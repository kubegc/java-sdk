/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.KubeStackClient;
import com.github.kubesys.kubernetes.api.specs.items.virtualmachinenetwork.Lifecycle.DeleteSwitch;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class DeleteSwitchTest {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineNetworks()
				.deleteSwitch("switch2", get());
		System.out.println(successful);
	}

	protected static DeleteSwitch get() {
		DeleteSwitch deleteSwitch = new DeleteSwitch();
		return deleteSwitch;
	}
}
