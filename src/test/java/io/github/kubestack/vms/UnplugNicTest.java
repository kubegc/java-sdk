/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachine.Lifecycle.UnplugNIC;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class UnplugNicTest {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.unplugNIC("cloudinit", get());
		System.out.println(successful);
	}
	
	public static UnplugNIC get() {
		UnplugNIC unplugNIC = new UnplugNIC();
		unplugNIC.setMac("52:54:00:73:16:2d");
		unplugNIC.setPersistent(true);
		unplugNIC.setLive(false);
		unplugNIC.setType("bridge");
//		unplugNIC.setConfig(true);
		return unplugNIC;
	}
}
