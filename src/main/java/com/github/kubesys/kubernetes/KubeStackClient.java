/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes;


import java.io.File;
import java.util.logging.Logger;

import com.github.kubesys.kubernetes.impl.NodeSelectorImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachineDiskImageImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachineDiskImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachineDiskSnapshotImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachineImageImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachineImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachineNetworkImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachinePoolImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachineSnapshotImpl;

import io.github.kubesys.client.KubernetesAnalyzer;
import io.github.kubesys.client.KubernetesClient;
import io.github.kubesys.client.KubernetesWatcher;

/**
 * @author wuheng@iscas.ac.cn
 * 
 * @version 2.0.0
 * @since   2022/9/28
 *
 * <code>ExtendedKubernetesClient<code> extends <code>DefaultKubernetesClient<code>
 * to provide the lifecycle of 
 * VirtualMachine
 * VirtualMachinePool, VirtualMachineDisk,
 * VirtualMachineImage, VirtualMachineSnapshot, VirtualMachineNetwork
 * 
 */
public class KubeStackClient extends KubernetesClient {

	/**
	 * m_logger
	 */
	public final static Logger m_logger = Logger.getLogger(KubeStackClient.class.getName());

	
	public KubeStackClient() throws Exception {
		super();
	}

	public KubeStackClient(File file, KubernetesAnalyzer analyzer) throws Exception {
		super(file, analyzer);
	}

	public KubeStackClient(File file) throws Exception {
		super(file);
	}

	public KubeStackClient(String url, String token, KubernetesAnalyzer analyzer) throws Exception {
		super(url, token, analyzer);
	}

	public KubeStackClient(String url, String token) throws Exception {
		super(url, token);
	}
	
	
	public static String GROUP = "doslab.io"; 
	
	public static String KIND_VIRTUALMACHINE = GROUP + ".VirtualMachine";
	
	public static String KIND_VIRTUALMACHINE_DISK = GROUP + ".VirtualMachineDisk";
	
	public static String KIND_VIRTUALMACHINE_DISKIMAGE = GROUP + ".VirtualMachineDiskImage";
	
	public static String KIND_VIRTUALMACHINE_DISKSNAPSHOT = GROUP + ".VirtualMachineDiskSnapshot";
	
	public static String KIND_VIRTUALMACHINE_IMAGE = GROUP + ".VirtualMachineImage";
	
	public static String KIND_VIRTUALMACHINE_NETWORK = GROUP + ".VirtualMachineNetwork";
	
	public static String KIND_VIRTUALMACHINE_POOL = GROUP + ".VirtualMachinePool";

	public static String KIND_VIRTUALMACHINE_SNAPSHOT = GROUP + ".VirtualMachineSnapshot";
	
	/**
	 * @return        VirtualMachines
	 */
	public VirtualMachineImpl virtualMachines() {
		return new VirtualMachineImpl();
	}
	
	/**
	 * @return        VirtualMachines 
	 * @throws Exception 
	 */
	public void watchVirtualMachines(KubernetesWatcher watcher) throws Exception {
		this.watchResources(KIND_VIRTUALMACHINE, watcher);
	}
	
	
	/**
	 * @return        VirtualMachineDisks
	 */
	public VirtualMachineDiskImpl virtualMachineDisks() {
		return new VirtualMachineDiskImpl();
	}

	
	/**
	 * @return        VirtualMachineDisks
	 * @throws Exception 
	 */
	public void watchVirtualMachineDisks(KubernetesWatcher watcher) throws Exception {
		this.watchResources(KIND_VIRTUALMACHINE_DISK, watcher);
	}
	
	
	/**
	 * @return        VirtualMachineDiskImages
	 */
	public VirtualMachineDiskImageImpl virtualMachineDiskImages() {
		return new VirtualMachineDiskImageImpl();
	}
	
	/**
	 * @return        VirtualMachineDiskImages
	 * @throws Exception 
	 */
	public void watchVirtualMachineDiskImages(KubernetesWatcher watcher) throws Exception {
		this.watchResources(KIND_VIRTUALMACHINE_DISKIMAGE, watcher);
	}
	
	/**
	 * @return        VirtualMachineDiskSnapshots
	 */
	public VirtualMachineDiskSnapshotImpl virtualMachineDiskSnapshots() {
		return new VirtualMachineDiskSnapshotImpl();
	}
	
