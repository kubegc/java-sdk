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
				.createDisk("disk1", "node30", getCreateDisk());
		System.out.println(successful);
	}
	
	public static CreateDisk getCreateDisk() {
		CreateDisk createDisk = new CreateDisk();
		createDisk.setPool("volumes1");
		createDisk.setFormat("qcow2");
		createDisk.setCapacity("10G");
		return createDisk;
	}
}
