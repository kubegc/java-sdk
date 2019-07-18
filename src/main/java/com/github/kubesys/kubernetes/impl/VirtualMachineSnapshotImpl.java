/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.VirtualMachineDiskList;
import com.github.kubesys.kubernetes.api.model.VirtualMachineSnapshot;
import com.github.kubesys.kubernetes.api.model.VirtualMachineSnapshotList;
import com.github.kubesys.kubernetes.api.model.VirtualMachineSnapshotSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Lifecycle.CreateSnapshot;
import com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Lifecycle.DeleteSnapshot;

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeletable;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author xuyuanjia2017@otcaix.iscas.ac.cn
 * @author xianghao16@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @since Thu Jun 13 21:39:55 CST 2019
 **/
public class VirtualMachineSnapshotImpl {
	
	/**
	 * m_logger
	 */
	protected final static Logger m_logger = Logger.getLogger(VirtualMachineSnapshotImpl.class.getName());
	
	/**
	 * client
	 */
	@SuppressWarnings("rawtypes")
	protected final MixedOperation client = ExtendedKubernetesClient
				.crdClients.get(VirtualMachineSnapshot.class.getSimpleName());
	
	/**
	 * support commands
	 */
	public static List<String> cmds = new ArrayList<String>();
	
	static {
		cmds.add("createSnapshot ");
		cmds.add("deleteSnapshot ");
	}
	
	/*************************************************
	 * 
	 *                   Core 
	 * 
	 **************************************************/
	
	/**
	 * return true or an exception
	 * 
	 * @param snapshot     VM snapshot description
	 * @return             true or an exception
	 * @throws Exception   create VM disk fail
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	public boolean create(VirtualMachineSnapshot snapshot) throws Exception {
		client.create(snapshot);
		m_logger.log(Level.INFO, "create VirtualMachineSnapshot " 
				+ snapshot.getMetadata().getName() + " successful.") ;
		return true;
	}
	
	/**
	 * @param snapshot      VM snapshot description
	 * @return              true or an exception
	 * @throws Exception    delete VM disk fail
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	public boolean delete(VirtualMachineSnapshot snapshot) throws Exception {
		client.delete(snapshot);
		m_logger.log(Level.INFO, "delete VirtualMachineSnapshot " 
				+ snapshot.getMetadata().getName() + " successful.") ;
		return true;
	}
	
	/**
	 * @param snapshot      VM snapshot description
	 * @return              true or an exception
	 * @throws Exception    update VM disk fail
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	public boolean update(VirtualMachineSnapshot snapshot) throws Exception {
		client.createOrReplace(snapshot);
		m_logger.log(Level.INFO, "update VirtualMachineSnapshot " 
				+ snapshot.getMetadata().getName() + " successful.") ;
		return true;
	}
	
	/**
	 * @param operator      operator
	 * @param snapshot      VM snapshot description
	 * @return              true or an exception
	 * @throws Exception    update VM disk fail
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	protected boolean update(String operator, VirtualMachineSnapshot snapshot) throws Exception {
		client.createOrReplace(snapshot);
		m_logger.log(Level.INFO, operator + " " + 
				snapshot.getMetadata().getName() + " successful.") ;
		return true;
	}
	
	/**
	 * return an object or null
	 * 
	 * @param name     .metadata.name
	 * @return         object or null
	 */
	@SuppressWarnings("unchecked")
	public VirtualMachineSnapshot get(String name) {
		return ((Gettable<VirtualMachineSnapshot>) 
				client.withName(name)).get();
	}
	
	/**
	 * @return list all virtual machine snapshots or null
	 */
	public VirtualMachineSnapshotList list() {
		return (VirtualMachineSnapshotList) client.list();
	}
	
	/**
	 * list all VM disks with the specified labels 
	 * 
	 * @param filter    .metadata.labels
	 * @return          all VM snapshots or null
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public VirtualMachineDiskList list(Map<String, String> labels) {
		return (VirtualMachineDiskList)((FilterWatchListDeletable) 
				client.withLabels(labels)).list();
	}
	
	
	/*************************************************
	 * 
	 *                   Generated
	 * 
	 **************************************************/
	
	public boolean createSnapshot (String name, CreateSnapshot  createSnapshot ) throws Exception {
		return createSnapshot(name, null, createSnapshot);
	}
	
	public boolean createSnapshot (String name, String nodeName, CreateSnapshot  createSnapshot ) throws Exception {
		VirtualMachineSnapshot kind = new VirtualMachineSnapshot();
		kind.setApiVersion("cloudplus.io/v1alpha3");
		kind.setKind("VirtualMachineSnapshot");
		VirtualMachineSnapshotSpec spec = new VirtualMachineSnapshotSpec();
		if (nodeName != null) {
			spec.setNodeName(nodeName);
		}
		ObjectMeta om = new ObjectMeta();
		om.setName(name);
		kind.setMetadata(om);
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setCreateSnapshot (createSnapshot );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		create(kind );
		return true;
	}


	public boolean deleteSnapshot (String name, DeleteSnapshot  deleteSnapshot ) throws Exception {
		VirtualMachineSnapshot kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			delete(kind);
		}
		VirtualMachineSnapshotSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setDeleteSnapshot (deleteSnapshot );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		delete(kind );
		return true;
	}

}

