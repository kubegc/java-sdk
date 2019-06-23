/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.VirtualMachine;

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
	
	protected final ExtendedKubernetesClient client;
	
	public VirtualMachineImpl(ExtendedKubernetesClient client) {
		super();
		this.client = client;
	}

	public boolean create(VirtualMachine vm) {
		CustomResourceDefinition  crd = new CustomResourceDefinitionBuilder()
					.withKind(vm.getApiVersion())
					.withKind(vm.getKind())
					.withMetadata(vm.getMetadata())
					.withSpec(vm.getSpec())
					.build();
		try {
			client.customResourceDefinitions().create(crd);
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

