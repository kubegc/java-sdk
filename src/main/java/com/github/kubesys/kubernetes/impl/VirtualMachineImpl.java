/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.github.kubesys.kubernetes.api.model.VirtualMachine;
import com.github.kubesys.kubernetes.api.model.VirtualMachineList;
import com.github.kubesys.kubernetes.api.model.VirtualMachineSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ChangeNumberOfCPU;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ConvertVMToImage;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CreateAndStartVMFromISO;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CreateAndStartVMFromImage;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CreateVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.DeleteVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.MigrateVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.PlugDevice;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.PlugDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.PlugNIC;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.RebootVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ResetVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ResizeRAM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.RestoreVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ResumeVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.SaveVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StartVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StopVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StopVMForce;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.SuspendVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UnplugDevice;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UnplugDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UnplugNIC;

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeletable;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author xuyuanjia2017@otcaix.iscas.ac.cn
 * @author xianghao16@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @since Thu Jun 13 21:39:55 CST 2019
 **/
public class VirtualMachineImpl {
	
	@SuppressWarnings("rawtypes")
	protected final MixedOperation excutor;
	
	protected String name;
	
	protected static List<String> cmds = new ArrayList<String>();
	
	static {
		cmds.add("createAndStartVMFromISO ");
		cmds.add("createAndStartVMFromImage ");
		cmds.add("convertVMToImage ");
		cmds.add("createVM ");
		cmds.add("startVM ");
		cmds.add("stopVM ");
		cmds.add("stopVMForce ");
		cmds.add("deleteVM ");
		cmds.add("rebootVM ");
		cmds.add("resetVM ");
		cmds.add("resumeVM ");
		cmds.add("suspendVM ");
		cmds.add("saveVM ");
		cmds.add("restoreVM ");
		cmds.add("migrateVM ");
		cmds.add("plugDevice ");
		cmds.add("unplugDevice ");
		cmds.add("plugDisk ");
		cmds.add("unplugDisk ");
		cmds.add("plugNIC ");
		cmds.add("unplugNIC ");
		cmds.add("changeNumberOfCPU ");
		cmds.add("resizeRAM");
	}
	
	@SuppressWarnings("rawtypes")
	public VirtualMachineImpl(MixedOperation excutor) {
		super();
		this.excutor = excutor;
	}

