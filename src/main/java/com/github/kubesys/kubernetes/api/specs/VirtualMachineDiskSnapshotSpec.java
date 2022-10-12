/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.specs;

import com.github.kubesys.kubernetes.api.KubeStackSpec;
import com.github.kubesys.kubernetes.api.specs.items.virtualmachinedisksnapshot.Lifecycle;
import com.github.kubesys.kubernetes.api.specs.items.virtualmachinedisksnapshot.Volume;

/**
 * @author wuheng@iscas.ac.cn
 * 
 * @version 2.0.0
 * @since   2022.9.28
 **/
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
