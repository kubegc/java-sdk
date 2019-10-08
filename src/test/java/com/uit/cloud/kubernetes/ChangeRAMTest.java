/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ChangeNumberOfCPU;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ResizeRAM;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class ChangeRAMTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.resizeRAM("950646e8c17a49d0b83c1c797811e004", get());
		System.out.println(successful);
	}
	
	public static ResizeRAM get() {
		ResizeRAM ins = new ResizeRAM();
		ins.setSize("1200000");
//		ins.setLive(true);
		ins.setConfig(true);
		return ins;
	}
}
