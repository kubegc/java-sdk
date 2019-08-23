/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.deprecated;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.UITSnapshot;
import com.github.kubesys.kubernetes.api.model.UITSnapshotSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Lifecycle.CreateSnapshot;
import com.uit.cloud.kubernetes.AbstractTest;

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
				.createUITSnapshot("s1", "node31", get());
		System.out.println(successful);
	}

	protected static UITSnapshotSpec.Lifecycle.CreateUITSnapshot get() {

		UITSnapshotSpec.Lifecycle.CreateUITSnapshot  createSnapshot = new UITSnapshotSpec.Lifecycle.CreateUITSnapshot ();
		createSnapshot.setPoolname("test");
		createSnapshot.setName("disk1");
		createSnapshot.setSname("s1");
		return createSnapshot;
	}
	
}
