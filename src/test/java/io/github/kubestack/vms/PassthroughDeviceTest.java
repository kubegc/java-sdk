/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachine.Lifecycle.PassthroughDevice;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class PassthroughDeviceTest {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.passthroughDevice("gputest", passthroughDevice());
		System.out.println(successful);
	}
	
	public static PassthroughDevice passthroughDevice() {
		PassthroughDevice passthroughDevice = new PassthroughDevice();
		passthroughDevice.setAction("add");
		passthroughDevice.setBus_num("01");
		passthroughDevice.setSub_bus_num("00");
		passthroughDevice.setDev_num("0");
		passthroughDevice.setLive(false);
		passthroughDevice.setDev_type("pci");
		return passthroughDevice;
	}
}
