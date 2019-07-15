/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import java.util.Map;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.VirtualMachineDisk;
import com.github.kubesys.kubernetes.api.model.VirtualMachineImage;
import com.github.kubesys.kubernetes.api.model.VirtualMachineImageList;

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
public class VirtualMachineImageImpl {
	
	@SuppressWarnings("rawtypes")
	protected final MixedOperation client = ExtendedKubernetesClient
			.crdClients.get(VirtualMachineImage.class.getSimpleName());
	
	/**
	 * return true or an exception
	 * 
	 * @param image   VM's description
	 * @return true or an exception
	 * @throws Exception create VM fail
	 */
	@SuppressWarnings("unchecked")
	public boolean create(VirtualMachineImage image) throws Exception {
		client.create(image);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public boolean update(VirtualMachineImage image) throws Exception {
		String name = image.getMetadata().getName();
		VirtualMachineImage vmi = get(name);
		if (vmi == null) {
			throw new Exception("Image " + name + " does not exist.");
		}
		client.createOrReplace(image);
		return true;
	}
	
	/**
	 * return an object or null
	 * 
	 * @param name it is .metadata.name
	 * @return object or null
	 */
	@SuppressWarnings("unchecked")
	public VirtualMachineImage get(String name) {
		return ((Gettable<VirtualMachineImage>) 
				client.withName(name)).get();
	}
	
	/**
	 * @return list virtual machines
	 */
	public VirtualMachineImageList list() {
		return (VirtualMachineImageList) client.list();
	}
	
	/**
	 * list all VMs with the specified labels 
	 * 
	 * @param filter see .metadata.labels
	 * @return all VMs
	 */
	public VirtualMachineImageList list(Map<String, String> labels) {
		return (VirtualMachineImageList)((FilterWatchListDeletable) 
				client.withLabels(labels)).list();
	}
}

