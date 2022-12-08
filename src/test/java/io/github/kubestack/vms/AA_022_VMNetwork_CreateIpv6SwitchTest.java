/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachinenetwork.Lifecycle.CreateBridge;
import io.github.kubestack.client.api.specs.vms.virtualmachinenetwork.Lifecycle.CreateSwitch;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class AA_022_VMNetwork_CreateIpv6SwitchTest {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineNetworks()
				.createSwitch("switch22", "vm.node22", getIpv6());
		System.out.println(successful);
	}
	
	protected static CreateSwitch getIpv6() {
		CreateSwitch vxlan = new CreateSwitch();
		vxlan.setSubnet("2001:198:10::/64");
		vxlan.setMtu("1450");
		vxlan.setGateway("2001:1::1");
		vxlan.setBridge("br-ex");
		vxlan.setVlanId("20");
		vxlan.setDhcp("2001:1::1");
		vxlan.setIpv6("true");
		return vxlan;
	}
}
