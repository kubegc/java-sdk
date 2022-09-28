/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model;

import java.util.Map;

import io.fabric8.kubernetes.api.model.Affinity;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Status;

/**
 * @author wuheng@iscas.ac.cn
 * 
 * @version 2.0.0
 * @since   2022.9.28
 * 
 **/
public abstract class KubeModel {

	/**
	 * serialVersionUID
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1171174592223281364L;
	
	
	protected String apiVersion;
	
	protected String kind;
	
	protected ObjectMeta metadata;
	
	protected AbstractSpec abstractSpec;
	
	protected Status status;


	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public ObjectMeta getMetadata() {
		return metadata;
	}

	public void setMetadata(ObjectMeta metadata) {
		this.metadata = metadata;
	}

	public AbstractSpec getSpec() {
		return abstractSpec;
	}

	public void setSpec(AbstractSpec abstractSpec) {
		this.abstractSpec = abstractSpec;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public static abstract class AbstractSpec {
		
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
}
