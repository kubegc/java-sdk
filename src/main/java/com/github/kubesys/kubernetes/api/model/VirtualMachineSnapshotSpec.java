/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model;

import com.github.kubesys.kubernetes.api.model.KubeModel.AbstractSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Domainsnapshot;
import com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Lifecycle;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.2.0
 * @since   2019/9/4
 * 
 **/
public class VirtualMachineSnapshotSpec extends AbstractSpec {


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
