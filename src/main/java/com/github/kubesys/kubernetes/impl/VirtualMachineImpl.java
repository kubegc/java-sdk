/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import java.util.HashMap;
import java.util.Map;

import com.github.kubesys.kubernetes.ExtendedKubernetesConstants;
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

/**
 * @author  wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.0.0
 * @since   2019/9/1
 **/
public class VirtualMachineImpl extends AbstractImpl<VirtualMachine, VirtualMachineList, VirtualMachineSpec> {


	@Override
	public VirtualMachine getModel() {
		return new VirtualMachine();
	}

	@Override
	public VirtualMachineSpec getSpec() {
		return new VirtualMachineSpec();
	}

	@Override
	public Object getLifecycle() {
		return new Lifecycle();
	}

	@Override
	public VirtualMachineSpec getSpec(VirtualMachine r) {
		return r.getSpec();
	}

	/**
	 * @param name  name
	 * @throws Exception exception
	 */
	public boolean setHA(String name) throws Exception {
		return this.addTag(name, ExtendedKubernetesConstants.LABEL_VM_HA, String.valueOf(true));
	}
	
	/**
	 * @param name  name
	 * @throws Exception exception
	 */
	public boolean unsetHA(String name) throws Exception {
		return deleteTag(name, ExtendedKubernetesConstants.LABEL_VM_HA);
	}


	/*************************************************
	 * 
	 * Generated
	 * 
	 **************************************************/
	// -----------------------------------------------------------------

	public boolean createAndStartVMFromISO(String name, CreateAndStartVMFromISO createAndStartVMFromISO)
			throws Exception {
		return createAndStartVMFromISO(name, null, createAndStartVMFromISO);
	}

	public boolean createAndStartVMFromISO(String name, String nodeName,
			CreateAndStartVMFromISO createAndStartVMFromISO) throws Exception {
		return createAndStartVMFromISO(name, nodeName, createAndStartVMFromISO, null);
	}
	
	public boolean createAndStartVMFromISO(String name, CreateAndStartVMFromISO createAndStartVMFromISO, String eventId)
			throws Exception {
		return createAndStartVMFromISO(name, null, createAndStartVMFromISO, eventId);
	}

	public boolean createAndStartVMFromISO(String name, String nodeName,
			CreateAndStartVMFromISO createAndStartVMFromISO, String eventId) throws Exception {
		return create(getModel(), createMetadata(name, nodeName, eventId), 
				createSpec(nodeName, createLifecycle(createAndStartVMFromISO)));
	}

	public boolean createAndStartVMFromImage(String name, CreateAndStartVMFromImage createAndStartVMFromImage, String eventId)
			throws Exception {
		return createAndStartVMFromImage(name, null, createAndStartVMFromImage, eventId);
	}

	public boolean createAndStartVMFromImage(String name, CreateAndStartVMFromImage createAndStartVMFromImage)
			throws Exception {
		return createAndStartVMFromImage(name, null, createAndStartVMFromImage, null);
	}

	public boolean createAndStartVMFromImage(String name, String nodeName,
			CreateAndStartVMFromImage createAndStartVMFromImage) throws Exception {
		return createAndStartVMFromImage(name, nodeName, createAndStartVMFromImage, null);
	}
	
	public boolean createAndStartVMFromImage(String name, String nodeName,
			CreateAndStartVMFromImage createAndStartVMFromImage, String eventId) throws Exception {
		return create(getModel(), createMetadata(name, nodeName, eventId), 
				createSpec(nodeName, createLifecycle(createAndStartVMFromImage)));
	}

