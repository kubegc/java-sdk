/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import java.util.HashMap;
import java.util.Map;

import com.github.kubesys.kubernetes.api.model.VirtualMachineDisk;
import com.github.kubesys.kubernetes.api.model.VirtualMachineDiskList;
import com.github.kubesys.kubernetes.api.model.VirtualMachineDiskSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CloneDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CreateDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.DeleteDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.ResizeDisk;

/**
 * @author  wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.0.0
 * @since   2019/9/1
 **/
public class VirtualMachineDiskImpl extends AbstractImpl<VirtualMachineDisk, VirtualMachineDiskList, VirtualMachineDiskSpec> {

	static {
		cmds.add("createDisk");
		cmds.add("deleteDisk");
		cmds.add("resizeDisk");
		cmds.add("cloneDisk");
	}

	@Override
	public VirtualMachineDisk getModel() {
		return new VirtualMachineDisk();
	}

	@Override
	public VirtualMachineDiskSpec getSpec() {
		return new VirtualMachineDiskSpec();
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

	public boolean createDisk(String name, CreateDisk createDisk) throws Exception {
		return createDisk(name, null, createDisk, null);
	}

	
	public boolean createDisk(String name, String nodeName, CreateDisk createDisk) throws Exception {
		return createDisk(name, nodeName, createDisk, null);
	}
	
	public boolean createDisk(String name, CreateDisk createDisk, String eventId) throws Exception {
		return createDisk(name, null, createDisk, eventId);
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
	
	public boolean createDisk(String name, String nodeName, CreateDisk createDisk, String eventId) throws Exception {
		return create(getModel(), createMetadata(name, nodeName, eventId), 
				createSpec(nodeName, createLifecycle(createDisk)));
	}
	
	//------------------------------------------------
	

	

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