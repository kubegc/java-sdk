/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachine.Lifecycle.UnplugDisk;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class UnplugDiskTest {
	
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.unplugDisk("cloudinit1", getUnplugDisk());
		System.out.println(successful);
	}
	
	public static UnplugDisk getUnplugDisk() {
		UnplugDisk unplugDisk = new UnplugDisk();
		unplugDisk.setTarget("hda");
		unplugDisk.setLive(false);
		unplugDisk.setConfig(true);
		return unplugDisk;
	}
}
