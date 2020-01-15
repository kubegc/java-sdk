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
				.migrateVMDisk("vm006", get());
		System.out.println(successful);
	}

	public static Lifecycle.MigrateVMDisk get() throws Exception {
		Lifecycle.MigrateVMDisk migrateVMDisk = new Lifecycle.MigrateVMDisk();
		migrateVMDisk.setIp("133.133.135.22");
		migrateVMDisk.setMigratedisks("vol=/var/lib/libvirt/cstor/1709accdd174caced76b0db2235/1709accdd174caced76b0db2235/vm003migratevmdisk2/snapshots/vm003migratevmdisk2.1,pool=vmbbstddolgg11node22");
		return migrateVMDisk;
	}
}
