/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.funcs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.virtualmachinepool.Lifecycle;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class Func000_DeleteVMLocalfsPoolTest {
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachinePools()
				.deletePool("testdiskpool2", getPool());
		System.out.println(successful);
	}

	protected static Lifecycle.DeletePool getPool() throws Exception {
		Lifecycle.DeletePool deletePool = new Lifecycle.DeletePool();
		
		//dir
		deletePool.setType("dir");

		return deletePool;
	}
	
}
