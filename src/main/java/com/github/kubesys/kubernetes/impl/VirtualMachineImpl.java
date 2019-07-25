/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.VirtualMachine;
import com.github.kubesys.kubernetes.api.model.VirtualMachineList;
import com.github.kubesys.kubernetes.api.model.VirtualMachineSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ChangeNumberOfCPU;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ConvertVMToImage;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CreateAndStartVMFromISO;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CreateAndStartVMFromImage;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.DeleteVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ManageISO;
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
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UpdateOS;

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
	
	
	/**
	 * m_logger
	 */
	protected final static Logger m_logger = Logger.getLogger(VirtualMachineImpl.class.getName());
	
	/**
	 * client
	 */
	@SuppressWarnings("rawtypes")
	protected final MixedOperation client = ExtendedKubernetesClient
			.crdClients.get(VirtualMachine.class.getSimpleName());;
	
	
	/**
	 * support commands
	 */
	public static List<String> cmds = new ArrayList<String>();
	
	static {
		cmds.add("createAndStartVMFromISO");
		cmds.add("createAndStartVMFromImage");
		cmds.add("convertVMToImage");
		cmds.add("startVM");
		cmds.add("stopVM");
		cmds.add("stopVMForce");
		cmds.add("deleteVM");
		cmds.add("rebootVM");
		cmds.add("resetVM");
		cmds.add("resumeVM");
		cmds.add("suspendVM");
		cmds.add("saveVM");
		cmds.add("restoreVM");
		cmds.add("migrateVM");
		cmds.add("manageISO");
		cmds.add("updateOS");
		cmds.add("plugDevice");
		cmds.add("unplugDevice");
		cmds.add("plugDisk");
		cmds.add("unplugDisk");
		cmds.add("plugNIC");
		cmds.add("unplugNIC");
		cmds.add("changeNumberOfCPU");
		cmds.add("resizeRAM");
	}
	
	/*************************************************
	 * 
	 *                   Core 
	 * 
	 **************************************************/
	
	/**
	 * return true or an exception
	 * 
	 * @param vm           VM's description
	 * @return             true or an exception
	 * @throws Exception   create VM fail
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	public boolean create(VirtualMachine vm) throws Exception {
		client.create(vm);
		m_logger.log(Level.INFO, "create VirtualMachine " 
				+ vm.getMetadata().getName() + " successful.") ;
		return true;
	}
	
	/**
	 * @param vm            VM's description
	 * @return              true or an exception
	 * @throws Exception    delete VM fail
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	public boolean delete(VirtualMachine vm) throws Exception {
		client.delete(vm);
		m_logger.log(Level.INFO, "delete VirtualMachine " 
				+ vm.getMetadata().getName() + " successful.") ;
		return true;
	}
	
	/**
	 * @param vm            VM's description
	 * @return              true or an exception
	 * @throws Exception    update VM fail
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	public boolean update(VirtualMachine vm) throws Exception {
		client.createOrReplace(vm);
		m_logger.log(Level.INFO, "update VirtualMachine " 
				+ vm.getMetadata().getName() + " successful.") ;
		return true;
	}
	
	/**
	 * @param operator      operator
	 * @param vm            VM's description
	 * @return              true or an exception
	 * @throws Exception    update VM fail
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	protected boolean update(String operator, VirtualMachine vm) throws Exception {
		client.createOrReplace(vm);
		m_logger.log(Level.INFO, operator + " " + 
				vm.getMetadata().getName() + " successful.") ;
		return true;
	}
	
	/**
	 * return an object or null
	 * 
	 * @param name     .metadata.name
	 * @return         object or null
	 */
	@SuppressWarnings("unchecked")
	public VirtualMachine get(String name) {
		return ((Gettable<VirtualMachine>) 
				client.withName(name)).get();
	}
	
	/**
	 * @return list all virtual machines or null
	 */
	public VirtualMachineList list() {
		return (VirtualMachineList) client.list();
	}
	
	/**
	 * list all VMs with the specified labels 
	 * 
	 * @param filter    .metadata.labels
	 * @return          all VMs or null
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public VirtualMachineList list(Map<String, String> labels) {
		return (VirtualMachineList)((FilterWatchListDeletable) 
				client.withLabels(labels)).list();
	}
	
	
	/**
	 * @param name        name
	 * @param key         key
	 * @param value       value
	 * @throws Exception   exception
	 */
	public void addTag(String name, String key, String value) throws Exception {
		
		if (key.equals("host")) {
			m_logger.log(Level.SEVERE, "'host' is a keyword.");
			return;
		}
		
		VirtualMachine vm = get(name);
		if (vm == null) {
			m_logger.log(Level.SEVERE, "VM " + name + " not exist.");
			return;
		}
		
		Map<String, String> tags = vm.getMetadata().getLabels();
		tags = (tags == null) ? new HashMap<String, String>() : tags;
		tags.put(key, value);
		update(vm);
	}
	
