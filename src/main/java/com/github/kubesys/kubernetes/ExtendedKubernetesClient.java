/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import com.github.kubesys.kubernetes.api.model.DoneableVirtualMachine;
import com.github.kubesys.kubernetes.api.model.VirtualMachine;
import com.github.kubesys.kubernetes.api.model.VirtualMachineList;

import io.fabric8.kubernetes.api.model.Doneable;
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.KubernetesResourceList;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.client.utils.Serialization;
import io.fabric8.kubernetes.internal.KubernetesDeserializer;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since 2019/5/1
 *
 *        This code is used to manage CustomResource's lifecycle, such as
 *        VirtualMachine
 */
public class ExtendedKubernetesClient extends DefaultKubernetesClient {

	public final static Logger m_logger = Logger.getLogger(ExtendedKubernetesClient.class.getName());

	public final static String TOKEN = "/etc/kubernetes/admin.conf";

	public final static String PACKAGE = ExtendedKubernetesClient.class.getPackage().getName();

	public final static String SUBPKG = ".api.model.";

	public final static Map<String, CustomResourceDefinition> crds = new HashMap<String, CustomResourceDefinition>();

	public final static Map<String, MixedOperation> executors = new HashMap<String, MixedOperation>();

	protected void initCustomResources() throws Exception {
//		for(File conf : getConfigs()) {
//    		// it is not a configure
//    		if (!conf.getName().endsWith("conf")) {
//    			continue;
//    		}
//    		
//    		
//			
//    	}
		// register to kubernetes
		Properties props =  new Properties();
		props.load(getClass()
				.getResourceAsStream("/VirtualMachine.conf"));
		registerToKubernetes(props);
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
		String name = props.getProperty("PLURAL") + "." + props.getProperty("GROUP");
		String kind = props.getProperty("KIND");
		String version = props.getProperty("GROUP") + "/" + props.getProperty("VERSION");

		CustomResourceDefinition crd = getCustomResourceDefinition(name);
		crds.put(kind, crd);
		KubernetesDeserializer.registerCustomKind(version, kind, getCustomResourceClass(kind));
		MixedOperation executor = (MixedOperation) customResources(crds.get(VirtualMachine.class.getSimpleName()),
				VirtualMachine.class, VirtualMachineList.class, DoneableVirtualMachine.class);
		executors.put(kind, executor);
	}

	/**
	 * @param conf file name
	 * @return key and values
	 * @throws Exception the file does not exist
	 */
	protected Properties loadConfig(File conf) throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream(conf));
		return props;
	}

	/**
	 * @param crd              crd
	 * @param resourceType     resource type
	 * @param resourceList     resource list
	 * @param doneableRespurce doneable resource
	 * @return custom resource
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected MixedOperation getCustomResource(CustomResourceDefinition crd, Class<? extends HasMetadata> resourceType,
			Class<? extends KubernetesResourceList> resourceList, Class<? extends Doneable> doneableRespurce) {
		return this.customResources(crd, resourceType, resourceList, doneableRespurce);
	}

	/**
	 * @param kind resource type
	 * @return resource class if the class exist
	 * @throws Exception class not found
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Class<? extends KubernetesResource> getCustomResourceClass(String kind) throws Exception {
		return (Class<? extends KubernetesResource>) Class.forName(PACKAGE + SUBPKG + kind);
	}

	/**
	 * @param name resource name
	 * @return the related CustomResourceDefinition
	 */
	protected CustomResourceDefinition getCustomResourceDefinition(String name) {
		return this.customResourceDefinitions().withName(name).get();
	}

	/**
	 * @return this files located at 'src/main/resources'
	 */
	protected File[] getConfigs() {
		File res = new File(this.getClass().getClassLoader().getResource("").getFile());
		return res.listFiles();
	}

	/**
	 * @param watcher watcher
	 */
	@SuppressWarnings("unchecked")
	public void watchVirtualMachine(Watcher<VirtualMachine> watcher) {
		executors.get(VirtualMachine.class.getSimpleName()).watch(watcher);
	}

	/**
	 * @param config config
	 * @return ExtendedKubernetesClient
	 * @throws Exception unable to init
	 */
	public static ExtendedKubernetesClient defaultConfig(String config) throws Exception {
		return new ExtendedKubernetesClient(Serialization.unmarshal(config, Config.class));
	}

	/**
	 * @param is file
	 * @return ExtendedKubernetesClient
	 * @throws Exception unable to init
	 */
	public static ExtendedKubernetesClient defaultConfig(InputStream is) throws Exception {
		return new ExtendedKubernetesClient(Serialization.unmarshal(is, Config.class));
	}

}
