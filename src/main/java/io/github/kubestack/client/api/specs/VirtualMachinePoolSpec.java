/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.client.api.specs;

import io.github.kubestack.client.api.specs.virtualmachinepool.Lifecycle;
import io.github.kubestack.client.api.specs.virtualmachinepool.Pool;

/**
 * @author wuheng@iscas.ac.cn
 * 
 * @version 2.0.0
 * @since   2022.9.28
 **/
public class VirtualMachinePoolSpec extends KubeStackSpec {

	protected Pool pool;

	protected Lifecycle lifecycle;
	
	public VirtualMachinePoolSpec() {

	}

	public Pool getPool() {
		return pool;
	}

	public void setPool(Pool pool) {
		this.pool = pool;
	}

	public Lifecycle getLifecycle() {
		return lifecycle;
	}

	public void setLifecycle(Lifecycle lifecycle) {
		this.lifecycle = lifecycle;
	}

}
