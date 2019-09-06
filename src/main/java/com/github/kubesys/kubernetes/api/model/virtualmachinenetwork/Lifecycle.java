/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model.virtualmachinenetwork;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.kubesys.kubernetes.annotations.Function;
import com.github.kubesys.kubernetes.annotations.Parameter;
import com.github.kubesys.kubernetes.annotations.Parent;
import com.github.kubesys.kubernetes.utils.AnnotationUtils;
import com.github.kubesys.kubernetes.utils.RegExpUtils;

/**
 * @author  wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.0.0
 * @since   2019/9/4
 * 
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@Parent(value = "VirtualMachineNetwork", desc = "扩展支持OVN插件")
public class Lifecycle {

	@Function(shortName = "创建网络交换机", description = "创建网络交换机，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = "", 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected CreateSwitch createSwitch;
	
	@Function(shortName = "删除网络交换机", description = "删除网络交换机，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMN, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected DeleteSwitch deleteSwitch;
	
	
	@Function(shortName = "绑定外网IP", description = "适用于虚拟IP和浮动IP场景，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMN, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected BindFip bindFip;
	
	@Function(shortName = "解绑定外网IP", description = "适用于虚拟IP和浮动IP场景，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMN, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected UnbindFip unbindFip;
	
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

	public BindFip getBindFip() {
		return bindFip;
	}

	public void setBindFip(BindFip bindFip) {
		this.bindFip = bindFip;
	}

	public UnbindFip getUnbindFip() {
		return unbindFip;
	}

	public void setUnbindFip(UnbindFip unbindFip) {
		this.unbindFip = unbindFip;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CreateSwitch {

		@Parameter(required = true, description = "网段，这里后台只会做形式，不会做逻辑判断，只要符合xx.xx.xx.xx/y形式即可，请确保传入正确的数值, y的取值必须是8,16,24之一", constraint = "网段和掩码", example = "192.168.5.1/24")
		@Pattern(regexp = RegExpUtils.SUBNET_PATTERN)
		protected String subnet;

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

	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class BindFip {

		@Parameter(required = true, description = "虚拟机mac地址", constraint = "mac地址不能以fe开头", example = "7e:0c:b0:ef:6a:04")
		@Pattern(regexp = RegExpUtils.MAC_PATTERN)
		protected String vmmac;
		
		@Parameter(required = true, description = "外网IP", constraint = "x.x.x.x,x取值范围0到255", example = "192.168.5.2")
		@Pattern(regexp = RegExpUtils.IP_PATTERN)
		protected String fip;

		public String getVmmac() {
			return vmmac;
		}

		public void setVmmac(String vmmac) {
			this.vmmac = vmmac;
		}

		public String getFip() {
			return fip;
		}

		public void setFip(String fip) {
			this.fip = fip;
		}
		
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class UnbindFip {

		@Parameter(required = true, description = "虚拟机mac地址", constraint = "mac地址不能以fe开头", example = "7e:0c:b0:ef:6a:04")
		@Pattern(regexp = RegExpUtils.MAC_PATTERN)
		protected String vmmac;

		public String getVmmac() {
			return vmmac;
		}

		public void setVmmac(String vmmac) {
			this.vmmac = vmmac;
		}
		
	}
	
}
