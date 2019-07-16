/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.VirtualMachineList;

import java.util.List;

/**
 * @author Zhou Wenjun
 * @since  2019/5/1
 *
 *
 */
public class ListVirtualMachineTest {
	
	public static void main(String[] args) throws Exception {
		ExtendedKubernetesClient client = AbstractTest.getClient();
		VirtualMachineList list = client.virtualMachines().list();
		list.getItems().forEach(vm -> System.out.println(vm));
	}
	
}
