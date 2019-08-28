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
import java.util.regex.Pattern;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.VirtualMachineNetwork;
import com.github.kubesys.kubernetes.api.model.VirtualMachineNetworkList;
import com.github.kubesys.kubernetes.api.model.VirtualMachineNetworkSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachinenetwork.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachinenetwork.Lifecycle.CreateSwitch;
import com.github.kubesys.kubernetes.api.model.virtualmachinenetwork.Lifecycle.DeleteSwitch;

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
public class VirtualMachineNetworkImpl {

	/**
	 * pattern
	 */
	protected final static Pattern pattern = Pattern.compile("[a-z0-9-]{32}");

	/**
	 * m_logger
	 */
	protected final static Logger m_logger = Logger.getLogger(VirtualMachineNetworkImpl.class.getName());

	/**
	 * client
	 */
	@SuppressWarnings("rawtypes")
	protected final MixedOperation client = ExtendedKubernetesClient.crdClients
			.get(VirtualMachineNetwork.class.getSimpleName());;

	/**
	 * support commands
	 */
	public static List<String> cmds = new ArrayList<String>();

	static {
		cmds.add("createSwitch");
		cmds.add("deleteSwitch");
		cmds.add("setBridgeVlan");
		cmds.add("unsetBridgeVlan");
		cmds.add("createFloatIP");
		cmds.add("deleteFloatIP");
		cmds.add("bindFloatIP");
		cmds.add("unbindFloatIP");
	}

	/*************************************************
	 * 
	 * Core
	 * 
	 **************************************************/

	/**
	 * return true or an exception
	 * 
	 * @param vmn VM's description
	 * @return true or an exception
	 * @throws Exception create VM fail
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	public boolean create(VirtualMachineNetwork vmn) throws Exception {
		client.create(vmn);
		m_logger.log(Level.INFO, "create VirtualMachineNetwork " + vmn.getMetadata().getName() + " successful.");
		return true;
	}

	/**
	 * @param vmn VM's description
	 * @return true or an exception
	 * @throws Exception delete VM fail
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	public boolean delete(VirtualMachineNetwork vmn) throws Exception {
		client.delete(vmn);
		m_logger.log(Level.INFO, "delete VirtualMachineNetwork " + vmn.getMetadata().getName() + " successful.");
		return true;
	}

	/**
	 * @param vm VM's description
	 * @return true or an exception
	 * @throws Exception update VM fail
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	public boolean update(VirtualMachineNetwork vmn) throws Exception {
		client.createOrReplace(vmn);
		m_logger.log(Level.INFO, "update VirtualMachineNetwork " + vmn.getMetadata().getName() + " successful.");
		return true;
	}

	/**
	 * @param operator operator
	 * @param vmn       VM's description
	 * @return true or an exception
	 * @throws Exception update VM fail
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	protected boolean update(String operator, VirtualMachineNetwork vmn) throws Exception {
		client.createOrReplace(vmn);
		m_logger.log(Level.INFO, operator + " " + vmn.getMetadata().getName() + " successful.");
		return true;
	}

	/**
	 * return an object or null
	 * 
	 * @param name .metadata.name
	 * @return object or null
	 */
	@SuppressWarnings("unchecked")
	public VirtualMachineNetwork get(String name) {
		return ((Gettable<VirtualMachineNetwork>) client.withName(name)).get();
	}

	/**
	 * @return list all virtual machines or null
	 */
	public VirtualMachineNetworkList list() {
		return (VirtualMachineNetworkList) client.list();
	}

	/**
	 * list all VMs with the specified labels
	 * 
	 * @param filter .metadata.labels
	 * @return all VMs or null
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public VirtualMachineNetworkList list(Map<String, String> labels) {
		return (VirtualMachineNetworkList) ((FilterWatchListDeletable) client.withLabels(labels)).list();
	}

	public String getEventId(String name) {
		VirtualMachineNetwork vmn = get(name);
		return vmn.getMetadata().getLabels().get("eventId");
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

		VirtualMachineNetwork vmn = get(name);
		if (vmn == null) {
			m_logger.log(Level.SEVERE, "VM " + name + " not exist.");
			return;
		}

		Map<String, String> tags = vmn.getMetadata().getLabels();
		tags = (tags == null) ? new HashMap<String, String>() : tags;
		tags.put(key, value);
		update(vmn);
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

		VirtualMachineNetwork vmn = get(name);
		if (vmn == null) {
			m_logger.log(Level.SEVERE, "Network " + name + " not exist.");
			return;
		}

		Map<String, String> tags = vmn.getMetadata().getLabels();
		if (tags != null) {
			tags.remove(key);
		}
		update(vmn);
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
		VirtualMachineNetwork kind = new VirtualMachineNetwork();
		kind.setApiVersion("cloudplus.io/v1alpha3");
		kind.setKind("VirtualMachineNetwork");
		VirtualMachineNetworkSpec spec = new VirtualMachineNetworkSpec();
		ObjectMeta om = new ObjectMeta();
		Map<String, String> labels = new HashMap<String, String>();
		labels.put("type", "normal");
		labels.put("eventId", eventId);
		if (nodeName != null) {
			labels.put("host", nodeName);
			spec.setNodeName(nodeName);
		}
		om.setLabels(labels);
		om.setName(name);
		kind.setMetadata(om);
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setCreateSwitch(createSwitch);
		spec.setLifecycle(lifecycle);
		kind.setSpec(spec);
		create(kind);
		return true;
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
		update(kind);
		delete(kind);
		return true;
	}
	
}
