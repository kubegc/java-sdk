/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CreateDisk;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/18
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class CreateDiskTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDisks()
				.createDisk("test4.qcow2", "vm.node30", get(), "abc");
		System.out.println(successful);
	}

	protected static CreateDisk get() {
		CreateDisk createDisk = new CreateDisk();
		createDisk.setPool("default");
		// bytes 10G
		Long size = 10L*1024*1024*1024;
		createDisk.setCapacity(String.valueOf(size));
		createDisk.setFormat("qcow2");
		return createDisk;
	}
}
