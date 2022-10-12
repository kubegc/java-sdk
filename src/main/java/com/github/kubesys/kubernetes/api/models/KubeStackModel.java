/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.models;

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.Status;

/**
 * @author wuheng@iscas.ac.cn
 * 
 * @version 2.0.0
 * @since   2022.9.28
 * 
 **/
public abstract class KubeStackModel<T> {

	/**
	 * serialVersionUID
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1171174592223281364L;
	
	
	protected String apiVersion;
	
	protected String kind;
	
	protected ObjectMeta metadata;
	
	protected T spec;
	
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


	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public T getSpec() {
		return spec;
	}

	public void setSpec(T spec) {
		this.spec = spec;
	}

}
