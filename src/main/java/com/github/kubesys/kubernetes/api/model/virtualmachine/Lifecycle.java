/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model.virtualmachine;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author xuyuanjia2017@otcaix.iscas.ac.cn
 * @author xianghao16@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @since Thu Jun 22 21:36:39 CST 2019
 **/
public class Lifecycle {

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