/**
 * @param name     name
 * @param key      key
 * @throws Exception exception
 */
public void deleteTag(String name, String key) throws Exception {
		
		if (key.equals("host")) {
			m_logger.log(Level.SEVERE, "'host' is a keyword.");
			return;
		}
		
		VirtualMachine vm = get(name);
		if (vm == null) {
			m_logger.log(Level.SEVERE, "VM " + name + " not exist.");
			return;
		}
		
		Map<String, String> tags = vm.getMetadata().getLabels();
		if (tags != null) {
			tags.remove(key);
		}
		update(vm);
	}
	
	/*************************************************
	 * 
	 *                   Generated
	 * 
	 **************************************************/
	//-----------------------------------------------------------------
	
	public boolean createAndStartVMFromISO (String name, CreateAndStartVMFromISO  createAndStartVMFromISO ) throws Exception {
		return createAndStartVMFromISO(name, null, createAndStartVMFromISO);
	}
	
	public boolean createAndStartVMFromISO (String name, String nodeName, CreateAndStartVMFromISO  createAndStartVMFromISO ) throws Exception {
		VirtualMachine kind = new VirtualMachine();
		kind.setApiVersion("cloudplus.io/v1alpha3");
		kind.setKind("VirtualMachine");
		VirtualMachineSpec spec = new VirtualMachineSpec();
		ObjectMeta om = new ObjectMeta();
		if (nodeName != null) {
			Map<String, String> labels = new HashMap<String, String>();
			labels.put("host", nodeName);
			labels.put("type", "normal");
			om.setLabels(labels );
			spec.setNodeName(nodeName);
		}
		om.setName(name);
		kind.setMetadata(om);
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setCreateAndStartVMFromISO (createAndStartVMFromISO );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		create(kind );
		return true;
	}


	public boolean createAndStartVMFromImage (String name, CreateAndStartVMFromImage  createAndStartVMFromImage ) throws Exception {
		return createAndStartVMFromImage(name, null, createAndStartVMFromImage);
	}
	
	public boolean createAndStartVMFromImage (String name, String nodeName, CreateAndStartVMFromImage  createAndStartVMFromImage ) throws Exception {
		VirtualMachine kind = new VirtualMachine();
		kind.setApiVersion("cloudplus.io/v1alpha3");
		kind.setKind("VirtualMachine");
		VirtualMachineSpec spec = new VirtualMachineSpec();
		ObjectMeta om = new ObjectMeta();
		om.setName(name);
		if (nodeName != null) {
			Map<String, String> labels = new HashMap<String, String>();
			labels.put("host", nodeName);
			labels.put("type", "normal");
			om.setLabels(labels );
			spec.setNodeName(nodeName);
		}
		kind.setMetadata(om);
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setCreateAndStartVMFromImage (createAndStartVMFromImage );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		create(kind );
		return true;
	}

	public boolean convertVMToImage (String name, ConvertVMToImage  convertVMToImage ) throws Exception {
		VirtualMachine kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setConvertVMToImage (convertVMToImage );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("convertVMToImage " , kind );
		return true;
	}


	public boolean startVM (String name, StartVM  startVM ) throws Exception {
		VirtualMachine kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setStartVM (startVM );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("startVM " , kind );
		return true;
	}


	public boolean stopVM (String name, StopVM  stopVM ) throws Exception {
		VirtualMachine kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setStopVM (stopVM );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("stopVM " , kind );
		return true;
	}


	public boolean stopVMForce (String name, StopVMForce  stopVMForce ) throws Exception {
		VirtualMachine kind = get(name);
		if(kind == null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setStopVMForce (stopVMForce );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("stopVMForce " , kind );
		return true;
	}


	public boolean deleteVM (String name, DeleteVM  deleteVM ) throws Exception {
		VirtualMachine kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			delete(kind);
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setDeleteVM (deleteVM );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update(kind );
		delete(kind );
		return true;
	}
	
	public boolean temporaryDeleteVM (String name, DeleteVM  deleteVM ) throws Exception {
		VirtualMachine kind = get(name);
		if(kind == null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		kind.getMetadata().getLabels().put("type", "deleted");
		update(kind);
		return stopVM(name, new StopVM());
	}


	public boolean rebootVM (String name, RebootVM  rebootVM ) throws Exception {
		VirtualMachine kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setRebootVM (rebootVM );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("rebootVM " , kind );
		return true;
	}


	public boolean resetVM (String name, ResetVM  resetVM ) throws Exception {
		VirtualMachine kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setResetVM (resetVM );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("resetVM " , kind );
		return true;
	}


	public boolean resumeVM (String name, ResumeVM  resumeVM ) throws Exception {
		VirtualMachine kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setResumeVM (resumeVM );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("resumeVM " , kind );
		return true;
	}


	public boolean suspendVM (String name, SuspendVM  suspendVM ) throws Exception {
		VirtualMachine kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setSuspendVM (suspendVM );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("suspendVM " , kind );
		return true;
	}


	public boolean saveVM (String name, SaveVM  saveVM ) throws Exception {
		VirtualMachine kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setSaveVM (saveVM );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("saveVM " , kind );
		return true;
	}


	public boolean restoreVM (String name, RestoreVM  restoreVM ) throws Exception {
		VirtualMachine kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setRestoreVM (restoreVM );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("restoreVM " , kind );
		return true;
	}


	public boolean migrateVM (String name, MigrateVM  migrateVM ) throws Exception {
		VirtualMachine kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setMigrateVM (migrateVM );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("migrateVM " , kind );
		return true;
	}


	public boolean manageISO (String name, ManageISO  manageISO ) throws Exception {
		VirtualMachine kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setManageISO (manageISO );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("manageISO " , kind );
		return true;
	}


	public boolean updateOS (String name, UpdateOS  updateOS ) throws Exception {
		VirtualMachine kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setUpdateOS (updateOS );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("updateOS " , kind );
		return true;
	}


	public boolean plugDevice (String name, PlugDevice  plugDevice ) throws Exception {
		VirtualMachine kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setPlugDevice (plugDevice );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("plugDevice " , kind );
		return true;
	}


	public boolean unplugDevice (String name, UnplugDevice  unplugDevice ) throws Exception {
		VirtualMachine kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setUnplugDevice (unplugDevice );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("unplugDevice " , kind );
		return true;
	}


	public boolean plugDisk (String name, PlugDisk  plugDisk ) throws Exception {
		VirtualMachine kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setPlugDisk (plugDisk );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("plugDisk " , kind );
		return true;
	}


	public boolean unplugDisk (String name, UnplugDisk  unplugDisk ) throws Exception {
		VirtualMachine kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setUnplugDisk (unplugDisk );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("unplugDisk " , kind );
		return true;
	}


	public boolean plugNIC (String name, PlugNIC  plugNIC ) throws Exception {
		VirtualMachine kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setPlugNIC (plugNIC );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("plugNIC " , kind );
		return true;
	}


	public boolean unplugNIC (String name, UnplugNIC  unplugNIC ) throws Exception {
		VirtualMachine kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setUnplugNIC (unplugNIC );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("unplugNIC " , kind );
		return true;
	}


	public boolean changeNumberOfCPU (String name, ChangeNumberOfCPU  changeNumberOfCPU ) throws Exception {
		VirtualMachine kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setChangeNumberOfCPU (changeNumberOfCPU );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("changeNumberOfCPU " , kind );
		return true;
	}


	public boolean resizeRAM(String name, ResizeRAM resizeRAM) throws Exception {
		VirtualMachine kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setResizeRAM(resizeRAM);
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("resizeRAM" , kind );
		return true;
	}
	//----------------------------------------------------------------
	
}

