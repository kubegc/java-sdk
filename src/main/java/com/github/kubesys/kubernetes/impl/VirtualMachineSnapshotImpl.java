/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import java.util.HashMap;
import java.util.Map;

import com.github.kubesys.kubernetes.api.model.VirtualMachineSnapshot;
import com.github.kubesys.kubernetes.api.model.VirtualMachineSnapshotList;
import com.github.kubesys.kubernetes.api.model.VirtualMachineSnapshotSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Lifecycle.CreateSnapshot;
import com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Lifecycle.DeleteSnapshot;
import com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Lifecycle.RevertVirtualMachine;

import io.fabric8.kubernetes.api.model.ObjectMeta;

/**
 * @author  wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.0.0
 * @since   2019/9/1
 **/
public class VirtualMachineSnapshotImpl extends AbstractImpl<VirtualMachineSnapshot, VirtualMachineSnapshotList, VirtualMachineSnapshotSpec> {

	static {
		// 创建快照
		cmds.add("createSnapshot");
		// 删除快照
		cmds.add("deleteSnapshot");
		// 恢复成虚拟机
		cmds.add("revertVirtualMachine");
	}

	@Override
	public VirtualMachineSnapshot getModel() {
		return new VirtualMachineSnapshot();
	}

	@Override
	public VirtualMachineSnapshotSpec getSpec() {
		return new VirtualMachineSnapshotSpec();
	}

	@Override
	public Object getLifecycle() {
		return new Lifecycle();
	}

	/*************************************************
	 * 
	 * Generated
	 * 
	 **************************************************/
	public boolean createSnapshot(String name, CreateSnapshot createSnapshot) throws Exception {
		return createSnapshot(name, null, createSnapshot, null);
	}

	public boolean createSnapshot(String name, String nodeName, CreateSnapshot createSnapshot) throws Exception {
		return createSnapshot(name, nodeName, createSnapshot, null);
	}

	public boolean createSnapshot(String name, CreateSnapshot createSnapshot, String eventId) throws Exception {
		return createSnapshot(name, null, createSnapshot, eventId);
	}

	public boolean createSnapshot(String name, String nodeName, CreateSnapshot createSnapshot, String eventId) throws Exception {
		return create(getModel(), createMetadata(name, nodeName, eventId), 
				createSpec(nodeName, createLifecycle(createSnapshot))); 
	}
	
	//------------------------------------------------------
	public boolean deleteSnapshot(String name, DeleteSnapshot deleteSnapshot) throws Exception {
		VirtualMachineSnapshot kind = get(name);
		if (kind == null) {
			return true;
		}
		if (kind.getSpec().getLifecycle() != null) {
			delete(kind);
			return true;
		}
		VirtualMachineSnapshotSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setDeleteSnapshot(deleteSnapshot);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update(DeleteSnapshot.class.getSimpleName(), kind);
		return true;
	}

	public boolean deleteSnapshot(String name, DeleteSnapshot deleteSnapshot, String eventId) throws Exception {
		VirtualMachineSnapshot kind = get(name);
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
		
		VirtualMachineSnapshotSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setDeleteSnapshot(deleteSnapshot);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update(DeleteSnapshot.class.getSimpleName(), kind);
		return true;
	}
	
	public boolean revertVirtualMachine(String name, RevertVirtualMachine revertVirtualMachine, String eventId) throws Exception {
		return revertVirtualMachine(name, null, revertVirtualMachine, eventId);
	}

	public boolean revertVirtualMachine(String name, String nodeName, RevertVirtualMachine revertVirtualMachine, String eventId) throws Exception {
		VirtualMachineSnapshot kind = new VirtualMachineSnapshot();
		kind.setApiVersion("cloudplus.io/v1alpha3");
		kind.setKind("VirtualMachineSnapshot");
		VirtualMachineSnapshotSpec spec = new VirtualMachineSnapshotSpec();
		ObjectMeta om = new ObjectMeta();
		if (nodeName != null) {
			Map<String, String> labels = new HashMap<String, String>();
			labels.put("host", nodeName);
			labels.put("eventId", eventId);
			om.setLabels(labels);
			spec.setNodeName(nodeName);
		}
		
		om.setName(name);
		kind.setMetadata(om);
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setRevertVirtualMachine(revertVirtualMachine);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update(RevertVirtualMachine.class.getSimpleName(), kind);
		return true;
	}

}
