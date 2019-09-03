/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.kubesys.kubernetes.api.model.VirtualMachineImage;
import com.github.kubesys.kubernetes.api.model.VirtualMachineImageList;
import com.github.kubesys.kubernetes.api.model.VirtualMachineImageSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachineimage.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachineimage.Lifecycle.ConvertImageToVM;
import com.github.kubesys.kubernetes.api.model.virtualmachineimage.Lifecycle.CreateImage;
import com.github.kubesys.kubernetes.api.model.virtualmachineimage.Lifecycle.DeleteImage;

import io.fabric8.kubernetes.api.model.ObjectMeta;

/**
 * @author  wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.0.0
 * @since   2019/9/1
 **/
public class VirtualMachineImageImpl extends AbstractImpl<VirtualMachineImage, VirtualMachineImageList> {

	/**
	 * m_logger
	 */
	protected final static Logger m_logger = Logger.getLogger(VirtualMachineImageImpl.class.getName());

	static {
		cmds.add("convertImageToVM");
		cmds.add("createImage");
		cmds.add("deleteImage");
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

		VirtualMachineImage image = get(name);
		if (image == null) {
			m_logger.log(Level.SEVERE, "Image " + name + " not exist.");
			return;
		}

		Map<String, String> tags = image.getMetadata().getLabels();
		tags = (tags == null) ? new HashMap<String, String>() : tags;
		tags.put(key, value);
		update("addTag", image);
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

		VirtualMachineImage image = get(name);
		if (image == null) {
			m_logger.log(Level.SEVERE, "Image " + name + " not exist.");
			return;
		}

		Map<String, String> tags = image.getMetadata().getLabels();
		if (tags != null) {
			tags.remove(key);
		}

		update("deleteTag", image);
	}

	/*************************************************
	 * 
	 * Generated
	 * 
	 **************************************************/

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

	public boolean createImage(String name, String nodeName, CreateImage createImage) throws Exception {
		VirtualMachineImage kind = new VirtualMachineImage();
		kind.setApiVersion("cloudplus.io/v1alpha3");
		kind.setKind("VirtualMachineImage");
		VirtualMachineImageSpec spec = new VirtualMachineImageSpec();
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
		lifecycle.setCreateImage(createImage);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		create(kind);
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

	public boolean createImage(String name, CreateImage createImage, String eventId) throws Exception {
		return createImage(name, null, createImage, eventId);
	}

	public boolean createImage(String name, String nodeName, CreateImage createImage, String eventId) throws Exception {
		VirtualMachineImage kind = new VirtualMachineImage();
		kind.setApiVersion("cloudplus.io/v1alpha3");
		kind.setKind("VirtualMachineImage");
		VirtualMachineImageSpec spec = new VirtualMachineImageSpec();
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
		lifecycle.setCreateImage(createImage);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		create(kind);
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
