/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.kubesys.kubernetes.api.model.UITDisk;
import com.github.kubesys.kubernetes.api.model.UITSnapshot;
import com.github.kubesys.kubernetes.api.model.UITStoragePool;
import com.github.kubesys.kubernetes.api.model.VirtualMachine;
import com.github.kubesys.kubernetes.api.model.VirtualMachineDisk;
import com.github.kubesys.kubernetes.api.model.VirtualMachineImage;
import com.github.kubesys.kubernetes.api.model.VirtualMachineSnapshot;
import com.github.kubesys.kubernetes.api.model.UITDisk;
import com.github.kubesys.kubernetes.api.model.UITStoragePool;
import com.github.kubesys.kubernetes.api.model.UITSnapshot;
import com.github.kubesys.kubernetes.impl.NodeSelectorImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachineDiskImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachineImageImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachineImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachineSnapshotImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachineUITDiskImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachineUITPoolImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachineUITSnapshotImpl;

import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.client.CustomResourceDoneable;
import io.fabric8.kubernetes.client.CustomResourceList;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.Watcher;
import io.fabric8.kubernetes.client.dsl.MixedOperation;
import io.fabric8.kubernetes.internal.KubernetesDeserializer;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since 2019/7/15
 *
 */
public class ExtendedKubernetesClient extends DefaultKubernetesClient {

	/**
	 * logger
	 */
	public final static Logger m_logger = Logger.getLogger(ExtendedKubernetesClient.class.getName());

	/**
	 * root package
	 */
	public final static String ROOT_PKG = ExtendedKubernetesClient.class.getPackage().getName();

	/**
	 * sub-package
	 */
	public final static String SUB_PKG = ".api.model.";

	/**
	 * all watchers
	 */
	@SuppressWarnings("rawtypes")
	public final static Map<String, MixedOperation> crdClients = new HashMap<String, MixedOperation>();

	/**
	 * all configurations
	 */
	public final static List<String> configs = new ArrayList<String>();
	
	static {
		configs.add("/VirtualMachine.conf");
		configs.add("/VirtualMachineImage.conf");
		configs.add("/VirtualMachineDisk.conf");
		configs.add("/VirtualMachineSnapshot.conf");
		configs.add("/VirtualMachineUITPool.conf");
		configs.add("/VirtualMachineUITDisk.conf");
		configs.add("/VirtualMachineUITSnapshot.conf");
	}
	
	/**
	 * @param config     the configuration contains token, 
	 */
	public ExtendedKubernetesClient(Config config)  {
		super(config);
		initKube();
	}

