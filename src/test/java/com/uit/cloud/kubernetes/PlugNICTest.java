/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.PlugDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.PlugNIC;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/15
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class PlugNICTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.plugNIC("skywind5", getPlugNIC());
		System.out.println(successful);
	}
	
	public static PlugNIC getPlugNIC() {
		PlugNIC plugNIC = new PlugNIC();
		plugNIC.setType("bridge");
		plugNIC.setSource("virbr0");
		plugNIC.setLive(true);
		plugNIC.setConfig(true);
		return plugNIC;
	}
}
