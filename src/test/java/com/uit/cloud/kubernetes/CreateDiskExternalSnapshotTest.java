/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CreateDiskExternalSnapshot;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class CreateDiskExternalSnapshotTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDisks()
				.createDiskExternalSnapshot("root4abcdeef.1", "vm.node30", get(), "abc");
		System.out.println(successful);
	}

	protected static CreateDiskExternalSnapshot get() {
		CreateDiskExternalSnapshot createDiskExternalSnapshot = new CreateDiskExternalSnapshot();
		createDiskExternalSnapshot.setPool("default");
		// bytes 10G
		Long size = 10L*1024*1024*1024;
		createDiskExternalSnapshot.setCapacity(String.valueOf(size));
		createDiskExternalSnapshot.setBacking_vol("root4abcdeef");
		createDiskExternalSnapshot.setBacking_vol_format("qcow2");
		createDiskExternalSnapshot.setFormat("qcow2");
		createDiskExternalSnapshot.setType("dir");
		return createDiskExternalSnapshot;
	}
}
