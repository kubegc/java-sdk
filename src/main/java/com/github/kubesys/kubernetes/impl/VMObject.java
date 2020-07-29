/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.impl;


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
public class VMObject {

	protected Object object;
	
	protected String datetime;
	
	protected String eventId;
	
	protected String lifecycle;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getLifecycle() {
		return lifecycle;
	}

	public void setLifecycle(String lifecycle) {
		this.lifecycle = lifecycle;
	}
	
	
}