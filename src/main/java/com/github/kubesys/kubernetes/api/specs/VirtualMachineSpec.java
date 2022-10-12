/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.specs;

import com.github.kubesys.kubernetes.api.KubeStackSpec;
import com.github.kubesys.kubernetes.api.specs.items.virtualmachine.Domain;
import com.github.kubesys.kubernetes.api.specs.items.virtualmachine.Lifecycle;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.2.0
 * @since   2019/9/4
 *
 * <p>
 * <code>ExtendedKubernetesClient<code> extends <code>DefaultKubernetesClient<code>
 * to provide the lifecycle of VirtualMachine, VirtualMachinePool, VirtualMachineDisk,
 * VirtualMachineImage, VirtualMachineSnapshot, VirtualMachineNetwork
 * 
 */
public class VirtualMachineSpec extends KubeStackSpec {


	protected Domain domain;

	protected Lifecycle lifecycle;
	
	protected String powerstate;
	
	public VirtualMachineSpec() {

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

	public String getPowerstate() {
		return powerstate;
	}

	public void setPowerstate(String powerstate) {
		this.powerstate = powerstate;
	}
	
}
