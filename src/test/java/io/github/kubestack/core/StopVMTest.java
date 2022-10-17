/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.core;

import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.virtualmachine.Lifecycle.StopVMForce;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/8/1
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class StopVMTest {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = io.github.kubestack.AbstractTest.getClient();
		System.out.println(client.virtualMachines().stopVMForce(
				"650646e8c17a49d0b83c1c797811e081", new StopVMForce(), "eventid-stop"));
	}
	
	
}
