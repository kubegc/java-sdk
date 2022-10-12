/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.virtualmachine.Lifecycle.DeleteVM;


/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/15
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class DeleteVMTest {
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = io.github.kubestack.vms.AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.deleteVM("centos", 
						new DeleteVM(), "123");
		System.out.println(successful);
	}
	
}
