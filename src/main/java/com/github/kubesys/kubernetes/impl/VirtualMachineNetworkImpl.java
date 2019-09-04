/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import java.util.HashMap;
import java.util.Map;

import com.github.kubesys.kubernetes.api.model.VirtualMachineNetwork;
import com.github.kubesys.kubernetes.api.model.VirtualMachineNetworkList;
import com.github.kubesys.kubernetes.api.model.VirtualMachineNetworkSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachinenetwork.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachinenetwork.Lifecycle.CreateSwitch;
import com.github.kubesys.kubernetes.api.model.virtualmachinenetwork.Lifecycle.DeleteSwitch;

/**
 * @author  wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.0.0
 * @since   2019/9/1
 **/
public class VirtualMachineNetworkImpl extends AbstractImpl<VirtualMachineNetwork, VirtualMachineNetworkList, VirtualMachineNetworkSpec> {

	@Override
	public VirtualMachineNetwork getModel() {
		return new VirtualMachineNetwork();
	}

	@Override
	public VirtualMachineNetworkSpec getSpec() {
		return new VirtualMachineNetworkSpec();
	}
	
	@Override
	public Object getLifecycle() {
		return new Lifecycle();
	}

	
	@Override
	public VirtualMachineNetworkSpec getSpec(VirtualMachineNetwork r) {
		return r.getSpec();
	}

	/*************************************************
	 * 
	 * Generated
	 * 
	 **************************************************/
	// -----------------------------------------------------------------

	public boolean createSwitch(String name, CreateSwitch createSwitch)
			throws Exception {
		return createSwitch(name, null, createSwitch, null);
	}
	
	public boolean createSwitch(String name, CreateSwitch createSwitch, String eventId)
			throws Exception {
		return createSwitch(name, null, createSwitch, eventId);
	}
	
	public boolean createSwitch(String name, String nodeName, CreateSwitch createSwitch)
			throws Exception {
		return createSwitch(name, nodeName, createSwitch, null);
	}

	public boolean createSwitch(String name, String nodeName,
			CreateSwitch createSwitch, String eventId) throws Exception {
		return create(getModel(), createMetadata(name, nodeName, eventId), 
				createSpec(nodeName, createLifecycle(createSwitch)));
	}

	public boolean deleteSwitch(String name, DeleteSwitch deleteSwitch, String eventId) throws Exception {
		VirtualMachineNetwork kind = get(name);
		if (kind == null ) {
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
		
		VirtualMachineNetworkSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setDeleteSwitch(deleteSwitch);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update(DeleteSwitch.class.getSimpleName(), kind);
//		delete(kind);
		return true;
	}
	
}
