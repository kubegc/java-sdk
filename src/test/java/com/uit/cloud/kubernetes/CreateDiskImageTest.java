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
				.createDiskImage("t1", "vm.node30", get(), "abc");
		System.out.println(successful);
	}

	protected static CreateDiskImage get() {
		CreateDiskImage createDiskImage = new CreateDiskImage();
		// absolute path of the image file
		createDiskImage.setSource("/root/test.qcow2");
		return createDiskImage;
	}
}
