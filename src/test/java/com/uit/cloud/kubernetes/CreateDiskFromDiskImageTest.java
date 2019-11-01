/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CreateDiskFromDiskImage;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class CreateDiskFromDiskImageTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDisks()
				.createDiskFromDiskImage("VM20190918", "vm.node30", get(), "abc");
		System.out.println(successful);
	}

	protected static CreateDiskFromDiskImage get() {
		CreateDiskFromDiskImage createDisk = new CreateDiskFromDiskImage();
		// create a volume in this pool
		createDisk.setTargetPool("default");
		// vm disk image name
		createDisk.setSourceImage("t5");
		return createDisk;
	}
}
