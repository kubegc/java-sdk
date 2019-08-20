/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.UITDiskSpec;

/**
 * @author liuhe18@otcaix.iscas.ac.cn
 * @since  2019/8/19
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class CreateUITDiskTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineUITDisk()
				.createDisk("disk1", "node31", getCreateDisk());
		System.out.println(successful);
	}
	
	public static UITDiskSpec.Lifecycle.CreateUITDisk getCreateDisk() {
		UITDiskSpec.Lifecycle.CreateUITDisk createDisk = new UITDiskSpec.Lifecycle.CreateUITDisk();
		createDisk.setPoolname("test");
		createDisk.setSize((long) 1);
		return createDisk;
	}
}
