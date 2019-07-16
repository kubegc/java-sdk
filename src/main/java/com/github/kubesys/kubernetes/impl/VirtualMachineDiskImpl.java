/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.VirtualMachineDisk;
import com.github.kubesys.kubernetes.api.model.VirtualMachineDiskList;
import com.github.kubesys.kubernetes.api.model.VirtualMachineDiskSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CloneDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CreateDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.DeleteDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.ResizeDisk;

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
public class VirtualMachineDiskImpl {
	
	/**
	 * m_logger
	 */
	protected final static Logger m_logger = Logger.getLogger(VirtualMachineDiskImpl.class.getName());
	
	/**
	 * client
	 */
	@SuppressWarnings("rawtypes")
	protected final MixedOperation client = ExtendedKubernetesClient
				.crdClients.get(VirtualMachineDisk.class.getSimpleName());
	
	/**
	 * support commands
	 */
	public static List<String> cmds = new ArrayList<String>();
	
	static {
		cmds.add("createDisk ");
		cmds.add("deleteDisk ");
		cmds.add("resizeDisk ");
		cmds.add("cloneDisk ");
	}
	
	/*************************************************
	 * 
	 *                   Core 
	 * 
	 **************************************************/
	
	/**
	 * return true or an exception
	 * 
	 * @param disk         VM disk description
	 * @return             true or an exception
	 * @throws Exception   create VM disk fail
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	public boolean create(VirtualMachineDisk disk) throws Exception {
		client.create(disk);
		m_logger.log(Level.INFO, "create VirtualMachineDisk " 
				+ disk.getMetadata().getName() + " successful.") ;
		return true;
	}
	
	/**
	 * @param disk          VM disk description
	 * @return              true or an exception
	 * @throws Exception    delete VM disk fail
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	public boolean delete(VirtualMachineDisk disk) throws Exception {
		client.delete(disk);
		m_logger.log(Level.INFO, "delete VirtualMachineDisk " 
				+ disk.getMetadata().getName() + " successful.") ;
		return true;
	}
	
	/**
	 * @param disk          VM disk description
	 * @return              true or an exception
	 * @throws Exception    update VM disk fail
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	public boolean update(VirtualMachineDisk disk) throws Exception {
		client.createOrReplace(disk);
		m_logger.log(Level.INFO, "update VirtualMachine " 
				+ disk.getMetadata().getName() + " successful.") ;
		return true;
	}
	
	/**
	 * @param operator      operator
	 * @param disk          VM disk description
	 * @return              true or an exception
	 * @throws Exception    update VM disk fail
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	protected boolean update(String operator, VirtualMachineDisk disk) throws Exception {
		client.createOrReplace(disk);
		m_logger.log(Level.INFO, operator + " " + 
				disk.getMetadata().getName() + " successful.") ;
		return true;
	}
	
	/**
	 * return an object or null
	 * 
	 * @param name     .metadata.name
	 * @return         object or null
	 */
	@SuppressWarnings("unchecked")
	public VirtualMachineDisk get(String name) {
		return ((Gettable<VirtualMachineDisk>) 
				client.withName(name)).get();
	}
	
	/**
	 * @return list all virtual machine disks or null
	 */
	public VirtualMachineDiskList list() {
		return (VirtualMachineDiskList) client.list();
	}
	
	/**
	 * list all VM disks with the specified labels 
	 * 
	 * @param filter    .metadata.labels
	 * @return          all VM disk or null
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public VirtualMachineDiskList list(Map<String, String> labels) {
		return (VirtualMachineDiskList)((FilterWatchListDeletable) 
				client.withLabels(labels)).list();
	}
	
	
	/*************************************************
	 * 
	 *                   Generated
	 * 
	 **************************************************/

	public boolean createDisk (String name, CreateDisk  createDisk ) throws Exception {
		VirtualMachineDisk kind = new VirtualMachineDisk();
		kind.setApiVersion("cloudplus.io/v1alpha3");
		kind.setKind("VirtualMachineDisk");
		VirtualMachineDiskSpec spec = new VirtualMachineDiskSpec();
		ObjectMeta om = new ObjectMeta();
		om.setName(name);
		kind.setMetadata(om);
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setCreateDisk (createDisk );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		create(kind );
		return true;
	}


	public boolean deleteDisk (String name, DeleteDisk  deleteDisk ) throws Exception {
		VirtualMachineDisk kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			delete(kind);
		}
		VirtualMachineDiskSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setDeleteDisk (deleteDisk );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		delete(kind );
		return true;
	}


	public boolean resizeDisk (String name, ResizeDisk  resizeDisk ) throws Exception {
		VirtualMachineDisk kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachineDisk" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineDiskSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setResizeDisk (resizeDisk );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("resizeDisk " , kind );
		return true;
	}


	public boolean cloneDisk (String name, CloneDisk  cloneDisk ) throws Exception {
		VirtualMachineDisk kind = get(name);
		if(kind == null || kind.getSpec().getLifecycle() != null) {
			throw new RuntimeException("VirtualMachineDisk" + name + " is not exist or it is in a wrong status");
		}
		VirtualMachineDiskSpec spec = kind.getSpec();
		Lifecycle lifecycle = new Lifecycle();
		lifecycle.setCloneDisk (cloneDisk );
		spec.setLifecycle(lifecycle );
		kind.setSpec(spec );
		update("cloneDisk " , kind );
		return true;
	}
}