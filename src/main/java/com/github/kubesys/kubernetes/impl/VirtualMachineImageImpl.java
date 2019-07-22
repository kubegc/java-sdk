/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.VirtualMachineImage;
import com.github.kubesys.kubernetes.api.model.VirtualMachineImageList;
import com.github.kubesys.kubernetes.api.model.VirtualMachineImageSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachineimage.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachineimage.Lifecycle.ConvertImageToVM;
import com.github.kubesys.kubernetes.api.model.virtualmachineimage.Lifecycle.CreateImage;
import com.github.kubesys.kubernetes.api.model.virtualmachineimage.Lifecycle.DeleteImage;

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeletable;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author xuyuanjia2017@otcaix.iscas.ac.cn
 * @author xianghao16@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @since Thu Jun 13 21:39:55 CST 2019
 **/
public class VirtualMachineImageImpl {
	
	/**
	 * m_logger
	 */
	protected final static Logger m_logger = Logger.getLogger(VirtualMachineImageImpl.class.getName());
	
	/**
	 * 
	 */
	@SuppressWarnings("rawtypes")
	protected final MixedOperation client = ExtendedKubernetesClient
			.crdClients.get(VirtualMachineImage.class.getSimpleName());
	
	/**
	 * support commands
	 */
	public static List<String> cmds = new ArrayList<String>();
	
	static {
		cmds.add("convertImageToVM");
		cmds.add("createImage");
		cmds.add("deleteImage");
	}
	
	/*************************************************
	 * 
	 *                   Core 
	 * 
	 **************************************************/
	
	/**
	 * return true or an exception
	 * 
	 * @param image              VM image description
	 * @return                   true or an exception
	 * @throws Exception         create VM image fail
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	public boolean create(VirtualMachineImage image) throws Exception {
		client.create(image);
		m_logger.log(Level.INFO, "create VirtualMachineImage " 
				+ image.getMetadata().getName() + " successful.") ;
		return true;
	}
	
	/**
	 * @param image         VM image description
	 * @return              true or an exception
	 * @throws Exception    delete VM image fail
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	public boolean delete(VirtualMachineImage image) throws Exception {
		client.delete(image);
		m_logger.log(Level.INFO, "delete VirtualMachineImage " 
				+ image.getMetadata().getName() + " successful.") ;
		return true;
	}
	
	/**
	 * @param image         VM image description
	 * @return              true or an exception
	 * @throws Exception    delete VM image fail
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	public boolean update(VirtualMachineImage image) throws Exception {
		client.createOrReplace(image);
		m_logger.log(Level.INFO, "update VirtualMachineImage " 
				+ image.getMetadata().getName() + " successful.") ;
		return true;
	}
	
	/**
	 * @param operator      operator
	 * @param image         VM image description
	 * @return              true or an exception
	 * @throws Exception    update VM image fail
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	protected boolean update(String operator, VirtualMachineImage image) throws Exception {
		client.createOrReplace(image);
		m_logger.log(Level.INFO, operator + " " + 
				image.getMetadata().getName() + " successful.") ;
		return true;
	}
	
	/**
	 * return an object or null
	 * 
	 * @param name it is .metadata.name
	 * @return object or null
	 */
	@SuppressWarnings("unchecked")
	public VirtualMachineImage get(String name) {
		return ((Gettable<VirtualMachineImage>) 
				client.withName(name)).get();
	}
	
	/**
	 * @return     virtual machine image list or null
	 */
	public VirtualMachineImageList list() {
		return (VirtualMachineImageList) client.list();
	}
	
	/**
	 * list all VM images with the specified labels 
	 * 
	 * @param filter     .metadata.labels
	 * @return           all VM images or null 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public VirtualMachineImageList list(Map<String, String> labels) {
		return (VirtualMachineImageList)((FilterWatchListDeletable) 
				client.withLabels(labels)).list();
	}
	
	/**
	 * @param name        name
	 * @param key         key
	 * @param value       value
	 * @throws Exception  exception
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
		
		update(image);
	}
	
/**
 * @param name     name
 * @param key      key
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
		
		update(image);
	}
	
	/*************************************************
	 * 
	 *                   Generated
	 * 
	 **************************************************/
	
	public boolean convertImageToVM (String name, ConvertImageToVM  convertImageToVM ) throws Exception {
		VirtualMachineImage kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachineImage" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineImageSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setConvertImageToVM (convertImageToVM );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("convertImageToVM " , kind );
		return true;
	}


	public boolean createImage (String name, CreateImage  createImage ) throws Exception {
		return createImage(name, null, createImage);
	}
	
	public boolean createImage (String name, String nodeName, CreateImage  createImage ) throws Exception {
		VirtualMachineImage kind = new VirtualMachineImage();
		kind.setApiVersion("cloudplus.io/v1alpha3");
		kind.setKind("VirtualMachineImage");
		VirtualMachineImageSpec spec = new VirtualMachineImageSpec();
		ObjectMeta om = new ObjectMeta();
		om.setName(name);
		if (nodeName != null) {
			Map<String, String> labels = new HashMap<String, String>();
			labels.put("host", nodeName);
			om.setLabels(labels );
			spec.setNodeName(nodeName);
		}
		kind.setMetadata(om);
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setCreateImage (createImage );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		create(kind );
		return true;
	}


	public boolean deleteImage (String name, DeleteImage  deleteImage ) throws Exception {
		VirtualMachineImage kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			delete(kind);
		}
		VirtualMachineImageSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setDeleteImage (deleteImage );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update(kind );
		delete(kind);
		return true;
	}

}

