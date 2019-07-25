/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Logger;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;

import io.fabric8.kubernetes.api.model.Node;


/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author xuyuanjia2017@otcaix.iscas.ac.cn
 * @author xianghao16@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @since Thu July 25 21:39:55 CST 2019
 **/
public class NodeSelectorImpl {
	
	/**
	 * m_logger
	 */
	protected final static Logger m_logger = Logger.getLogger(NodeSelectorImpl.class.getName());

	protected final ExtendedKubernetesClient client;
	
	public NodeSelectorImpl(ExtendedKubernetesClient client) {
		super();
		this.client = client;
	}

	public String getNodename(Policy policy) {
		Node[] nodes =  (Node[]) client.nodes()
				.list().getItems().toArray();
		
		if (policy == Policy.minimumCPUUsageHostAllocatorStrategyMode) {
			Arrays.sort(nodes, new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					long lo1 = stringToLong(o1.getStatus()
							.getAllocatable().get("cpu").getAmount());
					long lo2 = stringToLong(o2.getStatus()
							.getAllocatable().get("cpu").getAmount());
					return (lo1 - lo2 < 0) ? -1 : 1;
				}
				
			});
		} else if (policy == Policy.minimumMemoryUsageHostAllocatorStrategyMode) {
			Arrays.sort(nodes, new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					long lo1 = stringToLong(o1.getStatus()
							.getAllocatable().get("memory").getAmount());
					long lo2 = stringToLong(o2.getStatus()
							.getAllocatable().get("memory").getAmount());
					return (lo1 - lo2 < 0) ? -1 : 1;
				}
				
			});
		} else if (policy == Policy.maxInstancePerHost) {
			Arrays.sort(nodes, new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					long lo1 = stringToLong(o1.getStatus()
							.getAllocatable().get("pods").getAmount());
					long lo2 = stringToLong(o2.getStatus()
							.getAllocatable().get("pods").getAmount());
					return (lo1 - lo2 > 0) ? -1 : 1;
				}
				
			});
		} else if (policy == Policy.minInstancePerHost) {
			Arrays.sort(nodes, new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					long lo1 = stringToLong(o1.getStatus()
							.getAllocatable().get("pods").getAmount());
					long lo2 = stringToLong(o2.getStatus()
							.getAllocatable().get("pods").getAmount());
					return (lo1 - lo2 < 0) ? -1 : 1;
				}
				
			});
		}
		
		return nodes[0].getMetadata().getName();
	}

	public static long stringToLong(String value) {
		if (value.endsWith("Ki")) {
			value = value.substring(0, value.length() - 2);
		}
		
		return Long.parseLong(value);
	}
	
	public static enum Policy {
		minimumMemoryUsageHostAllocatorStrategyMode,
		minimumCPUUsageHostAllocatorStrategyMode,
		maxInstancePerHost,
		minInstancePerHost
	}
	
	public static void main(String[] args) {
		System.out.println(stringToLong("100Ki"));
	}
}

