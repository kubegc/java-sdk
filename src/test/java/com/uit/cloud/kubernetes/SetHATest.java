/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ResetVM;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/8/7
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class SetHATest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.setHA("test");
		// unsetHA
		System.out.println(successful);
	}
	
}
