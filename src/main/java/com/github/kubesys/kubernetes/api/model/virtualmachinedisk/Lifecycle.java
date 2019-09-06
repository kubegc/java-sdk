/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model.virtualmachinedisk;

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
@Parent(value = "VirtualMachineDisk", desc = "云盘是指未格式化的云盘")
public class Lifecycle {

	@Function(shortName = "删除云盘", description = "删除云盘，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMD, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected DeleteDisk deleteDisk;

	@Function(shortName = "调整云盘大小", description = "调整云盘大小，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMD, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected ResizeDisk resizeDisk;

	@Function(shortName = "创建云盘", description = "创建云盘，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = "", 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected CreateDisk createDisk;
	
	@Function(shortName = "从镜像创建云盘", description = "从镜像创建云盘，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = "", 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected CreateDiskFromDiskImage createDiskFromDiskImage;
	
	@Function(shortName = "转化为云盘镜像", description = "转化为云盘镜像，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMD, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected ConvertDiskToDiskImage convertDiskToDiskImage;

	@Function(shortName = "克隆云盘", description = "克隆云盘，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMD, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected CloneDisk cloneDisk;
	
	@Function(shortName = "创建云盘快照", description = "创建云盘快照，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMD, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected CreateDiskSnapshot createDiskSnapshot;
	
	@Function(shortName = "从云盘快照恢复", description = "从云盘快照恢复，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMD, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected RevertDiskSnapshot revertDiskSnapshot;
	
	@Function(shortName = "删除云盘快照", description = "删除云盘快照，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMD, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected DeleteDiskSnapshot deleteDiskSnapshot;
	
	public CreateDiskSnapshot getCreateDiskSnapshot() {
		return createDiskSnapshot;
	}

	public void setCreateDiskSnapshot(CreateDiskSnapshot createDiskSnapshot) {
		this.createDiskSnapshot = createDiskSnapshot;
	}

	public RevertDiskSnapshot getRevertDiskSnapshot() {
		return revertDiskSnapshot;
	}

	public void setRevertDiskSnapshot(RevertDiskSnapshot revertDiskSnapshot) {
		this.revertDiskSnapshot = revertDiskSnapshot;
	}

	public DeleteDiskSnapshot getDeleteDiskSnapshot() {
		return deleteDiskSnapshot;
	}

	public void setDeleteDiskSnapshot(DeleteDiskSnapshot deleteDiskSnapshot) {
		this.deleteDiskSnapshot = deleteDiskSnapshot;
	}
	
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

		@Parameter(required = true, description = "云盘文件的类型", constraint = "raw,bochs,qcow,qcow2,qed,vmdk", example = "qcow2")
		@Pattern(regexp = RegExpUtils.DISK_TYPE_PATTERN)
		protected String format;

		@Parameter(required = true, description = "创建云盘使用的存储池名", constraint = "已创建出的存储池", example = "pool2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String pool;

		protected String backing_vol;

		@Parameter(required = true, description = "云盘空间大小", constraint = "10000000000-999999999999（单位：Byte）", example = "10485760")
		@Pattern(regexp = RegExpUtils.DISK_SIZE_PATTERN)
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

		@Parameter(required = true, description = "云盘所在的存储池名", constraint = "已创建出的存储池", example = "pool2")
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

		@Parameter(required = true, description = "云盘所在的存储池名", constraint = "已创建出的存储池", example = "pool2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String pool;

		@Parameter(required = true, description = "扩容后的云盘空间大小", constraint = "10000000000-999999999999（单位：Byte），需要比以前的云盘空间大", example = "10485760")
		@Pattern(regexp = RegExpUtils.DISK_SIZE_PATTERN)
		protected String capacity;

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

		@Parameter(required = true, description = "创建云盘所在的存储池名", constraint = "由6-32位的数字和小写字母组成，已创建出的存储池", example = "pool2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String pool;

		@Parameter(required = true, description = "云盘镜像名", constraint = "由6-32位的数字和小写字母组成，已存在的云盘镜像名", example = "image2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
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

		@Parameter(required = true, description = "云盘所在的存储池名", constraint = "由6-32位的数字和小写字母组成，已创建出的存储池", example = "pool2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String pool;

		@Parameter(required = true, description = "新云盘的名字", constraint = "由6-32位的数字和小写字母组成", example = "newdisk")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
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

		@Parameter(required = true, description = "云盘所在的存储池名", constraint = "由6-32位的数字和小写字母组成，已创建出的存储池", example = "pool2")
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
	public static class ConvertImageToVM {
		
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CreateDiskSnapshot {
		
		@Parameter(required = true, description = "云盘所在的存储池名", constraint = "由6-32位的数字和小写字母组成，已创建出的存储池", example = "pool2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String pool;
		
		@Parameter(required = true, description = "快照的名字", constraint = "由6-32位的数字和小写字母组成", example = "snap1")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String snapshotname;

		public String getPool() {
			return pool;
		}

		public void setPool(String pool) {
			this.pool = pool;
		}

		public String getSnapshotname() {
			return snapshotname;
		}

		public void setSnapshotname(String snapshotname) {
			this.snapshotname = snapshotname;
		}
		
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class RevertDiskSnapshot {
		
		@Parameter(required = true, description = "云盘所在的存储池名", constraint = "由6-32位的数字和小写字母组成，已创建出的存储池", example = "pool2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String pool;
		
		@Parameter(required = true, description = "快照的名字", constraint = "由6-32位的数字和小写字母组成", example = "snap1")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String snapshotname;

		public String getPool() {
			return pool;
		}

		public void setPool(String pool) {
			this.pool = pool;
		}

		public String getSnapshotname() {
			return snapshotname;
		}

		public void setSnapshotname(String snapshotname) {
			this.snapshotname = snapshotname;
		}
		
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class DeleteDiskSnapshot {
		
		@Parameter(required = true, description = "云盘所在的存储池名", constraint = "由6-32位的数字和小写字母组成，已创建出的存储池", example = "pool2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String pool;
		
		@Parameter(required = true, description = "快照的名字", constraint = "由6-32位的数字和小写字母组成", example = "snap1")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String snapshotname;

		public String getPool() {
			return pool;
		}

		public void setPool(String pool) {
			this.pool = pool;
		}

		public String getSnapshotname() {
			return snapshotname;
		}

		public void setSnapshotname(String snapshotname) {
			this.snapshotname = snapshotname;
		}
		
	}
	
}
