/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model.virtualmachinenetwork;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author xuyuanjia2017@otcaix.iscas.ac.cn
 * @author xianghao16@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @since Thu Aug 20 21:36:39 CST 2019
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
public class Lifecycle {

	protected CreateSwitch createSwitch;
	
	protected DeleteSwitch deleteSwitch;
	
	protected CreateSwPort createSwPort;
	
	protected DeleteSwPort deleteSwPort;

	public CreateSwitch getCreateSwitch() {
		return createSwitch;
	}

	public void setCreateSwitch(CreateSwitch createSwitch) {
		this.createSwitch = createSwitch;
	}

	public DeleteSwitch getDeleteSwitch() {
		return deleteSwitch;
	}

	public void setDeleteSwitch(DeleteSwitch deleteSwitch) {
		this.deleteSwitch = deleteSwitch;
	}

	public CreateSwPort getCreateSwPort() {
		return createSwPort;
	}

	public void setCreateSwPort(CreateSwPort createSwPort) {
		this.createSwPort = createSwPort;
	}

	public DeleteSwPort getDeleteSwPort() {
		return deleteSwPort;
	}

	public void setDeleteSwPort(DeleteSwPort deleteSwPort) {
		this.deleteSwPort = deleteSwPort;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CreateSwitch {

		protected String name;
		
		protected String subnet;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSubnet() {
			return subnet;
		}

		public void setSubnet(String subnet) {
			this.subnet = subnet;
		}
		
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class DeleteSwitch {

		protected String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CreateSwPort {

		protected String swName;
		
		protected String name;
		
		protected String ip;

		public String getSwName() {
			return swName;
		}

		public void setSwName(String swName) {
			this.swName = swName;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}
		
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class DeleteSwPort {
		
		protected String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}

}
