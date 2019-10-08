/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model.virtualmachinepool;

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
@ClassDescriber(value = "VirtualMachinePool", desc = "扩展支持各种存储后端")
public class Lifecycle {
	
	@FunctionDescriber(shortName = "开机启动存储池", description = "开机启动存储池，否则开机该存储池会连接不上，导致不可用。适用libvirt指令创建存储池情况。" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMP, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected AutoStart autoStart;
	
	@FunctionDescriber(shortName = "创建存储池", description = "创建存储池，适用libvirt指令创建存储池情况。" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = "", 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected CreatePool createPool;
	
	@FunctionDescriber(shortName = "启动存储池", description = "启动存储池，如果存储池处于Inactive状态，可以启动。适用libvirt指令创建存储池情况。" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMP, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected StartPool startPool;
	
//	@FunctionDescriber(shortName = "注册存储池", description = "注册存储池，将挂载的存储信息注册到Libvirt中，适用与采用外部存储池情况，与CreatePool等价"
//			+ AnnotationUtils.DESC_FUNCTION_DESC,
//		prerequisite = AnnotationUtils.DESC_FUNCTION_VMP,
//		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
//	protected RegisterPool registerPool;
	
	@FunctionDescriber(shortName = "停止存储池", description = "停止存储池，将存储池状态设置为Inactive，适用libvirt指令创建存储池情况。" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMP, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected StopPool stopPool;
	
	@FunctionDescriber(shortName = "删除存储池", description = "删除存储池，适用libvirt指令创建存储池情况。" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMP, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected DeletePool deletePool;
	
	@FunctionDescriber(shortName = "反注册存储池", description = "反注册存储池，将存储池信息从libvirt里面注销" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMP, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected UnregisterPool unregisterPool;
	

	public AutoStart getAutoStart() {
		return autoStart;
	}

	public void setAutoStart(AutoStart autoStart) {
		this.autoStart = autoStart;
	}

	public CreatePool getCreatePool() {
		return createPool;
	}

	public void setCreatePool(CreatePool createPool) {
		this.createPool = createPool;
	}

	public StartPool getStartPool() {
		return startPool;
	}

	public void setStartPool(StartPool startPool) {
		this.startPool = startPool;
	}

//	public RegisterPool getRegisterPool() {
//		return registerPool;
//	}
//
//	public void setRegisterPool(RegisterPool registerPool) {
//		this.registerPool = registerPool;
//	}

	public StopPool getStopPool() {
		return stopPool;
	}

	public void setStopPool(StopPool stopPool) {
		this.stopPool = stopPool;
	}

	public DeletePool getDeletePool() {
		return deletePool;
	}

	public void setDeletePool(DeletePool deletePool) {
		this.deletePool = deletePool;
	}

	public UnregisterPool getUnregisterPool() {
		return unregisterPool;
	}

	public void setUnregisterPool(UnregisterPool unregisterPool) {
		this.unregisterPool = unregisterPool;
	}
	
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class AutoStart {

		@ParameterDescriber(required = true, description = "修改存储池autostart状态", constraint = AnnotationUtils.DESC_BOOLEAN, example = "true")
		protected Boolean disable;

		public Boolean getDisable() {
			return disable;
		}

		public void setDisable(Boolean disable) {
			this.disable = disable;
		}
		
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CreatePool {

		@ParameterDescriber(required = true, description = "存储池的类型", constraint = "只能是dir，uus，nfs，glusterfs之一", example = "dir")
		@Pattern(regexp = RegExpUtils.POOL_TYPE_PATTERN)
		protected String type;
		
		protected String source_host;
		
		protected String source_path;

		@ParameterDescriber(required = false, description = "云存储池的url", constraint = "建立云存储池时通过cstor-cli pool-list查询出的云存储池路径", example = "uus-iscsi-independent://admin:admin@192.168.3.10:7000/p1/4/2/0/32/0/3")
		protected String url;

		@ParameterDescriber(required = false, description = "nfs挂载参数", constraint = "当type为nfs类型时，nfs的挂载参数", example = "nolock")
		protected String opt;

		protected String source_dev;
		
		protected String source_name;

		@ParameterDescriber(required = true, description = "创建存储池后是否设置为自动打开", constraint = "yes或no", example = "yes")
		@Pattern(regexp = RegExpUtils.AUTOSTART_PATTERN)
		protected String autostart;

		@ParameterDescriber(required = true, description = "创建存储池使用的存储路径", constraint = "完整有效的存储路径", example = "/var/lib/libvirt/poolg")
		@Pattern(regexp = RegExpUtils.TARGET_PATTERN)
		protected String target;
		
		protected String source_format;
		
		protected String auth_type;
		
		protected String auth_username;
		
		protected String secret_usage;
		
		protected String secret_uuid;
		
		protected String adapter_name;
		
		protected String adapter_wwnn;
		
		protected String adapter_wwpn;
		
		protected String adapter_parent;
		
		protected String adapter_parent_wwnn;
		
		protected String adapter_parent_wwpn;
		
		protected String adapter_parent_fabric_wwn;
		
		protected Boolean build;
		
		protected Boolean no_overwrite;
		
		protected Boolean overwrite;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getSource_host() {
			return source_host;
		}

		public void setSource_host(String source_host) {
			this.source_host = source_host;
		}

		public String getSource_path() {
			return source_path;
		}

		public void setSource_path(String source_path) {
			this.source_path = source_path;
		}

		public String getSource_dev() {
			return source_dev;
		}

		public void setSource_dev(String source_dev) {
			this.source_dev = source_dev;
		}

		public String getSource_name() {
			return source_name;
		}

		public void setSource_name(String source_name) {
			this.source_name = source_name;
		}

		public String getTarget() {
			return target;
		}

		public void setTarget(String target) {
			this.target = target;
		}

		public String getSource_format() {
			return source_format;
		}

		public void setSource_format(String source_format) {
			this.source_format = source_format;
		}

		public String getAuth_type() {
			return auth_type;
		}

		public void setAuth_type(String auth_type) {
			this.auth_type = auth_type;
		}

		public String getAuth_username() {
			return auth_username;
		}

		public void setAuth_username(String auth_username) {
			this.auth_username = auth_username;
		}

		public String getSecret_usage() {
			return secret_usage;
		}

		public void setSecret_usage(String secret_usage) {
			this.secret_usage = secret_usage;
		}

		public String getSecret_uuid() {
			return secret_uuid;
		}

		public void setSecret_uuid(String secret_uuid) {
			this.secret_uuid = secret_uuid;
		}

		public String getAdapter_name() {
			return adapter_name;
		}

		public void setAdapter_name(String adapter_name) {
			this.adapter_name = adapter_name;
		}

		public String getAdapter_wwnn() {
			return adapter_wwnn;
		}

		public void setAdapter_wwnn(String adapter_wwnn) {
			this.adapter_wwnn = adapter_wwnn;
		}

		public String getAdapter_wwpn() {
			return adapter_wwpn;
		}

		public void setAdapter_wwpn(String adapter_wwpn) {
			this.adapter_wwpn = adapter_wwpn;
		}

		public String getAdapter_parent() {
			return adapter_parent;
		}

		public void setAdapter_parent(String adapter_parent) {
			this.adapter_parent = adapter_parent;
		}

		public String getAdapter_parent_wwnn() {
			return adapter_parent_wwnn;
		}

		public void setAdapter_parent_wwnn(String adapter_parent_wwnn) {
			this.adapter_parent_wwnn = adapter_parent_wwnn;
		}

		public String getAdapter_parent_wwpn() {
			return adapter_parent_wwpn;
		}

		public void setAdapter_parent_wwpn(String adapter_parent_wwpn) {
			this.adapter_parent_wwpn = adapter_parent_wwpn;
		}

		public String getAdapter_parent_fabric_wwn() {
			return adapter_parent_fabric_wwn;
		}

		public void setAdapter_parent_fabric_wwn(String adapter_parent_fabric_wwn) {
			this.adapter_parent_fabric_wwn = adapter_parent_fabric_wwn;
		}

		public Boolean getBuild() {
			return build;
		}

		public void setBuild(Boolean build) {
			this.build = build;
		}

		public Boolean getNo_overwrite() {
			return no_overwrite;
		}

		public void setNo_overwrite(Boolean no_overwrite) {
			this.no_overwrite = no_overwrite;
		}

		public Boolean getOverwrite() {
			return overwrite;
		}

		public void setOverwrite(Boolean overwrite) {
			this.overwrite = overwrite;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getOpt() {
			return opt;
		}

		public void setOpt(String opt) {
			this.opt = opt;
		}

		public String getAutostart() {
			return autostart;
		}

		public void setAutostart(String autostart) {
			this.autostart = autostart;
		}
	}
	
//	@JsonInclude(JsonInclude.Include.NON_NULL)
//	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
//	public static class RegisterPool {
//
//		protected String type;
//
//		protected String source_host;
//
//		protected String source_path;
//
//		protected String source_dev;
//
//		protected String source_name;
//
//		protected String target;
//
//		protected String source_format;
//
//		protected String auth_type;
//
//		protected String auth_username;
//
//		protected String secret_usage;
//
//		protected String secret_uuid;
//
//		protected String adapter_name;
//
//		protected String adapter_wwnn;
//
//		protected String adapter_wwpn;
//
//		protected String adapter_parent;
//
//		protected String adapter_parent_wwnn;
//
//		protected String adapter_parent_wwpn;
//
//		protected String adapter_parent_fabric_wwn;
//
//		public String getType() {
//			return type;
//		}
//
//		public void setType(String type) {
//			this.type = type;
//		}
//
//		public String getSource_host() {
//			return source_host;
//		}
//
//		public void setSource_host(String source_host) {
//			this.source_host = source_host;
//		}
//
//		public String getSource_path() {
//			return source_path;
//		}
//
//		public void setSource_path(String source_path) {
//			this.source_path = source_path;
//		}
//
//		public String getSource_dev() {
//			return source_dev;
//		}
//
//		public void setSource_dev(String source_dev) {
//			this.source_dev = source_dev;
//		}
//
//		public String getSource_name() {
//			return source_name;
//		}
//
//		public void setSource_name(String source_name) {
//			this.source_name = source_name;
//		}
//
//		public String getTarget() {
//			return target;
//		}
//
//		public void setTarget(String target) {
//			this.target = target;
//		}
//
//		public String getSource_format() {
//			return source_format;
//		}
//
//		public void setSource_format(String source_format) {
//			this.source_format = source_format;
//		}
//
//		public String getAuth_type() {
//			return auth_type;
//		}
//
//		public void setAuth_type(String auth_type) {
//			this.auth_type = auth_type;
//		}
//
//		public String getAuth_username() {
//			return auth_username;
//		}
//
//		public void setAuth_username(String auth_username) {
//			this.auth_username = auth_username;
//		}
//
//		public String getSecret_usage() {
//			return secret_usage;
//		}
//
//		public void setSecret_usage(String secret_usage) {
//			this.secret_usage = secret_usage;
//		}
//
//		public String getSecret_uuid() {
//			return secret_uuid;
//		}
//
//		public void setSecret_uuid(String secret_uuid) {
//			this.secret_uuid = secret_uuid;
//		}
//
//		public String getAdapter_name() {
//			return adapter_name;
//		}
//
//		public void setAdapter_name(String adapter_name) {
//			this.adapter_name = adapter_name;
//		}
//
//		public String getAdapter_wwnn() {
//			return adapter_wwnn;
//		}
//
//		public void setAdapter_wwnn(String adapter_wwnn) {
//			this.adapter_wwnn = adapter_wwnn;
//		}
//
//		public String getAdapter_wwpn() {
//			return adapter_wwpn;
//		}
//
//		public void setAdapter_wwpn(String adapter_wwpn) {
//			this.adapter_wwpn = adapter_wwpn;
//		}
//
//		public String getAdapter_parent() {
//			return adapter_parent;
//		}
//
//		public void setAdapter_parent(String adapter_parent) {
//			this.adapter_parent = adapter_parent;
//		}
//
//		public String getAdapter_parent_wwnn() {
//			return adapter_parent_wwnn;
//		}
//
//		public void setAdapter_parent_wwnn(String adapter_parent_wwnn) {
//			this.adapter_parent_wwnn = adapter_parent_wwnn;
//		}
//
//		public String getAdapter_parent_wwpn() {
//			return adapter_parent_wwpn;
//		}
//
//		public void setAdapter_parent_wwpn(String adapter_parent_wwpn) {
//			this.adapter_parent_wwpn = adapter_parent_wwpn;
//		}
//
//		public String getAdapter_parent_fabric_wwn() {
//			return adapter_parent_fabric_wwn;
//		}
//
//		public void setAdapter_parent_fabric_wwn(String adapter_parent_fabric_wwn) {
//			this.adapter_parent_fabric_wwn = adapter_parent_fabric_wwn;
//		}
//
//
//	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class StartPool {
		
		protected Boolean build;
		
		protected Boolean no_overwrite;
		
		protected Boolean overwrite;

		public Boolean getBuild() {
			return build;
		}

		public void setBuild(Boolean build) {
			this.build = build;
		}

		public Boolean getNo_overwrite() {
			return no_overwrite;
		}

		public void setNo_overwrite(Boolean no_overwrite) {
			this.no_overwrite = no_overwrite;
		}

		public Boolean getOverwrite() {
			return overwrite;
		}

		public void setOverwrite(Boolean overwrite) {
			this.overwrite = overwrite;
		}
		
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class StopPool {
		
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class DeletePool {
		@ParameterDescriber(required = false, description = "存储池的类型", constraint = "只能是dir，uus，nfs，glusterfs之一", example = "dir")
		@Pattern(regexp = RegExpUtils.POOL_TYPE_PATTERN)
		protected String type;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class UnregisterPool {
		
	}

}
