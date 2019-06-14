/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes.api.model;

import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.KubernetesResource;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author xuyuanjia2017@otcaix.iscas.ac.cn
 * @author xianghao16@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @since Thu Jun 13 21:44:40 CST 2019
 **/
@JsonDeserialize(using = JsonDeserializer.None.class)
public class VirtualMachineSpec implements KubernetesResource {

	private Domain domain;

	public VirtualMachineSpec() {

	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public Domain getDomain() {
		return this.domain;
	}

	public static class Domain {

		private Metadata metadata;

		private Memory memory;

		private Vcpu vcpu;

		private ArrayList<Seclabel> seclabel;

		private Description description;

		private Title title;

		private MaxMemory maxMemory;

		private Uuid uuid;

		private Iothreadids iothreadids;

		private Features features;

		private On_crash on_crash;

		private Blkiotune blkiotune;

		private Bootloader bootloader;

		private Idmap idmap;

		private Sysinfo sysinfo;

		private Memtune memtune;

		private Numatune numatune;

		private Keywrap keywrap;

		private MemoryBacking memoryBacking;

		private Perf perf;

		private LaunchSecurity launchSecurity;

		private On_poweroff on_poweroff;

		private Bootloader_args bootloader_args;

		private Os os;

		private Devices devices;

		private Resource resource;

		private On_reboot on_reboot;

		private String _type;

		private Cpu cpu;

		private Clock clock;

		private Vcpus vcpus;

		private Cputune cputune;

		private Genid genid;

		private Iothreads iothreads;

		private Name name;

		private CurrentMemory currentMemory;

		private String _id;

		private Pm pm;

		public Domain() {

		}

		public void setMetadata(Metadata metadata) {
			this.metadata = metadata;
		}

		public Metadata getMetadata() {
			return this.metadata;
		}

		public void setMemory(Memory memory) {
			this.memory = memory;
		}

		public Memory getMemory() {
			return this.memory;
		}

		public void setVcpu(Vcpu vcpu) {
			this.vcpu = vcpu;
		}

		public Vcpu getVcpu() {
			return this.vcpu;
		}

		public void setSeclabel(ArrayList<Seclabel> seclabel) {
			this.seclabel = seclabel;
		}

		public ArrayList<Seclabel> getSeclabel() {
			return this.seclabel;
		}

		public void setDescription(Description description) {
			this.description = description;
		}

		public Description getDescription() {
			return this.description;
		}

		public void setTitle(Title title) {
			this.title = title;
		}

		public Title getTitle() {
			return this.title;
		}

		public void setMaxMemory(MaxMemory maxMemory) {
			this.maxMemory = maxMemory;
		}

		public MaxMemory getMaxMemory() {
			return this.maxMemory;
		}

		public void setUuid(Uuid uuid) {
			this.uuid = uuid;
		}

		public Uuid getUuid() {
			return this.uuid;
		}

		public void setIothreadids(Iothreadids iothreadids) {
			this.iothreadids = iothreadids;
		}

		public Iothreadids getIothreadids() {
			return this.iothreadids;
		}

		public void setFeatures(Features features) {
			this.features = features;
		}

		public Features getFeatures() {
			return this.features;
		}

		public void setOn_crash(On_crash on_crash) {
			this.on_crash = on_crash;
		}

		public On_crash getOn_crash() {
			return this.on_crash;
		}

		public void setBlkiotune(Blkiotune blkiotune) {
			this.blkiotune = blkiotune;
		}

		public Blkiotune getBlkiotune() {
			return this.blkiotune;
		}

		public void setBootloader(Bootloader bootloader) {
			this.bootloader = bootloader;
		}

		public Bootloader getBootloader() {
			return this.bootloader;
		}

		public void setIdmap(Idmap idmap) {
			this.idmap = idmap;
		}

		public Idmap getIdmap() {
			return this.idmap;
		}

		public void setSysinfo(Sysinfo sysinfo) {
			this.sysinfo = sysinfo;
		}

		public Sysinfo getSysinfo() {
			return this.sysinfo;
		}

		public void setMemtune(Memtune memtune) {
			this.memtune = memtune;
		}

		public Memtune getMemtune() {
			return this.memtune;
		}

		public void setNumatune(Numatune numatune) {
			this.numatune = numatune;
		}

		public Numatune getNumatune() {
			return this.numatune;
		}

		public void setKeywrap(Keywrap keywrap) {
			this.keywrap = keywrap;
		}

		public Keywrap getKeywrap() {
			return this.keywrap;
		}

		public void setMemoryBacking(MemoryBacking memoryBacking) {
			this.memoryBacking = memoryBacking;
		}

		public MemoryBacking getMemoryBacking() {
			return this.memoryBacking;
		}

		public void setPerf(Perf perf) {
			this.perf = perf;
		}

		public Perf getPerf() {
			return this.perf;
		}

		public void setLaunchSecurity(LaunchSecurity launchSecurity) {
			this.launchSecurity = launchSecurity;
		}

		public LaunchSecurity getLaunchSecurity() {
			return this.launchSecurity;
		}

		public void setOn_poweroff(On_poweroff on_poweroff) {
			this.on_poweroff = on_poweroff;
		}

		public On_poweroff getOn_poweroff() {
			return this.on_poweroff;
		}

		public void setBootloader_args(Bootloader_args bootloader_args) {
			this.bootloader_args = bootloader_args;
		}

		public Bootloader_args getBootloader_args() {
			return this.bootloader_args;
		}

		public void setOs(Os os) {
			this.os = os;
		}

		public Os getOs() {
			return this.os;
		}

		public void setDevices(Devices devices) {
			this.devices = devices;
		}

		public Devices getDevices() {
			return this.devices;
		}

		public void setResource(Resource resource) {
			this.resource = resource;
		}

		public Resource getResource() {
			return this.resource;
		}

		public void setOn_reboot(On_reboot on_reboot) {
			this.on_reboot = on_reboot;
		}

		public On_reboot getOn_reboot() {
			return this.on_reboot;
		}

		public void set_type(String _type) {
			this._type = _type;
		}

		public String get_type() {
			return this._type;
		}

		public void setCpu(Cpu cpu) {
			this.cpu = cpu;
		}

		public Cpu getCpu() {
			return this.cpu;
		}

		public void setClock(Clock clock) {
			this.clock = clock;
		}

		public Clock getClock() {
			return this.clock;
		}

		public void setVcpus(Vcpus vcpus) {
			this.vcpus = vcpus;
		}

		public Vcpus getVcpus() {
			return this.vcpus;
		}

		public void setCputune(Cputune cputune) {
			this.cputune = cputune;
		}

		public Cputune getCputune() {
			return this.cputune;
		}

		public void setGenid(Genid genid) {
			this.genid = genid;
		}

		public Genid getGenid() {
			return this.genid;
		}

		public void setIothreads(Iothreads iothreads) {
			this.iothreads = iothreads;
		}

		public Iothreads getIothreads() {
			return this.iothreads;
		}

		public void setName(Name name) {
			this.name = name;
		}

		public Name getName() {
			return this.name;
		}

		public void setCurrentMemory(CurrentMemory currentMemory) {
			this.currentMemory = currentMemory;
		}

		public CurrentMemory getCurrentMemory() {
			return this.currentMemory;
		}

		public void set_id(String _id) {
			this._id = _id;
		}

		public String get_id() {
			return this._id;
		}

		public void setPm(Pm pm) {
			this.pm = pm;
		}

		public Pm getPm() {
			return this.pm;
		}

		public static class Metadata {

			public Metadata() {

			}
		}

		public static class Memory {

			private String _unit;

			private String text;

			private String _dumpCore;

			public Memory() {

			}

			public void set_unit(String _unit) {
				this._unit = _unit;
			}

			public String get_unit() {
				return this._unit;
			}

			public void setText(String text) {
				this.text = text;
			}

			public String getText() {
				return this.text;
			}

			public void set_dumpCore(String _dumpCore) {
				this._dumpCore = _dumpCore;
			}

			public String get_dumpCore() {
				return this._dumpCore;
			}
		}

		public static class Vcpu {

			private String _current;

			private String _cpuset;

			private String _placement;

			private String text;

			public Vcpu() {

			}

			public void set_current(String _current) {
				this._current = _current;
			}

			public String get_current() {
				return this._current;
			}

			public void set_cpuset(String _cpuset) {
				this._cpuset = _cpuset;
			}

			public String get_cpuset() {
				return this._cpuset;
			}

			public void set_placement(String _placement) {
				this._placement = _placement;
			}

			public String get_placement() {
				return this._placement;
			}

			public void setText(String text) {
				this.text = text;
			}

			public String getText() {
				return this.text;
			}
		}

		public static class Seclabel {

			private Imagelabel imagelabel;

			private String _type;

			private Baselabel baselabel;

			private String _model;

			private Label label;

			private String _relabel;

			public Seclabel() {

			}

			public void setImagelabel(Imagelabel imagelabel) {
				this.imagelabel = imagelabel;
			}

			public Imagelabel getImagelabel() {
				return this.imagelabel;
			}

			public void set_type(String _type) {
				this._type = _type;
			}

			public String get_type() {
				return this._type;
			}

			public void setBaselabel(Baselabel baselabel) {
				this.baselabel = baselabel;
			}

			public Baselabel getBaselabel() {
				return this.baselabel;
			}

			public void set_model(String _model) {
				this._model = _model;
			}

			public String get_model() {
				return this._model;
			}

			public void setLabel(Label label) {
				this.label = label;
			}

			public Label getLabel() {
				return this.label;
			}

			public void set_relabel(String _relabel) {
				this._relabel = _relabel;
			}

			public String get_relabel() {
				return this._relabel;
			}

			public static class Imagelabel {

				private String text;

				public Imagelabel() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Baselabel {

				private String text;

				public Baselabel() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Label {

				private String text;

				public Label() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}
		}

		public static class Description {

			private String text;

			public Description() {

			}

			public void setText(String text) {
				this.text = text;
			}

			public String getText() {
				return this.text;
			}
		}

		public static class Title {

			private String text;

			public Title() {

			}

			public void setText(String text) {
				this.text = text;
			}

			public String getText() {
				return this.text;
			}
		}

		public static class MaxMemory {

			private String _unit;

			private String _slots;

			private String text;

			public MaxMemory() {

			}

			public void set_unit(String _unit) {
				this._unit = _unit;
			}

			public String get_unit() {
				return this._unit;
			}

			public void set_slots(String _slots) {
				this._slots = _slots;
			}

			public String get_slots() {
				return this._slots;
			}

			public void setText(String text) {
				this.text = text;
			}

			public String getText() {
				return this.text;
			}
		}

		public static class Uuid {

			private String text;

			public Uuid() {

			}

			public void setText(String text) {
				this.text = text;
			}

			public String getText() {
				return this.text;
			}
		}

		public static class Iothreadids {

			private ArrayList<Iothread> iothread;

			public Iothreadids() {

			}

			public void setIothread(ArrayList<Iothread> iothread) {
				this.iothread = iothread;
			}

			public ArrayList<Iothread> getIothread() {
				return this.iothread;
			}

			public static class Iothread {

				private String _id;

				public Iothread() {

				}

				public void set_id(String _id) {
					this._id = _id;
				}

				public String get_id() {
					return this._id;
				}
			}
		}

		public static class Features {

			private Gic gic;

			private Htm htm;

			private Capabilities capabilities;

			private Kvm kvm;

			private Apic apic;

			private Viridian viridian;

			private Pvspinlock pvspinlock;

			private Vmport vmport;

			private Vmcoreinfo vmcoreinfo;

			private Hpt hpt;

			private Privnet privnet;

			private Smm smm;

			private Msrs msrs;

			private Pae pae;

			private Acpi acpi;

			private Hap hap;

			private Ioapic ioapic;

			private Pmu pmu;

			private Nested_hv nested_hv;

			private Hyperv hyperv;

			public Features() {

			}

			public void setGic(Gic gic) {
				this.gic = gic;
			}

			public Gic getGic() {
				return this.gic;
			}

			public void setHtm(Htm htm) {
				this.htm = htm;
			}

			public Htm getHtm() {
				return this.htm;
			}

			public void setCapabilities(Capabilities capabilities) {
				this.capabilities = capabilities;
			}

			public Capabilities getCapabilities() {
				return this.capabilities;
			}

			public void setKvm(Kvm kvm) {
				this.kvm = kvm;
			}

			public Kvm getKvm() {
				return this.kvm;
			}

			public void setApic(Apic apic) {
				this.apic = apic;
			}

			public Apic getApic() {
				return this.apic;
			}

			public void setViridian(Viridian viridian) {
				this.viridian = viridian;
			}

			public Viridian getViridian() {
				return this.viridian;
			}

			public void setPvspinlock(Pvspinlock pvspinlock) {
				this.pvspinlock = pvspinlock;
			}

			public Pvspinlock getPvspinlock() {
				return this.pvspinlock;
			}

			public void setVmport(Vmport vmport) {
				this.vmport = vmport;
			}

			public Vmport getVmport() {
				return this.vmport;
			}

			public void setVmcoreinfo(Vmcoreinfo vmcoreinfo) {
				this.vmcoreinfo = vmcoreinfo;
			}

			public Vmcoreinfo getVmcoreinfo() {
				return this.vmcoreinfo;
			}

			public void setHpt(Hpt hpt) {
				this.hpt = hpt;
			}

			public Hpt getHpt() {
				return this.hpt;
			}

			public void setPrivnet(Privnet privnet) {
				this.privnet = privnet;
			}

			public Privnet getPrivnet() {
				return this.privnet;
			}

			public void setSmm(Smm smm) {
				this.smm = smm;
			}

			public Smm getSmm() {
				return this.smm;
			}

			public void setMsrs(Msrs msrs) {
				this.msrs = msrs;
			}

			public Msrs getMsrs() {
				return this.msrs;
			}

			public void setPae(Pae pae) {
				this.pae = pae;
			}

			public Pae getPae() {
				return this.pae;
			}

			public void setAcpi(Acpi acpi) {
				this.acpi = acpi;
			}

			public Acpi getAcpi() {
				return this.acpi;
			}

			public void setHap(Hap hap) {
				this.hap = hap;
			}

			public Hap getHap() {
				return this.hap;
			}

			public void setIoapic(Ioapic ioapic) {
				this.ioapic = ioapic;
			}

			public Ioapic getIoapic() {
				return this.ioapic;
			}

			public void setPmu(Pmu pmu) {
				this.pmu = pmu;
			}

			public Pmu getPmu() {
				return this.pmu;
			}

			public void setNested_hv(Nested_hv nested_hv) {
				this.nested_hv = nested_hv;
			}

			public Nested_hv getNested_hv() {
				return this.nested_hv;
			}

			public void setHyperv(Hyperv hyperv) {
				this.hyperv = hyperv;
			}

			public Hyperv getHyperv() {
				return this.hyperv;
			}

			public static class Gic {

				private String _version;

				public Gic() {

				}

				public void set_version(String _version) {
					this._version = _version;
				}

				public String get_version() {
					return this._version;
				}
			}

			public static class Htm {

				private String _state;

				public Htm() {

				}

				public void set_state(String _state) {
					this._state = _state;
				}

				public String get_state() {
					return this._state;
				}
			}

			public static class Capabilities {

				private Dac_read_Search dac_read_Search;

				private Fsetid fsetid;

				private Dac_override dac_override;

				private Syslog syslog;

				private String _policy;

				private Net_raw net_raw;

				private Mac_override mac_override;

				private Setfcap setfcap;

				private Mknod mknod;

				private Sys_time sys_time;

				private Sys_tty_config sys_tty_config;

				private Net_broadcast net_broadcast;

				private Setpcap setpcap;

				private Ipc_lock ipc_lock;

				private Net_bind_service net_bind_service;

				private Wake_alarm wake_alarm;

				private Linux_immutable linux_immutable;

				private Sys_pacct sys_pacct;

				private Ipc_owner ipc_owner;

				private Net_admin net_admin;

				private Setgid setgid;

				private Sys_ptrace sys_ptrace;

				private Chown chown;

				private Sys_admin sys_admin;

				private Sys_module sys_module;

				private Sys_nice sys_nice;

				private Kill kill;

				private Audit_control audit_control;

				private Setuid setuid;

				private Fowner fowner;

				private Sys_resource sys_resource;

				private Sys_chroot sys_chroot;

				private Sys_rawio sys_rawio;

				private Audit_write audit_write;

				private Block_suspend block_suspend;

				private Lease lease;

				private Sys_boot sys_boot;

				private Mac_admin mac_admin;

				public Capabilities() {

				}

				public void setDac_read_Search(Dac_read_Search dac_read_Search) {
					this.dac_read_Search = dac_read_Search;
				}

				public Dac_read_Search getDac_read_Search() {
					return this.dac_read_Search;
				}

				public void setFsetid(Fsetid fsetid) {
					this.fsetid = fsetid;
				}

				public Fsetid getFsetid() {
					return this.fsetid;
				}

				public void setDac_override(Dac_override dac_override) {
					this.dac_override = dac_override;
				}

				public Dac_override getDac_override() {
					return this.dac_override;
				}

				public void setSyslog(Syslog syslog) {
					this.syslog = syslog;
				}

				public Syslog getSyslog() {
					return this.syslog;
				}

				public void set_policy(String _policy) {
					this._policy = _policy;
				}

				public String get_policy() {
					return this._policy;
				}

				public void setNet_raw(Net_raw net_raw) {
					this.net_raw = net_raw;
				}

				public Net_raw getNet_raw() {
					return this.net_raw;
				}

				public void setMac_override(Mac_override mac_override) {
					this.mac_override = mac_override;
				}

				public Mac_override getMac_override() {
					return this.mac_override;
				}

				public void setSetfcap(Setfcap setfcap) {
					this.setfcap = setfcap;
				}

				public Setfcap getSetfcap() {
					return this.setfcap;
				}

				public void setMknod(Mknod mknod) {
					this.mknod = mknod;
				}

				public Mknod getMknod() {
					return this.mknod;
				}

				public void setSys_time(Sys_time sys_time) {
					this.sys_time = sys_time;
				}

				public Sys_time getSys_time() {
					return this.sys_time;
				}

				public void setSys_tty_config(Sys_tty_config sys_tty_config) {
					this.sys_tty_config = sys_tty_config;
				}

				public Sys_tty_config getSys_tty_config() {
					return this.sys_tty_config;
				}

				public void setNet_broadcast(Net_broadcast net_broadcast) {
					this.net_broadcast = net_broadcast;
				}

				public Net_broadcast getNet_broadcast() {
					return this.net_broadcast;
				}

				public void setSetpcap(Setpcap setpcap) {
					this.setpcap = setpcap;
				}

				public Setpcap getSetpcap() {
					return this.setpcap;
				}

				public void setIpc_lock(Ipc_lock ipc_lock) {
					this.ipc_lock = ipc_lock;
				}

				public Ipc_lock getIpc_lock() {
					return this.ipc_lock;
				}

				public void setNet_bind_service(Net_bind_service net_bind_service) {
					this.net_bind_service = net_bind_service;
				}

				public Net_bind_service getNet_bind_service() {
					return this.net_bind_service;
				}

				public void setWake_alarm(Wake_alarm wake_alarm) {
					this.wake_alarm = wake_alarm;
				}

				public Wake_alarm getWake_alarm() {
					return this.wake_alarm;
				}

				public void setLinux_immutable(Linux_immutable linux_immutable) {
					this.linux_immutable = linux_immutable;
				}

				public Linux_immutable getLinux_immutable() {
					return this.linux_immutable;
				}

				public void setSys_pacct(Sys_pacct sys_pacct) {
					this.sys_pacct = sys_pacct;
				}

				public Sys_pacct getSys_pacct() {
					return this.sys_pacct;
				}

				public void setIpc_owner(Ipc_owner ipc_owner) {
					this.ipc_owner = ipc_owner;
				}

				public Ipc_owner getIpc_owner() {
					return this.ipc_owner;
				}

				public void setNet_admin(Net_admin net_admin) {
					this.net_admin = net_admin;
				}

				public Net_admin getNet_admin() {
					return this.net_admin;
				}

				public void setSetgid(Setgid setgid) {
					this.setgid = setgid;
				}

				public Setgid getSetgid() {
					return this.setgid;
				}

				public void setSys_ptrace(Sys_ptrace sys_ptrace) {
					this.sys_ptrace = sys_ptrace;
				}

				public Sys_ptrace getSys_ptrace() {
					return this.sys_ptrace;
				}

				public void setChown(Chown chown) {
					this.chown = chown;
				}

				public Chown getChown() {
					return this.chown;
				}

				public void setSys_admin(Sys_admin sys_admin) {
					this.sys_admin = sys_admin;
				}

				public Sys_admin getSys_admin() {
					return this.sys_admin;
				}

				public void setSys_module(Sys_module sys_module) {
					this.sys_module = sys_module;
				}

				public Sys_module getSys_module() {
					return this.sys_module;
				}

				public void setSys_nice(Sys_nice sys_nice) {
					this.sys_nice = sys_nice;
				}

				public Sys_nice getSys_nice() {
					return this.sys_nice;
				}

				public void setKill(Kill kill) {
					this.kill = kill;
				}

				public Kill getKill() {
					return this.kill;
				}

				public void setAudit_control(Audit_control audit_control) {
					this.audit_control = audit_control;
				}

				public Audit_control getAudit_control() {
					return this.audit_control;
				}

				public void setSetuid(Setuid setuid) {
					this.setuid = setuid;
				}

				public Setuid getSetuid() {
					return this.setuid;
				}

				public void setFowner(Fowner fowner) {
					this.fowner = fowner;
				}

				public Fowner getFowner() {
					return this.fowner;
				}

				public void setSys_resource(Sys_resource sys_resource) {
					this.sys_resource = sys_resource;
				}

				public Sys_resource getSys_resource() {
					return this.sys_resource;
				}

				public void setSys_chroot(Sys_chroot sys_chroot) {
					this.sys_chroot = sys_chroot;
				}

				public Sys_chroot getSys_chroot() {
					return this.sys_chroot;
				}

				public void setSys_rawio(Sys_rawio sys_rawio) {
					this.sys_rawio = sys_rawio;
				}

				public Sys_rawio getSys_rawio() {
					return this.sys_rawio;
				}

				public void setAudit_write(Audit_write audit_write) {
					this.audit_write = audit_write;
				}

				public Audit_write getAudit_write() {
					return this.audit_write;
				}

				public void setBlock_suspend(Block_suspend block_suspend) {
					this.block_suspend = block_suspend;
				}

				public Block_suspend getBlock_suspend() {
					return this.block_suspend;
				}

				public void setLease(Lease lease) {
					this.lease = lease;
				}

				public Lease getLease() {
					return this.lease;
				}

				public void setSys_boot(Sys_boot sys_boot) {
					this.sys_boot = sys_boot;
				}

				public Sys_boot getSys_boot() {
					return this.sys_boot;
				}

				public void setMac_admin(Mac_admin mac_admin) {
					this.mac_admin = mac_admin;
				}

				public Mac_admin getMac_admin() {
					return this.mac_admin;
				}

				public static class Dac_read_Search {

					private String _state;

					public Dac_read_Search() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Fsetid {

					private String _state;

					public Fsetid() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Dac_override {

					private String _state;

					public Dac_override() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Syslog {

					private String _state;

					public Syslog() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Net_raw {

					private String _state;

					public Net_raw() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Mac_override {

					private String _state;

					public Mac_override() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Setfcap {

					private String _state;

					public Setfcap() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Mknod {

					private String _state;

					public Mknod() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Sys_time {

					private String _state;

					public Sys_time() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Sys_tty_config {

					private String _state;

					public Sys_tty_config() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Net_broadcast {

					private String _state;

					public Net_broadcast() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Setpcap {

					private String _state;

					public Setpcap() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Ipc_lock {

					private String _state;

					public Ipc_lock() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Net_bind_service {

					private String _state;

					public Net_bind_service() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Wake_alarm {

					private String _state;

					public Wake_alarm() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Linux_immutable {

					private String _state;

					public Linux_immutable() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Sys_pacct {

					private String _state;

					public Sys_pacct() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Ipc_owner {

					private String _state;

					public Ipc_owner() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Net_admin {

					private String _state;

					public Net_admin() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Setgid {

					private String _state;

					public Setgid() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Sys_ptrace {

					private String _state;

					public Sys_ptrace() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Chown {

					private String _state;

					public Chown() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Sys_admin {

					private String _state;

					public Sys_admin() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Sys_module {

					private String _state;

					public Sys_module() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Sys_nice {

					private String _state;

					public Sys_nice() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Kill {

					private String _state;

					public Kill() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Audit_control {

					private String _state;

					public Audit_control() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Setuid {

					private String _state;

					public Setuid() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Fowner {

					private String _state;

					public Fowner() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Sys_resource {

					private String _state;

					public Sys_resource() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Sys_chroot {

					private String _state;

					public Sys_chroot() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Sys_rawio {

					private String _state;

					public Sys_rawio() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Audit_write {

					private String _state;

					public Audit_write() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Block_suspend {

					private String _state;

					public Block_suspend() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Lease {

					private String _state;

					public Lease() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Sys_boot {

					private String _state;

					public Sys_boot() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Mac_admin {

					private String _state;

					public Mac_admin() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}
			}

			public static class Kvm {

				private Hidden hidden;

				public Kvm() {

				}

				public void setHidden(Hidden hidden) {
					this.hidden = hidden;
				}

				public Hidden getHidden() {
					return this.hidden;
				}

				public static class Hidden {

					private String _state;

					public Hidden() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}
			}

			public static class Apic {

				private String _eoi;

				public Apic() {

				}

				public void set_eoi(String _eoi) {
					this._eoi = _eoi;
				}

				public String get_eoi() {
					return this._eoi;
				}
			}

			public static class Viridian {

				public Viridian() {

				}
			}

			public static class Pvspinlock {

				private String _state;

				public Pvspinlock() {

				}

				public void set_state(String _state) {
					this._state = _state;
				}

				public String get_state() {
					return this._state;
				}
			}

			public static class Vmport {

				private String _state;

				public Vmport() {

				}

				public void set_state(String _state) {
					this._state = _state;
				}

				public String get_state() {
					return this._state;
				}
			}

			public static class Vmcoreinfo {

				private String _state;

				public Vmcoreinfo() {

				}

				public void set_state(String _state) {
					this._state = _state;
				}

				public String get_state() {
					return this._state;
				}
			}

			public static class Hpt {

				private Maxpagesize maxpagesize;

				private String _resizing;

				public Hpt() {

				}

				public void setMaxpagesize(Maxpagesize maxpagesize) {
					this.maxpagesize = maxpagesize;
				}

				public Maxpagesize getMaxpagesize() {
					return this.maxpagesize;
				}

				public void set_resizing(String _resizing) {
					this._resizing = _resizing;
				}

				public String get_resizing() {
					return this._resizing;
				}

				public static class Maxpagesize {

					private String _unit;

					private String text;

					public Maxpagesize() {

					}

					public void set_unit(String _unit) {
						this._unit = _unit;
					}

					public String get_unit() {
						return this._unit;
					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}
			}

			public static class Privnet {

				public Privnet() {

				}
			}

			public static class Smm {

				private String _state;

				private Tseg tseg;

				public Smm() {

				}

				public void set_state(String _state) {
					this._state = _state;
				}

				public String get_state() {
					return this._state;
				}

				public void setTseg(Tseg tseg) {
					this.tseg = tseg;
				}

				public Tseg getTseg() {
					return this.tseg;
				}

				public static class Tseg {

					private String _unit;

					private String text;

					public Tseg() {

					}

					public void set_unit(String _unit) {
						this._unit = _unit;
					}

					public String get_unit() {
						return this._unit;
					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}
			}

			public static class Msrs {

				private String _unknown;

				public Msrs() {

				}

				public void set_unknown(String _unknown) {
					this._unknown = _unknown;
				}

				public String get_unknown() {
					return this._unknown;
				}
			}

			public static class Pae {

				public Pae() {

				}
			}

			public static class Acpi {

				public Acpi() {

				}
			}

			public static class Hap {

				private String _state;

				public Hap() {

				}

				public void set_state(String _state) {
					this._state = _state;
				}

				public String get_state() {
					return this._state;
				}
			}

			public static class Ioapic {

				private String _driver;

				public Ioapic() {

				}

				public void set_driver(String _driver) {
					this._driver = _driver;
				}

				public String get_driver() {
					return this._driver;
				}
			}

			public static class Pmu {

				private String _state;

				public Pmu() {

				}

				public void set_state(String _state) {
					this._state = _state;
				}

				public String get_state() {
					return this._state;
				}
			}

			public static class Nested_hv {

				private String _state;

				public Nested_hv() {

				}

				public void set_state(String _state) {
					this._state = _state;
				}

				public String get_state() {
					return this._state;
				}
			}

			public static class Hyperv {

				private Vpindex vpindex;

				private Ipi ipi;

				private Stimer stimer;

				private Reenlightenment reenlightenment;

				private Runtime runtime;

				private Evmcs evmcs;

				private Spinlocks spinlocks;

				private Tlbflush tlbflush;

				private Synic synic;

				private Relaxed relaxed;

				private Vapic vapic;

				private Vendor_id vendor_id;

				private Reset reset;

				private Frequencies frequencies;

				public Hyperv() {

				}

				public void setVpindex(Vpindex vpindex) {
					this.vpindex = vpindex;
				}

				public Vpindex getVpindex() {
					return this.vpindex;
				}

				public void setIpi(Ipi ipi) {
					this.ipi = ipi;
				}

				public Ipi getIpi() {
					return this.ipi;
				}

				public void setStimer(Stimer stimer) {
					this.stimer = stimer;
				}

				public Stimer getStimer() {
					return this.stimer;
				}

				public void setReenlightenment(Reenlightenment reenlightenment) {
					this.reenlightenment = reenlightenment;
				}

				public Reenlightenment getReenlightenment() {
					return this.reenlightenment;
				}

				public void setRuntime(Runtime runtime) {
					this.runtime = runtime;
				}

				public Runtime getRuntime() {
					return this.runtime;
				}

				public void setEvmcs(Evmcs evmcs) {
					this.evmcs = evmcs;
				}

				public Evmcs getEvmcs() {
					return this.evmcs;
				}

				public void setSpinlocks(Spinlocks spinlocks) {
					this.spinlocks = spinlocks;
				}

				public Spinlocks getSpinlocks() {
					return this.spinlocks;
				}

				public void setTlbflush(Tlbflush tlbflush) {
					this.tlbflush = tlbflush;
				}

				public Tlbflush getTlbflush() {
					return this.tlbflush;
				}

				public void setSynic(Synic synic) {
					this.synic = synic;
				}

				public Synic getSynic() {
					return this.synic;
				}

				public void setRelaxed(Relaxed relaxed) {
					this.relaxed = relaxed;
				}

				public Relaxed getRelaxed() {
					return this.relaxed;
				}

				public void setVapic(Vapic vapic) {
					this.vapic = vapic;
				}

				public Vapic getVapic() {
					return this.vapic;
				}

				public void setVendor_id(Vendor_id vendor_id) {
					this.vendor_id = vendor_id;
				}

				public Vendor_id getVendor_id() {
					return this.vendor_id;
				}

				public void setReset(Reset reset) {
					this.reset = reset;
				}

				public Reset getReset() {
					return this.reset;
				}

				public void setFrequencies(Frequencies frequencies) {
					this.frequencies = frequencies;
				}

				public Frequencies getFrequencies() {
					return this.frequencies;
				}

				public static class Vpindex {

					private String _state;

					public Vpindex() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Ipi {

					private String _state;

					public Ipi() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Stimer {

					private String _state;

					public Stimer() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Reenlightenment {

					private String _state;

					public Reenlightenment() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Runtime {

					private String _state;

					public Runtime() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Evmcs {

					private String _state;

					public Evmcs() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Spinlocks {

					private String _retries;

					public Spinlocks() {

					}

					public void set_retries(String _retries) {
						this._retries = _retries;
					}

					public String get_retries() {
						return this._retries;
					}
				}

				public static class Tlbflush {

					private String _state;

					public Tlbflush() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Synic {

					private String _state;

					public Synic() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Relaxed {

					private String _state;

					public Relaxed() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Vapic {

					private String _state;

					public Vapic() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Vendor_id {

					private String _value;

					public Vendor_id() {

					}

					public void set_value(String _value) {
						this._value = _value;
					}

					public String get_value() {
						return this._value;
					}
				}

				public static class Reset {

					private String _state;

					public Reset() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Frequencies {

					private String _state;

					public Frequencies() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}
			}
		}

		public static class On_crash {

			private String text;

			public On_crash() {

			}

			public void setText(String text) {
				this.text = text;
			}

			public String getText() {
				return this.text;
			}
		}

		public static class Blkiotune {

			private Weight weight;

			private ArrayList<Device> device;

			public Blkiotune() {

			}

			public void setWeight(Weight weight) {
				this.weight = weight;
			}

			public Weight getWeight() {
				return this.weight;
			}

			public void setDevice(ArrayList<Device> device) {
				this.device = device;
			}

			public ArrayList<Device> getDevice() {
				return this.device;
			}

			public static class Weight {

				private String text;

				public Weight() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Device {

				private Path path;

				private Write_bytes_sec write_bytes_sec;

				private Write_iops_sec write_iops_sec;

				private Weight weight;

				private Read_bytes_sec read_bytes_sec;

				private Read_iops_sec read_iops_sec;

				public Device() {

				}

				public void setPath(Path path) {
					this.path = path;
				}

				public Path getPath() {
					return this.path;
				}

				public void setWrite_bytes_sec(Write_bytes_sec write_bytes_sec) {
					this.write_bytes_sec = write_bytes_sec;
				}

				public Write_bytes_sec getWrite_bytes_sec() {
					return this.write_bytes_sec;
				}

				public void setWrite_iops_sec(Write_iops_sec write_iops_sec) {
					this.write_iops_sec = write_iops_sec;
				}

				public Write_iops_sec getWrite_iops_sec() {
					return this.write_iops_sec;
				}

				public void setWeight(Weight weight) {
					this.weight = weight;
				}

				public Weight getWeight() {
					return this.weight;
				}

				public void setRead_bytes_sec(Read_bytes_sec read_bytes_sec) {
					this.read_bytes_sec = read_bytes_sec;
				}

				public Read_bytes_sec getRead_bytes_sec() {
					return this.read_bytes_sec;
				}

				public void setRead_iops_sec(Read_iops_sec read_iops_sec) {
					this.read_iops_sec = read_iops_sec;
				}

				public Read_iops_sec getRead_iops_sec() {
					return this.read_iops_sec;
				}

				public static class Path {

					private String text;

					public Path() {

					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}

				public static class Write_bytes_sec {

					private String text;

					public Write_bytes_sec() {

					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}

				public static class Write_iops_sec {

					private String text;

					public Write_iops_sec() {

					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}

				public static class Weight {

					private String text;

					public Weight() {

					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}

				public static class Read_bytes_sec {

					private String text;

					public Read_bytes_sec() {

					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}

				public static class Read_iops_sec {

					private String text;

					public Read_iops_sec() {

					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}
			}
		}

		public static class Bootloader {

			private String text;

			public Bootloader() {

			}

			public void setText(String text) {
				this.text = text;
			}

			public String getText() {
				return this.text;
			}
		}

		public static class Idmap {

			private ArrayList<Uid> uid;

			private ArrayList<Gid> gid;

			public Idmap() {

			}

			public void setUid(ArrayList<Uid> uid) {
				this.uid = uid;
			}

			public ArrayList<Uid> getUid() {
				return this.uid;
			}

			public void setGid(ArrayList<Gid> gid) {
				this.gid = gid;
			}

			public ArrayList<Gid> getGid() {
				return this.gid;
			}

			public static class Uid {

				private String _count;

				private String _start;

				private String _target;

				public Uid() {

				}

				public void set_count(String _count) {
					this._count = _count;
				}

				public String get_count() {
					return this._count;
				}

				public void set_start(String _start) {
					this._start = _start;
				}

				public String get_start() {
					return this._start;
				}

				public void set_target(String _target) {
					this._target = _target;
				}

				public String get_target() {
					return this._target;
				}
			}

			public static class Gid {

				private String _count;

				private String _start;

				private String _target;

				public Gid() {

				}

				public void set_count(String _count) {
					this._count = _count;
				}

				public String get_count() {
					return this._count;
				}

				public void set_start(String _start) {
					this._start = _start;
				}

				public String get_start() {
					return this._start;
				}

				public void set_target(String _target) {
					this._target = _target;
				}

				public String get_target() {
					return this._target;
				}
			}
		}

		public static class Sysinfo {

			private ArrayList<Memory> memory;

			private System system;

			private ArrayList<BaseBoard> baseBoard;

			private Bios bios;

			private String _type;

			private Chassis chassis;

			private OemStrings oemStrings;

			private ArrayList<Processor> processor;

			public Sysinfo() {

			}

			public void setMemory(ArrayList<Memory> memory) {
				this.memory = memory;
			}

			public ArrayList<Memory> getMemory() {
				return this.memory;
			}

			public void setSystem(System system) {
				this.system = system;
			}

			public System getSystem() {
				return this.system;
			}

			public void setBaseBoard(ArrayList<BaseBoard> baseBoard) {
				this.baseBoard = baseBoard;
			}

			public ArrayList<BaseBoard> getBaseBoard() {
				return this.baseBoard;
			}

			public void setBios(Bios bios) {
				this.bios = bios;
			}

			public Bios getBios() {
				return this.bios;
			}

			public void set_type(String _type) {
				this._type = _type;
			}

			public String get_type() {
				return this._type;
			}

			public void setChassis(Chassis chassis) {
				this.chassis = chassis;
			}

			public Chassis getChassis() {
				return this.chassis;
			}

			public void setOemStrings(OemStrings oemStrings) {
				this.oemStrings = oemStrings;
			}

			public OemStrings getOemStrings() {
				return this.oemStrings;
			}

			public void setProcessor(ArrayList<Processor> processor) {
				this.processor = processor;
			}

			public ArrayList<Processor> getProcessor() {
				return this.processor;
			}

			public static class Memory {

				private ArrayList<Entry> entry;

				public Memory() {

				}

				public void setEntry(ArrayList<Entry> entry) {
					this.entry = entry;
				}

				public ArrayList<Entry> getEntry() {
					return this.entry;
				}

				public static class Entry {

					private String _name;

					private String text;

					public Entry() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}
			}

			public static class System {

				private ArrayList<Entry> entry;

				public System() {

				}

				public void setEntry(ArrayList<Entry> entry) {
					this.entry = entry;
				}

				public ArrayList<Entry> getEntry() {
					return this.entry;
				}

				public static class Entry {

					private String _name;

					private String text;

					public Entry() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}
			}

			public static class BaseBoard {

				private ArrayList<Entry> entry;

				public BaseBoard() {

				}

				public void setEntry(ArrayList<Entry> entry) {
					this.entry = entry;
				}

				public ArrayList<Entry> getEntry() {
					return this.entry;
				}

				public static class Entry {

					private String _name;

					private String text;

					public Entry() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}
			}

			public static class Bios {

				private ArrayList<Entry> entry;

				public Bios() {

				}

				public void setEntry(ArrayList<Entry> entry) {
					this.entry = entry;
				}

				public ArrayList<Entry> getEntry() {
					return this.entry;
				}

				public static class Entry {

					private String _name;

					private String text;

					public Entry() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}
			}

			public static class Chassis {

				private ArrayList<Entry> entry;

				public Chassis() {

				}

				public void setEntry(ArrayList<Entry> entry) {
					this.entry = entry;
				}

				public ArrayList<Entry> getEntry() {
					return this.entry;
				}

				public static class Entry {

					private String _name;

					private String text;

					public Entry() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}
			}

			public static class OemStrings {

				private Entry entry;

				public OemStrings() {

				}

				public void setEntry(Entry entry) {
					this.entry = entry;
				}

				public Entry getEntry() {
					return this.entry;
				}

				public static class Entry {

					private String text;

					public Entry() {

					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}
			}

			public static class Processor {

				private ArrayList<Entry> entry;

				public Processor() {

				}

				public void setEntry(ArrayList<Entry> entry) {
					this.entry = entry;
				}

				public ArrayList<Entry> getEntry() {
					return this.entry;
				}

				public static class Entry {

					private String _name;

					private String text;

					public Entry() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}
			}
		}

		public static class Memtune {

			private Soft_limit soft_limit;

			private Min_guarantee min_guarantee;

			private Swap_hard_limit swap_hard_limit;

			private Hard_limit hard_limit;

			public Memtune() {

			}

			public void setSoft_limit(Soft_limit soft_limit) {
				this.soft_limit = soft_limit;
			}

			public Soft_limit getSoft_limit() {
				return this.soft_limit;
			}

			public void setMin_guarantee(Min_guarantee min_guarantee) {
				this.min_guarantee = min_guarantee;
			}

			public Min_guarantee getMin_guarantee() {
				return this.min_guarantee;
			}

			public void setSwap_hard_limit(Swap_hard_limit swap_hard_limit) {
				this.swap_hard_limit = swap_hard_limit;
			}

			public Swap_hard_limit getSwap_hard_limit() {
				return this.swap_hard_limit;
			}

			public void setHard_limit(Hard_limit hard_limit) {
				this.hard_limit = hard_limit;
			}

			public Hard_limit getHard_limit() {
				return this.hard_limit;
			}

			public static class Soft_limit {

				private String _unit;

				private String text;

				public Soft_limit() {

				}

				public void set_unit(String _unit) {
					this._unit = _unit;
				}

				public String get_unit() {
					return this._unit;
				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Min_guarantee {

				private String _unit;

				private String text;

				public Min_guarantee() {

				}

				public void set_unit(String _unit) {
					this._unit = _unit;
				}

				public String get_unit() {
					return this._unit;
				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Swap_hard_limit {

				private String _unit;

				private String text;

				public Swap_hard_limit() {

				}

				public void set_unit(String _unit) {
					this._unit = _unit;
				}

				public String get_unit() {
					return this._unit;
				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Hard_limit {

				private String _unit;

				private String text;

				public Hard_limit() {

				}

				public void set_unit(String _unit) {
					this._unit = _unit;
				}

				public String get_unit() {
					return this._unit;
				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}
		}

		public static class Numatune {

			private ArrayList<Memnode> memnode;

			private Memory memory;

			public Numatune() {

			}

			public void setMemnode(ArrayList<Memnode> memnode) {
				this.memnode = memnode;
			}

			public ArrayList<Memnode> getMemnode() {
				return this.memnode;
			}

			public void setMemory(Memory memory) {
				this.memory = memory;
			}

			public Memory getMemory() {
				return this.memory;
			}

			public static class Memnode {

				private String _nodeset;

				private String _cellid;

				private String _mode;

				public Memnode() {

				}

				public void set_nodeset(String _nodeset) {
					this._nodeset = _nodeset;
				}

				public String get_nodeset() {
					return this._nodeset;
				}

				public void set_cellid(String _cellid) {
					this._cellid = _cellid;
				}

				public String get_cellid() {
					return this._cellid;
				}

				public void set_mode(String _mode) {
					this._mode = _mode;
				}

				public String get_mode() {
					return this._mode;
				}
			}

			public static class Memory {

				private String _nodeset;

				private String _placement;

				private String _mode;

				public Memory() {

				}

				public void set_nodeset(String _nodeset) {
					this._nodeset = _nodeset;
				}

				public String get_nodeset() {
					return this._nodeset;
				}

				public void set_placement(String _placement) {
					this._placement = _placement;
				}

				public String get_placement() {
					return this._placement;
				}

				public void set_mode(String _mode) {
					this._mode = _mode;
				}

				public String get_mode() {
					return this._mode;
				}
			}
		}

		public static class Keywrap {

			private ArrayList<Cipher> cipher;

			public Keywrap() {

			}

			public void setCipher(ArrayList<Cipher> cipher) {
				this.cipher = cipher;
			}

			public ArrayList<Cipher> getCipher() {
				return this.cipher;
			}

			public static class Cipher {

				private String _name;

				private String _state;

				public Cipher() {

				}

				public void set_name(String _name) {
					this._name = _name;
				}

				public String get_name() {
					return this._name;
				}

				public void set_state(String _state) {
					this._state = _state;
				}

				public String get_state() {
					return this._state;
				}
			}
		}

		public static class MemoryBacking {

			private Hugepages hugepages;

			private Discard discard;

			private Allocation allocation;

			private Access access;

			private Nosharepages nosharepages;

			private Source source;

			private Locked locked;

			public MemoryBacking() {

			}

			public void setHugepages(Hugepages hugepages) {
				this.hugepages = hugepages;
			}

			public Hugepages getHugepages() {
				return this.hugepages;
			}

			public void setDiscard(Discard discard) {
				this.discard = discard;
			}

			public Discard getDiscard() {
				return this.discard;
			}

			public void setAllocation(Allocation allocation) {
				this.allocation = allocation;
			}

			public Allocation getAllocation() {
				return this.allocation;
			}

			public void setAccess(Access access) {
				this.access = access;
			}

			public Access getAccess() {
				return this.access;
			}

			public void setNosharepages(Nosharepages nosharepages) {
				this.nosharepages = nosharepages;
			}

			public Nosharepages getNosharepages() {
				return this.nosharepages;
			}

			public void setSource(Source source) {
				this.source = source;
			}

			public Source getSource() {
				return this.source;
			}

			public void setLocked(Locked locked) {
				this.locked = locked;
			}

			public Locked getLocked() {
				return this.locked;
			}

			public static class Hugepages {

				private ArrayList<Page> page;

				public Hugepages() {

				}

				public void setPage(ArrayList<Page> page) {
					this.page = page;
				}

				public ArrayList<Page> getPage() {
					return this.page;
				}

				public static class Page {

					private String _size;

					private String _unit;

					private String _nodeset;

					public Page() {

					}

					public void set_size(String _size) {
						this._size = _size;
					}

					public String get_size() {
						return this._size;
					}

					public void set_unit(String _unit) {
						this._unit = _unit;
					}

					public String get_unit() {
						return this._unit;
					}

					public void set_nodeset(String _nodeset) {
						this._nodeset = _nodeset;
					}

					public String get_nodeset() {
						return this._nodeset;
					}
				}
			}

			public static class Discard {

				public Discard() {

				}
			}

			public static class Allocation {

				private String _mode;

				public Allocation() {

				}

				public void set_mode(String _mode) {
					this._mode = _mode;
				}

				public String get_mode() {
					return this._mode;
				}
			}

			public static class Access {

				private String _mode;

				public Access() {

				}

				public void set_mode(String _mode) {
					this._mode = _mode;
				}

				public String get_mode() {
					return this._mode;
				}
			}

			public static class Nosharepages {

				public Nosharepages() {

				}
			}

			public static class Source {

				private String _type;

				public Source() {

				}

				public void set_type(String _type) {
					this._type = _type;
				}

				public String get_type() {
					return this._type;
				}
			}

			public static class Locked {

				public Locked() {

				}
			}
		}

		public static class Perf {

			private ArrayList<Event> event;

			public Perf() {

			}

			public void setEvent(ArrayList<Event> event) {
				this.event = event;
			}

			public ArrayList<Event> getEvent() {
				return this.event;
			}

			public static class Event {

				private String _name;

				private String _enabled;

				public Event() {

				}

				public void set_name(String _name) {
					this._name = _name;
				}

				public String get_name() {
					return this._name;
				}

				public void set_enabled(String _enabled) {
					this._enabled = _enabled;
				}

				public String get_enabled() {
					return this._enabled;
				}
			}
		}

		public static class LaunchSecurity {

			public LaunchSecurity() {

			}
		}

		public static class On_poweroff {

			private String text;

			public On_poweroff() {

			}

			public void setText(String text) {
				this.text = text;
			}

			public String getText() {
				return this.text;
			}
		}

		public static class Bootloader_args {

			private String text;

			public Bootloader_args() {

			}

			public void setText(String text) {
				this.text = text;
			}

			public String getText() {
				return this.text;
			}
		}

		public static class Os {

			private Init init;

			private Bios bios;

			private Kernel kernel;

			private Loader loader;

			private Initarg initarg;

			private Type type;

			private Initrd initrd;

			private Smbios smbios;

			private Cmdline cmdline;

			private Dtb dtb;

			private Nvram nvram;

			private Inituser inituser;

			private Acpi acpi;

			private Bootmenu bootmenu;

			private Initgroup initgroup;

			private ArrayList<Boot> boot;

			private Initdir initdir;

			private ArrayList<Initenv> initenv;

			public Os() {

			}

			public void setInit(Init init) {
				this.init = init;
			}

			public Init getInit() {
				return this.init;
			}

			public void setBios(Bios bios) {
				this.bios = bios;
			}

			public Bios getBios() {
				return this.bios;
			}

			public void setKernel(Kernel kernel) {
				this.kernel = kernel;
			}

			public Kernel getKernel() {
				return this.kernel;
			}

			public void setLoader(Loader loader) {
				this.loader = loader;
			}

			public Loader getLoader() {
				return this.loader;
			}

			public void setInitarg(Initarg initarg) {
				this.initarg = initarg;
			}

			public Initarg getInitarg() {
				return this.initarg;
			}

			public void setType(Type type) {
				this.type = type;
			}

			public Type getType() {
				return this.type;
			}

			public void setInitrd(Initrd initrd) {
				this.initrd = initrd;
			}

			public Initrd getInitrd() {
				return this.initrd;
			}

			public void setSmbios(Smbios smbios) {
				this.smbios = smbios;
			}

			public Smbios getSmbios() {
				return this.smbios;
			}

			public void setCmdline(Cmdline cmdline) {
				this.cmdline = cmdline;
			}

			public Cmdline getCmdline() {
				return this.cmdline;
			}

			public void setDtb(Dtb dtb) {
				this.dtb = dtb;
			}

			public Dtb getDtb() {
				return this.dtb;
			}

			public void setNvram(Nvram nvram) {
				this.nvram = nvram;
			}

			public Nvram getNvram() {
				return this.nvram;
			}

			public void setInituser(Inituser inituser) {
				this.inituser = inituser;
			}

			public Inituser getInituser() {
				return this.inituser;
			}

			public void setAcpi(Acpi acpi) {
				this.acpi = acpi;
			}

			public Acpi getAcpi() {
				return this.acpi;
			}

			public void setBootmenu(Bootmenu bootmenu) {
				this.bootmenu = bootmenu;
			}

			public Bootmenu getBootmenu() {
				return this.bootmenu;
			}

			public void setInitgroup(Initgroup initgroup) {
				this.initgroup = initgroup;
			}

			public Initgroup getInitgroup() {
				return this.initgroup;
			}

			public void setBoot(ArrayList<Boot> boot) {
				this.boot = boot;
			}

			public ArrayList<Boot> getBoot() {
				return this.boot;
			}

			public void setInitdir(Initdir initdir) {
				this.initdir = initdir;
			}

			public Initdir getInitdir() {
				return this.initdir;
			}

			public void setInitenv(ArrayList<Initenv> initenv) {
				this.initenv = initenv;
			}

			public ArrayList<Initenv> getInitenv() {
				return this.initenv;
			}

			public static class Init {

				private String text;

				public Init() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Bios {

				private String _rebootTimeout;

				private String _useserial;

				public Bios() {

				}

				public void set_rebootTimeout(String _rebootTimeout) {
					this._rebootTimeout = _rebootTimeout;
				}

				public String get_rebootTimeout() {
					return this._rebootTimeout;
				}

				public void set_useserial(String _useserial) {
					this._useserial = _useserial;
				}

				public String get_useserial() {
					return this._useserial;
				}
			}

			public static class Kernel {

				private String text;

				public Kernel() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Loader {

				private String text;

				public Loader() {
					this.text = "strin readonly='string' secure='string' type='string'>";

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Initarg {

				private String text;

				public Initarg() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Type {

				private String _machine;

				private String text;

				private String _arch;

				public Type() {

				}

				public void set_machine(String _machine) {
					this._machine = _machine;
				}

				public String get_machine() {
					return this._machine;
				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}

				public void set_arch(String _arch) {
					this._arch = _arch;
				}

				public String get_arch() {
					return this._arch;
				}
			}

			public static class Initrd {

				private String text;

				public Initrd() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Smbios {

				private String _mode;

				public Smbios() {

				}

				public void set_mode(String _mode) {
					this._mode = _mode;
				}

				public String get_mode() {
					return this._mode;
				}
			}

			public static class Cmdline {

				private String text;

				public Cmdline() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Dtb {

				private String text;

				public Dtb() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Nvram {

				private String text;

				public Nvram() {
					this.text = "strin template='string'>";

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Inituser {

				private String text;

				public Inituser() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Acpi {

				private ArrayList<Table> table;

				public Acpi() {

				}

				public void setTable(ArrayList<Table> table) {
					this.table = table;
				}

				public ArrayList<Table> getTable() {
					return this.table;
				}

				public static class Table {

					private String _type;

					private String text;

					public Table() {

					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}
			}

			public static class Bootmenu {

				private String _enable;

				private String _timeout;

				public Bootmenu() {

				}

				public void set_enable(String _enable) {
					this._enable = _enable;
				}

				public String get_enable() {
					return this._enable;
				}

				public void set_timeout(String _timeout) {
					this._timeout = _timeout;
				}

				public String get_timeout() {
					return this._timeout;
				}
			}

			public static class Initgroup {

				private String text;

				public Initgroup() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Boot {

				private String _dev;

				public Boot() {

				}

				public void set_dev(String _dev) {
					this._dev = _dev;
				}

				public String get_dev() {
					return this._dev;
				}
			}

			public static class Initdir {

				private String text;

				public Initdir() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Initenv {

				private String _name;

				private String text;

				public Initenv() {

				}

				public void set_name(String _name) {
					this._name = _name;
				}

				public String get_name() {
					return this._name;
				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}
		}

		public static class Devices {

			private ArrayList<Memory> memory;

			private ArrayList<Redirfilter> redirfilter;

			private ArrayList<Sound> sound;

			private ArrayList<Channel> channel;

			private Memballoon memballoon;

			private ArrayList<Graphics> graphics;

			private ArrayList<Video> video;

			private ArrayList<_interface> _interface;

			private Vsock vsock;

			private ArrayList<Hostdev> hostdev;

			private Nvram nvram;

			private Iommu iommu;

			private ArrayList<Parallel> parallel;

			private ArrayList<Console> console;

			private ArrayList<Controller> controller;

			private ArrayList<Shmem> shmem;

			private ArrayList<Redirdev> redirdev;

			private ArrayList<Rng> rng;

			private ArrayList<Smartcard> smartcard;

			private ArrayList<Filesystem> filesystem;

			private ArrayList<Panic> panic;

			private ArrayList<Tpm> tpm;

			private Emulator emulator;

			private ArrayList<Input> input;

			private ArrayList<Disk> disk;

			private Watchdog watchdog;

			private ArrayList<Hub> hub;

			private ArrayList<Serial> serial;

			private ArrayList<Lease> lease;

			public Devices() {

			}

			public void setMemory(ArrayList<Memory> memory) {
				this.memory = memory;
			}

			public ArrayList<Memory> getMemory() {
				return this.memory;
			}

			public void setRedirfilter(ArrayList<Redirfilter> redirfilter) {
				this.redirfilter = redirfilter;
			}

			public ArrayList<Redirfilter> getRedirfilter() {
				return this.redirfilter;
			}

			public void setSound(ArrayList<Sound> sound) {
				this.sound = sound;
			}

			public ArrayList<Sound> getSound() {
				return this.sound;
			}

			public void setChannel(ArrayList<Channel> channel) {
				this.channel = channel;
			}

			public ArrayList<Channel> getChannel() {
				return this.channel;
			}

			public void setMemballoon(Memballoon memballoon) {
				this.memballoon = memballoon;
			}

			public Memballoon getMemballoon() {
				return this.memballoon;
			}

			public void setGraphics(ArrayList<Graphics> graphics) {
				this.graphics = graphics;
			}

			public ArrayList<Graphics> getGraphics() {
				return this.graphics;
			}

			public void setVideo(ArrayList<Video> video) {
				this.video = video;
			}

			public ArrayList<Video> getVideo() {
				return this.video;
			}

			public void set_interface(ArrayList<_interface> _interface) {
				this._interface = _interface;
			}

			public ArrayList<_interface> get_interface() {
				return this._interface;
			}

			public void setVsock(Vsock vsock) {
				this.vsock = vsock;
			}

			public Vsock getVsock() {
				return this.vsock;
			}

			public void setHostdev(ArrayList<Hostdev> hostdev) {
				this.hostdev = hostdev;
			}

			public ArrayList<Hostdev> getHostdev() {
				return this.hostdev;
			}

			public void setNvram(Nvram nvram) {
				this.nvram = nvram;
			}

			public Nvram getNvram() {
				return this.nvram;
			}

			public void setIommu(Iommu iommu) {
				this.iommu = iommu;
			}

			public Iommu getIommu() {
				return this.iommu;
			}

			public void setParallel(ArrayList<Parallel> parallel) {
				this.parallel = parallel;
			}

			public ArrayList<Parallel> getParallel() {
				return this.parallel;
			}

			public void setConsole(ArrayList<Console> console) {
				this.console = console;
			}

			public ArrayList<Console> getConsole() {
				return this.console;
			}

			public void setController(ArrayList<Controller> controller) {
				this.controller = controller;
			}

			public ArrayList<Controller> getController() {
				return this.controller;
			}

			public void setShmem(ArrayList<Shmem> shmem) {
				this.shmem = shmem;
			}

			public ArrayList<Shmem> getShmem() {
				return this.shmem;
			}

			public void setRedirdev(ArrayList<Redirdev> redirdev) {
				this.redirdev = redirdev;
			}

			public ArrayList<Redirdev> getRedirdev() {
				return this.redirdev;
			}

			public void setRng(ArrayList<Rng> rng) {
				this.rng = rng;
			}

			public ArrayList<Rng> getRng() {
				return this.rng;
			}

			public void setSmartcard(ArrayList<Smartcard> smartcard) {
				this.smartcard = smartcard;
			}

			public ArrayList<Smartcard> getSmartcard() {
				return this.smartcard;
			}

			public void setFilesystem(ArrayList<Filesystem> filesystem) {
				this.filesystem = filesystem;
			}

			public ArrayList<Filesystem> getFilesystem() {
				return this.filesystem;
			}

			public void setPanic(ArrayList<Panic> panic) {
				this.panic = panic;
			}

			public ArrayList<Panic> getPanic() {
				return this.panic;
			}

			public void setTpm(ArrayList<Tpm> tpm) {
				this.tpm = tpm;
			}

			public ArrayList<Tpm> getTpm() {
				return this.tpm;
			}

			public void setEmulator(Emulator emulator) {
				this.emulator = emulator;
			}

			public Emulator getEmulator() {
				return this.emulator;
			}

			public void setInput(ArrayList<Input> input) {
				this.input = input;
			}

			public ArrayList<Input> getInput() {
				return this.input;
			}

			public void setDisk(ArrayList<Disk> disk) {
				this.disk = disk;
			}

			public ArrayList<Disk> getDisk() {
				return this.disk;
			}

			public void setWatchdog(Watchdog watchdog) {
				this.watchdog = watchdog;
			}

			public Watchdog getWatchdog() {
				return this.watchdog;
			}

			public void setHub(ArrayList<Hub> hub) {
				this.hub = hub;
			}

			public ArrayList<Hub> getHub() {
				return this.hub;
			}

			public void setSerial(ArrayList<Serial> serial) {
				this.serial = serial;
			}

			public ArrayList<Serial> getSerial() {
				return this.serial;
			}

			public void setLease(ArrayList<Lease> lease) {
				this.lease = lease;
			}

			public ArrayList<Lease> getLease() {
				return this.lease;
			}

			public static class Memory {

				private String _discard;

				private Address address;

				private String _access;

				private Alias alias;

				private String _model;

				private Source source;

				private Target target;

				public Memory() {

				}

				public void set_discard(String _discard) {
					this._discard = _discard;
				}

				public String get_discard() {
					return this._discard;
				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void set_access(String _access) {
					this._access = _access;
				}

				public String get_access() {
					return this._access;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(String _model) {
					this._model = _model;
				}

				public String get_model() {
					return this._model;
				}

				public void setSource(Source source) {
					this.source = source;
				}

				public Source getSource() {
					return this.source;
				}

				public void setTarget(Target target) {
					this.target = target;
				}

				public Target getTarget() {
					return this.target;
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}

				public static class Source {

					private Path path;

					private Pmem pmem;

					private Alignsize alignsize;

					private Nodemask nodemask;

					private Pagesize pagesize;

					public Source() {

					}

					public void setPath(Path path) {
						this.path = path;
					}

					public Path getPath() {
						return this.path;
					}

					public void setPmem(Pmem pmem) {
						this.pmem = pmem;
					}

					public Pmem getPmem() {
						return this.pmem;
					}

					public void setAlignsize(Alignsize alignsize) {
						this.alignsize = alignsize;
					}

					public Alignsize getAlignsize() {
						return this.alignsize;
					}

					public void setNodemask(Nodemask nodemask) {
						this.nodemask = nodemask;
					}

					public Nodemask getNodemask() {
						return this.nodemask;
					}

					public void setPagesize(Pagesize pagesize) {
						this.pagesize = pagesize;
					}

					public Pagesize getPagesize() {
						return this.pagesize;
					}

					public static class Path {

						private String text;

						public Path() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Pmem {

						public Pmem() {

						}
					}

					public static class Alignsize {

						private String _unit;

						private String text;

						public Alignsize() {

						}

						public void set_unit(String _unit) {
							this._unit = _unit;
						}

						public String get_unit() {
							return this._unit;
						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Nodemask {

						private String text;

						public Nodemask() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Pagesize {

						private String _unit;

						private String text;

						public Pagesize() {

						}

						public void set_unit(String _unit) {
							this._unit = _unit;
						}

						public String get_unit() {
							return this._unit;
						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}
				}

				public static class Target {

					private Node node;

					private Readonly readonly;

					private Size size;

					private Label label;

					public Target() {

					}

					public void setNode(Node node) {
						this.node = node;
					}

					public Node getNode() {
						return this.node;
					}

					public void setReadonly(Readonly readonly) {
						this.readonly = readonly;
					}

					public Readonly getReadonly() {
						return this.readonly;
					}

					public void setSize(Size size) {
						this.size = size;
					}

					public Size getSize() {
						return this.size;
					}

					public void setLabel(Label label) {
						this.label = label;
					}

					public Label getLabel() {
						return this.label;
					}

					public static class Node {

						private String text;

						public Node() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Readonly {

						public Readonly() {

						}
					}

					public static class Size {

						private String _unit;

						private String text;

						public Size() {

						}

						public void set_unit(String _unit) {
							this._unit = _unit;
						}

						public String get_unit() {
							return this._unit;
						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Label {

						private Size size;

						public Label() {

						}

						public void setSize(Size size) {
							this.size = size;
						}

						public Size getSize() {
							return this.size;
						}

						public static class Size {

							private String _unit;

							private String text;

							public Size() {

							}

							public void set_unit(String _unit) {
								this._unit = _unit;
							}

							public String get_unit() {
								return this._unit;
							}

							public void setText(String text) {
								this.text = text;
							}

							public String getText() {
								return this.text;
							}
						}
					}
				}
			}

			public static class Redirfilter {

				private ArrayList<Usbdev> usbdev;

				public Redirfilter() {

				}

				public void setUsbdev(ArrayList<Usbdev> usbdev) {
					this.usbdev = usbdev;
				}

				public ArrayList<Usbdev> getUsbdev() {
					return this.usbdev;
				}

				public static class Usbdev {

					private String _vendor;

					private String _class;

					private String _allow;

					private String _product;

					private String _version;

					public Usbdev() {

					}

					public void set_vendor(String _vendor) {
						this._vendor = _vendor;
					}

					public String get_vendor() {
						return this._vendor;
					}

					public void set_class(String _class) {
						this._class = _class;
					}

					public String get_class() {
						return this._class;
					}

					public void set_allow(String _allow) {
						this._allow = _allow;
					}

					public String get_allow() {
						return this._allow;
					}

					public void set_product(String _product) {
						this._product = _product;
					}

					public String get_product() {
						return this._product;
					}

					public void set_version(String _version) {
						this._version = _version;
					}

					public String get_version() {
						return this._version;
					}
				}
			}

			public static class Sound {

				private ArrayList<Codec> codec;

				private Address address;

				private Alias alias;

				private String _model;

				public Sound() {

				}

				public void setCodec(ArrayList<Codec> codec) {
					this.codec = codec;
				}

				public ArrayList<Codec> getCodec() {
					return this.codec;
				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(String _model) {
					this._model = _model;
				}

				public String get_model() {
					return this._model;
				}

				public static class Codec {

					private String _type;

					public Codec() {

					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}
			}

			public static class Channel {

				private Protocol protocol;

				private Address address;

				private Log log;

				private Alias alias;

				private Source source;

				private Target target;

				public Channel() {

				}

				public void setProtocol(Protocol protocol) {
					this.protocol = protocol;
				}

				public Protocol getProtocol() {
					return this.protocol;
				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void setLog(Log log) {
					this.log = log;
				}

				public Log getLog() {
					return this.log;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void setSource(Source source) {
					this.source = source;
				}

				public Source getSource() {
					return this.source;
				}

				public void setTarget(Target target) {
					this.target = target;
				}

				public Target getTarget() {
					return this.target;
				}

				public static class Protocol {

					private String _type;

					public Protocol() {

					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Log {

					private String _file;

					private String _append;

					public Log() {

					}

					public void set_file(String _file) {
						this._file = _file;
					}

					public String get_file() {
						return this._file;
					}

					public void set_append(String _append) {
						this._append = _append;
					}

					public String get_append() {
						return this._append;
					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}

				public static class Source {

					public Source() {

					}
				}

				public static class Target {

					public Target() {

					}
				}
			}

			public static class Memballoon {

				private Address address;

				private Driver driver;

				private Stats stats;

				private Alias alias;

				private String _model;

				private String _autodeflate;

				public Memballoon() {

				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void setDriver(Driver driver) {
					this.driver = driver;
				}

				public Driver getDriver() {
					return this.driver;
				}

				public void setStats(Stats stats) {
					this.stats = stats;
				}

				public Stats getStats() {
					return this.stats;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(String _model) {
					this._model = _model;
				}

				public String get_model() {
					return this._model;
				}

				public void set_autodeflate(String _autodeflate) {
					this._autodeflate = _autodeflate;
				}

				public String get_autodeflate() {
					return this._autodeflate;
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Driver {

					private String _iommu;

					private String _ats;

					public Driver() {

					}

					public void set_iommu(String _iommu) {
						this._iommu = _iommu;
					}

					public String get_iommu() {
						return this._iommu;
					}

					public void set_ats(String _ats) {
						this._ats = _ats;
					}

					public String get_ats() {
						return this._ats;
					}
				}

				public static class Stats {

					private String _period;

					public Stats() {

					}

					public void set_period(String _period) {
						this._period = _period;
					}

					public String get_period() {
						return this._period;
					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}
			}

			public static class Graphics {

				public Graphics() {

				}
			}

			public static class Video {

				private Address address;

				private Driver driver;

				private Alias alias;

				private Model model;

				public Video() {

				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void setDriver(Driver driver) {
					this.driver = driver;
				}

				public Driver getDriver() {
					return this.driver;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void setModel(Model model) {
					this.model = model;
				}

				public Model getModel() {
					return this.model;
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Driver {

					private String _vgaconf;

					private String _iommu;

					private String _ats;

					public Driver() {

					}

					public void set_vgaconf(String _vgaconf) {
						this._vgaconf = _vgaconf;
					}

					public String get_vgaconf() {
						return this._vgaconf;
					}

					public void set_iommu(String _iommu) {
						this._iommu = _iommu;
					}

					public String get_iommu() {
						return this._iommu;
					}

					public void set_ats(String _ats) {
						this._ats = _ats;
					}

					public String get_ats() {
						return this._ats;
					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}

				public static class Model {

					private String _heads;

					private String _vgamem;

					private Acceleration acceleration;

					private String _ram;

					private String _vram;

					private String _vram64;

					private String _type;

					private String _primary;

					public Model() {

					}

					public void set_heads(String _heads) {
						this._heads = _heads;
					}

					public String get_heads() {
						return this._heads;
					}

					public void set_vgamem(String _vgamem) {
						this._vgamem = _vgamem;
					}

					public String get_vgamem() {
						return this._vgamem;
					}

					public void setAcceleration(Acceleration acceleration) {
						this.acceleration = acceleration;
					}

					public Acceleration getAcceleration() {
						return this.acceleration;
					}

					public void set_ram(String _ram) {
						this._ram = _ram;
					}

					public String get_ram() {
						return this._ram;
					}

					public void set_vram(String _vram) {
						this._vram = _vram;
					}

					public String get_vram() {
						return this._vram;
					}

					public void set_vram64(String _vram64) {
						this._vram64 = _vram64;
					}

					public String get_vram64() {
						return this._vram64;
					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}

					public void set_primary(String _primary) {
						this._primary = _primary;
					}

					public String get_primary() {
						return this._primary;
					}

					public static class Acceleration {

						private String _accel3d;

						private String _accel2d;

						public Acceleration() {

						}

						public void set_accel3d(String _accel3d) {
							this._accel3d = _accel3d;
						}

						public String get_accel3d() {
							return this._accel3d;
						}

						public void set_accel2d(String _accel2d) {
							this._accel2d = _accel2d;
						}

						public String get_accel2d() {
							return this._accel2d;
						}
					}
				}
			}

			public static class _interface {

				private Address address;

				private Bandwidth bandwidth;

				private ArrayList<Ip> ip;

				private Coalesce coalesce;

				private Link link;

				private Source source;

				private Filterref filterref;

				private Mac mac;

				private Script script;

				private Tune tune;

				private Mtu mtu;

				private Target target;

				private Rom rom;

				private ArrayList<Route> route;

				private Driver driver;

				private Vlan vlan;

				private String _managed;

				private String _trustGuestRxFilters;

				private Alias alias;

				private Backend backend;

				private Guest guest;

				private Model model;

				private Boot boot;

				private Virtualport virtualport;

				public _interface() {

				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void setBandwidth(Bandwidth bandwidth) {
					this.bandwidth = bandwidth;
				}

				public Bandwidth getBandwidth() {
					return this.bandwidth;
				}

				public void setIp(ArrayList<Ip> ip) {
					this.ip = ip;
				}

				public ArrayList<Ip> getIp() {
					return this.ip;
				}

				public void setCoalesce(Coalesce coalesce) {
					this.coalesce = coalesce;
				}

				public Coalesce getCoalesce() {
					return this.coalesce;
				}

				public void setLink(Link link) {
					this.link = link;
				}

				public Link getLink() {
					return this.link;
				}

				public void setSource(Source source) {
					this.source = source;
				}

				public Source getSource() {
					return this.source;
				}

				public void setFilterref(Filterref filterref) {
					this.filterref = filterref;
				}

				public Filterref getFilterref() {
					return this.filterref;
				}

				public void setMac(Mac mac) {
					this.mac = mac;
				}

				public Mac getMac() {
					return this.mac;
				}

				public void setScript(Script script) {
					this.script = script;
				}

				public Script getScript() {
					return this.script;
				}

				public void setTune(Tune tune) {
					this.tune = tune;
				}

				public Tune getTune() {
					return this.tune;
				}

				public void setMtu(Mtu mtu) {
					this.mtu = mtu;
				}

				public Mtu getMtu() {
					return this.mtu;
				}

				public void setTarget(Target target) {
					this.target = target;
				}

				public Target getTarget() {
					return this.target;
				}

				public void setRom(Rom rom) {
					this.rom = rom;
				}

				public Rom getRom() {
					return this.rom;
				}

				public void setRoute(ArrayList<Route> route) {
					this.route = route;
				}

				public ArrayList<Route> getRoute() {
					return this.route;
				}

				public void setDriver(Driver driver) {
					this.driver = driver;
				}

				public Driver getDriver() {
					return this.driver;
				}

				public void setVlan(Vlan vlan) {
					this.vlan = vlan;
				}

				public Vlan getVlan() {
					return this.vlan;
				}

				public void set_managed(String _managed) {
					this._managed = _managed;
				}

				public String get_managed() {
					return this._managed;
				}

				public void set_trustGuestRxFilters(String _trustGuestRxFilters) {
					this._trustGuestRxFilters = _trustGuestRxFilters;
				}

				public String get_trustGuestRxFilters() {
					return this._trustGuestRxFilters;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void setBackend(Backend backend) {
					this.backend = backend;
				}

				public Backend getBackend() {
					return this.backend;
				}

				public void setGuest(Guest guest) {
					this.guest = guest;
				}

				public Guest getGuest() {
					return this.guest;
				}

				public void setModel(Model model) {
					this.model = model;
				}

				public Model getModel() {
					return this.model;
				}

				public void setBoot(Boot boot) {
					this.boot = boot;
				}

				public Boot getBoot() {
					return this.boot;
				}

				public void setVirtualport(Virtualport virtualport) {
					this.virtualport = virtualport;
				}

				public Virtualport getVirtualport() {
					return this.virtualport;
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Bandwidth {

					private Inbound inbound;

					private Outbound outbound;

					public Bandwidth() {

					}

					public void setInbound(Inbound inbound) {
						this.inbound = inbound;
					}

					public Inbound getInbound() {
						return this.inbound;
					}

					public void setOutbound(Outbound outbound) {
						this.outbound = outbound;
					}

					public Outbound getOutbound() {
						return this.outbound;
					}

					public static class Inbound {

						private String _floor;

						private String _peak;

						private String _average;

						private String _burst;

						public Inbound() {

						}

						public void set_floor(String _floor) {
							this._floor = _floor;
						}

						public String get_floor() {
							return this._floor;
						}

						public void set_peak(String _peak) {
							this._peak = _peak;
						}

						public String get_peak() {
							return this._peak;
						}

						public void set_average(String _average) {
							this._average = _average;
						}

						public String get_average() {
							return this._average;
						}

						public void set_burst(String _burst) {
							this._burst = _burst;
						}

						public String get_burst() {
							return this._burst;
						}
					}

					public static class Outbound {

						private String _floor;

						private String _peak;

						private String _average;

						private String _burst;

						public Outbound() {

						}

						public void set_floor(String _floor) {
							this._floor = _floor;
						}

						public String get_floor() {
							return this._floor;
						}

						public void set_peak(String _peak) {
							this._peak = _peak;
						}

						public String get_peak() {
							return this._peak;
						}

						public void set_average(String _average) {
							this._average = _average;
						}

						public String get_average() {
							return this._average;
						}

						public void set_burst(String _burst) {
							this._burst = _burst;
						}

						public String get_burst() {
							return this._burst;
						}
					}
				}

				public static class Ip {

					private String _address;

					private String _prefix;

					private String _family;

					private String _peer;

					public Ip() {

					}

					public void set_address(String _address) {
						this._address = _address;
					}

					public String get_address() {
						return this._address;
					}

					public void set_prefix(String _prefix) {
						this._prefix = _prefix;
					}

					public String get_prefix() {
						return this._prefix;
					}

					public void set_family(String _family) {
						this._family = _family;
					}

					public String get_family() {
						return this._family;
					}

					public void set_peer(String _peer) {
						this._peer = _peer;
					}

					public String get_peer() {
						return this._peer;
					}
				}

				public static class Coalesce {

					private Rx rx;

					public Coalesce() {

					}

					public void setRx(Rx rx) {
						this.rx = rx;
					}

					public Rx getRx() {
						return this.rx;
					}

					public static class Rx {

						private Frames frames;

						public Rx() {

						}

						public void setFrames(Frames frames) {
							this.frames = frames;
						}

						public Frames getFrames() {
							return this.frames;
						}

						public static class Frames {

							private String _max;

							public Frames() {

							}

							public void set_max(String _max) {
								this._max = _max;
							}

							public String get_max() {
								return this._max;
							}
						}
					}
				}

				public static class Link {

					private String _state;

					public Link() {

					}

					public void set_state(String _state) {
						this._state = _state;
					}

					public String get_state() {
						return this._state;
					}
				}

				public static class Source {

					public Source() {

					}
				}

				public static class Filterref {

					private ArrayList<Parameter> parameter;

					private String _filter;

					public Filterref() {

					}

					public void setParameter(ArrayList<Parameter> parameter) {
						this.parameter = parameter;
					}

					public ArrayList<Parameter> getParameter() {
						return this.parameter;
					}

					public void set_filter(String _filter) {
						this._filter = _filter;
					}

					public String get_filter() {
						return this._filter;
					}

					public static class Parameter {

						private String _name;

						private String _value;

						public Parameter() {

						}

						public void set_name(String _name) {
							this._name = _name;
						}

						public String get_name() {
							return this._name;
						}

						public void set_value(String _value) {
							this._value = _value;
						}

						public String get_value() {
							return this._value;
						}
					}
				}

				public static class Mac {

					private String _address;

					public Mac() {

					}

					public void set_address(String _address) {
						this._address = _address;
					}

					public String get_address() {
						return this._address;
					}
				}

				public static class Script {

					private String _path;

					public Script() {

					}

					public void set_path(String _path) {
						this._path = _path;
					}

					public String get_path() {
						return this._path;
					}
				}

				public static class Tune {

					private Sndbuf sndbuf;

					public Tune() {

					}

					public void setSndbuf(Sndbuf sndbuf) {
						this.sndbuf = sndbuf;
					}

					public Sndbuf getSndbuf() {
						return this.sndbuf;
					}

					public static class Sndbuf {

						private String text;

						public Sndbuf() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}
				}

				public static class Mtu {

					private String _size;

					public Mtu() {

					}

					public void set_size(String _size) {
						this._size = _size;
					}

					public String get_size() {
						return this._size;
					}
				}

				public static class Target {

					private String _dev;

					public Target() {

					}

					public void set_dev(String _dev) {
						this._dev = _dev;
					}

					public String get_dev() {
						return this._dev;
					}
				}

				public static class Rom {

					private String _file;

					private String _bar;

					private String _enabled;

					public Rom() {

					}

					public void set_file(String _file) {
						this._file = _file;
					}

					public String get_file() {
						return this._file;
					}

					public void set_bar(String _bar) {
						this._bar = _bar;
					}

					public String get_bar() {
						return this._bar;
					}

					public void set_enabled(String _enabled) {
						this._enabled = _enabled;
					}

					public String get_enabled() {
						return this._enabled;
					}
				}

				public static class Route {

					private String _address;

					private String _prefix;

					private String _netmask;

					private String _metric;

					private String _family;

					private String _gateway;

					public Route() {

					}

					public void set_address(String _address) {
						this._address = _address;
					}

					public String get_address() {
						return this._address;
					}

					public void set_prefix(String _prefix) {
						this._prefix = _prefix;
					}

					public String get_prefix() {
						return this._prefix;
					}

					public void set_netmask(String _netmask) {
						this._netmask = _netmask;
					}

					public String get_netmask() {
						return this._netmask;
					}

					public void set_metric(String _metric) {
						this._metric = _metric;
					}

					public String get_metric() {
						return this._metric;
					}

					public void set_family(String _family) {
						this._family = _family;
					}

					public String get_family() {
						return this._family;
					}

					public void set_gateway(String _gateway) {
						this._gateway = _gateway;
					}

					public String get_gateway() {
						return this._gateway;
					}
				}

				public static class Driver {

					private String _name;

					private String _queues;

					private String _txmode;

					private String _tx_queue_size;

					private String _iommu;

					private Host host;

					private String _ioeventfd;

					private Guest guest;

					private String _event_idx;

					private String _ats;

					private String _rx_queue_size;

					public Driver() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}

					public void set_queues(String _queues) {
						this._queues = _queues;
					}

					public String get_queues() {
						return this._queues;
					}

					public void set_txmode(String _txmode) {
						this._txmode = _txmode;
					}

					public String get_txmode() {
						return this._txmode;
					}

					public void set_tx_queue_size(String _tx_queue_size) {
						this._tx_queue_size = _tx_queue_size;
					}

					public String get_tx_queue_size() {
						return this._tx_queue_size;
					}

					public void set_iommu(String _iommu) {
						this._iommu = _iommu;
					}

					public String get_iommu() {
						return this._iommu;
					}

					public void setHost(Host host) {
						this.host = host;
					}

					public Host getHost() {
						return this.host;
					}

					public void set_ioeventfd(String _ioeventfd) {
						this._ioeventfd = _ioeventfd;
					}

					public String get_ioeventfd() {
						return this._ioeventfd;
					}

					public void setGuest(Guest guest) {
						this.guest = guest;
					}

					public Guest getGuest() {
						return this.guest;
					}

					public void set_event_idx(String _event_idx) {
						this._event_idx = _event_idx;
					}

					public String get_event_idx() {
						return this._event_idx;
					}

					public void set_ats(String _ats) {
						this._ats = _ats;
					}

					public String get_ats() {
						return this._ats;
					}

					public void set_rx_queue_size(String _rx_queue_size) {
						this._rx_queue_size = _rx_queue_size;
					}

					public String get_rx_queue_size() {
						return this._rx_queue_size;
					}

					public static class Host {

						private String _tso4;

						private String _ufo;

						private String _tso6;

						private String _mrg_rxbuf;

						private String _gso;

						private String _ecn;

						private String _csum;

						public Host() {

						}

						public void set_tso4(String _tso4) {
							this._tso4 = _tso4;
						}

						public String get_tso4() {
							return this._tso4;
						}

						public void set_ufo(String _ufo) {
							this._ufo = _ufo;
						}

						public String get_ufo() {
							return this._ufo;
						}

						public void set_tso6(String _tso6) {
							this._tso6 = _tso6;
						}

						public String get_tso6() {
							return this._tso6;
						}

						public void set_mrg_rxbuf(String _mrg_rxbuf) {
							this._mrg_rxbuf = _mrg_rxbuf;
						}

						public String get_mrg_rxbuf() {
							return this._mrg_rxbuf;
						}

						public void set_gso(String _gso) {
							this._gso = _gso;
						}

						public String get_gso() {
							return this._gso;
						}

						public void set_ecn(String _ecn) {
							this._ecn = _ecn;
						}

						public String get_ecn() {
							return this._ecn;
						}

						public void set_csum(String _csum) {
							this._csum = _csum;
						}

						public String get_csum() {
							return this._csum;
						}
					}

					public static class Guest {

						private String _tso4;

						private String _ufo;

						private String _tso6;

						private String _ecn;

						private String _csum;

						public Guest() {

						}

						public void set_tso4(String _tso4) {
							this._tso4 = _tso4;
						}

						public String get_tso4() {
							return this._tso4;
						}

						public void set_ufo(String _ufo) {
							this._ufo = _ufo;
						}

						public String get_ufo() {
							return this._ufo;
						}

						public void set_tso6(String _tso6) {
							this._tso6 = _tso6;
						}

						public String get_tso6() {
							return this._tso6;
						}

						public void set_ecn(String _ecn) {
							this._ecn = _ecn;
						}

						public String get_ecn() {
							return this._ecn;
						}

						public void set_csum(String _csum) {
							this._csum = _csum;
						}

						public String get_csum() {
							return this._csum;
						}
					}
				}

				public static class Vlan {

					private String _trunk;

					private ArrayList<Tag> tag;

					public Vlan() {

					}

					public void set_trunk(String _trunk) {
						this._trunk = _trunk;
					}

					public String get_trunk() {
						return this._trunk;
					}

					public void setTag(ArrayList<Tag> tag) {
						this.tag = tag;
					}

					public ArrayList<Tag> getTag() {
						return this.tag;
					}

					public static class Tag {

						private String _nativeMode;

						private String _id;

						public Tag() {

						}

						public void set_nativeMode(String _nativeMode) {
							this._nativeMode = _nativeMode;
						}

						public String get_nativeMode() {
							return this._nativeMode;
						}

						public void set_id(String _id) {
							this._id = _id;
						}

						public String get_id() {
							return this._id;
						}
					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}

				public static class Backend {

					private String _vhost;

					private String _tap;

					public Backend() {

					}

					public void set_vhost(String _vhost) {
						this._vhost = _vhost;
					}

					public String get_vhost() {
						return this._vhost;
					}

					public void set_tap(String _tap) {
						this._tap = _tap;
					}

					public String get_tap() {
						return this._tap;
					}
				}

				public static class Guest {

					private String _actual;

					private String _dev;

					public Guest() {

					}

					public void set_actual(String _actual) {
						this._actual = _actual;
					}

					public String get_actual() {
						return this._actual;
					}

					public void set_dev(String _dev) {
						this._dev = _dev;
					}

					public String get_dev() {
						return this._dev;
					}
				}

				public static class Model {

					private String _type;

					public Model() {

					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}
				}

				public static class Boot {

					private String _loadparm;

					private String _order;

					public Boot() {

					}

					public void set_loadparm(String _loadparm) {
						this._loadparm = _loadparm;
					}

					public String get_loadparm() {
						return this._loadparm;
					}

					public void set_order(String _order) {
						this._order = _order;
					}

					public String get_order() {
						return this._order;
					}
				}

				public static class Virtualport {

					private Parameters parameters;

					public Virtualport() {

					}

					public void setParameters(Parameters parameters) {
						this.parameters = parameters;
					}

					public Parameters getParameters() {
						return this.parameters;
					}

					public static class Parameters {

						public Parameters() {

						}
					}
				}
			}

			public static class Vsock {

				private Address address;

				private Alias alias;

				private String _model;

				private Cid cid;

				public Vsock() {

				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(String _model) {
					this._model = _model;
				}

				public String get_model() {
					return this._model;
				}

				public void setCid(Cid cid) {
					this.cid = cid;
				}

				public Cid getCid() {
					return this.cid;
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}

				public static class Cid {

					private String _address;

					private String _auto;

					public Cid() {

					}

					public void set_address(String _address) {
						this._address = _address;
					}

					public String get_address() {
						return this._address;
					}

					public void set_auto(String _auto) {
						this._auto = _auto;
					}

					public String get_auto() {
						return this._auto;
					}
				}
			}

			public static class Hostdev {

				private Rom rom;

				private Address address;

				private String _managed;

				private Alias alias;

				private Boot boot;

				public Hostdev() {

				}

				public void setRom(Rom rom) {
					this.rom = rom;
				}

				public Rom getRom() {
					return this.rom;
				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void set_managed(String _managed) {
					this._managed = _managed;
				}

				public String get_managed() {
					return this._managed;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void setBoot(Boot boot) {
					this.boot = boot;
				}

				public Boot getBoot() {
					return this.boot;
				}

				public static class Rom {

					private String _file;

					private String _bar;

					private String _enabled;

					public Rom() {

					}

					public void set_file(String _file) {
						this._file = _file;
					}

					public String get_file() {
						return this._file;
					}

					public void set_bar(String _bar) {
						this._bar = _bar;
					}

					public String get_bar() {
						return this._bar;
					}

					public void set_enabled(String _enabled) {
						this._enabled = _enabled;
					}

					public String get_enabled() {
						return this._enabled;
					}
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}

				public static class Boot {

					private String _loadparm;

					private String _order;

					public Boot() {

					}

					public void set_loadparm(String _loadparm) {
						this._loadparm = _loadparm;
					}

					public String get_loadparm() {
						return this._loadparm;
					}

					public void set_order(String _order) {
						this._order = _order;
					}

					public String get_order() {
						return this._order;
					}
				}
			}

			public static class Nvram {

				private Address address;

				private Alias alias;

				public Nvram() {

				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}
			}

			public static class Iommu {

				private Driver driver;

				private String _model;

				public Iommu() {

				}

				public void setDriver(Driver driver) {
					this.driver = driver;
				}

				public Driver getDriver() {
					return this.driver;
				}

				public void set_model(String _model) {
					this._model = _model;
				}

				public String get_model() {
					return this._model;
				}

				public static class Driver {

					private String _caching_mode;

					private String _eim;

					private String _iotlb;

					private String _intremap;

					public Driver() {

					}

					public void set_caching_mode(String _caching_mode) {
						this._caching_mode = _caching_mode;
					}

					public String get_caching_mode() {
						return this._caching_mode;
					}

					public void set_eim(String _eim) {
						this._eim = _eim;
					}

					public String get_eim() {
						return this._eim;
					}

					public void set_iotlb(String _iotlb) {
						this._iotlb = _iotlb;
					}

					public String get_iotlb() {
						return this._iotlb;
					}

					public void set_intremap(String _intremap) {
						this._intremap = _intremap;
					}

					public String get_intremap() {
						return this._intremap;
					}
				}
			}

			public static class Parallel {

				private Protocol protocol;

				private Address address;

				private Log log;

				private Alias alias;

				private Source source;

				private Target target;

				public Parallel() {

				}

				public void setProtocol(Protocol protocol) {
					this.protocol = protocol;
				}

				public Protocol getProtocol() {
					return this.protocol;
				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void setLog(Log log) {
					this.log = log;
				}

				public Log getLog() {
					return this.log;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void setSource(Source source) {
					this.source = source;
				}

				public Source getSource() {
					return this.source;
				}

				public void setTarget(Target target) {
					this.target = target;
				}

				public Target getTarget() {
					return this.target;
				}

				public static class Protocol {

					private String _type;

					public Protocol() {

					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Log {

					private String _file;

					private String _append;

					public Log() {

					}

					public void set_file(String _file) {
						this._file = _file;
					}

					public String get_file() {
						return this._file;
					}

					public void set_append(String _append) {
						this._append = _append;
					}

					public String get_append() {
						return this._append;
					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}

				public static class Source {

					public Source() {

					}
				}

				public static class Target {

					private String _type;

					private String _port;

					public Target() {

					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}

					public void set_port(String _port) {
						this._port = _port;
					}

					public String get_port() {
						return this._port;
					}
				}
			}

			public static class Console {

				private Protocol protocol;

				private Address address;

				private Log log;

				private String _tty;

				private Alias alias;

				private Source source;

				private Target target;

				public Console() {

				}

				public void setProtocol(Protocol protocol) {
					this.protocol = protocol;
				}

				public Protocol getProtocol() {
					return this.protocol;
				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void setLog(Log log) {
					this.log = log;
				}

				public Log getLog() {
					return this.log;
				}

				public void set_tty(String _tty) {
					this._tty = _tty;
				}

				public String get_tty() {
					return this._tty;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void setSource(Source source) {
					this.source = source;
				}

				public Source getSource() {
					return this.source;
				}

				public void setTarget(Target target) {
					this.target = target;
				}

				public Target getTarget() {
					return this.target;
				}

				public static class Protocol {

					private String _type;

					public Protocol() {

					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Log {

					private String _file;

					private String _append;

					public Log() {

					}

					public void set_file(String _file) {
						this._file = _file;
					}

					public String get_file() {
						return this._file;
					}

					public void set_append(String _append) {
						this._append = _append;
					}

					public String get_append() {
						return this._append;
					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}

				public static class Source {

					public Source() {

					}
				}

				public static class Target {

					private String _type;

					private String _port;

					public Target() {

					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}

					public void set_port(String _port) {
						this._port = _port;
					}

					public String get_port() {
						return this._port;
					}
				}
			}

			public static class Controller {

				private Address address;

				private String _index;

				private Driver driver;

				private String _type;

				private Alias alias;

				private String _model;

				public Controller() {

				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void set_index(String _index) {
					this._index = _index;
				}

				public String get_index() {
					return this._index;
				}

				public void setDriver(Driver driver) {
					this.driver = driver;
				}

				public Driver getDriver() {
					return this.driver;
				}

				public void set_type(String _type) {
					this._type = _type;
				}

				public String get_type() {
					return this._type;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(String _model) {
					this._model = _model;
				}

				public String get_model() {
					return this._model;
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Driver {

					private String _max_sectors;

					private String _queues;

					private String _iommu;

					private String _ioeventfd;

					private String _iothread;

					private String _cmd_per_lun;

					private String _ats;

					public Driver() {

					}

					public void set_max_sectors(String _max_sectors) {
						this._max_sectors = _max_sectors;
					}

					public String get_max_sectors() {
						return this._max_sectors;
					}

					public void set_queues(String _queues) {
						this._queues = _queues;
					}

					public String get_queues() {
						return this._queues;
					}

					public void set_iommu(String _iommu) {
						this._iommu = _iommu;
					}

					public String get_iommu() {
						return this._iommu;
					}

					public void set_ioeventfd(String _ioeventfd) {
						this._ioeventfd = _ioeventfd;
					}

					public String get_ioeventfd() {
						return this._ioeventfd;
					}

					public void set_iothread(String _iothread) {
						this._iothread = _iothread;
					}

					public String get_iothread() {
						return this._iothread;
					}

					public void set_cmd_per_lun(String _cmd_per_lun) {
						this._cmd_per_lun = _cmd_per_lun;
					}

					public String get_cmd_per_lun() {
						return this._cmd_per_lun;
					}

					public void set_ats(String _ats) {
						this._ats = _ats;
					}

					public String get_ats() {
						return this._ats;
					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}
			}

			public static class Shmem {

				private Server server;

				private Msi msi;

				private Address address;

				private String _name;

				private Size size;

				private Alias alias;

				private Model model;

				public Shmem() {

				}

				public void setServer(Server server) {
					this.server = server;
				}

				public Server getServer() {
					return this.server;
				}

				public void setMsi(Msi msi) {
					this.msi = msi;
				}

				public Msi getMsi() {
					return this.msi;
				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void set_name(String _name) {
					this._name = _name;
				}

				public String get_name() {
					return this._name;
				}

				public void setSize(Size size) {
					this.size = size;
				}

				public Size getSize() {
					return this.size;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void setModel(Model model) {
					this.model = model;
				}

				public Model getModel() {
					return this.model;
				}

				public static class Server {

					private String _path;

					public Server() {

					}

					public void set_path(String _path) {
						this._path = _path;
					}

					public String get_path() {
						return this._path;
					}
				}

				public static class Msi {

					private String _vectors;

					private String _ioeventfd;

					private String _enabled;

					public Msi() {

					}

					public void set_vectors(String _vectors) {
						this._vectors = _vectors;
					}

					public String get_vectors() {
						return this._vectors;
					}

					public void set_ioeventfd(String _ioeventfd) {
						this._ioeventfd = _ioeventfd;
					}

					public String get_ioeventfd() {
						return this._ioeventfd;
					}

					public void set_enabled(String _enabled) {
						this._enabled = _enabled;
					}

					public String get_enabled() {
						return this._enabled;
					}
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Size {

					private String _unit;

					private String text;

					public Size() {

					}

					public void set_unit(String _unit) {
						this._unit = _unit;
					}

					public String get_unit() {
						return this._unit;
					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}

				public static class Model {

					private String _type;

					public Model() {

					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}
				}
			}

			public static class Redirdev {

				private Protocol protocol;

				private Address address;

				private Alias alias;

				private Source source;

				private Boot boot;

				private String _bus;

				public Redirdev() {

				}

				public void setProtocol(Protocol protocol) {
					this.protocol = protocol;
				}

				public Protocol getProtocol() {
					return this.protocol;
				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void setSource(Source source) {
					this.source = source;
				}

				public Source getSource() {
					return this.source;
				}

				public void setBoot(Boot boot) {
					this.boot = boot;
				}

				public Boot getBoot() {
					return this.boot;
				}

				public void set_bus(String _bus) {
					this._bus = _bus;
				}

				public String get_bus() {
					return this._bus;
				}

				public static class Protocol {

					private String _type;

					public Protocol() {

					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}

				public static class Source {

					public Source() {

					}
				}

				public static class Boot {

					private String _loadparm;

					private String _order;

					public Boot() {

					}

					public void set_loadparm(String _loadparm) {
						this._loadparm = _loadparm;
					}

					public String get_loadparm() {
						return this._loadparm;
					}

					public void set_order(String _order) {
						this._order = _order;
					}

					public String get_order() {
						return this._order;
					}
				}
			}

			public static class Rng {

				private Address address;

				private Driver driver;

				private Rate rate;

				private Alias alias;

				private String _model;

				private Backend backend;

				public Rng() {

				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void setDriver(Driver driver) {
					this.driver = driver;
				}

				public Driver getDriver() {
					return this.driver;
				}

				public void setRate(Rate rate) {
					this.rate = rate;
				}

				public Rate getRate() {
					return this.rate;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(String _model) {
					this._model = _model;
				}

				public String get_model() {
					return this._model;
				}

				public void setBackend(Backend backend) {
					this.backend = backend;
				}

				public Backend getBackend() {
					return this.backend;
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Driver {

					private String _iommu;

					private String _ats;

					public Driver() {

					}

					public void set_iommu(String _iommu) {
						this._iommu = _iommu;
					}

					public String get_iommu() {
						return this._iommu;
					}

					public void set_ats(String _ats) {
						this._ats = _ats;
					}

					public String get_ats() {
						return this._ats;
					}
				}

				public static class Rate {

					private String _period;

					private String _bytes;

					public Rate() {

					}

					public void set_period(String _period) {
						this._period = _period;
					}

					public String get_period() {
						return this._period;
					}

					public void set_bytes(String _bytes) {
						this._bytes = _bytes;
					}

					public String get_bytes() {
						return this._bytes;
					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}

				public static class Backend {

					public Backend() {

					}
				}
			}

			public static class Smartcard {

				private Database database;

				private Protocol protocol;

				private Address address;

				private ArrayList<Certificate> certificate;

				private Alias alias;

				private Source source;

				public Smartcard() {

				}

				public void setDatabase(Database database) {
					this.database = database;
				}

				public Database getDatabase() {
					return this.database;
				}

				public void setProtocol(Protocol protocol) {
					this.protocol = protocol;
				}

				public Protocol getProtocol() {
					return this.protocol;
				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void setCertificate(ArrayList<Certificate> certificate) {
					this.certificate = certificate;
				}

				public ArrayList<Certificate> getCertificate() {
					return this.certificate;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void setSource(Source source) {
					this.source = source;
				}

				public Source getSource() {
					return this.source;
				}

				public static class Database {

					private String text;

					public Database() {

					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}

				public static class Protocol {

					private String _type;

					public Protocol() {

					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Certificate {

					private String text;

					public Certificate() {

					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}

				public static class Source {

					public Source() {

					}
				}
			}

			public static class Filesystem {

				private String _accessmode;

				private Address address;

				private Driver driver;

				private Readonly readonly;

				private Space_hard_limit space_hard_limit;

				private Alias alias;

				private String _model;

				private Source source;

				private Space_soft_limit space_soft_limit;

				private Target target;

				public Filesystem() {

				}

				public void set_accessmode(String _accessmode) {
					this._accessmode = _accessmode;
				}

				public String get_accessmode() {
					return this._accessmode;
				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void setDriver(Driver driver) {
					this.driver = driver;
				}

				public Driver getDriver() {
					return this.driver;
				}

				public void setReadonly(Readonly readonly) {
					this.readonly = readonly;
				}

				public Readonly getReadonly() {
					return this.readonly;
				}

				public void setSpace_hard_limit(Space_hard_limit space_hard_limit) {
					this.space_hard_limit = space_hard_limit;
				}

				public Space_hard_limit getSpace_hard_limit() {
					return this.space_hard_limit;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(String _model) {
					this._model = _model;
				}

				public String get_model() {
					return this._model;
				}

				public void setSource(Source source) {
					this.source = source;
				}

				public Source getSource() {
					return this.source;
				}

				public void setSpace_soft_limit(Space_soft_limit space_soft_limit) {
					this.space_soft_limit = space_soft_limit;
				}

				public Space_soft_limit getSpace_soft_limit() {
					return this.space_soft_limit;
				}

				public void setTarget(Target target) {
					this.target = target;
				}

				public Target getTarget() {
					return this.target;
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Driver {

					private String _name;

					private String _iommu;

					private String _type;

					private String _format;

					private String _wrpolicy;

					private String _ats;

					public Driver() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}

					public void set_iommu(String _iommu) {
						this._iommu = _iommu;
					}

					public String get_iommu() {
						return this._iommu;
					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}

					public void set_format(String _format) {
						this._format = _format;
					}

					public String get_format() {
						return this._format;
					}

					public void set_wrpolicy(String _wrpolicy) {
						this._wrpolicy = _wrpolicy;
					}

					public String get_wrpolicy() {
						return this._wrpolicy;
					}

					public void set_ats(String _ats) {
						this._ats = _ats;
					}

					public String get_ats() {
						return this._ats;
					}
				}

				public static class Readonly {

					public Readonly() {

					}
				}

				public static class Space_hard_limit {

					private String _unit;

					private String text;

					public Space_hard_limit() {

					}

					public void set_unit(String _unit) {
						this._unit = _unit;
					}

					public String get_unit() {
						return this._unit;
					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}

				public static class Source {

					public Source() {

					}
				}

				public static class Space_soft_limit {

					private String _unit;

					private String text;

					public Space_soft_limit() {

					}

					public void set_unit(String _unit) {
						this._unit = _unit;
					}

					public String get_unit() {
						return this._unit;
					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}

				public static class Target {

					private String _dir;

					public Target() {

					}

					public void set_dir(String _dir) {
						this._dir = _dir;
					}

					public String get_dir() {
						return this._dir;
					}
				}
			}

			public static class Panic {

				private Address address;

				private Alias alias;

				private String _model;

				public Panic() {

				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(String _model) {
					this._model = _model;
				}

				public String get_model() {
					return this._model;
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}
			}

			public static class Tpm {

				private Address address;

				private Alias alias;

				private String _model;

				private Backend backend;

				public Tpm() {

				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(String _model) {
					this._model = _model;
				}

				public String get_model() {
					return this._model;
				}

				public void setBackend(Backend backend) {
					this.backend = backend;
				}

				public Backend getBackend() {
					return this.backend;
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}

				public static class Backend {

					public Backend() {

					}
				}
			}

			public static class Emulator {

				private String text;

				public Emulator() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Input {

				private Address address;

				private Driver driver;

				private String _type;

				private Alias alias;

				private String _model;

				private Source source;

				private String _bus;

				public Input() {

				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void setDriver(Driver driver) {
					this.driver = driver;
				}

				public Driver getDriver() {
					return this.driver;
				}

				public void set_type(String _type) {
					this._type = _type;
				}

				public String get_type() {
					return this._type;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_model(String _model) {
					this._model = _model;
				}

				public String get_model() {
					return this._model;
				}

				public void setSource(Source source) {
					this.source = source;
				}

				public Source getSource() {
					return this.source;
				}

				public void set_bus(String _bus) {
					this._bus = _bus;
				}

				public String get_bus() {
					return this._bus;
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Driver {

					private String _iommu;

					private String _ats;

					public Driver() {

					}

					public void set_iommu(String _iommu) {
						this._iommu = _iommu;
					}

					public String get_iommu() {
						return this._iommu;
					}

					public void set_ats(String _ats) {
						this._ats = _ats;
					}

					public String get_ats() {
						return this._ats;
					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}

				public static class Source {

					private String _evdev;

					public Source() {

					}

					public void set_evdev(String _evdev) {
						this._evdev = _evdev;
					}

					public String get_evdev() {
						return this._evdev;
					}
				}
			}

			public static class Disk {

				private Shareable shareable;

				private Mirror mirror;

				private String _snapshot;

				private Auth auth;

				private Blockio blockio;

				private Source source;

				private Wwn wwn;

				private Encryption encryption;

				private Readonly readonly;

				private Vendor vendor;

				private Alias alias;

				private Boot boot;

				private String _rawio;

				private Iotune iotune;

				private Product product;

				private Address address;

				private String _sgio;

				private String _device;

				private Target target;

				private Driver driver;

				private Serial serial;

				private Transient _transient;

				private BackingStore backingStore;

				private String _model;

				private Geometry geometry;

				public Disk() {

				}

				public void setShareable(Shareable shareable) {
					this.shareable = shareable;
				}

				public Shareable getShareable() {
					return this.shareable;
				}

				public void setMirror(Mirror mirror) {
					this.mirror = mirror;
				}

				public Mirror getMirror() {
					return this.mirror;
				}

				public void set_snapshot(String _snapshot) {
					this._snapshot = _snapshot;
				}

				public String get_snapshot() {
					return this._snapshot;
				}

				public void setAuth(Auth auth) {
					this.auth = auth;
				}

				public Auth getAuth() {
					return this.auth;
				}

				public void setBlockio(Blockio blockio) {
					this.blockio = blockio;
				}

				public Blockio getBlockio() {
					return this.blockio;
				}

				public void setSource(Source source) {
					this.source = source;
				}

				public Source getSource() {
					return this.source;
				}

				public void setWwn(Wwn wwn) {
					this.wwn = wwn;
				}

				public Wwn getWwn() {
					return this.wwn;
				}

				public void setEncryption(Encryption encryption) {
					this.encryption = encryption;
				}

				public Encryption getEncryption() {
					return this.encryption;
				}

				public void setReadonly(Readonly readonly) {
					this.readonly = readonly;
				}

				public Readonly getReadonly() {
					return this.readonly;
				}

				public void setVendor(Vendor vendor) {
					this.vendor = vendor;
				}

				public Vendor getVendor() {
					return this.vendor;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void setBoot(Boot boot) {
					this.boot = boot;
				}

				public Boot getBoot() {
					return this.boot;
				}

				public void set_rawio(String _rawio) {
					this._rawio = _rawio;
				}

				public String get_rawio() {
					return this._rawio;
				}

				public void setIotune(Iotune iotune) {
					this.iotune = iotune;
				}

				public Iotune getIotune() {
					return this.iotune;
				}

				public void setProduct(Product product) {
					this.product = product;
				}

				public Product getProduct() {
					return this.product;
				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void set_sgio(String _sgio) {
					this._sgio = _sgio;
				}

				public String get_sgio() {
					return this._sgio;
				}

				public void set_device(String _device) {
					this._device = _device;
				}

				public String get_device() {
					return this._device;
				}

				public void setTarget(Target target) {
					this.target = target;
				}

				public Target getTarget() {
					return this.target;
				}

				public void setDriver(Driver driver) {
					this.driver = driver;
				}

				public Driver getDriver() {
					return this.driver;
				}

				public void setSerial(Serial serial) {
					this.serial = serial;
				}

				public Serial getSerial() {
					return this.serial;
				}

				public void set_Transient(Transient _transient) {
					this._transient = _transient;
				}

				public Transient get_Transient() {
					return this._transient;
				}

				public void setBackingStore(BackingStore backingStore) {
					this.backingStore = backingStore;
				}

				public BackingStore getBackingStore() {
					return this.backingStore;
				}

				public void set_model(String _model) {
					this._model = _model;
				}

				public String get_model() {
					return this._model;
				}

				public void setGeometry(Geometry geometry) {
					this.geometry = geometry;
				}

				public Geometry getGeometry() {
					return this.geometry;
				}

				public static class Shareable {

					public Shareable() {

					}
				}

				public static class Mirror {

					private String _job;

					private String _ready;

					private Format format;

					private Source source;

					public Mirror() {

					}

					public void set_job(String _job) {
						this._job = _job;
					}

					public String get_job() {
						return this._job;
					}

					public void set_ready(String _ready) {
						this._ready = _ready;
					}

					public String get_ready() {
						return this._ready;
					}

					public void setFormat(Format format) {
						this.format = format;
					}

					public Format getFormat() {
						return this.format;
					}

					public void setSource(Source source) {
						this.source = source;
					}

					public Source getSource() {
						return this.source;
					}

					public static class Format {

						private String _type;

						public Format() {

						}

						public void set_type(String _type) {
							this._type = _type;
						}

						public String get_type() {
							return this._type;
						}
					}

					public static class Source {

						private String _index;

						private Encryption encryption;

						private Reservations reservations;

						private String _startupPolicy;

						public Source() {

						}

						public void set_index(String _index) {
							this._index = _index;
						}

						public String get_index() {
							return this._index;
						}

						public void setEncryption(Encryption encryption) {
							this.encryption = encryption;
						}

						public Encryption getEncryption() {
							return this.encryption;
						}

						public void setReservations(Reservations reservations) {
							this.reservations = reservations;
						}

						public Reservations getReservations() {
							return this.reservations;
						}

						public void set_startupPolicy(String _startupPolicy) {
							this._startupPolicy = _startupPolicy;
						}

						public String get_startupPolicy() {
							return this._startupPolicy;
						}

						public static class Encryption {

							private String _format;

							private Secret secret;

							public Encryption() {

							}

							public void set_format(String _format) {
								this._format = _format;
							}

							public String get_format() {
								return this._format;
							}

							public void setSecret(Secret secret) {
								this.secret = secret;
							}

							public Secret getSecret() {
								return this.secret;
							}

							public static class Secret {

								private String _usage;

								private String _type;

								private String _uuid;

								public Secret() {

								}

								public void set_usage(String _usage) {
									this._usage = _usage;
								}

								public String get_usage() {
									return this._usage;
								}

								public void set_type(String _type) {
									this._type = _type;
								}

								public String get_type() {
									return this._type;
								}

								public void set_uuid(String _uuid) {
									this._uuid = _uuid;
								}

								public String get_uuid() {
									return this._uuid;
								}
							}
						}

						public static class Reservations {

							private String _managed;

							private Source source;

							private String _enabled;

							public Reservations() {

							}

							public void set_managed(String _managed) {
								this._managed = _managed;
							}

							public String get_managed() {
								return this._managed;
							}

							public void setSource(Source source) {
								this.source = source;
							}

							public Source getSource() {
								return this.source;
							}

							public void set_enabled(String _enabled) {
								this._enabled = _enabled;
							}

							public String get_enabled() {
								return this._enabled;
							}

						}
					}
				}

				public static class Auth {

					private String _username;

					private Secret secret;

					public Auth() {

					}

					public void set_username(String _username) {
						this._username = _username;
					}

					public String get_username() {
						return this._username;
					}

					public void setSecret(Secret secret) {
						this.secret = secret;
					}

					public Secret getSecret() {
						return this.secret;
					}

					public static class Secret {

						private String _usage;

						private String _type;

						private String _uuid;

						public Secret() {

						}

						public void set_usage(String _usage) {
							this._usage = _usage;
						}

						public String get_usage() {
							return this._usage;
						}

						public void set_type(String _type) {
							this._type = _type;
						}

						public String get_type() {
							return this._type;
						}

						public void set_uuid(String _uuid) {
							this._uuid = _uuid;
						}

						public String get_uuid() {
							return this._uuid;
						}
					}
				}

				public static class Blockio {

					private String _physical_block_size;

					private String _logical_block_size;

					public Blockio() {

					}

					public void set_physical_block_size(String _physical_block_size) {
						this._physical_block_size = _physical_block_size;
					}

					public String get_physical_block_size() {
						return this._physical_block_size;
					}

					public void set_logical_block_size(String _logical_block_size) {
						this._logical_block_size = _logical_block_size;
					}

					public String get_logical_block_size() {
						return this._logical_block_size;
					}
				}

				public static class Source {

					private String _index;

					private Encryption encryption;

					private Reservations reservations;

					private String _startupPolicy;

					public Source() {

					}

					public void set_index(String _index) {
						this._index = _index;
					}

					public String get_index() {
						return this._index;
					}

					public void setEncryption(Encryption encryption) {
						this.encryption = encryption;
					}

					public Encryption getEncryption() {
						return this.encryption;
					}

					public void setReservations(Reservations reservations) {
						this.reservations = reservations;
					}

					public Reservations getReservations() {
						return this.reservations;
					}

					public void set_startupPolicy(String _startupPolicy) {
						this._startupPolicy = _startupPolicy;
					}

					public String get_startupPolicy() {
						return this._startupPolicy;
					}

					public static class Encryption {

						private String _format;

						private Secret secret;

						public Encryption() {

						}

						public void set_format(String _format) {
							this._format = _format;
						}

						public String get_format() {
							return this._format;
						}

						public void setSecret(Secret secret) {
							this.secret = secret;
						}

						public Secret getSecret() {
							return this.secret;
						}

						public static class Secret {

							private String _usage;

							private String _type;

							private String _uuid;

							public Secret() {

							}

							public void set_usage(String _usage) {
								this._usage = _usage;
							}

							public String get_usage() {
								return this._usage;
							}

							public void set_type(String _type) {
								this._type = _type;
							}

							public String get_type() {
								return this._type;
							}

							public void set_uuid(String _uuid) {
								this._uuid = _uuid;
							}

							public String get_uuid() {
								return this._uuid;
							}
						}
					}

					public static class Reservations {

						private String _managed;

						private Source source;

						private String _enabled;

						public Reservations() {

						}

						public void set_managed(String _managed) {
							this._managed = _managed;
						}

						public String get_managed() {
							return this._managed;
						}

						public void setSource(Source source) {
							this.source = source;
						}

						public Source getSource() {
							return this.source;
						}

						public void set_enabled(String _enabled) {
							this._enabled = _enabled;
						}

						public String get_enabled() {
							return this._enabled;
						}

					}
				}

				public static class Wwn {

					private String text;

					public Wwn() {

					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}

				public static class Encryption {

					private String _format;

					private Secret secret;

					public Encryption() {

					}

					public void set_format(String _format) {
						this._format = _format;
					}

					public String get_format() {
						return this._format;
					}

					public void setSecret(Secret secret) {
						this.secret = secret;
					}

					public Secret getSecret() {
						return this.secret;
					}

					public static class Secret {

						private String _usage;

						private String _type;

						private String _uuid;

						public Secret() {

						}

						public void set_usage(String _usage) {
							this._usage = _usage;
						}

						public String get_usage() {
							return this._usage;
						}

						public void set_type(String _type) {
							this._type = _type;
						}

						public String get_type() {
							return this._type;
						}

						public void set_uuid(String _uuid) {
							this._uuid = _uuid;
						}

						public String get_uuid() {
							return this._uuid;
						}
					}
				}

				public static class Readonly {

					public Readonly() {

					}
				}

				public static class Vendor {

					private String text;

					public Vendor() {

					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}

				public static class Boot {

					private String _loadparm;

					private String _order;

					public Boot() {

					}

					public void set_loadparm(String _loadparm) {
						this._loadparm = _loadparm;
					}

					public String get_loadparm() {
						return this._loadparm;
					}

					public void set_order(String _order) {
						this._order = _order;
					}

					public String get_order() {
						return this._order;
					}
				}

				public static class Iotune {

					private Write_iops_sec_max_length write_iops_sec_max_length;

					private Group_name group_name;

					private Write_iops_sec write_iops_sec;

					private Read_bytes_sec_max read_bytes_sec_max;

					private Read_bytes_sec_max_length read_bytes_sec_max_length;

					private Total_iops_sec total_iops_sec;

					private Write_iops_sec_max write_iops_sec_max;

					private Total_bytes_sec total_bytes_sec;

					private Total_iops_sec_max total_iops_sec_max;

					private Total_bytes_sec_max_length total_bytes_sec_max_length;

					private Write_bytes_sec write_bytes_sec;

					private Total_bytes_sec_max total_bytes_sec_max;

					private Write_bytes_sec_max write_bytes_sec_max;

					private Read_iops_sec_max read_iops_sec_max;

					private Read_iops_sec_max_length read_iops_sec_max_length;

					private Size_iops_sec size_iops_sec;

					private Read_bytes_sec read_bytes_sec;

					private Read_iops_sec read_iops_sec;

					private Total_iops_sec_max_length total_iops_sec_max_length;

					private Write_bytes_sec_max_length write_bytes_sec_max_length;

					public Iotune() {

					}

					public void setWrite_iops_sec_max_length(Write_iops_sec_max_length write_iops_sec_max_length) {
						this.write_iops_sec_max_length = write_iops_sec_max_length;
					}

					public Write_iops_sec_max_length getWrite_iops_sec_max_length() {
						return this.write_iops_sec_max_length;
					}

					public void setGroup_name(Group_name group_name) {
						this.group_name = group_name;
					}

					public Group_name getGroup_name() {
						return this.group_name;
					}

					public void setWrite_iops_sec(Write_iops_sec write_iops_sec) {
						this.write_iops_sec = write_iops_sec;
					}

					public Write_iops_sec getWrite_iops_sec() {
						return this.write_iops_sec;
					}

					public void setRead_bytes_sec_max(Read_bytes_sec_max read_bytes_sec_max) {
						this.read_bytes_sec_max = read_bytes_sec_max;
					}

					public Read_bytes_sec_max getRead_bytes_sec_max() {
						return this.read_bytes_sec_max;
					}

					public void setRead_bytes_sec_max_length(Read_bytes_sec_max_length read_bytes_sec_max_length) {
						this.read_bytes_sec_max_length = read_bytes_sec_max_length;
					}

					public Read_bytes_sec_max_length getRead_bytes_sec_max_length() {
						return this.read_bytes_sec_max_length;
					}

					public void setTotal_iops_sec(Total_iops_sec total_iops_sec) {
						this.total_iops_sec = total_iops_sec;
					}

					public Total_iops_sec getTotal_iops_sec() {
						return this.total_iops_sec;
					}

					public void setWrite_iops_sec_max(Write_iops_sec_max write_iops_sec_max) {
						this.write_iops_sec_max = write_iops_sec_max;
					}

					public Write_iops_sec_max getWrite_iops_sec_max() {
						return this.write_iops_sec_max;
					}

					public void setTotal_bytes_sec(Total_bytes_sec total_bytes_sec) {
						this.total_bytes_sec = total_bytes_sec;
					}

					public Total_bytes_sec getTotal_bytes_sec() {
						return this.total_bytes_sec;
					}

					public void setTotal_iops_sec_max(Total_iops_sec_max total_iops_sec_max) {
						this.total_iops_sec_max = total_iops_sec_max;
					}

					public Total_iops_sec_max getTotal_iops_sec_max() {
						return this.total_iops_sec_max;
					}

					public void setTotal_bytes_sec_max_length(Total_bytes_sec_max_length total_bytes_sec_max_length) {
						this.total_bytes_sec_max_length = total_bytes_sec_max_length;
					}

					public Total_bytes_sec_max_length getTotal_bytes_sec_max_length() {
						return this.total_bytes_sec_max_length;
					}

					public void setWrite_bytes_sec(Write_bytes_sec write_bytes_sec) {
						this.write_bytes_sec = write_bytes_sec;
					}

					public Write_bytes_sec getWrite_bytes_sec() {
						return this.write_bytes_sec;
					}

					public void setTotal_bytes_sec_max(Total_bytes_sec_max total_bytes_sec_max) {
						this.total_bytes_sec_max = total_bytes_sec_max;
					}

					public Total_bytes_sec_max getTotal_bytes_sec_max() {
						return this.total_bytes_sec_max;
					}

					public void setWrite_bytes_sec_max(Write_bytes_sec_max write_bytes_sec_max) {
						this.write_bytes_sec_max = write_bytes_sec_max;
					}

					public Write_bytes_sec_max getWrite_bytes_sec_max() {
						return this.write_bytes_sec_max;
					}

					public void setRead_iops_sec_max(Read_iops_sec_max read_iops_sec_max) {
						this.read_iops_sec_max = read_iops_sec_max;
					}

					public Read_iops_sec_max getRead_iops_sec_max() {
						return this.read_iops_sec_max;
					}

					public void setRead_iops_sec_max_length(Read_iops_sec_max_length read_iops_sec_max_length) {
						this.read_iops_sec_max_length = read_iops_sec_max_length;
					}

					public Read_iops_sec_max_length getRead_iops_sec_max_length() {
						return this.read_iops_sec_max_length;
					}

					public void setSize_iops_sec(Size_iops_sec size_iops_sec) {
						this.size_iops_sec = size_iops_sec;
					}

					public Size_iops_sec getSize_iops_sec() {
						return this.size_iops_sec;
					}

					public void setRead_bytes_sec(Read_bytes_sec read_bytes_sec) {
						this.read_bytes_sec = read_bytes_sec;
					}

					public Read_bytes_sec getRead_bytes_sec() {
						return this.read_bytes_sec;
					}

					public void setRead_iops_sec(Read_iops_sec read_iops_sec) {
						this.read_iops_sec = read_iops_sec;
					}

					public Read_iops_sec getRead_iops_sec() {
						return this.read_iops_sec;
					}

					public void setTotal_iops_sec_max_length(Total_iops_sec_max_length total_iops_sec_max_length) {
						this.total_iops_sec_max_length = total_iops_sec_max_length;
					}

					public Total_iops_sec_max_length getTotal_iops_sec_max_length() {
						return this.total_iops_sec_max_length;
					}

					public void setWrite_bytes_sec_max_length(Write_bytes_sec_max_length write_bytes_sec_max_length) {
						this.write_bytes_sec_max_length = write_bytes_sec_max_length;
					}

					public Write_bytes_sec_max_length getWrite_bytes_sec_max_length() {
						return this.write_bytes_sec_max_length;
					}

					public static class Write_iops_sec_max_length {

						private String text;

						public Write_iops_sec_max_length() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Group_name {

						private String text;

						public Group_name() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Write_iops_sec {

						private String text;

						public Write_iops_sec() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Read_bytes_sec_max {

						private String text;

						public Read_bytes_sec_max() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Read_bytes_sec_max_length {

						private String text;

						public Read_bytes_sec_max_length() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Total_iops_sec {

						private String text;

						public Total_iops_sec() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Write_iops_sec_max {

						private String text;

						public Write_iops_sec_max() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Total_bytes_sec {

						private String text;

						public Total_bytes_sec() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Total_iops_sec_max {

						private String text;

						public Total_iops_sec_max() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Total_bytes_sec_max_length {

						private String text;

						public Total_bytes_sec_max_length() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Write_bytes_sec {

						private String text;

						public Write_bytes_sec() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Total_bytes_sec_max {

						private String text;

						public Total_bytes_sec_max() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Write_bytes_sec_max {

						private String text;

						public Write_bytes_sec_max() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Read_iops_sec_max {

						private String text;

						public Read_iops_sec_max() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Read_iops_sec_max_length {

						private String text;

						public Read_iops_sec_max_length() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Size_iops_sec {

						private String text;

						public Size_iops_sec() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Read_bytes_sec {

						private String text;

						public Read_bytes_sec() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Read_iops_sec {

						private String text;

						public Read_iops_sec() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Total_iops_sec_max_length {

						private String text;

						public Total_iops_sec_max_length() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}

					public static class Write_bytes_sec_max_length {

						private String text;

						public Write_bytes_sec_max_length() {

						}

						public void setText(String text) {
							this.text = text;
						}

						public String getText() {
							return this.text;
						}
					}
				}

				public static class Product {

					private String text;

					public Product() {

					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Target {

					private String _removable;

					private String _tray;

					private String _dev;

					private String _bus;

					public Target() {

					}

					public void set_removable(String _removable) {
						this._removable = _removable;
					}

					public String get_removable() {
						return this._removable;
					}

					public void set_tray(String _tray) {
						this._tray = _tray;
					}

					public String get_tray() {
						return this._tray;
					}

					public void set_dev(String _dev) {
						this._dev = _dev;
					}

					public String get_dev() {
						return this._dev;
					}

					public void set_bus(String _bus) {
						this._bus = _bus;
					}

					public String get_bus() {
						return this._bus;
					}
				}

				public static class Driver {

					private String _detect_zeroes;

					private String _io;

					private String _name;

					private String _rerror_policy;

					private String _queues;

					private String _iommu;

					private String _type;

					private String _ats;

					private String _discard;

					private String _copy_on_read;

					private String _error_policy;

					private String _ioeventfd;

					private String _iothread;

					private String _event_idx;

					private String _cache;

					public Driver() {

					}

					public void set_detect_zeroes(String _detect_zeroes) {
						this._detect_zeroes = _detect_zeroes;
					}

					public String get_detect_zeroes() {
						return this._detect_zeroes;
					}

					public void set_io(String _io) {
						this._io = _io;
					}

					public String get_io() {
						return this._io;
					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}

					public void set_rerror_policy(String _rerror_policy) {
						this._rerror_policy = _rerror_policy;
					}

					public String get_rerror_policy() {
						return this._rerror_policy;
					}

					public void set_queues(String _queues) {
						this._queues = _queues;
					}

					public String get_queues() {
						return this._queues;
					}

					public void set_iommu(String _iommu) {
						this._iommu = _iommu;
					}

					public String get_iommu() {
						return this._iommu;
					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}

					public void set_ats(String _ats) {
						this._ats = _ats;
					}

					public String get_ats() {
						return this._ats;
					}

					public void set_discard(String _discard) {
						this._discard = _discard;
					}

					public String get_discard() {
						return this._discard;
					}

					public void set_copy_on_read(String _copy_on_read) {
						this._copy_on_read = _copy_on_read;
					}

					public String get_copy_on_read() {
						return this._copy_on_read;
					}

					public void set_error_policy(String _error_policy) {
						this._error_policy = _error_policy;
					}

					public String get_error_policy() {
						return this._error_policy;
					}

					public void set_ioeventfd(String _ioeventfd) {
						this._ioeventfd = _ioeventfd;
					}

					public String get_ioeventfd() {
						return this._ioeventfd;
					}

					public void set_iothread(String _iothread) {
						this._iothread = _iothread;
					}

					public String get_iothread() {
						return this._iothread;
					}

					public void set_event_idx(String _event_idx) {
						this._event_idx = _event_idx;
					}

					public String get_event_idx() {
						return this._event_idx;
					}

					public void set_cache(String _cache) {
						this._cache = _cache;
					}

					public String get_cache() {
						return this._cache;
					}
				}

				public static class Serial {

					private String text;

					public Serial() {

					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}

				public static class Transient {

					public Transient() {

					}
				}

				public static class BackingStore {

					private String _index;

					private Format format;

					private Source source;

					public BackingStore() {

					}

					public void set_index(String _index) {
						this._index = _index;
					}

					public String get_index() {
						return this._index;
					}

					public void setFormat(Format format) {
						this.format = format;
					}

					public Format getFormat() {
						return this.format;
					}

					public void setSource(Source source) {
						this.source = source;
					}

					public Source getSource() {
						return this.source;
					}

					public static class Format {

						private String _type;

						public Format() {

						}

						public void set_type(String _type) {
							this._type = _type;
						}

						public String get_type() {
							return this._type;
						}
					}

					public static class Source {

						private String _index;

						private Encryption encryption;

						private Reservations reservations;

						private String _startupPolicy;

						public Source() {

						}

						public void set_index(String _index) {
							this._index = _index;
						}

						public String get_index() {
							return this._index;
						}

						public void setEncryption(Encryption encryption) {
							this.encryption = encryption;
						}

						public Encryption getEncryption() {
							return this.encryption;
						}

						public void setReservations(Reservations reservations) {
							this.reservations = reservations;
						}

						public Reservations getReservations() {
							return this.reservations;
						}

						public void set_startupPolicy(String _startupPolicy) {
							this._startupPolicy = _startupPolicy;
						}

						public String get_startupPolicy() {
							return this._startupPolicy;
						}

						public static class Encryption {

							private String _format;

							private Secret secret;

							public Encryption() {

							}

							public void set_format(String _format) {
								this._format = _format;
							}

							public String get_format() {
								return this._format;
							}

							public void setSecret(Secret secret) {
								this.secret = secret;
							}

							public Secret getSecret() {
								return this.secret;
							}

							public static class Secret {

								private String _usage;

								private String _type;

								private String _uuid;

								public Secret() {

								}

								public void set_usage(String _usage) {
									this._usage = _usage;
								}

								public String get_usage() {
									return this._usage;
								}

								public void set_type(String _type) {
									this._type = _type;
								}

								public String get_type() {
									return this._type;
								}

								public void set_uuid(String _uuid) {
									this._uuid = _uuid;
								}

								public String get_uuid() {
									return this._uuid;
								}
							}
						}

						public static class Reservations {

							private String _managed;

							private Source source;

							private String _enabled;

							public Reservations() {

							}

							public void set_managed(String _managed) {
								this._managed = _managed;
							}

							public String get_managed() {
								return this._managed;
							}

							public void setSource(Source source) {
								this.source = source;
							}

							public Source getSource() {
								return this.source;
							}

							public void set_enabled(String _enabled) {
								this._enabled = _enabled;
							}

							public String get_enabled() {
								return this._enabled;
							}

						}
					}
				}

				public static class Geometry {

					private String _heads;

					private String _secs;

					private String _cyls;

					private String _trans;

					public Geometry() {

					}

					public void set_heads(String _heads) {
						this._heads = _heads;
					}

					public String get_heads() {
						return this._heads;
					}

					public void set_secs(String _secs) {
						this._secs = _secs;
					}

					public String get_secs() {
						return this._secs;
					}

					public void set_cyls(String _cyls) {
						this._cyls = _cyls;
					}

					public String get_cyls() {
						return this._cyls;
					}

					public void set_trans(String _trans) {
						this._trans = _trans;
					}

					public String get_trans() {
						return this._trans;
					}
				}
			}

			public static class Watchdog {

				private Address address;

				private Alias alias;

				private String _action;

				private String _model;

				public Watchdog() {

				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void set_action(String _action) {
					this._action = _action;
				}

				public String get_action() {
					return this._action;
				}

				public void set_model(String _model) {
					this._model = _model;
				}

				public String get_model() {
					return this._model;
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}
			}

			public static class Hub {

				private Address address;

				private String _type;

				private Alias alias;

				public Hub() {

				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void set_type(String _type) {
					this._type = _type;
				}

				public String get_type() {
					return this._type;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}
			}

			public static class Serial {

				private Protocol protocol;

				private Address address;

				private Log log;

				private Alias alias;

				private Source source;

				private Target target;

				public Serial() {

				}

				public void setProtocol(Protocol protocol) {
					this.protocol = protocol;
				}

				public Protocol getProtocol() {
					return this.protocol;
				}

				public void setAddress(Address address) {
					this.address = address;
				}

				public Address getAddress() {
					return this.address;
				}

				public void setLog(Log log) {
					this.log = log;
				}

				public Log getLog() {
					return this.log;
				}

				public void setAlias(Alias alias) {
					this.alias = alias;
				}

				public Alias getAlias() {
					return this.alias;
				}

				public void setSource(Source source) {
					this.source = source;
				}

				public Source getSource() {
					return this.source;
				}

				public void setTarget(Target target) {
					this.target = target;
				}

				public Target getTarget() {
					return this.target;
				}

				public static class Protocol {

					private String _type;

					public Protocol() {

					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}
				}

				public static class Address {

					public Address() {

					}
				}

				public static class Log {

					private String _file;

					private String _append;

					public Log() {

					}

					public void set_file(String _file) {
						this._file = _file;
					}

					public String get_file() {
						return this._file;
					}

					public void set_append(String _append) {
						this._append = _append;
					}

					public String get_append() {
						return this._append;
					}
				}

				public static class Alias {

					private String _name;

					public Alias() {

					}

					public void set_name(String _name) {
						this._name = _name;
					}

					public String get_name() {
						return this._name;
					}
				}

				public static class Source {

					public Source() {

					}
				}

				public static class Target {

					private String _type;

					private Model model;

					private String _port;

					public Target() {

					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}

					public void setModel(Model model) {
						this.model = model;
					}

					public Model getModel() {
						return this.model;
					}

					public void set_port(String _port) {
						this._port = _port;
					}

					public String get_port() {
						return this._port;
					}

					public static class Model {

						private String _name;

						public Model() {

						}

						public void set_name(String _name) {
							this._name = _name;
						}

						public String get_name() {
							return this._name;
						}
					}
				}
			}

			public static class Lease {

				private Lockspace lockspace;

				private Key key;

				private Target target;

				public Lease() {

				}

				public void setLockspace(Lockspace lockspace) {
					this.lockspace = lockspace;
				}

				public Lockspace getLockspace() {
					return this.lockspace;
				}

				public void setKey(Key key) {
					this.key = key;
				}

				public Key getKey() {
					return this.key;
				}

				public void setTarget(Target target) {
					this.target = target;
				}

				public Target getTarget() {
					return this.target;
				}

				public static class Lockspace {

					private String text;

					public Lockspace() {

					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}

				public static class Key {

					private String text;

					public Key() {

					}

					public void setText(String text) {
						this.text = text;
					}

					public String getText() {
						return this.text;
					}
				}

				public static class Target {

					private String _offset;

					private String _path;

					public Target() {

					}

					public void set_offset(String _offset) {
						this._offset = _offset;
					}

					public String get_offset() {
						return this._offset;
					}

					public void set_path(String _path) {
						this._path = _path;
					}

					public String get_path() {
						return this._path;
					}
				}
			}
		}

		public static class Resource {

			private Partition partition;

			public Resource() {

			}

			public void setPartition(Partition partition) {
				this.partition = partition;
			}

			public Partition getPartition() {
				return this.partition;
			}

			public static class Partition {

				private String text;

				public Partition() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}
		}

		public static class On_reboot {

			private String text;

			public On_reboot() {

			}

			public void setText(String text) {
				this.text = text;
			}

			public String getText() {
				return this.text;
			}
		}

		public static class Cpu {

			private Cache cache;

			private ArrayList<Feature> feature;

			private Topology topology;

			private Vendor vendor;

			private Numa numa;

			private String _check;

			private Model model;

			private String _match;

			private String _mode;

			public Cpu() {

			}

			public void setCache(Cache cache) {
				this.cache = cache;
			}

			public Cache getCache() {
				return this.cache;
			}

			public void setFeature(ArrayList<Feature> feature) {
				this.feature = feature;
			}

			public ArrayList<Feature> getFeature() {
				return this.feature;
			}

			public void setTopology(Topology topology) {
				this.topology = topology;
			}

			public Topology getTopology() {
				return this.topology;
			}

			public void setVendor(Vendor vendor) {
				this.vendor = vendor;
			}

			public Vendor getVendor() {
				return this.vendor;
			}

			public void setNuma(Numa numa) {
				this.numa = numa;
			}

			public Numa getNuma() {
				return this.numa;
			}

			public void set_check(String _check) {
				this._check = _check;
			}

			public String get_check() {
				return this._check;
			}

			public void setModel(Model model) {
				this.model = model;
			}

			public Model getModel() {
				return this.model;
			}

			public void set_match(String _match) {
				this._match = _match;
			}

			public String get_match() {
				return this._match;
			}

			public void set_mode(String _mode) {
				this._mode = _mode;
			}

			public String get_mode() {
				return this._mode;
			}

			public static class Cache {

				private String _level;

				private String _mode;

				public Cache() {

				}

				public void set_level(String _level) {
					this._level = _level;
				}

				public String get_level() {
					return this._level;
				}

				public void set_mode(String _mode) {
					this._mode = _mode;
				}

				public String get_mode() {
					return this._mode;
				}
			}

			public static class Feature {

				private String _name;

				private String _policy;

				public Feature() {

				}

				public void set_name(String _name) {
					this._name = _name;
				}

				public String get_name() {
					return this._name;
				}

				public void set_policy(String _policy) {
					this._policy = _policy;
				}

				public String get_policy() {
					return this._policy;
				}
			}

			public static class Topology {

				private String _cores;

				private String _sockets;

				private String _threads;

				public Topology() {

				}

				public void set_cores(String _cores) {
					this._cores = _cores;
				}

				public String get_cores() {
					return this._cores;
				}

				public void set_sockets(String _sockets) {
					this._sockets = _sockets;
				}

				public String get_sockets() {
					return this._sockets;
				}

				public void set_threads(String _threads) {
					this._threads = _threads;
				}

				public String get_threads() {
					return this._threads;
				}
			}

			public static class Vendor {

				private String text;

				public Vendor() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Numa {

				private ArrayList<Cell> cell;

				public Numa() {

				}

				public void setCell(ArrayList<Cell> cell) {
					this.cell = cell;
				}

				public ArrayList<Cell> getCell() {
					return this.cell;
				}

				public static class Cell {

					private String _discard;

					private Distances distances;

					private String _memory;

					private String _unit;

					private String _cpus;

					private String _memAccess;

					private String _id;

					public Cell() {

					}

					public void set_discard(String _discard) {
						this._discard = _discard;
					}

					public String get_discard() {
						return this._discard;
					}

					public void setDistances(Distances distances) {
						this.distances = distances;
					}

					public Distances getDistances() {
						return this.distances;
					}

					public void set_memory(String _memory) {
						this._memory = _memory;
					}

					public String get_memory() {
						return this._memory;
					}

					public void set_unit(String _unit) {
						this._unit = _unit;
					}

					public String get_unit() {
						return this._unit;
					}

					public void set_cpus(String _cpus) {
						this._cpus = _cpus;
					}

					public String get_cpus() {
						return this._cpus;
					}

					public void set_memAccess(String _memAccess) {
						this._memAccess = _memAccess;
					}

					public String get_memAccess() {
						return this._memAccess;
					}

					public void set_id(String _id) {
						this._id = _id;
					}

					public String get_id() {
						return this._id;
					}

					public static class Distances {

						private ArrayList<Sibling> sibling;

						public Distances() {

						}

						public void setSibling(ArrayList<Sibling> sibling) {
							this.sibling = sibling;
						}

						public ArrayList<Sibling> getSibling() {
							return this.sibling;
						}

						public static class Sibling {

							private String _value;

							private String _id;

							public Sibling() {

							}

							public void set_value(String _value) {
								this._value = _value;
							}

							public String get_value() {
								return this._value;
							}

							public void set_id(String _id) {
								this._id = _id;
							}

							public String get_id() {
								return this._id;
							}
						}
					}
				}
			}

			public static class Model {

				private String _fallback;

				private String _vendor_id;

				private String text;

				public Model() {

				}

				public void set_fallback(String _fallback) {
					this._fallback = _fallback;
				}

				public String get_fallback() {
					return this._fallback;
				}

				public void set_vendor_id(String _vendor_id) {
					this._vendor_id = _vendor_id;
				}

				public String get_vendor_id() {
					return this._vendor_id;
				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}
		}

		public static class Clock {

			private String _basis;

			private ArrayList<Timer> timer;

			private String _offset;

			private String _adjustment;

			private String _timezone;

			public Clock() {

			}

			public void set_basis(String _basis) {
				this._basis = _basis;
			}

			public String get_basis() {
				return this._basis;
			}

			public void setTimer(ArrayList<Timer> timer) {
				this.timer = timer;
			}

			public ArrayList<Timer> getTimer() {
				return this.timer;
			}

			public void set_offset(String _offset) {
				this._offset = _offset;
			}

			public String get_offset() {
				return this._offset;
			}

			public void set_adjustment(String _adjustment) {
				this._adjustment = _adjustment;
			}

			public String get_adjustment() {
				return this._adjustment;
			}

			public void set_timezone(String _timezone) {
				this._timezone = _timezone;
			}

			public String get_timezone() {
				return this._timezone;
			}

			public static class Timer {

				private String _name;

				private Catchup catchup;

				private String _track;

				private String _frequency;

				private String _present;

				private String _tickpolicy;

				private String _mode;

				public Timer() {

				}

				public void set_name(String _name) {
					this._name = _name;
				}

				public String get_name() {
					return this._name;
				}

				public void setCatchup(Catchup catchup) {
					this.catchup = catchup;
				}

				public Catchup getCatchup() {
					return this.catchup;
				}

				public void set_track(String _track) {
					this._track = _track;
				}

				public String get_track() {
					return this._track;
				}

				public void set_frequency(String _frequency) {
					this._frequency = _frequency;
				}

				public String get_frequency() {
					return this._frequency;
				}

				public void set_present(String _present) {
					this._present = _present;
				}

				public String get_present() {
					return this._present;
				}

				public void set_tickpolicy(String _tickpolicy) {
					this._tickpolicy = _tickpolicy;
				}

				public String get_tickpolicy() {
					return this._tickpolicy;
				}

				public void set_mode(String _mode) {
					this._mode = _mode;
				}

				public String get_mode() {
					return this._mode;
				}

				public static class Catchup {

					private String _limit;

					private String _slew;

					private String _threshold;

					public Catchup() {

					}

					public void set_limit(String _limit) {
						this._limit = _limit;
					}

					public String get_limit() {
						return this._limit;
					}

					public void set_slew(String _slew) {
						this._slew = _slew;
					}

					public String get_slew() {
						return this._slew;
					}

					public void set_threshold(String _threshold) {
						this._threshold = _threshold;
					}

					public String get_threshold() {
						return this._threshold;
					}
				}
			}
		}

		public static class Vcpus {

			private ArrayList<Vcpu> vcpu;

			public Vcpus() {

			}

			public void setVcpu(ArrayList<Vcpu> vcpu) {
				this.vcpu = vcpu;
			}

			public ArrayList<Vcpu> getVcpu() {
				return this.vcpu;
			}

			public static class Vcpu {

				private String _order;

				private String _hotpluggable;

				private String _id;

				private String _enabled;

				public Vcpu() {

				}

				public void set_order(String _order) {
					this._order = _order;
				}

				public String get_order() {
					return this._order;
				}

				public void set_hotpluggable(String _hotpluggable) {
					this._hotpluggable = _hotpluggable;
				}

				public String get_hotpluggable() {
					return this._hotpluggable;
				}

				public void set_id(String _id) {
					this._id = _id;
				}

				public String get_id() {
					return this._id;
				}

				public void set_enabled(String _enabled) {
					this._enabled = _enabled;
				}

				public String get_enabled() {
					return this._enabled;
				}
			}
		}

		public static class Cputune {

			private Global_quota global_quota;

			private ArrayList<Iothreadpin> iothreadpin;

			private Period period;

			private Emulator_period emulator_period;

			private Emulatorpin emulatorpin;

			private ArrayList<Vcpusched> vcpusched;

			private ArrayList<Iothreadsched> iothreadsched;

			private Iothread_period iothread_period;

			private Global_period global_period;

			private Emulator_quota emulator_quota;

			private Shares shares;

			private ArrayList<Vcpupin> vcpupin;

			private ArrayList<Cachetune> cachetune;

			private Quota quota;

			private Iothread_quota iothread_quota;

			private ArrayList<Memorytune> memorytune;

			public Cputune() {

			}

			public void setGlobal_quota(Global_quota global_quota) {
				this.global_quota = global_quota;
			}

			public Global_quota getGlobal_quota() {
				return this.global_quota;
			}

			public void setIothreadpin(ArrayList<Iothreadpin> iothreadpin) {
				this.iothreadpin = iothreadpin;
			}

			public ArrayList<Iothreadpin> getIothreadpin() {
				return this.iothreadpin;
			}

			public void setPeriod(Period period) {
				this.period = period;
			}

			public Period getPeriod() {
				return this.period;
			}

			public void setEmulator_period(Emulator_period emulator_period) {
				this.emulator_period = emulator_period;
			}

			public Emulator_period getEmulator_period() {
				return this.emulator_period;
			}

			public void setEmulatorpin(Emulatorpin emulatorpin) {
				this.emulatorpin = emulatorpin;
			}

			public Emulatorpin getEmulatorpin() {
				return this.emulatorpin;
			}

			public void setVcpusched(ArrayList<Vcpusched> vcpusched) {
				this.vcpusched = vcpusched;
			}

			public ArrayList<Vcpusched> getVcpusched() {
				return this.vcpusched;
			}

			public void setIothreadsched(ArrayList<Iothreadsched> iothreadsched) {
				this.iothreadsched = iothreadsched;
			}

			public ArrayList<Iothreadsched> getIothreadsched() {
				return this.iothreadsched;
			}

			public void setIothread_period(Iothread_period iothread_period) {
				this.iothread_period = iothread_period;
			}

			public Iothread_period getIothread_period() {
				return this.iothread_period;
			}

			public void setGlobal_period(Global_period global_period) {
				this.global_period = global_period;
			}

			public Global_period getGlobal_period() {
				return this.global_period;
			}

			public void setEmulator_quota(Emulator_quota emulator_quota) {
				this.emulator_quota = emulator_quota;
			}

			public Emulator_quota getEmulator_quota() {
				return this.emulator_quota;
			}

			public void setShares(Shares shares) {
				this.shares = shares;
			}

			public Shares getShares() {
				return this.shares;
			}

			public void setVcpupin(ArrayList<Vcpupin> vcpupin) {
				this.vcpupin = vcpupin;
			}

			public ArrayList<Vcpupin> getVcpupin() {
				return this.vcpupin;
			}

			public void setCachetune(ArrayList<Cachetune> cachetune) {
				this.cachetune = cachetune;
			}

			public ArrayList<Cachetune> getCachetune() {
				return this.cachetune;
			}

			public void setQuota(Quota quota) {
				this.quota = quota;
			}

			public Quota getQuota() {
				return this.quota;
			}

			public void setIothread_quota(Iothread_quota iothread_quota) {
				this.iothread_quota = iothread_quota;
			}

			public Iothread_quota getIothread_quota() {
				return this.iothread_quota;
			}

			public void setMemorytune(ArrayList<Memorytune> memorytune) {
				this.memorytune = memorytune;
			}

			public ArrayList<Memorytune> getMemorytune() {
				return this.memorytune;
			}

			public static class Global_quota {

				private String text;

				public Global_quota() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Iothreadpin {

				private String _cpuset;

				private String _iothread;

				public Iothreadpin() {

				}

				public void set_cpuset(String _cpuset) {
					this._cpuset = _cpuset;
				}

				public String get_cpuset() {
					return this._cpuset;
				}

				public void set_iothread(String _iothread) {
					this._iothread = _iothread;
				}

				public String get_iothread() {
					return this._iothread;
				}
			}

			public static class Period {

				private String text;

				public Period() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Emulator_period {

				private String text;

				public Emulator_period() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Emulatorpin {

				private String _cpuset;

				public Emulatorpin() {

				}

				public void set_cpuset(String _cpuset) {
					this._cpuset = _cpuset;
				}

				public String get_cpuset() {
					return this._cpuset;
				}
			}

			public static class Vcpusched {

				private String _scheduler;

				private String _vcpus;

				private String _priority;

				public Vcpusched() {

				}

				public void set_scheduler(String _scheduler) {
					this._scheduler = _scheduler;
				}

				public String get_scheduler() {
					return this._scheduler;
				}

				public void set_vcpus(String _vcpus) {
					this._vcpus = _vcpus;
				}

				public String get_vcpus() {
					return this._vcpus;
				}

				public void set_priority(String _priority) {
					this._priority = _priority;
				}

				public String get_priority() {
					return this._priority;
				}
			}

			public static class Iothreadsched {

				private String _scheduler;

				private String _iothreads;

				private String _priority;

				public Iothreadsched() {

				}

				public void set_scheduler(String _scheduler) {
					this._scheduler = _scheduler;
				}

				public String get_scheduler() {
					return this._scheduler;
				}

				public void set_iothreads(String _iothreads) {
					this._iothreads = _iothreads;
				}

				public String get_iothreads() {
					return this._iothreads;
				}

				public void set_priority(String _priority) {
					this._priority = _priority;
				}

				public String get_priority() {
					return this._priority;
				}
			}

			public static class Iothread_period {

				private String text;

				public Iothread_period() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Global_period {

				private String text;

				public Global_period() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Emulator_quota {

				private String text;

				public Emulator_quota() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Shares {

				private String text;

				public Shares() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Vcpupin {

				private String _vcpu;

				private String _cpuset;

				public Vcpupin() {

				}

				public void set_vcpu(String _vcpu) {
					this._vcpu = _vcpu;
				}

				public String get_vcpu() {
					return this._vcpu;
				}

				public void set_cpuset(String _cpuset) {
					this._cpuset = _cpuset;
				}

				public String get_cpuset() {
					return this._cpuset;
				}
			}

			public static class Cachetune {

				private ArrayList<Cache> cache;

				private ArrayList<Monitor> monitor;

				private String _vcpus;

				public Cachetune() {

				}

				public void setCache(ArrayList<Cache> cache) {
					this.cache = cache;
				}

				public ArrayList<Cache> getCache() {
					return this.cache;
				}

				public void setMonitor(ArrayList<Monitor> monitor) {
					this.monitor = monitor;
				}

				public ArrayList<Monitor> getMonitor() {
					return this.monitor;
				}

				public void set_vcpus(String _vcpus) {
					this._vcpus = _vcpus;
				}

				public String get_vcpus() {
					return this._vcpus;
				}

				public static class Cache {

					private String _size;

					private String _unit;

					private String _level;

					private String _type;

					private String _id;

					public Cache() {

					}

					public void set_size(String _size) {
						this._size = _size;
					}

					public String get_size() {
						return this._size;
					}

					public void set_unit(String _unit) {
						this._unit = _unit;
					}

					public String get_unit() {
						return this._unit;
					}

					public void set_level(String _level) {
						this._level = _level;
					}

					public String get_level() {
						return this._level;
					}

					public void set_type(String _type) {
						this._type = _type;
					}

					public String get_type() {
						return this._type;
					}

					public void set_id(String _id) {
						this._id = _id;
					}

					public String get_id() {
						return this._id;
					}
				}

				public static class Monitor {

					private String _level;

					private String _vcpus;

					public Monitor() {

					}

					public void set_level(String _level) {
						this._level = _level;
					}

					public String get_level() {
						return this._level;
					}

					public void set_vcpus(String _vcpus) {
						this._vcpus = _vcpus;
					}

					public String get_vcpus() {
						return this._vcpus;
					}
				}
			}

			public static class Quota {

				private String text;

				public Quota() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Iothread_quota {

				private String text;

				public Iothread_quota() {

				}

				public void setText(String text) {
					this.text = text;
				}

				public String getText() {
					return this.text;
				}
			}

			public static class Memorytune {

				private ArrayList<Node> node;

				private String _vcpus;

				public Memorytune() {

				}

				public void setNode(ArrayList<Node> node) {
					this.node = node;
				}

				public ArrayList<Node> getNode() {
					return this.node;
				}

				public void set_vcpus(String _vcpus) {
					this._vcpus = _vcpus;
				}

				public String get_vcpus() {
					return this._vcpus;
				}

				public static class Node {

					private String _bandwidth;

					private String _id;

					public Node() {

					}

					public void set_bandwidth(String _bandwidth) {
						this._bandwidth = _bandwidth;
					}

					public String get_bandwidth() {
						return this._bandwidth;
					}

					public void set_id(String _id) {
						this._id = _id;
					}

					public String get_id() {
						return this._id;
					}
				}
			}
		}

		public static class Genid {

			private String text;

			public Genid() {

			}

			public void setText(String text) {
				this.text = text;
			}

			public String getText() {
				return this.text;
			}
		}

		public static class Iothreads {

			private String text;

			public Iothreads() {

			}

			public void setText(String text) {
				this.text = text;
			}

			public String getText() {
				return this.text;
			}
		}

		public static class Name {

			private String text;

			public Name() {

			}

			public void setText(String text) {
				this.text = text;
			}

			public String getText() {
				return this.text;
			}
		}

		public static class CurrentMemory {

			private String _unit;

			private String text;

			public CurrentMemory() {

			}

			public void set_unit(String _unit) {
				this._unit = _unit;
			}

			public String get_unit() {
				return this._unit;
			}

			public void setText(String text) {
				this.text = text;
			}

			public String getText() {
				return this.text;
			}
		}

		public static class Pm {

			private Suspend_to_mem suspend_to_mem;

			private Suspend_to_disk suspend_to_disk;

			public Pm() {

			}

			public void setSuspend_to_mem(Suspend_to_mem suspend_to_mem) {
				this.suspend_to_mem = suspend_to_mem;
			}

			public Suspend_to_mem getSuspend_to_mem() {
				return this.suspend_to_mem;
			}

			public void setSuspend_to_disk(Suspend_to_disk suspend_to_disk) {
				this.suspend_to_disk = suspend_to_disk;
			}

			public Suspend_to_disk getSuspend_to_disk() {
				return this.suspend_to_disk;
			}

			public static class Suspend_to_mem {

				private String _enabled;

				public Suspend_to_mem() {

				}

				public void set_enabled(String _enabled) {
					this._enabled = _enabled;
				}

				public String get_enabled() {
					return this._enabled;
				}
			}

			public static class Suspend_to_disk {

				private String _enabled;

				public Suspend_to_disk() {

				}

				public void set_enabled(String _enabled) {
					this._enabled = _enabled;
				}

				public String get_enabled() {
					return this._enabled;
				}
			}
		}
	}
}
