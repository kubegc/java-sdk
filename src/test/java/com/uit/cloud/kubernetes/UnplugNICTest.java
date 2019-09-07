/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UnplugNIC;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class UnplugNICTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.unplugNIC("150646e8c17a49d0b83c1c797811e045", get());
		System.out.println(successful);
	}
	
	public static UnplugNIC get() {
		UnplugNIC unplugNIC = new UnplugNIC();
		// Libvirt default bridge
		unplugNIC.setType("bridge");
		// Ovs layer2 bridge
//		unplugNIC.setType("l2bridge");
		// Ovs layer3 bridge
//		unplugNIC.setType("l3bridge");
		unplugNIC.setMac("52:54:00:53:a1:51");
//		unplugNIC.setLive(true);
		unplugNIC.setConfig(true);
		return unplugNIC;
	}
}