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
				.plugDisk("vm010", getPlugDisk());
//				.plugDisk("vm003", getPlugCdrom());
		System.out.println(successful);
	}
	
	public static PlugDisk getPlugDisk() {
		PlugDisk plugDisk = new PlugDisk();
		plugDisk.setSource("/var/lib/libvirt/pooltest3/wyw1111/wyw1111");
		plugDisk.setTarget("vdb");
		plugDisk.setLive(true);
		plugDisk.setConfig(true);
//		plugDisk.setType("cdrom");
		plugDisk.setSubdriver("qcow2");
//		plugDisk.setTotal_bytes_sec("1024000000");
//		plugDisk.setRead_bytes_sec("1024000000");
//		plugDisk.setWrite_bytes_sec("1024000000");
//		plugDisk.setTotal_iops_sec("40000");
//		plugDisk.setRead_iops_sec("40000");
//		plugDisk.setWrite_iops_sec("40000");
		return plugDisk;
	}
	
	public static PlugDisk getPlugCdrom() {
		PlugDisk plugDisk = new PlugDisk();
		plugDisk.setSource("/var/lib/libvirt/iso/centos7-minimal-1511.iso");
		// Cdrom only support hdX device
		plugDisk.setTarget("hdb");
		// Cdrom/floppy device hotplug isn't supported by Libvirt
		plugDisk.setConfig(true);
		plugDisk.setType("cdrom");
		return plugDisk;
	}
}
