package com.uit.cloud.kubernetes;

import com.alibaba.fastjson.JSON;
import com.github.kubesys.kubernetes.api.model.VirtualMachine;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Domain;

public class Main {

	
	public static String VM = "{\r\n" + 
			"    \"apiVersion\": \"cloudplus.io/v1alpha3\",\r\n" + 
			"    \"kind\": \"VirtualMachine\",\r\n" + 
			"    \"metadata\": {\r\n" + 
			"        \"creationTimestamp\": \"2019-11-22T00:37:22Z\",\r\n" + 
			"        \"generation\": 1,\r\n" + 
			"        \"labels\": {\r\n" + 
			"            \"host\": \"vm.worker1\"\r\n" + 
			"        },\r\n" + 
			"        \"name\": \"gzhu4\",\r\n" + 
			"        \"namespace\": \"default\",\r\n" + 
			"        \"resourceVersion\": \"4126\",\r\n" + 
			"        \"selfLink\": \"/apis/cloudplus.io/v1alpha3/namespaces/default/virtualmachines/gzhu4\",\r\n" + 
			"        \"uid\": \"3f5ea1ae-0cc0-11ea-869c-108184003a14\"\r\n" + 
			"    },\r\n" + 
			"    \"spec\": {\r\n" + 
			"        \"description\": {\r\n" + 
			"            \"lastOperationTimeStamp\": 1574383042467\r\n" + 
			"        },\r\n" + 
			"        \"domain\": {\r\n" + 
			"            \"_id\": 21,\r\n" + 
			"            \"_type\": \"kvm\",\r\n" + 
			"            \"clock\": {\r\n" + 
			"                \"_offset\": \"utc\"\r\n" + 
			"            },\r\n" + 
			"            \"cpu\": {\r\n" + 
			"                \"_check\": \"none\",\r\n" + 
			"                \"_mode\": \"host-passthrough\",\r\n" + 
			"                \"numa\": {\r\n" + 
			"                    \"cell\": [\r\n" + 
			"                        {\r\n" + 
			"                            \"_cpus\": 0,\r\n" + 
			"                            \"_id\": 0,\r\n" + 
			"                            \"_memAccess\": \"shared\",\r\n" + 
			"                            \"_memory\": 4194304,\r\n" + 
			"                            \"_unit\": \"KiB\"\r\n" + 
			"                        }\r\n" + 
			"                    ]\r\n" + 
			"                },\r\n" + 
			"                \"topology\": {\r\n" + 
			"                    \"_cores\": 1,\r\n" + 
			"                    \"_sockets\": 1,\r\n" + 
			"                    \"_threads\": 1\r\n" + 
			"                }\r\n" + 
			"            },\r\n" + 
			"            \"cputune\": {\r\n" + 
			"                \"emulatorpin\": {\r\n" + 
			"                    \"_cpuset\": \"4-5\"\r\n" + 
			"                },\r\n" + 
			"                \"shares\": {\r\n" + 
			"                    \"text\": 4096\r\n" + 
			"                },\r\n" + 
			"                \"vcpupin\": [\r\n" + 
			"                    {\r\n" + 
			"                        \"_cpuset\": 4,\r\n" + 
			"                        \"_vcpu\": 0\r\n" + 
			"                    }\r\n" + 
			"                ]\r\n" + 
			"            },\r\n" + 
			"            \"currentMemory\": {\r\n" + 
			"                \"_unit\": \"KiB\",\r\n" + 
			"                \"text\": 4194304\r\n" + 
			"            },\r\n" + 
			"            \"devices\": {\r\n" + 
			"                \"_interface\": [\r\n" + 
			"                    {\r\n" + 
			"                        \"_type\": \"vhostuser\",\r\n" + 
			"                        \"address\": {\r\n" + 
			"                            \"_bus\": \"0x01\",\r\n" + 
			"                            \"_domain\": \"0x0000\",\r\n" + 
			"                            \"_function\": \"0x0\",\r\n" + 
			"                            \"_slot\": \"0x00\",\r\n" + 
			"                            \"_type\": \"pci\"\r\n" + 
			"                        },\r\n" + 
			"                        \"alias\": {\r\n" + 
			"                            \"_name\": \"net0\"\r\n" + 
			"                        },\r\n" + 
			"                        \"mac\": {\r\n" + 
			"                            \"_address\": \"00:00:00:00:00:03\"\r\n" + 
			"                        },\r\n" + 
			"                        \"model\": {\r\n" + 
			"                            \"_type\": \"virtio\"\r\n" + 
			"                        },\r\n" + 
			"                        \"source\": {\r\n" + 
			"                            \"_mode\": \"client\",\r\n" + 
			"                            \"_path\": \"/usr/local/var/run/openvswitch/vhost-user3\",\r\n" + 
			"                            \"_type\": \"unix\"\r\n" + 
			"                        },\r\n" + 
			"                        \"target\": {\r\n" + 
			"                            \"_dev\": \"vhost-user3\"\r\n" + 
			"                        }\r\n" + 
			"                    },\r\n" + 
			"                    {\r\n" + 
			"                        \"_type\": \"direct\",\r\n" + 
			"                        \"address\": {\r\n" + 
			"                            \"_bus\": \"0x05\",\r\n" + 
			"                            \"_domain\": \"0x0000\",\r\n" + 
			"                            \"_function\": \"0x0\",\r\n" + 
			"                            \"_slot\": \"0x00\",\r\n" + 
			"                            \"_type\": \"pci\"\r\n" + 
			"                        },\r\n" + 
			"                        \"alias\": {\r\n" + 
			"                            \"_name\": \"net1\"\r\n" + 
			"                        },\r\n" + 
			"                        \"mac\": {\r\n" + 
			"                            \"_address\": \"52:54:00:ff:78:3a\"\r\n" + 
			"                        },\r\n" + 
			"                        \"model\": {\r\n" + 
			"                            \"_type\": \"virtio\"\r\n" + 
			"                        },\r\n" + 
			"                        \"source\": {\r\n" + 
			"                            \"_dev\": \"ovsbr1\",\r\n" + 
			"                            \"_mode\": \"bridge\"\r\n" + 
			"                        },\r\n" + 
			"                        \"target\": {\r\n" + 
			"                            \"_dev\": \"macvtap3\"\r\n" + 
			"                        }\r\n" + 
			"                    }\r\n" + 
			"                ],\r\n" + 
			"                \"console\": [\r\n" + 
			"                    {\r\n" + 
			"                        \"_tty\": \"/dev/pts/11\",\r\n" + 
			"                        \"_type\": \"pty\",\r\n" + 
			"                        \"alias\": {\r\n" + 
			"                            \"_name\": \"serial0\"\r\n" + 
			"                        },\r\n" + 
			"                        \"source\": {\r\n" + 
			"                            \"_path\": \"/dev/pts/11\"\r\n" + 
			"                        },\r\n" + 
			"                        \"target\": {\r\n" + 
			"                            \"_port\": 0,\r\n" + 
			"                            \"_type\": \"serial\"\r\n" + 
			"                        }\r\n" + 
			"                    }\r\n" + 
			"                ],\r\n" + 
			"                \"controller\": [\r\n" + 
			"                    {\r\n" + 
			"                        \"_index\": 0,\r\n" + 
			"                        \"_model\": \"ich9-ehci1\",\r\n" + 
			"                        \"_type\": \"usb\",\r\n" + 
			"                        \"address\": {\r\n" + 
			"                            \"_bus\": \"0x03\",\r\n" + 
			"                            \"_domain\": \"0x0000\",\r\n" + 
			"                            \"_function\": \"0x7\",\r\n" + 
			"                            \"_slot\": \"0x01\",\r\n" + 
			"                            \"_type\": \"pci\"\r\n" + 
			"                        },\r\n" + 
			"                        \"alias\": {\r\n" + 
			"                            \"_name\": \"usb\"\r\n" + 
			"                        }\r\n" + 
			"                    },\r\n" + 
			"                    {\r\n" + 
			"                        \"_index\": 0,\r\n" + 
			"                        \"_model\": \"ich9-uhci1\",\r\n" + 
			"                        \"_type\": \"usb\",\r\n" + 
			"                        \"address\": {\r\n" + 
			"                            \"_bus\": \"0x03\",\r\n" + 
			"                            \"_domain\": \"0x0000\",\r\n" + 
			"                            \"_function\": \"0x0\",\r\n" + 
			"                            \"_multifunction\": \"on\",\r\n" + 
			"                            \"_slot\": \"0x01\",\r\n" + 
			"                            \"_type\": \"pci\"\r\n" + 
			"                        },\r\n" + 
			"                        \"alias\": {\r\n" + 
			"                            \"_name\": \"usb\"\r\n" + 
			"                        },\r\n" + 
			"                        \"master\": {\r\n" + 
			"                            \"_startport\": 0\r\n" + 
			"                        }\r\n" + 
			"                    },\r\n" + 
			"                    {\r\n" + 
			"                        \"_index\": 0,\r\n" + 
			"                        \"_model\": \"ich9-uhci2\",\r\n" + 
			"                        \"_type\": \"usb\",\r\n" + 
			"                        \"address\": {\r\n" + 
			"                            \"_bus\": \"0x03\",\r\n" + 
			"                            \"_domain\": \"0x0000\",\r\n" + 
			"                            \"_function\": \"0x1\",\r\n" + 
			"                            \"_slot\": \"0x01\",\r\n" + 
			"                            \"_type\": \"pci\"\r\n" + 
			"                        },\r\n" + 
			"                        \"alias\": {\r\n" + 
			"                            \"_name\": \"usb\"\r\n" + 
			"                        },\r\n" + 
			"                        \"master\": {\r\n" + 
			"                            \"_startport\": 2\r\n" + 
			"                        }\r\n" + 
			"                    },\r\n" + 
			"                    {\r\n" + 
			"                        \"_index\": 0,\r\n" + 
			"                        \"_model\": \"ich9-uhci3\",\r\n" + 
			"                        \"_type\": \"usb\",\r\n" + 
			"                        \"address\": {\r\n" + 
			"                            \"_bus\": \"0x03\",\r\n" + 
			"                            \"_domain\": \"0x0000\",\r\n" + 
			"                            \"_function\": \"0x2\",\r\n" + 
			"                            \"_slot\": \"0x01\",\r\n" + 
			"                            \"_type\": \"pci\"\r\n" + 
			"                        },\r\n" + 
			"                        \"alias\": {\r\n" + 
			"                            \"_name\": \"usb\"\r\n" + 
			"                        },\r\n" + 
			"                        \"master\": {\r\n" + 
			"                            \"_startport\": 4\r\n" + 
			"                        }\r\n" + 
			"                    },\r\n" + 
			"                    {\r\n" + 
			"                        \"_index\": 0,\r\n" + 
			"                        \"_model\": \"virtio-scsi\",\r\n" + 
			"                        \"_type\": \"scsi\",\r\n" + 
			"                        \"address\": {\r\n" + 
			"                            \"_bus\": \"0x04\",\r\n" + 
			"                            \"_domain\": \"0x0000\",\r\n" + 
			"                            \"_function\": \"0x0\",\r\n" + 
			"                            \"_slot\": \"0x00\",\r\n" + 
			"                            \"_type\": \"pci\"\r\n" + 
			"                        },\r\n" + 
			"                        \"alias\": {\r\n" + 
			"                            \"_name\": \"scsi0\"\r\n" + 
			"                        }\r\n" + 
			"                    },\r\n" + 
			"                    {\r\n" + 
			"                        \"_index\": 0,\r\n" + 
			"                        \"_model\": \"pcie-root\",\r\n" + 
			"                        \"_type\": \"pci\",\r\n" + 
			"                        \"alias\": {\r\n" + 
			"                            \"_name\": \"pcie.0\"\r\n" + 
			"                        }\r\n" + 
			"                    },\r\n" + 
			"                    {\r\n" + 
			"                        \"_index\": 1,\r\n" + 
			"                        \"_model\": \"pcie-root-port\",\r\n" + 
			"                        \"_type\": \"pci\",\r\n" + 
			"                        \"address\": {\r\n" + 
			"                            \"_bus\": \"0x00\",\r\n" + 
			"                            \"_domain\": \"0x0000\",\r\n" + 
			"                            \"_function\": \"0x0\",\r\n" + 
			"                            \"_multifunction\": \"on\",\r\n" + 
			"                            \"_slot\": \"0x01\",\r\n" + 
			"                            \"_type\": \"pci\"\r\n" + 
			"                        },\r\n" + 
			"                        \"alias\": {\r\n" + 
			"                            \"_name\": \"pci.1\"\r\n" + 
			"                        },\r\n" + 
			"                        \"model\": {\r\n" + 
			"                            \"_name\": \"pcie-root-port\"\r\n" + 
			"                        },\r\n" + 
			"                        \"target\": {\r\n" + 
			"                            \"_chassis\": 1,\r\n" + 
			"                            \"_port\": \"0x8\"\r\n" + 
			"                        }\r\n" + 
			"                    },\r\n" + 
			"                    {\r\n" + 
			"                        \"_index\": 2,\r\n" + 
			"                        \"_model\": \"dmi-to-pci-bridge\",\r\n" + 
			"                        \"_type\": \"pci\",\r\n" + 
			"                        \"address\": {\r\n" + 
			"                            \"_bus\": \"0x00\",\r\n" + 
			"                            \"_domain\": \"0x0000\",\r\n" + 
			"                            \"_function\": \"0x0\",\r\n" + 
			"                            \"_slot\": \"0x02\",\r\n" + 
			"                            \"_type\": \"pci\"\r\n" + 
			"                        },\r\n" + 
			"                        \"alias\": {\r\n" + 
			"                            \"_name\": \"pci.2\"\r\n" + 
			"                        },\r\n" + 
			"                        \"model\": {\r\n" + 
			"                            \"_name\": \"i82801b11-bridge\"\r\n" + 
			"                        }\r\n" + 
			"                    },\r\n" + 
			"                    {\r\n" + 
			"                        \"_index\": 3,\r\n" + 
			"                        \"_model\": \"pci-bridge\",\r\n" + 
			"                        \"_type\": \"pci\",\r\n" + 
			"                        \"address\": {\r\n" + 
			"                            \"_bus\": \"0x02\",\r\n" + 
			"                            \"_domain\": \"0x0000\",\r\n" + 
			"                            \"_function\": \"0x0\",\r\n" + 
			"                            \"_slot\": \"0x00\",\r\n" + 
			"                            \"_type\": \"pci\"\r\n" + 
			"                        },\r\n" + 
			"                        \"alias\": {\r\n" + 
			"                            \"_name\": \"pci.3\"\r\n" + 
			"                        },\r\n" + 
			"                        \"model\": {\r\n" + 
			"                            \"_name\": \"pci-bridge\"\r\n" + 
			"                        },\r\n" + 
			"                        \"target\": {\r\n" + 
			"                            \"_chassisNr\": 3\r\n" + 
			"                        }\r\n" + 
			"                    },\r\n" + 
			"                    {\r\n" + 
			"                        \"_index\": 4,\r\n" + 
			"                        \"_model\": \"pcie-root-port\",\r\n" + 
			"                        \"_type\": \"pci\",\r\n" + 
			"                        \"address\": {\r\n" + 
			"                            \"_bus\": \"0x00\",\r\n" + 
			"                            \"_domain\": \"0x0000\",\r\n" + 
			"                            \"_function\": \"0x1\",\r\n" + 
			"                            \"_slot\": \"0x01\",\r\n" + 
			"                            \"_type\": \"pci\"\r\n" + 
			"                        },\r\n" + 
			"                        \"alias\": {\r\n" + 
			"                            \"_name\": \"pci.4\"\r\n" + 
			"                        },\r\n" + 
			"                        \"model\": {\r\n" + 
			"                            \"_name\": \"pcie-root-port\"\r\n" + 
			"                        },\r\n" + 
			"                        \"target\": {\r\n" + 
			"                            \"_chassis\": 4,\r\n" + 
			"                            \"_port\": \"0x9\"\r\n" + 
			"                        }\r\n" + 
			"                    },\r\n" + 
			"                    {\r\n" + 
			"                        \"_index\": 5,\r\n" + 
			"                        \"_model\": \"pcie-root-port\",\r\n" + 
			"                        \"_type\": \"pci\",\r\n" + 
			"                        \"address\": {\r\n" + 
			"                            \"_bus\": \"0x00\",\r\n" + 
			"                            \"_domain\": \"0x0000\",\r\n" + 
			"                            \"_function\": \"0x2\",\r\n" + 
			"                            \"_slot\": \"0x01\",\r\n" + 
			"                            \"_type\": \"pci\"\r\n" + 
			"                        },\r\n" + 
			"                        \"alias\": {\r\n" + 
			"                            \"_name\": \"pci.5\"\r\n" + 
			"                        },\r\n" + 
			"                        \"model\": {\r\n" + 
			"                            \"_name\": \"pcie-root-port\"\r\n" + 
			"                        },\r\n" + 
			"                        \"target\": {\r\n" + 
			"                            \"_chassis\": 5,\r\n" + 
			"                            \"_port\": \"0xa\"\r\n" + 
			"                        }\r\n" + 
			"                    }\r\n" + 
			"                ],\r\n" + 
			"                \"disk\": [\r\n" + 
			"                    {\r\n" + 
			"                        \"_device\": \"disk\",\r\n" + 
			"                        \"_type\": \"file\",\r\n" + 
			"                        \"address\": {\r\n" + 
			"                            \"_bus\": 0,\r\n" + 
			"                            \"_controller\": 0,\r\n" + 
			"                            \"_target\": 0,\r\n" + 
			"                            \"_type\": \"drive\",\r\n" + 
			"                            \"_unit\": 0\r\n" + 
			"                        },\r\n" + 
			"                        \"alias\": {\r\n" + 
			"                            \"_name\": \"scsi0-0-0-0\"\r\n" + 
			"                        },\r\n" + 
			"                        \"backingStore\": {},\r\n" + 
			"                        \"driver\": {\r\n" + 
			"                            \"_name\": \"qemu\",\r\n" + 
			"                            \"_type\": \"qcow2\"\r\n" + 
			"                        },\r\n" + 
			"                        \"source\": {\r\n" + 
			"                            \"_file\": \"/var/lib/libvirt/images/gzhu4.qcow2\"\r\n" + 
			"                        },\r\n" + 
			"                        \"target\": {\r\n" + 
			"                            \"_bus\": \"scsi\",\r\n" + 
			"                            \"_dev\": \"sda\"\r\n" + 
			"                        }\r\n" + 
			"                    },\r\n" + 
			"                    {\r\n" + 
			"                        \"_device\": \"cdrom\",\r\n" + 
			"                        \"_type\": \"file\",\r\n" + 
			"                        \"address\": {\r\n" + 
			"                            \"_bus\": 0,\r\n" + 
			"                            \"_controller\": 0,\r\n" + 
			"                            \"_target\": 0,\r\n" + 
			"                            \"_type\": \"drive\",\r\n" + 
			"                            \"_unit\": 1\r\n" + 
			"                        },\r\n" + 
			"                        \"alias\": {\r\n" + 
			"                            \"_name\": \"scsi0-0-0-1\"\r\n" + 
			"                        },\r\n" + 
			"                        \"readonly\": {},\r\n" + 
			"                        \"target\": {\r\n" + 
			"                            \"_bus\": \"scsi\",\r\n" + 
			"                            \"_dev\": \"sdb\"\r\n" + 
			"                        }\r\n" + 
			"                    }\r\n" + 
			"                ],\r\n" + 
			"                \"emulator\": {\r\n" + 
			"                    \"text\": \"/usr/bin/kvm\"\r\n" + 
			"                },\r\n" + 
			"                \"graphics\": [\r\n" + 
			"                    {\r\n" + 
			"                        \"_autoport\": \"yes\",\r\n" + 
			"                        \"_listen\": \"127.0.0.1\",\r\n" + 
			"                        \"_port\": 5904,\r\n" + 
			"                        \"_type\": \"vnc\",\r\n" + 
			"                        \"listen\": {\r\n" + 
			"                            \"_address\": \"127.0.0.1\",\r\n" + 
			"                            \"_type\": \"address\"\r\n" + 
			"                        }\r\n" + 
			"                    }\r\n" + 
			"                ],\r\n" + 
			"                \"input\": [\r\n" + 
			"                    {\r\n" + 
			"                        \"_bus\": \"usb\",\r\n" + 
			"                        \"_type\": \"keyboard\",\r\n" + 
			"                        \"address\": {\r\n" + 
			"                            \"_bus\": 0,\r\n" + 
			"                            \"_port\": 1,\r\n" + 
			"                            \"_type\": \"usb\"\r\n" + 
			"                        },\r\n" + 
			"                        \"alias\": {\r\n" + 
			"                            \"_name\": \"input0\"\r\n" + 
			"                        }\r\n" + 
			"                    },\r\n" + 
			"                    {\r\n" + 
			"                        \"_bus\": \"usb\",\r\n" + 
			"                        \"_type\": \"mouse\",\r\n" + 
			"                        \"address\": {\r\n" + 
			"                            \"_bus\": 0,\r\n" + 
			"                            \"_port\": 2,\r\n" + 
			"                            \"_type\": \"usb\"\r\n" + 
			"                        },\r\n" + 
			"                        \"alias\": {\r\n" + 
			"                            \"_name\": \"input1\"\r\n" + 
			"                        }\r\n" + 
			"                    }\r\n" + 
			"                ],\r\n" + 
			"                \"serial\": [\r\n" + 
			"                    {\r\n" + 
			"                        \"_type\": \"pty\",\r\n" + 
			"                        \"alias\": {\r\n" + 
			"                            \"_name\": \"serial0\"\r\n" + 
			"                        },\r\n" + 
			"                        \"source\": {\r\n" + 
			"                            \"_path\": \"/dev/pts/11\"\r\n" + 
			"                        },\r\n" + 
			"                        \"target\": {\r\n" + 
			"                            \"_port\": 0,\r\n" + 
			"                            \"_type\": \"system-serial\",\r\n" + 
			"                            \"model\": {\r\n" + 
			"                                \"_name\": \"pl011\"\r\n" + 
			"                            }\r\n" + 
			"                        }\r\n" + 
			"                    }\r\n" + 
			"                ],\r\n" + 
			"                \"video\": [\r\n" + 
			"                    {\r\n" + 
			"                        \"address\": {\r\n" + 
			"                            \"_bus\": \"0x03\",\r\n" + 
			"                            \"_domain\": \"0x0000\",\r\n" + 
			"                            \"_function\": \"0x0\",\r\n" + 
			"                            \"_slot\": \"0x02\",\r\n" + 
			"                            \"_type\": \"pci\"\r\n" + 
			"                        },\r\n" + 
			"                        \"alias\": {\r\n" + 
			"                            \"_name\": \"video0\"\r\n" + 
			"                        },\r\n" + 
			"                        \"model\": {\r\n" + 
			"                            \"_heads\": 1,\r\n" + 
			"                            \"_primary\": \"yes\",\r\n" + 
			"                            \"_type\": \"vga\",\r\n" + 
			"                            \"_vram\": 16384\r\n" + 
			"                        }\r\n" + 
			"                    }\r\n" + 
			"                ]\r\n" + 
			"            },\r\n" + 
			"            \"features\": {\r\n" + 
			"                \"acpi\": {},\r\n" + 
			"                \"gic\": {\r\n" + 
			"                    \"_version\": 3\r\n" + 
			"                }\r\n" + 
			"            },\r\n" + 
			"            \"memory\": {\r\n" + 
			"                \"_unit\": \"KiB\",\r\n" + 
			"                \"text\": 4194304\r\n" + 
			"            },\r\n" + 
			"            \"memoryBacking\": {\r\n" + 
			"                \"hugepages\": {\r\n" + 
			"                    \"page\": [\r\n" + 
			"                        {\r\n" + 
			"                            \"_nodeset\": 0,\r\n" + 
			"                            \"_size\": 524288,\r\n" + 
			"                            \"_unit\": \"KiB\"\r\n" + 
			"                        }\r\n" + 
			"                    ]\r\n" + 
			"                }\r\n" + 
			"            },\r\n" + 
			"            \"name\": {\r\n" + 
			"                \"text\": \"gzhu4\"\r\n" + 
			"            },\r\n" + 
			"            \"on_crash\": {\r\n" + 
			"                \"text\": \"restart\"\r\n" + 
			"            },\r\n" + 
			"            \"on_poweroff\": {\r\n" + 
			"                \"text\": \"destroy\"\r\n" + 
			"            },\r\n" + 
			"            \"on_reboot\": {\r\n" + 
			"                \"text\": \"restart\"\r\n" + 
			"            },\r\n" + 
			"            \"os\": {\r\n" + 
			"                \"boot\": [\r\n" + 
			"                    {\r\n" + 
			"                        \"_dev\": \"hd\"\r\n" + 
			"                    }\r\n" + 
			"                ],\r\n" + 
			"                \"loader\": {\r\n" + 
			"                    \"_readonly\": \"yes\",\r\n" + 
			"                    \"_type\": \"pflash\",\r\n" + 
			"                    \"text\": \"/usr/share/AAVMF/AAVMF_CODE.fd\"\r\n" + 
			"                },\r\n" + 
			"                \"nvram\": {\r\n" + 
			"                    \"text\": \"/var/lib/libvirt/qemu/nvram/gzhu4_VARS.fd\"\r\n" + 
			"                },\r\n" + 
			"                \"type\": {\r\n" + 
			"                    \"_arch\": \"aarch64\",\r\n" + 
			"                    \"_machine\": \"virt-2.11\",\r\n" + 
			"                    \"text\": \"hvm\"\r\n" + 
			"                }\r\n" + 
			"            },\r\n" + 
			"            \"resource\": {\r\n" + 
			"                \"partition\": {\r\n" + 
			"                    \"text\": \"/machine\"\r\n" + 
			"                }\r\n" + 
			"            },\r\n" + 
			"            \"seclabel\": [\r\n" + 
			"                {\r\n" + 
			"                    \"_model\": \"dac\",\r\n" + 
			"                    \"_relabel\": \"yes\",\r\n" + 
			"                    \"_type\": \"dynamic\",\r\n" + 
			"                    \"imagelabel\": {\r\n" + 
			"                        \"text\": \"+0:+0\"\r\n" + 
			"                    },\r\n" + 
			"                    \"label\": {\r\n" + 
			"                        \"text\": \"+0:+0\"\r\n" + 
			"                    }\r\n" + 
			"                }\r\n" + 
			"            ],\r\n" + 
			"            \"uuid\": {\r\n" + 
			"                \"text\": \"6be24b64-e092-4dd5-b1e5-a88e3be9776c\"\r\n" + 
			"            },\r\n" + 
			"            \"vcpu\": {\r\n" + 
			"                \"_placement\": \"static\",\r\n" + 
			"                \"text\": 1\r\n" + 
			"            }\r\n" + 
			"        },\r\n" + 
			"        \"nodeName\": \"vm.worker1\",\r\n" + 
			"        \"status\": {\r\n" + 
			"            \"conditions\": {\r\n" + 
			"                \"state\": {\r\n" + 
			"                    \"waiting\": {\r\n" + 
			"                        \"message\": \"The VM is Running\",\r\n" + 
			"                        \"reason\": \"Running\"\r\n" + 
			"                    }\r\n" + 
			"                }\r\n" + 
			"            }\r\n" + 
			"        }\r\n" + 
			"    }\r\n" + 
			"}\r\n" + 
			"";
	
	public static void main(String[] args) {
		System.out.println(JSON.parseObject(VM, VirtualMachine.class));
	}

}
