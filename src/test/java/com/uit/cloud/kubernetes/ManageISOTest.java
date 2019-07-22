/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ManageISO;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/15
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class ManageISOTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.manageISO("t1", getManageISO());
		System.out.println(successful);
	}
	
	public static ManageISO getManageISO() {
		ManageISO iso = new ManageISO();
		iso.setPath("/opt/ISO/CentOS-7-x86_64-Minimal-1511.iso");
		iso.setEject(true);
		iso.setForce(true);
//		iso.setLive(true);
		iso.setConfig(true);
		return iso;
	}
}