	/**
	 * @return        VirtualMachineDiskSnapshots
	 * @throws Exception 
	 */
	public void watchVirtualMachineDiskSnapshots(KubernetesWatcher watcher) throws Exception {
		this.watchResources(KIND_VIRTUALMACHINE_DISKSNAPSHOT, watcher);
	}	
	
	/**
	 * @return        VirtualMachineImages
	 */
	public VirtualMachineImageImpl virtualMachineImages() {
		return new VirtualMachineImageImpl();
	}
	
	/**
	 * @return        VirtualMachineImages
	 * @throws Exception 
	 */
	public void watchVirtualMachineImages(KubernetesWatcher watcher) throws Exception {
		this.watchResources(KIND_VIRTUALMACHINE_IMAGE, watcher);
	}
	
	/**
	 * @return        VirtualMachineNetworks
	 */
	public VirtualMachineNetworkImpl virtualMachineNetworks() {
		return new VirtualMachineNetworkImpl();
	}
	
	/**
	 * @return        VirtualMachineNetworks
	 * @throws Exception 
	 */
	public void watchVirtualMachineNetworks(KubernetesWatcher watcher) throws Exception {
		this.watchResources(KIND_VIRTUALMACHINE_NETWORK, watcher);
	}
	
	
	
	/**
	 * @return        VirtualMachinePools
	 */
	public VirtualMachinePoolImpl virtualMachinePools() {
		return new VirtualMachinePoolImpl();
	}
	
	/**
	 * @return        VirtualMachinePools
	 * @throws Exception 
	 */
	public void watchVirtualMachinePools(KubernetesWatcher watcher) throws Exception {
		this.watchResources(KIND_VIRTUALMACHINE_POOL, watcher);
	}
	
	/**
	 * @return        VirtualMachineSnapshots
	 */
	public VirtualMachineSnapshotImpl virtualMachineSnapshots() {
		return new VirtualMachineSnapshotImpl();
	}
	
	/**
	 * @return        VirtualMachineSnapshots
	 * @throws Exception 
	 */
	public void watchVirtualMachineSnapshots(KubernetesWatcher watcher) throws Exception {
		this.watchResources(KIND_VIRTUALMACHINE_SNAPSHOT, watcher);
	}
	
	/**
	 * @return NodeSelector
	 */
	public NodeSelectorImpl getNodeSelector() {
		return new NodeSelectorImpl(this);
	}
	
	/**
	 * the same as  'virtualMachines'
	 * 
	 * @return                    virtualMachines
	 */
	public VirtualMachineImpl getVirtualMachineImpl() {
		return virtualMachines();
	}
	
	/**
	 * the same as  'virtualMachineDisks'
	 * 
	 * @return                    virtualMachineDisks
	 */
	public VirtualMachineDiskImpl getVirtualMachineDiskImpl() {
		return virtualMachineDisks();
	}
	
	/**
	 * the same as  'virtualMachineDiskSnapshots'
	 * 
	 * @return                    virtualMachineDiskSnapshots
	 */
	public VirtualMachineDiskSnapshotImpl getVirtualMachineDiskSnapshotImpl() {
		return virtualMachineDiskSnapshots();
	}
	
	/**
	 * the same as  'virtualMachineImages'
	 * 
	 * @return                    virtualMachineImages
	 */
	public VirtualMachineImageImpl getVirtualMachineImageImpl() {
		return virtualMachineImages();
	}
	
	/**
	 * the same as  'virtualMachineSnapshots'
	 * 
	 * @return                    virtualMachineSnapshots
	 */
	public VirtualMachineSnapshotImpl getVirtualMachineSnapshotImpl() {
		return virtualMachineSnapshots();
	}
	
	/**
	 * the same as  'virtualMachinePools'
	 * 
	 * @return                    virtualMachinePools
	 */
	public VirtualMachinePoolImpl getVirtualMachinePoolImpl() {
		return virtualMachinePools();
	}
	
	/**
	 * the same as  'virtualMachineDiskImages'
	 * 
	 * @return                    virtualMachineDiskImages
	 */
	public VirtualMachineDiskImageImpl getVirtualMachineDiskImageImpl() {
		return virtualMachineDiskImages();
	}
	
	/**
	 * the same as  'virtualMachineNetworks'
	 * 
	 * @return                    virtualMachineNetworks
	 */
	public VirtualMachineNetworkImpl getVirtualMachineNetworkImpl() {
		return virtualMachineNetworks();
	}

}
