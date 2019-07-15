/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import java.util.Map;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.VirtualMachineDisk;
import com.github.kubesys.kubernetes.api.model.VirtualMachineDiskList;

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
public class VirtualMachineDiskImpl {
	
	@SuppressWarnings("rawtypes")
	protected final MixedOperation client = ExtendedKubernetesClient
				.crdClients.get(VirtualMachineDisk.class.getSimpleName());
	
	/**
	 * return true or an exception
	 * 
	 * @param disk   VM's description
	 * @return true or an exception
	 * @throws Exception create VM fail
	 */
	@SuppressWarnings("unchecked")
	public boolean create(VirtualMachineDisk disk) throws Exception {
		client.create(disk);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public boolean update(VirtualMachineDisk disk) throws Exception {
		String name = disk.getMetadata().getName();
		VirtualMachineDisk vmd = get(name);
		if (vmd == null) {
			throw new Exception("Disk " + name + " does not exist.");
		}
		client.createOrReplace(disk);
		return true;
	}
	
	/**
	 * return an object or null
	 * 
	 * @param name it is .metadata.name
	 * @return object or null
	 */
	@SuppressWarnings("unchecked")
	public VirtualMachineDisk get(String name) {
		return ((Gettable<VirtualMachineDisk>) 
				client.withName(name)).get();
	}
	
	/**
	 * @return list virtual machines
	 */
	public VirtualMachineDiskList list() {
		return (VirtualMachineDiskList) client.list();
	}
	
	/**
	 * list all VMs with the specified labels 
	 * 
	 * @param filter see .metadata.labels
	 * @return all VMs
	 */
	public VirtualMachineDiskList list(Map<String, String> labels) {
		return (VirtualMachineDiskList)((FilterWatchListDeletable) 
				client.withLabels(labels)).list();
	}

}