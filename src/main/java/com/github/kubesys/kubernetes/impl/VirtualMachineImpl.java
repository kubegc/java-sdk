/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;


import java.util.Map;
import java.util.regex.Pattern;

import com.github.kubesys.kubernetes.ExtendedKubernetesConstants;
import com.github.kubesys.kubernetes.api.model.VirtualMachine;
import com.github.kubesys.kubernetes.api.model.VirtualMachineList;
import com.github.kubesys.kubernetes.api.model.VirtualMachineSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.AddACL;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.BindFloatingIP;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ChangeNumberOfCPU;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CloneVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ConvertVMToImage;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CreateAndStartVMFromISO;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CreateAndStartVMFromImage;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.DeleteVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.DeprecatedACL;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.EjectISO;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.InsertISO;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ManageISO;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.MigrateVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ModifyACL;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ModifyQoS;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.PlugDevice;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.PlugDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.PlugNIC;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.RebootVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ResetVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ResizeMaxRAM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ResizeRAM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ResizeVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ResumeVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.SetBootOrder;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.SetGuestPassword;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.SetQoS;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.SetVncPassword;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StartVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StopVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StopVMForce;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.SuspendVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.TuneDiskQoS;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.TuneNICQoS;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UnbindFloatingIP;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UnplugDevice;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UnplugDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UnplugNIC;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UnsetQoS;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UnsetVncPassword;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UpdateOS;
import com.github.kubesys.kubernetes.utils.RegExpUtils;

/**
 * @author  wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.0.0
 * @since   2019/9/1
 **/
