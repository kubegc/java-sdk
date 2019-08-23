/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.deprecated;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.UITDiskSpec;
import com.github.kubesys.kubernetes.api.model.UITDiskSpec.Lifecycle.DeleteUITDisk;
import com.uit.cloud.kubernetes.AbstractTest;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/18
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class DeleteUITDiskTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineUITDisk()
				.deleteDisk("disk4", get());
		System.out.println(successful);
	}
	
	public static DeleteUITDisk get() {
		DeleteUITDisk disk = new DeleteUITDisk();
		disk.setPoolname("test");
		return disk;
	}

}
