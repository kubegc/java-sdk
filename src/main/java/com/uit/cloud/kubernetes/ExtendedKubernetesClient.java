/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import com.uit.cloud.kubernetes.api.model.DoneableVirtualMachine;
import com.uit.cloud.kubernetes.api.model.VirtualMachine;
import com.uit.cloud.kubernetes.api.model.VirtualMachineList;

import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.internal.KubernetesDeserializer;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/5/1
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class ExtendedKubernetesClient extends DefaultKubernetesClient {
	
	public final static Logger m_logger = Logger.getLogger(ExtendedKubernetesClient.class.getName());
	
	public final static String TOKEN    = "/etc/kubernetes/admin.conf";
	
	public final static String PACKAGE  = ExtendedKubernetesClient.class.getPackage().getName();
	
	public final static String SUBPKG   = ".api.model.";
	
	public final static Map<String, CustomResourceDefinition> crds = 
											new HashMap<String, CustomResourceDefinition>();
	
	protected void initCustomResources() throws Exception {
		for(File conf : getConfigs()) {
    		// it is not a configure
    		if (!conf.getName().endsWith("conf")) {
    			continue;
    		}
    		
    		// register to kubernetes
			Properties props = loadConfig(conf);
			registerToKubernetes(props);
			
    	}
	}


	public ExtendedKubernetesClient(Config config) throws Exception {
		super(config);
		initCustomResources();
	}

	/**
     * @param props
     * @throws Exception
     */
    protected void registerToKubernetes(Properties props) throws Exception {
    	String name    = props.getProperty("PLURAL")
				+ "." + props.getProperty("GROUP");
		String kind    = props.getProperty("KIND");
		String version = props.getProperty("GROUP") 
						+ "/" + props.getProperty("VERSION");
		
		CustomResourceDefinition customResourceDefinition = getCustomResourceDefinition(name);
		crds.put(kind, customResourceDefinition);
		KubernetesDeserializer.registerCustomKind(version, kind, 
									getCustomResourceClass(kind));
    }

	/**
	 * @param conf       file name
	 * @return           key and values
	 * @throws Exception the file does not exist
	 */
	protected Properties loadConfig(File conf) throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream(conf));
		return props;
	}


	/**
	 * @param kind       resource type
	 * @return           resource class if the class exist
	 * @throws Exception class not found
	 */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	protected Class<? extends KubernetesResource> getCustomResourceClass(String kind) 
																throws Exception {
		return (Class<? extends KubernetesResource>) 
							Class.forName(PACKAGE + SUBPKG + kind);
	}


	/**
	 * @param name       resource name
	 * @return           the related CustomResourceDefinition
	 */
	protected CustomResourceDefinition getCustomResourceDefinition(String name) {
		return this.customResourceDefinitions()
								.withName(name).get();
	}
  
    
    /**
     * @return this files located at 'src/main/resources'
     */
    protected File[] getConfigs() {
    	File res = new File(this.getClass()
    							.getClassLoader()
    							.getResource("")
    							.getFile());
    	return res.listFiles();
    }
    
    /**
     * @param watcher watcher
     */
    public void watchVirtualMachine(Watcher<VirtualMachine> watcher) {
    	this.customResources(crds.get("VirtualMachine"), 
    						VirtualMachine.class, 
    						VirtualMachineList.class, 
    						DoneableVirtualMachine.class)
    								.watch(watcher);
    }
    
    public static ExtendedKubernetesClient defaultConfig(String config) throws Exception {
    	return new ExtendedKubernetesClient(Serialization.unmarshal(config, Config.class));
    }
    
    public static ExtendedKubernetesClient defaultConfig(InputStream is) throws Exception {
        return new ExtendedKubernetesClient(Serialization.unmarshal(is, Config.class));
    }
    
}
