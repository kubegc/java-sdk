/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.specs;

import com.github.kubesys.kubernetes.api.KubeStackSpec;
import com.github.kubesys.kubernetes.api.specs.items.virtualmachinesnapshot.Domainsnapshot;
import com.github.kubesys.kubernetes.api.specs.items.virtualmachinesnapshot.Lifecycle;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.2.0
 * @since   2019/9/4
 * 
 **/
public class VirtualMachineSnapshotSpec extends KubeStackSpec {


	protected Domainsnapshot domainsnapshot;
	
	protected Lifecycle lifecycle;
	
	public VirtualMachineSnapshotSpec() {

	}

	public Domainsnapshot getDomainsnapshot() {
		return domainsnapshot;
	}

	public void setDomainsnapshot(Domainsnapshot domainsnapshot) {
		this.domainsnapshot = domainsnapshot;
	}

	public Lifecycle getLifecycle() {
		return lifecycle;
	}

	public void setLifecycle(Lifecycle lifecycle) {
		this.lifecycle = lifecycle;
	}

}
