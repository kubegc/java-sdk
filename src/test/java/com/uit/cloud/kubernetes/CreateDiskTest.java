/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CreateDisk;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class CreateDiskTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDisks()
				.createDisk("vmtest111disk1", "vm.node25", get(), "abc");
		System.out.println(successful);
	}

	protected static CreateDisk get() {
		CreateDisk createDisk = new CreateDisk();
		createDisk.setPool("3915282a12dd4c34a0ae565d3ba2da41");
		// bytes 10G
		Long size = 10L*1024*1024*1024;
		createDisk.setCapacity(String.valueOf(size));
		createDisk.setFormat("qcow2");
		createDisk.setType("glusterfs");
		return createDisk;
	}
}
