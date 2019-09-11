/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.api.model.virtualmachinedisk;

import java.util.List;

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

	protected Name name;

	protected Source source;

	protected Physical physical;

	protected Key key;

	protected Capacity capacity;

	protected Target target;
	
	protected List<Snapshot> snapshot;
	
	protected BackingStroe backingStore;

	public List<Snapshot> getSnapshot() {
		return snapshot;
	}

	public void setSnapshot(List<Snapshot> snapshot) {
		this.snapshot = snapshot;
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

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
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
	
	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
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

	public BackingStroe getBackingStore() {
		return backingStore;
	}

	public void setBackingStore(BackingStroe backingStore) {
		this.backingStore = backingStore;
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class BackingStroe {
		
		protected Format format;
		
		public BackingStroe() {
			super();
		}
		
		protected Path path;
		
		protected Permissions permissions;
		
		protected Timestamps timestamps;

		public Format getFormat() {
			return format;
		}

		public void setFormat(Format format) {
			this.format = format;
		}

		public Path getPath() {
			return path;
		}

		public void setPath(Path path) {
			this.path = path;
		}

		public Permissions getPermissions() {
			return permissions;
		}

		public void setPermissions(Permissions permissions) {
			this.permissions = permissions;
		}

		public Timestamps getTimestamps() {
			return timestamps;
		}

		public void setTimestamps(Timestamps timestamps) {
			this.timestamps = timestamps;
		}
		
		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
		public static class Format {
			
			protected String _type;

			public String get_type() {
				return _type;
			}

			public void set_type(String _type) {
				this._type = _type;
			}
			
		}
		
		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
		public static class Path {
			
			protected String text;

			public String getText() {
				return text;
			}

			public void setText(String text) {
				this.text = text;
			}
			
		}
		
		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
		public static class Permissions {
			
			protected Group group;
			
			protected Mode mode;
			
			protected Owner owner;
			
			public Group getGroup() {
				return group;
			}

			public void setGroup(Group group) {
				this.group = group;
			}

			public Mode getMode() {
				return mode;
			}

			public void setMode(Mode mode) {
				this.mode = mode;
			}

			public Owner getOwner() {
				return owner;
			}

			public void setOwner(Owner owner) {
				this.owner = owner;
			}

			@JsonInclude(JsonInclude.Include.NON_NULL)
			@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
			public static class Group {
				
				protected String text;

				public String getText() {
					return text;
				}

				public void setText(String text) {
					this.text = text;
				}
				
			}
			
			@JsonInclude(JsonInclude.Include.NON_NULL)
			@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
			public static class Mode {
				
				protected String text;

				public String getText() {
					return text;
				}

				public void setText(String text) {
					this.text = text;
				}
				
			}
			
			@JsonInclude(JsonInclude.Include.NON_NULL)
			@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
			public static class Owner {
				
				protected String text;

				public String getText() {
					return text;
				}

				public void setText(String text) {
					this.text = text;
				}
				
			}
		}
		
		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
		public static class Timestamps {
			
			protected Atime atime;
			
			protected Ctime ctime;
			
			protected Mtime mtime;
			
			public Atime getAtime() {
				return atime;
			}

			public void setAtime(Atime atime) {
				this.atime = atime;
			}

			public Ctime getCtime() {
				return ctime;
			}

			public void setCtime(Ctime ctime) {
				this.ctime = ctime;
			}

			public Mtime getMtime() {
				return mtime;
			}

			public void setMtime(Mtime mtime) {
				this.mtime = mtime;
			}

			@JsonInclude(JsonInclude.Include.NON_NULL)
			@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
			public static class Atime {
				
				protected String text;

				public String getText() {
					return text;
				}

				public void setText(String text) {
					this.text = text;
				}
			}
			
			@JsonInclude(JsonInclude.Include.NON_NULL)
			@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
			public static class Ctime {
			
				protected String text;

				public String getText() {
					return text;
				}

				public void setText(String text) {
					this.text = text;
				}
			}
			
			@JsonInclude(JsonInclude.Include.NON_NULL)
			@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
			public static class Mtime {
				
				protected String text;

				public String getText() {
					return text;
				}

				public void setText(String text) {
					this.text = text;
				}
			}
			
		}
		
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class Name {
		
		protected String text;

		public Name() {
			super();
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
		
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class Key {
		
		protected String text;

		public Key() {
			super();
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
		
	}
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class Allocation {

		protected String _unit;

		protected String text;

		public Allocation() {

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

		protected Path path;

		protected Permissions permissions;

		protected Timestamps timestamps;

		protected Format format;
		
		protected Compat compat;
		
		protected Features features;

		public Target() {
		}

		public Compat getCompat() {
			return compat;
		}

		public void setCompat(Compat compat) {
			this.compat = compat;
		}

		
		public Features getFeatures() {
			return features;
		}

		public void setFeatures(Features features) {
			this.features = features;
		}

		/**
		 * Ignore the user setting, use 'lifecycle' to update VM's info
		 *
		 */
		public Path getPath() {
			return path;
		}


		public void setPath(Path path) {
			this.path = path;
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
		public static class Features {

			protected Lazy_refcounts lazy_refcounts;
			
			public Features() {
				super();
			}

			public Lazy_refcounts getLazy_refcounts() {
				return lazy_refcounts;
			}

			public void setLazy_refcounts(Lazy_refcounts lazy_refcounts) {
				this.lazy_refcounts = lazy_refcounts;
			}
			
			
		}
		
		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
		public static class Lazy_refcounts {
			
			public Lazy_refcounts() {
				super();
			}

		}
		
		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
		public static class Compat {
			
			protected String text;

			public Compat() {
				super();
			}

			public String getText() {
				return text;
			}

			public void setText(String text) {
				this.text = text;
			}
			
		}
		
		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
		public static class Path {
			
			protected String text;

			public Path() {
				super();
			}

			public String getText() {
				return text;
			}

			public void setText(String text) {
				this.text = text;
			}
			
		}
		
		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
		public static class Permissions {

			protected Mode mode;

			protected Owner owner;

			protected Group group;

			public Permissions() {
			}

			public Mode getMode() {
				return mode;
			}

			public void setMode(Mode mode) {
				this.mode = mode;
			}

			public Owner getOwner() {
				return owner;
			}

			public void setOwner(Owner owner) {
				this.owner = owner;
			}

			public Group getGroup() {
				return group;
			}

			public void setGroup(Group group) {
				this.group = group;
			}

			
		}

		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
		public static class Mode {
			
			protected String text;

			public Mode() {
				super();
			}

			public String getText() {
				return text;
			}

			public void setText(String text) {
				this.text = text;
			}
			
		}
		
		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
		public static class Owner {
			
			protected String text;

			public Owner() {
				super();
			}

			public String getText() {
				return text;
			}

			public void setText(String text) {
				this.text = text;
			}
			
		}
		
		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
		public static class Group {
			
			protected String text;

			public Group() {
				super();
			}

			public String getText() {
				return text;
			}

			public void setText(String text) {
				this.text = text;
			}
			
		}
		
		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
		public static class Timestamps {

			protected Atime atime;

			protected Ctime ctime;

			protected Mtime mtime;

			public Timestamps() {
			}

			public Atime getAtime() {
				return atime;
			}

			public void setAtime(Atime atime) {
				this.atime = atime;
			}

			public Ctime getCtime() {
				return ctime;
			}

			public void setCtime(Ctime ctime) {
				this.ctime = ctime;
			}

			public Mtime getMtime() {
				return mtime;
			}

			public void setMtime(Mtime mtime) {
				this.mtime = mtime;
			}

		}
		
		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
		public static class Atime {
			
			protected String text;

			public Atime() {
				super();
			}

			public String getText() {
				return text;
			}

			public void setText(String text) {
				this.text = text;
			}
			
		}
		
		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
		public static class Ctime {
			
			protected String text;

			public Ctime() {
				super();
			}

			public String getText() {
				return text;
			}

			public void setText(String text) {
				this.text = text;
			}
			
		}
		
		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
		public static class Mtime {
			
			protected String text;

			public Mtime() {
				super();
			}

			public String getText() {
				return text;
			}

			public void setText(String text) {
				this.text = text;
			}
			
		}

		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
		public static class Format {

			protected String _type;

			public Format() {
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
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
	public static class Snapshot {
		
		protected String date;

		protected String id;
		
		protected String name;
		
		public String getDate() {
			return date;
		}
		
		public void setDate(String date) {
			this.date = date;
		}
		
		public String getId() {
			return id;
		}
		
		public void setId(String id) {
			this.id = id;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
	}
}
