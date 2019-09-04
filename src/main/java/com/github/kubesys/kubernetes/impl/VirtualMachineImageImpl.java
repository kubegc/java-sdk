/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import java.util.HashMap;
import java.util.Map;

import com.github.kubesys.kubernetes.api.model.VirtualMachineImage;
import com.github.kubesys.kubernetes.api.model.VirtualMachineImageList;
import com.github.kubesys.kubernetes.api.model.VirtualMachineImageSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachineimage.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachineimage.Lifecycle.ConvertImageToVM;
import com.github.kubesys.kubernetes.api.model.virtualmachineimage.Lifecycle.CreateImage;
import com.github.kubesys.kubernetes.api.model.virtualmachineimage.Lifecycle.DeleteImage;

/**
 * @author  wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.0.0
 * @since   2019/9/1
 **/
public class VirtualMachineImageImpl extends AbstractImpl<VirtualMachineImage, VirtualMachineImageList, VirtualMachineImageSpec> {

	@Override
	public VirtualMachineImage getModel() {
		return new VirtualMachineImage();
	}

	@Override
	public VirtualMachineImageSpec getSpec() {
		return new VirtualMachineImageSpec();
	}

	@Override
	public Object getLifecycle() {
		return new Lifecycle();
	}

	@Override
	public VirtualMachineImageSpec getSpec(VirtualMachineImage r) {
		return r.getSpec();
	}

	/*************************************************
	 * 
	 * Generated
	 * 
	 **************************************************/

	public boolean createImage(String name, CreateImage createImage) throws Exception {
		return createImage(name, null, createImage, null);
	}
	
	public boolean createImage(String name, CreateImage createImage, String eventId) throws Exception {
		return createImage(name, null, createImage, eventId);
	}

	public boolean createImage(String name, String nodeName, CreateImage createImage) throws Exception {
		return createImage(name, nodeName, createImage, null);
	}
	
	public boolean createImage(String name, String nodeName, CreateImage createImage, String eventId) throws Exception {
		return create(getModel(), createMetadata(name, nodeName, eventId), 
				createSpec(nodeName, createLifecycle(createImage)));
	}
	
	public boolean convertImageToVM(String name, ConvertImageToVM convertImageToVM) throws Exception {
		VirtualMachineImage kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachineImage" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineImageSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setConvertImageToVM(convertImageToVM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("convertImageToVM ", kind);
		return true;
	}

	

	public boolean deleteImage(String name, DeleteImage deleteImage) throws Exception {
		VirtualMachineImage kind = get(name);
		
		if (kind == null) {
			return true;
		}
		
		if (kind.getSpec().getLifecycle() != null) {
			delete(kind);
			return true;
		}
		VirtualMachineImageSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setDeleteImage(deleteImage);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update(DeleteImage.class.getSimpleName(), kind);
//		delete(kind);
		return true;
	}
	
	//-------------------------------------------------------------------------------
	public boolean convertImageToVM(String name, ConvertImageToVM convertImageToVM, String eventId) throws Exception {
		VirtualMachineImage kind = get(name);
		if (kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachineImage" + name + " is not exist or it is in a wrong status");
		}
		Map<String, String> labels = kind.getMetadata().getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put("eventId", eventId);
		kind.getMetadata().setLabels(labels);
		
		VirtualMachineImageSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setConvertImageToVM(convertImageToVM);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update("convertImageToVM ", kind);
		return true;
	}

	

	public boolean deleteImage(String name, DeleteImage deleteImage, String eventId) throws Exception {
		VirtualMachineImage kind = get(name);
		
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
		
		VirtualMachineImageSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setDeleteImage(deleteImage);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		update(DeleteImage.class.getSimpleName(), kind);
//		delete(kind);
		return true;
	}


}
