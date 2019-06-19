/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model;

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

	protected Domain domain;

	protected Lifecycle lifecycle;

	protected String image;

	protected String nodeName;

	public VirtualMachineSpec() {

	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public Domain getDomain() {
		return this.domain;
	}

	public Lifecycle getLifecycle() {
		return lifecycle;
	}

	public void setLifecycle(Lifecycle lifecycle) {
		this.lifecycle = lifecycle;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	/****************************************************
	 * 
	 * Domain
	 * 
	 *****************************************************/

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

			private Nested_hv nested_hv;

			private Privnet privnet;

			private Smm smm;

			private Msrs msrs;

			private Pae pae;

			private Acpi acpi;

			private Hap hap;

			private Ioapic ioapic;

			private Pmu pmu;

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

			public void setNested_hv(Nested_hv nested_hv) {
				this.nested_hv = nested_hv;
			}

			public Nested_hv getNested_hv() {
				return this.nested_hv;
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

				private _transient _transient;

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

				public void set_transient(_transient _transient) {
					this._transient = _transient;
				}

				public _transient get_transient() {
					return this._transient;
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

				public static class _transient {

					public _transient() {

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

			private Suspend_to_disk suspend_to_disk;

			private Suspend_to_mem suspend_to_mem;

			public Pm() {

			}

			public void setSuspend_to_disk(Suspend_to_disk suspend_to_disk) {
				this.suspend_to_disk = suspend_to_disk;
			}

			public Suspend_to_disk getSuspend_to_disk() {
				return this.suspend_to_disk;
			}

			public void setSuspend_to_mem(Suspend_to_mem suspend_to_mem) {
				this.suspend_to_mem = suspend_to_mem;
			}

			public Suspend_to_mem getSuspend_to_mem() {
				return this.suspend_to_mem;
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
		}
	}

	/****************************************************
	 * 
	 * Lifecycle
	 * 
	 *****************************************************/
	public static class Lifecycle {

		private Metadata metadata;

		private Managedsave managedsave;

		private Change_media change_media;

		private Nodedev_reset nodedev_reset;

		private Nwfilter_binding_create nwfilter_binding_create;

		private Detach_device detach_device;

		private Pool_autostart pool_autostart;

		private Autostart autostart;

		private Domifaddr domifaddr;

		private Migrate_postcopy migrate_postcopy;

		private Vol_upload vol_upload;

		private Nwfilter_undefine nwfilter_undefine;

		private Domif_setlink domif_setlink;

		private Snapshot_parent snapshot_parent;

		private Nodedev_reattach nodedev_reattach;

		private Pool_create pool_create;

		private Net_name net_name;

		private Domfsfreeze domfsfreeze;

		private Vol_name vol_name;

		private Secret_dumpxml secret_dumpxml;

		private Attach__interface attach__interface;

		private Edit edit;

		private Iface_define iface_define;

		private Emulatorpin emulatorpin;

		private Domcontrol domcontrol;

		private Destroy destroy;

		private Pool_destroy pool_destroy;

		private Migrate_getspeed migrate_getspeed;

		private Snapshot_info snapshot_info;

		private Iothreadinfo iothreadinfo;

		private Setmem setmem;

		private Domiftune domiftune;

		private Install install;

		private Reset reset;

		private Vol_create_as vol_create_as;

		private Snapshot_dumpxml snapshot_dumpxml;

		private Domname domname;

		private Domfsinfo domfsinfo;

		private Iface_dumpxml iface_dumpxml;

		private Detach_disk detach_disk;

		private Domfsthaw domfsthaw;

		private Pool_start pool_start;

		private Save save;

		private Pool_undefine pool_undefine;

		private Pool_delete pool_delete;

		private Vol_path vol_path;

		private Managedsave_edit managedsave_edit;

		private Screenshot screenshot;

		private Vol_dumpxml vol_dumpxml;

		private Find_storage_pool_sources_as find_storage_pool_sources_as;

		private Migrate_setspeed migrate_setspeed;

		private Ttyconsole ttyconsole;

		private Set_user_password set_user_password;

		private Blockresize blockresize;

		private Pool_edit pool_edit;

		private Vol_pool vol_pool;

		private Detach_device_alias detach_device_alias;

		private Vol_key vol_key;

		private Blkiotune blkiotune;

		private Nwfilter_binding_delete nwfilter_binding_delete;

		private Secret_set_value secret_set_value;

		private Pool_define pool_define;

		private Blockpull blockpull;

		private Migrate_setmaxdowntime migrate_setmaxdowntime;

		private Nwfilter_binding_dumpxml nwfilter_binding_dumpxml;

		private Resume resume;

		private Iface_name iface_name;

		private Iothreadpin iothreadpin;

		private Pool_refresh pool_refresh;

		private Migrate_getmaxdowntime migrate_getmaxdowntime;

		private Iface_mac iface_mac;

		private Domid domid;

		private Dumpxml dumpxml;

		private Blkdeviotune blkdeviotune;

		private Domuuid domuuid;

		private Nodedev_detach nodedev_detach;

		private Vol_wipe vol_wipe;

		private Pool_dumpxml pool_dumpxml;

		private Blockjob blockjob;

		private Iothreadadd iothreadadd;

		private Domblkstat domblkstat;

		private Send_key send_key;

		private Net_dhcp_leases net_dhcp_leases;

		private Nwfilter_define nwfilter_define;

		private Net_start net_start;

		private Vcpucount vcpucount;

		private Nodedev_destroy nodedev_destroy;

		private Attach_disk attach_disk;

		private Dominfo dominfo;

		private Net_undefine net_undefine;

		private Snapshot_create snapshot_create;

		private Domtime domtime;

		private Pool_define_as pool_define_as;

		private Schedinfo schedinfo;

		private Setvcpus setvcpus;

		private Blockcopy blockcopy;

		private Snapshot_current snapshot_current;

		private Domblkerror domblkerror;

		private Setvcpu setvcpu;

		private Migrate_compcache migrate_compcache;

		private Save_image_dumpxml save_image_dumpxml;

		private Qemu_monitor_command qemu_monitor_command;

		private Cpu_stats cpu_stats;

		private Vcpupin vcpupin;

		private Net_autostart net_autostart;

		private Create create;

		private Net_dumpxml net_dumpxml;

		private Numatune numatune;

		private Save_image_edit save_image_edit;

		private Net_edit net_edit;

		private Domxml_to_native domxml_to_native;

		private Qemu_attach qemu_attach;

		private Suspend suspend;

		private Snapshot_create_as snapshot_create_as;

		private Setmaxmem setmaxmem;

		private Iface_start iface_start;

		private Net_update net_update;

		private Detach__interface detach__interface;

		private Undefine undefine;

		private Vol_create_from vol_create_from;

		private Domrename domrename;

		private Vol_create vol_create;

		private Net_create net_create;

		private Domblkinfo domblkinfo;

		private Vcpuinfo vcpuinfo;

		private Managedsave_dumpxml managedsave_dumpxml;

		private Pool_create_as pool_create_as;

		private Secret_undefine secret_undefine;

		private Save_image_define save_image_define;

		private Shutdown shutdown;

		private Desc desc;

		private Migrate migrate;

		private Pool_build pool_build;

		private Inject_nmi inject_nmi;

		private Set_lifecycle_action set_lifecycle_action;

		private Blockcommit blockcommit;

		private Nwfilter_edit nwfilter_edit;

		private Snapshot_edit snapshot_edit;

		private Dompmwakeup dompmwakeup;

		private Vol_delete vol_delete;

		private Managedsave_remove managedsave_remove;

		private Nwfilter_dumpxml nwfilter_dumpxml;

		private Find_storage_pool_sources find_storage_pool_sources;

		private Domfstrim domfstrim;

		private Vol_info vol_info;

		private Secret_get_value secret_get_value;

		private Domifstat domifstat;

		private Send_process_signal send_process_signal;

		private Define define;

		private Secret_define secret_define;

		private Memtune memtune;

		private Nodedev_dumpxml nodedev_dumpxml;

		private Dump dump;

		private Domstate domstate;

		private Iothreaddel iothreaddel;

		private Dompmsuspend dompmsuspend;

		private Pool_uuid pool_uuid;

		private Managedsave_define managedsave_define;

		private Snapshot_delete snapshot_delete;

		private Guestvcpus guestvcpus;

		private Reboot reboot;

		private Vol_clone vol_clone;

		private Iface_edit iface_edit;

		private Vol_resize vol_resize;

		private Iface_bridge iface_bridge;

		private Nodedev_create nodedev_create;

		private Restore restore;

		private Net_info net_info;

		private Net_uuid net_uuid;

		private Lxc_enter_namespace lxc_enter_namespace;

		private Start start;

		private Domif_getlink domif_getlink;

		private Iface_undefine iface_undefine;

		private Iface_unbridge iface_unbridge;

		private Pool_name pool_name;

		private Domxml_from_native domxml_from_native;

		private Pool_info pool_info;

		private Vol_download vol_download;

		private Domjobabort domjobabort;

		private Dommemstat dommemstat;

		private Qemu_agent_command qemu_agent_command;

		private Update_device update_device;

		private Attach_device attach_device;

		private Iface_destroy iface_destroy;

		private Net_define net_define;

		private Domjobinfo domjobinfo;

		private Clone clone;

		private Net_destroy net_destroy;

		private Snapshot_revert snapshot_revert;

		public Lifecycle() {

		}

		public void setMetadata(Metadata metadata) {
			this.metadata = metadata;
		}

		public Metadata getMetadata() {
			return this.metadata;
		}

		public void setManagedsave(Managedsave managedsave) {
			this.managedsave = managedsave;
		}

		public Managedsave getManagedsave() {
			return this.managedsave;
		}

		public void setChange_media(Change_media change_media) {
			this.change_media = change_media;
		}

		public Change_media getChange_media() {
			return this.change_media;
		}

		public void setNodedev_reset(Nodedev_reset nodedev_reset) {
			this.nodedev_reset = nodedev_reset;
		}

		public Nodedev_reset getNodedev_reset() {
			return this.nodedev_reset;
		}

		public void setNwfilter_binding_create(Nwfilter_binding_create nwfilter_binding_create) {
			this.nwfilter_binding_create = nwfilter_binding_create;
		}

		public Nwfilter_binding_create getNwfilter_binding_create() {
			return this.nwfilter_binding_create;
		}

		public void setDetach_device(Detach_device detach_device) {
			this.detach_device = detach_device;
		}

		public Detach_device getDetach_device() {
			return this.detach_device;
		}

		public void setPool_autostart(Pool_autostart pool_autostart) {
			this.pool_autostart = pool_autostart;
		}

		public Pool_autostart getPool_autostart() {
			return this.pool_autostart;
		}

		public void setAutostart(Autostart autostart) {
			this.autostart = autostart;
		}

		public Autostart getAutostart() {
			return this.autostart;
		}

		public void setDomifaddr(Domifaddr domifaddr) {
			this.domifaddr = domifaddr;
		}

		public Domifaddr getDomifaddr() {
			return this.domifaddr;
		}

		public void setMigrate_postcopy(Migrate_postcopy migrate_postcopy) {
			this.migrate_postcopy = migrate_postcopy;
		}

		public Migrate_postcopy getMigrate_postcopy() {
			return this.migrate_postcopy;
		}

		public void setVol_upload(Vol_upload vol_upload) {
			this.vol_upload = vol_upload;
		}

		public Vol_upload getVol_upload() {
			return this.vol_upload;
		}

		public void setNwfilter_undefine(Nwfilter_undefine nwfilter_undefine) {
			this.nwfilter_undefine = nwfilter_undefine;
		}

		public Nwfilter_undefine getNwfilter_undefine() {
			return this.nwfilter_undefine;
		}

		public void setDomif_setlink(Domif_setlink domif_setlink) {
			this.domif_setlink = domif_setlink;
		}

		public Domif_setlink getDomif_setlink() {
			return this.domif_setlink;
		}

		public void setSnapshot_parent(Snapshot_parent snapshot_parent) {
			this.snapshot_parent = snapshot_parent;
		}

		public Snapshot_parent getSnapshot_parent() {
			return this.snapshot_parent;
		}

		public void setNodedev_reattach(Nodedev_reattach nodedev_reattach) {
			this.nodedev_reattach = nodedev_reattach;
		}

		public Nodedev_reattach getNodedev_reattach() {
			return this.nodedev_reattach;
		}

		public void setPool_create(Pool_create pool_create) {
			this.pool_create = pool_create;
		}

		public Pool_create getPool_create() {
			return this.pool_create;
		}

		public void setNet_name(Net_name net_name) {
			this.net_name = net_name;
		}

		public Net_name getNet_name() {
			return this.net_name;
		}

		public void setDomfsfreeze(Domfsfreeze domfsfreeze) {
			this.domfsfreeze = domfsfreeze;
		}

		public Domfsfreeze getDomfsfreeze() {
			return this.domfsfreeze;
		}

		public void setVol_name(Vol_name vol_name) {
			this.vol_name = vol_name;
		}

		public Vol_name getVol_name() {
			return this.vol_name;
		}

		public void setSecret_dumpxml(Secret_dumpxml secret_dumpxml) {
			this.secret_dumpxml = secret_dumpxml;
		}

		public Secret_dumpxml getSecret_dumpxml() {
			return this.secret_dumpxml;
		}

		public void setAttach__interface(Attach__interface attach__interface) {
			this.attach__interface = attach__interface;
		}

		public Attach__interface getAttach__interface() {
			return this.attach__interface;
		}

		public void setEdit(Edit edit) {
			this.edit = edit;
		}

		public Edit getEdit() {
			return this.edit;
		}

		public void setIface_define(Iface_define iface_define) {
			this.iface_define = iface_define;
		}

		public Iface_define getIface_define() {
			return this.iface_define;
		}

		public void setEmulatorpin(Emulatorpin emulatorpin) {
			this.emulatorpin = emulatorpin;
		}

		public Emulatorpin getEmulatorpin() {
			return this.emulatorpin;
		}

		public void setDomcontrol(Domcontrol domcontrol) {
			this.domcontrol = domcontrol;
		}

		public Domcontrol getDomcontrol() {
			return this.domcontrol;
		}

		public void setDestroy(Destroy destroy) {
			this.destroy = destroy;
		}

		public Destroy getDestroy() {
			return this.destroy;
		}

		public void setPool_destroy(Pool_destroy pool_destroy) {
			this.pool_destroy = pool_destroy;
		}

		public Pool_destroy getPool_destroy() {
			return this.pool_destroy;
		}

		public void setMigrate_getspeed(Migrate_getspeed migrate_getspeed) {
			this.migrate_getspeed = migrate_getspeed;
		}

		public Migrate_getspeed getMigrate_getspeed() {
			return this.migrate_getspeed;
		}

		public void setSnapshot_info(Snapshot_info snapshot_info) {
			this.snapshot_info = snapshot_info;
		}

		public Snapshot_info getSnapshot_info() {
			return this.snapshot_info;
		}

		public void setIothreadinfo(Iothreadinfo iothreadinfo) {
			this.iothreadinfo = iothreadinfo;
		}

		public Iothreadinfo getIothreadinfo() {
			return this.iothreadinfo;
		}

		public void setSetmem(Setmem setmem) {
			this.setmem = setmem;
		}

		public Setmem getSetmem() {
			return this.setmem;
		}

		public void setDomiftune(Domiftune domiftune) {
			this.domiftune = domiftune;
		}

		public Domiftune getDomiftune() {
			return this.domiftune;
		}

		public void setInstall(Install install) {
			this.install = install;
		}

		public Install getInstall() {
			return this.install;
		}

		public void setReset(Reset reset) {
			this.reset = reset;
		}

		public Reset getReset() {
			return this.reset;
		}

		public void setVol_create_as(Vol_create_as vol_create_as) {
			this.vol_create_as = vol_create_as;
		}

		public Vol_create_as getVol_create_as() {
			return this.vol_create_as;
		}

		public void setSnapshot_dumpxml(Snapshot_dumpxml snapshot_dumpxml) {
			this.snapshot_dumpxml = snapshot_dumpxml;
		}

		public Snapshot_dumpxml getSnapshot_dumpxml() {
			return this.snapshot_dumpxml;
		}

		public void setDomname(Domname domname) {
			this.domname = domname;
		}

		public Domname getDomname() {
			return this.domname;
		}

		public void setDomfsinfo(Domfsinfo domfsinfo) {
			this.domfsinfo = domfsinfo;
		}

		public Domfsinfo getDomfsinfo() {
			return this.domfsinfo;
		}

		public void setIface_dumpxml(Iface_dumpxml iface_dumpxml) {
			this.iface_dumpxml = iface_dumpxml;
		}

		public Iface_dumpxml getIface_dumpxml() {
			return this.iface_dumpxml;
		}

		public void setDetach_disk(Detach_disk detach_disk) {
			this.detach_disk = detach_disk;
		}

		public Detach_disk getDetach_disk() {
			return this.detach_disk;
		}

		public void setDomfsthaw(Domfsthaw domfsthaw) {
			this.domfsthaw = domfsthaw;
		}

		public Domfsthaw getDomfsthaw() {
			return this.domfsthaw;
		}

		public void setPool_start(Pool_start pool_start) {
			this.pool_start = pool_start;
		}

		public Pool_start getPool_start() {
			return this.pool_start;
		}

		public void setSave(Save save) {
			this.save = save;
		}

		public Save getSave() {
			return this.save;
		}

		public void setPool_undefine(Pool_undefine pool_undefine) {
			this.pool_undefine = pool_undefine;
		}

		public Pool_undefine getPool_undefine() {
			return this.pool_undefine;
		}

		public void setPool_delete(Pool_delete pool_delete) {
			this.pool_delete = pool_delete;
		}

		public Pool_delete getPool_delete() {
			return this.pool_delete;
		}

		public void setVol_path(Vol_path vol_path) {
			this.vol_path = vol_path;
		}

		public Vol_path getVol_path() {
			return this.vol_path;
		}

		public void setManagedsave_edit(Managedsave_edit managedsave_edit) {
			this.managedsave_edit = managedsave_edit;
		}

		public Managedsave_edit getManagedsave_edit() {
			return this.managedsave_edit;
		}

		public void setScreenshot(Screenshot screenshot) {
			this.screenshot = screenshot;
		}

		public Screenshot getScreenshot() {
			return this.screenshot;
		}

		public void setVol_dumpxml(Vol_dumpxml vol_dumpxml) {
			this.vol_dumpxml = vol_dumpxml;
		}

		public Vol_dumpxml getVol_dumpxml() {
			return this.vol_dumpxml;
		}

		public void setFind_storage_pool_sources_as(Find_storage_pool_sources_as find_storage_pool_sources_as) {
			this.find_storage_pool_sources_as = find_storage_pool_sources_as;
		}

		public Find_storage_pool_sources_as getFind_storage_pool_sources_as() {
			return this.find_storage_pool_sources_as;
		}

		public void setMigrate_setspeed(Migrate_setspeed migrate_setspeed) {
			this.migrate_setspeed = migrate_setspeed;
		}

		public Migrate_setspeed getMigrate_setspeed() {
			return this.migrate_setspeed;
		}

		public void setTtyconsole(Ttyconsole ttyconsole) {
			this.ttyconsole = ttyconsole;
		}

		public Ttyconsole getTtyconsole() {
			return this.ttyconsole;
		}

		public void setSet_user_password(Set_user_password set_user_password) {
			this.set_user_password = set_user_password;
		}

		public Set_user_password getSet_user_password() {
			return this.set_user_password;
		}

		public void setBlockresize(Blockresize blockresize) {
			this.blockresize = blockresize;
		}

		public Blockresize getBlockresize() {
			return this.blockresize;
		}

		public void setPool_edit(Pool_edit pool_edit) {
			this.pool_edit = pool_edit;
		}

		public Pool_edit getPool_edit() {
			return this.pool_edit;
		}

		public void setVol_pool(Vol_pool vol_pool) {
			this.vol_pool = vol_pool;
		}

		public Vol_pool getVol_pool() {
			return this.vol_pool;
		}

		public void setDetach_device_alias(Detach_device_alias detach_device_alias) {
			this.detach_device_alias = detach_device_alias;
		}

		public Detach_device_alias getDetach_device_alias() {
			return this.detach_device_alias;
		}

		public void setVol_key(Vol_key vol_key) {
			this.vol_key = vol_key;
		}

		public Vol_key getVol_key() {
			return this.vol_key;
		}

		public void setBlkiotune(Blkiotune blkiotune) {
			this.blkiotune = blkiotune;
		}

		public Blkiotune getBlkiotune() {
			return this.blkiotune;
		}

		public void setNwfilter_binding_delete(Nwfilter_binding_delete nwfilter_binding_delete) {
			this.nwfilter_binding_delete = nwfilter_binding_delete;
		}

		public Nwfilter_binding_delete getNwfilter_binding_delete() {
			return this.nwfilter_binding_delete;
		}

		public void setSecret_set_value(Secret_set_value secret_set_value) {
			this.secret_set_value = secret_set_value;
		}

		public Secret_set_value getSecret_set_value() {
			return this.secret_set_value;
		}

		public void setPool_define(Pool_define pool_define) {
			this.pool_define = pool_define;
		}

		public Pool_define getPool_define() {
			return this.pool_define;
		}

		public void setBlockpull(Blockpull blockpull) {
			this.blockpull = blockpull;
		}

		public Blockpull getBlockpull() {
			return this.blockpull;
		}

		public void setMigrate_setmaxdowntime(Migrate_setmaxdowntime migrate_setmaxdowntime) {
			this.migrate_setmaxdowntime = migrate_setmaxdowntime;
		}

		public Migrate_setmaxdowntime getMigrate_setmaxdowntime() {
			return this.migrate_setmaxdowntime;
		}

		public void setNwfilter_binding_dumpxml(Nwfilter_binding_dumpxml nwfilter_binding_dumpxml) {
			this.nwfilter_binding_dumpxml = nwfilter_binding_dumpxml;
		}

		public Nwfilter_binding_dumpxml getNwfilter_binding_dumpxml() {
			return this.nwfilter_binding_dumpxml;
		}

		public void setResume(Resume resume) {
			this.resume = resume;
		}

		public Resume getResume() {
			return this.resume;
		}

		public void setIface_name(Iface_name iface_name) {
			this.iface_name = iface_name;
		}

		public Iface_name getIface_name() {
			return this.iface_name;
		}

		public void setIothreadpin(Iothreadpin iothreadpin) {
			this.iothreadpin = iothreadpin;
		}

		public Iothreadpin getIothreadpin() {
			return this.iothreadpin;
		}

		public void setPool_refresh(Pool_refresh pool_refresh) {
			this.pool_refresh = pool_refresh;
		}

		public Pool_refresh getPool_refresh() {
			return this.pool_refresh;
		}

		public void setMigrate_getmaxdowntime(Migrate_getmaxdowntime migrate_getmaxdowntime) {
			this.migrate_getmaxdowntime = migrate_getmaxdowntime;
		}

		public Migrate_getmaxdowntime getMigrate_getmaxdowntime() {
			return this.migrate_getmaxdowntime;
		}

		public void setIface_mac(Iface_mac iface_mac) {
			this.iface_mac = iface_mac;
		}

		public Iface_mac getIface_mac() {
			return this.iface_mac;
		}

		public void setDomid(Domid domid) {
			this.domid = domid;
		}

		public Domid getDomid() {
			return this.domid;
		}

		public void setDumpxml(Dumpxml dumpxml) {
			this.dumpxml = dumpxml;
		}

		public Dumpxml getDumpxml() {
			return this.dumpxml;
		}

		public void setBlkdeviotune(Blkdeviotune blkdeviotune) {
			this.blkdeviotune = blkdeviotune;
		}

		public Blkdeviotune getBlkdeviotune() {
			return this.blkdeviotune;
		}

		public void setDomuuid(Domuuid domuuid) {
			this.domuuid = domuuid;
		}

		public Domuuid getDomuuid() {
			return this.domuuid;
		}

		public void setNodedev_detach(Nodedev_detach nodedev_detach) {
			this.nodedev_detach = nodedev_detach;
		}

		public Nodedev_detach getNodedev_detach() {
			return this.nodedev_detach;
		}

		public void setVol_wipe(Vol_wipe vol_wipe) {
			this.vol_wipe = vol_wipe;
		}

		public Vol_wipe getVol_wipe() {
			return this.vol_wipe;
		}

		public void setPool_dumpxml(Pool_dumpxml pool_dumpxml) {
			this.pool_dumpxml = pool_dumpxml;
		}

		public Pool_dumpxml getPool_dumpxml() {
			return this.pool_dumpxml;
		}

		public void setBlockjob(Blockjob blockjob) {
			this.blockjob = blockjob;
		}

		public Blockjob getBlockjob() {
			return this.blockjob;
		}

		public void setIothreadadd(Iothreadadd iothreadadd) {
			this.iothreadadd = iothreadadd;
		}

		public Iothreadadd getIothreadadd() {
			return this.iothreadadd;
		}

		public void setDomblkstat(Domblkstat domblkstat) {
			this.domblkstat = domblkstat;
		}

		public Domblkstat getDomblkstat() {
			return this.domblkstat;
		}

		public void setSend_key(Send_key send_key) {
			this.send_key = send_key;
		}

		public Send_key getSend_key() {
			return this.send_key;
		}

		public void setNet_dhcp_leases(Net_dhcp_leases net_dhcp_leases) {
			this.net_dhcp_leases = net_dhcp_leases;
		}

		public Net_dhcp_leases getNet_dhcp_leases() {
			return this.net_dhcp_leases;
		}

		public void setNwfilter_define(Nwfilter_define nwfilter_define) {
			this.nwfilter_define = nwfilter_define;
		}

		public Nwfilter_define getNwfilter_define() {
			return this.nwfilter_define;
		}

		public void setNet_start(Net_start net_start) {
			this.net_start = net_start;
		}

		public Net_start getNet_start() {
			return this.net_start;
		}

		public void setVcpucount(Vcpucount vcpucount) {
			this.vcpucount = vcpucount;
		}

		public Vcpucount getVcpucount() {
			return this.vcpucount;
		}

		public void setNodedev_destroy(Nodedev_destroy nodedev_destroy) {
			this.nodedev_destroy = nodedev_destroy;
		}

		public Nodedev_destroy getNodedev_destroy() {
			return this.nodedev_destroy;
		}

		public void setAttach_disk(Attach_disk attach_disk) {
			this.attach_disk = attach_disk;
		}

		public Attach_disk getAttach_disk() {
			return this.attach_disk;
		}

		public void setDominfo(Dominfo dominfo) {
			this.dominfo = dominfo;
		}

		public Dominfo getDominfo() {
			return this.dominfo;
		}

		public void setNet_undefine(Net_undefine net_undefine) {
			this.net_undefine = net_undefine;
		}

		public Net_undefine getNet_undefine() {
			return this.net_undefine;
		}

		public void setSnapshot_create(Snapshot_create snapshot_create) {
			this.snapshot_create = snapshot_create;
		}

		public Snapshot_create getSnapshot_create() {
			return this.snapshot_create;
		}

		public void setDomtime(Domtime domtime) {
			this.domtime = domtime;
		}

		public Domtime getDomtime() {
			return this.domtime;
		}

		public void setPool_define_as(Pool_define_as pool_define_as) {
			this.pool_define_as = pool_define_as;
		}

		public Pool_define_as getPool_define_as() {
			return this.pool_define_as;
		}

		public void setSchedinfo(Schedinfo schedinfo) {
			this.schedinfo = schedinfo;
		}

		public Schedinfo getSchedinfo() {
			return this.schedinfo;
		}

		public void setSetvcpus(Setvcpus setvcpus) {
			this.setvcpus = setvcpus;
		}

		public Setvcpus getSetvcpus() {
			return this.setvcpus;
		}

		public void setBlockcopy(Blockcopy blockcopy) {
			this.blockcopy = blockcopy;
		}

		public Blockcopy getBlockcopy() {
			return this.blockcopy;
		}

		public void setSnapshot_current(Snapshot_current snapshot_current) {
			this.snapshot_current = snapshot_current;
		}

		public Snapshot_current getSnapshot_current() {
			return this.snapshot_current;
		}

		public void setDomblkerror(Domblkerror domblkerror) {
			this.domblkerror = domblkerror;
		}

		public Domblkerror getDomblkerror() {
			return this.domblkerror;
		}

		public void setSetvcpu(Setvcpu setvcpu) {
			this.setvcpu = setvcpu;
		}

		public Setvcpu getSetvcpu() {
			return this.setvcpu;
		}

		public void setMigrate_compcache(Migrate_compcache migrate_compcache) {
			this.migrate_compcache = migrate_compcache;
		}

		public Migrate_compcache getMigrate_compcache() {
			return this.migrate_compcache;
		}

		public void setSave_image_dumpxml(Save_image_dumpxml save_image_dumpxml) {
			this.save_image_dumpxml = save_image_dumpxml;
		}

		public Save_image_dumpxml getSave_image_dumpxml() {
			return this.save_image_dumpxml;
		}

		public void setQemu_monitor_command(Qemu_monitor_command qemu_monitor_command) {
			this.qemu_monitor_command = qemu_monitor_command;
		}

		public Qemu_monitor_command getQemu_monitor_command() {
			return this.qemu_monitor_command;
		}

		public void setCpu_stats(Cpu_stats cpu_stats) {
			this.cpu_stats = cpu_stats;
		}

		public Cpu_stats getCpu_stats() {
			return this.cpu_stats;
		}

		public void setVcpupin(Vcpupin vcpupin) {
			this.vcpupin = vcpupin;
		}

		public Vcpupin getVcpupin() {
			return this.vcpupin;
		}

		public void setNet_autostart(Net_autostart net_autostart) {
			this.net_autostart = net_autostart;
		}

		public Net_autostart getNet_autostart() {
			return this.net_autostart;
		}

		public void setCreate(Create create) {
			this.create = create;
		}

		public Create getCreate() {
			return this.create;
		}

		public void setNet_dumpxml(Net_dumpxml net_dumpxml) {
			this.net_dumpxml = net_dumpxml;
		}

		public Net_dumpxml getNet_dumpxml() {
			return this.net_dumpxml;
		}

		public void setNumatune(Numatune numatune) {
			this.numatune = numatune;
		}

		public Numatune getNumatune() {
			return this.numatune;
		}

		public void setSave_image_edit(Save_image_edit save_image_edit) {
			this.save_image_edit = save_image_edit;
		}

		public Save_image_edit getSave_image_edit() {
			return this.save_image_edit;
		}

		public void setNet_edit(Net_edit net_edit) {
			this.net_edit = net_edit;
		}

		public Net_edit getNet_edit() {
			return this.net_edit;
		}

		public void setDomxml_to_native(Domxml_to_native domxml_to_native) {
			this.domxml_to_native = domxml_to_native;
		}

		public Domxml_to_native getDomxml_to_native() {
			return this.domxml_to_native;
		}

		public void setQemu_attach(Qemu_attach qemu_attach) {
			this.qemu_attach = qemu_attach;
		}

		public Qemu_attach getQemu_attach() {
			return this.qemu_attach;
		}

		public void setSuspend(Suspend suspend) {
			this.suspend = suspend;
		}

		public Suspend getSuspend() {
			return this.suspend;
		}

		public void setSnapshot_create_as(Snapshot_create_as snapshot_create_as) {
			this.snapshot_create_as = snapshot_create_as;
		}

		public Snapshot_create_as getSnapshot_create_as() {
			return this.snapshot_create_as;
		}

		public void setSetmaxmem(Setmaxmem setmaxmem) {
			this.setmaxmem = setmaxmem;
		}

		public Setmaxmem getSetmaxmem() {
			return this.setmaxmem;
		}

		public void setIface_start(Iface_start iface_start) {
			this.iface_start = iface_start;
		}

		public Iface_start getIface_start() {
			return this.iface_start;
		}

		public void setNet_update(Net_update net_update) {
			this.net_update = net_update;
		}

		public Net_update getNet_update() {
			return this.net_update;
		}

		public void setDetach__interface(Detach__interface detach__interface) {
			this.detach__interface = detach__interface;
		}

		public Detach__interface getDetach__interface() {
			return this.detach__interface;
		}

		public void setUndefine(Undefine undefine) {
			this.undefine = undefine;
		}

		public Undefine getUndefine() {
			return this.undefine;
		}

		public void setVol_create_from(Vol_create_from vol_create_from) {
			this.vol_create_from = vol_create_from;
		}

		public Vol_create_from getVol_create_from() {
			return this.vol_create_from;
		}

		public void setDomrename(Domrename domrename) {
			this.domrename = domrename;
		}

		public Domrename getDomrename() {
			return this.domrename;
		}

		public void setVol_create(Vol_create vol_create) {
			this.vol_create = vol_create;
		}

		public Vol_create getVol_create() {
			return this.vol_create;
		}

		public void setNet_create(Net_create net_create) {
			this.net_create = net_create;
		}

		public Net_create getNet_create() {
			return this.net_create;
		}

		public void setDomblkinfo(Domblkinfo domblkinfo) {
			this.domblkinfo = domblkinfo;
		}

		public Domblkinfo getDomblkinfo() {
			return this.domblkinfo;
		}

		public void setVcpuinfo(Vcpuinfo vcpuinfo) {
			this.vcpuinfo = vcpuinfo;
		}

		public Vcpuinfo getVcpuinfo() {
			return this.vcpuinfo;
		}

		public void setManagedsave_dumpxml(Managedsave_dumpxml managedsave_dumpxml) {
			this.managedsave_dumpxml = managedsave_dumpxml;
		}

		public Managedsave_dumpxml getManagedsave_dumpxml() {
			return this.managedsave_dumpxml;
		}

		public void setPool_create_as(Pool_create_as pool_create_as) {
			this.pool_create_as = pool_create_as;
		}

		public Pool_create_as getPool_create_as() {
			return this.pool_create_as;
		}

		public void setSecret_undefine(Secret_undefine secret_undefine) {
			this.secret_undefine = secret_undefine;
		}

		public Secret_undefine getSecret_undefine() {
			return this.secret_undefine;
		}

		public void setSave_image_define(Save_image_define save_image_define) {
			this.save_image_define = save_image_define;
		}

		public Save_image_define getSave_image_define() {
			return this.save_image_define;
		}

		public void setShutdown(Shutdown shutdown) {
			this.shutdown = shutdown;
		}

		public Shutdown getShutdown() {
			return this.shutdown;
		}

		public void setDesc(Desc desc) {
			this.desc = desc;
		}

		public Desc getDesc() {
			return this.desc;
		}

		public void setMigrate(Migrate migrate) {
			this.migrate = migrate;
		}

		public Migrate getMigrate() {
			return this.migrate;
		}

		public void setPool_build(Pool_build pool_build) {
			this.pool_build = pool_build;
		}

		public Pool_build getPool_build() {
			return this.pool_build;
		}

		public void setInject_nmi(Inject_nmi inject_nmi) {
			this.inject_nmi = inject_nmi;
		}

		public Inject_nmi getInject_nmi() {
			return this.inject_nmi;
		}

		public void setSet_lifecycle_action(Set_lifecycle_action set_lifecycle_action) {
			this.set_lifecycle_action = set_lifecycle_action;
		}

		public Set_lifecycle_action getSet_lifecycle_action() {
			return this.set_lifecycle_action;
		}

		public void setBlockcommit(Blockcommit blockcommit) {
			this.blockcommit = blockcommit;
		}

		public Blockcommit getBlockcommit() {
			return this.blockcommit;
		}

		public void setNwfilter_edit(Nwfilter_edit nwfilter_edit) {
			this.nwfilter_edit = nwfilter_edit;
		}

		public Nwfilter_edit getNwfilter_edit() {
			return this.nwfilter_edit;
		}

		public void setSnapshot_edit(Snapshot_edit snapshot_edit) {
			this.snapshot_edit = snapshot_edit;
		}

		public Snapshot_edit getSnapshot_edit() {
			return this.snapshot_edit;
		}

		public void setDompmwakeup(Dompmwakeup dompmwakeup) {
			this.dompmwakeup = dompmwakeup;
		}

		public Dompmwakeup getDompmwakeup() {
			return this.dompmwakeup;
		}

		public void setVol_delete(Vol_delete vol_delete) {
			this.vol_delete = vol_delete;
		}

		public Vol_delete getVol_delete() {
			return this.vol_delete;
		}

		public void setManagedsave_remove(Managedsave_remove managedsave_remove) {
			this.managedsave_remove = managedsave_remove;
		}

		public Managedsave_remove getManagedsave_remove() {
			return this.managedsave_remove;
		}

		public void setNwfilter_dumpxml(Nwfilter_dumpxml nwfilter_dumpxml) {
			this.nwfilter_dumpxml = nwfilter_dumpxml;
		}

		public Nwfilter_dumpxml getNwfilter_dumpxml() {
			return this.nwfilter_dumpxml;
		}

		public void setFind_storage_pool_sources(Find_storage_pool_sources find_storage_pool_sources) {
			this.find_storage_pool_sources = find_storage_pool_sources;
		}

		public Find_storage_pool_sources getFind_storage_pool_sources() {
			return this.find_storage_pool_sources;
		}

		public void setDomfstrim(Domfstrim domfstrim) {
			this.domfstrim = domfstrim;
		}

		public Domfstrim getDomfstrim() {
			return this.domfstrim;
		}

		public void setVol_info(Vol_info vol_info) {
			this.vol_info = vol_info;
		}

		public Vol_info getVol_info() {
			return this.vol_info;
		}

		public void setSecret_get_value(Secret_get_value secret_get_value) {
			this.secret_get_value = secret_get_value;
		}

		public Secret_get_value getSecret_get_value() {
			return this.secret_get_value;
		}

		public void setDomifstat(Domifstat domifstat) {
			this.domifstat = domifstat;
		}

		public Domifstat getDomifstat() {
			return this.domifstat;
		}

		public void setSend_process_signal(Send_process_signal send_process_signal) {
			this.send_process_signal = send_process_signal;
		}

		public Send_process_signal getSend_process_signal() {
			return this.send_process_signal;
		}

		public void setDefine(Define define) {
			this.define = define;
		}

		public Define getDefine() {
			return this.define;
		}

		public void setSecret_define(Secret_define secret_define) {
			this.secret_define = secret_define;
		}

		public Secret_define getSecret_define() {
			return this.secret_define;
		}

		public void setMemtune(Memtune memtune) {
			this.memtune = memtune;
		}

		public Memtune getMemtune() {
			return this.memtune;
		}

		public void setNodedev_dumpxml(Nodedev_dumpxml nodedev_dumpxml) {
			this.nodedev_dumpxml = nodedev_dumpxml;
		}

		public Nodedev_dumpxml getNodedev_dumpxml() {
			return this.nodedev_dumpxml;
		}

		public void setDump(Dump dump) {
			this.dump = dump;
		}

		public Dump getDump() {
			return this.dump;
		}

		public void setDomstate(Domstate domstate) {
			this.domstate = domstate;
		}

		public Domstate getDomstate() {
			return this.domstate;
		}

		public void setIothreaddel(Iothreaddel iothreaddel) {
			this.iothreaddel = iothreaddel;
		}

		public Iothreaddel getIothreaddel() {
			return this.iothreaddel;
		}

		public void setDompmsuspend(Dompmsuspend dompmsuspend) {
			this.dompmsuspend = dompmsuspend;
		}

		public Dompmsuspend getDompmsuspend() {
			return this.dompmsuspend;
		}

		public void setPool_uuid(Pool_uuid pool_uuid) {
			this.pool_uuid = pool_uuid;
		}

		public Pool_uuid getPool_uuid() {
			return this.pool_uuid;
		}

		public void setManagedsave_define(Managedsave_define managedsave_define) {
			this.managedsave_define = managedsave_define;
		}

		public Managedsave_define getManagedsave_define() {
			return this.managedsave_define;
		}

		public void setSnapshot_delete(Snapshot_delete snapshot_delete) {
			this.snapshot_delete = snapshot_delete;
		}

		public Snapshot_delete getSnapshot_delete() {
			return this.snapshot_delete;
		}

		public void setGuestvcpus(Guestvcpus guestvcpus) {
			this.guestvcpus = guestvcpus;
		}

		public Guestvcpus getGuestvcpus() {
			return this.guestvcpus;
		}

		public void setReboot(Reboot reboot) {
			this.reboot = reboot;
		}

		public Reboot getReboot() {
			return this.reboot;
		}

		public void setVol_clone(Vol_clone vol_clone) {
			this.vol_clone = vol_clone;
		}

		public Vol_clone getVol_clone() {
			return this.vol_clone;
		}

		public void setIface_edit(Iface_edit iface_edit) {
			this.iface_edit = iface_edit;
		}

		public Iface_edit getIface_edit() {
			return this.iface_edit;
		}

		public void setVol_resize(Vol_resize vol_resize) {
			this.vol_resize = vol_resize;
		}

		public Vol_resize getVol_resize() {
			return this.vol_resize;
		}

		public void setIface_bridge(Iface_bridge iface_bridge) {
			this.iface_bridge = iface_bridge;
		}

		public Iface_bridge getIface_bridge() {
			return this.iface_bridge;
		}

		public void setNodedev_create(Nodedev_create nodedev_create) {
			this.nodedev_create = nodedev_create;
		}

		public Nodedev_create getNodedev_create() {
			return this.nodedev_create;
		}

		public void setRestore(Restore restore) {
			this.restore = restore;
		}

		public Restore getRestore() {
			return this.restore;
		}

		public void setNet_info(Net_info net_info) {
			this.net_info = net_info;
		}

		public Net_info getNet_info() {
			return this.net_info;
		}

		public void setNet_uuid(Net_uuid net_uuid) {
			this.net_uuid = net_uuid;
		}

		public Net_uuid getNet_uuid() {
			return this.net_uuid;
		}

		public void setLxc_enter_namespace(Lxc_enter_namespace lxc_enter_namespace) {
			this.lxc_enter_namespace = lxc_enter_namespace;
		}

		public Lxc_enter_namespace getLxc_enter_namespace() {
			return this.lxc_enter_namespace;
		}

		public void setStart(Start start) {
			this.start = start;
		}

		public Start getStart() {
			return this.start;
		}

		public void setDomif_getlink(Domif_getlink domif_getlink) {
			this.domif_getlink = domif_getlink;
		}

		public Domif_getlink getDomif_getlink() {
			return this.domif_getlink;
		}

		public void setIface_undefine(Iface_undefine iface_undefine) {
			this.iface_undefine = iface_undefine;
		}

		public Iface_undefine getIface_undefine() {
			return this.iface_undefine;
		}

		public void setIface_unbridge(Iface_unbridge iface_unbridge) {
			this.iface_unbridge = iface_unbridge;
		}

		public Iface_unbridge getIface_unbridge() {
			return this.iface_unbridge;
		}

		public void setPool_name(Pool_name pool_name) {
			this.pool_name = pool_name;
		}

		public Pool_name getPool_name() {
			return this.pool_name;
		}

		public void setDomxml_from_native(Domxml_from_native domxml_from_native) {
			this.domxml_from_native = domxml_from_native;
		}

		public Domxml_from_native getDomxml_from_native() {
			return this.domxml_from_native;
		}

		public void setPool_info(Pool_info pool_info) {
			this.pool_info = pool_info;
		}

		public Pool_info getPool_info() {
			return this.pool_info;
		}

		public void setVol_download(Vol_download vol_download) {
			this.vol_download = vol_download;
		}

		public Vol_download getVol_download() {
			return this.vol_download;
		}

		public void setDomjobabort(Domjobabort domjobabort) {
			this.domjobabort = domjobabort;
		}

		public Domjobabort getDomjobabort() {
			return this.domjobabort;
		}

		public void setDommemstat(Dommemstat dommemstat) {
			this.dommemstat = dommemstat;
		}

		public Dommemstat getDommemstat() {
			return this.dommemstat;
		}

		public void setQemu_agent_command(Qemu_agent_command qemu_agent_command) {
			this.qemu_agent_command = qemu_agent_command;
		}

		public Qemu_agent_command getQemu_agent_command() {
			return this.qemu_agent_command;
		}

		public void setUpdate_device(Update_device update_device) {
			this.update_device = update_device;
		}

		public Update_device getUpdate_device() {
			return this.update_device;
		}

		public void setAttach_device(Attach_device attach_device) {
			this.attach_device = attach_device;
		}

		public Attach_device getAttach_device() {
			return this.attach_device;
		}

		public void setIface_destroy(Iface_destroy iface_destroy) {
			this.iface_destroy = iface_destroy;
		}

		public Iface_destroy getIface_destroy() {
			return this.iface_destroy;
		}

		public void setNet_define(Net_define net_define) {
			this.net_define = net_define;
		}

		public Net_define getNet_define() {
			return this.net_define;
		}

		public void setDomjobinfo(Domjobinfo domjobinfo) {
			this.domjobinfo = domjobinfo;
		}

		public Domjobinfo getDomjobinfo() {
			return this.domjobinfo;
		}

		public void setClone(Clone clone) {
			this.clone = clone;
		}

		public Clone getClone() {
			return this.clone;
		}

		public void setNet_destroy(Net_destroy net_destroy) {
			this.net_destroy = net_destroy;
		}

		public Net_destroy getNet_destroy() {
			return this.net_destroy;
		}

		public void setSnapshot_revert(Snapshot_revert snapshot_revert) {
			this.snapshot_revert = snapshot_revert;
		}

		public Snapshot_revert getSnapshot_revert() {
			return this.snapshot_revert;
		}

		public static class Metadata {

			private String domain;

			private String uri;

			public Metadata() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void setUri(String uri) {
				this.uri = uri;
			}

			public String getUri() {
				return this.uri;
			}
		}

		public static class Managedsave {

			private String domain;

			public Managedsave() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Change_media {

			private String path;

			private String domain;

			public Change_media() {

			}

			public void setPath(String path) {
				this.path = path;
			}

			public String getPath() {
				return this.path;
			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Nodedev_reset {

			private String device;

			public Nodedev_reset() {

			}

			public void setDevice(String device) {
				this.device = device;
			}

			public String getDevice() {
				return this.device;
			}
		}

		public static class Nwfilter_binding_create {

			private String file;

			public Nwfilter_binding_create() {

			}

			public void setFile(String file) {
				this.file = file;
			}

			public String getFile() {
				return this.file;
			}
		}

		public static class Detach_device {

			private String file;

			private String domain;

			public Detach_device() {

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
		}

		public static class Pool_autostart {

			private String pool;

			public Pool_autostart() {

			}

			public void setPool(String pool) {
				this.pool = pool;
			}

			public String getPool() {
				return this.pool;
			}
		}

		public static class Autostart {

			private String domain;

			public Autostart() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Domifaddr {

			private String domain;

			public Domifaddr() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Migrate_postcopy {

			private String domain;

			public Migrate_postcopy() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Vol_upload {

			private String vol;

			private String file;

			public Vol_upload() {

			}

			public void setVol(String vol) {
				this.vol = vol;
			}

			public String getVol() {
				return this.vol;
			}

			public void setFile(String file) {
				this.file = file;
			}

			public String getFile() {
				return this.file;
			}
		}

		public static class Nwfilter_undefine {

			private String nwfilter;

			public Nwfilter_undefine() {

			}

			public void setNwfilter(String nwfilter) {
				this.nwfilter = nwfilter;
			}

			public String getNwfilter() {
				return this.nwfilter;
			}
		}

		public static class Domif_setlink {

			private String domain;

			private String state;

			private String _interface;

			public Domif_setlink() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void setState(String state) {
				this.state = state;
			}

			public String getState() {
				return this.state;
			}

			public void set_interface(String _interface) {
				this._interface = _interface;
			}

			public String get_interface() {
				return this._interface;
			}
		}

		public static class Snapshot_parent {

			private String domain;

			public Snapshot_parent() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Nodedev_reattach {

			private String device;

			public Nodedev_reattach() {

			}

			public void setDevice(String device) {
				this.device = device;
			}

			public String getDevice() {
				return this.device;
			}
		}

		public static class Pool_create {

			private String file;

			public Pool_create() {

			}

			public void setFile(String file) {
				this.file = file;
			}

			public String getFile() {
				return this.file;
			}
		}

		public static class Net_name {

			private String network;

			public Net_name() {

			}

			public void setNetwork(String network) {
				this.network = network;
			}

			public String getNetwork() {
				return this.network;
			}
		}

		public static class Domfsfreeze {

			private String domain;

			public Domfsfreeze() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Vol_name {

			private String vol;

			public Vol_name() {

			}

			public void setVol(String vol) {
				this.vol = vol;
			}

			public String getVol() {
				return this.vol;
			}
		}

		public static class Secret_dumpxml {

			private String secret;

			public Secret_dumpxml() {

			}

			public void setSecret(String secret) {
				this.secret = secret;
			}

			public String getSecret() {
				return this.secret;
			}
		}

		public static class Attach__interface {

			private String domain;

			private String source;

			private String type;

			public Attach__interface() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
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
		}

		public static class Edit {

			private String domain;

			public Edit() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Iface_define {

			private String file;

			public Iface_define() {

			}

			public void setFile(String file) {
				this.file = file;
			}

			public String getFile() {
				return this.file;
			}
		}

		public static class Emulatorpin {

			private String domain;

			public Emulatorpin() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Domcontrol {

			private String domain;

			public Domcontrol() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Destroy {

			private String domain;

			public Destroy() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Pool_destroy {

			private String pool;

			public Pool_destroy() {

			}

			public void setPool(String pool) {
				this.pool = pool;
			}

			public String getPool() {
				return this.pool;
			}
		}

		public static class Migrate_getspeed {

			private String domain;

			public Migrate_getspeed() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Snapshot_info {

			private String domain;

			public Snapshot_info() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Iothreadinfo {

			private String domain;

			public Iothreadinfo() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Setmem {

			private String domain;

			private String __size;

			public Setmem() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void set__size(String __size) {
				this.__size = __size;
			}

			public String get__size() {
				return this.__size;
			}
		}

		public static class Domiftune {

			private String domain;

			private String _interface;

			public Domiftune() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void set_interface(String _interface) {
				this._interface = _interface;
			}

			public String get_interface() {
				return this._interface;
			}
		}

		public static class Install {

			private String __container;

			private String __idmap;

			private String __cputune;

			private String __os_variant;

			private String __noreboot;

			private String __paravirt;

			private String __autostart;

			private String __memorybacking;

			private String __network;

			private String __security;

			private String __check;

			private String __pxe;

			private String __filesystem;

			private String __clock;

			private String __parallel;

			private String __memory;

			private String __channel;

			private String __memballoon;

			private String __rng;

			private String __cpu;

			private String __arch;

			private String __controller;

			private String __sound;

			private String __resource;

			private String __cdrom;

			private String __machine;

			private String __memdev;

			private String __watchdog;

			private String __virt_type;

			private String __graphics;

			private String __features;

			private String __qemu_commandline;

			private String __blkiotune;

			private String __serial;

			private String __dry_run;

			private String __boot;

			private String __vcpus;

			private String __redirdev;

			private String __hvm;

			private String __extra_args;

			private String __metadata;

			private String __console;

			private String __numatune;

			private String __location;

			private String __name;

			private String __memtune;

			private String __initrd_inject;

			private String __import;

			private String __livecd;

			private String __smartcard;

			private String __input;

			private String __pm;

			private String __panic;

			private String __transient;

			private String __tpm;

			private String __sysinfo;

			private String __disk;

			private String __hostdev;

			private String __events;

			public Install() {

			}

			public void set__container(String __container) {
				this.__container = __container;
			}

			public String get__container() {
				return this.__container;
			}

			public void set__idmap(String __idmap) {
				this.__idmap = __idmap;
			}

			public String get__idmap() {
				return this.__idmap;
			}

			public void set__cputune(String __cputune) {
				this.__cputune = __cputune;
			}

			public String get__cputune() {
				return this.__cputune;
			}

			public void set__os_variant(String __os_variant) {
				this.__os_variant = __os_variant;
			}

			public String get__os_variant() {
				return this.__os_variant;
			}

			public void set__noreboot(String __noreboot) {
				this.__noreboot = __noreboot;
			}

			public String get__noreboot() {
				return this.__noreboot;
			}

			public void set__paravirt(String __paravirt) {
				this.__paravirt = __paravirt;
			}

			public String get__paravirt() {
				return this.__paravirt;
			}

			public void set__autostart(String __autostart) {
				this.__autostart = __autostart;
			}

			public String get__autostart() {
				return this.__autostart;
			}

			public void set__memorybacking(String __memorybacking) {
				this.__memorybacking = __memorybacking;
			}

			public String get__memorybacking() {
				return this.__memorybacking;
			}

			public void set__network(String __network) {
				this.__network = __network;
			}

			public String get__network() {
				return this.__network;
			}

			public void set__security(String __security) {
				this.__security = __security;
			}

			public String get__security() {
				return this.__security;
			}

			public void set__check(String __check) {
				this.__check = __check;
			}

			public String get__check() {
				return this.__check;
			}

			public void set__pxe(String __pxe) {
				this.__pxe = __pxe;
			}

			public String get__pxe() {
				return this.__pxe;
			}

			public void set__filesystem(String __filesystem) {
				this.__filesystem = __filesystem;
			}

			public String get__filesystem() {
				return this.__filesystem;
			}

			public void set__clock(String __clock) {
				this.__clock = __clock;
			}

			public String get__clock() {
				return this.__clock;
			}

			public void set__parallel(String __parallel) {
				this.__parallel = __parallel;
			}

			public String get__parallel() {
				return this.__parallel;
			}

			public void set__memory(String __memory) {
				this.__memory = __memory;
			}

			public String get__memory() {
				return this.__memory;
			}

			public void set__channel(String __channel) {
				this.__channel = __channel;
			}

			public String get__channel() {
				return this.__channel;
			}

			public void set__memballoon(String __memballoon) {
				this.__memballoon = __memballoon;
			}

			public String get__memballoon() {
				return this.__memballoon;
			}

			public void set__rng(String __rng) {
				this.__rng = __rng;
			}

			public String get__rng() {
				return this.__rng;
			}

			public void set__cpu(String __cpu) {
				this.__cpu = __cpu;
			}

			public String get__cpu() {
				return this.__cpu;
			}

			public void set__arch(String __arch) {
				this.__arch = __arch;
			}

			public String get__arch() {
				return this.__arch;
			}

			public void set__controller(String __controller) {
				this.__controller = __controller;
			}

			public String get__controller() {
				return this.__controller;
			}

			public void set__sound(String __sound) {
				this.__sound = __sound;
			}

			public String get__sound() {
				return this.__sound;
			}

			public void set__resource(String __resource) {
				this.__resource = __resource;
			}

			public String get__resource() {
				return this.__resource;
			}

			public void set__cdrom(String __cdrom) {
				this.__cdrom = __cdrom;
			}

			public String get__cdrom() {
				return this.__cdrom;
			}

			public void set__machine(String __machine) {
				this.__machine = __machine;
			}

			public String get__machine() {
				return this.__machine;
			}

			public void set__memdev(String __memdev) {
				this.__memdev = __memdev;
			}

			public String get__memdev() {
				return this.__memdev;
			}

			public void set__watchdog(String __watchdog) {
				this.__watchdog = __watchdog;
			}

			public String get__watchdog() {
				return this.__watchdog;
			}

			public void set__virt_type(String __virt_type) {
				this.__virt_type = __virt_type;
			}

			public String get__virt_type() {
				return this.__virt_type;
			}

			public void set__graphics(String __graphics) {
				this.__graphics = __graphics;
			}

			public String get__graphics() {
				return this.__graphics;
			}

			public void set__features(String __features) {
				this.__features = __features;
			}

			public String get__features() {
				return this.__features;
			}

			public void set__qemu_commandline(String __qemu_commandline) {
				this.__qemu_commandline = __qemu_commandline;
			}

			public String get__qemu_commandline() {
				return this.__qemu_commandline;
			}

			public void set__blkiotune(String __blkiotune) {
				this.__blkiotune = __blkiotune;
			}

			public String get__blkiotune() {
				return this.__blkiotune;
			}

			public void set__serial(String __serial) {
				this.__serial = __serial;
			}

			public String get__serial() {
				return this.__serial;
			}

			public void set__dry_run(String __dry_run) {
				this.__dry_run = __dry_run;
			}

			public String get__dry_run() {
				return this.__dry_run;
			}

			public void set__boot(String __boot) {
				this.__boot = __boot;
			}

			public String get__boot() {
				return this.__boot;
			}

			public void set__vcpus(String __vcpus) {
				this.__vcpus = __vcpus;
			}

			public String get__vcpus() {
				return this.__vcpus;
			}

			public void set__redirdev(String __redirdev) {
				this.__redirdev = __redirdev;
			}

			public String get__redirdev() {
				return this.__redirdev;
			}

			public void set__hvm(String __hvm) {
				this.__hvm = __hvm;
			}

			public String get__hvm() {
				return this.__hvm;
			}

			public void set__extra_args(String __extra_args) {
				this.__extra_args = __extra_args;
			}

			public String get__extra_args() {
				return this.__extra_args;
			}

			public void set__metadata(String __metadata) {
				this.__metadata = __metadata;
			}

			public String get__metadata() {
				return this.__metadata;
			}

			public void set__console(String __console) {
				this.__console = __console;
			}

			public String get__console() {
				return this.__console;
			}

			public void set__numatune(String __numatune) {
				this.__numatune = __numatune;
			}

			public String get__numatune() {
				return this.__numatune;
			}

			public void set__location(String __location) {
				this.__location = __location;
			}

			public String get__location() {
				return this.__location;
			}

			public void set__name(String __name) {
				this.__name = __name;
			}

			public String get__name() {
				return this.__name;
			}

			public void set__memtune(String __memtune) {
				this.__memtune = __memtune;
			}

			public String get__memtune() {
				return this.__memtune;
			}

			public void set__initrd_inject(String __initrd_inject) {
				this.__initrd_inject = __initrd_inject;
			}

			public String get__initrd_inject() {
				return this.__initrd_inject;
			}

			public void set__import(String __import) {
				this.__import = __import;
			}

			public String get__import() {
				return this.__import;
			}

			public void set__livecd(String __livecd) {
				this.__livecd = __livecd;
			}

			public String get__livecd() {
				return this.__livecd;
			}

			public void set__smartcard(String __smartcard) {
				this.__smartcard = __smartcard;
			}

			public String get__smartcard() {
				return this.__smartcard;
			}

			public void set__input(String __input) {
				this.__input = __input;
			}

			public String get__input() {
				return this.__input;
			}

			public void set__pm(String __pm) {
				this.__pm = __pm;
			}

			public String get__pm() {
				return this.__pm;
			}

			public void set__panic(String __panic) {
				this.__panic = __panic;
			}

			public String get__panic() {
				return this.__panic;
			}

			public void set__transient(String __transient) {
				this.__transient = __transient;
			}

			public String get__transient() {
				return this.__transient;
			}

			public void set__tpm(String __tpm) {
				this.__tpm = __tpm;
			}

			public String get__tpm() {
				return this.__tpm;
			}

			public void set__sysinfo(String __sysinfo) {
				this.__sysinfo = __sysinfo;
			}

			public String get__sysinfo() {
				return this.__sysinfo;
			}

			public void set__disk(String __disk) {
				this.__disk = __disk;
			}

			public String get__disk() {
				return this.__disk;
			}

			public void set__hostdev(String __hostdev) {
				this.__hostdev = __hostdev;
			}

			public String get__hostdev() {
				return this.__hostdev;
			}

			public void set__events(String __events) {
				this.__events = __events;
			}

			public String get__events() {
				return this.__events;
			}
		}

		public static class Reset {

			private String domain;

			public Reset() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Vol_create_as {

			private String name;

			private String pool;

			private String capacity;

			public Vol_create_as() {

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

			public void setCapacity(String capacity) {
				this.capacity = capacity;
			}

			public String getCapacity() {
				return this.capacity;
			}
		}

		public static class Snapshot_dumpxml {

			private String domain;

			private String snapshotname;

			public Snapshot_dumpxml() {

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

		public static class Domname {

			private String domain;

			public Domname() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Domfsinfo {

			private String domain;

			public Domfsinfo() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Iface_dumpxml {

			private String _interface;

			public Iface_dumpxml() {

			}

			public void set_interface(String _interface) {
				this._interface = _interface;
			}

			public String get_interface() {
				return this._interface;
			}
		}

		public static class Detach_disk {

			private String domain;

			private String target;

			public Detach_disk() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void setTarget(String target) {
				this.target = target;
			}

			public String getTarget() {
				return this.target;
			}
		}

		public static class Domfsthaw {

			private String domain;

			public Domfsthaw() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Pool_start {

			private String pool;

			public Pool_start() {

			}

			public void setPool(String pool) {
				this.pool = pool;
			}

			public String getPool() {
				return this.pool;
			}
		}

		public static class Save {

			private String file;

			private String domain;

			public Save() {

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
		}

		public static class Pool_undefine {

			private String pool;

			public Pool_undefine() {

			}

			public void setPool(String pool) {
				this.pool = pool;
			}

			public String getPool() {
				return this.pool;
			}
		}

		public static class Pool_delete {

			private String pool;

			public Pool_delete() {

			}

			public void setPool(String pool) {
				this.pool = pool;
			}

			public String getPool() {
				return this.pool;
			}
		}

		public static class Vol_path {

			private String vol;

			public Vol_path() {

			}

			public void setVol(String vol) {
				this.vol = vol;
			}

			public String getVol() {
				return this.vol;
			}
		}

		public static class Managedsave_edit {

			private String domain;

			public Managedsave_edit() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Screenshot {

			private String domain;

			public Screenshot() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Vol_dumpxml {

			private String vol;

			public Vol_dumpxml() {

			}

			public void setVol(String vol) {
				this.vol = vol;
			}

			public String getVol() {
				return this.vol;
			}
		}

		public static class Find_storage_pool_sources_as {

			private String type;

			public Find_storage_pool_sources_as() {

			}

			public void setType(String type) {
				this.type = type;
			}

			public String getType() {
				return this.type;
			}
		}

		public static class Migrate_setspeed {

			private String __bandwidth;

			private String domain;

			public Migrate_setspeed() {

			}

			public void set__bandwidth(String __bandwidth) {
				this.__bandwidth = __bandwidth;
			}

			public String get__bandwidth() {
				return this.__bandwidth;
			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Ttyconsole {

			private String domain;

			public Ttyconsole() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Set_user_password {

			private String password;

			private String domain;

			private String user;

			public Set_user_password() {

			}

			public void setPassword(String password) {
				this.password = password;
			}

			public String getPassword() {
				return this.password;
			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void setUser(String user) {
				this.user = user;
			}

			public String getUser() {
				return this.user;
			}
		}

		public static class Blockresize {

			private String path;

			private String domain;

			private String __size;

			public Blockresize() {

			}

			public void setPath(String path) {
				this.path = path;
			}

			public String getPath() {
				return this.path;
			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void set__size(String __size) {
				this.__size = __size;
			}

			public String get__size() {
				return this.__size;
			}
		}

		public static class Pool_edit {

			private String pool;

			public Pool_edit() {

			}

			public void setPool(String pool) {
				this.pool = pool;
			}

			public String getPool() {
				return this.pool;
			}
		}

		public static class Vol_pool {

			private String vol;

			public Vol_pool() {

			}

			public void setVol(String vol) {
				this.vol = vol;
			}

			public String getVol() {
				return this.vol;
			}
		}

		public static class Detach_device_alias {

			private String domain;

			private String alias;

			public Detach_device_alias() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void setAlias(String alias) {
				this.alias = alias;
			}

			public String getAlias() {
				return this.alias;
			}
		}

		public static class Vol_key {

			private String vol;

			public Vol_key() {

			}

			public void setVol(String vol) {
				this.vol = vol;
			}

			public String getVol() {
				return this.vol;
			}
		}

		public static class Blkiotune {

			private String domain;

			public Blkiotune() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Nwfilter_binding_delete {

			private String binding;

			public Nwfilter_binding_delete() {

			}

			public void setBinding(String binding) {
				this.binding = binding;
			}

			public String getBinding() {
				return this.binding;
			}
		}

		public static class Secret_set_value {

			private String base64;

			private String secret;

			public Secret_set_value() {

			}

			public void setBase64(String base64) {
				this.base64 = base64;
			}

			public String getBase64() {
				return this.base64;
			}

			public void setSecret(String secret) {
				this.secret = secret;
			}

			public String getSecret() {
				return this.secret;
			}
		}

		public static class Pool_define {

			private String file;

			public Pool_define() {

			}

			public void setFile(String file) {
				this.file = file;
			}

			public String getFile() {
				return this.file;
			}
		}

		public static class Blockpull {

			private String path;

			private String domain;

			public Blockpull() {

			}

			public void setPath(String path) {
				this.path = path;
			}

			public String getPath() {
				return this.path;
			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Migrate_setmaxdowntime {

			private String domain;

			private String __downtime;

			public Migrate_setmaxdowntime() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void set__downtime(String __downtime) {
				this.__downtime = __downtime;
			}

			public String get__downtime() {
				return this.__downtime;
			}
		}

		public static class Nwfilter_binding_dumpxml {

			private String binding;

			public Nwfilter_binding_dumpxml() {

			}

			public void setBinding(String binding) {
				this.binding = binding;
			}

			public String getBinding() {
				return this.binding;
			}
		}

		public static class Resume {

			private String domain;

			public Resume() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Iface_name {

			private String _interface;

			public Iface_name() {

			}

			public void set_interface(String _interface) {
				this._interface = _interface;
			}

			public String get_interface() {
				return this._interface;
			}
		}

		public static class Iothreadpin {

			private String __iothread;

			private String domain;

			private String cpulist;

			public Iothreadpin() {

			}

			public void set__iothread(String __iothread) {
				this.__iothread = __iothread;
			}

			public String get__iothread() {
				return this.__iothread;
			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void setCpulist(String cpulist) {
				this.cpulist = cpulist;
			}

			public String getCpulist() {
				return this.cpulist;
			}
		}

		public static class Pool_refresh {

			private String pool;

			public Pool_refresh() {

			}

			public void setPool(String pool) {
				this.pool = pool;
			}

			public String getPool() {
				return this.pool;
			}
		}

		public static class Migrate_getmaxdowntime {

			private String domain;

			public Migrate_getmaxdowntime() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Iface_mac {

			private String _interface;

			public Iface_mac() {

			}

			public void set_interface(String _interface) {
				this._interface = _interface;
			}

			public String get_interface() {
				return this._interface;
			}
		}

		public static class Domid {

			private String domain;

			public Domid() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Dumpxml {

			private String domain;

			public Dumpxml() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Blkdeviotune {

			private String domain;

			private String device;

			public Blkdeviotune() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void setDevice(String device) {
				this.device = device;
			}

			public String getDevice() {
				return this.device;
			}
		}

		public static class Domuuid {

			private String domain;

			public Domuuid() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Nodedev_detach {

			private String device;

			public Nodedev_detach() {

			}

			public void setDevice(String device) {
				this.device = device;
			}

			public String getDevice() {
				return this.device;
			}
		}

		public static class Vol_wipe {

			private String vol;

			public Vol_wipe() {

			}

			public void setVol(String vol) {
				this.vol = vol;
			}

			public String getVol() {
				return this.vol;
			}
		}

		public static class Pool_dumpxml {

			private String pool;

			public Pool_dumpxml() {

			}

			public void setPool(String pool) {
				this.pool = pool;
			}

			public String getPool() {
				return this.pool;
			}
		}

		public static class Blockjob {

			private String path;

			private String domain;

			public Blockjob() {

			}

			public void setPath(String path) {
				this.path = path;
			}

			public String getPath() {
				return this.path;
			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Iothreadadd {

			private String domain;

			private String __id;

			public Iothreadadd() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void set__id(String __id) {
				this.__id = __id;
			}

			public String get__id() {
				return this.__id;
			}
		}

		public static class Domblkstat {

			private String domain;

			public Domblkstat() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Send_key {

			private String keycode;

			private String domain;

			public Send_key() {

			}

			public void setKeycode(String keycode) {
				this.keycode = keycode;
			}

			public String getKeycode() {
				return this.keycode;
			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Net_dhcp_leases {

			private String network;

			public Net_dhcp_leases() {

			}

			public void setNetwork(String network) {
				this.network = network;
			}

			public String getNetwork() {
				return this.network;
			}
		}

		public static class Nwfilter_define {

			private String file;

			public Nwfilter_define() {

			}

			public void setFile(String file) {
				this.file = file;
			}

			public String getFile() {
				return this.file;
			}
		}

		public static class Net_start {

			private String network;

			public Net_start() {

			}

			public void setNetwork(String network) {
				this.network = network;
			}

			public String getNetwork() {
				return this.network;
			}
		}

		public static class Vcpucount {

			private String domain;

			public Vcpucount() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Nodedev_destroy {

			private String device;

			public Nodedev_destroy() {

			}

			public void setDevice(String device) {
				this.device = device;
			}

			public String getDevice() {
				return this.device;
			}
		}

		public static class Attach_disk {

			private String domain;

			private String source;

			private String target;

			public Attach_disk() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void setSource(String source) {
				this.source = source;
			}

			public String getSource() {
				return this.source;
			}

			public void setTarget(String target) {
				this.target = target;
			}

			public String getTarget() {
				return this.target;
			}
		}

		public static class Dominfo {

			private String domain;

			public Dominfo() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Net_undefine {

			private String network;

			public Net_undefine() {

			}

			public void setNetwork(String network) {
				this.network = network;
			}

			public String getNetwork() {
				return this.network;
			}
		}

		public static class Snapshot_create {

			private String domain;

			public Snapshot_create() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Domtime {

			private String domain;

			public Domtime() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Pool_define_as {

			private String name;

			private String type;

			public Pool_define_as() {

			}

			public void setName(String name) {
				this.name = name;
			}

			public String getName() {
				return this.name;
			}

			public void setType(String type) {
				this.type = type;
			}

			public String getType() {
				return this.type;
			}
		}

		public static class Schedinfo {

			private String domain;

			public Schedinfo() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Setvcpus {

			private String domain;

			private String __count;

			public Setvcpus() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void set__count(String __count) {
				this.__count = __count;
			}

			public String get__count() {
				return this.__count;
			}
		}

		public static class Blockcopy {

			private String path;

			private String domain;

			public Blockcopy() {

			}

			public void setPath(String path) {
				this.path = path;
			}

			public String getPath() {
				return this.path;
			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Snapshot_current {

			private String domain;

			public Snapshot_current() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Domblkerror {

			private String domain;

			public Domblkerror() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Setvcpu {

			private String vcpulist;

			private String domain;

			public Setvcpu() {

			}

			public void setVcpulist(String vcpulist) {
				this.vcpulist = vcpulist;
			}

			public String getVcpulist() {
				return this.vcpulist;
			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Migrate_compcache {

			private String domain;

			public Migrate_compcache() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Save_image_dumpxml {

			private String file;

			public Save_image_dumpxml() {

			}

			public void setFile(String file) {
				this.file = file;
			}

			public String getFile() {
				return this.file;
			}
		}

		public static class Qemu_monitor_command {

			private String domain;

			private String cmd;

			public Qemu_monitor_command() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void setCmd(String cmd) {
				this.cmd = cmd;
			}

			public String getCmd() {
				return this.cmd;
			}
		}

		public static class Cpu_stats {

			private String domain;

			public Cpu_stats() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Vcpupin {

			private String domain;

			public Vcpupin() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Net_autostart {

			private String network;

			public Net_autostart() {

			}

			public void setNetwork(String network) {
				this.network = network;
			}

			public String getNetwork() {
				return this.network;
			}
		}

		public static class Create {

			private String file;

			public Create() {

			}

			public void setFile(String file) {
				this.file = file;
			}

			public String getFile() {
				return this.file;
			}
		}

		public static class Net_dumpxml {

			private String network;

			public Net_dumpxml() {

			}

			public void setNetwork(String network) {
				this.network = network;
			}

			public String getNetwork() {
				return this.network;
			}
		}

		public static class Numatune {

			private String domain;

			public Numatune() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Save_image_edit {

			private String file;

			public Save_image_edit() {

			}

			public void setFile(String file) {
				this.file = file;
			}

			public String getFile() {
				return this.file;
			}
		}

		public static class Net_edit {

			private String network;

			public Net_edit() {

			}

			public void setNetwork(String network) {
				this.network = network;
			}

			public String getNetwork() {
				return this.network;
			}
		}

		public static class Domxml_to_native {

			private String format;

			public Domxml_to_native() {

			}

			public void setFormat(String format) {
				this.format = format;
			}

			public String getFormat() {
				return this.format;
			}
		}

		public static class Qemu_attach {

			private String pid;

			public Qemu_attach() {

			}

			public void setPid(String pid) {
				this.pid = pid;
			}

			public String getPid() {
				return this.pid;
			}
		}

		public static class Suspend {

			private String domain;

			public Suspend() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Snapshot_create_as {

			private String domain;

			public Snapshot_create_as() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Setmaxmem {

			private String domain;

			private String __size;

			public Setmaxmem() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void set__size(String __size) {
				this.__size = __size;
			}

			public String get__size() {
				return this.__size;
			}
		}

		public static class Iface_start {

			private String _interface;

			public Iface_start() {

			}

			public void set_interface(String _interface) {
				this._interface = _interface;
			}

			public String get_interface() {
				return this._interface;
			}
		}

		public static class Net_update {

			private String xml;

			private String section;

			private String command;

			private String network;

			public Net_update() {

			}

			public void setXml(String xml) {
				this.xml = xml;
			}

			public String getXml() {
				return this.xml;
			}

			public void setSection(String section) {
				this.section = section;
			}

			public String getSection() {
				return this.section;
			}

			public void setCommand(String command) {
				this.command = command;
			}

			public String getCommand() {
				return this.command;
			}

			public void setNetwork(String network) {
				this.network = network;
			}

			public String getNetwork() {
				return this.network;
			}
		}

		public static class Detach__interface {

			private String domain;

			private String type;

			public Detach__interface() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void setType(String type) {
				this.type = type;
			}

			public String getType() {
				return this.type;
			}
		}

		public static class Undefine {

			private String domain;

			public Undefine() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Vol_create_from {

			private String vol;

			private String file;

			private String pool;

			public Vol_create_from() {

			}

			public void setVol(String vol) {
				this.vol = vol;
			}

			public String getVol() {
				return this.vol;
			}

			public void setFile(String file) {
				this.file = file;
			}

			public String getFile() {
				return this.file;
			}

			public void setPool(String pool) {
				this.pool = pool;
			}

			public String getPool() {
				return this.pool;
			}
		}

		public static class Domrename {

			private String domain;

			private String new_name;

			public Domrename() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void setNew_name(String new_name) {
				this.new_name = new_name;
			}

			public String getNew_name() {
				return this.new_name;
			}
		}

		public static class Vol_create {

			private String file;

			private String pool;

			public Vol_create() {

			}

			public void setFile(String file) {
				this.file = file;
			}

			public String getFile() {
				return this.file;
			}

			public void setPool(String pool) {
				this.pool = pool;
			}

			public String getPool() {
				return this.pool;
			}
		}

		public static class Net_create {

			private String file;

			public Net_create() {

			}

			public void setFile(String file) {
				this.file = file;
			}

			public String getFile() {
				return this.file;
			}
		}

		public static class Domblkinfo {

			private String domain;

			public Domblkinfo() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Vcpuinfo {

			private String domain;

			public Vcpuinfo() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Managedsave_dumpxml {

			private String domain;

			public Managedsave_dumpxml() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Pool_create_as {

			private String name;

			private String type;

			public Pool_create_as() {

			}

			public void setName(String name) {
				this.name = name;
			}

			public String getName() {
				return this.name;
			}

			public void setType(String type) {
				this.type = type;
			}

			public String getType() {
				return this.type;
			}
		}

		public static class Secret_undefine {

			private String secret;

			public Secret_undefine() {

			}

			public void setSecret(String secret) {
				this.secret = secret;
			}

			public String getSecret() {
				return this.secret;
			}
		}

		public static class Save_image_define {

			private String file;

			private String xml;

			public Save_image_define() {

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

		public static class Shutdown {

			private String domain;

			public Shutdown() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Desc {

			private String domain;

			public Desc() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Migrate {

			private String domain;

			private String desturi;

			public Migrate() {

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
		}

		public static class Pool_build {

			private String pool;

			public Pool_build() {

			}

			public void setPool(String pool) {
				this.pool = pool;
			}

			public String getPool() {
				return this.pool;
			}
		}

		public static class Inject_nmi {

			private String domain;

			public Inject_nmi() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Set_lifecycle_action {

			private String domain;

			private String action;

			private String type;

			public Set_lifecycle_action() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void setAction(String action) {
				this.action = action;
			}

			public String getAction() {
				return this.action;
			}

			public void setType(String type) {
				this.type = type;
			}

			public String getType() {
				return this.type;
			}
		}

		public static class Blockcommit {

			private String path;

			private String domain;

			public Blockcommit() {

			}

			public void setPath(String path) {
				this.path = path;
			}

			public String getPath() {
				return this.path;
			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Nwfilter_edit {

			private String nwfilter;

			public Nwfilter_edit() {

			}

			public void setNwfilter(String nwfilter) {
				this.nwfilter = nwfilter;
			}

			public String getNwfilter() {
				return this.nwfilter;
			}
		}

		public static class Snapshot_edit {

			private String domain;

			public Snapshot_edit() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Dompmwakeup {

			private String domain;

			public Dompmwakeup() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Vol_delete {

			private String vol;

			public Vol_delete() {

			}

			public void setVol(String vol) {
				this.vol = vol;
			}

			public String getVol() {
				return this.vol;
			}
		}

		public static class Managedsave_remove {

			private String domain;

			public Managedsave_remove() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Nwfilter_dumpxml {

			private String nwfilter;

			public Nwfilter_dumpxml() {

			}

			public void setNwfilter(String nwfilter) {
				this.nwfilter = nwfilter;
			}

			public String getNwfilter() {
				return this.nwfilter;
			}
		}

		public static class Find_storage_pool_sources {

			private String type;

			public Find_storage_pool_sources() {

			}

			public void setType(String type) {
				this.type = type;
			}

			public String getType() {
				return this.type;
			}
		}

		public static class Domfstrim {

			private String domain;

			public Domfstrim() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Vol_info {

			private String vol;

			public Vol_info() {

			}

			public void setVol(String vol) {
				this.vol = vol;
			}

			public String getVol() {
				return this.vol;
			}
		}

		public static class Secret_get_value {

			private String secret;

			public Secret_get_value() {

			}

			public void setSecret(String secret) {
				this.secret = secret;
			}

			public String getSecret() {
				return this.secret;
			}
		}

		public static class Domifstat {

			private String domain;

			private String _interface;

			public Domifstat() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void set_interface(String _interface) {
				this._interface = _interface;
			}

			public String get_interface() {
				return this._interface;
			}
		}

		public static class Send_process_signal {

			private String signame;

			private String domain;

			private String pid;

			public Send_process_signal() {

			}

			public void setSigname(String signame) {
				this.signame = signame;
			}

			public String getSigname() {
				return this.signame;
			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void setPid(String pid) {
				this.pid = pid;
			}

			public String getPid() {
				return this.pid;
			}
		}

		public static class Define {

			private String file;

			public Define() {

			}

			public void setFile(String file) {
				this.file = file;
			}

			public String getFile() {
				return this.file;
			}
		}

		public static class Secret_define {

			private String file;

			public Secret_define() {

			}

			public void setFile(String file) {
				this.file = file;
			}

			public String getFile() {
				return this.file;
			}
		}

		public static class Memtune {

			private String domain;

			public Memtune() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Nodedev_dumpxml {

			private String device;

			public Nodedev_dumpxml() {

			}

			public void setDevice(String device) {
				this.device = device;
			}

			public String getDevice() {
				return this.device;
			}
		}

		public static class Dump {

			private String file;

			private String domain;

			public Dump() {

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
		}

		public static class Domstate {

			private String domain;

			public Domstate() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Iothreaddel {

			private String domain;

			private String __id;

			public Iothreaddel() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void set__id(String __id) {
				this.__id = __id;
			}

			public String get__id() {
				return this.__id;
			}
		}

		public static class Dompmsuspend {

			private String domain;

			private String target;

			public Dompmsuspend() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void setTarget(String target) {
				this.target = target;
			}

			public String getTarget() {
				return this.target;
			}
		}

		public static class Pool_uuid {

			private String pool;

			public Pool_uuid() {

			}

			public void setPool(String pool) {
				this.pool = pool;
			}

			public String getPool() {
				return this.pool;
			}
		}

		public static class Managedsave_define {

			private String xml;

			private String domain;

			public Managedsave_define() {

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
		}

		public static class Snapshot_delete {

			private String domain;

			public Snapshot_delete() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Guestvcpus {

			private String domain;

			public Guestvcpus() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Reboot {

			private String domain;

			public Reboot() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Vol_clone {

			private String vol;

			private String newname;

			public Vol_clone() {

			}

			public void setVol(String vol) {
				this.vol = vol;
			}

			public String getVol() {
				return this.vol;
			}

			public void setNewname(String newname) {
				this.newname = newname;
			}

			public String getNewname() {
				return this.newname;
			}
		}

		public static class Iface_edit {

			private String _interface;

			public Iface_edit() {

			}

			public void set_interface(String _interface) {
				this._interface = _interface;
			}

			public String get_interface() {
				return this._interface;
			}
		}

		public static class Vol_resize {

			private String vol;

			private String capacity;

			public Vol_resize() {

			}

			public void setVol(String vol) {
				this.vol = vol;
			}

			public String getVol() {
				return this.vol;
			}

			public void setCapacity(String capacity) {
				this.capacity = capacity;
			}

			public String getCapacity() {
				return this.capacity;
			}
		}

		public static class Iface_bridge {

			private String bridge;

			private String _interface;

			public Iface_bridge() {

			}

			public void setBridge(String bridge) {
				this.bridge = bridge;
			}

			public String getBridge() {
				return this.bridge;
			}

			public void set_interface(String _interface) {
				this._interface = _interface;
			}

			public String get_interface() {
				return this._interface;
			}
		}

		public static class Nodedev_create {

			private String file;

			public Nodedev_create() {

			}

			public void setFile(String file) {
				this.file = file;
			}

			public String getFile() {
				return this.file;
			}
		}

		public static class Restore {

			private String file;

			public Restore() {

			}

			public void setFile(String file) {
				this.file = file;
			}

			public String getFile() {
				return this.file;
			}
		}

		public static class Net_info {

			private String network;

			public Net_info() {

			}

			public void setNetwork(String network) {
				this.network = network;
			}

			public String getNetwork() {
				return this.network;
			}
		}

		public static class Net_uuid {

			private String network;

			public Net_uuid() {

			}

			public void setNetwork(String network) {
				this.network = network;
			}

			public String getNetwork() {
				return this.network;
			}
		}

		public static class Lxc_enter_namespace {

			private String domain;

			private String cmd;

			public Lxc_enter_namespace() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void setCmd(String cmd) {
				this.cmd = cmd;
			}

			public String getCmd() {
				return this.cmd;
			}
		}

		public static class Start {

			private String domain;

			public Start() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Domif_getlink {

			private String domain;

			private String _interface;

			public Domif_getlink() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void set_interface(String _interface) {
				this._interface = _interface;
			}

			public String get_interface() {
				return this._interface;
			}
		}

		public static class Iface_undefine {

			private String _interface;

			public Iface_undefine() {

			}

			public void set_interface(String _interface) {
				this._interface = _interface;
			}

			public String get_interface() {
				return this._interface;
			}
		}

		public static class Iface_unbridge {

			private String bridge;

			public Iface_unbridge() {

			}

			public void setBridge(String bridge) {
				this.bridge = bridge;
			}

			public String getBridge() {
				return this.bridge;
			}
		}

		public static class Pool_name {

			private String pool;

			public Pool_name() {

			}

			public void setPool(String pool) {
				this.pool = pool;
			}

			public String getPool() {
				return this.pool;
			}
		}

		public static class Domxml_from_native {

			private String format;

			private String config;

			public Domxml_from_native() {

			}

			public void setFormat(String format) {
				this.format = format;
			}

			public String getFormat() {
				return this.format;
			}

			public void setConfig(String config) {
				this.config = config;
			}

			public String getConfig() {
				return this.config;
			}
		}

		public static class Pool_info {

			private String pool;

			public Pool_info() {

			}

			public void setPool(String pool) {
				this.pool = pool;
			}

			public String getPool() {
				return this.pool;
			}
		}

		public static class Vol_download {

			private String vol;

			private String file;

			public Vol_download() {

			}

			public void setVol(String vol) {
				this.vol = vol;
			}

			public String getVol() {
				return this.vol;
			}

			public void setFile(String file) {
				this.file = file;
			}

			public String getFile() {
				return this.file;
			}
		}

		public static class Domjobabort {

			private String domain;

			public Domjobabort() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Dommemstat {

			private String domain;

			public Dommemstat() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Qemu_agent_command {

			private String domain;

			private String cmd;

			public Qemu_agent_command() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}

			public void setCmd(String cmd) {
				this.cmd = cmd;
			}

			public String getCmd() {
				return this.cmd;
			}
		}

		public static class Update_device {

			private String file;

			private String domain;

			public Update_device() {

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
		}

		public static class Attach_device {

			private String file;

			private String domain;

			public Attach_device() {

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
		}

		public static class Iface_destroy {

			private String _interface;

			public Iface_destroy() {

			}

			public void set_interface(String _interface) {
				this._interface = _interface;
			}

			public String get_interface() {
				return this._interface;
			}
		}

		public static class Net_define {

			private String file;

			public Net_define() {

			}

			public void setFile(String file) {
				this.file = file;
			}

			public String getFile() {
				return this.file;
			}
		}

		public static class Domjobinfo {

			private String domain;

			public Domjobinfo() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}

		public static class Clone {

			private String __name;

			private String __nonsparse;

			private String __force_copy;

			private String __replace;

			private String __nvram;

			private String __original_xml;

			private String __mac;

			private String __original;

			private String __reflink;

			private String __auto_clone;

			private String __preserve_data;

			private String __check;

			private String __file;

			public Clone() {

			}

			public void set__name(String __name) {
				this.__name = __name;
			}

			public String get__name() {
				return this.__name;
			}

			public void set__nonsparse(String __nonsparse) {
				this.__nonsparse = __nonsparse;
			}

			public String get__nonsparse() {
				return this.__nonsparse;
			}

			public void set__force_copy(String __force_copy) {
				this.__force_copy = __force_copy;
			}

			public String get__force_copy() {
				return this.__force_copy;
			}

			public void set__replace(String __replace) {
				this.__replace = __replace;
			}

			public String get__replace() {
				return this.__replace;
			}

			public void set__nvram(String __nvram) {
				this.__nvram = __nvram;
			}

			public String get__nvram() {
				return this.__nvram;
			}

			public void set__original_xml(String __original_xml) {
				this.__original_xml = __original_xml;
			}

			public String get__original_xml() {
				return this.__original_xml;
			}

			public void set__mac(String __mac) {
				this.__mac = __mac;
			}

			public String get__mac() {
				return this.__mac;
			}

			public void set__original(String __original) {
				this.__original = __original;
			}

			public String get__original() {
				return this.__original;
			}

			public void set__reflink(String __reflink) {
				this.__reflink = __reflink;
			}

			public String get__reflink() {
				return this.__reflink;
			}

			public void set__auto_clone(String __auto_clone) {
				this.__auto_clone = __auto_clone;
			}

			public String get__auto_clone() {
				return this.__auto_clone;
			}

			public void set__preserve_data(String __preserve_data) {
				this.__preserve_data = __preserve_data;
			}

			public String get__preserve_data() {
				return this.__preserve_data;
			}

			public void set__check(String __check) {
				this.__check = __check;
			}

			public String get__check() {
				return this.__check;
			}

			public void set__file(String __file) {
				this.__file = __file;
			}

			public String get__file() {
				return this.__file;
			}
		}

		public static class Net_destroy {

			private String network;

			public Net_destroy() {

			}

			public void setNetwork(String network) {
				this.network = network;
			}

			public String getNetwork() {
				return this.network;
			}
		}

		public static class Snapshot_revert {

			private String domain;

			public Snapshot_revert() {

			}

			public void setDomain(String domain) {
				this.domain = domain;
			}

			public String getDomain() {
				return this.domain;
			}
		}
	}
}
