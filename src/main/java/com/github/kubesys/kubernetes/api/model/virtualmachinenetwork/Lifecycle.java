/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model.virtualmachinenetwork;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.kubesys.kubernetes.annotations.ClassDescriber;
import com.github.kubesys.kubernetes.annotations.FunctionDescriber;
import com.github.kubesys.kubernetes.annotations.ParameterDescriber;
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

	/**************************************************************
	 * 
	 *      L2 Network
	 * 
	 ***************************************************************/
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
	
	@FunctionDescriber(shortName = "设置二层网桥的vlan ID", description = "适用于OpenvSwitch二层网桥，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMN, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected SetBridgeVlan setBridgeVlan;
	
	@FunctionDescriber(shortName = "删除二层网桥的vlan ID", description = "适用于OpenvSwitch二层网桥，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMN, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected DelBridgeVlan delBridgeVlan;
	
	@FunctionDescriber(shortName = "给虚拟机绑定vlan ID", description = "适用于OpenvSwitch二层网桥，更换虚拟机的vlan" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMN, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected BindPortVlan bindPortVlan;
	
	@FunctionDescriber(shortName = "解除虚拟机的vlan ID", description = "适用于OpenvSwitch二层网桥，更换虚拟机的vlan" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMN, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected UnbindPortVlan unbindPortVlan;
	
	
	/**************************************************************
	 * 
	 *      L3 Network
	 * 
	 ***************************************************************/
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
	
	@FunctionDescriber(shortName = "修改三层网络交换机配置", description = "修改三层网络交换机配置，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = "", 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected ModifySwitch modifySwitch;
	
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


	public SetBridgeVlan getSetBridgeVlan() {
		return setBridgeVlan;
	}

	public void setSetBridgeVlan(SetBridgeVlan setBridgeVlan) {
		this.setBridgeVlan = setBridgeVlan;
	}

	public DelBridgeVlan getDelBridgeVlan() {
		return delBridgeVlan;
	}

	public void setDelBridgeVlan(DelBridgeVlan delBridgeVlan) {
		this.delBridgeVlan = delBridgeVlan;
	}


	public BindPortVlan getBindPortVlan() {
		return bindPortVlan;
	}

	public void setBindPortVlan(BindPortVlan bindPortVlan) {
		this.bindPortVlan = bindPortVlan;
	}

	public UnbindPortVlan getUnbindPortVlan() {
		return unbindPortVlan;
	}

	public void setUnbindPortVlan(UnbindPortVlan unbindPortVlan) {
		this.unbindPortVlan = unbindPortVlan;
	}


	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CreateSwitch {

		@ParameterDescriber(required = false, description = "网段，这里后台只会做形式，不会做逻辑判断，只要符合xx.xx.xx.xx/y形式即可，请确保传入正确的数值, y的取值必须是8,16,24之一", constraint = "网段和掩码", example = "192.168.5.1/24")
		@Pattern(regexp = RegExpUtils.SUBNET_PATTERN)
		protected String subnet;
		
		@ParameterDescriber(required = false, description = "网关地址", constraint = "IP", example = "192.168.5.5")
		@Pattern(regexp = RegExpUtils.IP_PATTERN)
		protected String gateway;
		
		@ParameterDescriber(required = false, description = "mtu", constraint = "10-1000", example = "1500")
		@Pattern(regexp = RegExpUtils.MTU_PATTERN)
		protected String mtu;
		
		@ParameterDescriber(required = false, description = "IP列表黑名单", constraint = "单个IP之间通过空格分开，IP范围使用..分开", example = "192.168.5.2 192.168.5.10..192.168.5.100")
		@Pattern(regexp = RegExpUtils.EXCLUDEIPS_PATTERN)
		protected String excludeIPs;
		
		public String getExcludeIPs() {
			return excludeIPs;
		}

		public void setExcludeIPs(String excludeIPs) {
			this.excludeIPs = excludeIPs;
		}

		public String getSubnet() {
			return subnet;
		}

		public void setSubnet(String subnet) {
			this.subnet = subnet;
		}

		public String getGateway() {
			return gateway;
		}

		public void setGateway(String gateway) {
			this.gateway = gateway;
		}

		public String getMtu() {
			return mtu;
		}

		public void setMtu(String mtu) {
			this.mtu = mtu;
		}
		
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class ModifySwitch {

		@ParameterDescriber(required = false, description = "网关地址", constraint = "IP", example = "192.168.5.5")
		@Pattern(regexp = RegExpUtils.IP_PATTERN)
		protected String gateway;
		
		@ParameterDescriber(required = false, description = "mtu", constraint = "10-1000", example = "1500")
		@Pattern(regexp = RegExpUtils.MTU_PATTERN)
		protected String mtu;
		
		public String getGateway() {
			return gateway;
		}

		public void setGateway(String gateway) {
			this.gateway = gateway;
		}

		public String getMtu() {
			return mtu;
		}

		public void setMtu(String mtu) {
			this.mtu = mtu;
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
	public static class SetBridgeVlan {

		@ParameterDescriber(required = true, description = "vlan ID", constraint = "0~4094", example = "1")
		@Pattern(regexp = RegExpUtils.VLAN_PATTERN)
		protected String vlan;

		public String getVlan() {
			return vlan;
		}

		public void setVlan(String vlan) {
			this.vlan = vlan;
		}

	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class DelBridgeVlan extends SetBridgeVlan{

	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CreateBridge {
		
		@ParameterDescriber(required = true, description = "被接管的网卡", constraint = "名称是字符串类型，长度是3到32位，只允许数字、小写字母、中划线、以及圆点", example = "l2bridge")
		@Pattern(regexp = RegExpUtils.NIC_PATTERN)
		protected String nic;
		
		@ParameterDescriber(required = false, description = "vlan ID", constraint = "0~4094", example = "1")
		@Pattern(regexp = RegExpUtils.VLAN_PATTERN)
		protected String vlan;

		public String getNic() {
			return nic;
		}

		public void setNic(String nic) {
			this.nic = nic;
		}

		public String getVlan() {
			return vlan;
		}

		public void setVlan(String vlan) {
			this.vlan = vlan;
		}

	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class DeleteBridge {
		
		@ParameterDescriber(required = true, description = "被接管的网卡", constraint = "名称是字符串类型，长度是3到32位，只允许数字、小写字母、中划线、以及圆点", example = "l2bridge")
		@Pattern(regexp = RegExpUtils.NIC_PATTERN)
		protected String nic;
		
		public String getNic() {
			return nic;
		}

		public void setNic(String nic) {
			this.nic = nic;
		}
		
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class BindPortVlan {
		
		@ParameterDescriber(required = true, description = "mac地址", constraint = "mac地址不能以fe开头", example = "7e:0c:b0:ef:6a:04")
		@Pattern(regexp = RegExpUtils.MAC_PATTERN)
		protected String mac;
		
		@ParameterDescriber(required = true, description = "虚拟机名称", constraint = "4-100位，包含小写字母，数字0-9，中划线，以及圆点", example = "950646e8c17a49d0b83c1c797811e004")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String domain;
		
		@ParameterDescriber(required = false, description = "vlan ID", constraint = "0~4094", example = "1")
		@Pattern(regexp = RegExpUtils.VLAN_PATTERN)
		protected String vlan;

		public String getDomain() {
			return domain;
		}

		public void setDomain(String domain) {
			this.domain = domain;
		}

		public String getMac() {
			return mac;
		}

		public void setMac(String mac) {
			this.mac = mac;
		}

		public String getVlan() {
			return vlan;
		}

		public void setVlan(String vlan) {
			this.vlan = vlan;
		}

	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class UnbindPortVlan extends BindPortVlan {
		
	}
	
}
