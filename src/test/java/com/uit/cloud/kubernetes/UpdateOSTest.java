/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UpdateOS;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class UpdateOSTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.updateOS("950646e8c17a49d0b83c1c797811e041", getManageISO());
		System.out.println(successful);
	}
	
	public static UpdateOS getManageISO() {
		UpdateOS os = new UpdateOS();
		// current VM disk
		os.setSource("/var/lib/libvirt/images/950646e8c17a49d0b83c1c797811e041-2.qcow2");
		// target VM disk
		os.setTarget("/var/lib/libvirt/templates/test.qcow2");
		return os;
	}
}
