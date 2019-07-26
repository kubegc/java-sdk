/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.DeleteDisk;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/18
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class DeleteDiskTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDisks()
				.deleteDisk("650646e8c17a49d0b83c1c797811e067", getDeleteDisk());
		System.out.println(successful);
	}
	
	public static DeleteDisk getDeleteDisk() {
		DeleteDisk dleteDisk = new DeleteDisk();
		dleteDisk.setPool("volumes1");
		return dleteDisk;
	}
}
