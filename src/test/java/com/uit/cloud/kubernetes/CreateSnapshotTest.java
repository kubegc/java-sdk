/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Lifecycle.CreateSnapshot;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/18
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class CreateSnapshotTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineSanshots()
				.createSnapshot("hello11", "vm.node31", getCreateSnapshot());
		System.out.println(successful);
	}

	protected static CreateSnapshot getCreateSnapshot() {
		CreateSnapshot createSnapshot = new CreateSnapshot();
		createSnapshot.setDomain("950646e8c17a49d0b83c1c797811e055");
		return createSnapshot;
	}
	
}
