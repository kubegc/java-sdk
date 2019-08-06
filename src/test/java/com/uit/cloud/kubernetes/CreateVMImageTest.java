/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;


import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachineimage.Lifecycle.CreateImage;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/22
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class CreateVMImageTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		client.virtualMachineImages().createImage("aaa", get());
	}

	private static CreateImage get() {
		CreateImage image = new CreateImage();
		image.setDisk("/var/lib/");
		return image;
	}
	
	
	
}
