/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model.virtualmachinedisk;

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

	protected DeleteDisk deleteDisk;

	protected ResizeDisk resizeDisk;

	protected CreateDisk createDisk;
	
	protected CreateDiskFromDiskImage createDiskFromDiskImage;
	
	protected ConvertDiskToDiskImage convertDiskToDiskImage;

	protected CloneDisk cloneDisk;
	
	public ConvertDiskToDiskImage getConvertDiskToDiskImage() {
		return convertDiskToDiskImage;
	}
	
	public void setConvertDiskToDiskImage(ConvertDiskToDiskImage convertDiskToDiskImage) {
		this.convertDiskToDiskImage = convertDiskToDiskImage;
	}
	
	public CreateDiskFromDiskImage getCreateDiskFromDiskImage() {
		return createDiskFromDiskImage;
	}
	
	public void setCreateDiskFromDiskImage(CreateDiskFromDiskImage createDiskFromDiskImage) {
		this.createDiskFromDiskImage = createDiskFromDiskImage;
	}
	
	public DeleteDisk getDeleteDisk() {
		return deleteDisk;
	}

	public void setDeleteDisk(DeleteDisk deleteDisk) {
		this.deleteDisk = deleteDisk;
	}

	public ResizeDisk getResizeDisk() {
		return resizeDisk;
	}

	public void setResizeDisk(ResizeDisk resizeDisk) {
		this.resizeDisk = resizeDisk;
	}

	public CreateDisk getCreateDisk() {
		return createDisk;
	}

	public void setCreateDisk(CreateDisk createDisk) {
		this.createDisk = createDisk;
	}

	public CloneDisk getCloneDisk() {
		return cloneDisk;
	}

	public void setCloneDisk(CloneDisk cloneDisk) {
		this.cloneDisk = cloneDisk;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CreateDisk {

		protected String allocation;

		protected String backing_vol_format;

		protected Boolean prealloc_metadata;

		protected String format;

		protected String pool;

		protected String backing_vol;

		protected String capacity;

		public CreateDisk() {

		}

		public void setAllocation(String allocation) {
			this.allocation = allocation;
		}

		public String getAllocation() {
			return this.allocation;
		}

		public void setBacking_vol_format(String backing_vol_format) {
			this.backing_vol_format = backing_vol_format;
		}

		public String getBacking_vol_format() {
			return this.backing_vol_format;
		}

		public void setPrealloc_metadata(Boolean prealloc_metadata) {
			this.prealloc_metadata = prealloc_metadata;
		}

		public Boolean getPrealloc_metadata() {
			return this.prealloc_metadata;
		}

		public void setFormat(String format) {
			this.format = format;
		}

		public String getFormat() {
			return this.format;
		}

		public void setPool(String pool) {
			this.pool = pool;
		}

		public String getPool() {
			return this.pool;
		}

		public void setBacking_vol(String backing_vol) {
			this.backing_vol = backing_vol;
		}

		public String getBacking_vol() {
			return this.backing_vol;
		}

		public void setCapacity(String capacity) {
			this.capacity = capacity;
		}

		public String getCapacity() {
			return this.capacity;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class DeleteDisk {

		protected Boolean delete_snapshots;

		protected String pool;

		public void setDelete_snapshots(Boolean delete_snapshots) {
			this.delete_snapshots = delete_snapshots;
		}

		public Boolean getDelete_snapshots() {
			return this.delete_snapshots;
		}

		public void setPool(String pool) {
			this.pool = pool;
		}

		public String getPool() {
			return this.pool;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class ResizeDisk {

		protected Boolean allocate;

		protected Boolean shrink;

		protected Boolean delta;

		protected String pool;

		protected String capacity;

		public ResizeDisk() {

		}

		public void setAllocate(Boolean allocate) {
			this.allocate = allocate;
		}

		public Boolean getAllocate() {
			return this.allocate;
		}

		public void setShrink(Boolean shrink) {
			this.shrink = shrink;
		}

		public Boolean getShrink() {
			return this.shrink;
		}

		public void setDelta(Boolean delta) {
			this.delta = delta;
		}

		public Boolean getDelta() {
			return this.delta;
		}

		public void setPool(String pool) {
			this.pool = pool;
		}

		public String getPool() {
			return this.pool;
		}

		public void setCapacity(String capacity) {
			this.capacity = capacity;
		}

		public String getCapacity() {
			return this.capacity;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CreateDiskFromDiskImage {
		
		protected String pool;
		
		protected String image;

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public String getPool() {
			return pool;
		}

		public void setPool(String pool) {
			this.pool = pool;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CloneDisk {

		protected Boolean reflink;

		protected Boolean prealloc_metadata;

		protected String pool;

		protected String newname;

		public CloneDisk() {

		}

		public void setReflink(Boolean reflink) {
			this.reflink = reflink;
		}

		public Boolean getReflink() {
			return this.reflink;
		}

		public void setPrealloc_metadata(Boolean prealloc_metadata) {
			this.prealloc_metadata = prealloc_metadata;
		}

		public Boolean getPrealloc_metadata() {
			return this.prealloc_metadata;
		}

		public void setPool(String pool) {
			this.pool = pool;
		}

		public String getPool() {
			return this.pool;
		}

		public void setNewname(String newname) {
			this.newname = newname;
		}

		public String getNewname() {
			return this.newname;
		}
	}

	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class ConvertDiskToDiskImage {
		
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
	public static class ConvertImageToVM {
		
	}
	
}
