/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.client;


import java.io.File;
import java.util.logging.Logger;

import io.github.kubestack.client.api.models.Node;
import io.github.kubestack.client.api.models.VirtualMachine;
import io.github.kubestack.client.api.models.VirtualMachineDisk;
import io.github.kubestack.client.api.models.VirtualMachineDiskImage;
import io.github.kubestack.client.api.models.VirtualMachineDiskSnapshot;
import io.github.kubestack.client.api.models.VirtualMachineImage;
import io.github.kubestack.client.api.models.VirtualMachineNetwork;
import io.github.kubestack.client.api.models.VirtualMachinePool;
import io.github.kubestack.client.api.models.VirtualMachineSnapshot;
import io.github.kubestack.client.impl.NodeImpl;
import io.github.kubestack.client.impl.VirtualMachineDiskImageImpl;
import io.github.kubestack.client.impl.VirtualMachineDiskImpl;
import io.github.kubestack.client.impl.VirtualMachineDiskSnapshotImpl;
import io.github.kubestack.client.impl.VirtualMachineImageImpl;
import io.github.kubestack.client.impl.VirtualMachineImpl;
import io.github.kubestack.client.impl.VirtualMachineNetworkImpl;
import io.github.kubestack.client.impl.VirtualMachinePoolImpl;
import io.github.kubestack.client.impl.VirtualMachineSnapshotImpl;
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
		return new VirtualMachineImpl(this, VirtualMachine.class.getSimpleName());
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
		return new VirtualMachineDiskImpl(this, VirtualMachineDisk.class.getSimpleName());
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
		return new VirtualMachineDiskImageImpl(this, VirtualMachineDiskImage.class.getSimpleName());
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
		return new VirtualMachineDiskSnapshotImpl(this, VirtualMachineDiskSnapshot.class.getSimpleName());
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
		return new VirtualMachineImageImpl(this, VirtualMachineImage.class.getSimpleName());
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
		return new VirtualMachineNetworkImpl(this, VirtualMachineNetwork.class.getSimpleName());
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
		return new VirtualMachinePoolImpl(this, VirtualMachinePool.class.getSimpleName());
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
		return new VirtualMachineSnapshotImpl(this, VirtualMachineSnapshot.class.getSimpleName());
	}
	
	/**
	 * @return        VirtualMachineSnapshots
	 * @throws Exception 
	 */
	public void watchVirtualMachineSnapshots(KubernetesWatcher watcher) throws Exception {
		this.watchResources(KIND_VIRTUALMACHINE_SNAPSHOT, watcher);
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
	
	//--------------------------------------------------------
	
	/**
	 * @return        VirtualMachines
	 */
	public NodeImpl nodes() {
		return new NodeImpl(this, Node.class.getSimpleName());
	}

	/**
	 * @return        VirtualMachinePools
	 * @throws Exception 
	 */
	public void watchNodes(KubernetesWatcher watcher) throws Exception {
		this.watchResources(Node.class.getSimpleName(), watcher);
	}
	
	/**
	 * the same as  'virtualMachineNetworks'
	 * 
	 * @return                    virtualMachineNetworks
	 */
	public NodeImpl getNodeImpl() {
		return nodes();
	}
}