	public boolean convertVMToImage(String name, ConvertVMToImage convertVMToImage, String eventId) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setConvertVMToImage(convertVMToImage);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("convertVMToImage ", kind);
		return true;
	}

	public boolean startVM(String name, StartVM startVM, String eventId) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setStartVM(startVM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("startVM ", kind);
		return true;
	}

	public boolean stopVM(String name, StopVM stopVM, String eventId) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setStopVM(stopVM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("stopVM ", kind);
		return true;
	}

	public boolean stopVMForce(String name, StopVMForce stopVMForce, String eventId) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setStopVMForce(stopVMForce);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("stopVMForce ", kind);
		return true;
	}

	public boolean deleteVM(String name, DeleteVM deleteVM, String eventId) throws Exception {
		VirtualMachine kind = get(name);
		
		if (kind == null) {
			return true;
		}
		
		if (kind.getSpec().getLifecycle() != null) {
			delete(kind);
			return true;
		}
		
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setDeleteVM(deleteVM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update(DeleteVM.class.getSimpleName(), kind);
//		delete(kind);
		return true;
	}

	public boolean temporaryDeleteVM(String name, DeleteVM deleteVM, String eventId) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		kind.getMetadata().getLabels().put("type", "deleted");
		update(DeleteVM.class.getSimpleName(), kind);
		return stopVM(name, new StopVM());
	}

	public boolean rebootVM(String name, RebootVM rebootVM, String eventId) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setRebootVM(rebootVM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("rebootVM ", kind);
		return true;
	}

	public boolean resetVM(String name, ResetVM resetVM, String eventId) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setResetVM(resetVM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("resetVM ", kind);
		return true;
	}

	public boolean resumeVM(String name, ResumeVM resumeVM, String eventId) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setResumeVM(resumeVM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("resumeVM ", kind);
		return true;
	}

	public boolean suspendVM(String name, SuspendVM suspendVM, String eventId) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setSuspendVM(suspendVM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("suspendVM ", kind);
		return true;
	}

	public boolean saveVM(String name, SaveVM saveVM, String eventId) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setSaveVM(saveVM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("saveVM ", kind);
		return true;
	}

	public boolean restoreVM(String name, RestoreVM restoreVM, String eventId) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setRestoreVM(restoreVM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("restoreVM ", kind);
		return true;
	}

	public boolean migrateVM(String name, MigrateVM migrateVM, String eventId) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setMigrateVM(migrateVM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("migrateVM ", kind);
		return true;
	}

	public boolean manageISO(String name, ManageISO manageISO, String eventId) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setManageISO(manageISO);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("manageISO ", kind);
		return true;
	}

	public boolean updateOS(String name, UpdateOS updateOS, String eventId) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setUpdateOS(updateOS);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("updateOS ", kind);
		return true;
	}

	public boolean plugDevice(String name, PlugDevice plugDevice, String eventId) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setPlugDevice(plugDevice);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("plugDevice ", kind);
		return true;
	}

	public boolean unplugDevice(String name, UnplugDevice unplugDevice, String eventId) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setUnplugDevice(unplugDevice);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("unplugDevice ", kind);
		return true;
	}

	public boolean plugDisk(String name, PlugDisk plugDisk, String eventId) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setPlugDisk(plugDisk);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("plugDisk ", kind);
		return true;
	}

	public boolean unplugDisk(String name, UnplugDisk unplugDisk, String eventId) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setUnplugDisk(unplugDisk);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("unplugDisk ", kind);
		return true;
	}

	public boolean plugNIC(String name, PlugNIC plugNIC, String eventId) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setPlugNIC(plugNIC);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("plugNIC ", kind);
		return true;
	}

	public boolean unplugNIC(String name, UnplugNIC unplugNIC, String eventId) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setUnplugNIC(unplugNIC);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("unplugNIC ", kind);
		return true;
	}

	public boolean changeNumberOfCPU(String name, ChangeNumberOfCPU changeNumberOfCPU, String eventId) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setChangeNumberOfCPU(changeNumberOfCPU);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("changeNumberOfCPU ", kind);
		return true;
	}

	public boolean resizeRAM(String name, ResizeRAM resizeRAM, String eventId) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setResizeRAM(resizeRAM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("resizeRAM", kind);
		return true;
	}
	// ----------------------------------------------------------------

	

	

	public boolean convertVMToImage(String name, ConvertVMToImage convertVMToImage) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setConvertVMToImage(convertVMToImage);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("convertVMToImage ", kind);
		return true;
	}

	public boolean startVM(String name, StartVM startVM) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setStartVM(startVM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("startVM ", kind);
		return true;
	}

	public boolean stopVM(String name, StopVM stopVM) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setStopVM(stopVM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("stopVM ", kind);
		return true;
	}

	public boolean stopVMForce(String name, StopVMForce stopVMForce) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setStopVMForce(stopVMForce);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("stopVMForce ", kind);
		return true;
	}

	public boolean deleteVM(String name, DeleteVM deleteVM) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null) {
			return true;
		}
		
		if (kind.getSpec().getDomain() == null) {
			delete(kind);
			return true;
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setDeleteVM(deleteVM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update(DeleteVM.class.getSimpleName(), kind);
//		delete(kind);
		return true;
	}

	public boolean temporaryDeleteVM(String name, DeleteVM deleteVM) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		kind.getMetadata().getLabels().put("type", "deleted");
		update(DeleteVM.class.getSimpleName(), kind);
		return stopVM(name, new StopVM());
	}

	public boolean rebootVM(String name, RebootVM rebootVM) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setRebootVM(rebootVM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("rebootVM ", kind);
		return true;
	}

	public boolean resetVM(String name, ResetVM resetVM) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setResetVM(resetVM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("resetVM ", kind);
		return true;
	}

	public boolean resumeVM(String name, ResumeVM resumeVM) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setResumeVM(resumeVM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("resumeVM ", kind);
		return true;
	}

	public boolean suspendVM(String name, SuspendVM suspendVM) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setSuspendVM(suspendVM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("suspendVM ", kind);
		return true;
	}

	public boolean saveVM(String name, SaveVM saveVM) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setSaveVM(saveVM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("saveVM ", kind);
		return true;
	}

	public boolean restoreVM(String name, RestoreVM restoreVM) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setRestoreVM(restoreVM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("restoreVM ", kind);
		return true;
	}

	public boolean migrateVM(String name, MigrateVM migrateVM) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setMigrateVM(migrateVM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("migrateVM ", kind);
		return true;
	}

	public boolean manageISO(String name, ManageISO manageISO) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setManageISO(manageISO);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("manageISO ", kind);
		return true;
	}

	public boolean updateOS(String name, UpdateOS updateOS) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setUpdateOS(updateOS);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("updateOS ", kind);
		return true;
	}

	public boolean plugDevice(String name, PlugDevice plugDevice) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setPlugDevice(plugDevice);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("plugDevice ", kind);
		return true;
	}

	public boolean unplugDevice(String name, UnplugDevice unplugDevice) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setUnplugDevice(unplugDevice);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("unplugDevice ", kind);
		return true;
	}

	public boolean plugDisk(String name, PlugDisk plugDisk) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setPlugDisk(plugDisk);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("plugDisk ", kind);
		return true;
	}

	public boolean unplugDisk(String name, UnplugDisk unplugDisk) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setUnplugDisk(unplugDisk);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("unplugDisk ", kind);
		return true;
	}

	public boolean plugNIC(String name, PlugNIC plugNIC) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setPlugNIC(plugNIC);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("plugNIC ", kind);
		return true;
	}

	public boolean unplugNIC(String name, UnplugNIC unplugNIC) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setUnplugNIC(unplugNIC);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("unplugNIC ", kind);
		return true;
	}

	public boolean changeNumberOfCPU(String name, ChangeNumberOfCPU changeNumberOfCPU) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setChangeNumberOfCPU(changeNumberOfCPU);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("changeNumberOfCPU ", kind);
		return true;
	}

	public boolean resizeRAM(String name, ResizeRAM resizeRAM) throws Exception {
		VirtualMachine kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachine" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setResizeRAM(resizeRAM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("resizeRAM", kind);
		return true;
	}
}
