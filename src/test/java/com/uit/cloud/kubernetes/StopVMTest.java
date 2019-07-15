/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.VirtualMachine;
import com.github.kubesys.kubernetes.api.model.VirtualMachineSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CreateAndStartVMFromISO;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StopVM;

import io.fabric8.kubernetes.api.model.ObjectMeta;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/15
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class StopVMTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.stopVM("skywind", new StopVM());
		System.out.println(successful);
	}
	
	
	public static VirtualMachine stopVM(String name) throws Exception {
		VirtualMachine vm = AbstractTest.getVMByName(name);
		VirtualMachineSpec spec= vm.getSpec();
		{
			Lifecycle lifecycle = new Lifecycle();
			StopVM stopVM = new StopVM();
			lifecycle.setStopVM(stopVM);
			spec.setLifecycle(lifecycle );
			vm.setSpec(spec );
		}
		return vm;
	}
	
}
