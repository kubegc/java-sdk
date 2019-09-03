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
import com.github.kubesys.kubernetes.api.model.VirtualMachinePool;
import com.github.kubesys.kubernetes.api.model.VirtualMachinePoolList;
import com.github.kubesys.kubernetes.api.model.VirtualMachinePoolSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachinepool.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachinepool.Lifecycle.CreatePool;
import com.github.kubesys.kubernetes.api.model.virtualmachinepool.Lifecycle.DeletePool;

import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeletable;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;

/**
 * @author  wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.0.0
 * @since   2019/9/1
 **/
public class VirtualMachinePoolImpl extends AbstractImpl {

	/**
	 * m_logger
	 */
	protected final static Logger m_logger = Logger.getLogger(VirtualMachinePoolImpl.class.getName());

	static {
		cmds.add("createPool");
		cmds.add("deletePool");
	}

	/**
	 * return an object or null
	 * 
	 * @param name .metadata.name
	 * @return object or null
	 */
	@SuppressWarnings("unchecked")
	public VirtualMachinePool get(String name) {
		return ((Gettable<VirtualMachinePool>) client.withName(name)).get();
	}

	/**
	 * @return list all virtual machine disks or null
	 */
	public VirtualMachinePoolList list() {
		return (VirtualMachinePoolList) client.list();
	}

	/**
	 * list all VM disks with the specified labels
	 * 
	 * @param filter .metadata.labels
	 * @return all VM disk or null
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public VirtualMachinePoolList list(Map<String, String> labels) {
		return (VirtualMachinePoolList) ((FilterWatchListDeletable) client.withLabels(labels)).list();
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

		VirtualMachinePool pool = get(name);
		if (pool == null) {
			m_logger.log(Level.SEVERE, "Disk" + name + " not exist.");
			return;
		}

		Map<String, String> tags = pool.getMetadata().getLabels();
		tags = (tags == null) ? new HashMap<String, String>() : tags;
		tags.put(key, value);
		update("addTag", pool);
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

		VirtualMachinePool pool = get(name);
		if (pool == null) {
			m_logger.log(Level.SEVERE, "Disk " + name + " not exist.");
			return;
		}

		Map<String, String> tags = pool.getMetadata().getLabels();
		if (tags != null) {
			tags.remove(key);
		}

		update("deleteTag", pool);
	}

	/*************************************************
	 * 
	 * Generated
	 * 
	 **************************************************/

	public boolean createPool(String name, CreatePool createPool) throws Exception {
		return createPool(name, null, createPool);
	}

	public boolean createPool(String name, String nodeName, CreatePool createPool) throws Exception {
		VirtualMachinePool kind = new VirtualMachinePool();
		kind.setApiVersion("cloudplus.io/v1alpha3");
		kind.setKind("VirtualMachinePool");
		VirtualMachinePoolSpec spec = new VirtualMachinePoolSpec();
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
		lifecycle.setCreatePool(createPool);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		create(kind);
		return true;
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
	public boolean createPool(String name, CreatePool createPool, String eventId) throws Exception {
		return createPool(name, null, createPool, eventId);
	}

	public boolean createPool(String name, String nodeName, CreatePool createPool, String eventId) throws Exception {
		VirtualMachinePool kind = new VirtualMachinePool();
		kind.setApiVersion("cloudplus.io/v1alpha3");
		kind.setKind("VirtualMachinePool");
		VirtualMachinePoolSpec spec = new VirtualMachinePoolSpec();
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
		lifecycle.setCreatePool(createPool);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		create(kind);
		return true;
	}

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