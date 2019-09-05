/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CreateDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CreateDiskSnapshot;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/18
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class CreateDiskSnapshotTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDisks()
				.createDiskSnapshot("test1.qcow2", get(), "abc");
		System.out.println(successful);
	}

	protected static CreateDiskSnapshot get() {
		CreateDiskSnapshot createDiskSnapshot = new CreateDiskSnapshot();
		createDiskSnapshot.setPool("default");
		createDiskSnapshot.setSnapshotname("snap6");
		return createDiskSnapshot;
	}
}