	/**
	 * extend Kubernetes to support custom resources
	 */
	protected void initKube() {
		for (String configFile : configs) {
			try {
				Properties props = loadConfigFile(configFile);
				registerCrdToKube(props);
				registerCrdClients(props);
			} catch (Exception e) {
				m_logger.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	/**
	 * @param configFile           file 
	 * @return                     properties
	 * @throws Exception           if the file not exist
	 */
	protected Properties loadConfigFile(String configFile) throws Exception {
		Properties props =  new Properties();
		props.load(getClass().getResourceAsStream(configFile));
		return props;
	}
	
	/**
	 * @param props            props
	 * @throws Exception       if the customResource is not found.
	 */
	protected void registerCrdToKube(Properties props) throws Exception {
		String kind = props.getProperty("KIND");
		registerCustomResource(kind, props);
		m_logger.log(Level.INFO, "register CustomResource [" + kind + "] successful.");
	}

	/**
	 * @param kind               kind
	 * @param props              properties
	 * @throws Exception         if the class in the properties cannot be loaded
	 */
	protected void registerCustomResource(String kind, Properties props) throws Exception {
		KubernetesDeserializer.registerCustomKind(
				props.getProperty("GROUP") + "/" + props.getProperty("VERSION"), 
				kind, Class.forName(ROOT_PKG + SUB_PKG + kind).asSubclass(KubernetesResource.class));
	}
	/**
	 * @param props             props
	 * @throws Exception        if the customResource is not found.
	 */
	protected void registerCrdClients(Properties props) throws Exception {
		String kind = props.getProperty("KIND");
		CustomResourceDefinition crd = getCustomResourceDefinition(
				props.getProperty("PLURAL") + "." + props.getProperty("GROUP"));
		if (crd == null) {
			throw new Exception("cannot find CustomResourceDefinition [" + kind + "]");
		}
		crdClients.put(kind, getCrdClient(kind, crd));
		m_logger.log(Level.INFO, "register crdClient [" + kind + "] successful.");
	}

	/**
	 * @param name               name
	 * @return                   customResourceDefinitions
	 */
	public CustomResourceDefinition getCustomResourceDefinition(String name) {
		return this.customResourceDefinitions().withName(name).get();
	}

	
	/**
	 * @param kind                 kind
	 * @param crd                  CustomeResourceDefinition
	 * @return                     CRDClient
	 * @throws Exception           if the customResource is not found.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected MixedOperation getCrdClient(String kind, CustomResourceDefinition crd) throws Exception {
		return (MixedOperation) customResources(crd,
				Class.forName(ROOT_PKG + SUB_PKG + kind).asSubclass(CustomResource.class), 
				Class.forName(ROOT_PKG + SUB_PKG + kind + "List").asSubclass(CustomResourceList.class), 
				Class.forName(ROOT_PKG + SUB_PKG + "Doneable" + kind).asSubclass(CustomResourceDoneable.class))
					.inNamespace("default");
	}

	/**
	 * @return        VirtualMachine 
	 */
	public VirtualMachineImpl virtualMachines() {
		return new VirtualMachineImpl();
	}
	
	/**
	 * @return        VirtualMachineImage
	 */
	public VirtualMachineImageImpl virtualMachineImages() {
		return new VirtualMachineImageImpl();
	}
	
	/**
	 * @return        VirtualMachineDisk
	 */
	public VirtualMachineDiskImpl virtualMachineDisks() {
		return new VirtualMachineDiskImpl();
	}
	
	
	/**
	 * @return        VirtualMachineUITPool
	 */
	public VirtualMachineUITPoolImpl virtualMachineUITPool() {
		return new VirtualMachineUITPoolImpl();
	}
	
	/**
	 * @return        VirtualMachineUITDisk
	 */
	public VirtualMachineUITDiskImpl virtualMachineUITDisk() {
		return new VirtualMachineUITDiskImpl();
	}
	
	/**
	 * @return        VirtualMachineUITDisk
	 */
	public VirtualMachineUITSnapshotImpl virtualMachineUITSnapshot() {
		return new VirtualMachineUITSnapshotImpl();
	}
	
	/**
	 * @return        VirtualMachineSnapshot
	 */
	public VirtualMachineSnapshotImpl virtualMachineSanshots() {
		return new VirtualMachineSnapshotImpl();
	}
	
	/**
	 * @return        VirtualMachine 
	 */
	@SuppressWarnings("unchecked")
	public void watchVirtualMachines(Watcher<VirtualMachine> watcher) {
		crdClients.get(VirtualMachine.class.getSimpleName()).watch(watcher);
	}
	
	/**
	 * @return        VirtualMachineImage
	 */
	@SuppressWarnings("unchecked")
	public void watchVirtualMachineImages(Watcher<VirtualMachineImage> watcher) {
		crdClients.get(VirtualMachineImage.class.getSimpleName()).watch(watcher);
	}
	
	/**
	 * @return        VirtualMachineDisk
	 */
	@SuppressWarnings("unchecked")
	public void watchVirtualMachineDisks(Watcher<VirtualMachineDisk> watcher) {
		crdClients.get(VirtualMachineDisk.class.getSimpleName()).watch(watcher);
	}
	
	/**
	 * @return        VirtualMachineSnapshot
	 */
	@SuppressWarnings("unchecked")
	public void watchVirtualMachineSnapshots(Watcher<VirtualMachineSnapshot> watcher) {
		crdClients.get(VirtualMachineSnapshot.class.getSimpleName()).watch(watcher);
	}
	
	/**
	 * @return        VirtualMachineUITPool
	 */
	@SuppressWarnings("unchecked")
	public void watchVirtualMachineUITPools(Watcher<UITStoragePool> watcher) {
		crdClients.get(UITStoragePool.class.getSimpleName()).watch(watcher);
	}
	
	/**
	 * @return        VirtualMachineUITDisk
	 */
	@SuppressWarnings("unchecked")
	public void watchVirtualMachineUITDisks(Watcher<UITDisk> watcher) {
		crdClients.get(UITDisk.class.getSimpleName()).watch(watcher);
	}
	
	/**
	 * @return        VirtualMachineUITSnapshot
	 */
	@SuppressWarnings("unchecked")
	public void watchVirtualMachineSnapshorts(Watcher<UITSnapshot> watcher) {
		crdClients.get(UITSnapshot.class.getSimpleName()).watch(watcher);
	}
	
	/**
	 * @return NodeSelector
	 */
	public NodeSelectorImpl getNodeSelector() {
		return new NodeSelectorImpl(this);
	}

}
