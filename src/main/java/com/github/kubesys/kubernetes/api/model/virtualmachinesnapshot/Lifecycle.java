/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot;

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

	protected DeleteSnapshot deleteSnapshot;

	protected CreateSnapshot createSnapshot;
	
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
	public static class RevertVirtualMachine {
		
		protected String domain;
		
		protected String snapshotname;
		
		protected Boolean current;
		
		protected Boolean running;
		
		protected Boolean paused;
		
		protected Boolean force;

		public String getDomain() {
			return domain;
		}

		public void setDomain(String domain) {
			this.domain = domain;
		}

		public String getSnapshotname() {
			return snapshotname;
		}

		public void setSnapshotname(String snapshotname) {
			this.snapshotname = snapshotname;
		}

		public Boolean getCurrent() {
			return current;
		}

		public void setCurrent(Boolean current) {
			this.current = current;
		}

		public Boolean getRunning() {
			return running;
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

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class RestoreVM {

		protected Boolean running;

		protected Boolean bypass_cache;

		protected Boolean paused;

		protected String file;

		protected String xml;

		public RestoreVM() {

		}

		public void setRunning(Boolean running) {
			this.running = running;
		}

		public Boolean getRunning() {
			return this.running;
		}

		public void setBypass_cache(Boolean bypass_cache) {
			this.bypass_cache = bypass_cache;
		}

		public Boolean getBypass_cache() {
			return this.bypass_cache;
		}

		public void setPaused(Boolean paused) {
			this.paused = paused;
		}

		public Boolean getPaused() {
			return this.paused;
		}

		public void setFile(String file) {
			this.file = file;
		}

		public String getFile() {
			return this.file;
		}

		public void setXml(String xml) {
			this.xml = xml;
		}

		public String getXml() {
			return this.xml;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class ResizeRAM {

		protected Boolean current;

		protected Integer size;

		protected String domain;

		protected Boolean config;

		protected Boolean live;

		public ResizeRAM() {

		}

		public void setCurrent(Boolean current) {
			this.current = current;
		}

		public Boolean getCurrent() {
			return this.current;
		}

		public void setSize(Integer size) {
			this.size = size;
		}

		public Integer getSize() {
			return this.size;
		}

		public void setDomain(String domain) {
			this.domain = domain;
		}

		public String getDomain() {
			return this.domain;
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

		protected String domain;

		public SuspendVM() {

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
	public static class StopVMForce {

		protected String domain;

		protected Boolean graceful;

		public StopVMForce() {

		}

		public void setDomain(String domain) {
			this.domain = domain;
		}

		public String getDomain() {
			return this.domain;
		}

		public void setGraceful(Boolean graceful) {
			this.graceful = graceful;
		}

		public Boolean getGraceful() {
			return this.graceful;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class UnplugDevice {

		protected Boolean current;

		protected String file;

		protected String domain;

		protected Boolean persistent;

		protected Boolean config;

		protected Boolean live;

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

		public void setDomain(String domain) {
			this.domain = domain;
		}

		public String getDomain() {
			return this.domain;
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
	public static class DeleteDisk {

		protected String vol;

		protected Boolean delete_snapshots;

		protected String pool;

		public DeleteDisk() {

		}

		public void setVol(String vol) {
			this.vol = vol;
		}

		public String getVol() {
			return this.vol;
		}

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
	public static class UnplugNIC {

		protected Boolean current;

		protected String domain;

		protected Boolean persistent;

		protected String type;

		protected Boolean config;

		protected Boolean live;

		protected String mac;

		public UnplugNIC() {

		}

		public void setCurrent(Boolean current) {
			this.current = current;
		}

		public Boolean getCurrent() {
			return this.current;
		}

		public void setDomain(String domain) {
			this.domain = domain;
		}

		public String getDomain() {
			return this.domain;
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
	public static class DeleteSnapshot {

		protected Boolean current;

		protected Boolean metadata;

		protected Boolean children;

		protected Boolean children_only;

		protected String domain;

		protected String snapshotname;

		public DeleteSnapshot() {

		}

		public void setCurrent(Boolean current) {
			this.current = current;
		}

		public Boolean getCurrent() {
			return this.current;
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

		public void setSnapshotname(String snapshotname) {
			this.snapshotname = snapshotname;
		}

		public String getSnapshotname() {
			return this.snapshotname;
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

		protected Boolean current;

		protected Boolean hotpluggable;

		protected String domain;

		protected Integer count;

		protected Boolean maximum;

		protected Boolean guest;

		protected Boolean config;

		protected Boolean live;

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

		public void setDomain(String domain) {
			this.domain = domain;
		}

		public String getDomain() {
			return this.domain;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

		public Integer getCount() {
			return this.count;
		}

		public void setMaximum(Boolean maximum) {
			this.maximum = maximum;
		}

		public Boolean getMaximum() {
			return this.maximum;
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

		protected String domain;

		public ResumeVM() {

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
	public static class CreateSnapshot {

		protected String diskspec;

		protected Boolean no_metadata;

		protected Boolean disk_only;

		protected String memspec;

		protected String description;

		protected Boolean quiesce;

		protected Boolean print_xml;

		protected Boolean reuse_external;

		protected Boolean halt;

		protected Boolean atomic;

		protected String domain;

		protected String name;

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

		public void setPrint_xml(Boolean print_xml) {
			this.print_xml = print_xml;
		}

		public Boolean getPrint_xml() {
			return this.print_xml;
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

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
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
	public static class ResizeDisk {

		protected String vol;

		protected Boolean allocate;

		protected Boolean shrink;

		protected Boolean delta;

		protected String pool;

		protected String capacity;

		public ResizeDisk() {

		}

		public void setVol(String vol) {
			this.vol = vol;
		}

		public String getVol() {
			return this.vol;
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
	public static class PlugDisk {

		protected String iothread;

		protected String cache;

		protected String address;

		protected String io;

		protected String source;

		protected Boolean print_xml;

		protected String targetbus;

		protected String type;

		protected String subdriver;

		protected Boolean multifunction;

		protected String target;

		protected String wwn;

		protected String mode;

		protected String driver;

		protected String serial;

		protected String domain;

		protected Boolean rawio;

		protected String sourcetype;

		protected Boolean persistent;

		protected Boolean config;

		public PlugDisk() {

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

		public void setPrint_xml(Boolean print_xml) {
			this.print_xml = print_xml;
		}

		public Boolean getPrint_xml() {
			return this.print_xml;
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

		public void setDomain(String domain) {
			this.domain = domain;
		}

		public String getDomain() {
			return this.domain;
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

		protected Boolean current;

		protected String file;

		protected String domain;

		protected Boolean persistent;

		protected Boolean config;

		protected Boolean live;

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

		public void setDomain(String domain) {
			this.domain = domain;
		}

		public String getDomain() {
			return this.domain;
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

		protected String domain;

		public ResetVM() {

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
	public static class UnplugDisk {

		protected Boolean current;

		protected String domain;

		protected Boolean persistent;

		protected Boolean print_xml;

		protected Boolean config;

		protected Boolean live;

		protected String target;

		public UnplugDisk() {

		}

		public void setCurrent(Boolean current) {
			this.current = current;
		}

		public Boolean getCurrent() {
			return this.current;
		}

		public void setDomain(String domain) {
			this.domain = domain;
		}

		public String getDomain() {
			return this.domain;
		}

		public void setPersistent(Boolean persistent) {
			this.persistent = persistent;
		}

		public Boolean getPersistent() {
			return this.persistent;
		}

		public void setPrint_xml(Boolean print_xml) {
			this.print_xml = print_xml;
		}

		public Boolean getPrint_xml() {
			return this.print_xml;
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
	public static class CreateDisk {

		protected String allocation;

		protected String backing_vol_format;

		protected Boolean prealloc_metadata;

		protected String format;

		protected String name;

		protected String pool;

		protected Boolean print_xml;

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

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}

		public void setPool(String pool) {
			this.pool = pool;
		}

		public String getPool() {
			return this.pool;
		}

		public void setPrint_xml(Boolean print_xml) {
			this.print_xml = print_xml;
		}

		public Boolean getPrint_xml() {
			return this.print_xml;
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
	public static class StopVM {

		protected String mode;

		protected String domain;

		public StopVM() {

		}

		public void setMode(String mode) {
			this.mode = mode;
		}

		public String getMode() {
			return this.mode;
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
	public static class CreateVM {

		protected Boolean console;

		protected Boolean paused;

		protected String file;

		protected String pass_fds;

		protected Boolean autodestroy;

		protected Boolean validate;

		public CreateVM() {

		}

		public void setConsole(Boolean console) {
			this.console = console;
		}

		public Boolean getConsole() {
			return this.console;
		}

		public void setPaused(Boolean paused) {
			this.paused = paused;
		}

		public Boolean getPaused() {
			return this.paused;
		}

		public void setFile(String file) {
			this.file = file;
		}

		public String getFile() {
			return this.file;
		}

		public void setPass_fds(String pass_fds) {
			this.pass_fds = pass_fds;
		}

		public String getPass_fds() {
			return this.pass_fds;
		}

		public void setAutodestroy(Boolean autodestroy) {
			this.autodestroy = autodestroy;
		}

		public Boolean getAutodestroy() {
			return this.autodestroy;
		}

		public void setValidate(Boolean validate) {
			this.validate = validate;
		}

		public Boolean getValidate() {
			return this.validate;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class StartVM {

		protected Boolean bypass_cache;

		protected Boolean console;

		protected Boolean paused;

		protected Boolean force_boot;

		protected String domain;

		protected String pass_fds;

		protected Boolean autodestroy;

		public StartVM() {

		}

		public void setBypass_cache(Boolean bypass_cache) {
			this.bypass_cache = bypass_cache;
		}

		public Boolean getBypass_cache() {
			return this.bypass_cache;
		}

		public void setConsole(Boolean console) {
			this.console = console;
		}

		public Boolean getConsole() {
			return this.console;
		}

		public void setPaused(Boolean paused) {
			this.paused = paused;
		}

		public Boolean getPaused() {
			return this.paused;
		}

		public void setForce_boot(Boolean force_boot) {
			this.force_boot = force_boot;
		}

		public Boolean getForce_boot() {
			return this.force_boot;
		}

		public void setDomain(String domain) {
			this.domain = domain;
		}

		public String getDomain() {
			return this.domain;
		}

		public void setPass_fds(String pass_fds) {
			this.pass_fds = pass_fds;
		}

		public String getPass_fds() {
			return this.pass_fds;
		}

		public void setAutodestroy(Boolean autodestroy) {
			this.autodestroy = autodestroy;
		}

		public Boolean getAutodestroy() {
			return this.autodestroy;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CloneDisk {

		protected Boolean reflink;

		protected String vol;

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

		public void setVol(String vol) {
			this.vol = vol;
		}

		public String getVol() {
			return this.vol;
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
	public static class DeleteVM {

		protected Boolean wipe_storage;

		protected Boolean snapshots_metadata;

		protected Boolean delete_snapshots;

		protected Boolean nvram;

		protected Boolean managed_save;

		protected Boolean remove_all_storage;

		protected String domain;

		protected Boolean keep_nvram;

		protected String storage;

		public DeleteVM() {

		}

		public void setWipe_storage(Boolean wipe_storage) {
			this.wipe_storage = wipe_storage;
		}

		public Boolean getWipe_storage() {
			return this.wipe_storage;
		}

		public void setSnapshots_metadata(Boolean snapshots_metadata) {
			this.snapshots_metadata = snapshots_metadata;
		}

		public Boolean getSnapshots_metadata() {
			return this.snapshots_metadata;
		}

		public void setDelete_snapshots(Boolean delete_snapshots) {
			this.delete_snapshots = delete_snapshots;
		}

		public Boolean getDelete_snapshots() {
			return this.delete_snapshots;
		}

		public void setNvram(Boolean nvram) {
			this.nvram = nvram;
		}

		public Boolean getNvram() {
			return this.nvram;
		}

		public void setManaged_save(Boolean managed_save) {
			this.managed_save = managed_save;
		}

		public Boolean getManaged_save() {
			return this.managed_save;
		}

		public void setRemove_all_storage(Boolean remove_all_storage) {
			this.remove_all_storage = remove_all_storage;
		}

		public Boolean getRemove_all_storage() {
			return this.remove_all_storage;
		}

		public void setDomain(String domain) {
			this.domain = domain;
		}

		public String getDomain() {
			return this.domain;
		}

		public void setKeep_nvram(Boolean keep_nvram) {
			this.keep_nvram = keep_nvram;
		}

		public Boolean getKeep_nvram() {
			return this.keep_nvram;
		}

		public void setStorage(String storage) {
			this.storage = storage;
		}

		public String getStorage() {
			return this.storage;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class CreateAndStartVM {

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

		protected String name;

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

		public CreateAndStartVM() {

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

		public void setDisk(String disk) {
			this.disk = disk;
		}

		public String getDisk() {
			return this.disk;
		}

		public void setMemorybacking(String memorybacking) {
			this.memorybacking = memorybacking;
		}

		public String getMemorybacking() {
			return this.memorybacking;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
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
	public static class CreateAndStartVMFromImage {

		protected String original_xml;
		
		protected String original;
		
		protected String name;
		
		protected String file;
		
		protected String vcpus;

		protected String memory;
		
		public CreateAndStartVMFromImage() {
			super();
		}

		public String getOriginal() {
			return original;
		}

		public void setOriginal(String original) {
			this.original = original;
		}

		public String getOriginal_xml() {
			return original_xml;
		}

		public void setOriginal_xml(String original_xml) {
			this.original_xml = original_xml;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getFile() {
			return file;
		}

		public void setFile(String file) {
			this.file = file;
		}

		public String getVcpus() {
			return vcpus;
		}

		public void setVcpus(String vcpus) {
			this.vcpus = vcpus;
		}

		public String getMemory() {
			return memory;
		}

		public void setMemory(String memory) {
			this.memory = memory;
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

		protected String name;

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

		public CreateAndStartVMFromISO() {

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

		public void setDisk(String disk) {
			this.disk = disk;
		}

		public String getDisk() {
			return this.disk;
		}

		public void setMemorybacking(String memorybacking) {
			this.memorybacking = memorybacking;
		}

		public String getMemorybacking() {
			return this.memorybacking;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
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
	public static class RebootVM {

		protected String mode;

		protected String domain;

		public RebootVM() {

		}

		public void setMode(String mode) {
			this.mode = mode;
		}

		public String getMode() {
			return this.mode;
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
	public static class PlugNIC {

		protected String inbound;

		protected String source;

		protected Boolean print_xml;

		protected String type;

		protected String mac;

		protected String script;

		protected String target;

		protected Boolean current;

		protected Boolean managed;

		protected String outbound;

		protected String domain;

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

		public void setPrint_xml(Boolean print_xml) {
			this.print_xml = print_xml;
		}

		public Boolean getPrint_xml() {
			return this.print_xml;
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

		public void setDomain(String domain) {
			this.domain = domain;
		}

		public String getDomain() {
			return this.domain;
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
	public static class SaveVM {

		protected Boolean running;

		protected Boolean bypass_cache;

		protected Boolean paused;

		protected String file;

		protected String xml;

		protected String domain;

		protected Boolean verbose;

		public SaveVM() {

		}

		public void setRunning(Boolean running) {
			this.running = running;
		}

		public Boolean getRunning() {
			return this.running;
		}

		public void setBypass_cache(Boolean bypass_cache) {
			this.bypass_cache = bypass_cache;
		}

		public Boolean getBypass_cache() {
			return this.bypass_cache;
		}

		public void setPaused(Boolean paused) {
			this.paused = paused;
		}

		public Boolean getPaused() {
			return this.paused;
		}

		public void setFile(String file) {
			this.file = file;
		}

		public String getFile() {
			return this.file;
		}

		public void setXml(String xml) {
			this.xml = xml;
		}

		public String getXml() {
			return this.xml;
		}

		public void setDomain(String domain) {
			this.domain = domain;
		}

		public String getDomain() {
			return this.domain;
		}

		public void setVerbose(Boolean verbose) {
			this.verbose = verbose;
		}

		public Boolean getVerbose() {
			return this.verbose;
		}
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class ConvertVMToImage {
		
	}
	
}
