/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Lifecycle.CreateSnapshot;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class CreateSnapshotTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineSnapshots()
				.createSnapshot("disktest3.3", "vm.node22", getCreateExternalSnapshot());
		System.out.println(successful);
	}

	protected static CreateSnapshot getCreateInternalSnapshot() {
		CreateSnapshot createSnapshot = new CreateSnapshot();
		// domain name
		createSnapshot.setDomain("vm003");
		createSnapshot.setLive(true);
		return createSnapshot;
	}
	
	protected static CreateSnapshot getCreateExternalSnapshot() {
		CreateSnapshot createSnapshot = new CreateSnapshot();
		// domain name
		createSnapshot.setDomain("vm007");
		createSnapshot.setAtomic(true);
		createSnapshot.setDisk_only(true);
		createSnapshot.setIsExternal(true);
		createSnapshot.setDiskspec("vda,snapshot=external,file=/var/lib/libvirt/pooltest2/disktest3/disktest3.3,driver=qcow2");
		return createSnapshot;
	}
	
}
