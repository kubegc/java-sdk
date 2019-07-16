/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UnplugDisk;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/15
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class UnplugDiskTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.unplugDisk("skywind5", getUnplugDisk());
		System.out.println(successful);
	}
	
	public static UnplugDisk getUnplugDisk() {
		UnplugDisk unplugDisk = new UnplugDisk();
		unplugDisk.setTarget("vdb");
		unplugDisk.setLive(true);
		unplugDisk.setConfig(true);
		return unplugDisk;
	}
}
