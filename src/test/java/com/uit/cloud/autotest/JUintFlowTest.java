/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.autotest;

import java.util.ArrayList;
import java.util.List;

import com.github.kubesys.henry.AbstractTest;
import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.VirtualMachine;
import com.github.kubesys.kubernetes.api.model.VirtualMachineDisk;
import com.github.kubesys.kubernetes.api.model.VirtualMachineSnapshot;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ChangeNumberOfCPU;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CreateAndStartVMFromISO;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.DeleteVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.EjectISO;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.InsertISO;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.PlugDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ResizeRAM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StartVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StopVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StopVMForce;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UnplugDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UpdateOS;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CloneDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CreateDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CreateDiskSnapshot;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.DeleteDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.DeleteDiskSnapshot;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.ResizeDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Lifecycle.CreateSnapshot;
import com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Lifecycle.DeleteSnapshot;

/**
 * @author  wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/4
 * 
 **/
public class JUintFlowTest {
	
	public final static String VM_PREFIX = "vm.";
	
	public final static String VMI_PREFIX = "vm.";
	
	public final static String VMD_PREFIX = "vmd.";
	
	public final static String VMDI_PREFIX = "vmi.";
	
	public final static String VMP_PREFIX = "vmp.";

	public final static List<String> storageTests = new ArrayList<String>();
	
	public final static List<String> networkTests = new ArrayList<String>();
	
	public final static List<String> computeTests = new ArrayList<String>();
	
	
	static {
		computeTests.add(VirtualMachine.class.getSimpleName() + "=" + CreateAndStartVMFromISO.class.getName());
		computeTests.add(VirtualMachine.class.getSimpleName() + "=" + StopVM.class.getName());
		computeTests.add(VirtualMachine.class.getSimpleName() + "=" + StopVMForce.class.getName());
		computeTests.add(VirtualMachine.class.getSimpleName() + "=" + UpdateOS.class.getName());
		computeTests.add(VirtualMachine.class.getSimpleName() + "=" + StartVM.class.getName());
		computeTests.add(VirtualMachine.class.getSimpleName() + "=" + ChangeNumberOfCPU.class.getName());
		computeTests.add(VirtualMachine.class.getSimpleName() + "=" + ResizeRAM.class.getName());
		computeTests.add(VirtualMachine.class.getSimpleName() + "=" + InsertISO.class.getName());
		computeTests.add(VirtualMachine.class.getSimpleName() + "=" + EjectISO.class.getName());
		computeTests.add(VirtualMachineSnapshot.class.getSimpleName() + "=" + CreateSnapshot.class.getName());
		computeTests.add(VirtualMachineSnapshot.class.getSimpleName() + "=" + DeleteSnapshot.class.getName());
		computeTests.add(VirtualMachineDisk.class.getSimpleName() + "=" + CreateDisk.class.getName());
		computeTests.add(VirtualMachineDisk.class.getSimpleName() + "=" + ResizeDisk.class.getName());
		computeTests.add(VirtualMachine.class.getSimpleName() + "=" + PlugDisk.class.getName());
		computeTests.add(VirtualMachineDisk.class.getSimpleName() + "=" + CreateDiskSnapshot.class.getName());
		computeTests.add(VirtualMachineDisk.class.getSimpleName() + "=" + DeleteDiskSnapshot.class.getName());
		computeTests.add(VirtualMachine.class.getSimpleName() + "=" + UnplugDisk.class.getName());
		computeTests.add(VirtualMachine.class.getSimpleName() + "=" + CloneDisk.class.getName());
		computeTests.add(VirtualMachine.class.getSimpleName() + "=" + DeleteDisk.class.getName());
		computeTests.add(VirtualMachine.class.getSimpleName() + "=" + DeleteVM.class.getName());
	}
	
	protected final ExtendedKubernetesClient client;
	
	public JUintFlowTest() throws Exception {
		this.client = AbstractTest.getClient();
	}

	
	public void start() {
	}
	
	public static void main(String[] args) {
		
	}
}
