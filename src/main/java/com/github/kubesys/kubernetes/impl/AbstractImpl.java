/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.constraints.Pattern;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.ExtendedKubernetesConstants;
import com.github.kubesys.kubernetes.annotations.ParameterDescriber;
import com.github.kubesys.kubernetes.api.model.ExtendedCustomResourceDefinitionSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ResetVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StopVMForce;

import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.ObjectMeta;
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
public abstract class AbstractImpl<R, S, T> {

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
	 * @param  labels          resource labels, the .metadata.labels
	 * @return                 all resource, or null, or throw an exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public S list(Map<String, String> labels) {
		return (S) ((FilterWatchListDeletable) client.withLabels(labels)).list();
	}
	
	/**
	 * @param name               resource name, the .metadata.name
	 * @param key                key
	 * @param value              value
	 * @return                   true, or false, or an exception
	 * @throws Exception         exception
	 */
	public boolean addTag(String name, String key, String value) throws Exception {

		R res = get(name);
		if (res == null) {
			m_logger.log(Level.SEVERE, type + " " + name 
				+ " not exist so that we cannot add this tag.");
			return false;
		}

		HasMetadata metadata = (HasMetadata)res;
		Map<String, String> tags = metadata.getMetadata().getLabels();
		tags = (tags == null) ? new HashMap<String, String>() : tags;
		tags.put(key, value);
		return update(ExtendedKubernetesConstants.OPERATOR_ADD_TAG, metadata);
	}

	/**
	 * @param name               resource name, the .metadata.name
	 * @param key                key
	 * @return                   true, or false, or an exception
	 * @throws Exception         exception
	 */
	public boolean deleteTag(String name, String key) throws Exception {

		R res = get(name);
		if (res == null) {
			m_logger.log(Level.SEVERE, type + " " + name + " not exist.");
			return false;
		}

		HasMetadata metadata = (HasMetadata)res;
		Map<String, String> tags = metadata.getMetadata().getLabels();
		if (tags != null) {	tags.remove(key);}
		return update(ExtendedKubernetesConstants.OPERATOR_DEL_TAG, metadata);
	}
	
	/**
	 * @return                  api version
	 */
	public String getAPIVersion() {
		return "cloudplus.io/v1alpha3";
	}
	
	/**
	 * @return                  kind
	 */
	public String getKind() {
		return type;
	}
	
	/**
	 * @return                     all support cmds
	 * @throws Exception           an exception
	 */
	public List<String> getSupportCmds() throws Exception {
		String rootPkg = ExtendedCustomResourceDefinitionSpec.class.getPackage().getName();
		String fullPkg = rootPkg + "." + type.toLowerCase();
		String className = fullPkg + ".Lifecycle";
		Class<?> clazz = Class.forName(className);
		
		List<String> cmds = new ArrayList<String>();
		for (Field f : clazz.getDeclaredFields()) {
			cmds.add(f.getName());
		}
		
		return cmds;
	}
	
	/*******************************************************
	 * 
	 *                Framework
	 * 
	 ********************************************************/
	/**
	 * @return                   Model, see fabric8 example
	 */
	public abstract R getModel();
	
	/**
	 * @return                   Spec, see fabric8 example
	 */
	public abstract T getSpec();
	
	/**
	 * @param t                  model
	 * @return                   spec, see fabric8 example
	 */
	public abstract T getSpec(R r);
	
	/**
	 * @return                   Lifecycle, see fabric8 example
	 */
	public abstract Object getLifecycle();
	
	/******************************************************
	 * 
	 *               Core
	 * 
	 *******************************************************/
	/**
	 * @param r                  model
	 * @param om                 objectMeta
	 * @param spec               spec
	 * @return                   true, or an exception
	 * @throws Exception         exception  
	 */
	public boolean create(R r, ObjectMeta om, T spec) throws Exception {
		
		// r.setApiVersion(apiversion)
		Method setVersion = r.getClass().getMethod("setApiVersion", String.class);
		setVersion.invoke(r, getAPIVersion());
		
		// r.setKind(kind)
		Method setKind = r.getClass().getMethod("setKind", String.class);
		setKind.invoke(r, getKind());
		
		// r.setMetadata(metadata)
		Method setMeta = r.getClass().getMethod("setMetadata", ObjectMeta.class);
		setMeta.invoke(r, om);
		
		// r.setSpec(spec)
		Method setSpec = r.getClass().getMethod("setSpec", spec.getClass());
		setSpec.invoke(r, spec);
		
		return create((HasMetadata) r);
	}
	
