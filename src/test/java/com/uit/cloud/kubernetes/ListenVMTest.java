/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.VirtualMachine;

import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/8/1
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class ListenVMTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		client.watchVirtualMachines(new Watcher<VirtualMachine>() {

			@Override
			public void eventReceived(Action action, VirtualMachine resource) {
				
				if (!resource.getMetadata().getName().equals("")) {
					return;
				}
				
				//Action can be ADDED, MODIFIED, DELETED, ERROR
				
				if (resource.getSpec().getLifecycle() != null) {
					System.out.println("虚拟机正在处理中[根据Action的状态]");
					return;
				}
				
				if (resource.getSpec().getStatus() == null) {
					System.out.println("虚拟机处理异常，virtctl或virtctl服务异常");
					return;
				}
				
				if (resource.getSpec().getStatus().getStatus().equals("Exception")
						|| resource.getSpec().getStatus().getStatus().equals("VirtError")) {
					System.out.println("错误原因[根据Action的状态]：" + resource.getSpec().getStatus().getMessage());
					return;
				}
				
				System.out.println("正常处理[[根据Action的状态]]");
			}

			@Override
			public void onClose(KubernetesClientException cause) {
				
			}
			
		});
	}
	
	
}
