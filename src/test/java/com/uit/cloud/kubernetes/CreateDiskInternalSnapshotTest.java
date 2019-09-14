/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CreateDiskInternalSnapshot;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class CreateDiskInternalSnapshotTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDisks()
				.createDiskInternalSnapshot("vm.auto.test-003", get(), "abc");
		System.out.println(successful);
	}

	protected static CreateDiskInternalSnapshot get() {
		CreateDiskInternalSnapshot createDiskInternalSnapshot = new CreateDiskInternalSnapshot();
		createDiskInternalSnapshot.setPool("default");
		createDiskInternalSnapshot.setSnapshotname("snapshot2");
		return createDiskInternalSnapshot;
	}
}
