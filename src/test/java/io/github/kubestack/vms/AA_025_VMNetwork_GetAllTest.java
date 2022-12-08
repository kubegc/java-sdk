/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.models.vms.VirtualMachineNetwork;


/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/15
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class AA_025_VMNetwork_GetAllTest {
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = io.github.kubestack.AbstractTest.getClient();
		for (VirtualMachineNetwork vmn : client.virtualMachineNetworks().list()) {
			System.out.println(vmn.getMetadata().getName() + ":" + vmn.getSpec().getData());
		}
	}
	
}
