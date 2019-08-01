/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import java.util.Map;

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
				
				System.out.println(action + ":" + resource.getMetadata().getName());
				
				if (!resource.getMetadata().getName().equals("650646e8c17a49d0b83c1c797811e083")) {
					return;
				}
				
				//Action can be ADDED, MODIFIED, DELETED, ERROR
				
				if (resource.getSpec().getLifecycle() != null) {
					System.out.println("虚拟机正在处理中[根据Action的状态]");
					return;
				}
				
				if (resource.getSpec().getStatus() == null || resource.getSpec().getStatus().getAdditionalProperties() == null) {
					System.out.println("虚拟机处理异常，virtctl或virtctl服务异常");
					return;
				}
				
				Map<String, Object> statusProps = resource.getSpec().getStatus().getAdditionalProperties();	
				Map<String, Object> statusCond = (Map<String, Object>) (statusProps.get("conditions"));
				Map<String, Object> statusStat = (Map<String, Object>) (statusCond.get("state"));
				Map<String, Object> statusWait = (Map<String, Object>) (statusStat.get("waiting"));
				if (statusWait.get("reason").equals("Exception")
						|| statusWait.get("reason").equals("VirtError")) {
					System.out.println("错误原因[根据Action的状态]：" + statusWait.get("message"));
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
