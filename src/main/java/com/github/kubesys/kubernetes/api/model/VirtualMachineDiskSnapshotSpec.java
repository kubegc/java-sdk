/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model;

import com.github.kubesys.kubernetes.api.model.KubeModel.AbstractSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisksnapshot.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisksnapshot.Volume;

/**
 * @author wuheng@iscas.ac.cn
 * 
 * @version 2.0.0
 * @since   2022.9.28
 **/
public class VirtualMachineDiskSnapshotSpec extends AbstractSpec {


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
