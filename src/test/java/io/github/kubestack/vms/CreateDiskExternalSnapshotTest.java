/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.virtualmachinedisksnapshot.Lifecycle.CreateDiskExternalSnapshot;

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

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDiskSnapshots()
				.createDiskExternalSnapshot("vmbackuptestdisk1.4", "vm.node25", get(), "abc");
		System.out.println(successful);
	}

	protected static CreateDiskExternalSnapshot get() {
		CreateDiskExternalSnapshot createDiskExternalSnapshot = new CreateDiskExternalSnapshot();
		createDiskExternalSnapshot.setPool("61024b305b5c463b80bceee066077079");
		createDiskExternalSnapshot.setVol("vmbackuptestdisk1");
		createDiskExternalSnapshot.setFormat("qcow2");
		createDiskExternalSnapshot.setType("nfs");
		createDiskExternalSnapshot.setDomain("vmbackuptest");
		return createDiskExternalSnapshot;
	}
}
