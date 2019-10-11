/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ManageISO;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class ManageISOTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.manageISO("vm003", getManageISO());
		System.out.println(successful);
	}
	
	public static ManageISO getManageISO() {
		ManageISO iso = new ManageISO();
		iso.setSource("/var/lib/libvirt/iso/centos7-minimal-1511.iso");
		iso.setPath("hdb");
//		iso.setEject(true);
		iso.setInsert(true);
		iso.setForce(true);
//		iso.setLive(true);
		iso.setConfig(true);
		return iso;
	}
}
