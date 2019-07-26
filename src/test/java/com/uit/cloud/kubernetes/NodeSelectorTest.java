/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ManageISO;
import com.github.kubesys.kubernetes.impl.NodeSelectorImpl.Policy;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/26
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class NodeSelectorTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		String nodeName = client.getNodeSelector()
				.getNodename(Policy.minimumCPUUsageHostAllocatorStrategyMode);
		System.out.println(nodeName);
	}
	
}
