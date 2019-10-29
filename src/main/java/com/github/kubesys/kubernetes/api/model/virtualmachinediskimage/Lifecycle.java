/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model.virtualmachinediskimage;

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
@ClassDescriber(value = "VirtualMachineDiskImage", desc = "云盘模板，主要是指大小和文件格式等")
public class Lifecycle {

	@FunctionDescriber(shortName = "将云盘镜像转化为云盘", description = "将云盘镜像转化为云盘，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMDI, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected ConvertDiskImageToDisk convertDiskImageToDisk;

	@FunctionDescriber(shortName = "删除云盘镜像", description = "删除云盘镜像，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMDI, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected DeleteDiskImage deleteDiskImage;
	
	@FunctionDescriber(shortName = "创建云盘镜像", description = "创建云盘镜像，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = "", 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected CreateDiskImage createDiskImage;
	
	public ConvertDiskImageToDisk getConvertDiskImageToDisk() {
		return convertDiskImageToDisk;
	}
	
	public void setConvertDiskImageToDisk(ConvertDiskImageToDisk convertDiskImageToDisk) {
		this.convertDiskImageToDisk = convertDiskImageToDisk;
	}
	
	public DeleteDiskImage getDeleteDiskImage() {
		return deleteDiskImage;
	}
	
	public void setDeleteDiskImage(DeleteDiskImage deleteDiskImage) {
		this.deleteDiskImage = deleteDiskImage;
	}
	
	public CreateDiskImage getCreateDiskImage() {
		return createDiskImage;
	}
	
	public void setCreateDiskImage(CreateDiskImage createDiskImage) {
		this.createDiskImage = createDiskImage;
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class ConvertDiskImageToDisk {

		@ParameterDescriber(required = true, description = "目标存储池名，用于存储转化的云盘", constraint = "由4-100位的数字和小写字母组成，已创建出的存储池", example = "pool2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String targetPool;
		
		@ParameterDescriber(required = true, description = "云盘镜像所在的存储池名", constraint = "由4-100位的数字和小写字母组成，已创建出的存储池", example = "pool2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String sourcePool;

		@ParameterDescriber(required = true, description = "存储池的类型", constraint = "只能是dir，uus，nfs，glusterfs之一", example = "dir")
		@Pattern(regexp = RegExpUtils.POOL_TYPE_PATTERN)
		protected String type;


		public String getTargetPool() {
			return targetPool;
		}

		public void setTargetPool(String targetPool) {
			this.targetPool = targetPool;
		}

		public String getSourcePool() {
			return sourcePool;
		}

		public void setSourcePool(String sourcePool) {
			this.sourcePool = sourcePool;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class DeleteDiskImage {

		@ParameterDescriber(required = true, description = "目标存储池名", constraint = "由4-100位的数字和小写字母组成，已创建出的存储池", example = "pool2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String targetPool;

		public String getTargetPool() {
			return targetPool;
		}

		public void setTargetPool(String targetPool) {
			this.targetPool = targetPool;
		}
		
		
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CreateDiskImage {

		@ParameterDescriber(required = true, description = "要转化为云盘镜像的源文件路径", constraint = "路径必须在/var/lib/libvirt下，18-1024位，只允许小写、字母、中划线和圆点", example = "/var/lib/libvirt/test.qcow2")
		@Pattern(regexp = RegExpUtils.PATH_PATTERN)
		protected String source;
		
		@ParameterDescriber(required = true, description = "目标存储池名", constraint = "由4-100位的数字和小写字母组成，已创建出的存储池", example = "pool2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String targetPool;

		public String getTargetPool() {
			return targetPool;
		}

		public void setTargetPool(String targetPool) {
			this.targetPool = targetPool;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}
	}
	
}
