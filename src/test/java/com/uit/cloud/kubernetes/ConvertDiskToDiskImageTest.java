/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.ConvertDiskToDiskImage;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/18
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class ConvertDiskToDiskImageTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDisks()
				.convertDiskToDiskImage("t6", get(), "abc");
		System.out.println(successful);
	}

	protected static ConvertDiskToDiskImage get() {
		ConvertDiskToDiskImage convertDisk = new ConvertDiskToDiskImage();
		// need pool to locate disk
		convertDisk.setPool("default");
		return convertDisk;
	}
}
