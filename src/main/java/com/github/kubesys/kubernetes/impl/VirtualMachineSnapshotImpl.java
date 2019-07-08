/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import java.util.Map;

import com.github.kubesys.kubernetes.api.model.VirtualMachineSnapshot;
import com.github.kubesys.kubernetes.api.model.VirtualMachineSnapshotList;

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
	
	@SuppressWarnings("rawtypes")
	protected final MixedOperation excutor;
	
	protected String name;
	
	@SuppressWarnings("rawtypes")
	public VirtualMachineSnapshotImpl(MixedOperation excutor) {
		super();
		this.excutor = excutor;
	}

	/**
	 * return true or an exception
	 * 
	 * @param snapshot   VM's description
	 * @return true or an exception
	 * @throws Exception create VM fail
	 */
	@SuppressWarnings("unchecked")
	public boolean create(VirtualMachineSnapshot snapshot) throws Exception {
		excutor.create(snapshot);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public boolean update(VirtualMachineSnapshot snapshot) throws Exception {
		String name = snapshot.getMetadata().getName();
		VirtualMachineSnapshot vms = get(name);
		if (vms == null) {
			throw new Exception("Snapshot " + name + " does not exist.");
		}
		excutor.createOrReplace(snapshot);
		return true;
	}
	
	/**
	 * return an object or null
	 * 
	 * @param name it is .metadata.name
	 * @return object or null
	 */
	@SuppressWarnings("unchecked")
	public VirtualMachineSnapshot get(String name) {
		return ((Gettable<VirtualMachineSnapshot>) 
				excutor.withName(name)).get();
	}
	
	/**
	 * @return list virtual machines
	 */
	public VirtualMachineSnapshotList list() {
		return (VirtualMachineSnapshotList) excutor.list();
	}
	
	/**
	 * list all VMs with the specified labels 
	 * 
	 * @param filter see .metadata.labels
	 * @return all VMs
	 */
	public VirtualMachineSnapshotList list(Map<String, String> labels) {
		return (VirtualMachineSnapshotList)((FilterWatchListDeletable) 
				excutor.withLabels(labels)).list();
	}
}

