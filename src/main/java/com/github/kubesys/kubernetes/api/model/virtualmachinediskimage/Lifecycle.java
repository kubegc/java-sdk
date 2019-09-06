/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model.virtualmachinediskimage;

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
@Parent(value = "VirtualMachineDiskImage", desc = "云盘模板，主要是指大小和文件格式等")
public class Lifecycle {

	@Function(shortName = "将云盘镜像转化为云盘", description = "将云盘镜像转化为云盘，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMDI, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected ConvertDiskImageToDisk convertDiskImageToDisk;

	@Function(shortName = "删除云盘镜像", description = "删除云盘镜像，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMDI, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected DeleteDiskImage deleteDiskImage;
	
	@Function(shortName = "创建云盘镜像", description = "创建云盘镜像，" 
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

		@Parameter(required = true, description = "转化的云盘所属的存储池名", constraint = "由6-32位的数字和小写字母组成，已创建出的存储池", example = "pool2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String pool;

		public String getPool() {
			return pool;
		}

		public void setPool(String pool) {
			this.pool = pool;
		}
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class DeleteDiskImage {
		
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CreateDiskImage {

		@Parameter(required = true, description = "要转化为云盘镜像的云盘所在的路径", constraint = "路径必须在/var/lib/libvirt下，18-1024位，只允许小写、字母、中划线和圆点", example = "/var/lib/libvirt/test.qcow2")
		@Pattern(regexp = RegExpUtils.PATH_PATTERN)
		protected String source;

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}
	}
	
}
