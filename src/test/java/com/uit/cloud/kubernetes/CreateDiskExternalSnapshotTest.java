/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisksnapshot.Lifecycle.CreateDiskExternalSnapshot;

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
		boolean successful = client.virtualMachineDiskSnapshots()
				.createDiskExternalSnapshot("disktest3.1", "vm.node22", get(), "abc");
		System.out.println(successful);
	}

	protected static CreateDiskExternalSnapshot get() {
		CreateDiskExternalSnapshot createDiskExternalSnapshot = new CreateDiskExternalSnapshot();
		createDiskExternalSnapshot.setPool("pooltest2");
		createDiskExternalSnapshot.setVol("disktest3");
		createDiskExternalSnapshot.setFormat("qcow2");
		createDiskExternalSnapshot.setType("dir");
		return createDiskExternalSnapshot;
	}
}
