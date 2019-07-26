/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;

import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.NodeCondition;
import io.fabric8.kubernetes.api.model.Taint;


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

	/**
	 * default node
	 */
	protected final static String DEFAULT_NODE = null;
	
	/**
	 * client
	 */
	protected final ExtendedKubernetesClient client;
	
	/**
	 * @param client  client
	 */
	public NodeSelectorImpl(ExtendedKubernetesClient client) {
		super();
		this.client = client;
	}

	public String getNodename(Policy policy) {
		
		Node[] nodes = getAllNodesFromKubernetes();
		
		if (policy == Policy.minimumCPUUsageHostAllocatorStrategyMode) {
			sortByMinimumCPUUsage(nodes);
		} else if (policy == Policy.minimumMemoryUsageHostAllocatorStrategyMode) {
			sortByMinimumMemoryUsage(nodes);
		} else if (policy == Policy.maxInstancePerHost) {
			sortByMaxInstancePerHost(nodes);
		} else if (policy == Policy.minInstancePerHost) {
			sortByMinInstancePerHost(nodes);
		} 
		
		for (Node node : nodes) {
			if (isMaster(node) || notReady(node) || unSched(node)) {
				continue;
			}
			return node.getMetadata().getName();
		}
		
		return DEFAULT_NODE;
	}

	protected void sortByMinInstancePerHost(Node[] nodes) {
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

	protected void sortByMaxInstancePerHost(Node[] nodes) {
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
	}

	protected void sortByMinimumMemoryUsage(Node[] nodes) {
		Arrays.sort(nodes, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				long lo1 = stringToLong(o1.getStatus()
						.getAllocatable().get("memory").getAmount());
				long lo2 = stringToLong(o2.getStatus()
						.getAllocatable().get("memory").getAmount());
				return (lo2 - lo1 < 0) ? -1 : 1;
			}
			
		});
	}

	protected void sortByMinimumCPUUsage(Node[] nodes) {
		Arrays.sort(nodes, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				long lo1 = stringToLong(o1.getStatus()
						.getAllocatable().get("cpu").getAmount());
				long lo2 = stringToLong(o2.getStatus()
						.getAllocatable().get("cpu").getAmount());
				return (lo2 - lo1 < 0) ? -1 : 1;
			}
			
		});
	}

	protected Node[] getAllNodesFromKubernetes() {
		try {
			return client.nodes().list()
					.getItems().toArray(new Node[] {});
		} catch (Exception ex) {
			// if client is null or we encounter unknown problem 
			m_logger.log(Level.SEVERE, ex.getMessage());
			return new Node[] {};
		}
	}

	protected boolean unSched(Node node) {
		for (Taint taint : node.getSpec().getTaints()) {
			if (taint.getEffect().equals("NoSchedule")) {
				return true;
			}
		}
		return false;
	}

	protected boolean notReady(Node node) {
		for (NodeCondition nc : node.getStatus().getConditions()) {
			if (nc.getType().equals("Ready")) {
				return false;
			}
		}
		return true;
	}

	protected boolean isMaster(Node node) {
		return node.getMetadata().getLabels()
				.containsKey("node-role.kubernetes.io/master");
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

