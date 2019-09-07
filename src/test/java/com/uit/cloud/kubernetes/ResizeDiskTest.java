/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.ResizeDisk;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class ResizeDiskTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDisks()
				.resizeDisk("950646e8c17a49d0b83c1c797811e041-2.qcow2", get());
		System.out.println(successful);
	}

	protected static ResizeDisk get() {
		ResizeDisk resizeDisk = new ResizeDisk();
		resizeDisk.setCapacity("40G");
		resizeDisk.setPool("default");
		return resizeDisk;
	}
}
	
