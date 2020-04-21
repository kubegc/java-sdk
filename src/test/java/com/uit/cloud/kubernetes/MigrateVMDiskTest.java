/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class MigrateVMDiskTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.migrateVMDisk("vmbackuptest", get());
		System.out.println(successful);
	}

	public static Lifecycle.MigrateVMDisk get() throws Exception {
		Lifecycle.MigrateVMDisk migrateVMDisk = new Lifecycle.MigrateVMDisk();
		migrateVMDisk.setIp("172.16.1.25");
		migrateVMDisk.setMigratedisks("vol=/var/lib/libvirt/cstor/3eebd453b21c4b8fad84a60955598195/3eebd453b21c4b8fad84a60955598195/vmbackupdisktest1/vmbackupdisktest1,pool=3915282a12dd4c34a0ae565d3ba2da41");
		return migrateVMDisk;
	}
}
