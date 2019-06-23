/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import com.alibaba.fastjson.JSON;
import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.DoneableVirtualMachine;
import com.github.kubesys.kubernetes.api.model.VirtualMachine;
import com.github.kubesys.kubernetes.api.model.VirtualMachineList;

import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinition;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionBuilder;
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
	
	@SuppressWarnings("rawtypes")
	public VirtualMachineImpl(MixedOperation excutor) {
		super();
		this.excutor = excutor;
	}

	@SuppressWarnings("unchecked")
	public boolean create(VirtualMachine vm) {
		try {
			excutor.create(vm);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(VirtualMachine vm) {
		return false;
	}
	
	public VirtualMachineImpl withName(String name) {
		return this;
	}
	
	public VirtualMachine get() {
		return null;
	}
}

