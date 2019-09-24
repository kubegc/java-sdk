/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.SetPortVlan;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class DelPortVlanTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.setPortVlan("950646e8c17a49d0b83c1c797811e004", get());
		System.out.println(successful);
	}

	protected static SetPortVlan get() {
		SetPortVlan setPortVlan = new SetPortVlan();
		setPortVlan.setVlan("1");
		setPortVlan.setVmmac("52:54:00:03:c8:dc");
		return setPortVlan;
	}
}
