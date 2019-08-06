/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model.virtualmachineimage;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author xuyuanjia2017@otcaix.iscas.ac.cn
 * @author xianghao16@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @since Thu Jun 22 21:36:39 CST 2019
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
public class Lifecycle {

	protected CreateImage createImage;
	
	protected DeleteImage deleteImage;
	
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
		
		protected String name;
		
		protected String disk;

		public CreateImage() {
			super();
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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
		
		protected String name;

		public DeleteImage() {
			super();
			// TODO Auto-generated constructor stub
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class ConvertImageToVM {
		
	}
	
}
