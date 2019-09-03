/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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
public class VirtualMachineSnapshotImpl extends AbstractImpl<VirtualMachineSnapshot, VirtualMachineSnapshotList> {

	/**
	 * m_logger
	 */
	protected final static Logger m_logger = Logger.getLogger(VirtualMachineSnapshotImpl.class.getName());

	static {
		cmds.add("createSnapshot");
		cmds.add("deleteSnapshot");
	}


	/**
	 * @param name  name
	 * @param key   key
	 * @param value value
	 * @throws Exception exception
	 */
	public void addTag(String name, String key, String value) throws Exception {

		if (key.equals("host")) {
			m_logger.log(Level.SEVERE, "'host' is a keyword.");
			return;
		}

		VirtualMachineSnapshot snapshot = get(name);
		if (snapshot == null) {
			m_logger.log(Level.SEVERE, "Snapshot " + name + " not exist.");
			return;
		}

		Map<String, String> tags = snapshot.getMetadata().getLabels();
		tags = (tags == null) ? new HashMap<String, String>() : tags;
		tags.put(key, value);

		update("addTag", snapshot);
	}

	/**
	 * @param name name
	 * @param key  key
	 * @throws Exception exception
	 */
	public void deleteTag(String name, String key) throws Exception {

		if (key.equals("host")) {
			m_logger.log(Level.SEVERE, "'host' is a keyword.");
			return;
		}

		VirtualMachineSnapshot snapshot = get(name);
		if (snapshot == null) {
			m_logger.log(Level.SEVERE, "Snapshot " + name + " not exist.");
			return;
		}

		Map<String, String> tags = snapshot.getMetadata().getLabels();
		if (tags != null) {
			tags.remove(key);
		}

		update("deleteTag", snapshot);
	}

	/*************************************************
	 * 
	 * Generated
	 * 
	 **************************************************/

	public boolean createSnapshot(String name, CreateSnapshot createSnapshot) throws Exception {
		return createSnapshot(name, null, createSnapshot);
	}

	public boolean createSnapshot(String name, String nodeName, CreateSnapshot createSnapshot) throws Exception {
		VirtualMachineSnapshot kind = new VirtualMachineSnapshot();
		kind.setApiVersion("cloudplus.io/v1alpha3");
		kind.setKind("VirtualMachineSnapshot");
		VirtualMachineSnapshotSpec spec = new VirtualMachineSnapshotSpec();
		ObjectMeta om = new ObjectMeta();
		if (nodeName != null) {
			Map<String, String> labels = new HashMap<String, String>();
			labels.put("host", nodeName);
			om.setLabels(labels);
			spec.setNodeName(nodeName);
		}
		om.setName(name);
		kind.setMetadata(om);
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setCreateSnapshot(createSnapshot);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		create(kind);
		return true;
	}

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
//		delete(kind);
		return true;
	}
	
	//------------------------------------------------------
	public boolean createSnapshot(String name, CreateSnapshot createSnapshot, String eventId) throws Exception {
		return createSnapshot(name, null, createSnapshot, eventId);
	}

	public boolean createSnapshot(String name, String nodeName, CreateSnapshot createSnapshot, String eventId) throws Exception {
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
		lifecycle.setCreateSnapshot(createSnapshot);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		create(kind);
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
//		delete(kind);
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
