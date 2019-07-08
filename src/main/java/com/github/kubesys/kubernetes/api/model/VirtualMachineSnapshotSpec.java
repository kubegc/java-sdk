/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model;

import java.util.Map;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Domainsnapshot;

import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.apiextensions.CustomResourceDefinitionSpec;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author xuyuanjia2017@otcaix.iscas.ac.cn
 * @author xianghao16@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @since Thu Jun 13 21:44:40 CST 2019
 **/
@SuppressWarnings("rawtypes")
@JsonDeserialize(using = JsonDeserializer.None.class)
public class VirtualMachineSnapshotSpec extends CustomResourceDefinitionSpec implements KubernetesResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1171174592223281364L;

	protected Domainsnapshot domainsnapshot;

	protected Map<String, String> description;

	protected String image;

	protected String nodeName;
	
	protected String status;

	public VirtualMachineSnapshotSpec() {

	}

	public Map<String, String> getDescription() {
		return description;
	}

	public void setDescription(Map<String, String> description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Domainsnapshot getDomainsnapshot() {
		return domainsnapshot;
	}

	public void setDomainsnapshot(Domainsnapshot domainsnapshot) {
		this.domainsnapshot = domainsnapshot;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	
}
