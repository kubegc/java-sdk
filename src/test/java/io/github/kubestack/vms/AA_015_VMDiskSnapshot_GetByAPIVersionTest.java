/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.models.vms.VirtualMachineDiskSnapshot;


/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/15
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class AA_015_VMDiskSnapshot_GetByAPIVersionTest {
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = io.github.kubestack.AbstractTest.getClient();
		for (VirtualMachineDiskSnapshot vmdsn : client.virtualMachineDiskSnapshots().list()) {
			System.out.println(vmdsn.getApiVersion());
		}
	}
	
}
