/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model.virtualmachinedisk;

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
public class Volume {

	protected Allocation allocation;

	protected String _type;

	protected String name;

	protected Source source;

	protected Physical physical;

	protected String key;

	protected Capacity capacity;

	protected Target target;

	public Volume() {

	}

	/**
	 * Ignore the user setting, use 'lifecycle' to update VM's info
	 *
	 */
	public void setAllocation(Allocation allocation) {
		this.allocation = allocation;
	}

	public Allocation getAllocation() {
		return this.allocation;
	}

	/**
	 * Ignore the user setting, use 'lifecycle' to update VM's info
	 *
	 */
	public void set_type(String _type) {
		this._type = _type;
	}

	public String get_type() {
		return this._type;
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
	public void setSource(Source source) {
		this.source = source;
	}

	public Source getSource() {
		return this.source;
	}

	/**
	 * Ignore the user setting, use 'lifecycle' to update VM's info
	 *
	 */
	public void setPhysical(Physical physical) {
		this.physical = physical;
	}

	public Physical getPhysical() {
		return this.physical;
	}

	/**
	 * Ignore the user setting, use 'lifecycle' to update VM's info
	 *
	 */
	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return this.key;
	}

	/**
	 * Ignore the user setting, use 'lifecycle' to update VM's info
	 *
	 */
	public void setCapacity(Capacity capacity) {
		this.capacity = capacity;
	}

	public Capacity getCapacity() {
		return this.capacity;
	}

	/**
	 * Ignore the user setting, use 'lifecycle' to update VM's info
	 *
	 */
	public void setTarget(Target target) {
		this.target = target;
	}

	public Target getTarget() {
		return this.target;
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class Allocation {

		protected String _unit;

		protected String text;

		public Allocation() {
			this._unit = "String";
			this.text = "String";

		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void set_unit(String _unit) {
			this._unit = _unit;
		}

		public String get_unit() {
			return this._unit;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setText(String text) {
			this.text = text;
		}

		public String getText() {
			return this.text;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class Source {

		protected Auth auth;

		protected Host host;

		protected Device device;

		public Source() {

		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setAuth(Auth auth) {
			this.auth = auth;
		}

		public Auth getAuth() {
			return this.auth;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setHost(Host host) {
			this.host = host;
		}

		public Host getHost() {
			return this.host;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setDevice(Device device) {
			this.device = device;
		}

		public Device getDevice() {
			return this.device;
		}

		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
		public static class Auth {

			protected String _type;

			protected String _username;

			protected Secret secret;

			public Auth() {
				this._type = "String";
				this._username = "String";

			}

			/**
			 * Ignore the user setting, use 'lifecycle' to update VM's info
			 *
			 */
			public void set_type(String _type) {
				this._type = _type;
			}

			public String get_type() {
				return this._type;
			}

			/**
			 * Ignore the user setting, use 'lifecycle' to update VM's info
			 *
			 */
			public void set_username(String _username) {
				this._username = _username;
			}

			public String get_username() {
				return this._username;
			}

			/**
			 * Ignore the user setting, use 'lifecycle' to update VM's info
			 *
			 */
			public void setSecret(Secret secret) {
				this.secret = secret;
			}

			public Secret getSecret() {
				return this.secret;
			}

			@JsonInclude(JsonInclude.Include.NON_NULL)
			@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
			public static class Secret {

				protected String _usage;

				public Secret() {
					this._usage = "String";

				}

				/**
				 * Ignore the user setting, use 'lifecycle' to update VM's info
				 *
				 */
				public void set_usage(String _usage) {
					this._usage = _usage;
				}

				public String get_usage() {
					return this._usage;
				}
			}
		}

		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
		public static class Host {

			protected String _name;

			public Host() {
				this._name = "String";

			}

			/**
			 * Ignore the user setting, use 'lifecycle' to update VM's info
			 *
			 */
			public void set_name(String _name) {
				this._name = _name;
			}

			public String get_name() {
				return this._name;
			}
		}

		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
		public static class Device {

			protected String _path;

			public Device() {
				this._path = "String";

			}

			/**
			 * Ignore the user setting, use 'lifecycle' to update VM's info
			 *
			 */
			public void set_path(String _path) {
				this._path = _path;
			}

			public String get_path() {
				return this._path;
			}
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class Physical {

		protected String _unit;

		protected String text;

		public Physical() {
			this._unit = "String";
			this.text = "String";

		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void set_unit(String _unit) {
			this._unit = _unit;
		}

		public String get_unit() {
			return this._unit;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setText(String text) {
			this.text = text;
		}

		public String getText() {
			return this.text;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class Capacity {

		protected String _unit;

		protected String text;

		public Capacity() {
			this._unit = "String";
			this.text = "String";

		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void set_unit(String _unit) {
			this._unit = _unit;
		}

		public String get_unit() {
			return this._unit;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setText(String text) {
			this.text = text;
		}

		public String getText() {
			return this.text;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class Target {

		protected String path;

		protected Permissions permissions;

		protected Timestamps timestamps;

		protected Format format;

		public Target() {
			this.path = "String";

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
		public void setPermissions(Permissions permissions) {
			this.permissions = permissions;
		}

		public Permissions getPermissions() {
			return this.permissions;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setTimestamps(Timestamps timestamps) {
			this.timestamps = timestamps;
		}

		public Timestamps getTimestamps() {
			return this.timestamps;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public void setFormat(Format format) {
			this.format = format;
		}

		public Format getFormat() {
			return this.format;
		}

		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
		public static class Permissions {

			protected String mode;

			protected String owner;

			protected String group;

			public Permissions() {
				this.mode = "String";
				this.owner = "String";
				this.group = "String";

			}

			/**
			 * Ignore the user setting, use 'lifecycle' to update VM's info
			 *
			 */
			public void setMode(String mode) {
				this.mode = mode;
			}

			public String getMode() {
				return this.mode;
			}

			/**
			 * Ignore the user setting, use 'lifecycle' to update VM's info
			 *
			 */
			public void setOwner(String owner) {
				this.owner = owner;
			}

			public String getOwner() {
				return this.owner;
			}

			/**
			 * Ignore the user setting, use 'lifecycle' to update VM's info
			 *
			 */
			public void setGroup(String group) {
				this.group = group;
			}

			public String getGroup() {
				return this.group;
			}
		}

		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
		public static class Timestamps {

			protected String atime;

			protected String ctime;

			protected String mtime;

			public Timestamps() {
				this.atime = "String";
				this.ctime = "String";
				this.mtime = "String";

			}

			/**
			 * Ignore the user setting, use 'lifecycle' to update VM's info
			 *
			 */
			public void setAtime(String atime) {
				this.atime = atime;
			}

			public String getAtime() {
				return this.atime;
			}

			/**
			 * Ignore the user setting, use 'lifecycle' to update VM's info
			 *
			 */
			public void setCtime(String ctime) {
				this.ctime = ctime;
			}

			public String getCtime() {
				return this.ctime;
			}

			/**
			 * Ignore the user setting, use 'lifecycle' to update VM's info
			 *
			 */
			public void setMtime(String mtime) {
				this.mtime = mtime;
			}

			public String getMtime() {
				return this.mtime;
			}
		}

		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
		public static class Format {

			protected String _type;

			public Format() {
				this._type = "String";

			}

			/**
			 * Ignore the user setting, use 'lifecycle' to update VM's info
			 *
			 */
			public void set_type(String _type) {
				this._type = _type;
			}

			public String get_type() {
				return this._type;
			}
		}
	}
}
