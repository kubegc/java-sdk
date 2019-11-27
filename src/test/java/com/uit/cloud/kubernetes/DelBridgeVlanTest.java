/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinenetwork.Lifecycle.DelBridgeVlan;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class DelBridgeVlanTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineNetworks()
				.delBridgeVlan("br-native", get());
		System.out.println(successful);
	}

	protected static DelBridgeVlan get() {
		DelBridgeVlan delBridgeVlan = new DelBridgeVlan();
		delBridgeVlan.setVlan("1");
		delBridgeVlan.setName("wyw1");
		return delBridgeVlan;
	}
}
