/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.kubesys.kubernetes.api.model.VirtualMachineDisk;
import com.github.kubesys.kubernetes.api.model.VirtualMachineDiskList;
import com.github.kubesys.kubernetes.api.model.VirtualMachineDiskSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CloneDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CreateDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.DeleteDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.ResizeDisk;

import io.fabric8.kubernetes.api.model.ObjectMeta;

/**
 * @author  wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.0.0
 * @since   2019/9/1
 **/
public class VirtualMachineDiskImpl extends AbstractImpl<VirtualMachineDisk, VirtualMachineDiskList> {

	/**
	 * m_logger
	 */
	protected final static Logger m_logger = Logger.getLogger(VirtualMachineDiskImpl.class.getName());


	static {
		cmds.add("createDisk");
		cmds.add("deleteDisk");
		cmds.add("resizeDisk");
		cmds.add("cloneDisk");
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

		VirtualMachineDisk disk = get(name);
		if (disk == null) {
			m_logger.log(Level.SEVERE, "Disk" + name + " not exist.");
			return;
		}

		Map<String, String> tags = disk.getMetadata().getLabels();
		tags = (tags == null) ? new HashMap<String, String>() : tags;
		tags.put(key, value);
		update("addTag", disk);
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

		VirtualMachineDisk disk = get(name);
		if (disk == null) {
			m_logger.log(Level.SEVERE, "Disk " + name + " not exist.");
			return;
		}

		Map<String, String> tags = disk.getMetadata().getLabels();
		if (tags != null) {
			tags.remove(key);
		}

		update("deleteTag", disk);
	}

	/*************************************************
	 * 
	 * Generated
	 * 
	 **************************************************/

	public boolean createDisk(String name, CreateDisk createDisk) throws Exception {
		return createDisk(name, null, createDisk);
	}

	public boolean createDisk(String name, String nodeName, CreateDisk createDisk) throws Exception {
		VirtualMachineDisk kind = new VirtualMachineDisk();
		kind.setApiVersion("cloudplus.io/v1alpha3");
		kind.setKind("VirtualMachineDisk");
		VirtualMachineDiskSpec spec = new VirtualMachineDiskSpec();
		ObjectMeta om = new ObjectMeta();
		om.setName(name);
		if (nodeName != null) {
			Map<String, String> labels = new HashMap<String, String>();
			labels.put("host", nodeName);
			om.setLabels(labels);
			spec.setNodeName(nodeName);
		}
		kind.setMetadata(om);
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setCreateDisk(createDisk);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		create(kind);
		return true;
	}

	public boolean deleteDisk(String name, DeleteDisk deleteDisk) throws Exception {
		VirtualMachineDisk kind = get(name);
		
		if (kind == null) {
			return true;
		}
		
		if (kind.getSpec().getLifecycle() != null) {
			delete(kind);
			return true;
		}
		VirtualMachineDiskSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setDeleteDisk(deleteDisk);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update(DeleteDisk.class.getSimpleName(), kind);
//		delete(kind);
		return true;
	}

	public boolean resizeDisk(String name, ResizeDisk resizeDisk) throws Exception {
		VirtualMachineDisk kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachineDisk" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineDiskSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setResizeDisk(resizeDisk);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("resizeDisk ", kind);
		return true;
	}

	public boolean cloneDisk(String name, CloneDisk cloneDisk) throws Exception {
		VirtualMachineDisk kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachineDisk" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineDiskSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setCloneDisk(cloneDisk);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("cloneDisk ", kind);
		return true;
	}
	
	//------------------------------------------------
	public boolean createDisk(String name, CreateDisk createDisk, String eventId) throws Exception {
		return createDisk(name, null, createDisk, eventId);
	}

	public boolean createDisk(String name, String nodeName, CreateDisk createDisk, String eventId) throws Exception {
		VirtualMachineDisk kind = new VirtualMachineDisk();
		kind.setApiVersion("cloudplus.io/v1alpha3");
		kind.setKind("VirtualMachineDisk");
		VirtualMachineDiskSpec spec = new VirtualMachineDiskSpec();
		ObjectMeta om = new ObjectMeta();
		om.setName(name);
		if (nodeName != null) {
			Map<String, String> labels = new HashMap<String, String>();
			labels.put("host", nodeName);
			labels.put("eventId", eventId);
			om.setLabels(labels);
			spec.setNodeName(nodeName);
		}
		kind.setMetadata(om);
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setCreateDisk(createDisk);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		create(kind);
		return true;
	}

	public boolean deleteDisk(String name, DeleteDisk deleteDisk, String eventId) throws Exception {
		VirtualMachineDisk kind = get(name);
		
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
		VirtualMachineDiskSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setDeleteDisk(deleteDisk);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update(DeleteDisk.class.getName(), kind);
//		delete(kind);
		return true;
	}

	public boolean resizeDisk(String name, ResizeDisk resizeDisk, String eventId) throws Exception {
		VirtualMachineDisk kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachineDisk" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		
		VirtualMachineDiskSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setResizeDisk(resizeDisk);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("resizeDisk ", kind);
		return true;
	}

	public boolean cloneDisk(String name, CloneDisk cloneDisk, String eventId) throws Exception {
		VirtualMachineDisk kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachineDisk" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		
		VirtualMachineDiskSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setCloneDisk(cloneDisk);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("cloneDisk ", kind);
		return true;
	}
}