/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.TuneNICQoS;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class TuneNICQoSTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.tuneNICQoS("vm003", get());
		System.out.println(successful);
	}
	
	public static TuneNICQoS get() {
		TuneNICQoS tuneNICQoS = new TuneNICQoS();
		tuneNICQoS.setInbound("102400");
		tuneNICQoS.setOutbound("102400");
		tuneNICQoS.set_interface("52:54:00:51:12:cf");
		tuneNICQoS.setLive(true);
		tuneNICQoS.setConfig(true);
		return tuneNICQoS;
	}
}
