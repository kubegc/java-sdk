/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import com.github.kubesys.kubernetes.api.model.VirtualMachine;
import com.github.kubesys.kubernetes.api.model.VirtualMachineList;

import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author xuyuanjia2017@otcaix.iscas.ac.cn
 * @author xianghao16@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @since Thu Jun 13 21:39:55 CST 2019
 **/
public class VirtualMachineImpl {
	
	@SuppressWarnings("rawtypes")
	protected final MixedOperation excutor;
	
	protected String name;
	
	@SuppressWarnings("rawtypes")
	public VirtualMachineImpl(MixedOperation excutor) {
		super();
		this.excutor = excutor;
	}

	/**
	 * return true or an exception
	 * 
	 * @param vm   VM's description
	 * @return true or an exception
	 * @throws Exception create VM fail
	 */
	@SuppressWarnings("unchecked")
	public boolean create(VirtualMachine vm) throws Exception {
		excutor.create(vm);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public boolean update(VirtualMachine vm) throws Exception {
		String name = vm.getMetadata().getName();
		VirtualMachine vmn = get(name);
		if (vmn == null) {
			throw new Exception("VM named " + name + " does not exist.");
		}
		excutor.createOrReplace(vm);
		return true;
	}
	
	/**
	 * return an object or null
	 * 
	 * @param name it is .metadata.name
	 * @return object or null
	 */
	@SuppressWarnings("unchecked")
	public VirtualMachine get(String name) {
		return ((Gettable<VirtualMachine>) 
				excutor.withName(name)).get();
	}
	
	public VirtualMachineList list() {
		return (VirtualMachineList) excutor.list();
	}
}

