/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model.virtualmachinedisk;

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
@ClassDescriber(value = "VirtualMachineDisk", desc = "云盘是指未格式化的云盘")
public class Lifecycle {

	@FunctionDescriber(shortName = "删除云盘", description = "删除云盘，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMD, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected DeleteDisk deleteDisk;

	@FunctionDescriber(shortName = "调整云盘大小", description = "调整云盘大小，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMD, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected ResizeDisk resizeDisk;

	@FunctionDescriber(shortName = "创建云盘", description = "创建云盘，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = "", 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected CreateDisk createDisk;
	
	@FunctionDescriber(shortName = "从镜像创建云盘", description = "从镜像创建云盘，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = "", 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected CreateDiskFromDiskImage createDiskFromDiskImage;
	
	@FunctionDescriber(shortName = "转化为云盘镜像", description = "转化为云盘镜像，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMD, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected ConvertDiskToDiskImage convertDiskToDiskImage;

	@FunctionDescriber(shortName = "克隆云盘", description = "克隆云盘，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMD, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected CloneDisk cloneDisk;
	
	@FunctionDescriber(shortName = "创建云盘内部快照", description = "创建云盘内部快照，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMD, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected CreateDiskInternalSnapshot createDiskInternalSnapshot;
	
	@FunctionDescriber(shortName = "从云盘内部快照恢复", description = "从云盘内部快照恢复，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMD, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected RevertDiskInternalSnapshot revertDiskInternalSnapshot;
	
	@FunctionDescriber(shortName = "删除云盘内部快照", description = "删除云盘内部快照，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMD, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected DeleteDiskInternalSnapshot deleteDiskInternalSnapshot;
	
	@FunctionDescriber(shortName = "创建云盘外部快照", description = "创建云盘外部快照，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMD, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected CreateDiskExternalSnapshot createDiskExternalSnapshot;
	
	@FunctionDescriber(shortName = "从云盘外部快照恢复", description = "从云盘外部快照恢复，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMD, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected RevertDiskExternalSnapshot revertDiskExternalSnapshot;
	
	@FunctionDescriber(shortName = "删除云盘外部快照", description = "删除云盘外部快照，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMD, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected DeleteDiskExternalSnapshot deleteDiskExternalSnapshot;
	
	public CreateDiskInternalSnapshot getCreateDiskSnapshot() {
		return createDiskInternalSnapshot;
	}

	public void setCreateDiskSnapshot(CreateDiskInternalSnapshot createDiskSnapshot) {
		this.createDiskInternalSnapshot = createDiskSnapshot;
	}

	public RevertDiskInternalSnapshot getRevertDiskSnapshot() {
		return revertDiskInternalSnapshot;
	}

	public void setRevertDiskSnapshot(RevertDiskInternalSnapshot revertDiskSnapshot) {
		this.revertDiskInternalSnapshot = revertDiskSnapshot;
	}

	public DeleteDiskInternalSnapshot getDeleteDiskSnapshot() {
		return deleteDiskInternalSnapshot;
	}

	public void setDeleteDiskSnapshot(DeleteDiskInternalSnapshot deleteDiskSnapshot) {
		this.deleteDiskInternalSnapshot = deleteDiskSnapshot;
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

	public CreateDiskInternalSnapshot getCreateDiskInternalSnapshot() {
		return createDiskInternalSnapshot;
	}

	public void setCreateDiskInternalSnapshot(CreateDiskInternalSnapshot createDiskInternalSnapshot) {
		this.createDiskInternalSnapshot = createDiskInternalSnapshot;
	}

	public RevertDiskInternalSnapshot getRevertDiskInternalSnapshot() {
		return revertDiskInternalSnapshot;
	}

	public void setRevertDiskInternalSnapshot(RevertDiskInternalSnapshot revertDiskInternalSnapshot) {
		this.revertDiskInternalSnapshot = revertDiskInternalSnapshot;
	}

	public DeleteDiskInternalSnapshot getDeleteDiskInternalSnapshot() {
		return deleteDiskInternalSnapshot;
	}

	public void setDeleteDiskInternalSnapshot(DeleteDiskInternalSnapshot deleteDiskInternalSnapshot) {
		this.deleteDiskInternalSnapshot = deleteDiskInternalSnapshot;
	}

	public CreateDiskExternalSnapshot getCreateDiskExternalSnapshot() {
		return createDiskExternalSnapshot;
	}

	public void setCreateDiskExternalSnapshot(CreateDiskExternalSnapshot createDiskExternalSnapshot) {
		this.createDiskExternalSnapshot = createDiskExternalSnapshot;
	}

	public DeleteDiskExternalSnapshot getDeleteDiskExternalSnapshot() {
		return deleteDiskExternalSnapshot;
	}

	public void setDeleteDiskExternalSnapshot(DeleteDiskExternalSnapshot deleteDiskExternalSnapshot) {
		this.deleteDiskExternalSnapshot = deleteDiskExternalSnapshot;
	}

	public RevertDiskExternalSnapshot getRevertDiskExternalSnapshot() {
		return revertDiskExternalSnapshot;
	}

	public void setRevertDiskExternalSnapshot(RevertDiskExternalSnapshot revertDiskExternalSnapshot) {
		this.revertDiskExternalSnapshot = revertDiskExternalSnapshot;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CreateDisk {

		@ParameterDescriber(required = true, description = "存储池的类型", constraint = "只能是dir，uus，nfs，glusterfs之一", example = "dir")
		@Pattern(regexp = RegExpUtils.POOL_TYPE_PATTERN)
		protected String type;

		protected String allocation;

		@ParameterDescriber(required = true, description = "根云盘文件的类型", constraint = "qcow2", example = "qcow2")
		@Pattern(regexp = RegExpUtils.DISK_TYPE_PATTERN)
		protected String backing_vol_format;

		protected Boolean prealloc_metadata;

		@ParameterDescriber(required = true, description = "云盘文件的类型", constraint = "qcow2", example = "qcow2")
		@Pattern(regexp = RegExpUtils.DISK_TYPE_PATTERN)
		protected String format;

		@ParameterDescriber(required = true, description = "创建云盘使用的存储池名", constraint = "已创建出的存储池", example = "pool2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String pool;

		@ParameterDescriber(required = true, description = "根云盘的名字", constraint = "已创建出的云盘", example = "volume1")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String backing_vol;

		@ParameterDescriber(required = true, description = "云盘空间大小,1G到1T", constraint = "1000000000-999999999999（单位：Byte）", example = "‭10,737,418,240‬")
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


		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class DeleteDisk {

		@ParameterDescriber(required = true, description = "存储池的类型", constraint = "只能是dir，uus，nfs，glusterfs之一", example = "dir")
		@Pattern(regexp = RegExpUtils.POOL_TYPE_PATTERN)
		protected String type;

		@ParameterDescriber(required = false, description = "删除所有快照", constraint = AnnotationUtils.DESC_BOOLEAN, example = "true")
		protected Boolean delete_snapshots;

		@ParameterDescriber(required = true, description = "云盘所在的存储池名", constraint = "已创建出的存储池", example = "pool2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
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

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class ResizeDisk {

		@ParameterDescriber(required = true, description = "存储池的类型", constraint = "只能是dir，uus，nfs，glusterfs之一", example = "dir")
		@Pattern(regexp = RegExpUtils.POOL_TYPE_PATTERN)
		protected String type;

		protected Boolean allocate;

		protected Boolean shrink;

		protected Boolean delta;

		@ParameterDescriber(required = true, description = "云盘所在的存储池名", constraint = "已创建出的存储池", example = "pool2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String pool;

		@ParameterDescriber(required = true, description = "扩容后的云盘空间大小, 1G到1T", constraint = "1000000000-999999999999（单位：Byte），需要比以前的云盘空间大", example = "‭10,737,418,240‬")
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

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CreateDiskFromDiskImage {
		
		@ParameterDescriber(required = true, description = "存储池的类型", constraint = "只能是dir，uus，nfs，glusterfs之一", example = "dir")
		@Pattern(regexp = RegExpUtils.POOL_TYPE_PATTERN)
		protected String type;

		@ParameterDescriber(required = true, description = "创建云盘所在的存储池名", constraint = "由4-100位的数字和小写字母组成，已创建出的存储池", example = "pool2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String pool;

		@ParameterDescriber(required = true, description = "云盘镜像名", constraint = "由4-100位的数字和小写字母组成，已存在的云盘镜像名", example = "image2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String image;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

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

		@ParameterDescriber(required = true, description = "存储池的类型", constraint = "只能是dir，uus，nfs，glusterfs之一", example = "dir")
		@Pattern(regexp = RegExpUtils.POOL_TYPE_PATTERN)
		protected String type;

		protected Boolean reflink;

		protected Boolean prealloc_metadata;

		@ParameterDescriber(required = true, description = "云盘所在的存储池名", constraint = "由4-100位的数字和小写字母组成，已创建出的存储池", example = "pool2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String pool;

		@ParameterDescriber(required = true, description = "新云盘的名字", constraint = "由4-100位的数字和小写字母组成", example = "newdisk")
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

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
	}

	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class ConvertDiskToDiskImage {
		
		@ParameterDescriber(required = true, description = "存储池的类型", constraint = "只能是dir，uus，nfs，glusterfs之一", example = "dir")
		@Pattern(regexp = RegExpUtils.POOL_TYPE_PATTERN)
		protected String type;

		@ParameterDescriber(required = true, description = "云盘所在的存储池名", constraint = "由4-100位的数字和小写字母组成，已创建出的存储池", example = "pool2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String pool;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
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
	public static class ConvertImageToVM {
		
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CreateDiskInternalSnapshot {
		
		@ParameterDescriber(required = true, description = "存储池的类型", constraint = "只能是dir，uus，nfs，glusterfs之一", example = "dir")
		@Pattern(regexp = RegExpUtils.POOL_TYPE_PATTERN)
		protected String type;
		
		@ParameterDescriber(required = true, description = "云盘所在的存储池名", constraint = "由4-100位的数字和小写字母组成，已创建出的存储池", example = "pool2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String pool;
		
		@ParameterDescriber(required = true, description = "快照的名字", constraint = "由4-100位的数字和小写字母组成", example = "snap1")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String snapshotname;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

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
	public static class RevertDiskInternalSnapshot {
		
		@ParameterDescriber(required = true, description = "存储池的类型", constraint = "只能是dir，uus，nfs，glusterfs之一", example = "dir")
		@Pattern(regexp = RegExpUtils.POOL_TYPE_PATTERN)
		protected String type;
		
		@ParameterDescriber(required = true, description = "云盘所在的存储池名", constraint = "由4-100位的数字和小写字母组成，已创建出的存储池", example = "pool2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String pool;
		
		@ParameterDescriber(required = true, description = "快照的名字", constraint = "由4-100位的数字和小写字母组成", example = "snap1")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String snapshotname;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

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
	public static class DeleteDiskInternalSnapshot {
		
		@ParameterDescriber(required = true, description = "存储池的类型", constraint = "只能是dir，uus，nfs，glusterfs之一", example = "dir")
		@Pattern(regexp = RegExpUtils.POOL_TYPE_PATTERN)
		protected String type;
		
		@ParameterDescriber(required = true, description = "云盘所在的存储池名", constraint = "由4-100位的数字和小写字母组成，已创建出的存储池", example = "pool2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String pool;
		
		@ParameterDescriber(required = true, description = "快照的名字", constraint = "由4-100位的数字和小写字母组成", example = "snap1")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String snapshotname;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

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
	public static class CreateDiskExternalSnapshot extends CreateDisk{

	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class RevertDiskExternalSnapshot {

		@ParameterDescriber(required = true, description = "存储池的类型", constraint = "只能是dir，uus，nfs，glusterfs之一", example = "dir")
		@Pattern(regexp = RegExpUtils.POOL_TYPE_PATTERN)
		protected String type;
		
		@ParameterDescriber(required = true, description = "云盘所在的存储池名", constraint = "由4-100位的数字和小写字母组成，已创建出的存储池", example = "pool2")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String pool;
		
		@ParameterDescriber(required = true, description = "快照的名字", constraint = "由4-100位的数字和小写字母组成", example = "snap1")
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

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class DeleteDiskExternalSnapshot extends DeleteDisk{

	}
	
}
