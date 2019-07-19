/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UpdateOS;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/15
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class UpdateOSTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.updateOS("skywind11", getManageISO());
		System.out.println(successful);
	}
	
	public static UpdateOS getManageISO() {
		UpdateOS os = new UpdateOS();
		// current VM disk
		os.setSource("/var/lib/libvirt/images/fuck-skywind11.qcow2");
		// target VM disk
		os.setTarget("/var/lib/libvirt/images/ttt.qcow2");
		return os;
	}
}
