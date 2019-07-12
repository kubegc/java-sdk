/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model.virtualmachineuitdisk;

import java.util.ArrayList;

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
public class UitVolume {

	protected Val val;

	protected Result result;

	protected ArrayList<Data> data;

	protected String obj;

	protected String end;

	protected String cmd;

	protected String oid;

	protected Cond cond;

	public UitVolume() {
		this.obj = "String";
		this.end = "true";
		this.cmd = "String";
		this.oid = "1";

	}

	/**
	 * Ignore the user setting, use 'lifecycle' to update VM's info
	 *
	 */
	public void setVal(Val val) {
		this.val = val;
	}

	public Val getVal() {
		return this.val;
	}

	/**
	 * Ignore the user setting, use 'lifecycle' to update VM's info
	 *
	 */
	public void setResult(Result result) {
		this.result = result;
	}

	public Result getResult() {
		return this.result;
	}

	/**
	 * Ignore the user setting, use 'lifecycle' to update VM's info
	 *
	 */
	public void setData(ArrayList<Data> data) {
		this.data = data;
	}

	public ArrayList<Data> getData() {
		return this.data;
	}

	/**
	 * Ignore the user setting, use 'lifecycle' to update VM's info
	 *
	 */
	public void setObj(String obj) {
		this.obj = obj;
	}

	public String getObj() {
		return this.obj;
	}

	/**
	 * Ignore the user setting, use 'lifecycle' to update VM's info
	 *
	 */
	public void setEnd(String end) {
		this.end = end;
	}

	public String getEnd() {
		return this.end;
	}

	/**
	 * Ignore the user setting, use 'lifecycle' to update VM's info
	 *
	 */
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getCmd() {
		return this.cmd;
	}

	/**
	 * Ignore the user setting, use 'lifecycle' to update VM's info
	 *
	 */
	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getOid() {
		return this.oid;
	}

	/**
	 * Ignore the user setting, use 'lifecycle' to update VM's info
	 *
	 */
	public void setCond(Cond cond) {
		this.cond = cond;
	}

	public Cond getCond() {
		return this.cond;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class Val {

		protected String cmd;

		public Val() {
			this.cmd = "String";

		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setCmd(String cmd) {
			this.cmd = cmd;
		}

		public String getCmd() {
			return this.cmd;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class Result {

		protected ArrayList<String> msg;

		protected String code;

		public Result() {
			this.code = "1";

		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setMsg(ArrayList<String> msg) {
			this.msg = msg;
		}

		public ArrayList<String> getMsg() {
			return this.msg;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setCode(String code) {
			this.code = code;
		}

		public String getCode() {
			return this.code;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class Data {

		protected String ret;

		protected String now_host;

		protected String mount_path;

		protected String block_type;

		protected String app_type;

		protected String create_time;

		protected ArrayList<Devices> devices;

		protected String now_cluster;

		protected String ip;

		protected String device_path;

		protected String device_type;

		protected String path;

		protected String size;

		protected String if_cache;

		protected String name;

		protected String creating;

		protected String id;

		protected String status;

		public Data() {
			this.ret = "1";
			this.now_host = "1";
			this.mount_path = "String";
			this.block_type = "String";
			this.app_type = "String";
			this.create_time = "1";
			this.now_cluster = "1";
			this.ip = "String";
			this.device_path = "String";
			this.device_type = "String";
			this.path = "String";
			this.size = "String";
			this.if_cache = "String";
			this.name = "String";
			this.creating = "1";
			this.id = "1";
			this.status = "String";

		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setRet(String ret) {
			this.ret = ret;
		}

		public String getRet() {
			return this.ret;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setNow_host(String now_host) {
			this.now_host = now_host;
		}

		public String getNow_host() {
			return this.now_host;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setMount_path(String mount_path) {
			this.mount_path = mount_path;
		}

		public String getMount_path() {
			return this.mount_path;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setBlock_type(String block_type) {
			this.block_type = block_type;
		}

		public String getBlock_type() {
			return this.block_type;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setApp_type(String app_type) {
			this.app_type = app_type;
		}

		public String getApp_type() {
			return this.app_type;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setCreate_time(String create_time) {
			this.create_time = create_time;
		}

		public String getCreate_time() {
			return this.create_time;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setDevices(ArrayList<Devices> devices) {
			this.devices = devices;
		}

		public ArrayList<Devices> getDevices() {
			return this.devices;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setNow_cluster(String now_cluster) {
			this.now_cluster = now_cluster;
		}

		public String getNow_cluster() {
			return this.now_cluster;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setIp(String ip) {
			this.ip = ip;
		}

		public String getIp() {
			return this.ip;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setDevice_path(String device_path) {
			this.device_path = device_path;
		}

		public String getDevice_path() {
			return this.device_path;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setDevice_type(String device_type) {
			this.device_type = device_type;
		}

		public String getDevice_type() {
			return this.device_type;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setPath(String path) {
			this.path = path;
		}

		public String getPath() {
			return this.path;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setSize(String size) {
			this.size = size;
		}

		public String getSize() {
			return this.size;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setIf_cache(String if_cache) {
			this.if_cache = if_cache;
		}

		public String getIf_cache() {
			return this.if_cache;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return this.name;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setCreating(String creating) {
			this.creating = creating;
		}

		public String getCreating() {
			return this.creating;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setId(String id) {
			this.id = id;
		}

		public String getId() {
			return this.id;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setStatus(String status) {
			this.status = status;
		}

		public String getStatus() {
			return this.status;
		}

		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
		public static class Devices {

			protected String cluster;

			protected String node;

			protected String role;

			protected String type;

			protected String device;

			public Devices() {
				this.cluster = "1";
				this.node = "1";
				this.role = "String";
				this.type = "String";
				this.device = "1";

			}

			/**
			 * Ignore the user setting, use 'lifecycle' to update VM's info
			 *
			 */
			public void setCluster(String cluster) {
				this.cluster = cluster;
			}

			public String getCluster() {
				return this.cluster;
			}

			/**
			 * Ignore the user setting, use 'lifecycle' to update VM's info
			 *
			 */
			public void setNode(String node) {
				this.node = node;
			}

			public String getNode() {
				return this.node;
			}

			/**
			 * Ignore the user setting, use 'lifecycle' to update VM's info
			 *
			 */
			public void setRole(String role) {
				this.role = role;
			}

			public String getRole() {
				return this.role;
			}

			/**
			 * Ignore the user setting, use 'lifecycle' to update VM's info
			 *
			 */
			public void setType(String type) {
				this.type = type;
			}

			public String getType() {
				return this.type;
			}

			/**
			 * Ignore the user setting, use 'lifecycle' to update VM's info
			 *
			 */
			public void setDevice(String device) {
				this.device = device;
			}

			public String getDevice() {
				return this.device;
			}
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class Cond {

		public Cond() {

		}
	}
}
