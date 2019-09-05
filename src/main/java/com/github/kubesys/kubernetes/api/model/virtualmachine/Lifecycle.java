/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model.virtualmachine;

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
@Parent(value = "VirtualMachine", desc = "虚拟机是指安装了OS的磁盘")
public class Lifecycle {

	@Function(shortName = "虚拟机内存扩容", description = "对虚拟机内存扩容，" 
					+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
	  prerequisite = ExtendedKubernetesConstants.DESC_FUNCTION_VM, 
	  exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected ResizeRAM resizeRAM;

	@Function(shortName = "虚拟机暂停", description = "对运行的虚拟机进行暂停操作，已经暂停虚拟机执行暂停会报错" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
	  prerequisite = ExtendedKubernetesConstants.DESC_FUNCTION_VM, 
	  exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected SuspendVM suspendVM;

	@Function(shortName = "强制关闭虚拟机", description = "强制关闭虚拟机，虚拟机在某些情况下无法关闭，本质相当于拔掉电源" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
	  prerequisite = ExtendedKubernetesConstants.DESC_FUNCTION_VM, 
	  exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected StopVMForce stopVMForce;

	@Function(shortName = "虚拟机卸载设备", description = "卸载GPU、云盘、网卡等资源，" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
	  prerequisite = ExtendedKubernetesConstants.DESC_FUNCTION_VM, 
	  exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected UnplugDevice unplugDevice;

	@Function(shortName = "虚拟机卸载网卡", description = "卸载网卡，" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
	  prerequisite = ExtendedKubernetesConstants.DESC_FUNCTION_VM, 
	  exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected UnplugNIC unplugNIC;

	@Function(shortName = "虚拟机迁移", description = "虚拟机迁移，必须依赖共享存储" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
	  prerequisite = ExtendedKubernetesConstants.DESC_FUNCTION_VM, 
	  exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected MigrateVM migrateVM;

	@Function(shortName = "虚拟机CPU设置", description = "修改虚拟机CPU个数" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
	  prerequisite = ExtendedKubernetesConstants.DESC_FUNCTION_VM, 
	  exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected ChangeNumberOfCPU changeNumberOfCPU;

	@Function(shortName = "恢复虚拟机", description = "恢复暂停的虚拟机，对运行的虚拟机执行恢复会报错" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
	  prerequisite = ExtendedKubernetesConstants.DESC_FUNCTION_VM, 
	  exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected ResumeVM resumeVM;

	@Function(shortName = "虚拟机添加云盘", description = "添加云盘，云盘必须通过CreateVirtualMachineDisk预先创建好" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
	  prerequisite = ExtendedKubernetesConstants.DESC_FUNCTION_VM + ",或CreateVirtualMachineDisk", 
	  exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected PlugDisk plugDisk;

	@Function(shortName = "虚拟机添加设备", description = "添加GPU、云盘、网卡等，这种方法相对于pluginDisk等可设置高级选项，如QoS" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
	  prerequisite = ExtendedKubernetesConstants.DESC_FUNCTION_VM, 
	  exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected PlugDevice plugDevice;

	@Function(shortName = "强制重启虚拟机", description = "强制重置虚拟机，即强制重启虚拟机" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
	  prerequisite = ExtendedKubernetesConstants.DESC_FUNCTION_VM, 
	  exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected ResetVM resetVM;

	@Function(shortName = "虚拟机卸载云盘", description = "卸载虚拟机云盘" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
	  prerequisite = ExtendedKubernetesConstants.DESC_FUNCTION_VM + ",或CreateVirtualMachineDisk", 
	  exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected UnplugDisk unplugDisk;

	@Function(shortName = "虚拟机关机", description = "关闭虚拟机，但不一定能关闭，如虚拟机中OS受损，对关闭虚拟机再执行关闭会报错" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
	  prerequisite = ExtendedKubernetesConstants.DESC_FUNCTION_VM, 
	  exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected StopVM stopVM;

	@Function(shortName = "启动虚拟机", description = "启动虚拟机，能否正常启动取决于虚拟机OS是否受损，对运行虚拟机执行启动会报错" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
	  prerequisite = ExtendedKubernetesConstants.DESC_FUNCTION_VM, 
	  exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected StartVM startVM;

	@Function(shortName = "删除虚拟机", description = "删除虚拟机，需要先关闭虚拟机" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
	  prerequisite = ExtendedKubernetesConstants.DESC_FUNCTION_VM + "或StopVM，或StopVMForce", 
	  exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected DeleteVM deleteVM;

	@Function(shortName = "通过ISO安装虚拟机", description = "通过光驱安装云OS，光驱必须存在" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
	  prerequisite = "", 
	  exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected CreateAndStartVMFromISO createAndStartVMFromISO;
	
	@Function(shortName = "通过镜像安装虚拟机", description = "通过虚拟机镜像VirtualMachineImage创建云OS" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
	  prerequisite = "", 
	  exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected CreateAndStartVMFromImage createAndStartVMFromImage;

	@Function(shortName = "虚拟机重启", description = "重启虚拟机，能否正常重新启动取决于虚拟机OS是否受损" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
	  prerequisite = ExtendedKubernetesConstants.DESC_FUNCTION_VM, 
	  exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected RebootVM rebootVM;

	@Function(shortName = "虚拟机添加网卡", description = "给虚拟机添加网卡" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
	  prerequisite = ExtendedKubernetesConstants.DESC_FUNCTION_VM, 
	  exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected PlugNIC plugNIC;

	@Function(shortName = "插入或拔出光驱", description = "插入或者拔出光驱" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
	  prerequisite = ExtendedKubernetesConstants.DESC_FUNCTION_VM + "或plugDevice", 
	  exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected ManageISO manageISO;
	
	@Function(shortName = "更换虚拟机OS", description = "更换云主机的OS，云主机必须关机" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
	  prerequisite = ExtendedKubernetesConstants.DESC_FUNCTION_VM, 
	  exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected UpdateOS updateOS;
	
	@Function(shortName = "转化为虚拟机模板", description = "转化为虚拟机镜像" 
			+ ExtendedKubernetesConstants.DESC_FUNCTION_DESC, 
	  prerequisite = ExtendedKubernetesConstants.DESC_FUNCTION_VM, 
	  exception = ExtendedKubernetesConstants.DESC_FUNCTION_EXEC)
	protected ConvertVMToImage convertVMToImage;
	
	public Lifecycle() {

	}

	public ManageISO getManageISO() {
		return manageISO;
	}

	public void setManageISO(ManageISO manageISO) {
		this.manageISO = manageISO;
	}

	public UpdateOS getUpdateOS() {
		return updateOS;
	}

	public void setUpdateOS(UpdateOS updateOS) {
		this.updateOS = updateOS;
	}

	public void setResizeRAM(ResizeRAM resizeRAM) {
		this.resizeRAM = resizeRAM;
	}

	public ResizeRAM getResizeRAM() {
		return this.resizeRAM;
	}

	public void setSuspendVM(SuspendVM suspendVM) {
		this.suspendVM = suspendVM;
	}

	public SuspendVM getSuspendVM() {
		return this.suspendVM;
	}

	public void setStopVMForce(StopVMForce stopVMForce) {
		this.stopVMForce = stopVMForce;
	}

	public StopVMForce getStopVMForce() {
		return this.stopVMForce;
	}

	public void setUnplugDevice(UnplugDevice unplugDevice) {
		this.unplugDevice = unplugDevice;
	}

	public UnplugDevice getUnplugDevice() {
		return this.unplugDevice;
	}

	public void setUnplugNIC(UnplugNIC unplugNIC) {
		this.unplugNIC = unplugNIC;
	}

	public UnplugNIC getUnplugNIC() {
		return this.unplugNIC;
	}

	public void setMigrateVM(MigrateVM migrateVM) {
		this.migrateVM = migrateVM;
	}

	public MigrateVM getMigrateVM() {
		return this.migrateVM;
	}

	public void setChangeNumberOfCPU(ChangeNumberOfCPU changeNumberOfCPU) {
		this.changeNumberOfCPU = changeNumberOfCPU;
	}

	public ChangeNumberOfCPU getChangeNumberOfCPU() {
		return this.changeNumberOfCPU;
	}

	public void setResumeVM(ResumeVM resumeVM) {
		this.resumeVM = resumeVM;
	}

	public ResumeVM getResumeVM() {
		return this.resumeVM;
	}

	public CreateAndStartVMFromISO getCreateAndStartVMFromISO() {
		return createAndStartVMFromISO;
	}

	public void setCreateAndStartVMFromISO(CreateAndStartVMFromISO createAndStartVMFromISO) {
		this.createAndStartVMFromISO = createAndStartVMFromISO;
	}

	public CreateAndStartVMFromImage getCreateAndStartVMFromImage() {
		return createAndStartVMFromImage;
	}

	public void setCreateAndStartVMFromImage(CreateAndStartVMFromImage createAndStartVMFromImage) {
		this.createAndStartVMFromImage = createAndStartVMFromImage;
	}

	public void setPlugDisk(PlugDisk plugDisk) {
		this.plugDisk = plugDisk;
	}

	public PlugDisk getPlugDisk() {
		return this.plugDisk;
	}

	public void setPlugDevice(PlugDevice plugDevice) {
		this.plugDevice = plugDevice;
	}

	public PlugDevice getPlugDevice() {
		return this.plugDevice;
	}

	public void setResetVM(ResetVM resetVM) {
		this.resetVM = resetVM;
	}

	public ResetVM getResetVM() {
		return this.resetVM;
	}

	public void setUnplugDisk(UnplugDisk unplugDisk) {
		this.unplugDisk = unplugDisk;
	}

	public UnplugDisk getUnplugDisk() {
		return this.unplugDisk;
	}

	public void setStopVM(StopVM stopVM) {
		this.stopVM = stopVM;
	}

	public StopVM getStopVM() {
		return this.stopVM;
	}

	public void setStartVM(StartVM startVM) {
		this.startVM = startVM;
	}

	public StartVM getStartVM() {
		return this.startVM;
	}

	public void setDeleteVM(DeleteVM deleteVM) {
		this.deleteVM = deleteVM;
	}

	public DeleteVM getDeleteVM() {
		return this.deleteVM;
	}

	public void setRebootVM(RebootVM rebootVM) {
		this.rebootVM = rebootVM;
	}

	public RebootVM getRebootVM() {
		return this.rebootVM;
	}

	public void setPlugNIC(PlugNIC plugNIC) {
		this.plugNIC = plugNIC;
	}

	public PlugNIC getPlugNIC() {
		return this.plugNIC;
	}

	public ConvertVMToImage getConvertVMToImage() {
		return convertVMToImage;
	}

	public void setConvertVMToImage(ConvertVMToImage convertVMToImage) {
		this.convertVMToImage = convertVMToImage;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class ResizeRAM {

		@Parameter(required = false, description = "对当前虚拟机生效", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean current;

		@Parameter(required = true,  description = "内存大小，单位为KiB", constraint = "100MiB到100GiB", example = "1GiB: 1048576")
		protected String size;

		@Parameter(required = false, description = "下一次启动生效，如果虚拟机是关闭状态，与--live不可同时设置为true", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean config;

		@Parameter(required = false, description = "本次生效，如果虚拟机开机状态使用", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean live;

		public ResizeRAM() {

		}

		public void setCurrent(Boolean current) {
			this.current = current;
		}

		public Boolean getCurrent() {
			return this.current;
		}

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}

		public void setConfig(Boolean config) {
			this.config = config;
		}

		public Boolean getConfig() {
			return this.config;
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
	public static class SuspendVM {

	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class StopVMForce {

	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class UnplugDevice {

		@Parameter(required = false, description = "对当前虚拟机生效", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean current;

		@Parameter(required = false, description = "对配置进行持久化", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean persistent;

		@Parameter(required = false, description = "下一次启动生效，对于关机虚拟机，与--live不能同时设置为true", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean config;

		@Parameter(required = false, description = "立即生效，对于开机虚拟机", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean live;
		
		@Parameter(required = true, description = "设备xml文件，可以是GPU、硬盘、网卡、光驱等", constraint= "文件路径", example = "/opt/unplug.xml")
		protected String file;

		public UnplugDevice() {

		}

		public void setCurrent(Boolean current) {
			this.current = current;
		}

		public Boolean getCurrent() {
			return this.current;
		}

		public void setFile(String file) {
			this.file = file;
		}

		public String getFile() {
			return this.file;
		}

		public void setPersistent(Boolean persistent) {
			this.persistent = persistent;
		}

		public Boolean getPersistent() {
			return this.persistent;
		}

		public void setConfig(Boolean config) {
			this.config = config;
		}

		public Boolean getConfig() {
			return this.config;
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
	public static class UnplugNIC {

		@Parameter(required = false, description = "对当前虚拟机生效", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean current;

		@Parameter(required = false, description = "对配置进行持久化", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean persistent;

		@Parameter(required = false, description = "下一次启动生效，对于关机虚拟机，与--live不能同时设置为true", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean config;

		@Parameter(required = false, description = "立即生效，对于开机虚拟机", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean live;

		@Parameter(required = true, description = "虚拟机网络类型", constraint = ExtendedKubernetesConstants.DESC_BRIDGE_DESC, example = "true")
		protected String type;

		@Parameter(required = true, description = "mac地址", constraint = "mac地址不能以fe开头", example = "7e:0c:b0:ef:6a:04")
		protected String mac;
		
		public void setCurrent(Boolean current) {
			this.current = current;
		}

		public Boolean getCurrent() {
			return this.current;
		}

		public void setPersistent(Boolean persistent) {
			this.persistent = persistent;
		}

		public Boolean getPersistent() {
			return this.persistent;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getType() {
			return this.type;
		}

		public void setConfig(Boolean config) {
			this.config = config;
		}

		public Boolean getConfig() {
			return this.config;
		}

		public void setLive(Boolean live) {
			this.live = live;
		}

		public Boolean getLive() {
			return this.live;
		}

		public void setMac(String mac) {
			this.mac = mac;
		}

		public String getMac() {
			return this.mac;
		}
	}


	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class MigrateVM {

		protected Boolean suspend;

		protected Boolean direct;

		protected Boolean change_protection;

		protected Boolean rdma_pin_all;

		protected Boolean undefinesource;

		protected Boolean copy_storage_all;

		protected Boolean unsafe;

		protected Boolean copy_storage_inc;

		protected Boolean p2p;

		protected Boolean auto_converge;

		protected Boolean postcopy;

		protected Boolean offline;

		protected Boolean tunnelled;

		protected String domain;

		protected String desturi;

		protected Boolean abort_on_error;

		protected Boolean compressed;

		protected Boolean persistent;

		protected Boolean live;

		public MigrateVM() {

		}

		public void setSuspend(Boolean suspend) {
			this.suspend = suspend;
		}

		public Boolean getSuspend() {
			return this.suspend;
		}

		public void setDirect(Boolean direct) {
			this.direct = direct;
		}

		public Boolean getDirect() {
			return this.direct;
		}

		public void setChange_protection(Boolean change_protection) {
			this.change_protection = change_protection;
		}

		public Boolean getChange_protection() {
			return this.change_protection;
		}

		public void setRdma_pin_all(Boolean rdma_pin_all) {
			this.rdma_pin_all = rdma_pin_all;
		}

		public Boolean getRdma_pin_all() {
			return this.rdma_pin_all;
		}

		public void setUndefinesource(Boolean undefinesource) {
			this.undefinesource = undefinesource;
		}

		public Boolean getUndefinesource() {
			return this.undefinesource;
		}

		public void setCopy_storage_all(Boolean copy_storage_all) {
			this.copy_storage_all = copy_storage_all;
		}

		public Boolean getCopy_storage_all() {
			return this.copy_storage_all;
		}

		public void setUnsafe(Boolean unsafe) {
			this.unsafe = unsafe;
		}

		public Boolean getUnsafe() {
			return this.unsafe;
		}

		public void setCopy_storage_inc(Boolean copy_storage_inc) {
			this.copy_storage_inc = copy_storage_inc;
		}

		public Boolean getCopy_storage_inc() {
			return this.copy_storage_inc;
		}

		public void setP2p(Boolean p2p) {
			this.p2p = p2p;
		}

		public Boolean getP2p() {
			return this.p2p;
		}

		public void setAuto_converge(Boolean auto_converge) {
			this.auto_converge = auto_converge;
		}

		public Boolean getAuto_converge() {
			return this.auto_converge;
		}

		public void setPostcopy(Boolean postcopy) {
			this.postcopy = postcopy;
		}

		public Boolean getPostcopy() {
			return this.postcopy;
		}

		public void setOffline(Boolean offline) {
			this.offline = offline;
		}

		public Boolean getOffline() {
			return this.offline;
		}

		public void setTunnelled(Boolean tunnelled) {
			this.tunnelled = tunnelled;
		}

		public Boolean getTunnelled() {
			return this.tunnelled;
		}

		public void setDomain(String domain) {
			this.domain = domain;
		}

		public String getDomain() {
			return this.domain;
		}

		public void setDesturi(String desturi) {
			this.desturi = desturi;
		}

		public String getDesturi() {
			return this.desturi;
		}

		public void setAbort_on_error(Boolean abort_on_error) {
			this.abort_on_error = abort_on_error;
		}

		public Boolean getAbort_on_error() {
			return this.abort_on_error;
		}

		public void setCompressed(Boolean compressed) {
			this.compressed = compressed;
		}

		public Boolean getCompressed() {
			return this.compressed;
		}

		public void setPersistent(Boolean persistent) {
			this.persistent = persistent;
		}

		public Boolean getPersistent() {
			return this.persistent;
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
	public static class ChangeNumberOfCPU {

		@Parameter(required = false, description = "对当前虚拟机生效", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean current;

		@Parameter(required = false, description = "对配置进行持久化", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean persistent;

		@Parameter(required = false, description = "下一次启动生效，对于关机虚拟机，与--live不能同时设置为true", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean config;

		@Parameter(required = false, description = "立即生效，对于开机虚拟机", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean live;

		@Parameter(required = false, description = "对于开机虚拟机进行运行时插拔，与--live等价", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean hotpluggable;

		@Parameter(required = true, description = "vcpu数量", constraint = "1-99个", example = "16")
		protected Integer count;

		@Parameter(required = false, description = "修改虚拟机CPU状态", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean guest;


		public ChangeNumberOfCPU() {

		}

		public void setCurrent(Boolean current) {
			this.current = current;
		}

		public Boolean getCurrent() {
			return this.current;
		}

		public void setHotpluggable(Boolean hotpluggable) {
			this.hotpluggable = hotpluggable;
		}

		public Boolean getHotpluggable() {
			return this.hotpluggable;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

		public Integer getCount() {
			return this.count;
		}

		public void setGuest(Boolean guest) {
			this.guest = guest;
		}

		public Boolean getGuest() {
			return this.guest;
		}

		public void setConfig(Boolean config) {
			this.config = config;
		}

		public Boolean getConfig() {
			return this.config;
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
	public static class ResumeVM {

	}


	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class PlugDisk {

		@Parameter(required = false, description = "对配置进行持久化", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean persistent;

		@Parameter(required = false, description = "下一次启动生效，对于关机虚拟机，与--live不能同时设置为true", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean config;

		@Parameter(required = false, description = "立即生效，对于开机虚拟机", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean live;
		
		@Parameter(required = false, description = "立即生效，对于开机虚拟机", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected String iothread;

		protected String cache;

		protected String address;

		protected String io;

		protected String source;

		protected String targetbus;

		protected String type;

		protected String subdriver;

		protected Boolean multifunction;

		protected String target;

		protected String wwn;

		protected String mode;

		protected String driver;

		protected String serial;

		protected Boolean rawio;

		protected String sourcetype;
		
		protected String read_bytes_sec;
		
		protected String write_bytes_sec;
		
		protected String read_iops_sec;
		
		protected String write_iops_sec;

		public PlugDisk() {

		}
		
		public String getRead_bytes_sec() {
			return read_bytes_sec;
		}

		public void setRead_bytes_sec(String read_bytes_sec) {
			this.read_bytes_sec = read_bytes_sec;
		}

		public String getWrite_bytes_sec() {
			return write_bytes_sec;
		}

		public void setWrite_bytes_sec(String write_bytes_sec) {
			this.write_bytes_sec = write_bytes_sec;
		}

		public String getRead_iops_sec() {
			return read_iops_sec;
		}

		public void setRead_iops_sec(String read_iops_sec) {
			this.read_iops_sec = read_iops_sec;
		}

		public String getWrite_iops_sec() {
			return write_iops_sec;
		}

		public void setWrite_iops_sec(String write_iops_sec) {
			this.write_iops_sec = write_iops_sec;
		}

		public Boolean getLive() {
			return live;
		}

		public void setLive(Boolean live) {
			this.live = live;
		}

		public void setIothread(String iothread) {
			this.iothread = iothread;
		}

		public String getIothread() {
			return this.iothread;
		}

		public void setCache(String cache) {
			this.cache = cache;
		}

		public String getCache() {
			return this.cache;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getAddress() {
			return this.address;
		}

		public void setIo(String io) {
			this.io = io;
		}

		public String getIo() {
			return this.io;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public String getSource() {
			return this.source;
		}

		public void setTargetbus(String targetbus) {
			this.targetbus = targetbus;
		}

		public String getTargetbus() {
			return this.targetbus;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getType() {
			return this.type;
		}

		public void setSubdriver(String subdriver) {
			this.subdriver = subdriver;
		}

		public String getSubdriver() {
			return this.subdriver;
		}

		public void setMultifunction(Boolean multifunction) {
			this.multifunction = multifunction;
		}

		public Boolean getMultifunction() {
			return this.multifunction;
		}

		public void setTarget(String target) {
			this.target = target;
		}

		public String getTarget() {
			return this.target;
		}

		public void setWwn(String wwn) {
			this.wwn = wwn;
		}

		public String getWwn() {
			return this.wwn;
		}

		public void setMode(String mode) {
			this.mode = mode;
		}

		public String getMode() {
			return this.mode;
		}

		public void setDriver(String driver) {
			this.driver = driver;
		}

		public String getDriver() {
			return this.driver;
		}

		public void setSerial(String serial) {
			this.serial = serial;
		}

		public String getSerial() {
			return this.serial;
		}

		public void setRawio(Boolean rawio) {
			this.rawio = rawio;
		}

		public Boolean getRawio() {
			return this.rawio;
		}

		public void setSourcetype(String sourcetype) {
			this.sourcetype = sourcetype;
		}

		public String getSourcetype() {
			return this.sourcetype;
		}

		public void setPersistent(Boolean persistent) {
			this.persistent = persistent;
		}

		public Boolean getPersistent() {
			return this.persistent;
		}

		public void setConfig(Boolean config) {
			this.config = config;
		}

		public Boolean getConfig() {
			return this.config;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class PlugDevice {

		@Parameter(required = false, description = "对当前虚拟机生效", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean current;

		@Parameter(required = false, description = "对配置进行持久化", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean persistent;

		@Parameter(required = false, description = "下一次启动生效，对于关机虚拟机，与--live不能同时设置为true", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean config;

		@Parameter(required = false, description = "立即生效，对于开机虚拟机", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean live;
		
		@Parameter(required = true, description = "设备xml文件，可以是GPU、硬盘、网卡、光驱等", constraint= "文件路径", example = "/opt/unplug.xml")
		protected String file;

		public PlugDevice() {

		}

		public void setCurrent(Boolean current) {
			this.current = current;
		}

		public Boolean getCurrent() {
			return this.current;
		}

		public void setFile(String file) {
			this.file = file;
		}

		public String getFile() {
			return this.file;
		}

		public void setPersistent(Boolean persistent) {
			this.persistent = persistent;
		}

		public Boolean getPersistent() {
			return this.persistent;
		}

		public void setConfig(Boolean config) {
			this.config = config;
		}

		public Boolean getConfig() {
			return this.config;
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
	public static class ResetVM {

	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class UnplugDisk {

		@Parameter(required = false, description = "对当前虚拟机生效", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean current;

		@Parameter(required = false, description = "对配置进行持久化", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean persistent;

		@Parameter(required = false, description = "下一次启动生效，对于关机虚拟机，与--live不能同时设置为true", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean config;

		@Parameter(required = false, description = "立即生效，对于开机虚拟机", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean live;

		@Parameter(required = true, description = "设备的目标，即在虚拟机中fdisk -l看到的硬盘标记", constraint = ExtendedKubernetesConstants.DESC_TARGET_DESC, example = "windows: hdb, Linux: vdb")
		protected String target;

		public UnplugDisk() {

		}

		public void setCurrent(Boolean current) {
			this.current = current;
		}

		public Boolean getCurrent() {
			return this.current;
		}

		public void setPersistent(Boolean persistent) {
			this.persistent = persistent;
		}

		public Boolean getPersistent() {
			return this.persistent;
		}

		public void setConfig(Boolean config) {
			this.config = config;
		}

		public Boolean getConfig() {
			return this.config;
		}

		public void setLive(Boolean live) {
			this.live = live;
		}

		public Boolean getLive() {
			return this.live;
		}

		public void setTarget(String target) {
			this.target = target;
		}

		public String getTarget() {
			return this.target;
		}
	}


	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class StopVM {

	}


	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class StartVM {

	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class DeleteVM {

		@Parameter(required = false, description = "删除虚拟机所有快照，否则如果虚拟机还存在快照，会导致删除失败", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean delete_snapshots;

		@Parameter(required = false, description = "是否删除虚拟机所有快照对应的磁盘存储", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean remove_all_storage;


		public void setDelete_snapshots(Boolean delete_snapshots) {
			this.delete_snapshots = delete_snapshots;
		}

		public Boolean getDelete_snapshots() {
			return this.delete_snapshots;
		}


		public void setRemove_all_storage(Boolean remove_all_storage) {
			this.remove_all_storage = remove_all_storage;
		}

		public Boolean getRemove_all_storage() {
			return this.remove_all_storage;
		}

	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CreateAndStartVMFromISO {

		protected String container;

		protected String metadata;

		protected String livecd;

		protected String sound;

		protected String channel;

		protected String graphics;

		protected String autostart;

		protected String features;

		protected String hostdev;

		protected String idmap;

		protected String sysinfo;

		protected String numatune;

		protected String events;

		protected String hvm;

		protected String qemu_commandline;

		protected String resource;

		protected String extra_args;

		protected String cpu;

		protected String rng;

		protected String check;

		protected String clock;

		protected String smartcard;

		protected String panic;

		protected String input;

		protected String disk;

		protected String memorybacking;

		protected String dry_run;

		protected String memory;

		protected String paravirt;

		protected String memballoon;

		protected String network;

		protected String security;

		protected String blkiotune;

		protected String virt_type;

		protected String parallel;

		protected String memtune;

		protected String boot;

		protected String initrd_inject;

		protected String pxe;

		protected String console;

		protected String controller;

		protected String memdev;

		protected String redirdev;

		protected String os_variant;

		protected String vcpus;

		protected String cdrom;

		protected String cputune;

		protected String filesystem;

		protected String tpm;

		protected String watchdog;

		protected String serial;

		protected String machine;

		protected String location;

		protected String arch;

		protected String noreboot;

		protected String pm;
		
		protected Boolean noautoconsole;
		
		protected Boolean _import;

		public CreateAndStartVMFromISO() {

		}

		public Boolean get_import() {
			return _import;
		}

		public void set_import(Boolean _import) {
			this._import = _import;
		}

		public String getDisk() {
			return disk;
		}

		public void setDisk(String disk) {
			this.disk = disk;
		}

		public Boolean getNoautoconsole() {
			return noautoconsole;
		}

		public Boolean isNoautoconsole() {
			return noautoconsole;
		}

		public void setNoautoconsole(Boolean noautoconsole) {
			this.noautoconsole = noautoconsole;
		}

		public void setContainer(String container) {
			this.container = container;
		}

		public String getContainer() {
			return this.container;
		}

		public void setMetadata(String metadata) {
			this.metadata = metadata;
		}

		public String getMetadata() {
			return this.metadata;
		}

		public void setLivecd(String livecd) {
			this.livecd = livecd;
		}

		public String getLivecd() {
			return this.livecd;
		}

		public void setSound(String sound) {
			this.sound = sound;
		}

		public String getSound() {
			return this.sound;
		}

		public void setChannel(String channel) {
			this.channel = channel;
		}

		public String getChannel() {
			return this.channel;
		}

		public void setGraphics(String graphics) {
			this.graphics = graphics;
		}

		public String getGraphics() {
			return this.graphics;
		}

		public void setAutostart(String autostart) {
			this.autostart = autostart;
		}

		public String getAutostart() {
			return this.autostart;
		}

		public void setFeatures(String features) {
			this.features = features;
		}

		public String getFeatures() {
			return this.features;
		}

		public void setHostdev(String hostdev) {
			this.hostdev = hostdev;
		}

		public String getHostdev() {
			return this.hostdev;
		}

		public void setIdmap(String idmap) {
			this.idmap = idmap;
		}

		public String getIdmap() {
			return this.idmap;
		}

		public void setSysinfo(String sysinfo) {
			this.sysinfo = sysinfo;
		}

		public String getSysinfo() {
			return this.sysinfo;
		}

		public void setNumatune(String numatune) {
			this.numatune = numatune;
		}

		public String getNumatune() {
			return this.numatune;
		}

		public void setEvents(String events) {
			this.events = events;
		}

		public String getEvents() {
			return this.events;
		}

		public void setHvm(String hvm) {
			this.hvm = hvm;
		}

		public String getHvm() {
			return this.hvm;
		}

		public void setQemu_commandline(String qemu_commandline) {
			this.qemu_commandline = qemu_commandline;
		}

		public String getQemu_commandline() {
			return this.qemu_commandline;
		}

		public void setResource(String resource) {
			this.resource = resource;
		}

		public String getResource() {
			return this.resource;
		}

		public void setExtra_args(String extra_args) {
			this.extra_args = extra_args;
		}

		public String getExtra_args() {
			return this.extra_args;
		}

		public void setCpu(String cpu) {
			this.cpu = cpu;
		}

		public String getCpu() {
			return this.cpu;
		}

		public void setRng(String rng) {
			this.rng = rng;
		}

		public String getRng() {
			return this.rng;
		}

		public void setCheck(String check) {
			this.check = check;
		}

		public String getCheck() {
			return this.check;
		}

		public void setClock(String clock) {
			this.clock = clock;
		}

		public String getClock() {
			return this.clock;
		}

		public void setSmartcard(String smartcard) {
			this.smartcard = smartcard;
		}

		public String getSmartcard() {
			return this.smartcard;
		}

		public void setPanic(String panic) {
			this.panic = panic;
		}

		public String getPanic() {
			return this.panic;
		}

		public void setInput(String input) {
			this.input = input;
		}

		public String getInput() {
			return this.input;
		}


		public void setMemorybacking(String memorybacking) {
			this.memorybacking = memorybacking;
		}

		public String getMemorybacking() {
			return this.memorybacking;
		}

		public void setDry_run(String dry_run) {
			this.dry_run = dry_run;
		}

		public String getDry_run() {
			return this.dry_run;
		}

		public void setMemory(String memory) {
			this.memory = memory;
		}

		public String getMemory() {
			return this.memory;
		}

		public void setParavirt(String paravirt) {
			this.paravirt = paravirt;
		}

		public String getParavirt() {
			return this.paravirt;
		}

		public void setMemballoon(String memballoon) {
			this.memballoon = memballoon;
		}

		public String getMemballoon() {
			return this.memballoon;
		}

		public void setNetwork(String network) {
			this.network = network;
		}

		public String getNetwork() {
			return this.network;
		}

		public void setSecurity(String security) {
			this.security = security;
		}

		public String getSecurity() {
			return this.security;
		}

		public void setBlkiotune(String blkiotune) {
			this.blkiotune = blkiotune;
		}

		public String getBlkiotune() {
			return this.blkiotune;
		}

		public void setVirt_type(String virt_type) {
			this.virt_type = virt_type;
		}

		public String getVirt_type() {
			return this.virt_type;
		}

		public void setParallel(String parallel) {
			this.parallel = parallel;
		}

		public String getParallel() {
			return this.parallel;
		}

		public void setMemtune(String memtune) {
			this.memtune = memtune;
		}

		public String getMemtune() {
			return this.memtune;
		}

		public void setBoot(String boot) {
			this.boot = boot;
		}

		public String getBoot() {
			return this.boot;
		}

		public void setInitrd_inject(String initrd_inject) {
			this.initrd_inject = initrd_inject;
		}

		public String getInitrd_inject() {
			return this.initrd_inject;
		}

		public void setPxe(String pxe) {
			this.pxe = pxe;
		}

		public String getPxe() {
			return this.pxe;
		}

		public void setConsole(String console) {
			this.console = console;
		}

		public String getConsole() {
			return this.console;
		}

		public void setController(String controller) {
			this.controller = controller;
		}

		public String getController() {
			return this.controller;
		}

		public void setMemdev(String memdev) {
			this.memdev = memdev;
		}

		public String getMemdev() {
			return this.memdev;
		}

		public void setRedirdev(String redirdev) {
			this.redirdev = redirdev;
		}

		public String getRedirdev() {
			return this.redirdev;
		}

		public void setOs_variant(String os_variant) {
			this.os_variant = os_variant;
		}

		public String getOs_variant() {
			return this.os_variant;
		}

		public void setVcpus(String vcpus) {
			this.vcpus = vcpus;
		}

		public String getVcpus() {
			return this.vcpus;
		}

		public void setCdrom(String cdrom) {
			this.cdrom = cdrom;
		}

		public String getCdrom() {
			return this.cdrom;
		}

		public void setCputune(String cputune) {
			this.cputune = cputune;
		}

		public String getCputune() {
			return this.cputune;
		}

		public void setFilesystem(String filesystem) {
			this.filesystem = filesystem;
		}

		public String getFilesystem() {
			return this.filesystem;
		}

		public void setTpm(String tpm) {
			this.tpm = tpm;
		}

		public String getTpm() {
			return this.tpm;
		}

		public void setWatchdog(String watchdog) {
			this.watchdog = watchdog;
		}

		public String getWatchdog() {
			return this.watchdog;
		}

		public void setSerial(String serial) {
			this.serial = serial;
		}

		public String getSerial() {
			return this.serial;
		}

		public void setMachine(String machine) {
			this.machine = machine;
		}

		public String getMachine() {
			return this.machine;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getLocation() {
			return this.location;
		}

		public void setArch(String arch) {
			this.arch = arch;
		}

		public String getArch() {
			return this.arch;
		}

		public void setNoreboot(String noreboot) {
			this.noreboot = noreboot;
		}

		public String getNoreboot() {
			return this.noreboot;
		}

		public void setPm(String pm) {
			this.pm = pm;
		}

		public String getPm() {
			return this.pm;
		}
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CreateAndStartVMFromImage extends CreateAndStartVMFromISO {

	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class RebootVM {

	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class PlugNIC {

		protected String inbound;

		protected String source;

		protected String type;

		protected String mac;

		protected String script;

		protected String target;

		protected Boolean current;

		protected Boolean managed;

		protected String outbound;

		protected String model;

		protected Boolean persistent;

		protected Boolean config;

		protected Boolean live;

		public PlugNIC() {

		}

		public void setInbound(String inbound) {
			this.inbound = inbound;
		}

		public String getInbound() {
			return this.inbound;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public String getSource() {
			return this.source;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getType() {
			return this.type;
		}

		public void setMac(String mac) {
			this.mac = mac;
		}

		public String getMac() {
			return this.mac;
		}

		public void setScript(String script) {
			this.script = script;
		}

		public String getScript() {
			return this.script;
		}

		public void setTarget(String target) {
			this.target = target;
		}

		public String getTarget() {
			return this.target;
		}

		public void setCurrent(Boolean current) {
			this.current = current;
		}

		public Boolean getCurrent() {
			return this.current;
		}

		public void setManaged(Boolean managed) {
			this.managed = managed;
		}

		public Boolean getManaged() {
			return this.managed;
		}

		public void setOutbound(String outbound) {
			this.outbound = outbound;
		}

		public String getOutbound() {
			return this.outbound;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public String getModel() {
			return this.model;
		}

		public void setPersistent(Boolean persistent) {
			this.persistent = persistent;
		}

		public Boolean getPersistent() {
			return this.persistent;
		}

		public void setConfig(Boolean config) {
			this.config = config;
		}

		public Boolean getConfig() {
			return this.config;
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
	public static class ManageISO {

		@Parameter(required = false, description = "对当前虚拟机生效", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean current;

		@Parameter(required = false, description = "下一次启动生效，对于关机虚拟机，与--live不能同时设置为true", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean config;

		@Parameter(required = false, description = "立即生效，对于开机虚拟机", constraint = ExtendedKubernetesConstants.DESC_BOOLEAN, example = "true")
		protected Boolean live;
		
		@Parameter(required = false, description = "设备xml文件，可以是GPU、硬盘、网卡、光驱等", constraint= "文件路径", example = "/opt/unplug.xml")
		protected String file;
		
		@Parameter(required = true, description = "模板虚拟机的路径", constraint= "文件路径", example = "/opt/target.iso")
		protected String path;
		
		protected Boolean eject;
		
		protected Boolean insert;
		
		protected Boolean update;
		
		protected Boolean force;
		
		protected Boolean block;
		
		public ManageISO() {
			super();
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public Boolean getEject() {
			return eject;
		}

		public void setEject(Boolean eject) {
			this.eject = eject;
		}

		public Boolean getInsert() {
			return insert;
		}

		public void setInsert(Boolean insert) {
			this.insert = insert;
		}

		public Boolean getUpdate() {
			return update;
		}

		public void setUpdate(Boolean update) {
			this.update = update;
		}

		public Boolean getCurrent() {
			return current;
		}

		public void setCurrent(Boolean current) {
			this.current = current;
		}

		public Boolean getLive() {
			return live;
		}

		public void setLive(Boolean live) {
			this.live = live;
		}

		public Boolean getConfig() {
			return config;
		}

		public void setConfig(Boolean config) {
			this.config = config;
		}

		public Boolean getForce() {
			return force;
		}

		public void setForce(Boolean force) {
			this.force = force;
		}

		public Boolean getBlock() {
			return block;
		}

		public void setBlock(Boolean block) {
			this.block = block;
		}

	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class UpdateOS {
		
		@Parameter(required = true, description = "需要被替换的虚拟机路径", constraint= "文件路径", example = "/opt/source.xml")
		protected String source;
		
		@Parameter(required = true, description = "模板虚拟机的路径", constraint= "文件路径", example = "/opt/target.xml")
		protected String target;

		public UpdateOS() {
			super();
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public String getTarget() {
			return target;
		}

		public void setTarget(String target) {
			this.target = target;
		}

	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class ConvertVMToImage {
		
	}
	
	
}
