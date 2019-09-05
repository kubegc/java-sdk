/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model.virtualmachinenetwork;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.kubesys.interior.annotations.Function;
import com.github.kubesys.interior.annotations.Parameter;
import com.github.kubesys.interior.annotations.Parent;
import com.github.kubesys.kubernetes.ExtendedKubernetesConstants;

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
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
		prerequisite = "", 
		exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected CreateSwitch createSwitch;
	
	@Function(shortName = "删除网络交换机", description = "删除网络交换机，" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
		prerequisite = ExtendedKubernetesConstants.DESC_FUNCTION_VMN, 
		exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected DeleteSwitch deleteSwitch;
	
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

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CreateSwitch {

		@Parameter(required = true, description = "网段，这里后台只会做形式，不会做逻辑判断，只要符合xx.xx.xx.xx/x形式即可，请确保传入正确的数值", constraint = "网段和掩码", example = "192.168.5.1/24")
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
	
}
