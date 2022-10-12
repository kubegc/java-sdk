/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.client.api.specs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.github.kubestack.client.api.specs.virtualmachinedisksnapshot.Lifecycle;
import io.github.kubestack.client.api.specs.virtualmachinedisksnapshot.Volume;

/**
 * @author wuheng@iscas.ac.cn
 * 
 * @version 2.0.0
 * @since   2022.9.28
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VirtualMachineDiskSnapshotSpec extends KubeStackSpec {


	protected Volume volume;

	protected Lifecycle lifecycle;
	
	public VirtualMachineDiskSnapshotSpec() {

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
