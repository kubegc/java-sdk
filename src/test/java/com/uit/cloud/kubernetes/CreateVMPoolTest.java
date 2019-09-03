/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinepool.Lifecycle;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/18
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class CreateVMPoolTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachinePools()
				.createPool("poolg", "vm.node30", getPool());
		System.out.println(successful);
	}

	protected static Lifecycle.CreatePool getPool() {
		Lifecycle.CreatePool createPool = new Lifecycle.CreatePool();
		createPool.setType("dir");
		createPool.setTarget("/var/lib/libvirt/poolg");
		return createPool;
	}
	
}
