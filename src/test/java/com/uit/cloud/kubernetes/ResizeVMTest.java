/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ResizeVM;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class ResizeVMTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.resizeVM("950646e8c17a49d0b83c1c797811e004", get());
		System.out.println(successful);
	}

	protected static ResizeVM get() {
		ResizeVM resizevm = new ResizeVM();
		resizevm.setPath("/var/lib/libvirt/images/950646e8c17a49d0b83c1c797811e004");
		Long size = 40L*1024*1024*1024;
		resizevm.setSize(String.valueOf(size));
		return resizevm;
	}
}
	
