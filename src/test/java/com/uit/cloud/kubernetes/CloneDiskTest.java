/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CloneDisk;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/26
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class CloneDiskTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDisks()
				.cloneDisk("diskacopy", getCreateDisk());
		System.out.println(successful);
	}
	
	public static CloneDisk getCreateDisk() {
		CloneDisk createDisk = new CloneDisk();
		createDisk.setPool("poolb");
		createDisk.setNewname("diskacopy1");
		return createDisk;
	}
}
