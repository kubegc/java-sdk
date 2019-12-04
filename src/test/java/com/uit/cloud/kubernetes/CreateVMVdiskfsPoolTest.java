/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinepool.Lifecycle;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class CreateVMVdiskfsPoolTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachinePools()
				.createPool("node22dadad", "vm.node22", getPool(), "123");
		System.out.println(successful);
	}

	protected static Lifecycle.CreatePool getPool() {
		Lifecycle.CreatePool createPool = new Lifecycle.CreatePool();

		// uus
		createPool.setType("vdiskfs");
		createPool.setUrl("/mnt/localfs/pooldir1");
		createPool.setContent("vmd");
		return createPool;
	}
	
}
