/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot;

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
@Parent(value = "VirtualMachineSnapshot", desc = "虚拟机/云盘快照")
public class Lifecycle {

	@Function(shortName = "删除虚拟机/云盘快照", description = "删除虚拟机/云盘快照，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMSN, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected DeleteSnapshot deleteSnapshot;

	@Function(shortName = "创建虚拟机/云盘快照", description = "创建虚拟机/云盘快照，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = "", 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected CreateSnapshot createSnapshot;
	
	@Function(shortName = "恢复成虚拟机/云盘", description = "恢复成虚拟机/云盘，" 
			+ AnnotationUtils.DESC_FUNCTION_DESC, 
		prerequisite = AnnotationUtils.DESC_FUNCTION_VMSN, 
		exception = AnnotationUtils.DESC_FUNCTION_EXEC)
	protected RevertVirtualMachine revertVirtualMachine;

	public Lifecycle() {

	}

	public DeleteSnapshot getDeleteSnapshot() {
		return deleteSnapshot;
	}

	public void setDeleteSnapshot(DeleteSnapshot deleteSnapshot) {
		this.deleteSnapshot = deleteSnapshot;
	}

	public CreateSnapshot getCreateSnapshot() {
		return createSnapshot;
	}

	public void setCreateSnapshot(CreateSnapshot createSnapshot) {
		this.createSnapshot = createSnapshot;
	}
	
	public RevertVirtualMachine getRevertVirtualMachine() {
		return revertVirtualMachine;
	}

	public void setRevertVirtualMachine(RevertVirtualMachine revertVirtualMachine) {
		this.revertVirtualMachine = revertVirtualMachine;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CreateSnapshot {

		protected String diskspec;

		protected Boolean no_metadata;

		protected Boolean disk_only;

		protected String memspec;

		protected String description;

		protected Boolean quiesce;

		protected Boolean reuse_external;

		protected Boolean halt;

		protected Boolean atomic;

		@Parameter(required = true, description = "要恢复到快照状态的虚拟机name", constraint = "已存在的虚拟机名", example = "vm1")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String domain;

		protected Boolean live;

		public CreateSnapshot() {

		}

		public void setDiskspec(String diskspec) {
			this.diskspec = diskspec;
		}

		public String getDiskspec() {
			return this.diskspec;
		}

		public void setNo_metadata(Boolean no_metadata) {
			this.no_metadata = no_metadata;
		}

		public Boolean getNo_metadata() {
			return this.no_metadata;
		}

		public void setDisk_only(Boolean disk_only) {
			this.disk_only = disk_only;
		}

		public Boolean getDisk_only() {
			return this.disk_only;
		}

		public void setMemspec(String memspec) {
			this.memspec = memspec;
		}

		public String getMemspec() {
			return this.memspec;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getDescription() {
			return this.description;
		}

		public void setQuiesce(Boolean quiesce) {
			this.quiesce = quiesce;
		}

		public Boolean getQuiesce() {
			return this.quiesce;
		}

		public void setReuse_external(Boolean reuse_external) {
			this.reuse_external = reuse_external;
		}

		public Boolean getReuse_external() {
			return this.reuse_external;
		}

		public void setHalt(Boolean halt) {
			this.halt = halt;
		}

		public Boolean getHalt() {
			return this.halt;
		}

		public void setAtomic(Boolean atomic) {
			this.atomic = atomic;
		}

		public Boolean getAtomic() {
			return this.atomic;
		}

		public void setDomain(String domain) {
			this.domain = domain;
		}

		public String getDomain() {
			return this.domain;
		}

		public void setLive(Boolean live) {
			this.live = live;
		}

		public Boolean getLive() {
			return this.live;
		}
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class DeleteSnapshot {

		protected Boolean metadata;

		protected Boolean children;

		protected Boolean children_only;

		@Parameter(required = true, description = "要删除快照的虚拟机名字", constraint = "由8-32位的数字和小写字母组成，已存在的虚拟机名", example = "vm1")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String domain;

		public DeleteSnapshot() {

		}

		public void setMetadata(Boolean metadata) {
			this.metadata = metadata;
		}

		public Boolean getMetadata() {
			return this.metadata;
		}

		public void setChildren(Boolean children) {
			this.children = children;
		}

		public Boolean getChildren() {
			return this.children;
		}

		public void setChildren_only(Boolean children_only) {
			this.children_only = children_only;
		}

		public Boolean getChildren_only() {
			return this.children_only;
		}

		public void setDomain(String domain) {
			this.domain = domain;
		}

		public String getDomain() {
			return this.domain;
		}

	}
	

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class RevertVirtualMachine {

		@Parameter(required = true, description = "要恢复到快照状态的虚拟机name", constraint = "由8-32位的数字和小写字母组成，已存在的虚拟机名", example = "vm1")
		@Pattern(regexp = RegExpUtils.NAME_PATTERN)
		protected String domain;

		@Parameter(required = false, description = "恢复到快照的状态后，是否将虚拟机转换到开机状态", constraint=AnnotationUtils.DESC_BOOLEAN, example = "true")
		protected Boolean running;
		
		protected Boolean paused;
		
		protected Boolean force;

		public Boolean getRunning() {
			return running;
		}
		
		public String getDomain() {
			return domain;
		}
		
		public void setDomain(String domain) {
			this.domain = domain;
		}

		public void setRunning(Boolean running) {
			this.running = running;
		}

		public Boolean getPaused() {
			return paused;
		}

		public void setPaused(Boolean paused) {
			this.paused = paused;
		}

		public Boolean getForce() {
			return force;
		}

		public void setForce(Boolean force) {
			this.force = force;
		}
		
	}
	
}
