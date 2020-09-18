/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ChangeNumberOfCPU;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class ChangeNumberOfCPUTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.changeNumberOfCPU("cloudinit1", get());
//				.plugDisk("vm003", getPlugCdrom());
		System.out.println(successful);
	}
	
	public static ChangeNumberOfCPU get() {
		ChangeNumberOfCPU cpu = new ChangeNumberOfCPU();
		cpu.setCount("1");
		cpu.setLive(true);
		cpu.setConfig(true);
		return cpu;
	}
}
