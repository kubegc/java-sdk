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
				.createDiskFromDiskImage("vm006copdssdndddd", "vm.node22", get(), "abc");
		System.out.println(successful);
	}

	protected static CreateDiskFromDiskImage get() {
		CreateDiskFromDiskImage createDisk = new CreateDiskFromDiskImage();
		createDisk.setType("nfs");
		// create a volume in this pool
		createDisk.setTargetPool("migratepoolnode22");
		// vm disk image name
		createDisk.setSource("/var/lib/libvirt/cstor/1709accf174fccafed76b0d7fccdev/1709accf174fccafed76b0d7fccdev/wyw124bb/wyw124bb");
//		createDisk.setFull_copy(true);
		return createDisk;
	}
}
