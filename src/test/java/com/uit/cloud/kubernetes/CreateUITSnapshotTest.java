/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.UITSnapshot;
import com.github.kubesys.kubernetes.api.model.UITSnapshotSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Lifecycle.CreateSnapshot;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/18
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class CreateUITSnapshotTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineUITSnapshot()
				.createSnapshot("s1", "node31", getCreateSnapshot());
		System.out.println(successful);
	}

	protected static UITSnapshotSpec.Lifecycle.CreateUITDiskSnapshot getCreateSnapshot() {

		UITSnapshotSpec.Lifecycle.CreateUITDiskSnapshot  createSnapshot = new UITSnapshotSpec.Lifecycle.CreateUITDiskSnapshot ();
		createSnapshot.setPoolname("test");
		createSnapshot.setName("disk1");
		createSnapshot.setSname("s1");
		return createSnapshot;
	}
	
}
