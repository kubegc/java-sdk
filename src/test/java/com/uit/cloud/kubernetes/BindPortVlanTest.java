/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinenetwork.Lifecycle.BindPortVlan;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class BindPortVlanTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineNetworks()
				.bindPortVlan("bridge1", get());
		System.out.println(successful);
	}

	protected static BindPortVlan get() {
		BindPortVlan bindPortVlan = new BindPortVlan();
		bindPortVlan.setVlan("2");
		bindPortVlan.setMac("52:54:00:79:c3:47");
		bindPortVlan.setDomain("950646e8c17a49d0b83c1c797811e004");
		return bindPortVlan;
	}
}
