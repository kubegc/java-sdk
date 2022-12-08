/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachinenetwork.Lifecycle.ModifySwitch;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class AA_023_VMNetwork_ModifyMtuTest {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineNetworks()
				.modifySwitch("switch22", get());
		System.out.println(successful);
	}

	protected static ModifySwitch get() {
		ModifySwitch vxlan = new ModifySwitch();
		vxlan.setMtu("1450");
		vxlan.setGateway("192.168.2.1");
		vxlan.setVlanId("20");
		vxlan.setDhcp("192.168.2.1");
		vxlan.setIpv6("false");
		return vxlan;
	}
}
