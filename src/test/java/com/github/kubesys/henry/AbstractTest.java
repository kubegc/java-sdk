/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.henry;

import com.github.kubesys.kubernetes.KubeStackClient;


/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/15
 *
 */
public class AbstractTest {

	public static KubeStackClient getClient() throws Exception {
		return new KubeStackClient("", "");
	}
	
	public static VirtualMachine getVMByName(String name) throws Exception {
		return getClient().virtualMachines().get(name);
	}
}
