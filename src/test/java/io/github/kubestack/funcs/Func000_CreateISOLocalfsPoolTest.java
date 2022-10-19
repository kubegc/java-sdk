/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.funcs;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachinepool.Lifecycle;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class Func000_CreateISOLocalfsPoolTest {
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachinePools()
				.createPool("isos", "vm.node131", getPool(), "123");
		System.out.println(successful);
	}

	protected static Lifecycle.CreatePool getPool() throws Exception {
		Lifecycle.CreatePool createPool = new Lifecycle.CreatePool();
		
		//dir
		createPool.setType("dir");
		createPool.setContent("iso");
		createPool.setAutostart(true);
        createPool.setUrl("/var/lib/libvirt/test/isos"); 
//		createPool.setUuid("170zzca5fd174fccafee76b0d7fc2d35");
		// uus
//		createPool.setType("uus");
//		createPool.setUrl("uus-iscsi-independent://admin:admin@192.168.3.10:7000/p1/4/2/0/32/0/3");
		
		// nfs
//		createPool.setType("nfs");
//		createPool.setTarget("poolnfs");
//		createPool.setUrl("nfs://192.168.3.99:/nfs/nfs");
//		createPool.setOpt("nolock");
		
		// glusterfs
//		createPool.setType("glusterfs");
//		createPool.setTarget("poolglusterfs");
//		createPool.setUrl("glusterfs://192.168.3.93:nfsvol");
		
		return createPool;
	}
	
}
