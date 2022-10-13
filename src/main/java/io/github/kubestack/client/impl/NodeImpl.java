/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.client.impl;


import io.fabric8.kubernetes.api.model.NodeSpec;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.models.Node;

/**
 * @author  wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.0.0
 * @since   2019/9/1
 **/
public class NodeImpl extends AbstractImpl<Node, NodeSpec> {

	public NodeImpl(KubeStackClient client, String kind) {
		super(client, kind);
	}


	@Override
	protected Node getModel() {
		return new Node();
	}

	@Override
	protected NodeSpec getSpec() {
		return new NodeSpec();
	}

	@Override
	protected Object getLifecycle() {
		return null;
	}

	@Override
	protected Class<?> getModelClass() {
		return Node.class;
	}

}