	/**
	 * @param name                    name
	 * @param om                      ObjectMeta  
	 * @param operator                operator
	 * @return                        true or an exception
	 * @throws Exception
	 */
	public boolean update(String name, ObjectMeta om, Object operator) throws Exception {
		
		R r = get(name);
		if (r == null) {
			throw new RuntimeException(type + " " + name + " is not exist");
		}
		
		T t = getSpec(r);
		if (!operator.getClass().getSimpleName().equals(StopVMForce.class.getSimpleName())
				&& !operator.getClass().getSimpleName().equals(ResetVM.class.getSimpleName())) {
			Method glf = t.getClass().getMethod("getLifecycle");
			Object gva = glf.invoke(t);
			if (gva != null) {
				throw new RuntimeException(type + " " + name + " is now under processing");
			}
		}
		
		Object lifecycle = createLifecycle(operator);
		
		// t.setLifecycle(lifecycle)
		Method setLifecycle = t.getClass().getMethod("setLifecycle", lifecycle.getClass());
		setLifecycle.invoke(t, lifecycle);
		
		// r.setSpec(spec)
		Method setSpec = r.getClass().getMethod("setSpec", t.getClass());
		setSpec.invoke(r, t);

		// r.setMetadata(metadata)
		Method setMeta = r.getClass().getMethod("setMetadata", ObjectMeta.class);
		setMeta.invoke(r, om);
		
		return update(operator.getClass().getSimpleName(), (HasMetadata) r);
	}
	
	/**
	 * @param name                    name
	 * @param om                      ObjectMeta
	 * @param operator                operator
	 * @return                        true or an exception
	 * @throws Exception              exception
	 */
	public boolean delete(String name, ObjectMeta om, Object operator) throws Exception {
		
		R r = get(name);
		if (r == null) {
			throw new RuntimeException(type + " " + name + " is not exist");
		}
		
		T t = getSpec(r);
		Method glf = t.getClass().getMethod("getLifecycle");
		Object gva = glf.invoke(t);
		if (gva != null) {
			delete((HasMetadata) r);
			return true;
		}
		
		return update(name, om, operator);
	}
	
	/*************************************************
	 * 
	 *              Utils
	 * 
	 *************************************************/
	
	/**
	 * @param nodeName             nodeName
	 * @param lifecycle            lifecycle
	 * @return                     Spec, or an exception
	 * @throws Exception           exception
	 */
	public T createSpec(String nodeName, Object lifecycle) throws Exception {
		T t = getSpec();
		if (nodeName != null) {
			// t.setNodeName(nodeName)
			Method setNode = t.getClass().getMethod("setNodeName", String.class);
			setNode.invoke(t, nodeName);
		}

		// t.setLifecycle(lifecycle)
		
		Method setLifecycle = t.getClass().getMethod("setLifecycle", lifecycle.getClass());
		setLifecycle.invoke(t, lifecycle);
		
		return t;
	}
	
	/**
	 * @param operator               operator
	 * @return                       lifecycle, or an exception
	 * @throws Exception             exception
	 */
	public Object createLifecycle(Object operator) throws Exception {
		
		// JSR 303
		for (Field field : operator.getClass().getDeclaredFields()) {
			ParameterDescriber param = field.getAnnotation(ParameterDescriber.class);
			if (param == null) {
				continue;
			}
			
			
			String fieldName = field.getName();
			String method = "get" + fieldName.substring(0, 1)
						.toUpperCase() + fieldName.substring(1);
			Object value = operator.getClass()
					.getMethod(method).invoke(operator);
			
			if (param.required() == false && value == null) {
				continue;
			}
			
			if (!(value instanceof String)) {
				continue;
			}
			
			Pattern pattern = field.getAnnotation(Pattern.class);
			
			if (pattern == null || pattern.regexp() == null) {
				continue;
			}
			
			String regexp = pattern.regexp();
			
			java.util.regex.Pattern checker = java.util.regex.Pattern.compile(regexp);
			if (!checker.matcher((String)value).matches()) {
				throw new IllegalArgumentException(param.constraint() + ", constraint is: " + regexp);
			}
		}
		
		Object lifecycle = getLifecycle();
		String name = "set" + operator.getClass().getSimpleName();
		Method setOperator = lifecycle.getClass().getMethod(name, operator.getClass());
		setOperator.invoke(lifecycle, operator);
		return lifecycle;
	}
	
	/**
	 * @param name                  metadata.name
	 * @param nodeName              metadata.labels.host
	 * @param eventId               metadata.labels.eventId
	 * @return                      ObjectMeta  
	 */
	protected ObjectMeta createMetadata(String name, String nodeName, String eventId) {
		ObjectMeta om = new ObjectMeta();
		om.setName(name);
		Map<String, String> labels = new HashMap<String, String>();
		labels.put(ExtendedKubernetesConstants.LABEL_HOST, nodeName);
		labels.put(ExtendedKubernetesConstants.LABEL_EVENTID, eventId);
		om.setLabels(labels);
		return om;
	}
	
	/**
	 * @param name                      name
	 * @param eventId                   eventId
	 * @return                          ObjectMeta 
	 * @throws Exception 
	 */
	protected ObjectMeta updateMetadata(String name, String eventId) throws Exception {
		R r = get(name);
		if (r == null) {
			throw new RuntimeException(type + " " + name + " is not exist");
		}

		Method m = r.getClass().getMethod("getMetadata");
		ObjectMeta om = (ObjectMeta) m.invoke(r);
		Map<String, String> labels = om.getLabels();
		labels = (labels == null) ? new HashMap<String, String>() : labels;
		labels.put(ExtendedKubernetesConstants.LABEL_EVENTID, eventId);
		om.setLabels(labels);
		return om;
	}
	
}