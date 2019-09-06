/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Lifecycle.DeleteSnapshot;
import com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Lifecycle.RevertVirtualMachine;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class RevertSnapshotTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineSnapshots()
				.revertVirtualMachine("hello131212", get(), "123456");
		System.out.println(successful);
	}

	protected static RevertVirtualMachine get() {
		RevertVirtualMachine revertVM = new RevertVirtualMachine();
		// domain name
		revertVM.setDomain("350646e8c17a49d0b83c1c797811e084");
		// after reverting, change state to running
		revertVM.setRunning(true);
		return revertVM;
	}
	
}
