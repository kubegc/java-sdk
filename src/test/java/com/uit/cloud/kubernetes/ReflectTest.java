/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import java.lang.reflect.Method;

import com.alibaba.fastjson.JSON;
import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CreateAndStartVMFromISO;
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
	
	
	public static String json = "{\r\n" + 
			"	\"cdrom\":\"/var/lib/libvirt/iso/centos7-minimal-1511.iso\",\r\n" + 
			"	\"disk\":\"/VAR/LIB/LIBVIRT/IMAGES/ROOTDISK\",\r\n" + 
			"	\"graphics\":\"vnc,listen=0.0.0.0\",\r\n" + 
			"	\"memory\":\"100\",\r\n" + 
			"	\"metadata\":\"auto.test\",\r\n" + 
			"	\"network\":\"type=bridge,source=virbr0\",\r\n" + 
			"	\"os_variant\":\"centos7.0\",\r\n" + 
			"	\"vcpus\":\"192.168.5.12,cpuset=1000\",\r\n" + 
			"	\"virt_type\":\"kvm\"\r\n" + 
			"}";
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
//		boolean successful = client.virtualMachineNetworks()
//				.createSwitch("switchtest", "vm.node30", get());
//		System.out.println(successful);
		Method tm = client.getClass().getMethod("virtualMachines");
		Object obj = tm.invoke(client);
		Method cw = obj.getClass().getMethod("createAndStartVMFromISO", String.class, String.class, CreateAndStartVMFromISO.class);
		cw.invoke(obj, "switch1234", "vm.node30", get());
	}

	protected static CreateAndStartVMFromISO get() {
		return JSON.parseObject(json, CreateAndStartVMFromISO.class);
	}
}
