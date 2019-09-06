/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinediskimage.Lifecycle.CreateDiskImage;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/18
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class CreateDiskImageTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDiskImages()
				.createDiskImage("tttttttt5", "vm.node30", get(), "abc");
		System.out.println(successful);
	}

	protected static CreateDiskImage get() {
		CreateDiskImage createDiskImage = new CreateDiskImage();
		// Only support file in "/var/lib/libvirt/" or its sub-dirs
		createDiskImage.setSource("/var/test.qcow2");
		return createDiskImage;
	}
}
