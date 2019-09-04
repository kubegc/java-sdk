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
				.revertVirtualMachine("hello12", get(), "123456");
		System.out.println(successful);
	}

	protected static RevertVirtualMachine get() {
		RevertVirtualMachine revertVM = new RevertVirtualMachine();
		revertVM.setSnapshotname("abcde");
		revertVM.setCurrent(true);
		return revertVM;
	}
	
}
