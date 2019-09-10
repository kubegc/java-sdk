/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import java.lang.reflect.Method;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinenetwork.Lifecycle.CreateSwitch;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class ReflectTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
//		boolean successful = client.virtualMachineNetworks()
//				.createSwitch("switchtest", "vm.node30", get());
//		System.out.println(successful);
		Method tm = client.getClass().getMethod("virtualMachineNetworks");
		Object obj = tm.invoke(client);
		Method cw = obj.getClass().getMethod("createSwitch", String.class, String.class, CreateSwitch.class);
		cw.invoke(obj, "switch1234", "vm.node30", get());
	}

	protected static CreateSwitch get() {
		CreateSwitch createSwitch = new CreateSwitch();
		createSwitch.setSubnet("192.168.7.0/24");
		return createSwitch;
	}
}
