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
public class ListenDeleteVMTest {
	
	protected static boolean deleteHandled = false;
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		client.watchVirtualMachines(new Watcher<VirtualMachine>() {

			@Override
			public void eventReceived(Action action, VirtualMachine resource) {
				
				// 不是所需的虚拟机
				if (!resource.getMetadata().getName().equals("650646e8c17a49d0b83c1c797811e083")
						// 不是虚拟机类型
						|| !resource.getKind().equals(VirtualMachine.class.getSimpleName())
						// 没有接到删除指令
						|| resource.getSpec().getLifecycle() == null) {
					return;
				}
				
				// 删除虚拟机 CASE1: 删除虚拟机无法实施
				if (action.toString().equals("MODIFIED")) {
					// 超时机制，如果lifecycle存在，说明物理机上virt程序死掉，后续都无法处理
					int i = 10;
					while(!deleteHandled && i-->0) {
						if (client.virtualMachines().get("650646e8c17a49d0b83c1c797811e083")
								.getSpec().getLifecycle() != null) {
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								
							}
						} else {
							deleteHandled = true;
						}
					}
					if (!deleteHandled) {
						System.out.println("删除虚拟机：虚拟机无法实施创建操作，请查看nodeName是否正确，获取调度器是否正常");
						System.out.println("删除虚拟机：虚拟机创建异常退出");
						return;
					}
				}
				
				//删除虚拟机 CASE2: 删除虚拟机得以实施
				VirtualMachine vm = client.virtualMachines().get("650646e8c17a49d0b83c1c797811e083");
				
				if (vm == null) {
					System.out.println("删除虚拟机成功");
					return;
				}
				
				
				Map<String, Object> statusProps = vm.getSpec().getStatus().getAdditionalProperties();	
				Map<String, Object> statusCond = (Map<String, Object>) (statusProps.get("conditions"));
				Map<String, Object> statusStat = (Map<String, Object>) (statusCond.get("state"));
				Map<String, Object> statusWait = (Map<String, Object>) (statusStat.get("waiting"));
				if (statusWait.get("reason").equals("Exception")
						|| statusWait.get("reason").equals("VirtctlError")) {
					System.out.println("删除虚拟机异常原因]：" + statusWait.get("message"));
					return;
				}
				
				
			}

			@Override
			public void onClose(KubernetesClientException cause) {
				
			}
			
		});
	}
	
	
}
