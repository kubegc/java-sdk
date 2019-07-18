/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StartVM;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/15
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class StartVMTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.startVM("skywind2", new StartVM());
		System.out.println(successful);
	}
	
}
