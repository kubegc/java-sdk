/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Volume;

import io.fabric8.kubernetes.api.model.KubernetesResource;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author xuyuanjia2017@otcaix.iscas.ac.cn
 * @author xianghao16@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @since Thu Jun 13 21:44:40 CST 2019
 **/
@SuppressWarnings("rawtypes")
@JsonDeserialize(using = JsonDeserializer.None.class)
public class VirtualMachineDiskSpec extends ExtendedCustomResourceDefinitionSpec implements KubernetesResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1171174592223281364L;

	protected Volume volume;

	protected Lifecycle lifecycle;

	public VirtualMachineDiskSpec() {

	}

	public Volume getVolume() {
		return volume;
	}

	public void setVolume(Volume volume) {
		this.volume = volume;
	}

	public Lifecycle getLifecycle() {
		return lifecycle;
	}

	public void setLifecycle(Lifecycle lifecycle) {
		this.lifecycle = lifecycle;
	}

}
