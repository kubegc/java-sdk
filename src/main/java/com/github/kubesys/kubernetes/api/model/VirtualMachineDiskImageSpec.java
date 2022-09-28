/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model;

import com.github.kubesys.kubernetes.api.model.KubeModel.AbstractSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachinediskimage.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachinediskimage.Volume;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.2.0
 * @since   2019/9/4
 **/
public class VirtualMachineDiskImageSpec extends AbstractSpec {


	protected Volume volume;

	protected Lifecycle lifecycle;
	
	public VirtualMachineDiskImageSpec() {

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
