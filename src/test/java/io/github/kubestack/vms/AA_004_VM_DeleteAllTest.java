/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.models.vms.VirtualMachine;
import io.github.kubestack.client.api.specs.vms.virtualmachine.Lifecycle.DeleteVM;


/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/15
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class AA_004_VM_DeleteAllTest {
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = io.github.kubestack.AbstractTest.getClient();
		for (VirtualMachine vm : client.virtualMachines().list()) {
			boolean successful = client.virtualMachines()
					.deleteVM(vm.getMetadata().getName(), 
							new DeleteVM(), "123");
			System.out.println(successful);
		}
	}
	
}
