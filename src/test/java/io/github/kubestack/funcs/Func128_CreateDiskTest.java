/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.funcs;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachinedisk.Lifecycle.CreateDisk;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class Func128_CreateDiskTest {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDisks()
				.createDisk("test-disk-uuid-0001", "vm.node131", get(), "abc");
		System.out.println(successful);
	}

	protected static CreateDisk get() {
		CreateDisk createDisk = new CreateDisk();
		createDisk.setPool("migratenodepool22");
		// bytes 10G
		createDisk.setCapacity("10G");
		createDisk.setFormat("qcow2");
		createDisk.setType("nfs");
		return createDisk;
	}
}
