/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.models.vms.VirtualMachineNetwork;
import io.github.kubestack.client.api.specs.vms.virtualmachinenetwork.Lifecycle.DeleteSwitch;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class AA_024_VMNetwork_DeleteAllTest {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		for (VirtualMachineNetwork vmn : client.virtualMachineNetworks().list()) {
			boolean successful = client.virtualMachineNetworks()
					.deleteSwitch(vmn.getMetadata().getName(), get());
			System.out.println(successful);
		}
	}

	protected static DeleteSwitch get() {
		DeleteSwitch deleteSwitch = new DeleteSwitch();
		return deleteSwitch;
	}
}
