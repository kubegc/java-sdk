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
				.plugDisk("wywtest", getPlugBlock());
//				.plugDisk("vm003", getPlugCdrom());
		System.out.println(successful);
	}
	
	public static PlugDisk getPlugDisk() {
		PlugDisk plugDisk = new PlugDisk();
		plugDisk.setSource("/var/lib/libvirt/snapshots/disk1.1");
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
	
	public static PlugDisk getPlugBlock() {
		PlugDisk plugDisk = new PlugDisk();
		plugDisk.setSource("/dev/disk/by-id/wwn-0x5000c500b5b0bd4e-part2");
		plugDisk.setTarget("sda");
		plugDisk.setLive(true);
		plugDisk.setConfig(true);
		plugDisk.setType("lun");
		plugDisk.setSgio("unfiltered");
		plugDisk.setSubdriver("raw");
		plugDisk.setTotal_bytes_sec("1024000000");
		plugDisk.setRead_bytes_sec("1024000000");
		plugDisk.setWrite_bytes_sec("1024000000");
		plugDisk.setTargetbus("scsi");
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
		plugDisk.setSubdriver("raw");
		plugDisk.setType("cdrom");
		return plugDisk;
	}
}
