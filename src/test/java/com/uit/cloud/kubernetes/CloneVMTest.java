/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CloneVM;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class CloneVMTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.cloneVM("wyw111", getCreateDisk());
		System.out.println(successful);
	}

	public static CloneVM getCreateDisk() {
		CloneVM cloneVM = new CloneVM();
		cloneVM.setName("wyw111-clone");
//		cloneVM.setAuto_clone(true);
		cloneVM.setFile("/var/lib/libvirt/imasges/ttt-1.qcow2");
		return cloneVM;
	}
}
