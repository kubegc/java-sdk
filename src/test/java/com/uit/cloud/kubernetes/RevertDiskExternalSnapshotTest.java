/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.RevertDiskExternalSnapshot;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class RevertDiskExternalSnapshotTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDisks()
				.revertDiskExternalSnapshot("ss3", get(), "abc");
		System.out.println(successful);
	}

	protected static RevertDiskExternalSnapshot get() {
		RevertDiskExternalSnapshot revertDiskExternalSnapshot = new RevertDiskExternalSnapshot();
		revertDiskExternalSnapshot.setType("dir");
		revertDiskExternalSnapshot.setPool("default");
		revertDiskExternalSnapshot.setVol("disktest");
		revertDiskExternalSnapshot.setFormat("qcow2");
		return revertDiskExternalSnapshot;
	}
}