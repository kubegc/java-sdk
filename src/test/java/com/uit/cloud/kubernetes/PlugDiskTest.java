/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.PlugDisk;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class PlugDiskTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.plugDisk("950646e8c17a49d0b83c1c797811e001", getPlugDisk());
		System.out.println(successful);
	}
	
	public static PlugDisk getPlugDisk() {
		PlugDisk plugDisk = new PlugDisk();
		plugDisk.setSource("/var/lib/libvirt/images/snapshot1");
		plugDisk.setTarget("vda");
		plugDisk.setLive(true);
		plugDisk.setConfig(true);
		plugDisk.setSubdriver("qcow2");
		plugDisk.setRead_bytes_sec("1024000000");
		plugDisk.setWrite_bytes_sec("1024000000");
		plugDisk.setRead_iops_sec("40000");
		plugDisk.setWrite_iops_sec("40000");
		return plugDisk;
	}
}
