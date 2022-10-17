/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;


import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.virtualmachine.Lifecycle.DeprecatedACL;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class DeleteDeprcatedACLsTest {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.deprecatedACL("cloudinit1", get());
		System.out.println(successful);
	}
	
	public static DeprecatedACL get() {
		DeprecatedACL a1 = new DeprecatedACL();
		a1.setSwName("aaa1");
		a1.setVmmac("52:54:00:fd:67:3b");
		return a1;
	}
}
