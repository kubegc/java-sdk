/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.UITSnapshotSpec;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/18
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class DeleteUITSnapshotTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineUITSnapshot()
				.deleteUITSnapshot("s1", get());
		System.out.println(successful);
	}

	protected static UITSnapshotSpec.Lifecycle.RemoveUITSnapshot get() {

		UITSnapshotSpec.Lifecycle.RemoveUITSnapshot  createSnapshot = new UITSnapshotSpec.Lifecycle.RemoveUITSnapshot ();
		createSnapshot.setPoolname("test");
		createSnapshot.setName("disk1");
		createSnapshot.setSname("s1");
		return createSnapshot;
	}
}
