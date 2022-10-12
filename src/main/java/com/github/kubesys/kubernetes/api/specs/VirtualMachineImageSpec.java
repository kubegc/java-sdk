/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.specs;

import com.github.kubesys.kubernetes.api.KubeStackSpec;
import com.github.kubesys.kubernetes.api.specs.items.virtualmachine.Domain;
import com.github.kubesys.kubernetes.api.specs.items.virtualmachineimage.Lifecycle;

/**
 * @author wuheng@iscas.ac.cn
 * 
 * @version 2.0.0
 * @since   2022.9.28
 **/
public class VirtualMachineImageSpec extends KubeStackSpec {


	protected Domain domain;

	protected Lifecycle lifecycle;
	
	public VirtualMachineImageSpec() {

	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public Lifecycle getLifecycle() {
		return lifecycle;
	}

	public void setLifecycle(Lifecycle lifecycle) {
		this.lifecycle = lifecycle;
	}

}
