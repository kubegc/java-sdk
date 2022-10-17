/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.models.VirtualMachineDisk;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class AA_VMDisk_DeleteTest {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = io.github.kubestack.AbstractTest.getClient();
		System.out.println(client.virtualMachineDisks().get("henryvmd"));
		VirtualMachineDisk vmd = client.virtualMachineDisks().get("henryvmd");
		System.out.println(vmd);
		boolean successful = client.virtualMachineDisks()
				.delete(vmd);
		System.out.println(successful);
	}

}
