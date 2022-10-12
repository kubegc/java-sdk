/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.client.api.specs;

import java.util.Map;

import io.fabric8.kubernetes.api.model.Affinity;

/**
 * @author wuheng@iscas.ac.cn
 * 
 * @version 2.0.0
 * @since 2022.9.28
 * 
 **/
public abstract class KubeStackSpec {

	/**
	 * serialVersionUID
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1171174592223281364L;

	/**
	 * advanced scheduling policy based on node name
	 */
	protected String nodeName;

	/**
	 * advanced scheduling policy based on node selector
	 */
	protected Map<String, String> nodeSelector;

	/**
	 * affinity and anti-affinity
	 */
	protected Affinity affinity;

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public Map<String, String> getNodeSelector() {
		return nodeSelector;
	}

	public void setNodeSelector(Map<String, String> nodeSelector) {
		this.nodeSelector = nodeSelector;
	}

	public Affinity getAffinity() {
		return affinity;
	}

	public void setAffinity(Affinity affinity) {
		this.affinity = affinity;
	}

}
