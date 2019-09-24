/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model.virtualmachinenetwork;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.kubesys.kubernetes.annotations.FunctionDescriber;
import com.github.kubesys.kubernetes.annotations.ParameterDescriber;
import com.github.kubesys.kubernetes.annotations.ClassDescriber;
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
@ClassDescriber(value = "VirtualMachineNetwork", desc = "扩展支持OVN插件")
public class Lifecycle {

	@FunctionDescriber(shortName = "创建二层桥接网络，用于vlan场景", description = "创建二层桥接，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = "", 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected CreateBridge createBridge;
	
	@FunctionDescriber(shortName = "删除二层桥接网络", description = "删除二层桥接," 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMN, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected DeleteBridge deleteBridge;
	
	@FunctionDescriber(shortName = "创建三层网络交换机", description = "创建三层网络交换机，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = "", 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected CreateSwitch createSwitch;
	
	@FunctionDescriber(shortName = "删除三层网络交换机", description = "删除三层网络交换机，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMN, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected DeleteSwitch deleteSwitch;
	
	@FunctionDescriber(shortName = "绑定外网IP", description = "适用于虚拟IP和浮动IP场景，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMN, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected BindFip bindFip;
	
	@FunctionDescriber(shortName = "解绑定外网IP", description = "适用于虚拟IP和浮动IP场景，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMN, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected UnbindFip unbindFip;
	
	@FunctionDescriber(shortName = "设置端口的vlan ID", description = "适用于OpenvSwitch二层网桥，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMN, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected SetPortVlan setPortVlan;
	
	@FunctionDescriber(shortName = "删除端口的vlan ID", description = "适用于OpenvSwitch二层网桥，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMN, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected DelPortVlan delPortVlan;
	
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

	public SetPortVlan getSetPortVlan() {
		return setPortVlan;
	}

	public void setSetPortVlan(SetPortVlan setPortVlan) {
		this.setPortVlan = setPortVlan;
	}

	public DelPortVlan getDelPortVlan() {
		return delPortVlan;
	}

	public void setDelPortVlan(DelPortVlan delPortVlan) {
		this.delPortVlan = delPortVlan;
	}

	public CreateBridge getCreateBridge() {
		return createBridge;
	}

	public void setCreateBridge(CreateBridge createBridge) {
		this.createBridge = createBridge;
	}

	public DeleteBridge getDeleteBridge() {
		return deleteBridge;
	}

	public void setDeleteBridge(DeleteBridge deleteBridge) {
		this.deleteBridge = deleteBridge;
	}



	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CreateSwitch {

		@ParameterDescriber(required = true, description = "网段，这里后台只会做形式，不会做逻辑判断，只要符合xx.xx.xx.xx/y形式即可，请确保传入正确的数值, y的取值必须是8,16,24之一", constraint = "网段和掩码", example = "192.168.5.1/24")
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

		@ParameterDescriber(required = true, description = "虚拟机mac地址", constraint = "mac地址不能以fe开头", example = "7e:0c:b0:ef:6a:04")
		@Pattern(regexp = RegExpUtils.MAC_PATTERN)
		protected String vmmac;
		
		@ParameterDescriber(required = true, description = "外网IP", constraint = "x.x.x.x,x取值范围0到255", example = "192.168.5.2")
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

		@ParameterDescriber(required = true, description = "虚拟机mac地址", constraint = "mac地址不能以fe开头", example = "7e:0c:b0:ef:6a:04")
		@Pattern(regexp = RegExpUtils.MAC_PATTERN)
		protected String vmmac;

		public String getVmmac() {
			return vmmac;
		}

		public void setVmmac(String vmmac) {
			this.vmmac = vmmac;
		}
		
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class SetPortVlan {

		@ParameterDescriber(required = true, description = "虚拟机mac地址", constraint = "mac地址不能以fe开头", example = "7e:0c:b0:ef:6a:04")
		@Pattern(regexp = RegExpUtils.MAC_PATTERN)
		protected String vmmac;
		
		@ParameterDescriber(required = true, description = "vlan ID", constraint = "0~4094", example = "1")
		@Pattern(regexp = RegExpUtils.VLAN_PATTERN)
		protected String vlan;

		public String getVlan() {
			return vlan;
		}

		public void setVlan(String vlan) {
			this.vlan = vlan;
		}

		public String getVmmac() {
			return vmmac;
		}

		public void setVmmac(String vmmac) {
			this.vmmac = vmmac;
		}
		
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class DelPortVlan {

		@ParameterDescriber(required = true, description = "虚拟机mac地址", constraint = "mac地址不能以fe开头", example = "7e:0c:b0:ef:6a:04")
		@Pattern(regexp = RegExpUtils.MAC_PATTERN)
		protected String vmmac;

		public String getVmmac() {
			return vmmac;
		}

		public void setVmmac(String vmmac) {
			this.vmmac = vmmac;
		}
		
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CreateBridge {
		
		@ParameterDescriber(required = true, description = "被接管的网卡", constraint = "名称是字符串类型，长度是6到128位，只允许数字、小写字母、中划线、以及圆点", example = "l2bridge")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String name;
		
		@ParameterDescriber(required = false, description = "希望创建的网桥名", constraint = "名称是字符串类型，长度是6到128位，只允许数字、小写字母、中划线、以及圆点。如果不传值，默认是br-native", example = "br-l2bridge")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String bridge;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getBridge() {
			return bridge;
		}

		public void setBridge(String bridge) {
			this.bridge = bridge;
		}
		
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class DeleteBridge extends CreateBridge {
		
	}
	
}
