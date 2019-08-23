/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UnplugNIC;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/15
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class UnplugNICTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.unplugNIC("950646e8c17a49d0b83c1c797811e042", get());
		System.out.println(successful);
	}
	
	public static UnplugNIC get() {
		UnplugNIC unplugNIC = new UnplugNIC();

		unplugNIC.setType("bridge");
//		unplugNIC.setType("l2bridge");
//		unplugNIC.setType("l3bridge");
		unplugNIC.setMac("52:54:00:20:d0:81");
		unplugNIC.setLive(true);
		unplugNIC.setConfig(true);
		return unplugNIC;
	}
}
