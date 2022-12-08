/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachinedisk.Lifecycle.DeleteDisk;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class AA_019_VMDisk_DeleteOnLocalfsTest {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDisks()
				.deleteDisk("crail-compute1", getDeleteDisk());
		System.out.println(successful);
	}
	
	public static DeleteDisk getDeleteDisk() {
		DeleteDisk deleteDisk = new DeleteDisk();
		deleteDisk.setPool("migratepoolnodepool22");
		deleteDisk.setType("localfs");
		return deleteDisk;
	}
}
