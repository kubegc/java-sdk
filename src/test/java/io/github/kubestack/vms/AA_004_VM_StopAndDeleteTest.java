/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachine.Lifecycle.DeleteVM;
import io.github.kubestack.client.api.specs.vms.virtualmachine.Lifecycle.StopVM;


/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/15
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class AA_004_VM_StopAndDeleteTest {
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = io.github.kubestack.AbstractTest.getClient();
		boolean successful1 = client.virtualMachines()
				.stopVM("centos", new StopVM());
		System.out.println(successful1);
		boolean successful2 = client.virtualMachines()
				.deleteVM("centos", 
						new DeleteVM(), "123");
		System.out.println(successful2);
	}
	
}
