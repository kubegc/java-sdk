/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model.virtualmachineimage;

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
@Parent(value = "VirtualMachineImage", desc = "虚拟机模板，包括CPU、内存、OS等信息")
public class Lifecycle {

	@Function(shortName = "创建虚拟机镜像", description = "创建虚拟机镜像，" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
		prerequisite = "", 
		exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected CreateImage createImage;
	
	@Function(shortName = "删除虚拟机镜像", description = "删除虚拟机镜像，" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
		prerequisite = ExtendedKubernetesConstants.DESC_FUNCTION_VMI, 
		exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected DeleteImage deleteImage;
	
	@Function(shortName = "将虚拟机镜像转化为虚拟机", description = "将虚拟机镜像转化为虚拟机，" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
		prerequisite = ExtendedKubernetesConstants.DESC_FUNCTION_VMI, 
		exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected ConvertImageToVM convertImageToVM;

	public Lifecycle() {

	}

	public ConvertImageToVM getConvertImageToVM() {
		return convertImageToVM;
	}

	public void setConvertImageToVM(ConvertImageToVM convertImageToVM) {
		this.convertImageToVM = convertImageToVM;
	}

	public CreateImage getCreateImage() {
		return createImage;
	}

	public void setCreateImage(CreateImage createImage) {
		this.createImage = createImage;
	}

	public DeleteImage getDeleteImage() {
		return deleteImage;
	}

	public void setDeleteImage(DeleteImage deleteImage) {
		this.deleteImage = deleteImage;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CreateImage {

		@Parameter(required = true, description = "存储镜像的磁盘", constraint = "有效完整的磁盘路径", example = "/var/lib/aaa.qcow2")
		protected String disk;

		public CreateImage() {
			super();
		}

		public String getDisk() {
			return disk;
		}

		public void setDisk(String disk) {
			this.disk = disk;
		}
		
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class DeleteImage {
		
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class ConvertImageToVM {
		
	}
	
}
