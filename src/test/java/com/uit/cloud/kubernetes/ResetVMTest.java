/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ResetVM;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/25
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class ResetVMTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.resetVM("t1", new ResetVM());
		System.out.println(successful);
	}
	
}
