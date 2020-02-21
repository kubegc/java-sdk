/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.PassthroughUsb;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class PassthroughUSBTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.passthroughUsb("wyw123", passthroughUsb());
		System.out.println(successful);
	}
	
	public static PassthroughUsb passthroughUsb() {
		PassthroughUsb passthroughUsb = new PassthroughUsb();
		passthroughUsb.setAction("remove");
		passthroughUsb.setBus_num("001");
		passthroughUsb.setDev_num("001");
		passthroughUsb.setLive(false);
		return passthroughUsb;
	}
}
