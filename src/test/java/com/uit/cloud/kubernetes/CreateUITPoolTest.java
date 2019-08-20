/*
  * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.UITStoragePoolSpec.Lifecycle.CreateUITPool;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/8/18
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class CreateUITPoolTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineUITPool()
				.createPool("test1", "node31", get());
		System.out.println(successful);
	}
	
	public static CreateUITPool get() {
		CreateUITPool createPool = new CreateUITPool();
		createPool.setPoolType("localfs");
		createPool.setUrl("localfs:///dev/sdb:/pool");
		return createPool;
	}
}
