/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.SetVncPassword;


/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class SetVncPasswordTest {
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.setVncPassword("vm003", get(), "1123");
		System.out.println(successful);
	}
	
	public static SetVncPassword get() {
		SetVncPassword setVncPassword = new SetVncPassword();
		setVncPassword.setPassword("abcdefg");
		return setVncPassword;
	}
	
}
