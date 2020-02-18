/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.DeleteDisk;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class DeleteDiskTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDisks()
				.deleteDisk("vmbackuplocalfsdisk2", getDeleteDisk());
		System.out.println(successful);
	}
	
	public static DeleteDisk getDeleteDisk() {
		DeleteDisk deleteDisk = new DeleteDisk();
		deleteDisk.setPool("25aa4da8e659417fb27be62a78797822");
		deleteDisk.setType("localfs");
		return deleteDisk;
	}
}
