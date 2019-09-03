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
import com.github.kubesys.kubernetes.ExtendedKubernetesConstants;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.client.dsl.FilterWatchListDeletable;
import io.fabric8.kubernetes.client.dsl.Gettable;
import io.fabric8.kubernetes.client.dsl.MixedOperation;

/**
 * @author  wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.0.0
 * @since   2019/9/1
 * 
 * <p>
 * <code>AbstarctImpl<code> is used for selecting a optimal
 * machine based on the specified policy for each resource.
 * Here, resource can be VirtualMachine, VirtualMachinePool, 
 * VirtualMachineDisk, VirtualMachineSnapshot, and so on
 * 
 **/
public abstract class AbstractImpl<R, S> {

	/**
	 * m_logger
	 */
	protected final static Logger m_logger = Logger.getLogger(AbstractImpl.class.getName());

	/**
	 * client
	 */
	@SuppressWarnings("rawtypes")
	protected final MixedOperation client;
	
	/**
	 * resource type
	 */
	protected final String type;

	/**
	 * support commands
	 */
	public static List<String> cmds = new ArrayList<String>();


	/**
	 * @param client         the client can manage the lifecyle of the specified 
	 * @param type           resource type, such as VirtualMachine, VirtualMachinePool
	 */
	public AbstractImpl() {
		super();
		String classname = getClass().getSimpleName();
		this.type = classname.substring(0, classname.length() - "Impl".length());
		this.client = ExtendedKubernetesClient.crdClients.get(type);
	}

	/**
	 * Here, resource can be VirtualMachine, VirtualMachinePool, 
	 * VirtualMachineDisk, VirtualMachineSnapshot, and so on
	 * 
	 * @param object           resource object
	 * @return                 true or an exception
	 * @throws Exception       create resource fail
	 */
	@SuppressWarnings("unchecked")
	protected boolean create(HasMetadata object) throws Exception {
		client.create(object);
		m_logger.log(Level.INFO, "create "+ type + " "
					+ object.getMetadata().getName() + " successful.");
		return true;
	}

	/**
	 * 	Here, resource can be VirtualMachine, VirtualMachinePool, 
	 *  VirtualMachineDisk, VirtualMachineSnapshot, and so on
	 * 
	 * @param object            resource object
	 * @return                  true or an exception
	 * @throws Exception        delete resource fail
	 */
	@SuppressWarnings("unchecked")
	protected boolean delete(HasMetadata object) throws Exception {
		client.delete(object);
		m_logger.log(Level.INFO, "delete " + type + " " 
					+ object.getMetadata().getName() + " successful.");
		return true;
	}

	/**
	 * 
	 * Here, resource can be VirtualMachine, VirtualMachinePool, 
	 * VirtualMachineDisk, VirtualMachineSnapshot, and so on
	 *  
	 * @param operator           lifecyle except for 'Create' and 'Delete'
	 * @param object             resource object
	 * @return                   true or an exception
	 * @throws Exception         update resource fail
	 */
	@SuppressWarnings("unchecked")
	protected boolean update(String operator, HasMetadata object) throws Exception {
		client.createOrReplace(object);
		m_logger.log(Level.INFO, type + ": " + operator + " " 
					+ object.getMetadata().getName() + " successful.");
		return true;
	}
	
	/**
	 * 
	 * @param name            resource name, the .metadata.name
	 * @return                the object, or null, or throw an exception
	 */
	@SuppressWarnings("unchecked")
	public R get(String name)  {
		return ((Gettable<R>) client.withName(name)).get();
	}
	
	/**
	 * @param name          resource name, the .metadata.name
	 * @return              the object, or null, or throw an exception
	 */
	public String getEventId(String name) {
		R resource = get(name);
		return ((HasMetadata)resource).getMetadata().getLabels()
				.get(ExtendedKubernetesConstants.LABEL_EVENTID);
	}
	
	/**
	 * @return                  list all resource, or null, or throw an exception
	 */
	@SuppressWarnings("unchecked")
	public S list() {
		return (S) client.list();
	}
	
	/**
	 * list all resources with the specified labels
	 * 
	 * @param  labels           .metadata.labels
	 * @return                   all resource, or null, or throw an exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public S list(Map<String, String> labels) {
		return (S) ((FilterWatchListDeletable) client.withLabels(labels)).list();
	}

}