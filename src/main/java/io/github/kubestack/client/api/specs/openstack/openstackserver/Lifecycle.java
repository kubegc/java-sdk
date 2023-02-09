package io.github.kubestack.client.api.specs.openstack.openstackserver;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.github.kubestack.core.annotations.ClassDescriber;

/**
 * @Description openstack function support
 * @Date 2023/2/8 14:17
 * @Author guohao
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@ClassDescriber(value = "OpenstackServer", desc = "Openstack 虚拟机支持操作")
public class Lifecycle {
    @JsonProperty("CreateComputeV2Servers")
    protected CreateServer createServer;

    public CreateServer getCreateServer() {
        return createServer;
    }

    public void setCreateServer(CreateServer createServer) {
        this.createServer = createServer;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
    @JsonRootName("CreateComputeV2Servers")
    public static class CreateServer {
        @JsonProperty("opts")
        protected Opts opts;

        public CreateServer() {
            opts = new Opts();
        }

        public Opts getOpts() {
            return opts;
        }

        public void setOpts(Opts opts) {
            this.opts = opts;
        }

        public static class Opts {
            @JsonProperty("name")
            protected String name;
            @JsonProperty("imageRef")
            protected String imageRef;
            @JsonProperty("flavorRef")
            protected String flavorRef;
            @JsonProperty("security_groups")
            protected List<String> securityGroups;
            @JsonProperty("user_data")
            protected String userData;
            @JsonProperty("availability_zone")
            protected String availabilityZone;
            @JsonProperty("networks")
            protected List<NovaNetworkCreate> networks;
            @JsonProperty("metadata")
            protected Map<String, String> metadata;
            protected List<Personality> personality;
            @JsonProperty("config_drive")
            protected Boolean configDrive;
            protected String adminPass;
            protected String accessIPv4;
            protected String accessIPv6;
            protected Integer min;
            protected Integer max;
            protected List<String> tags;

            public Opts() {}

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImageRef() {
                return imageRef;
            }

            public void setImageRef(String imageRef) {
                this.imageRef = imageRef;
            }

            public String getFlavorRef() {
                return flavorRef;
            }

            public void setFlavorRef(String flavorRef) {
                this.flavorRef = flavorRef;
            }

            public List<String> getSecurityGroups() {
                return securityGroups;
            }

            public void setSecurityGroups(List<String> securityGroups) {
                this.securityGroups = securityGroups;
            }

            public String getUserData() {
                return userData;
            }

            public void setUserData(String userData) {
                this.userData = userData;
            }

            public String getAvailabilityZone() {
                return availabilityZone;
            }

            public void setAvailabilityZone(String availabilityZone) {
                this.availabilityZone = availabilityZone;
            }

            public List<NovaNetworkCreate> getNetworks() {
                return networks;
            }

            public void setNetworks(List<NovaNetworkCreate> networks) {
                this.networks = networks;
            }

            public Map<String, String> getMetadata() {
                return metadata;
            }

            public void setMetadata(Map<String, String> metadata) {
                this.metadata = metadata;
            }

            public List<Personality> getPersonality() {
                return personality;
            }

            public void setPersonality(List<Personality> personality) {
                this.personality = personality;
            }

            public Boolean getConfigDrive() {
                return configDrive;
            }

            public void setConfigDrive(Boolean configDrive) {
                this.configDrive = configDrive;
            }

            public String getAdminPass() {
                return adminPass;
            }

            public void setAdminPass(String adminPass) {
                this.adminPass = adminPass;
            }

            public String getAccessIPv4() {
                return accessIPv4;
            }

            public void setAccessIPv4(String accessIPv4) {
                this.accessIPv4 = accessIPv4;
            }

            public String getAccessIPv6() {
                return accessIPv6;
            }

            public void setAccessIPv6(String accessIPv6) {
                this.accessIPv6 = accessIPv6;
            }

            public Integer getMin() {
                return min;
            }

            public void setMin(Integer min) {
                this.min = min;
            }

            public Integer getMax() {
                return max;
            }

            public void setMax(Integer max) {
                this.max = max;
            }

            public List<String> getTags() {
                return tags;
            }

            public void setTags(List<String> tags) {
                this.tags = tags;
            }

            public NovaNetworkCreate NewNovaNetworkCreate() {
                return new NovaNetworkCreate();
            }

            @JsonInclude(JsonInclude.Include.NON_NULL)
            @JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
            public static class NovaNetworkCreate {
                protected String UUID;
                protected String Port;
                protected String FixedIP;
                protected String Tag;

                public NovaNetworkCreate() {}

                public String getUUID() {
                    return UUID;
                }

                public void setUUID(String UUID) {
                    this.UUID = UUID;
                }

                public String getPort() {
                    return Port;
                }

                public void setPort(String port) {
                    Port = port;
                }

                public String getFixedIP() {
                    return FixedIP;
                }

                public void setFixedIP(String fixedIP) {
                    FixedIP = fixedIP;
                }

                public String getTag() {
                    return Tag;
                }

                public void setTag(String tag) {
                    Tag = tag;
                }
            }

            @JsonInclude(JsonInclude.Include.NON_NULL)
            @JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
            public static class Personality {
                protected String path;
                protected String contents;

                public Personality(String path) {
                    this.path = path;
                }

                public String getPath() {
                    return path;
                }

                public void setPath(String path) {
                    this.path = path;
                }

                public String getContents() {
                    return contents;
                }

                public void setContents(String contents) {
                    this.contents = contents;
                }
            }
        }

    }
}
