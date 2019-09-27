/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.TuneDiskQoS;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class TuneDiskQoSTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.tuneDiskQoS("950646e8c17a49d0b83c1c797811e001", get());
		System.out.println(successful);
	}
	
	public static TuneDiskQoS get() {
		TuneDiskQoS tuneDiskQoS = new TuneDiskQoS();
//		tuneDiskQoS.setLive(true);
		tuneDiskQoS.setConfig(true);
		tuneDiskQoS.setDevice("vda");
		tuneDiskQoS.setTotal_bytes_sec("0");
//		tuneDiskQoS.setRead_bytes_sec("1024000000");
//		tuneDiskQoS.setWrite_bytes_sec("1024000000");
		tuneDiskQoS.setTotal_iops_sec("0");
//		tuneDiskQoS.setRead_iops_sec("40000");
//		tuneDiskQoS.setWrite_iops_sec("40000");
		return tuneDiskQoS;
	}
}
