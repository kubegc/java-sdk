/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model.virtualmachinediskimage;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author  wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.0.0
 * @since   2019/9/4
 * 
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
public class Lifecycle {

	protected ConvertDiskImageToDisk convertDiskImageToDisk;

	protected DeleteDiskImage deleteDiskImage;
	
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
		
		protected String source;

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}
	}
	
}
