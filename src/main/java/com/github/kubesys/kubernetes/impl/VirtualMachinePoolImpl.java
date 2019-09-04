/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import java.util.HashMap;
import java.util.Map;

import com.github.kubesys.kubernetes.api.model.VirtualMachinePool;
import com.github.kubesys.kubernetes.api.model.VirtualMachinePoolList;
import com.github.kubesys.kubernetes.api.model.VirtualMachinePoolSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachinepool.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachinepool.Lifecycle.CreatePool;
import com.github.kubesys.kubernetes.api.model.virtualmachinepool.Lifecycle.DeletePool;

import io.fabric8.kubernetes.api.model.ObjectMeta;

/**
 * @author  wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.0.0
 * @since   2019/9/1
 **/
public class VirtualMachinePoolImpl extends AbstractImpl<VirtualMachinePool, VirtualMachinePoolList, VirtualMachinePoolSpec> {

	static {
		cmds.add("createPool");
		cmds.add("deletePool");
	}


	@Override
	public VirtualMachinePool getModel() {
		return new VirtualMachinePool();
	}

	@Override
	public VirtualMachinePoolSpec getSpec() {
		return new VirtualMachinePoolSpec();
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

	public boolean createPool(String name, CreatePool createPool) throws Exception {
		return createPool(name, null, createPool, null);
	}

	public boolean createPool(String name, String nodeName, CreatePool createPool) throws Exception {
		return createPool(name, nodeName, createPool, null);
	}
	
	public boolean createPool(String name, CreatePool createPool, String eventId) throws Exception {
		return createPool(name, null, createPool, eventId);
	}

	public boolean createPool(String name, String nodeName, CreatePool createPool, String eventId) throws Exception {
		return create(getModel(), createMetadata(name, nodeName, eventId), 
				createSpec(nodeName, createLifecycle(createPool))); 
	}

	public boolean deletePool(String name, DeletePool deletePool) throws Exception {
		VirtualMachinePool kind = get(name);
		
		if (kind == null) {
			return true;
		}
		
		if (kind.getSpec().getLifecycle() != null) {
			delete(kind);
			return true;
		}
		VirtualMachinePoolSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setDeletePool(deletePool);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update(DeletePool.class.getSimpleName(), kind);
//		delete(kind);
		return true;
	}

	//------------------------------------------------
	

	public boolean deletePool(String name, DeletePool deletePool, String eventId) throws Exception {
		VirtualMachinePool kind = get(name);
		
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
		
		VirtualMachinePoolSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setDeletePool(deletePool);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update(DeletePool.class.getSimpleName(), kind);
//		delete(kind);
		return true;
	}

}