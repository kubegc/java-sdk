/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import java.util.HashMap;
import java.util.Map;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;

import io.fabric8.kubernetes.api.model.Node;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class NodeZoneLabels {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		Node node = client.nodes().withName("nodeName").get();
		Map<String, String> labels = node.getMetadata().getLabels();
		// 可以添加多个标签
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("zone", "rackA");
		client.nodes().create(node);
	}

}
