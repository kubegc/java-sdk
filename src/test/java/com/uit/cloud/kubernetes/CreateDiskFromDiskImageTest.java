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
				.createDiskFromDiskImage("vm006copynnn", "vm.node22", get(), "abc");
		System.out.println(successful);
	}

	protected static CreateDiskFromDiskImage get() {
		CreateDiskFromDiskImage createDisk = new CreateDiskFromDiskImage();
		createDisk.setType("localfs");
		// create a volume in this pool
		createDisk.setTargetPool("node22-poolnfs");
		// vm disk image name
		createDisk.setSource("/var/lib/libvirt/cstor/07098ca5-fd17-4fcc-afed-76b0d7fccde9/07098ca5-fd17-4fcc-afed-76b0d7fccde9/wyw222/wyw222");
//		createDisk.setFull_copy(true);
		return createDisk;
	}
}
