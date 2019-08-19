/*
  * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.UITStoragePoolSpec.Lifecycle.CreatePool;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/8/18
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class CreatePoolTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineUITPool()
				.createPool("pool1", "node31", get());
		System.out.println(successful);
	}
	
	public static CreatePool get() {
		CreatePool createPool = new CreatePool();
		createPool.setPoolType("localfs");
		createPool.setUrl("localfs:///dev/sdb:/pool2");
		return createPool;
	}
}