@SuppressWarnings("deprecation")
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
	
	/**
	 * @param name
	 * @param nodeName
	 * @param startVM
	 * @return
	 * @throws Exception
	 */
	public boolean startVM(String name, String nodeName, StartVM startVM) throws Exception {
		VirtualMachine vm = get(name);
		Map<String, String> labels = vm.getMetadata().getLabels();
		labels.put("host", nodeName);
		vm.getSpec().setNodeName(nodeName);
		return update(vm, startVM);
	}


	/*************************************************
	 * 
	 * Generated by <code>MethodGenerator<code>
	 * 
	 **************************************************/

	public boolean createAndStartVMFromISO(String name, CreateAndStartVMFromISO createAndStartVMFromISO) throws Exception {
		return createAndStartVMFromISO(name, null, createAndStartVMFromISO, null);
	}

	public boolean createAndStartVMFromISO(String name, String nodeName, CreateAndStartVMFromISO createAndStartVMFromISO) throws Exception {
		return createAndStartVMFromISO(name, nodeName, createAndStartVMFromISO, null);
	}

	public boolean createAndStartVMFromISO(String name, CreateAndStartVMFromISO createAndStartVMFromISO, String eventId) throws Exception {
		return createAndStartVMFromISO(name, null, createAndStartVMFromISO, eventId);
	}

	public boolean createAndStartVMFromISO(String name, String nodeName,CreateAndStartVMFromISO createAndStartVMFromISO, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return create(getModel(), createMetadata(name, nodeName, eventId), 
				createSpec(nodeName, createLifecycle(createAndStartVMFromISO)));
	}

	public boolean createAndStartVMFromImage(String name, CreateAndStartVMFromImage createAndStartVMFromImage) throws Exception {
		return createAndStartVMFromImage(name, null, createAndStartVMFromImage, null);
	}

	public boolean createAndStartVMFromImage(String name, String nodeName, CreateAndStartVMFromImage createAndStartVMFromImage) throws Exception {
		return createAndStartVMFromImage(name, nodeName, createAndStartVMFromImage, null);
	}

	public boolean createAndStartVMFromImage(String name, CreateAndStartVMFromImage createAndStartVMFromImage, String eventId) throws Exception {
		return createAndStartVMFromImage(name, null, createAndStartVMFromImage, eventId);
	}

	public boolean createAndStartVMFromImage(String name, String nodeName,CreateAndStartVMFromImage createAndStartVMFromImage, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return create(getModel(), createMetadata(name, nodeName, eventId), 
				createSpec(nodeName, createLifecycle(createAndStartVMFromImage)));
	}

	public boolean suspendVM(String name, SuspendVM suspendVM) throws Exception {
		return suspendVM(name, suspendVM, null);
	}

	public boolean suspendVM(String name, SuspendVM suspendVM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), suspendVM);
	}

	public boolean stopVMForce(String name, StopVMForce stopVMForce) throws Exception {
		return stopVMForce(name, stopVMForce, null);
	}

	public boolean stopVMForce(String name, StopVMForce stopVMForce, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), stopVMForce);
	}

	public boolean unplugDevice(String name, UnplugDevice unplugDevice) throws Exception {
		return unplugDevice(name, unplugDevice, null);
	}

	public boolean unplugDevice(String name, UnplugDevice unplugDevice, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), unplugDevice);
	}

	public boolean unplugNIC(String name, UnplugNIC unplugNIC) throws Exception {
		return unplugNIC(name, unplugNIC, null);
	}

	public boolean unplugNIC(String name, UnplugNIC unplugNIC, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), unplugNIC);
	}

	public boolean migrateVM(String name, MigrateVM migrateVM) throws Exception {
		return migrateVM(name, migrateVM, null);
	}

	public boolean migrateVM(String name, MigrateVM migrateVM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), migrateVM);
	}

	public boolean changeNumberOfCPU(String name, ChangeNumberOfCPU changeNumberOfCPU) throws Exception {
		return changeNumberOfCPU(name, changeNumberOfCPU, null);
	}

	public boolean changeNumberOfCPU(String name, ChangeNumberOfCPU changeNumberOfCPU, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), changeNumberOfCPU);
	}

	public boolean resumeVM(String name, ResumeVM resumeVM) throws Exception {
		return resumeVM(name, resumeVM, null);
	}

	public boolean resumeVM(String name, ResumeVM resumeVM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), resumeVM);
	}

	public boolean plugDisk(String name, PlugDisk plugDisk) throws Exception {
		return plugDisk(name, plugDisk, null);
	}

	public boolean plugDisk(String name, PlugDisk plugDisk, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), plugDisk);
	}

	public boolean plugDevice(String name, PlugDevice plugDevice) throws Exception {
		return plugDevice(name, plugDevice, null);
	}

	public boolean plugDevice(String name, PlugDevice plugDevice, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), plugDevice);
	}

	public boolean resetVM(String name, ResetVM resetVM) throws Exception {
		return resetVM(name, resetVM, null);
	}

	public boolean resetVM(String name, ResetVM resetVM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), resetVM);
	}

	public boolean unplugDisk(String name, UnplugDisk unplugDisk) throws Exception {
		return unplugDisk(name, unplugDisk, null);
	}

	public boolean unplugDisk(String name, UnplugDisk unplugDisk, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), unplugDisk);
	}

	public boolean stopVM(String name, StopVM stopVM) throws Exception {
		return stopVM(name, stopVM, null);
	}

	public boolean stopVM(String name, StopVM stopVM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), stopVM);
	}

	public boolean startVM(String name, StartVM startVM) throws Exception {
		return startVM(name, startVM, null);
	}

	public boolean startVM(String name, StartVM startVM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), startVM);
	}

	public boolean deleteVM(String name, DeleteVM deleteVM) throws Exception {
		return deleteVM(name, deleteVM, null);
	}

	public boolean deleteVM(String name, DeleteVM deleteVM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return delete(name, updateMetadata(name, eventId), deleteVM);
	}

	public boolean rebootVM(String name, RebootVM rebootVM) throws Exception {
		return rebootVM(name, rebootVM, null);
	}

	public boolean rebootVM(String name, RebootVM rebootVM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), rebootVM);
	}

	public boolean plugNIC(String name, PlugNIC plugNIC) throws Exception {
		return plugNIC(name, plugNIC, null);
	}

	public boolean plugNIC(String name, PlugNIC plugNIC, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), plugNIC);
	}

	public boolean manageISO(String name, ManageISO manageISO) throws Exception {
		return manageISO(name, manageISO, null);
	}

	public boolean manageISO(String name, ManageISO manageISO, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), manageISO);
	}

	public boolean updateOS(String name, UpdateOS updateOS) throws Exception {
		return updateOS(name, updateOS, null);
	}

	public boolean updateOS(String name, UpdateOS updateOS, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), updateOS);
	}

	public boolean convertVMToImage(String name, ConvertVMToImage convertVMToImage) throws Exception {
		return convertVMToImage(name, convertVMToImage, null);
	}

	public boolean convertVMToImage(String name, ConvertVMToImage convertVMToImage, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), convertVMToImage);
	}

	public boolean insertISO(String name, InsertISO insertISO) throws Exception {
		return insertISO(name, insertISO, null);
	}

	public boolean insertISO(String name, InsertISO insertISO, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), insertISO);
	}

	public boolean ejectISO(String name, EjectISO ejectISO) throws Exception {
		return ejectISO(name, ejectISO, null);
	}

	public boolean ejectISO(String name, EjectISO ejectISO, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), ejectISO);
	}

	public boolean resizeVM(String name, ResizeVM resizeVM) throws Exception {
		return resizeVM(name, resizeVM, null);
	}

	public boolean resizeVM(String name, ResizeVM resizeVM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), resizeVM);
	}

	public boolean cloneVM(String name, CloneVM cloneVM) throws Exception {
		return cloneVM(name, cloneVM, null);
	}

	public boolean cloneVM(String name, CloneVM cloneVM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), cloneVM);
	}

	public boolean tuneDiskQoS(String name, TuneDiskQoS tuneDiskQoS) throws Exception {
		return tuneDiskQoS(name, tuneDiskQoS, null);
	}

	public boolean tuneDiskQoS(String name, TuneDiskQoS tuneDiskQoS, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), tuneDiskQoS);
	}

	public boolean tuneNICQoS(String name, TuneNICQoS tuneNICQoS) throws Exception {
		return tuneNICQoS(name, tuneNICQoS, null);
	}

	public boolean tuneNICQoS(String name, TuneNICQoS tuneNICQoS, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), tuneNICQoS);
	}

	public boolean resizeMaxRAM(String name, ResizeMaxRAM resizeMaxRAM) throws Exception {
		return resizeMaxRAM(name, resizeMaxRAM, null);
	}

	public boolean resizeMaxRAM(String name, ResizeMaxRAM resizeMaxRAM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), resizeMaxRAM);
	}

	public boolean setBootOrder(String name, SetBootOrder setBootOrder) throws Exception {
		return setBootOrder(name, setBootOrder, null);
	}

	public boolean setBootOrder(String name, SetBootOrder setBootOrder, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), setBootOrder);
	}

	public boolean setVncPassword(String name, SetVncPassword setVncPassword) throws Exception {
		return setVncPassword(name, setVncPassword, null);
	}

	public boolean setVncPassword(String name, SetVncPassword setVncPassword, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), setVncPassword);
	}

	public boolean unsetVncPassword(String name, UnsetVncPassword unsetVncPassword) throws Exception {
		return unsetVncPassword(name, unsetVncPassword, null);
	}

	public boolean unsetVncPassword(String name, UnsetVncPassword unsetVncPassword, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), unsetVncPassword);
	}

	public boolean setGuestPassword(String name, SetGuestPassword setGuestPassword) throws Exception {
		return setGuestPassword(name, setGuestPassword, null);
	}

	public boolean setGuestPassword(String name, SetGuestPassword setGuestPassword, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), setGuestPassword);
	}

	public boolean resizeRAM(String name, ResizeRAM resizeRAM) throws Exception {
		return resizeRAM(name, resizeRAM, null);
	}

	public boolean resizeRAM(String name, ResizeRAM resizeRAM, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), resizeRAM);
	}

	public boolean bindFloatingIP(String name, BindFloatingIP bindFloatingIP) throws Exception {
		return bindFloatingIP(name, bindFloatingIP, null);
	}

	public boolean bindFloatingIP(String name, BindFloatingIP bindFloatingIP, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), bindFloatingIP);
	}

	public boolean unbindFloatingIP(String name, UnbindFloatingIP unbindFloatingIP) throws Exception {
		return unbindFloatingIP(name, unbindFloatingIP, null);
	}

	public boolean unbindFloatingIP(String name, UnbindFloatingIP unbindFloatingIP, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), unbindFloatingIP);
	}

	public boolean addACL(String name, AddACL addACL) throws Exception {
		return addACL(name, addACL, null);
	}

	public boolean addACL(String name, AddACL addACL, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), addACL);
	}

	public boolean modifyACL(String name, ModifyACL modifyACL) throws Exception {
		return modifyACL(name, modifyACL, null);
	}

	public boolean modifyACL(String name, ModifyACL modifyACL, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), modifyACL);
	}

	public boolean deprecatedACL(String name, DeprecatedACL deprecatedACL) throws Exception {
		return deprecatedACL(name, deprecatedACL, null);
	}

	public boolean deprecatedACL(String name, DeprecatedACL deprecatedACL, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), deprecatedACL);
	}

	public boolean setQoS(String name, SetQoS setQoS) throws Exception {
		return setQoS(name, setQoS, null);
	}

	public boolean setQoS(String name, SetQoS setQoS, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), setQoS);
	}

	public boolean modifyQoS(String name, ModifyQoS modifyQoS) throws Exception {
		return modifyQoS(name, modifyQoS, null);
	}

	public boolean modifyQoS(String name, ModifyQoS modifyQoS, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), modifyQoS);
	}

	public boolean unsetQoS(String name, UnsetQoS unsetQoS) throws Exception {
		return unsetQoS(name, unsetQoS, null);
	}

	public boolean unsetQoS(String name, UnsetQoS unsetQoS, String eventId) throws Exception {
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
		}
		return update(name, updateMetadata(name, eventId), unsetQoS);
	}




}
