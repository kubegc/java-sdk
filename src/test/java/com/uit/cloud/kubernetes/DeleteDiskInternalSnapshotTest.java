/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.DeleteDiskInternalSnapshot;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class DeleteDiskInternalSnapshotTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDisks()
				.deleteDiskInternalSnapshot("disk4abcdefgh", get(), "abc");
		System.out.println(successful);
	}

	protected static DeleteDiskInternalSnapshot get() {
		DeleteDiskInternalSnapshot deleteDiskSnapshot = new DeleteDiskInternalSnapshot();
		deleteDiskSnapshot.setPool("default");
		deleteDiskSnapshot.setSnapshotname("snapshot1");
		return deleteDiskSnapshot;
	}
}