	/**
	 * return true or an exception
	 * 
	 * @param vm   VM's description
	 * @return true or an exception
	 * @throws Exception create VM fail
	 */
	@SuppressWarnings("unchecked")
	public boolean create(VirtualMachine vm) throws Exception {
		excutor.create(vm);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public boolean delete(VirtualMachine vm) throws Exception {
		excutor.delete(vm);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public boolean update(VirtualMachine vm) throws Exception {
		String name = vm.getMetadata().getName();
		VirtualMachine vmn = get(name);
		if (vmn == null) {
			throw new Exception("VM " + name + " does not exist.");
		}
		excutor.createOrReplace(vm);
		return true;
	}
	
	/**
	 * return an object or null
	 * 
	 * @param name it is .metadata.name
	 * @return object or null
	 */
	@SuppressWarnings("unchecked")
	public VirtualMachine get(String name) {
		return ((Gettable<VirtualMachine>) 
				excutor.withName(name)).get();
	}
	
	/**
	 * @return list virtual machines
	 */
	public VirtualMachineList list() {
		return (VirtualMachineList) excutor.list();
	}
	
	/**
	 * list all VMs with the specified labels 
	 * 
	 * @param filter see .metadata.labels
	 * @return all VMs
	 */
	public VirtualMachineList list(Map<String, String> labels) {
		return (VirtualMachineList)((FilterWatchListDeletable) 
				excutor.withLabels(labels)).list();
	}
	
	//-----------------------------------------------------------------
	
	public boolean createAndStartVMFromISO (String name, CreateAndStartVMFromISO  createAndStartVMFromISO ) throws Exception {
		VirtualMachine vm = new VirtualMachine();
		vm.setApiVersion("cloudplus.io/v1alpha3");
		vm.setKind("VirtualMachine");
		ObjectMeta om = new ObjectMeta();
		om.setName(name);
		vm.setMetadata(om);
		VirtualMachineSpec spec = new VirtualMachineSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setCreateAndStartVMFromISO (createAndStartVMFromISO );
		spec.setLifecycle(lifecycle );
		vm.setSpec(spec );
		create(vm );
		return true;
	}


	public boolean createAndStartVMFromImage (String name, CreateAndStartVMFromImage  createAndStartVMFromImage ) throws Exception {
		VirtualMachine vm = new VirtualMachine();
		vm.setApiVersion("cloudplus.io/v1alpha3");
		vm.setKind("VirtualMachine");
		ObjectMeta om = new ObjectMeta();
		om.setName(name);
		vm.setMetadata(om);
		VirtualMachineSpec spec = new VirtualMachineSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setCreateAndStartVMFromImage (createAndStartVMFromImage );
		spec.setLifecycle(lifecycle );
		vm.setSpec(spec );
		create(vm );
		return true;
	}


	public boolean convertVMToImage (String name, ConvertVMToImage  convertVMToImage ) throws Exception {
		VirtualMachine vm = get(name);
		if(vm == null || vm.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VM is not exist or ");
		}
		VirtualMachineSpec spec = new VirtualMachineSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setConvertVMToImage (convertVMToImage );
		spec.setLifecycle(lifecycle );
		vm.setSpec(spec );
		update(vm );
		return true;
	}


	public boolean createVM (CreateVM  createVM ) throws Exception {
		VirtualMachine vm = new VirtualMachine();
		vm.setApiVersion("cloudplus.io/v1alpha3");
		vm.setKind("VirtualMachine");
		VirtualMachineSpec spec = new VirtualMachineSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setCreateVM (createVM );
		spec.setLifecycle(lifecycle );
		vm.setSpec(spec );
		create(vm );
		return true;
	}


	public boolean startVM (String name, StartVM  startVM ) throws Exception {
		VirtualMachine vm = get(name);
		if(vm == null || vm.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VM is not exist or ");
		}
		VirtualMachineSpec spec = new VirtualMachineSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setStartVM (startVM );
		spec.setLifecycle(lifecycle );
		vm.setSpec(spec );
		update(vm );
		return true;
	}


	public boolean stopVM (String name, StopVM  stopVM ) throws Exception {
		VirtualMachine vm = get(name);
		if(vm == null || vm.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VM is not exist or ");
		}
		VirtualMachineSpec spec = new VirtualMachineSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setStopVM (stopVM );
		spec.setLifecycle(lifecycle );
		vm.setSpec(spec );
		update(vm );
		return true;
	}


	public boolean stopVMForce (String name, StopVMForce  stopVMForce ) throws Exception {
		VirtualMachine vm = get(name);
		if(vm == null || vm.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VM is not exist or ");
		}
		VirtualMachineSpec spec = new VirtualMachineSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setStopVMForce (stopVMForce );
		spec.setLifecycle(lifecycle );
		vm.setSpec(spec );
		update(vm );
		return true;
	}


	public boolean deleteVM (String name, DeleteVM  deleteVM ) throws Exception {
		VirtualMachine vm = get(name);
		if(vm == null || vm.getSpec().getLifecycle() != null) {
			delete(vm );
			return true;
		}
		VirtualMachineSpec spec = new VirtualMachineSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setDeleteVM (deleteVM );
		spec.setLifecycle(lifecycle );
		vm.setSpec(spec );
		delete(vm );
		return true;
	}


	public boolean rebootVM (String name, RebootVM  rebootVM ) throws Exception {
		VirtualMachine vm = get(name);
		if(vm == null || vm.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VM is not exist or ");
		}
		VirtualMachineSpec spec = new VirtualMachineSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setRebootVM (rebootVM );
		spec.setLifecycle(lifecycle );
		vm.setSpec(spec );
		update(vm );
		return true;
	}


	public boolean resetVM (String name, ResetVM  resetVM ) throws Exception {
		VirtualMachine vm = get(name);
		if(vm == null || vm.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VM is not exist or ");
		}
		VirtualMachineSpec spec = new VirtualMachineSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setResetVM (resetVM );
		spec.setLifecycle(lifecycle );
		vm.setSpec(spec );
		update(vm );
		return true;
	}


	public boolean resumeVM (String name, ResumeVM  resumeVM ) throws Exception {
		VirtualMachine vm = get(name);
		if(vm == null || vm.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VM is not exist or ");
		}
		VirtualMachineSpec spec = new VirtualMachineSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setResumeVM (resumeVM );
		spec.setLifecycle(lifecycle );
		vm.setSpec(spec );
		update(vm );
		return true;
	}


	public boolean suspendVM (String name, SuspendVM  suspendVM ) throws Exception {
		VirtualMachine vm = get(name);
		if(vm == null || vm.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VM is not exist or ");
		}
		VirtualMachineSpec spec = new VirtualMachineSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setSuspendVM (suspendVM );
		spec.setLifecycle(lifecycle );
		vm.setSpec(spec );
		update(vm );
		return true;
	}


	public boolean saveVM (String name, SaveVM  saveVM ) throws Exception {
		VirtualMachine vm = get(name);
		if(vm == null || vm.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VM is not exist or ");
		}
		VirtualMachineSpec spec = new VirtualMachineSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setSaveVM (saveVM );
		spec.setLifecycle(lifecycle );
		vm.setSpec(spec );
		update(vm );
		return true;
	}


	public boolean restoreVM (String name, RestoreVM  restoreVM ) throws Exception {
		VirtualMachine vm = get(name);
		if(vm == null || vm.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VM is not exist or ");
		}
		VirtualMachineSpec spec = new VirtualMachineSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setRestoreVM (restoreVM );
		spec.setLifecycle(lifecycle );
		vm.setSpec(spec );
		update(vm );
		return true;
	}


	public boolean migrateVM (String name, MigrateVM  migrateVM ) throws Exception {
		VirtualMachine vm = get(name);
		if(vm == null || vm.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VM is not exist or ");
		}
		VirtualMachineSpec spec = new VirtualMachineSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setMigrateVM (migrateVM );
		spec.setLifecycle(lifecycle );
		vm.setSpec(spec );
		update(vm );
		return true;
	}


	public boolean plugDevice (String name, PlugDevice  plugDevice ) throws Exception {
		VirtualMachine vm = get(name);
		if(vm == null || vm.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VM is not exist or ");
		}
		VirtualMachineSpec spec = new VirtualMachineSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setPlugDevice (plugDevice );
		spec.setLifecycle(lifecycle );
		vm.setSpec(spec );
		update(vm );
		return true;
	}


	public boolean unplugDevice (String name, UnplugDevice  unplugDevice ) throws Exception {
		VirtualMachine vm = get(name);
		if(vm == null || vm.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VM is not exist or ");
		}
		VirtualMachineSpec spec = new VirtualMachineSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setUnplugDevice (unplugDevice );
		spec.setLifecycle(lifecycle );
		vm.setSpec(spec );
		update(vm );
		return true;
	}


	public boolean plugDisk (String name, PlugDisk  plugDisk ) throws Exception {
		VirtualMachine vm = get(name);
		if(vm == null || vm.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VM is not exist or ");
		}
		VirtualMachineSpec spec = new VirtualMachineSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setPlugDisk (plugDisk );
		spec.setLifecycle(lifecycle );
		vm.setSpec(spec );
		update(vm );
		return true;
	}


	public boolean unplugDisk (String name, UnplugDisk  unplugDisk ) throws Exception {
		VirtualMachine vm = get(name);
		if(vm == null || vm.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VM is not exist or ");
		}
		VirtualMachineSpec spec = new VirtualMachineSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setUnplugDisk (unplugDisk );
		spec.setLifecycle(lifecycle );
		vm.setSpec(spec );
		update(vm );
		return true;
	}


	public boolean plugNIC (String name, PlugNIC  plugNIC ) throws Exception {
		VirtualMachine vm = get(name);
		if(vm == null || vm.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VM is not exist or ");
		}
		VirtualMachineSpec spec = new VirtualMachineSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setPlugNIC (plugNIC );
		spec.setLifecycle(lifecycle );
		vm.setSpec(spec );
		update(vm );
		return true;
	}


	public boolean unplugNIC (String name, UnplugNIC  unplugNIC ) throws Exception {
		VirtualMachine vm = get(name);
		if(vm == null || vm.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VM is not exist or ");
		}
		VirtualMachineSpec spec = new VirtualMachineSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setUnplugNIC (unplugNIC );
		spec.setLifecycle(lifecycle );
		vm.setSpec(spec );
		update(vm );
		return true;
	}


	public boolean changeNumberOfCPU (String name, ChangeNumberOfCPU  changeNumberOfCPU ) throws Exception {
		VirtualMachine vm = get(name);
		if(vm == null || vm.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VM is not exist or ");
		}
		VirtualMachineSpec spec = new VirtualMachineSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setChangeNumberOfCPU (changeNumberOfCPU );
		spec.setLifecycle(lifecycle );
		vm.setSpec(spec );
		update(vm );
		return true;
	}


	public boolean resizeRAM(String name, ResizeRAM resizeRAM) throws Exception {
		VirtualMachine vm = get(name);
		if(vm == null || vm.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VM is not exist or ");
		}
		VirtualMachineSpec spec = new VirtualMachineSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setResizeRAM(resizeRAM);
		spec.setLifecycle(lifecycle );
		vm.setSpec(spec );
		update(vm );
		return true;
	}


	//----------------------------------------------------------------
	public static void main(String[] args) {
		for (String cmd : cmds) {
			if (cmd.startsWith("create")) {
				System.out.println("\tpublic boolean " + cmd + "(" + getClassName(cmd) + " " + cmd +") throws Exception {");
				System.out.println("\t\tVirtualMachine vm = new VirtualMachine();");
				System.out.println("\t\tvm.setApiVersion(\"cloudplus.io/v1alpha3\");");
				System.out.println("\t\tvm.setKind(\"VirtualMachine\");");
				System.out.println("\t\tVirtualMachineSpec spec = new VirtualMachineSpec();");
				System.out.println("\t\tLifecycle lifecycle = new Lifecycle();");
				System.out.println("\t\tlifecycle.set" + getClassName(cmd) + "(" + cmd + ");");
				System.out.println("\t\tspec.setLifecycle(lifecycle );");
				System.out.println("\t\tvm.setSpec(spec );");
				System.out.println("\t\tcreate(vm );");
				System.out.println("\t\treturn true;");
			} else if (cmd.startsWith("delete")) {
				System.out.println("\tpublic boolean " + cmd + "(String name, " + getClassName(cmd) + " " + cmd +") throws Exception {");
				System.out.println("\t\tVirtualMachine vm = get(name);");
				System.out.println("\t\tif(vm == null || vm.getSpec().getLifecycle() != null) {");
				System.out.println("\t\t\tthrow new RuntimeException(\"VM is not exist or \");");
				System.out.println("\t\t}");
				System.out.println("\t\tVirtualMachineSpec spec = new VirtualMachineSpec();");
				System.out.println("\t\tLifecycle lifecycle = new Lifecycle();");
				System.out.println("\t\tlifecycle.set" + getClassName(cmd) + "(" + cmd + ");");
				System.out.println("\t\tspec.setLifecycle(lifecycle );");
				System.out.println("\t\tvm.setSpec(spec );");
				System.out.println("\t\tdelete(vm );");
				System.out.println("\t\treturn true;");
			} else {
				System.out.println("\tpublic boolean " + cmd + "(String name, " + getClassName(cmd) + " " + cmd +") throws Exception {");
				System.out.println("\t\tVirtualMachine vm = get(name);");
				System.out.println("\t\tif(vm == null || vm.getSpec().getLifecycle() != null) {");
				System.out.println("\t\t\tthrow new RuntimeException(\"VM is not exist or \");");
				System.out.println("\t\t}");
				System.out.println("\t\tVirtualMachineSpec spec = new VirtualMachineSpec();");
				System.out.println("\t\tLifecycle lifecycle = new Lifecycle();");
				System.out.println("\t\tlifecycle.set" + getClassName(cmd) + "(" + cmd + ");");
				System.out.println("\t\tspec.setLifecycle(lifecycle );");
				System.out.println("\t\tvm.setSpec(spec );");
				System.out.println("\t\tupdate(vm );");
				System.out.println("\t\treturn true;");
			}
			System.out.println("\t}\n\n");
		}
	}
	
	public static String getClassName(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}
}

