# 文档简介

	本文档用于说明基于Kubernetes的虚拟机生命周期如何管理, 项目地址：https://github.com/kubesys/kubeext-jdk.
	本文有两种通用的约束:
		(1)名称：只允许小写字母和数字组合，8-32位
		(2)路径：必须是/xx/xx形式，且在/var/lib/libvirt目录下，xx允许小写字母、数字、中划线、下划线和点，8-32位


# 1 VirtualMachine

虚拟机是指安装了OS的磁盘.VirtualMachine所有操作的返回值一样，见**[返回值]**

## 1.1 CreateAndStartVMFromISO(通过ISO安装虚拟机)

**接口功能:**
	通过光驱安装云OS，光驱必须存在只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CreateAndStartVMFromISO

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | createAndStartVMFromISO.name.001|
| nodeName | String | false | 选择部署的物理机，可以通过kubernetes.nodes().list进行查询 | node22 |
| createAndStartVMFromISO | CreateAndStartVMFromISO | true | 通过ISO安装虚拟机 | 详细见下 |
| eventId | String | fasle | 事件ID | createAndStartVMFromISO.event.001 |

对象createAndStartVMFromISO参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| metadata|String|false|用户生成虚拟机的元数据|uuid=950646e8-c17a-49d0-b83c-1c797811e001|
| graphics|String|true|虚拟机VNC/SPICE及其密码|vnc,listen=0.0.0.0,password=abcdefg|
| disk|String|true|虚拟机磁盘，包括硬盘和光驱|/var/lib/libvirt/images/test3.qcow2,read_bytes_sec=1024000000,write_bytes_sec=1024000000 --disk /opt/ISO/CentOS-7-x86_64-Minimal-1511.iso,device=cdrom,perms=ro|
| memory|String|true|虚拟机内存大小，单位为MiB|2048|
| network|String|true|虚拟机网络|type=l3bridge,source=br-int,inbound=102400,outbound=102400,ip=192.168.5.9,switch=switch|
| virt_type|String|false|虚拟化类型|kvm|
| os_variant|String|true|操作系统类型，如果不设置可能发生鼠标偏移等问题|centos7.0|
| vcpus|String|true|虚拟机CPU个数，及其物理CPU绑定关系|2,cpuset=1-4|
| cdrom|String|false|虚拟机挂载的光驱，重启失效|/var/lib/libvirt/ISO/CentOS-7-x86_64-Minimal-1511.iso|
| noautoconsole|Boolean|true|不自动连接到虚拟机终端，必须设置成true|true|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看CreateAndStartVMFromISOspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 1.2 CreateAndStartVMFromImage(通过镜像安装虚拟机)

**接口功能:**
	通过虚拟机镜像VirtualMachineImage创建云OS只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CreateAndStartVMFromImage

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | createAndStartVMFromImage.name.001|
| nodeName | String | false | 选择部署的物理机，可以通过kubernetes.nodes().list进行查询 | node22 |
| createAndStartVMFromImage | CreateAndStartVMFromImage | true | 通过镜像安装虚拟机 | 详细见下 |
| eventId | String | fasle | 事件ID | createAndStartVMFromImage.event.001 |

对象createAndStartVMFromImage参数说明:

## 1.3 ResizeRAM(虚拟机内存扩容)

**接口功能:**
	对虚拟机内存扩容，只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存在，即已调用过CreatePool, CreateSwitch, CreateDisk/CreateDiskImage, CreateAndStartVMFromISO/CreateAndStartVMFromImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ResizeRAM

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | resizeRAM.name.001|
| resizeRAM | ResizeRAM | true | 虚拟机内存扩容 | 详细见下 |
| eventId | String | fasle | 事件ID | resizeRAM.event.001 |

对象resizeRAM参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| current|Boolean|false|对当前虚拟机生效|true|
| size|String|true|内存大小，单位为KiB|1GiB: 1048576|
| config|Boolean|false|如果不设置，当前配置下次不会生效|true|
| live|Boolean|false|本次生效，如果虚拟机开机状态使用|true|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看ResizeRAMspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 1.4 SuspendVM(虚拟机暂停)

**接口功能:**
	对运行的虚拟机进行暂停操作，已经暂停虚拟机执行暂停会报错只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存在，即已调用过CreatePool, CreateSwitch, CreateDisk/CreateDiskImage, CreateAndStartVMFromISO/CreateAndStartVMFromImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.SuspendVM

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | suspendVM.name.001|
| suspendVM | SuspendVM | true | 虚拟机暂停 | 详细见下 |
| eventId | String | fasle | 事件ID | suspendVM.event.001 |

对象suspendVM参数说明:

## 1.5 StopVMForce(强制关闭虚拟机)

**接口功能:**
	强制关闭虚拟机，虚拟机在某些情况下无法关闭，本质相当于拔掉电源只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存在，即已调用过CreatePool, CreateSwitch, CreateDisk/CreateDiskImage, CreateAndStartVMFromISO/CreateAndStartVMFromImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StopVMForce

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | stopVMForce.name.001|
| stopVMForce | StopVMForce | true | 强制关闭虚拟机 | 详细见下 |
| eventId | String | fasle | 事件ID | stopVMForce.event.001 |

对象stopVMForce参数说明:

## 1.6 UnplugDevice(虚拟机卸载设备)

**接口功能:**
	卸载GPU、云盘、网卡等资源，只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存在，即已调用过CreatePool, CreateSwitch, CreateDisk/CreateDiskImage, CreateAndStartVMFromISO/CreateAndStartVMFromImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UnplugDevice

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | unplugDevice.name.001|
| unplugDevice | UnplugDevice | true | 虚拟机卸载设备 | 详细见下 |
| eventId | String | fasle | 事件ID | unplugDevice.event.001 |

对象unplugDevice参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| current|Boolean|false|对当前虚拟机生效|true|
| persistent|Boolean|false|对配置进行持久化|true|
| config|Boolean|false|如果不设置，当前配置下次不会生效|true|
| live|Boolean|false|立即生效，对于开机虚拟机|true|
| file|String|true|设备xml文件，可以是GPU、硬盘、网卡、光驱等|/var/lib/libvirt/unplug.xml|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看UnplugDevicespec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 1.7 UnplugNIC(虚拟机卸载网卡)

**接口功能:**
	卸载网卡，只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存在，即已调用过CreatePool, CreateSwitch, CreateDisk/CreateDiskImage, CreateAndStartVMFromISO/CreateAndStartVMFromImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UnplugNIC

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | unplugNIC.name.001|
| unplugNIC | UnplugNIC | true | 虚拟机卸载网卡 | 详细见下 |
| eventId | String | fasle | 事件ID | unplugNIC.event.001 |

对象unplugNIC参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| current|Boolean|false|对当前虚拟机生效|true|
| persistent|Boolean|false|对配置进行持久化|true|
| config|Boolean|false|如果不设置，当前配置下次不会生效|true|
| live|Boolean|false|立即生效，对于开机虚拟机|true|
| type|String|true|虚拟机网络类型|true|
| mac|String|true|mac地址|7e:0c:b0:ef:6a:04|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看UnplugNICspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 1.8 MigrateVM(虚拟机迁移)

**接口功能:**
	虚拟机迁移，必须依赖共享存储只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存在，即已调用过CreatePool, CreateSwitch, CreateDisk/CreateDiskImage, CreateAndStartVMFromISO/CreateAndStartVMFromImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.MigrateVM

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | migrateVM.name.001|
| migrateVM | MigrateVM | true | 虚拟机迁移 | 详细见下 |
| eventId | String | fasle | 事件ID | migrateVM.event.001 |

对象migrateVM参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看MigrateVMspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 1.9 ChangeNumberOfCPU(虚拟机CPU设置)

**接口功能:**
	修改虚拟机CPU个数只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存在，即已调用过CreatePool, CreateSwitch, CreateDisk/CreateDiskImage, CreateAndStartVMFromISO/CreateAndStartVMFromImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ChangeNumberOfCPU

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | changeNumberOfCPU.name.001|
| changeNumberOfCPU | ChangeNumberOfCPU | true | 虚拟机CPU设置 | 详细见下 |
| eventId | String | fasle | 事件ID | changeNumberOfCPU.event.001 |

对象changeNumberOfCPU参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| current|Boolean|false|对当前虚拟机生效|true|
| config|Boolean|false|如果不设置，当前配置下次不会生效|true|
| live|Boolean|false|立即生效，对于开机虚拟机|true|
| hotpluggable|Boolean|false|对于开机虚拟机进行运行时插拔，与--live等价|true|
| count|Integer|true|vcpu数量|16|
| guest|Boolean|false|修改虚拟机CPU状态|true|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看ChangeNumberOfCPUspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 1.10 ResumeVM(恢复虚拟机)

**接口功能:**
	恢复暂停的虚拟机，对运行的虚拟机执行恢复会报错只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存在，即已调用过CreatePool, CreateSwitch, CreateDisk/CreateDiskImage, CreateAndStartVMFromISO/CreateAndStartVMFromImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ResumeVM

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | resumeVM.name.001|
| resumeVM | ResumeVM | true | 恢复虚拟机 | 详细见下 |
| eventId | String | fasle | 事件ID | resumeVM.event.001 |

对象resumeVM参数说明:

## 1.11 PlugDisk(虚拟机添加云盘)

**接口功能:**
	添加云盘，云盘必须通过CreateVirtualMachineDisk预先创建好只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存在，即已调用过CreatePool, CreateSwitch, CreateDisk/CreateDiskImage, CreateAndStartVMFromISO/CreateAndStartVMFromImage,或CreateVirtualMachineDisk

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.PlugDisk

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | plugDisk.name.001|
| plugDisk | PlugDisk | true | 虚拟机添加云盘 | 详细见下 |
| eventId | String | fasle | 事件ID | plugDisk.event.001 |

对象plugDisk参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| persistent|Boolean|false|对配置进行持久化|true|
| config|Boolean|false|如果不设置，当前配置下次不会生效|true|
| live|Boolean|false|立即生效，对于开机虚拟机|true|
| iothread|String|false|立即生效，对于开机虚拟机|true|
| source|String|true|云盘源路径|/var/lib/libvirt/images/test1.qcow2|
| targetbus|String|false|虚拟的云盘总线类型，如果不填将根据target的取值自动匹配，例如vdX匹配为virtio类型的总线、sdX匹配为scsi类型的总线|virtio|
| subdriver|String|false|云盘子驱动类型|qcow2|
| target|String|true|目标盘符，对应虚拟机内看到的盘符号|vdc|
| mode|String|false|读写类型|shareable|
| driver|String|false|云盘驱动类型|qemu|
| read_bytes_sec|String|false|云盘读bps的QoS设置，单位为bytes|1GiB: 1073741824|
| write_bytes_sec|String|false|云盘写bps的QoS设置，单位为bytes|1GiB: 1073741824|
| read_iops_sec|String|false|云盘读iops的QoS设置|40000|
| write_iops_sec|String|false|云盘写iops的QoS设置|40000|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看PlugDiskspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 1.12 PlugDevice(虚拟机添加设备)

**接口功能:**
	添加GPU、云盘、网卡等，这种方法相对于pluginDisk等可设置高级选项，如QoS只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存在，即已调用过CreatePool, CreateSwitch, CreateDisk/CreateDiskImage, CreateAndStartVMFromISO/CreateAndStartVMFromImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.PlugDevice

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | plugDevice.name.001|
| plugDevice | PlugDevice | true | 虚拟机添加设备 | 详细见下 |
| eventId | String | fasle | 事件ID | plugDevice.event.001 |

对象plugDevice参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| current|Boolean|false|对当前虚拟机生效|true|
| persistent|Boolean|false|对配置进行持久化|true|
| config|Boolean|false|如果不设置，当前配置下次不会生效|true|
| live|Boolean|false|立即生效，对于开机虚拟机|true|
| file|String|true|设备xml文件，可以是GPU、硬盘、网卡、光驱等|/var/lib/libvirt/unplug.xml|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看PlugDevicespec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 1.13 ResetVM(强制重启虚拟机)

**接口功能:**
	强制重置虚拟机，即强制重启虚拟机只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存在，即已调用过CreatePool, CreateSwitch, CreateDisk/CreateDiskImage, CreateAndStartVMFromISO/CreateAndStartVMFromImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ResetVM

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | resetVM.name.001|
| resetVM | ResetVM | true | 强制重启虚拟机 | 详细见下 |
| eventId | String | fasle | 事件ID | resetVM.event.001 |

对象resetVM参数说明:

## 1.14 UnplugDisk(虚拟机卸载云盘)

**接口功能:**
	卸载虚拟机云盘只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存在，即已调用过CreatePool, CreateSwitch, CreateDisk/CreateDiskImage, CreateAndStartVMFromISO/CreateAndStartVMFromImage,或CreateVirtualMachineDisk

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UnplugDisk

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | unplugDisk.name.001|
| unplugDisk | UnplugDisk | true | 虚拟机卸载云盘 | 详细见下 |
| eventId | String | fasle | 事件ID | unplugDisk.event.001 |

对象unplugDisk参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| current|Boolean|false|对当前虚拟机生效|true|
| persistent|Boolean|false|对配置进行持久化|true|
| config|Boolean|false|如果不设置，当前配置下次不会生效|true|
| live|Boolean|false|立即生效，对于开机虚拟机|true|
| target|String|true|设备的目标，即在虚拟机中fdisk -l看到的硬盘标记|windows: hdb, Linux: vdb|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看UnplugDiskspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 1.15 StopVM(虚拟机关机)

**接口功能:**
	关闭虚拟机，但不一定能关闭，如虚拟机中OS受损，对关闭虚拟机再执行关闭会报错只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存在，即已调用过CreatePool, CreateSwitch, CreateDisk/CreateDiskImage, CreateAndStartVMFromISO/CreateAndStartVMFromImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StopVM

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | stopVM.name.001|
| stopVM | StopVM | true | 虚拟机关机 | 详细见下 |
| eventId | String | fasle | 事件ID | stopVM.event.001 |

对象stopVM参数说明:

## 1.16 StartVM(启动虚拟机)

**接口功能:**
	启动虚拟机，能否正常启动取决于虚拟机OS是否受损，对运行虚拟机执行启动会报错只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存在，即已调用过CreatePool, CreateSwitch, CreateDisk/CreateDiskImage, CreateAndStartVMFromISO/CreateAndStartVMFromImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StartVM

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | startVM.name.001|
| startVM | StartVM | true | 启动虚拟机 | 详细见下 |
| eventId | String | fasle | 事件ID | startVM.event.001 |

对象startVM参数说明:

## 1.17 DeleteVM(删除虚拟机)

**接口功能:**
	删除虚拟机，需要先关闭虚拟机只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存在，即已调用过CreatePool, CreateSwitch, CreateDisk/CreateDiskImage, CreateAndStartVMFromISO/CreateAndStartVMFromImage或StopVM，或StopVMForce

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.DeleteVM

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | deleteVM.name.001|
| deleteVM | DeleteVM | true | 删除虚拟机 | 详细见下 |
| eventId | String | fasle | 事件ID | deleteVM.event.001 |

对象deleteVM参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| delete_snapshots|Boolean|false|删除虚拟机所有快照，否则如果虚拟机还存在快照，会导致删除失败|true|
| remove_all_storage|Boolean|false|是否删除虚拟机所有快照对应的磁盘存储|true|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看DeleteVMspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 1.18 RebootVM(虚拟机重启)

**接口功能:**
	重启虚拟机，能否正常重新启动取决于虚拟机OS是否受损只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存在，即已调用过CreatePool, CreateSwitch, CreateDisk/CreateDiskImage, CreateAndStartVMFromISO/CreateAndStartVMFromImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.RebootVM

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | rebootVM.name.001|
| rebootVM | RebootVM | true | 虚拟机重启 | 详细见下 |
| eventId | String | fasle | 事件ID | rebootVM.event.001 |

对象rebootVM参数说明:

## 1.19 PlugNIC(虚拟机添加网卡)

**接口功能:**
	给虚拟机添加网卡只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存在，即已调用过CreatePool, CreateSwitch, CreateDisk/CreateDiskImage, CreateAndStartVMFromISO/CreateAndStartVMFromImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.PlugNIC

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | plugNIC.name.001|
| plugNIC | PlugNIC | true | 虚拟机添加网卡 | 详细见下 |
| eventId | String | fasle | 事件ID | plugNIC.event.001 |

对象plugNIC参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| current|Boolean|false|对当前虚拟机生效|true|
| persistent|Boolean|false|对配置进行持久化|true|
| config|Boolean|false|如果不设置，当前配置下次不会生效|true|
| live|Boolean|false|立即生效，对于开机虚拟机|true|
| inbound|String|false|网络输入带宽QoS限制，单位为KiB，示例参考https://libvirt.org/formatnetwork.html#elementQoS|1000MiB: 1024000|
| source|String|true|网络源设置|source=br-int,ip=192.168.5.2,switch=switch|
| type|String|true|网络源类型设置|bridge|
| mac|String|true|mac地址|7e:0c:b0:ef:6a:04|
| outbound|String|false|网络输出带宽QoS限制，单位为KiB，示例参考https://libvirt.org/formatnetwork.html#elementQoS|1000MiB: 1024000|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看PlugNICspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 1.20 ManageISO(插入或拔出光驱)

**接口功能:**
	插入或者拔出光驱只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存在，即已调用过CreatePool, CreateSwitch, CreateDisk/CreateDiskImage, CreateAndStartVMFromISO/CreateAndStartVMFromImage或plugDevice

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ManageISO

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | manageISO.name.001|
| manageISO | ManageISO | true | 插入或拔出光驱 | 详细见下 |
| eventId | String | fasle | 事件ID | manageISO.event.001 |

对象manageISO参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| current|Boolean|false|对当前虚拟机生效|true|
| config|Boolean|false|如果不设置，当前配置下次不会生效|true|
| live|Boolean|false|立即生效，对于开机虚拟机|true|
| path|String|true|模板虚拟机的路径|/var/lib/libvirt/target.iso|
| eject|Boolean|true|弹出光驱，与--insert不可同时设置为true|true|
| insert|Boolean|true|插入光驱|true|
| update|Boolean|true|更新操作|true|
| force|Boolean|true|强制执行|true|
| block|Boolean|true|如果适用物理机光驱，应该设置为true|true|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看ManageISOspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 1.21 UpdateOS(更换虚拟机OS)

**接口功能:**
	更换云主机的OS，云主机必须关机只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存在，即已调用过CreatePool, CreateSwitch, CreateDisk/CreateDiskImage, CreateAndStartVMFromISO/CreateAndStartVMFromImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UpdateOS

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | updateOS.name.001|
| updateOS | UpdateOS | true | 更换虚拟机OS | 详细见下 |
| eventId | String | fasle | 事件ID | updateOS.event.001 |

对象updateOS参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| source|String|true|需要被替换的虚拟机路径|/var/lib/libvirt/source.xml|
| target|String|true|模板虚拟机的路径|/var/lib/libvirt/target.xml|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看UpdateOSspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 1.22 ConvertVMToImage(转化为虚拟机模板)

**接口功能:**
	转化为虚拟机镜像只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存在，即已调用过CreatePool, CreateSwitch, CreateDisk/CreateDiskImage, CreateAndStartVMFromISO/CreateAndStartVMFromImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ConvertVMToImage

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | convertVMToImage.name.001|
| convertVMToImage | ConvertVMToImage | true | 转化为虚拟机模板 | 详细见下 |
| eventId | String | fasle | 事件ID | convertVMToImage.event.001 |

对象convertVMToImage参数说明:

## **返回值:**

```
{
	"kind":"VirtualMachine",
	"metadata":{
		"additionalProperties":{},
		"finalizers":[],
		"ownerReferences":[]
	},
	"spec":{
		"additionalPrinterColumns":[],
		"additionalProperties":{},
		"domain":{
			"blkiotune":{
				"device":[
					{
						"path":{
							"text":"String"
						},
						"read_bytes_sec":{
							"text":"String"
						},
						"read_iops_sec":{
							"text":"String"
						},
						"weight":{
							"text":"String"
						},
						"write_bytes_sec":{
							"text":"String"
						},
						"write_iops_sec":{
							"text":"String"
						}
					},
					{
						"path":{
							"text":"String"
						},
						"read_bytes_sec":{
							"text":"String"
						},
						"read_iops_sec":{
							"text":"String"
						},
						"weight":{
							"text":"String"
						},
						"write_bytes_sec":{
							"text":"String"
						},
						"write_iops_sec":{
							"text":"String"
						}
					}
				],
				"weight":{
					"text":"String"
				}
			},
			"bootloader":{
				"text":"String"
			},
			"bootloader_args":{
				"text":"String"
			},
			"clock":{
				"adjustment":"String",
				"basis":"String",
				"offset":"String",
				"timer":[
					{
						"catchup":{
							"limit":"String",
							"slew":"String",
							"threshold":"String"
						},
						"frequency":"String",
						"mode":"String",
						"name":"String",
						"present":"String",
						"tickpolicy":"String",
						"track":"String"
					},
					{
						"catchup":{
							"limit":"String",
							"slew":"String",
							"threshold":"String"
						},
						"frequency":"String",
						"mode":"String",
						"name":"String",
						"present":"String",
						"tickpolicy":"String",
						"track":"String"
					}
				],
				"timezone":"String"
			},
			"cpu":{
				"cache":{
					"level":"String",
					"mode":"String"
				},
				"check":"String",
				"feature":[
					{
						"name":"String",
						"policy":"String"
					},
					{
						"name":"String",
						"policy":"String"
					}
				],
				"match":"String",
				"mode":"String",
				"model":{
					"fallback":"String",
					"text":"String",
					"vendor_id":"String"
				},
				"numa":{
					"cell":[
						{
							"cpus":"String",
							"discard":"String",
							"distances":{
								"sibling":[
									{
										"id":"String",
										"value":"String"
									},
									{
										"id":"String",
										"value":"String"
									}
								]
							},
							"id":"String",
							"memAccess":"String",
							"memory":"String",
							"unit":"String"
						},
						{
							"cpus":"String",
							"discard":"String",
							"distances":{
								"sibling":[
									{
										"id":"String",
										"value":"String"
									},
									{
										"id":"String",
										"value":"String"
									}
								]
							},
							"id":"String",
							"memAccess":"String",
							"memory":"String",
							"unit":"String"
						}
					]
				},
				"topology":{
					"cores":"String",
					"sockets":"String",
					"threads":"String"
				},
				"vendor":{
					"text":"String"
				}
			},
			"cputune":{
				"cachetune":[
					{
						"cache":[
							{
								"id":"String",
								"level":"String",
								"size":"String",
								"type":"String",
								"unit":"String"
							},
							{
								"id":"String",
								"level":"String",
								"size":"String",
								"type":"String",
								"unit":"String"
							}
						],
						"monitor":[
							{
								"level":"String",
								"vcpus":"String"
							},
							{
								"level":"String",
								"vcpus":"String"
							}
						],
						"vcpus":"String"
					},
					{
						"cache":[
							{
								"id":"String",
								"level":"String",
								"size":"String",
								"type":"String",
								"unit":"String"
							},
							{
								"id":"String",
								"level":"String",
								"size":"String",
								"type":"String",
								"unit":"String"
							}
						],
						"monitor":[
							{
								"level":"String",
								"vcpus":"String"
							},
							{
								"level":"String",
								"vcpus":"String"
							}
						],
						"vcpus":"String"
					}
				],
				"emulator_period":{
					"text":"String"
				},
				"emulator_quota":{
					"text":"String"
				},
				"emulatorpin":{
					"cpuset":"String"
				},
				"global_period":{
					"text":"String"
				},
				"global_quota":{
					"text":"String"
				},
				"iothread_period":{
					"text":"String"
				},
				"iothread_quota":{
					"text":"String"
				},
				"iothreadpin":[
					{
						"cpuset":"String",
						"iothread":"String"
					},
					{
						"cpuset":"String",
						"iothread":"String"
					}
				],
				"iothreadsched":[
					{
						"iothreads":"String",
						"priority":"String",
						"scheduler":"String"
					},
					{
						"iothreads":"String",
						"priority":"String",
						"scheduler":"String"
					}
				],
				"memorytune":[
					{
						"node":[
							{
								"bandwidth":"String",
								"id":"String"
							},
							{
								"bandwidth":"String",
								"id":"String"
							}
						],
						"vcpus":"String"
					},
					{
						"node":[
							{
								"bandwidth":"String",
								"id":"String"
							},
							{
								"bandwidth":"String",
								"id":"String"
							}
						],
						"vcpus":"String"
					}
				],
				"period":{
					"text":"String"
				},
				"quota":{
					"text":"String"
				},
				"shares":{
					"text":"String"
				},
				"vcpupin":[
					{
						"cpuset":"String",
						"vcpu":"String"
					},
					{
						"cpuset":"String",
						"vcpu":"String"
					}
				],
				"vcpusched":[
					{
						"priority":"String",
						"scheduler":"String",
						"vcpus":"String"
					},
					{
						"priority":"String",
						"scheduler":"String",
						"vcpus":"String"
					}
				]
			},
			"currentMemory":{
				"text":"String",
				"unit":"String"
			},
			"description":{
				"text":"String"
			},
			"devices":{
				"channel":[
					{
						"address":{
							"bus":"String",
							"controller":"String",
							"port":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"log":{
							"append":"String",
							"file":"String"
						},
						"protocol":{
							"type":"String"
						},
						"source":{
							"mode":"String",
							"path":"String"
						},
						"target":{
							"name":"String",
							"state":"String",
							"type":"String"
						},
						"type":"String"
					},
					{
						"address":{
							"bus":"String",
							"controller":"String",
							"port":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"log":{
							"append":"String",
							"file":"String"
						},
						"protocol":{
							"type":"String"
						},
						"source":{
							"mode":"String",
							"path":"String"
						},
						"target":{
							"name":"String",
							"state":"String",
							"type":"String"
						},
						"type":"String"
					}
				],
				"console":[
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"log":{
							"append":"String",
							"file":"String"
						},
						"protocol":{
							"type":"String"
						},
						"source":{
							"path":"String"
						},
						"target":{
							"port":"String",
							"type":"String"
						},
						"tty":"String",
						"type":"String"
					},
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"log":{
							"append":"String",
							"file":"String"
						},
						"protocol":{
							"type":"String"
						},
						"source":{
							"path":"String"
						},
						"target":{
							"port":"String",
							"type":"String"
						},
						"tty":"String",
						"type":"String"
					}
				],
				"controller":[
					{
						"address":{
							"bus":"String",
							"domain":"String",
							"function":"String",
							"multifunction":"String",
							"slot":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"driver":{
							"ats":"String",
							"cmd_per_lun":"String",
							"ioeventfd":"String",
							"iommu":"String",
							"iothread":"String",
							"max_sectors":"String",
							"queues":"String"
						},
						"index":"String",
						"master":{
							"startport":"String"
						},
						"model":"String",
						"type":"String"
					},
					{
						"address":{
							"bus":"String",
							"domain":"String",
							"function":"String",
							"multifunction":"String",
							"slot":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"driver":{
							"ats":"String",
							"cmd_per_lun":"String",
							"ioeventfd":"String",
							"iommu":"String",
							"iothread":"String",
							"max_sectors":"String",
							"queues":"String"
						},
						"index":"String",
						"master":{
							"startport":"String"
						},
						"model":"String",
						"type":"String"
					}
				],
				"disk":[
					{
						"address":{
							"bus":"String",
							"controller":"String",
							"domain":"String",
							"function":"String",
							"slot":"String",
							"target":"String",
							"type":"String",
							"unit":"String"
						},
						"alias":{
							"name":"String"
						},
						"auth":{
							"secret":{
								"type":"String",
								"usage":"String",
								"uuid":"String"
							},
							"username":"String"
						},
						"backingStore":{
							"format":{
								"type":"String"
							},
							"index":"String",
							"source":{
								"encryption":{
									"format":"String",
									"secret":{
										"type":"String",
										"usage":"String",
										"uuid":"String"
									}
								},
								"index":"String",
								"reservations":{
									"enabled":"String",
									"managed":"String",
									"source":{
										"dev":"String",
										"mode":"String",
										"path":"String",
										"type":"String"
									}
								},
								"startupPolicy":"String"
							}
						},
						"blockio":{
							"logical_block_size":"String",
							"physical_block_size":"String"
						},
						"boot":{
							"loadparm":"String",
							"order":"String"
						},
						"device":"String",
						"driver":{
							"ats":"String",
							"cache":"String",
							"copy_on_read":"String",
							"detect_zeroes":"String",
							"discard":"String",
							"error_policy":"String",
							"event_idx":"String",
							"io":"String",
							"ioeventfd":"String",
							"iommu":"String",
							"iothread":"String",
							"name":"String",
							"queues":"String",
							"rerror_policy":"String",
							"type":"String"
						},
						"encryption":{
							"format":"String",
							"secret":{
								"type":"String",
								"usage":"String",
								"uuid":"String"
							}
						},
						"geometry":{
							"cyls":"String",
							"heads":"String",
							"secs":"String",
							"trans":"String"
						},
						"iotune":{
							"group_name":{
								"text":"String"
							},
							"read_bytes_sec":{
								"text":"String"
							},
							"read_bytes_sec_max":{
								"text":"String"
							},
							"read_bytes_sec_max_length":{
								"text":"String"
							},
							"read_iops_sec":{
								"text":"String"
							},
							"read_iops_sec_max":{
								"text":"String"
							},
							"read_iops_sec_max_length":{
								"text":"String"
							},
							"size_iops_sec":{
								"text":"String"
							},
							"total_bytes_sec":{
								"text":"String"
							},
							"total_bytes_sec_max":{
								"text":"String"
							},
							"total_bytes_sec_max_length":{
								"text":"String"
							},
							"total_iops_sec":{
								"text":"String"
							},
							"total_iops_sec_max":{
								"text":"String"
							},
							"total_iops_sec_max_length":{
								"text":"String"
							},
							"write_bytes_sec":{
								"text":"String"
							},
							"write_bytes_sec_max":{
								"text":"String"
							},
							"write_bytes_sec_max_length":{
								"text":"String"
							},
							"write_iops_sec":{
								"text":"String"
							},
							"write_iops_sec_max":{
								"text":"String"
							},
							"write_iops_sec_max_length":{
								"text":"String"
							}
						},
						"mirror":{
							"format":{
								"type":"String"
							},
							"job":"String",
							"ready":"String",
							"source":{
								"encryption":{
									"format":"String",
									"secret":{
										"type":"String",
										"usage":"String",
										"uuid":"String"
									}
								},
								"index":"String",
								"reservations":{
									"enabled":"String",
									"managed":"String",
									"source":{
										"dev":"String",
										"mode":"String",
										"path":"String",
										"type":"String"
									}
								},
								"startupPolicy":"String"
							}
						},
						"model":"String",
						"product":{
							"text":"String"
						},
						"rawio":"String",
						"readonly":{},
						"serial":{
							"text":"String",
							"type":"String"
						},
						"sgio":"String",
						"shareable":{},
						"snapshot":"String",
						"source":{
							"controller":"String",
							"encryption":{
								"format":"String",
								"secret":{
									"type":"String",
									"usage":"String",
									"uuid":"String"
								}
							},
							"file":"String",
							"index":"String",
							"reservations":{
								"enabled":"String",
								"managed":"String",
								"source":{
									"dev":"String",
									"mode":"String",
									"path":"String",
									"type":"String"
								}
							},
							"startupPolicy":"String"
						},
						"target":{
							"bus":"String",
							"dev":"String",
							"removable":"String",
							"tray":"String"
						},
						"transient":{},
						"type":"String",
						"vendor":{
							"text":"String"
						},
						"wwn":{
							"text":"String"
						}
					},
					{
						"address":{
							"bus":"String",
							"controller":"String",
							"domain":"String",
							"function":"String",
							"slot":"String",
							"target":"String",
							"type":"String",
							"unit":"String"
						},
						"alias":{
							"name":"String"
						},
						"auth":{
							"secret":{
								"type":"String",
								"usage":"String",
								"uuid":"String"
							},
							"username":"String"
						},
						"backingStore":{
							"format":{
								"type":"String"
							},
							"index":"String",
							"source":{
								"encryption":{
									"format":"String",
									"secret":{
										"type":"String",
										"usage":"String",
										"uuid":"String"
									}
								},
								"index":"String",
								"reservations":{
									"enabled":"String",
									"managed":"String",
									"source":{
										"dev":"String",
										"mode":"String",
										"path":"String",
										"type":"String"
									}
								},
								"startupPolicy":"String"
							}
						},
						"blockio":{
							"logical_block_size":"String",
							"physical_block_size":"String"
						},
						"boot":{
							"loadparm":"String",
							"order":"String"
						},
						"device":"String",
						"driver":{
							"ats":"String",
							"cache":"String",
							"copy_on_read":"String",
							"detect_zeroes":"String",
							"discard":"String",
							"error_policy":"String",
							"event_idx":"String",
							"io":"String",
							"ioeventfd":"String",
							"iommu":"String",
							"iothread":"String",
							"name":"String",
							"queues":"String",
							"rerror_policy":"String",
							"type":"String"
						},
						"encryption":{
							"format":"String",
							"secret":{
								"type":"String",
								"usage":"String",
								"uuid":"String"
							}
						},
						"geometry":{
							"cyls":"String",
							"heads":"String",
							"secs":"String",
							"trans":"String"
						},
						"iotune":{
							"group_name":{
								"text":"String"
							},
							"read_bytes_sec":{
								"text":"String"
							},
							"read_bytes_sec_max":{
								"text":"String"
							},
							"read_bytes_sec_max_length":{
								"text":"String"
							},
							"read_iops_sec":{
								"text":"String"
							},
							"read_iops_sec_max":{
								"text":"String"
							},
							"read_iops_sec_max_length":{
								"text":"String"
							},
							"size_iops_sec":{
								"text":"String"
							},
							"total_bytes_sec":{
								"text":"String"
							},
							"total_bytes_sec_max":{
								"text":"String"
							},
							"total_bytes_sec_max_length":{
								"text":"String"
							},
							"total_iops_sec":{
								"text":"String"
							},
							"total_iops_sec_max":{
								"text":"String"
							},
							"total_iops_sec_max_length":{
								"text":"String"
							},
							"write_bytes_sec":{
								"text":"String"
							},
							"write_bytes_sec_max":{
								"text":"String"
							},
							"write_bytes_sec_max_length":{
								"text":"String"
							},
							"write_iops_sec":{
								"text":"String"
							},
							"write_iops_sec_max":{
								"text":"String"
							},
							"write_iops_sec_max_length":{
								"text":"String"
							}
						},
						"mirror":{
							"format":{
								"type":"String"
							},
							"job":"String",
							"ready":"String",
							"source":{
								"encryption":{
									"format":"String",
									"secret":{
										"type":"String",
										"usage":"String",
										"uuid":"String"
									}
								},
								"index":"String",
								"reservations":{
									"enabled":"String",
									"managed":"String",
									"source":{
										"dev":"String",
										"mode":"String",
										"path":"String",
										"type":"String"
									}
								},
								"startupPolicy":"String"
							}
						},
						"model":"String",
						"product":{
							"text":"String"
						},
						"rawio":"String",
						"readonly":{},
						"serial":{
							"text":"String",
							"type":"String"
						},
						"sgio":"String",
						"shareable":{},
						"snapshot":"String",
						"source":{
							"controller":"String",
							"encryption":{
								"format":"String",
								"secret":{
									"type":"String",
									"usage":"String",
									"uuid":"String"
								}
							},
							"file":"String",
							"index":"String",
							"reservations":{
								"enabled":"String",
								"managed":"String",
								"source":{
									"dev":"String",
									"mode":"String",
									"path":"String",
									"type":"String"
								}
							},
							"startupPolicy":"String"
						},
						"target":{
							"bus":"String",
							"dev":"String",
							"removable":"String",
							"tray":"String"
						},
						"transient":{},
						"type":"String",
						"vendor":{
							"text":"String"
						},
						"wwn":{
							"text":"String"
						}
					}
				],
				"emulator":{
					"text":"String"
				},
				"filesystem":[
					{
						"accessmode":"String",
						"address":{},
						"alias":{
							"name":"String"
						},
						"driver":{
							"ats":"String",
							"format":"String",
							"iommu":"String",
							"name":"String",
							"type":"String",
							"wrpolicy":"String"
						},
						"model":"String",
						"readonly":{},
						"source":{},
						"space_hard_limit":{
							"text":"String",
							"unit":"String"
						},
						"space_soft_limit":{
							"text":"String",
							"unit":"String"
						},
						"target":{
							"dir":"String"
						}
					},
					{
						"accessmode":"String",
						"address":{},
						"alias":{
							"name":"String"
						},
						"driver":{
							"ats":"String",
							"format":"String",
							"iommu":"String",
							"name":"String",
							"type":"String",
							"wrpolicy":"String"
						},
						"model":"String",
						"readonly":{},
						"source":{},
						"space_hard_limit":{
							"text":"String",
							"unit":"String"
						},
						"space_soft_limit":{
							"text":"String",
							"unit":"String"
						},
						"target":{
							"dir":"String"
						}
					}
				],
				"graphics":[
					{
						"autoport":"String",
						"listen":{
							"address":"String",
							"type":"String"
						},
						"port":"String",
						"type":"String"
					},
					{
						"autoport":"String",
						"listen":{
							"address":"String",
							"type":"String"
						},
						"port":"String",
						"type":"String"
					}
				],
				"hostdev":[
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"boot":{
							"loadparm":"String",
							"order":"String"
						},
						"managed":"String",
						"rom":{
							"bar":"String",
							"enabled":"String",
							"file":"String"
						}
					},
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"boot":{
							"loadparm":"String",
							"order":"String"
						},
						"managed":"String",
						"rom":{
							"bar":"String",
							"enabled":"String",
							"file":"String"
						}
					}
				],
				"hub":[
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"type":"String"
					},
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"type":"String"
					}
				],
				"input":[
					{
						"address":{
							"bus":"String",
							"port":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"bus":"String",
						"driver":{
							"ats":"String",
							"iommu":"String"
						},
						"model":"String",
						"source":{
							"evdev":"String"
						},
						"type":"String"
					},
					{
						"address":{
							"bus":"String",
							"port":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"bus":"String",
						"driver":{
							"ats":"String",
							"iommu":"String"
						},
						"model":"String",
						"source":{
							"evdev":"String"
						},
						"type":"String"
					}
				],
				"interface":[
					{
						"address":{
							"bus":"String",
							"domain":"String",
							"function":"String",
							"slot":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"backend":{
							"tap":"String",
							"vhost":"String"
						},
						"bandwidth":{
							"inbound":{
								"average":"String",
								"burst":"String",
								"floor":"String",
								"peak":"String"
							},
							"outbound":{
								"average":"String",
								"burst":"String",
								"floor":"String",
								"peak":"String"
							}
						},
						"boot":{
							"loadparm":"String",
							"order":"String"
						},
						"coalesce":{
							"rx":{
								"frames":{
									"max":"String"
								}
							}
						},
						"driver":{
							"ats":"String",
							"event_idx":"String",
							"guest":{
								"csum":"String",
								"ecn":"String",
								"tso4":"String",
								"tso6":"String",
								"ufo":"String"
							},
							"host":{
								"csum":"String",
								"ecn":"String",
								"gso":"String",
								"mrg_rxbuf":"String",
								"tso4":"String",
								"tso6":"String",
								"ufo":"String"
							},
							"ioeventfd":"String",
							"iommu":"String",
							"name":"String",
							"queues":"String",
							"rx_queue_size":"String",
							"tx_queue_size":"String",
							"txmode":"String"
						},
						"filterref":{
							"filter":"String",
							"parameter":[
								{
									"name":"String",
									"value":"String"
								},
								{
									"name":"String",
									"value":"String"
								}
							]
						},
						"guest":{
							"actual":"String",
							"dev":"String"
						},
						"ip":[
							{
								"address":"String",
								"family":"String",
								"peer":"String",
								"prefix":"String"
							},
							{
								"address":"String",
								"family":"String",
								"peer":"String",
								"prefix":"String"
							}
						],
						"link":{
							"state":"String"
						},
						"mac":{
							"address":"String"
						},
						"managed":"String",
						"model":{
							"type":"String"
						},
						"mtu":{
							"size":"String"
						},
						"rom":{
							"bar":"String",
							"enabled":"String",
							"file":"String"
						},
						"route":[
							{
								"address":"String",
								"family":"String",
								"gateway":"String",
								"metric":"String",
								"netmask":"String",
								"prefix":"String"
							},
							{
								"address":"String",
								"family":"String",
								"gateway":"String",
								"metric":"String",
								"netmask":"String",
								"prefix":"String"
							}
						],
						"script":{
							"path":"String"
						},
						"source":{
							"bridge":"String",
							"network":"String"
						},
						"target":{
							"dev":"String"
						},
						"trustGuestRxFilters":"String",
						"tune":{
							"sndbuf":{
								"text":"String"
							}
						},
						"type":"String",
						"virtualport":{
							"parameters":{
								"_interfaceid":"String"
							},
							"type":"String"
						},
						"vlan":{
							"tag":[
								{
									"id":"String",
									"nativeMode":"String"
								},
								{
									"id":"String",
									"nativeMode":"String"
								}
							],
							"trunk":"String"
						}
					},
					{
						"address":{
							"bus":"String",
							"domain":"String",
							"function":"String",
							"slot":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"backend":{
							"tap":"String",
							"vhost":"String"
						},
						"bandwidth":{
							"inbound":{
								"average":"String",
								"burst":"String",
								"floor":"String",
								"peak":"String"
							},
							"outbound":{
								"average":"String",
								"burst":"String",
								"floor":"String",
								"peak":"String"
							}
						},
						"boot":{
							"loadparm":"String",
							"order":"String"
						},
						"coalesce":{
							"rx":{
								"frames":{
									"max":"String"
								}
							}
						},
						"driver":{
							"ats":"String",
							"event_idx":"String",
							"guest":{
								"csum":"String",
								"ecn":"String",
								"tso4":"String",
								"tso6":"String",
								"ufo":"String"
							},
							"host":{
								"csum":"String",
								"ecn":"String",
								"gso":"String",
								"mrg_rxbuf":"String",
								"tso4":"String",
								"tso6":"String",
								"ufo":"String"
							},
							"ioeventfd":"String",
							"iommu":"String",
							"name":"String",
							"queues":"String",
							"rx_queue_size":"String",
							"tx_queue_size":"String",
							"txmode":"String"
						},
						"filterref":{
							"filter":"String",
							"parameter":[
								{
									"name":"String",
									"value":"String"
								},
								{
									"name":"String",
									"value":"String"
								}
							]
						},
						"guest":{
							"actual":"String",
							"dev":"String"
						},
						"ip":[
							{
								"address":"String",
								"family":"String",
								"peer":"String",
								"prefix":"String"
							},
							{
								"address":"String",
								"family":"String",
								"peer":"String",
								"prefix":"String"
							}
						],
						"link":{
							"state":"String"
						},
						"mac":{
							"address":"String"
						},
						"managed":"String",
						"model":{
							"type":"String"
						},
						"mtu":{
							"size":"String"
						},
						"rom":{
							"bar":"String",
							"enabled":"String",
							"file":"String"
						},
						"route":[
							{
								"address":"String",
								"family":"String",
								"gateway":"String",
								"metric":"String",
								"netmask":"String",
								"prefix":"String"
							},
							{
								"address":"String",
								"family":"String",
								"gateway":"String",
								"metric":"String",
								"netmask":"String",
								"prefix":"String"
							}
						],
						"script":{
							"path":"String"
						},
						"source":{
							"bridge":"String",
							"network":"String"
						},
						"target":{
							"dev":"String"
						},
						"trustGuestRxFilters":"String",
						"tune":{
							"sndbuf":{
								"text":"String"
							}
						},
						"type":"String",
						"virtualport":{
							"parameters":{
								"_interfaceid":"String"
							},
							"type":"String"
						},
						"vlan":{
							"tag":[
								{
									"id":"String",
									"nativeMode":"String"
								},
								{
									"id":"String",
									"nativeMode":"String"
								}
							],
							"trunk":"String"
						}
					}
				],
				"iommu":{
					"driver":{
						"caching_mode":"String",
						"eim":"String",
						"intremap":"String",
						"iotlb":"String"
					},
					"model":"String"
				},
				"lease":[
					{
						"key":{
							"text":"String"
						},
						"lockspace":{
							"text":"String"
						},
						"target":{
							"offset":"String",
							"path":"String"
						}
					},
					{
						"key":{
							"text":"String"
						},
						"lockspace":{
							"text":"String"
						},
						"target":{
							"offset":"String",
							"path":"String"
						}
					}
				],
				"memballoon":{
					"address":{
						"bus":"String",
						"domain":"String",
						"function":"String",
						"slot":"String",
						"type":"String"
					},
					"alias":{
						"name":"String"
					},
					"autodeflate":"String",
					"driver":{
						"ats":"String",
						"iommu":"String"
					},
					"model":"String",
					"stats":{
						"period":"String"
					}
				},
				"memory":[
					{
						"access":"String",
						"address":{},
						"alias":{
							"name":"String"
						},
						"discard":"String",
						"model":"String",
						"source":{
							"alignsize":{
								"text":"String",
								"unit":"String"
							},
							"nodemask":{
								"text":"String"
							},
							"pagesize":{
								"text":"String",
								"unit":"String"
							},
							"path":{
								"text":"String"
							},
							"pmem":{}
						},
						"target":{
							"label":{
								"size":{
									"text":"String",
									"unit":"String"
								}
							},
							"node":{
								"text":"String"
							},
							"readonly":{},
							"size":{
								"text":"String",
								"unit":"String"
							}
						}
					},
					{
						"access":"String",
						"address":{},
						"alias":{
							"name":"String"
						},
						"discard":"String",
						"model":"String",
						"source":{
							"alignsize":{
								"text":"String",
								"unit":"String"
							},
							"nodemask":{
								"text":"String"
							},
							"pagesize":{
								"text":"String",
								"unit":"String"
							},
							"path":{
								"text":"String"
							},
							"pmem":{}
						},
						"target":{
							"label":{
								"size":{
									"text":"String",
									"unit":"String"
								}
							},
							"node":{
								"text":"String"
							},
							"readonly":{},
							"size":{
								"text":"String",
								"unit":"String"
							}
						}
					}
				],
				"nvram":{
					"address":{},
					"alias":{
						"name":"String"
					}
				},
				"panic":[
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"model":"String"
					},
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"model":"String"
					}
				],
				"parallel":[
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"log":{
							"append":"String",
							"file":"String"
						},
						"protocol":{
							"type":"String"
						},
						"source":{},
						"target":{
							"port":"String",
							"type":"String"
						}
					},
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"log":{
							"append":"String",
							"file":"String"
						},
						"protocol":{
							"type":"String"
						},
						"source":{},
						"target":{
							"port":"String",
							"type":"String"
						}
					}
				],
				"redirdev":[
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"boot":{
							"loadparm":"String",
							"order":"String"
						},
						"bus":"String",
						"protocol":{
							"type":"String"
						},
						"source":{}
					},
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"boot":{
							"loadparm":"String",
							"order":"String"
						},
						"bus":"String",
						"protocol":{
							"type":"String"
						},
						"source":{}
					}
				],
				"redirfilter":[
					{
						"usbdev":[
							{
								"allow":"String",
								"class":"String",
								"product":"String",
								"vendor":"String",
								"version":"String"
							},
							{
								"allow":"String",
								"class":"String",
								"product":"String",
								"vendor":"String",
								"version":"String"
							}
						]
					},
					{
						"usbdev":[
							{
								"allow":"String",
								"class":"String",
								"product":"String",
								"vendor":"String",
								"version":"String"
							},
							{
								"allow":"String",
								"class":"String",
								"product":"String",
								"vendor":"String",
								"version":"String"
							}
						]
					}
				],
				"rng":[
					{
						"address":{
							"bus":"String",
							"domain":"String",
							"function":"String",
							"slot":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"backend":{
							"model":"String",
							"text":"String"
						},
						"driver":{
							"ats":"String",
							"iommu":"String"
						},
						"model":"String",
						"rate":{
							"bytes":"String",
							"period":"String"
						}
					},
					{
						"address":{
							"bus":"String",
							"domain":"String",
							"function":"String",
							"slot":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"backend":{
							"model":"String",
							"text":"String"
						},
						"driver":{
							"ats":"String",
							"iommu":"String"
						},
						"model":"String",
						"rate":{
							"bytes":"String",
							"period":"String"
						}
					}
				],
				"serial":[
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"log":{
							"append":"String",
							"file":"String"
						},
						"protocol":{
							"type":"String"
						},
						"source":{
							"path":"String"
						},
						"target":{
							"model":{
								"name":"String"
							},
							"port":"String",
							"type":"String"
						},
						"type":"String"
					},
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"log":{
							"append":"String",
							"file":"String"
						},
						"protocol":{
							"type":"String"
						},
						"source":{
							"path":"String"
						},
						"target":{
							"model":{
								"name":"String"
							},
							"port":"String",
							"type":"String"
						},
						"type":"String"
					}
				],
				"shmem":[
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"model":{
							"type":"String"
						},
						"msi":{
							"enabled":"String",
							"ioeventfd":"String",
							"vectors":"String"
						},
						"name":"String",
						"server":{
							"path":"String"
						},
						"size":{
							"text":"String",
							"unit":"String"
						}
					},
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"model":{
							"type":"String"
						},
						"msi":{
							"enabled":"String",
							"ioeventfd":"String",
							"vectors":"String"
						},
						"name":"String",
						"server":{
							"path":"String"
						},
						"size":{
							"text":"String",
							"unit":"String"
						}
					}
				],
				"smartcard":[
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"certificate":[
							{
								"text":"String"
							},
							{
								"text":"String"
							}
						],
						"database":{
							"text":"String"
						},
						"protocol":{
							"type":"String"
						},
						"source":{}
					},
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"certificate":[
							{
								"text":"String"
							},
							{
								"text":"String"
							}
						],
						"database":{
							"text":"String"
						},
						"protocol":{
							"type":"String"
						},
						"source":{}
					}
				],
				"sound":[
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"codec":[
							{
								"type":"String"
							},
							{
								"type":"String"
							}
						],
						"model":"String"
					},
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"codec":[
							{
								"type":"String"
							},
							{
								"type":"String"
							}
						],
						"model":"String"
					}
				],
				"tpm":[
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"backend":{},
						"model":"String"
					},
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"backend":{},
						"model":"String"
					}
				],
				"video":[
					{
						"address":{
							"bus":"String",
							"domain":"String",
							"function":"String",
							"slot":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"driver":{
							"ats":"String",
							"iommu":"String",
							"vgaconf":"String"
						},
						"model":{
							"acceleration":{
								"accel2d":"String",
								"accel3d":"String"
							},
							"heads":"String",
							"primary":"String",
							"ram":"String",
							"type":"String",
							"vgamem":"String",
							"vram":"String",
							"vram64":"String"
						}
					},
					{
						"address":{
							"bus":"String",
							"domain":"String",
							"function":"String",
							"slot":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"driver":{
							"ats":"String",
							"iommu":"String",
							"vgaconf":"String"
						},
						"model":{
							"acceleration":{
								"accel2d":"String",
								"accel3d":"String"
							},
							"heads":"String",
							"primary":"String",
							"ram":"String",
							"type":"String",
							"vgamem":"String",
							"vram":"String",
							"vram64":"String"
						}
					}
				],
				"vsock":{
					"address":{},
					"alias":{
						"name":"String"
					},
					"cid":{
						"address":"String",
						"auto":"String"
					},
					"model":"String"
				},
				"watchdog":{
					"action":"String",
					"address":{},
					"alias":{
						"name":"String"
					},
					"model":"String"
				}
			},
			"features":{
				"acpi":{},
				"apic":{
					"eoi":"String"
				},
				"capabilities":{
					"audit_control":{
						"state":"String"
					},
					"audit_write":{
						"state":"String"
					},
					"block_suspend":{
						"state":"String"
					},
					"chown":{
						"state":"String"
					},
					"dac_override":{
						"state":"String"
					},
					"dac_read_Search":{
						"state":"String"
					},
					"fowner":{
						"state":"String"
					},
					"fsetid":{
						"state":"String"
					},
					"ipc_lock":{
						"state":"String"
					},
					"ipc_owner":{
						"state":"String"
					},
					"kill":{
						"state":"String"
					},
					"lease":{
						"state":"String"
					},
					"linux_immutable":{
						"state":"String"
					},
					"mac_admin":{
						"state":"String"
					},
					"mac_override":{
						"state":"String"
					},
					"mknod":{
						"state":"String"
					},
					"net_admin":{
						"state":"String"
					},
					"net_bind_service":{
						"state":"String"
					},
					"net_broadcast":{
						"state":"String"
					},
					"net_raw":{
						"state":"String"
					},
					"policy":"String",
					"setfcap":{
						"state":"String"
					},
					"setgid":{
						"state":"String"
					},
					"setpcap":{
						"state":"String"
					},
					"setuid":{
						"state":"String"
					},
					"sys_admin":{
						"state":"String"
					},
					"sys_boot":{
						"state":"String"
					},
					"sys_chroot":{
						"state":"String"
					},
					"sys_module":{
						"state":"String"
					},
					"sys_nice":{
						"state":"String"
					},
					"sys_pacct":{
						"state":"String"
					},
					"sys_ptrace":{
						"state":"String"
					},
					"sys_rawio":{
						"state":"String"
					},
					"sys_resource":{
						"state":"String"
					},
					"sys_time":{
						"state":"String"
					},
					"sys_tty_config":{
						"state":"String"
					},
					"syslog":{
						"state":"String"
					},
					"wake_alarm":{
						"state":"String"
					}
				},
				"gic":{
					"version":"String"
				},
				"hap":{
					"state":"String"
				},
				"hpt":{
					"maxpagesize":{
						"text":"String",
						"unit":"String"
					},
					"resizing":"String"
				},
				"htm":{
					"state":"String"
				},
				"hyperv":{
					"evmcs":{
						"state":"String"
					},
					"frequencies":{
						"state":"String"
					},
					"ipi":{
						"state":"String"
					},
					"reenlightenment":{
						"state":"String"
					},
					"relaxed":{
						"state":"String"
					},
					"reset":{
						"state":"String"
					},
					"runtime":{
						"state":"String"
					},
					"spinlocks":{
						"retries":"String",
						"state":"String"
					},
					"stimer":{
						"state":"String"
					},
					"synic":{
						"state":"String"
					},
					"tlbflush":{
						"state":"String"
					},
					"vapic":{
						"state":"String"
					},
					"vendor_id":{
						"value":"String"
					},
					"vpindex":{
						"state":"String"
					}
				},
				"ioapic":{
					"driver":"String"
				},
				"kvm":{
					"hidden":{
						"state":"String"
					}
				},
				"msrs":{
					"unknown":"String"
				},
				"nested_hv":{
					"state":"String"
				},
				"pae":{},
				"pmu":{
					"state":"String"
				},
				"privnet":{},
				"pvspinlock":{
					"state":"String"
				},
				"smm":{
					"state":"String",
					"tseg":{
						"text":"String",
						"unit":"String"
					}
				},
				"viridian":{},
				"vmcoreinfo":{
					"state":"String"
				},
				"vmport":{
					"state":"String"
				}
			},
			"genid":{
				"text":"String"
			},
			"id":"String",
			"idmap":{
				"gid":[
					{
						"count":"String",
						"start":"String",
						"target":"String"
					},
					{
						"count":"String",
						"start":"String",
						"target":"String"
					}
				],
				"uid":[
					{
						"count":"String",
						"start":"String",
						"target":"String"
					},
					{
						"count":"String",
						"start":"String",
						"target":"String"
					}
				]
			},
			"iothreadids":{
				"iothread":[
					{
						"id":"String"
					},
					{
						"id":"String"
					}
				]
			},
			"iothreads":{
				"text":"String"
			},
			"keywrap":{
				"cipher":[
					{
						"name":"String",
						"state":"String"
					},
					{
						"name":"String",
						"state":"String"
					}
				]
			},
			"launchSecurity":{},
			"maxMemory":{
				"slots":"String",
				"text":"String",
				"unit":"String"
			},
			"memory":{
				"dumpCore":"String",
				"text":"String",
				"unit":"String"
			},
			"memoryBacking":{
				"access":{
					"mode":"String"
				},
				"allocation":{
					"mode":"String"
				},
				"discard":{},
				"hugepages":{
					"page":[
						{
							"nodeset":"String",
							"size":"String",
							"unit":"String"
						},
						{
							"nodeset":"String",
							"size":"String",
							"unit":"String"
						}
					]
				},
				"locked":{},
				"nosharepages":{},
				"source":{
					"type":"String"
				}
			},
			"memtune":{
				"hard_limit":{
					"text":"String",
					"unit":"String"
				},
				"min_guarantee":{
					"text":"String",
					"unit":"String"
				},
				"soft_limit":{
					"text":"String",
					"unit":"String"
				},
				"swap_hard_limit":{
					"text":"String",
					"unit":"String"
				}
			},
			"metadata":{},
			"name":{
				"text":"String"
			},
			"numatune":{
				"memnode":[
					{
						"cellid":"String",
						"mode":"String",
						"nodeset":"String"
					},
					{
						"cellid":"String",
						"mode":"String",
						"nodeset":"String"
					}
				],
				"memory":{
					"mode":"String",
					"nodeset":"String",
					"placement":"String"
				}
			},
			"on_crash":{
				"text":"String"
			},
			"on_poweroff":{
				"text":"String"
			},
			"on_reboot":{
				"text":"String"
			},
			"os":{
				"acpi":{
					"table":[
						{
							"text":"String",
							"type":"String"
						},
						{
							"text":"String",
							"type":"String"
						}
					]
				},
				"bios":{
					"rebootTimeout":"String",
					"useserial":"String"
				},
				"boot":[
					{
						"dev":"String"
					},
					{
						"dev":"String"
					}
				],
				"bootmenu":{
					"enable":"String",
					"timeout":"String"
				},
				"cmdline":{
					"text":"String"
				},
				"dtb":{
					"text":"String"
				},
				"init":{
					"text":"String"
				},
				"initarg":{
					"text":"String"
				},
				"initdir":{
					"text":"String"
				},
				"initenv":[
					{
						"name":"String",
						"text":"String"
					},
					{
						"name":"String",
						"text":"String"
					}
				],
				"initgroup":{
					"text":"String"
				},
				"initrd":{
					"text":"String"
				},
				"inituser":{
					"text":"String"
				},
				"kernel":{
					"text":"String"
				},
				"loader":{
					"text":"String"
				},
				"nvram":{
					"text":"String"
				},
				"smbios":{
					"mode":"String"
				},
				"type":{
					"arch":"String",
					"machine":"String",
					"text":"String"
				}
			},
			"perf":{
				"event":[
					{
						"enabled":"String",
						"name":"String"
					},
					{
						"enabled":"String",
						"name":"String"
					}
				]
			},
			"pm":{
				"suspend_to_disk":{
					"enabled":"String"
				},
				"suspend_to_mem":{
					"enabled":"String"
				}
			},
			"resource":{
				"partition":{
					"text":"String"
				}
			},
			"seclabel":[
				{
					"baselabel":{
						"text":"String"
					},
					"imagelabel":{
						"text":"String"
					},
					"label":{
						"text":"String"
					},
					"model":"String",
					"relabel":"String",
					"type":"String"
				},
				{
					"baselabel":{
						"text":"String"
					},
					"imagelabel":{
						"text":"String"
					},
					"label":{
						"text":"String"
					},
					"model":"String",
					"relabel":"String",
					"type":"String"
				}
			],
			"sysinfo":{
				"baseBoard":[
					{
						"entry":[
							{
								"name":"String",
								"text":"String"
							},
							{
								"name":"String",
								"text":"String"
							}
						]
					},
					{
						"entry":[
							{
								"name":"String",
								"text":"String"
							},
							{
								"name":"String",
								"text":"String"
							}
						]
					}
				],
				"bios":{
					"entry":[
						{
							"name":"String",
							"text":"String"
						},
						{
							"name":"String",
							"text":"String"
						}
					]
				},
				"chassis":{
					"entry":[
						{
							"name":"String",
							"text":"String"
						},
						{
							"name":"String",
							"text":"String"
						}
					]
				},
				"memory":[
					{
						"entry":[
							{
								"name":"String",
								"text":"String"
							},
							{
								"name":"String",
								"text":"String"
							}
						]
					},
					{
						"entry":[
							{
								"name":"String",
								"text":"String"
							},
							{
								"name":"String",
								"text":"String"
							}
						]
					}
				],
				"oemStrings":{
					"entry":{
						"text":"String"
					}
				},
				"processor":[
					{
						"entry":[
							{
								"name":"String",
								"text":"String"
							},
							{
								"name":"String",
								"text":"String"
							}
						]
					},
					{
						"entry":[
							{
								"name":"String",
								"text":"String"
							},
							{
								"name":"String",
								"text":"String"
							}
						]
					}
				],
				"system":{
					"entry":[
						{
							"name":"String",
							"text":"String"
						},
						{
							"name":"String",
							"text":"String"
						}
					]
				},
				"type":"String"
			},
			"title":{
				"text":"String"
			},
			"type":"String",
			"uuid":{
				"text":"String"
			},
			"vcpu":{
				"cpuset":"String",
				"current":"String",
				"placement":"String",
				"text":"String"
			},
			"vcpus":{
				"vcpu":[
					{
						"enabled":"String",
						"hotpluggable":"String",
						"id":"String",
						"order":"String"
					},
					{
						"enabled":"String",
						"hotpluggable":"String",
						"id":"String",
						"order":"String"
					}
				]
			}
		},
		"lifecycle":{
			"changeNumberOfCPU":{
				"config":true,
				"count":1,
				"current":true,
				"guest":true,
				"hotpluggable":true,
				"live":true
			},
			"convertVMToImage":{},
			"createAndStartVMFromISO":{
				"arch":"String",
				"autostart":"String",
				"blkiotune":"String",
				"boot":"String",
				"cdrom":"String",
				"channel":"String",
				"check":"String",
				"clock":"String",
				"console":"String",
				"container":"String",
				"controller":"String",
				"cpu":"String",
				"cputune":"String",
				"disk":"String",
				"dry_run":"String",
				"events":"String",
				"extra_args":"String",
				"features":"String",
				"filesystem":"String",
				"graphics":"String",
				"hostdev":"String",
				"hvm":"String",
				"idmap":"String",
				"import":true,
				"initrd_inject":"String",
				"input":"String",
				"livecd":"String",
				"location":"String",
				"machine":"String",
				"memballoon":"String",
				"memdev":"String",
				"memory":"String",
				"memorybacking":"String",
				"memtune":"String",
				"metadata":"String",
				"network":"String",
				"noautoconsole":true,
				"noreboot":"String",
				"numatune":"String",
				"os_variant":"String",
				"panic":"String",
				"parallel":"String",
				"paravirt":"String",
				"pm":"String",
				"pxe":"String",
				"qemu_commandline":"String",
				"redirdev":"String",
				"resource":"String",
				"rng":"String",
				"security":"String",
				"serial":"String",
				"smartcard":"String",
				"sound":"String",
				"sysinfo":"String",
				"tpm":"String",
				"vcpus":"String",
				"virt_type":"String",
				"watchdog":"String"
			},
			"createAndStartVMFromImage":{
				
			},
			"deleteVM":{
				"delete_snapshots":true,
				"remove_all_storage":true
			},
			"manageISO":{
				"block":true,
				"config":true,
				"current":true,
				"eject":true,
				"force":true,
				"insert":true,
				"live":true,
				"path":"String",
				"update":true
			},
			"migrateVM":{
				"abort_on_error":true,
				"auto_converge":true,
				"change_protection":true,
				"compressed":true,
				"copy_storage_all":true,
				"copy_storage_inc":true,
				"desturi":"String",
				"direct":true,
				"domain":"String",
				"live":true,
				"offline":true,
				"p2p":true,
				"persistent":true,
				"postcopy":true,
				"rdma_pin_all":true,
				"suspend":true,
				"tunnelled":true,
				"undefinesource":true,
				"unsafe":true
			},
			"plugDevice":{
				"config":true,
				"current":true,
				"file":"String",
				"live":true,
				"persistent":true
			},
			"plugDisk":{
				"address":"String",
				"cache":"String",
				"config":true,
				"driver":"String",
				"io":"String",
				"iothread":"String",
				"live":true,
				"mode":"String",
				"multifunction":true,
				"persistent":true,
				"rawio":true,
				"read_bytes_sec":"String",
				"read_iops_sec":"String",
				"serial":"String",
				"source":"String",
				"sourcetype":"String",
				"subdriver":"String",
				"target":"String",
				"targetbus":"String",
				"type":"String",
				"write_bytes_sec":"String",
				"write_iops_sec":"String",
				"wwn":"String"
			},
			"plugNIC":{
				"config":true,
				"current":true,
				"inbound":"String",
				"live":true,
				"mac":"String",
				"managed":true,
				"model":"String",
				"outbound":"String",
				"persistent":true,
				"script":"String",
				"source":"String",
				"target":"String",
				"type":"String"
			},
			"rebootVM":{},
			"resetVM":{},
			"resizeRAM":{
				"config":true,
				"current":true,
				"live":true,
				"size":"String"
			},
			"resumeVM":{},
			"startVM":{},
			"stopVM":{},
			"stopVMForce":{},
			"suspendVM":{},
			"unplugDevice":{
				"config":true,
				"current":true,
				"file":"String",
				"live":true,
				"persistent":true
			},
			"unplugDisk":{
				"config":true,
				"current":true,
				"live":true,
				"persistent":true,
				"target":"String"
			},
			"unplugNIC":{
				"config":true,
				"current":true,
				"live":true,
				"mac":"String",
				"persistent":true,
				"type":"String"
			},
			"updateOS":{
				"source":"String",
				"target":"String"
			}
		},
		"versions":[]
	}
}
```
# 2 VirtualMachineSnapshot

虚拟机/云盘快照.VirtualMachineSnapshot所有操作的返回值一样，见**[返回值]**

## 2.1 DeleteSnapshot(删除虚拟机/云盘快照)

**接口功能:**
	删除虚拟机/云盘快照，只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机/云盘快照存在，即已调用过CreateSnapshot

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Lifecycle.DeleteSnapshot

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | deleteSnapshot.name.001|
| deleteSnapshot | DeleteSnapshot | true | 删除虚拟机/云盘快照 | 详细见下 |
| eventId | String | fasle | 事件ID | deleteSnapshot.event.001 |

对象deleteSnapshot参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| domain|String|true|要删除快照的虚拟机名字|vm1|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看DeleteSnapshotspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 2.2 CreateSnapshot(创建虚拟机/云盘快照)

**接口功能:**
	创建虚拟机/云盘快照，只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Lifecycle.CreateSnapshot

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | createSnapshot.name.001|
| nodeName | String | false | 选择部署的物理机，可以通过kubernetes.nodes().list进行查询 | node22 |
| createSnapshot | CreateSnapshot | true | 创建虚拟机/云盘快照 | 详细见下 |
| eventId | String | fasle | 事件ID | createSnapshot.event.001 |

对象createSnapshot参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| domain|String|true|要恢复到快照状态的虚拟机name|vm1|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看CreateSnapshotspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 2.3 RevertVirtualMachine(恢复成虚拟机/云盘)

**接口功能:**
	恢复成虚拟机/云盘，只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机/云盘快照存在，即已调用过CreateSnapshot

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Lifecycle.RevertVirtualMachine

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | revertVirtualMachine.name.001|
| revertVirtualMachine | RevertVirtualMachine | true | 恢复成虚拟机/云盘 | 详细见下 |
| eventId | String | fasle | 事件ID | revertVirtualMachine.event.001 |

对象revertVirtualMachine参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| domain|String|true|要恢复到快照状态的虚拟机name|vm1|
| running|Boolean|false|恢复到快照的状态后，是否将虚拟机转换到开机状态|true|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看RevertVirtualMachinespec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## **返回值:**

```
{
	"kind":"VirtualMachineSnapshot",
	"metadata":{
		"additionalProperties":{},
		"finalizers":[],
		"ownerReferences":[]
	},
	"spec":{
		"additionalPrinterColumns":[],
		"additionalProperties":{},
		"domainsnapshot":{
			"active":{
				"text":"String"
			},
			"cookie":{
				"cpu":{
					"check":"String",
					"feature":[
						{
							"name":"String",
							"policy":"String"
						},
						{
							"name":"String",
							"policy":"String"
						}
					],
					"match":"String",
					"mode":"String",
					"model":{
						"fallback":"String",
						"text":"String"
					}
				}
			},
			"creationTime":{
				"text":"String"
			},
			"description":{
				"text":"String"
			},
			"disks":{
				"disk":[
					{
						"driver":{
							"type":"String"
						},
						"name":"String",
						"snapshot":"String",
						"source":{
							"encryption":{
								"format":"String",
								"secret":{
									"type":"String",
									"usage":"String",
									"uuid":"String"
								}
							},
							"index":"String",
							"reservations":{
								"enabled":"String",
								"managed":"String",
								"source":{
									"dev":"String",
									"mode":"String",
									"path":"String",
									"type":"String"
								}
							},
							"startupPolicy":"String"
						}
					},
					{
						"driver":{
							"type":"String"
						},
						"name":"String",
						"snapshot":"String",
						"source":{
							"encryption":{
								"format":"String",
								"secret":{
									"type":"String",
									"usage":"String",
									"uuid":"String"
								}
							},
							"index":"String",
							"reservations":{
								"enabled":"String",
								"managed":"String",
								"source":{
									"dev":"String",
									"mode":"String",
									"path":"String",
									"type":"String"
								}
							},
							"startupPolicy":"String"
						}
					}
				]
			},
			"domain":{
				"blkiotune":{
					"device":[
						{
							"path":{
								"text":"String"
							},
							"read_bytes_sec":{
								"text":"String"
							},
							"read_iops_sec":{
								"text":"String"
							},
							"weight":{
								"text":"String"
							},
							"write_bytes_sec":{
								"text":"String"
							},
							"write_iops_sec":{
								"text":"String"
							}
						},
						{
							"path":{
								"text":"String"
							},
							"read_bytes_sec":{
								"text":"String"
							},
							"read_iops_sec":{
								"text":"String"
							},
							"weight":{
								"text":"String"
							},
							"write_bytes_sec":{
								"text":"String"
							},
							"write_iops_sec":{
								"text":"String"
							}
						}
					],
					"weight":{
						"text":"String"
					}
				},
				"bootloader":{
					"text":"String"
				},
				"bootloader_args":{
					"text":"String"
				},
				"clock":{
					"adjustment":"String",
					"basis":"String",
					"offset":"String",
					"timer":[
						{
							"catchup":{
								"limit":"String",
								"slew":"String",
								"threshold":"String"
							},
							"frequency":"String",
							"mode":"String",
							"name":"String",
							"present":"String",
							"tickpolicy":"String",
							"track":"String"
						},
						{
							"catchup":{
								"limit":"String",
								"slew":"String",
								"threshold":"String"
							},
							"frequency":"String",
							"mode":"String",
							"name":"String",
							"present":"String",
							"tickpolicy":"String",
							"track":"String"
						}
					],
					"timezone":"String"
				},
				"cpu":{
					"cache":{
						"level":"String",
						"mode":"String"
					},
					"check":"String",
					"feature":[
						{
							"name":"String",
							"policy":"String"
						},
						{
							"name":"String",
							"policy":"String"
						}
					],
					"match":"String",
					"mode":"String",
					"model":{
						"fallback":"String",
						"text":"String",
						"vendor_id":"String"
					},
					"numa":{
						"cell":[
							{
								"cpus":"String",
								"discard":"String",
								"distances":{
									"sibling":[
										{
											"id":"String",
											"value":"String"
										},
										{
											"id":"String",
											"value":"String"
										}
									]
								},
								"id":"String",
								"memAccess":"String",
								"memory":"String",
								"unit":"String"
							},
							{
								"cpus":"String",
								"discard":"String",
								"distances":{
									"sibling":[
										{
											"id":"String",
											"value":"String"
										},
										{
											"id":"String",
											"value":"String"
										}
									]
								},
								"id":"String",
								"memAccess":"String",
								"memory":"String",
								"unit":"String"
							}
						]
					},
					"topology":{
						"cores":"String",
						"sockets":"String",
						"threads":"String"
					},
					"vendor":{
						"text":"String"
					}
				},
				"cputune":{
					"cachetune":[
						{
							"cache":[
								{
									"id":"String",
									"level":"String",
									"size":"String",
									"type":"String",
									"unit":"String"
								},
								{
									"id":"String",
									"level":"String",
									"size":"String",
									"type":"String",
									"unit":"String"
								}
							],
							"monitor":[
								{
									"level":"String",
									"vcpus":"String"
								},
								{
									"level":"String",
									"vcpus":"String"
								}
							],
							"vcpus":"String"
						},
						{
							"cache":[
								{
									"id":"String",
									"level":"String",
									"size":"String",
									"type":"String",
									"unit":"String"
								},
								{
									"id":"String",
									"level":"String",
									"size":"String",
									"type":"String",
									"unit":"String"
								}
							],
							"monitor":[
								{
									"level":"String",
									"vcpus":"String"
								},
								{
									"level":"String",
									"vcpus":"String"
								}
							],
							"vcpus":"String"
						}
					],
					"emulator_period":{
						"text":"String"
					},
					"emulator_quota":{
						"text":"String"
					},
					"emulatorpin":{
						"cpuset":"String"
					},
					"global_period":{
						"text":"String"
					},
					"global_quota":{
						"text":"String"
					},
					"iothread_period":{
						"text":"String"
					},
					"iothread_quota":{
						"text":"String"
					},
					"iothreadpin":[
						{
							"cpuset":"String",
							"iothread":"String"
						},
						{
							"cpuset":"String",
							"iothread":"String"
						}
					],
					"iothreadsched":[
						{
							"iothreads":"String",
							"priority":"String",
							"scheduler":"String"
						},
						{
							"iothreads":"String",
							"priority":"String",
							"scheduler":"String"
						}
					],
					"memorytune":[
						{
							"node":[
								{
									"bandwidth":"String",
									"id":"String"
								},
								{
									"bandwidth":"String",
									"id":"String"
								}
							],
							"vcpus":"String"
						},
						{
							"node":[
								{
									"bandwidth":"String",
									"id":"String"
								},
								{
									"bandwidth":"String",
									"id":"String"
								}
							],
							"vcpus":"String"
						}
					],
					"period":{
						"text":"String"
					},
					"quota":{
						"text":"String"
					},
					"shares":{
						"text":"String"
					},
					"vcpupin":[
						{
							"cpuset":"String",
							"vcpu":"String"
						},
						{
							"cpuset":"String",
							"vcpu":"String"
						}
					],
					"vcpusched":[
						{
							"priority":"String",
							"scheduler":"String",
							"vcpus":"String"
						},
						{
							"priority":"String",
							"scheduler":"String",
							"vcpus":"String"
						}
					]
				},
				"currentMemory":{
					"text":"String",
					"unit":"String"
				},
				"description":{
					"text":"String"
				},
				"devices":{
					"channel":[
						{
							"address":{
								"bus":"String",
								"controller":"String",
								"port":"String",
								"type":"String"
							},
							"alias":{
								"name":"String"
							},
							"log":{
								"append":"String",
								"file":"String"
							},
							"protocol":{
								"type":"String"
							},
							"source":{
								"mode":"String",
								"path":"String"
							},
							"target":{
								"name":"String",
								"state":"String",
								"type":"String"
							},
							"type":"String"
						},
						{
							"address":{
								"bus":"String",
								"controller":"String",
								"port":"String",
								"type":"String"
							},
							"alias":{
								"name":"String"
							},
							"log":{
								"append":"String",
								"file":"String"
							},
							"protocol":{
								"type":"String"
							},
							"source":{
								"mode":"String",
								"path":"String"
							},
							"target":{
								"name":"String",
								"state":"String",
								"type":"String"
							},
							"type":"String"
						}
					],
					"console":[
						{
							"address":{},
							"alias":{
								"name":"String"
							},
							"log":{
								"append":"String",
								"file":"String"
							},
							"protocol":{
								"type":"String"
							},
							"source":{
								"path":"String"
							},
							"target":{
								"port":"String",
								"type":"String"
							},
							"tty":"String",
							"type":"String"
						},
						{
							"address":{},
							"alias":{
								"name":"String"
							},
							"log":{
								"append":"String",
								"file":"String"
							},
							"protocol":{
								"type":"String"
							},
							"source":{
								"path":"String"
							},
							"target":{
								"port":"String",
								"type":"String"
							},
							"tty":"String",
							"type":"String"
						}
					],
					"controller":[
						{
							"address":{
								"bus":"String",
								"domain":"String",
								"function":"String",
								"multifunction":"String",
								"slot":"String",
								"type":"String"
							},
							"alias":{
								"name":"String"
							},
							"driver":{
								"ats":"String",
								"cmd_per_lun":"String",
								"ioeventfd":"String",
								"iommu":"String",
								"iothread":"String",
								"max_sectors":"String",
								"queues":"String"
							},
							"index":"String",
							"master":{
								"startport":"String"
							},
							"model":"String",
							"type":"String"
						},
						{
							"address":{
								"bus":"String",
								"domain":"String",
								"function":"String",
								"multifunction":"String",
								"slot":"String",
								"type":"String"
							},
							"alias":{
								"name":"String"
							},
							"driver":{
								"ats":"String",
								"cmd_per_lun":"String",
								"ioeventfd":"String",
								"iommu":"String",
								"iothread":"String",
								"max_sectors":"String",
								"queues":"String"
							},
							"index":"String",
							"master":{
								"startport":"String"
							},
							"model":"String",
							"type":"String"
						}
					],
					"disk":[
						{
							"address":{
								"bus":"String",
								"controller":"String",
								"domain":"String",
								"function":"String",
								"slot":"String",
								"target":"String",
								"type":"String",
								"unit":"String"
							},
							"alias":{
								"name":"String"
							},
							"auth":{
								"secret":{
									"type":"String",
									"usage":"String",
									"uuid":"String"
								},
								"username":"String"
							},
							"backingStore":{
								"format":{
									"type":"String"
								},
								"index":"String",
								"source":{
									"encryption":{
										"format":"String",
										"secret":{
											"type":"String",
											"usage":"String",
											"uuid":"String"
										}
									},
									"index":"String",
									"reservations":{
										"enabled":"String",
										"managed":"String",
										"source":{
											"dev":"String",
											"mode":"String",
											"path":"String",
											"type":"String"
										}
									},
									"startupPolicy":"String"
								}
							},
							"blockio":{
								"logical_block_size":"String",
								"physical_block_size":"String"
							},
							"boot":{
								"loadparm":"String",
								"order":"String"
							},
							"device":"String",
							"driver":{
								"ats":"String",
								"cache":"String",
								"copy_on_read":"String",
								"detect_zeroes":"String",
								"discard":"String",
								"error_policy":"String",
								"event_idx":"String",
								"io":"String",
								"ioeventfd":"String",
								"iommu":"String",
								"iothread":"String",
								"name":"String",
								"queues":"String",
								"rerror_policy":"String",
								"type":"String"
							},
							"encryption":{
								"format":"String",
								"secret":{
									"type":"String",
									"usage":"String",
									"uuid":"String"
								}
							},
							"geometry":{
								"cyls":"String",
								"heads":"String",
								"secs":"String",
								"trans":"String"
							},
							"iotune":{
								"group_name":{
									"text":"String"
								},
								"read_bytes_sec":{
									"text":"String"
								},
								"read_bytes_sec_max":{
									"text":"String"
								},
								"read_bytes_sec_max_length":{
									"text":"String"
								},
								"read_iops_sec":{
									"text":"String"
								},
								"read_iops_sec_max":{
									"text":"String"
								},
								"read_iops_sec_max_length":{
									"text":"String"
								},
								"size_iops_sec":{
									"text":"String"
								},
								"total_bytes_sec":{
									"text":"String"
								},
								"total_bytes_sec_max":{
									"text":"String"
								},
								"total_bytes_sec_max_length":{
									"text":"String"
								},
								"total_iops_sec":{
									"text":"String"
								},
								"total_iops_sec_max":{
									"text":"String"
								},
								"total_iops_sec_max_length":{
									"text":"String"
								},
								"write_bytes_sec":{
									"text":"String"
								},
								"write_bytes_sec_max":{
									"text":"String"
								},
								"write_bytes_sec_max_length":{
									"text":"String"
								},
								"write_iops_sec":{
									"text":"String"
								},
								"write_iops_sec_max":{
									"text":"String"
								},
								"write_iops_sec_max_length":{
									"text":"String"
								}
							},
							"mirror":{
								"format":{
									"type":"String"
								},
								"job":"String",
								"ready":"String",
								"source":{
									"encryption":{
										"format":"String",
										"secret":{
											"type":"String",
											"usage":"String",
											"uuid":"String"
										}
									},
									"index":"String",
									"reservations":{
										"enabled":"String",
										"managed":"String",
										"source":{
											"dev":"String",
											"mode":"String",
											"path":"String",
											"type":"String"
										}
									},
									"startupPolicy":"String"
								}
							},
							"model":"String",
							"product":{
								"text":"String"
							},
							"rawio":"String",
							"readonly":{},
							"serial":{
								"text":"String",
								"type":"String"
							},
							"sgio":"String",
							"shareable":{},
							"snapshot":"String",
							"source":{
								"controller":"String",
								"encryption":{
									"format":"String",
									"secret":{
										"type":"String",
										"usage":"String",
										"uuid":"String"
									}
								},
								"file":"String",
								"index":"String",
								"reservations":{
									"enabled":"String",
									"managed":"String",
									"source":{
										"dev":"String",
										"mode":"String",
										"path":"String",
										"type":"String"
									}
								},
								"startupPolicy":"String"
							},
							"target":{
								"bus":"String",
								"dev":"String",
								"removable":"String",
								"tray":"String"
							},
							"transient":{},
							"type":"String",
							"vendor":{
								"text":"String"
							},
							"wwn":{
								"text":"String"
							}
						},
						{
							"address":{
								"bus":"String",
								"controller":"String",
								"domain":"String",
								"function":"String",
								"slot":"String",
								"target":"String",
								"type":"String",
								"unit":"String"
							},
							"alias":{
								"name":"String"
							},
							"auth":{
								"secret":{
									"type":"String",
									"usage":"String",
									"uuid":"String"
								},
								"username":"String"
							},
							"backingStore":{
								"format":{
									"type":"String"
								},
								"index":"String",
								"source":{
									"encryption":{
										"format":"String",
										"secret":{
											"type":"String",
											"usage":"String",
											"uuid":"String"
										}
									},
									"index":"String",
									"reservations":{
										"enabled":"String",
										"managed":"String",
										"source":{
											"dev":"String",
											"mode":"String",
											"path":"String",
											"type":"String"
										}
									},
									"startupPolicy":"String"
								}
							},
							"blockio":{
								"logical_block_size":"String",
								"physical_block_size":"String"
							},
							"boot":{
								"loadparm":"String",
								"order":"String"
							},
							"device":"String",
							"driver":{
								"ats":"String",
								"cache":"String",
								"copy_on_read":"String",
								"detect_zeroes":"String",
								"discard":"String",
								"error_policy":"String",
								"event_idx":"String",
								"io":"String",
								"ioeventfd":"String",
								"iommu":"String",
								"iothread":"String",
								"name":"String",
								"queues":"String",
								"rerror_policy":"String",
								"type":"String"
							},
							"encryption":{
								"format":"String",
								"secret":{
									"type":"String",
									"usage":"String",
									"uuid":"String"
								}
							},
							"geometry":{
								"cyls":"String",
								"heads":"String",
								"secs":"String",
								"trans":"String"
							},
							"iotune":{
								"group_name":{
									"text":"String"
								},
								"read_bytes_sec":{
									"text":"String"
								},
								"read_bytes_sec_max":{
									"text":"String"
								},
								"read_bytes_sec_max_length":{
									"text":"String"
								},
								"read_iops_sec":{
									"text":"String"
								},
								"read_iops_sec_max":{
									"text":"String"
								},
								"read_iops_sec_max_length":{
									"text":"String"
								},
								"size_iops_sec":{
									"text":"String"
								},
								"total_bytes_sec":{
									"text":"String"
								},
								"total_bytes_sec_max":{
									"text":"String"
								},
								"total_bytes_sec_max_length":{
									"text":"String"
								},
								"total_iops_sec":{
									"text":"String"
								},
								"total_iops_sec_max":{
									"text":"String"
								},
								"total_iops_sec_max_length":{
									"text":"String"
								},
								"write_bytes_sec":{
									"text":"String"
								},
								"write_bytes_sec_max":{
									"text":"String"
								},
								"write_bytes_sec_max_length":{
									"text":"String"
								},
								"write_iops_sec":{
									"text":"String"
								},
								"write_iops_sec_max":{
									"text":"String"
								},
								"write_iops_sec_max_length":{
									"text":"String"
								}
							},
							"mirror":{
								"format":{
									"type":"String"
								},
								"job":"String",
								"ready":"String",
								"source":{
									"encryption":{
										"format":"String",
										"secret":{
											"type":"String",
											"usage":"String",
											"uuid":"String"
										}
									},
									"index":"String",
									"reservations":{
										"enabled":"String",
										"managed":"String",
										"source":{
											"dev":"String",
											"mode":"String",
											"path":"String",
											"type":"String"
										}
									},
									"startupPolicy":"String"
								}
							},
							"model":"String",
							"product":{
								"text":"String"
							},
							"rawio":"String",
							"readonly":{},
							"serial":{
								"text":"String",
								"type":"String"
							},
							"sgio":"String",
							"shareable":{},
							"snapshot":"String",
							"source":{
								"controller":"String",
								"encryption":{
									"format":"String",
									"secret":{
										"type":"String",
										"usage":"String",
										"uuid":"String"
									}
								},
								"file":"String",
								"index":"String",
								"reservations":{
									"enabled":"String",
									"managed":"String",
									"source":{
										"dev":"String",
										"mode":"String",
										"path":"String",
										"type":"String"
									}
								},
								"startupPolicy":"String"
							},
							"target":{
								"bus":"String",
								"dev":"String",
								"removable":"String",
								"tray":"String"
							},
							"transient":{},
							"type":"String",
							"vendor":{
								"text":"String"
							},
							"wwn":{
								"text":"String"
							}
						}
					],
					"emulator":{
						"text":"String"
					},
					"filesystem":[
						{
							"accessmode":"String",
							"address":{},
							"alias":{
								"name":"String"
							},
							"driver":{
								"ats":"String",
								"format":"String",
								"iommu":"String",
								"name":"String",
								"type":"String",
								"wrpolicy":"String"
							},
							"model":"String",
							"readonly":{},
							"source":{},
							"space_hard_limit":{
								"text":"String",
								"unit":"String"
							},
							"space_soft_limit":{
								"text":"String",
								"unit":"String"
							},
							"target":{
								"dir":"String"
							}
						},
						{
							"accessmode":"String",
							"address":{},
							"alias":{
								"name":"String"
							},
							"driver":{
								"ats":"String",
								"format":"String",
								"iommu":"String",
								"name":"String",
								"type":"String",
								"wrpolicy":"String"
							},
							"model":"String",
							"readonly":{},
							"source":{},
							"space_hard_limit":{
								"text":"String",
								"unit":"String"
							},
							"space_soft_limit":{
								"text":"String",
								"unit":"String"
							},
							"target":{
								"dir":"String"
							}
						}
					],
					"graphics":[
						{
							"autoport":"String",
							"listen":{
								"address":"String",
								"type":"String"
							},
							"port":"String",
							"type":"String"
						},
						{
							"autoport":"String",
							"listen":{
								"address":"String",
								"type":"String"
							},
							"port":"String",
							"type":"String"
						}
					],
					"hostdev":[
						{
							"address":{},
							"alias":{
								"name":"String"
							},
							"boot":{
								"loadparm":"String",
								"order":"String"
							},
							"managed":"String",
							"rom":{
								"bar":"String",
								"enabled":"String",
								"file":"String"
							}
						},
						{
							"address":{},
							"alias":{
								"name":"String"
							},
							"boot":{
								"loadparm":"String",
								"order":"String"
							},
							"managed":"String",
							"rom":{
								"bar":"String",
								"enabled":"String",
								"file":"String"
							}
						}
					],
					"hub":[
						{
							"address":{},
							"alias":{
								"name":"String"
							},
							"type":"String"
						},
						{
							"address":{},
							"alias":{
								"name":"String"
							},
							"type":"String"
						}
					],
					"input":[
						{
							"address":{
								"bus":"String",
								"port":"String",
								"type":"String"
							},
							"alias":{
								"name":"String"
							},
							"bus":"String",
							"driver":{
								"ats":"String",
								"iommu":"String"
							},
							"model":"String",
							"source":{
								"evdev":"String"
							},
							"type":"String"
						},
						{
							"address":{
								"bus":"String",
								"port":"String",
								"type":"String"
							},
							"alias":{
								"name":"String"
							},
							"bus":"String",
							"driver":{
								"ats":"String",
								"iommu":"String"
							},
							"model":"String",
							"source":{
								"evdev":"String"
							},
							"type":"String"
						}
					],
					"interface":[
						{
							"address":{
								"bus":"String",
								"domain":"String",
								"function":"String",
								"slot":"String",
								"type":"String"
							},
							"alias":{
								"name":"String"
							},
							"backend":{
								"tap":"String",
								"vhost":"String"
							},
							"bandwidth":{
								"inbound":{
									"average":"String",
									"burst":"String",
									"floor":"String",
									"peak":"String"
								},
								"outbound":{
									"average":"String",
									"burst":"String",
									"floor":"String",
									"peak":"String"
								}
							},
							"boot":{
								"loadparm":"String",
								"order":"String"
							},
							"coalesce":{
								"rx":{
									"frames":{
										"max":"String"
									}
								}
							},
							"driver":{
								"ats":"String",
								"event_idx":"String",
								"guest":{
									"csum":"String",
									"ecn":"String",
									"tso4":"String",
									"tso6":"String",
									"ufo":"String"
								},
								"host":{
									"csum":"String",
									"ecn":"String",
									"gso":"String",
									"mrg_rxbuf":"String",
									"tso4":"String",
									"tso6":"String",
									"ufo":"String"
								},
								"ioeventfd":"String",
								"iommu":"String",
								"name":"String",
								"queues":"String",
								"rx_queue_size":"String",
								"tx_queue_size":"String",
								"txmode":"String"
							},
							"filterref":{
								"filter":"String",
								"parameter":[
									{
										"name":"String",
										"value":"String"
									},
									{
										"name":"String",
										"value":"String"
									}
								]
							},
							"guest":{
								"actual":"String",
								"dev":"String"
							},
							"ip":[
								{
									"address":"String",
									"family":"String",
									"peer":"String",
									"prefix":"String"
								},
								{
									"address":"String",
									"family":"String",
									"peer":"String",
									"prefix":"String"
								}
							],
							"link":{
								"state":"String"
							},
							"mac":{
								"address":"String"
							},
							"managed":"String",
							"model":{
								"type":"String"
							},
							"mtu":{
								"size":"String"
							},
							"rom":{
								"bar":"String",
								"enabled":"String",
								"file":"String"
							},
							"route":[
								{
									"address":"String",
									"family":"String",
									"gateway":"String",
									"metric":"String",
									"netmask":"String",
									"prefix":"String"
								},
								{
									"address":"String",
									"family":"String",
									"gateway":"String",
									"metric":"String",
									"netmask":"String",
									"prefix":"String"
								}
							],
							"script":{
								"path":"String"
							},
							"source":{
								"bridge":"String",
								"network":"String"
							},
							"target":{
								"dev":"String"
							},
							"trustGuestRxFilters":"String",
							"tune":{
								"sndbuf":{
									"text":"String"
								}
							},
							"type":"String",
							"virtualport":{
								"parameters":{
									"_interfaceid":"String"
								},
								"type":"String"
							},
							"vlan":{
								"tag":[
									{
										"id":"String",
										"nativeMode":"String"
									},
									{
										"id":"String",
										"nativeMode":"String"
									}
								],
								"trunk":"String"
							}
						},
						{
							"address":{
								"bus":"String",
								"domain":"String",
								"function":"String",
								"slot":"String",
								"type":"String"
							},
							"alias":{
								"name":"String"
							},
							"backend":{
								"tap":"String",
								"vhost":"String"
							},
							"bandwidth":{
								"inbound":{
									"average":"String",
									"burst":"String",
									"floor":"String",
									"peak":"String"
								},
								"outbound":{
									"average":"String",
									"burst":"String",
									"floor":"String",
									"peak":"String"
								}
							},
							"boot":{
								"loadparm":"String",
								"order":"String"
							},
							"coalesce":{
								"rx":{
									"frames":{
										"max":"String"
									}
								}
							},
							"driver":{
								"ats":"String",
								"event_idx":"String",
								"guest":{
									"csum":"String",
									"ecn":"String",
									"tso4":"String",
									"tso6":"String",
									"ufo":"String"
								},
								"host":{
									"csum":"String",
									"ecn":"String",
									"gso":"String",
									"mrg_rxbuf":"String",
									"tso4":"String",
									"tso6":"String",
									"ufo":"String"
								},
								"ioeventfd":"String",
								"iommu":"String",
								"name":"String",
								"queues":"String",
								"rx_queue_size":"String",
								"tx_queue_size":"String",
								"txmode":"String"
							},
							"filterref":{
								"filter":"String",
								"parameter":[
									{
										"name":"String",
										"value":"String"
									},
									{
										"name":"String",
										"value":"String"
									}
								]
							},
							"guest":{
								"actual":"String",
								"dev":"String"
							},
							"ip":[
								{
									"address":"String",
									"family":"String",
									"peer":"String",
									"prefix":"String"
								},
								{
									"address":"String",
									"family":"String",
									"peer":"String",
									"prefix":"String"
								}
							],
							"link":{
								"state":"String"
							},
							"mac":{
								"address":"String"
							},
							"managed":"String",
							"model":{
								"type":"String"
							},
							"mtu":{
								"size":"String"
							},
							"rom":{
								"bar":"String",
								"enabled":"String",
								"file":"String"
							},
							"route":[
								{
									"address":"String",
									"family":"String",
									"gateway":"String",
									"metric":"String",
									"netmask":"String",
									"prefix":"String"
								},
								{
									"address":"String",
									"family":"String",
									"gateway":"String",
									"metric":"String",
									"netmask":"String",
									"prefix":"String"
								}
							],
							"script":{
								"path":"String"
							},
							"source":{
								"bridge":"String",
								"network":"String"
							},
							"target":{
								"dev":"String"
							},
							"trustGuestRxFilters":"String",
							"tune":{
								"sndbuf":{
									"text":"String"
								}
							},
							"type":"String",
							"virtualport":{
								"parameters":{
									"_interfaceid":"String"
								},
								"type":"String"
							},
							"vlan":{
								"tag":[
									{
										"id":"String",
										"nativeMode":"String"
									},
									{
										"id":"String",
										"nativeMode":"String"
									}
								],
								"trunk":"String"
							}
						}
					],
					"iommu":{
						"driver":{
							"caching_mode":"String",
							"eim":"String",
							"intremap":"String",
							"iotlb":"String"
						},
						"model":"String"
					},
					"lease":[
						{
							"key":{
								"text":"String"
							},
							"lockspace":{
								"text":"String"
							},
							"target":{
								"offset":"String",
								"path":"String"
							}
						},
						{
							"key":{
								"text":"String"
							},
							"lockspace":{
								"text":"String"
							},
							"target":{
								"offset":"String",
								"path":"String"
							}
						}
					],
					"memballoon":{
						"address":{
							"bus":"String",
							"domain":"String",
							"function":"String",
							"slot":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"autodeflate":"String",
						"driver":{
							"ats":"String",
							"iommu":"String"
						},
						"model":"String",
						"stats":{
							"period":"String"
						}
					},
					"memory":[
						{
							"access":"String",
							"address":{},
							"alias":{
								"name":"String"
							},
							"discard":"String",
							"model":"String",
							"source":{
								"alignsize":{
									"text":"String",
									"unit":"String"
								},
								"nodemask":{
									"text":"String"
								},
								"pagesize":{
									"text":"String",
									"unit":"String"
								},
								"path":{
									"text":"String"
								},
								"pmem":{}
							},
							"target":{
								"label":{
									"size":{
										"text":"String",
										"unit":"String"
									}
								},
								"node":{
									"text":"String"
								},
								"readonly":{},
								"size":{
									"text":"String",
									"unit":"String"
								}
							}
						},
						{
							"access":"String",
							"address":{},
							"alias":{
								"name":"String"
							},
							"discard":"String",
							"model":"String",
							"source":{
								"alignsize":{
									"text":"String",
									"unit":"String"
								},
								"nodemask":{
									"text":"String"
								},
								"pagesize":{
									"text":"String",
									"unit":"String"
								},
								"path":{
									"text":"String"
								},
								"pmem":{}
							},
							"target":{
								"label":{
									"size":{
										"text":"String",
										"unit":"String"
									}
								},
								"node":{
									"text":"String"
								},
								"readonly":{},
								"size":{
									"text":"String",
									"unit":"String"
								}
							}
						}
					],
					"nvram":{
						"address":{},
						"alias":{
							"name":"String"
						}
					},
					"panic":[
						{
							"address":{},
							"alias":{
								"name":"String"
							},
							"model":"String"
						},
						{
							"address":{},
							"alias":{
								"name":"String"
							},
							"model":"String"
						}
					],
					"parallel":[
						{
							"address":{},
							"alias":{
								"name":"String"
							},
							"log":{
								"append":"String",
								"file":"String"
							},
							"protocol":{
								"type":"String"
							},
							"source":{},
							"target":{
								"port":"String",
								"type":"String"
							}
						},
						{
							"address":{},
							"alias":{
								"name":"String"
							},
							"log":{
								"append":"String",
								"file":"String"
							},
							"protocol":{
								"type":"String"
							},
							"source":{},
							"target":{
								"port":"String",
								"type":"String"
							}
						}
					],
					"redirdev":[
						{
							"address":{},
							"alias":{
								"name":"String"
							},
							"boot":{
								"loadparm":"String",
								"order":"String"
							},
							"bus":"String",
							"protocol":{
								"type":"String"
							},
							"source":{}
						},
						{
							"address":{},
							"alias":{
								"name":"String"
							},
							"boot":{
								"loadparm":"String",
								"order":"String"
							},
							"bus":"String",
							"protocol":{
								"type":"String"
							},
							"source":{}
						}
					],
					"redirfilter":[
						{
							"usbdev":[
								{
									"allow":"String",
									"class":"String",
									"product":"String",
									"vendor":"String",
									"version":"String"
								},
								{
									"allow":"String",
									"class":"String",
									"product":"String",
									"vendor":"String",
									"version":"String"
								}
							]
						},
						{
							"usbdev":[
								{
									"allow":"String",
									"class":"String",
									"product":"String",
									"vendor":"String",
									"version":"String"
								},
								{
									"allow":"String",
									"class":"String",
									"product":"String",
									"vendor":"String",
									"version":"String"
								}
							]
						}
					],
					"rng":[
						{
							"address":{
								"bus":"String",
								"domain":"String",
								"function":"String",
								"slot":"String",
								"type":"String"
							},
							"alias":{
								"name":"String"
							},
							"backend":{
								"model":"String",
								"text":"String"
							},
							"driver":{
								"ats":"String",
								"iommu":"String"
							},
							"model":"String",
							"rate":{
								"bytes":"String",
								"period":"String"
							}
						},
						{
							"address":{
								"bus":"String",
								"domain":"String",
								"function":"String",
								"slot":"String",
								"type":"String"
							},
							"alias":{
								"name":"String"
							},
							"backend":{
								"model":"String",
								"text":"String"
							},
							"driver":{
								"ats":"String",
								"iommu":"String"
							},
							"model":"String",
							"rate":{
								"bytes":"String",
								"period":"String"
							}
						}
					],
					"serial":[
						{
							"address":{},
							"alias":{
								"name":"String"
							},
							"log":{
								"append":"String",
								"file":"String"
							},
							"protocol":{
								"type":"String"
							},
							"source":{
								"path":"String"
							},
							"target":{
								"model":{
									"name":"String"
								},
								"port":"String",
								"type":"String"
							},
							"type":"String"
						},
						{
							"address":{},
							"alias":{
								"name":"String"
							},
							"log":{
								"append":"String",
								"file":"String"
							},
							"protocol":{
								"type":"String"
							},
							"source":{
								"path":"String"
							},
							"target":{
								"model":{
									"name":"String"
								},
								"port":"String",
								"type":"String"
							},
							"type":"String"
						}
					],
					"shmem":[
						{
							"address":{},
							"alias":{
								"name":"String"
							},
							"model":{
								"type":"String"
							},
							"msi":{
								"enabled":"String",
								"ioeventfd":"String",
								"vectors":"String"
							},
							"name":"String",
							"server":{
								"path":"String"
							},
							"size":{
								"text":"String",
								"unit":"String"
							}
						},
						{
							"address":{},
							"alias":{
								"name":"String"
							},
							"model":{
								"type":"String"
							},
							"msi":{
								"enabled":"String",
								"ioeventfd":"String",
								"vectors":"String"
							},
							"name":"String",
							"server":{
								"path":"String"
							},
							"size":{
								"text":"String",
								"unit":"String"
							}
						}
					],
					"smartcard":[
						{
							"address":{},
							"alias":{
								"name":"String"
							},
							"certificate":[
								{
									"text":"String"
								},
								{
									"text":"String"
								}
							],
							"database":{
								"text":"String"
							},
							"protocol":{
								"type":"String"
							},
							"source":{}
						},
						{
							"address":{},
							"alias":{
								"name":"String"
							},
							"certificate":[
								{
									"text":"String"
								},
								{
									"text":"String"
								}
							],
							"database":{
								"text":"String"
							},
							"protocol":{
								"type":"String"
							},
							"source":{}
						}
					],
					"sound":[
						{
							"address":{},
							"alias":{
								"name":"String"
							},
							"codec":[
								{
									"type":"String"
								},
								{
									"type":"String"
								}
							],
							"model":"String"
						},
						{
							"address":{},
							"alias":{
								"name":"String"
							},
							"codec":[
								{
									"type":"String"
								},
								{
									"type":"String"
								}
							],
							"model":"String"
						}
					],
					"tpm":[
						{
							"address":{},
							"alias":{
								"name":"String"
							},
							"backend":{},
							"model":"String"
						},
						{
							"address":{},
							"alias":{
								"name":"String"
							},
							"backend":{},
							"model":"String"
						}
					],
					"video":[
						{
							"address":{
								"bus":"String",
								"domain":"String",
								"function":"String",
								"slot":"String",
								"type":"String"
							},
							"alias":{
								"name":"String"
							},
							"driver":{
								"ats":"String",
								"iommu":"String",
								"vgaconf":"String"
							},
							"model":{
								"acceleration":{
									"accel2d":"String",
									"accel3d":"String"
								},
								"heads":"String",
								"primary":"String",
								"ram":"String",
								"type":"String",
								"vgamem":"String",
								"vram":"String",
								"vram64":"String"
							}
						},
						{
							"address":{
								"bus":"String",
								"domain":"String",
								"function":"String",
								"slot":"String",
								"type":"String"
							},
							"alias":{
								"name":"String"
							},
							"driver":{
								"ats":"String",
								"iommu":"String",
								"vgaconf":"String"
							},
							"model":{
								"acceleration":{
									"accel2d":"String",
									"accel3d":"String"
								},
								"heads":"String",
								"primary":"String",
								"ram":"String",
								"type":"String",
								"vgamem":"String",
								"vram":"String",
								"vram64":"String"
							}
						}
					],
					"vsock":{
						"address":{},
						"alias":{
							"name":"String"
						},
						"cid":{
							"address":"String",
							"auto":"String"
						},
						"model":"String"
					},
					"watchdog":{
						"action":"String",
						"address":{},
						"alias":{
							"name":"String"
						},
						"model":"String"
					}
				},
				"features":{
					"acpi":{},
					"apic":{
						"eoi":"String"
					},
					"capabilities":{
						"audit_control":{
							"state":"String"
						},
						"audit_write":{
							"state":"String"
						},
						"block_suspend":{
							"state":"String"
						},
						"chown":{
							"state":"String"
						},
						"dac_override":{
							"state":"String"
						},
						"dac_read_Search":{
							"state":"String"
						},
						"fowner":{
							"state":"String"
						},
						"fsetid":{
							"state":"String"
						},
						"ipc_lock":{
							"state":"String"
						},
						"ipc_owner":{
							"state":"String"
						},
						"kill":{
							"state":"String"
						},
						"lease":{
							"state":"String"
						},
						"linux_immutable":{
							"state":"String"
						},
						"mac_admin":{
							"state":"String"
						},
						"mac_override":{
							"state":"String"
						},
						"mknod":{
							"state":"String"
						},
						"net_admin":{
							"state":"String"
						},
						"net_bind_service":{
							"state":"String"
						},
						"net_broadcast":{
							"state":"String"
						},
						"net_raw":{
							"state":"String"
						},
						"policy":"String",
						"setfcap":{
							"state":"String"
						},
						"setgid":{
							"state":"String"
						},
						"setpcap":{
							"state":"String"
						},
						"setuid":{
							"state":"String"
						},
						"sys_admin":{
							"state":"String"
						},
						"sys_boot":{
							"state":"String"
						},
						"sys_chroot":{
							"state":"String"
						},
						"sys_module":{
							"state":"String"
						},
						"sys_nice":{
							"state":"String"
						},
						"sys_pacct":{
							"state":"String"
						},
						"sys_ptrace":{
							"state":"String"
						},
						"sys_rawio":{
							"state":"String"
						},
						"sys_resource":{
							"state":"String"
						},
						"sys_time":{
							"state":"String"
						},
						"sys_tty_config":{
							"state":"String"
						},
						"syslog":{
							"state":"String"
						},
						"wake_alarm":{
							"state":"String"
						}
					},
					"gic":{
						"version":"String"
					},
					"hap":{
						"state":"String"
					},
					"hpt":{
						"maxpagesize":{
							"text":"String",
							"unit":"String"
						},
						"resizing":"String"
					},
					"htm":{
						"state":"String"
					},
					"hyperv":{
						"evmcs":{
							"state":"String"
						},
						"frequencies":{
							"state":"String"
						},
						"ipi":{
							"state":"String"
						},
						"reenlightenment":{
							"state":"String"
						},
						"relaxed":{
							"state":"String"
						},
						"reset":{
							"state":"String"
						},
						"runtime":{
							"state":"String"
						},
						"spinlocks":{
							"retries":"String",
							"state":"String"
						},
						"stimer":{
							"state":"String"
						},
						"synic":{
							"state":"String"
						},
						"tlbflush":{
							"state":"String"
						},
						"vapic":{
							"state":"String"
						},
						"vendor_id":{
							"value":"String"
						},
						"vpindex":{
							"state":"String"
						}
					},
					"ioapic":{
						"driver":"String"
					},
					"kvm":{
						"hidden":{
							"state":"String"
						}
					},
					"msrs":{
						"unknown":"String"
					},
					"nested_hv":{
						"state":"String"
					},
					"pae":{},
					"pmu":{
						"state":"String"
					},
					"privnet":{},
					"pvspinlock":{
						"state":"String"
					},
					"smm":{
						"state":"String",
						"tseg":{
							"text":"String",
							"unit":"String"
						}
					},
					"viridian":{},
					"vmcoreinfo":{
						"state":"String"
					},
					"vmport":{
						"state":"String"
					}
				},
				"genid":{
					"text":"String"
				},
				"id":"String",
				"idmap":{
					"gid":[
						{
							"count":"String",
							"start":"String",
							"target":"String"
						},
						{
							"count":"String",
							"start":"String",
							"target":"String"
						}
					],
					"uid":[
						{
							"count":"String",
							"start":"String",
							"target":"String"
						},
						{
							"count":"String",
							"start":"String",
							"target":"String"
						}
					]
				},
				"iothreadids":{
					"iothread":[
						{
							"id":"String"
						},
						{
							"id":"String"
						}
					]
				},
				"iothreads":{
					"text":"String"
				},
				"keywrap":{
					"cipher":[
						{
							"name":"String",
							"state":"String"
						},
						{
							"name":"String",
							"state":"String"
						}
					]
				},
				"launchSecurity":{},
				"maxMemory":{
					"slots":"String",
					"text":"String",
					"unit":"String"
				},
				"memory":{
					"dumpCore":"String",
					"text":"String",
					"unit":"String"
				},
				"memoryBacking":{
					"access":{
						"mode":"String"
					},
					"allocation":{
						"mode":"String"
					},
					"discard":{},
					"hugepages":{
						"page":[
							{
								"nodeset":"String",
								"size":"String",
								"unit":"String"
							},
							{
								"nodeset":"String",
								"size":"String",
								"unit":"String"
							}
						]
					},
					"locked":{},
					"nosharepages":{},
					"source":{
						"type":"String"
					}
				},
				"memtune":{
					"hard_limit":{
						"text":"String",
						"unit":"String"
					},
					"min_guarantee":{
						"text":"String",
						"unit":"String"
					},
					"soft_limit":{
						"text":"String",
						"unit":"String"
					},
					"swap_hard_limit":{
						"text":"String",
						"unit":"String"
					}
				},
				"metadata":{},
				"name":{
					"text":"String"
				},
				"numatune":{
					"memnode":[
						{
							"cellid":"String",
							"mode":"String",
							"nodeset":"String"
						},
						{
							"cellid":"String",
							"mode":"String",
							"nodeset":"String"
						}
					],
					"memory":{
						"mode":"String",
						"nodeset":"String",
						"placement":"String"
					}
				},
				"on_crash":{
					"text":"String"
				},
				"on_poweroff":{
					"text":"String"
				},
				"on_reboot":{
					"text":"String"
				},
				"os":{
					"acpi":{
						"table":[
							{
								"text":"String",
								"type":"String"
							},
							{
								"text":"String",
								"type":"String"
							}
						]
					},
					"bios":{
						"rebootTimeout":"String",
						"useserial":"String"
					},
					"boot":[
						{
							"dev":"String"
						},
						{
							"dev":"String"
						}
					],
					"bootmenu":{
						"enable":"String",
						"timeout":"String"
					},
					"cmdline":{
						"text":"String"
					},
					"dtb":{
						"text":"String"
					},
					"init":{
						"text":"String"
					},
					"initarg":{
						"text":"String"
					},
					"initdir":{
						"text":"String"
					},
					"initenv":[
						{
							"name":"String",
							"text":"String"
						},
						{
							"name":"String",
							"text":"String"
						}
					],
					"initgroup":{
						"text":"String"
					},
					"initrd":{
						"text":"String"
					},
					"inituser":{
						"text":"String"
					},
					"kernel":{
						"text":"String"
					},
					"loader":{
						"text":"String"
					},
					"nvram":{
						"text":"String"
					},
					"smbios":{
						"mode":"String"
					},
					"type":{
						"arch":"String",
						"machine":"String",
						"text":"String"
					}
				},
				"perf":{
					"event":[
						{
							"enabled":"String",
							"name":"String"
						},
						{
							"enabled":"String",
							"name":"String"
						}
					]
				},
				"pm":{
					"suspend_to_disk":{
						"enabled":"String"
					},
					"suspend_to_mem":{
						"enabled":"String"
					}
				},
				"resource":{
					"partition":{
						"text":"String"
					}
				},
				"seclabel":[
					{
						"baselabel":{
							"text":"String"
						},
						"imagelabel":{
							"text":"String"
						},
						"label":{
							"text":"String"
						},
						"model":"String",
						"relabel":"String",
						"type":"String"
					},
					{
						"baselabel":{
							"text":"String"
						},
						"imagelabel":{
							"text":"String"
						},
						"label":{
							"text":"String"
						},
						"model":"String",
						"relabel":"String",
						"type":"String"
					}
				],
				"sysinfo":{
					"baseBoard":[
						{
							"entry":[
								{
									"name":"String",
									"text":"String"
								},
								{
									"name":"String",
									"text":"String"
								}
							]
						},
						{
							"entry":[
								{
									"name":"String",
									"text":"String"
								},
								{
									"name":"String",
									"text":"String"
								}
							]
						}
					],
					"bios":{
						"entry":[
							{
								"name":"String",
								"text":"String"
							},
							{
								"name":"String",
								"text":"String"
							}
						]
					},
					"chassis":{
						"entry":[
							{
								"name":"String",
								"text":"String"
							},
							{
								"name":"String",
								"text":"String"
							}
						]
					},
					"memory":[
						{
							"entry":[
								{
									"name":"String",
									"text":"String"
								},
								{
									"name":"String",
									"text":"String"
								}
							]
						},
						{
							"entry":[
								{
									"name":"String",
									"text":"String"
								},
								{
									"name":"String",
									"text":"String"
								}
							]
						}
					],
					"oemStrings":{
						"entry":{
							"text":"String"
						}
					},
					"processor":[
						{
							"entry":[
								{
									"name":"String",
									"text":"String"
								},
								{
									"name":"String",
									"text":"String"
								}
							]
						},
						{
							"entry":[
								{
									"name":"String",
									"text":"String"
								},
								{
									"name":"String",
									"text":"String"
								}
							]
						}
					],
					"system":{
						"entry":[
							{
								"name":"String",
								"text":"String"
							},
							{
								"name":"String",
								"text":"String"
							}
						]
					},
					"type":"String"
				},
				"title":{
					"text":"String"
				},
				"type":"String",
				"uuid":{
					"text":"String"
				},
				"vcpu":{
					"cpuset":"String",
					"current":"String",
					"placement":"String",
					"text":"String"
				},
				"vcpus":{
					"vcpu":[
						{
							"enabled":"String",
							"hotpluggable":"String",
							"id":"String",
							"order":"String"
						},
						{
							"enabled":"String",
							"hotpluggable":"String",
							"id":"String",
							"order":"String"
						}
					]
				}
			},
			"memory":{
				"file":"String",
				"snapshot":"String"
			},
			"name":{
				"text":"String"
			},
			"parent":{
				"name":{
					"text":"String"
				}
			},
			"state":{
				"text":"String"
			}
		},
		"lifecycle":{
			"createSnapshot":{
				"atomic":true,
				"description":"String",
				"disk_only":true,
				"diskspec":"String",
				"domain":"String",
				"halt":true,
				"live":true,
				"memspec":"String",
				"no_metadata":true,
				"quiesce":true,
				"reuse_external":true
			},
			"deleteSnapshot":{
				"children":true,
				"children_only":true,
				"domain":"String",
				"metadata":true
			},
			"revertVirtualMachine":{
				"domain":"String",
				"force":true,
				"paused":true,
				"running":true
			}
		},
		"versions":[]
	}
}
```
# 3 VirtualMachinePool

扩展支持各种存储后端.VirtualMachinePool所有操作的返回值一样，见**[返回值]**

## 3.1 AutoStart(开机启动存储池)

**接口功能:**
	开机启动存储池，否则开机该存储池会连接不上，导致不可用。适用libvirt指令创建存储池情况。只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存储池存在，即已调用过CreatePool

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachinepool.Lifecycle.AutoStart

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | autoStart.name.001|
| autoStart | AutoStart | true | 开机启动存储池 | 详细见下 |
| eventId | String | fasle | 事件ID | autoStart.event.001 |

对象autoStart参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| disable|Boolean|true|修改存储池autostart状态|true|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看AutoStartspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 3.2 CreatePool(创建存储池)

**接口功能:**
	创建存储池，适用libvirt指令创建存储池情况。只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachinepool.Lifecycle.CreatePool

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | createPool.name.001|
| nodeName | String | false | 选择部署的物理机，可以通过kubernetes.nodes().list进行查询 | node22 |
| createPool | CreatePool | true | 创建存储池 | 详细见下 |
| eventId | String | fasle | 事件ID | createPool.event.001 |

对象createPool参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| type|String|true|存储池的类型|dir|
| target|String|true|创建存储池使用的存储路径|/var/lib/libvirt/poolg|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看CreatePoolspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 3.3 StartPool(启动存储池)

**接口功能:**
	启动存储池，如果存储池处于Inactive状态，可以启动。适用libvirt指令创建存储池情况。只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存储池存在，即已调用过CreatePool

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachinepool.Lifecycle.StartPool

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | startPool.name.001|
| startPool | StartPool | true | 启动存储池 | 详细见下 |
| eventId | String | fasle | 事件ID | startPool.event.001 |

对象startPool参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看StartPoolspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 3.4 RegisterPool(注册存储池)

**接口功能:**
	注册存储池，将挂载的存储信息注册到Libvirt中，适用与采用外部存储池情况，与CreatePool等价只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存储池存在，即已调用过CreatePool

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachinepool.Lifecycle.RegisterPool

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | registerPool.name.001|
| registerPool | RegisterPool | true | 注册存储池 | 详细见下 |
| eventId | String | fasle | 事件ID | registerPool.event.001 |

对象registerPool参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看RegisterPoolspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 3.5 StopPool(停止存储池)

**接口功能:**
	停止存储池，将存储池状态设置为Inactive，适用libvirt指令创建存储池情况。只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存储池存在，即已调用过CreatePool

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachinepool.Lifecycle.StopPool

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | stopPool.name.001|
| stopPool | StopPool | true | 停止存储池 | 详细见下 |
| eventId | String | fasle | 事件ID | stopPool.event.001 |

对象stopPool参数说明:

## 3.6 DeletePool(删除存储池)

**接口功能:**
	删除存储池，适用libvirt指令创建存储池情况。只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存储池存在，即已调用过CreatePool

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachinepool.Lifecycle.DeletePool

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | deletePool.name.001|
| deletePool | DeletePool | true | 删除存储池 | 详细见下 |
| eventId | String | fasle | 事件ID | deletePool.event.001 |

对象deletePool参数说明:

## 3.7 UnregisterPool(反注册存储池)

**接口功能:**
	反注册存储池，将存储池信息从libvirt里面注销只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机存储池存在，即已调用过CreatePool

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachinepool.Lifecycle.UnregisterPool

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | unregisterPool.name.001|
| unregisterPool | UnregisterPool | true | 反注册存储池 | 详细见下 |
| eventId | String | fasle | 事件ID | unregisterPool.event.001 |

对象unregisterPool参数说明:

## **返回值:**

```
{
	"kind":"VirtualMachinePool",
	"metadata":{
		"additionalProperties":{},
		"finalizers":[],
		"ownerReferences":[]
	},
	"spec":{
		"additionalPrinterColumns":[],
		"additionalProperties":{},
		"lifecycle":{
			"autoStart":{
				"disable":true
			},
			"createPool":{
				"adapter_name":"String",
				"adapter_parent":"String",
				"adapter_parent_fabric_wwn":"String",
				"adapter_parent_wwnn":"String",
				"adapter_parent_wwpn":"String",
				"adapter_wwnn":"String",
				"adapter_wwpn":"String",
				"auth_type":"String",
				"auth_username":"String",
				"build":true,
				"no_overwrite":true,
				"overwrite":true,
				"secret_usage":"String",
				"secret_uuid":"String",
				"source_dev":"String",
				"source_format":"String",
				"source_host":"String",
				"source_name":"String",
				"source_path":"String",
				"target":"String",
				"type":"String"
			},
			"deletePool":{},
			"registerPool":{
				"adapter_name":"String",
				"adapter_parent":"String",
				"adapter_parent_fabric_wwn":"String",
				"adapter_parent_wwnn":"String",
				"adapter_parent_wwpn":"String",
				"adapter_wwnn":"String",
				"adapter_wwpn":"String",
				"auth_type":"String",
				"auth_username":"String",
				"secret_usage":"String",
				"secret_uuid":"String",
				"source_dev":"String",
				"source_format":"String",
				"source_host":"String",
				"source_name":"String",
				"source_path":"String",
				"target":"String",
				"type":"String"
			},
			"startPool":{
				"build":true,
				"no_overwrite":true,
				"overwrite":true
			},
			"stopPool":{},
			"unregisterPool":{}
		},
		"pool":{
			"autostart":"String",
			"capacity":"String",
			"name":"String",
			"path":"String",
			"persistent":"String",
			"state":"String",
			"type":"String",
			"uuid":"String"
		},
		"versions":[]
	}
}
```
# 4 VirtualMachineNetwork

扩展支持OVN插件.VirtualMachineNetwork所有操作的返回值一样，见**[返回值]**

## 4.1 CreateSwitch(创建网络交换机)

**接口功能:**
	创建网络交换机，只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachinenetwork.Lifecycle.CreateSwitch

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | createSwitch.name.001|
| nodeName | String | false | 选择部署的物理机，可以通过kubernetes.nodes().list进行查询 | node22 |
| createSwitch | CreateSwitch | true | 创建网络交换机 | 详细见下 |
| eventId | String | fasle | 事件ID | createSwitch.event.001 |

对象createSwitch参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| subnet|String|true|网段，这里后台只会做形式，不会做逻辑判断，只要符合xx.xx.xx.xx/x形式即可，请确保传入正确的数值|192.168.5.1/24|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看CreateSwitchspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 4.2 DeleteSwitch(删除网络交换机)

**接口功能:**
	删除网络交换机，只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机网络存在，即已调用过CreateSwitch

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachinenetwork.Lifecycle.DeleteSwitch

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | deleteSwitch.name.001|
| deleteSwitch | DeleteSwitch | true | 删除网络交换机 | 详细见下 |
| eventId | String | fasle | 事件ID | deleteSwitch.event.001 |

对象deleteSwitch参数说明:

## **返回值:**

```
{
	"kind":"VirtualMachineNetwork",
	"metadata":{
		"additionalProperties":{},
		"finalizers":[],
		"ownerReferences":[]
	},
	"spec":{
		"additionalPrinterColumns":[],
		"additionalProperties":{},
		"data":{
			"gatewayInfo":{
				"id":"String",
				"lease_time":"String",
				"router":"String",
				"server_id":"String",
				"server_mac":"String"
			},
			"routerInfo":{
				"id":"String",
				"name":"String",
				"nat":[
					{
						"externalIP":"String",
						"gateway":"String",
						"logicalIP":"String",
						"name":"String",
						"type":"String"
					},
					{
						"externalIP":"String",
						"gateway":"String",
						"logicalIP":"String",
						"name":"String",
						"type":"String"
					}
				],
				"port":[
					{
						"gateway":"String",
						"mac":"String",
						"name":"String",
						"networks":"String"
					},
					{
						"gateway":"String",
						"mac":"String",
						"name":"String",
						"networks":"String"
					}
				]
			},
			"switchInfo":{
				"id":"String",
				"name":"String",
				"port":[
					{
						"addresses":"String",
						"name":"String",
						"router_port":"String",
						"type":"String"
					},
					{
						"addresses":"String",
						"name":"String",
						"router_port":"String",
						"type":"String"
					}
				]
			}
		},
		"lifecycle":{
			"createSwitch":{
				"subnet":"String"
			},
			"deleteSwitch":{}
		},
		"type":"String",
		"versions":[]
	}
}
```
# 5 VirtualMachineImage

虚拟机模板，包括CPU、内存、OS等信息.VirtualMachineImage所有操作的返回值一样，见**[返回值]**

## 5.1 CreateImage(创建虚拟机镜像)

**接口功能:**
	创建虚拟机镜像，只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachineimage.Lifecycle.CreateImage

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | createImage.name.001|
| nodeName | String | false | 选择部署的物理机，可以通过kubernetes.nodes().list进行查询 | node22 |
| createImage | CreateImage | true | 创建虚拟机镜像 | 详细见下 |
| eventId | String | fasle | 事件ID | createImage.event.001 |

对象createImage参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| disk|String|true|用于创建虚拟机镜像的源文件|/var/lib/aaa.qcow2|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看CreateImagespec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 5.2 DeleteImage(删除虚拟机镜像)

**接口功能:**
	删除虚拟机镜像，只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机镜像存在，即已调用过CreateImage/ConvertVMToImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachineimage.Lifecycle.DeleteImage

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | deleteImage.name.001|
| deleteImage | DeleteImage | true | 删除虚拟机镜像 | 详细见下 |
| eventId | String | fasle | 事件ID | deleteImage.event.001 |

对象deleteImage参数说明:

## 5.3 ConvertImageToVM(将虚拟机镜像转化为虚拟机)

**接口功能:**
	将虚拟机镜像转化为虚拟机，只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机镜像存在，即已调用过CreateImage/ConvertVMToImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachineimage.Lifecycle.ConvertImageToVM

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | convertImageToVM.name.001|
| convertImageToVM | ConvertImageToVM | true | 将虚拟机镜像转化为虚拟机 | 详细见下 |
| eventId | String | fasle | 事件ID | convertImageToVM.event.001 |

对象convertImageToVM参数说明:

## **返回值:**

```
{
	"kind":"VirtualMachineImage",
	"metadata":{
		"additionalProperties":{},
		"finalizers":[],
		"ownerReferences":[]
	},
	"spec":{
		"additionalPrinterColumns":[],
		"additionalProperties":{},
		"domain":{
			"blkiotune":{
				"device":[
					{
						"path":{
							"text":"String"
						},
						"read_bytes_sec":{
							"text":"String"
						},
						"read_iops_sec":{
							"text":"String"
						},
						"weight":{
							"text":"String"
						},
						"write_bytes_sec":{
							"text":"String"
						},
						"write_iops_sec":{
							"text":"String"
						}
					},
					{
						"path":{
							"text":"String"
						},
						"read_bytes_sec":{
							"text":"String"
						},
						"read_iops_sec":{
							"text":"String"
						},
						"weight":{
							"text":"String"
						},
						"write_bytes_sec":{
							"text":"String"
						},
						"write_iops_sec":{
							"text":"String"
						}
					}
				],
				"weight":{
					"text":"String"
				}
			},
			"bootloader":{
				"text":"String"
			},
			"bootloader_args":{
				"text":"String"
			},
			"clock":{
				"adjustment":"String",
				"basis":"String",
				"offset":"String",
				"timer":[
					{
						"catchup":{
							"limit":"String",
							"slew":"String",
							"threshold":"String"
						},
						"frequency":"String",
						"mode":"String",
						"name":"String",
						"present":"String",
						"tickpolicy":"String",
						"track":"String"
					},
					{
						"catchup":{
							"limit":"String",
							"slew":"String",
							"threshold":"String"
						},
						"frequency":"String",
						"mode":"String",
						"name":"String",
						"present":"String",
						"tickpolicy":"String",
						"track":"String"
					}
				],
				"timezone":"String"
			},
			"cpu":{
				"cache":{
					"level":"String",
					"mode":"String"
				},
				"check":"String",
				"feature":[
					{
						"name":"String",
						"policy":"String"
					},
					{
						"name":"String",
						"policy":"String"
					}
				],
				"match":"String",
				"mode":"String",
				"model":{
					"fallback":"String",
					"text":"String",
					"vendor_id":"String"
				},
				"numa":{
					"cell":[
						{
							"cpus":"String",
							"discard":"String",
							"distances":{
								"sibling":[
									{
										"id":"String",
										"value":"String"
									},
									{
										"id":"String",
										"value":"String"
									}
								]
							},
							"id":"String",
							"memAccess":"String",
							"memory":"String",
							"unit":"String"
						},
						{
							"cpus":"String",
							"discard":"String",
							"distances":{
								"sibling":[
									{
										"id":"String",
										"value":"String"
									},
									{
										"id":"String",
										"value":"String"
									}
								]
							},
							"id":"String",
							"memAccess":"String",
							"memory":"String",
							"unit":"String"
						}
					]
				},
				"topology":{
					"cores":"String",
					"sockets":"String",
					"threads":"String"
				},
				"vendor":{
					"text":"String"
				}
			},
			"cputune":{
				"cachetune":[
					{
						"cache":[
							{
								"id":"String",
								"level":"String",
								"size":"String",
								"type":"String",
								"unit":"String"
							},
							{
								"id":"String",
								"level":"String",
								"size":"String",
								"type":"String",
								"unit":"String"
							}
						],
						"monitor":[
							{
								"level":"String",
								"vcpus":"String"
							},
							{
								"level":"String",
								"vcpus":"String"
							}
						],
						"vcpus":"String"
					},
					{
						"cache":[
							{
								"id":"String",
								"level":"String",
								"size":"String",
								"type":"String",
								"unit":"String"
							},
							{
								"id":"String",
								"level":"String",
								"size":"String",
								"type":"String",
								"unit":"String"
							}
						],
						"monitor":[
							{
								"level":"String",
								"vcpus":"String"
							},
							{
								"level":"String",
								"vcpus":"String"
							}
						],
						"vcpus":"String"
					}
				],
				"emulator_period":{
					"text":"String"
				},
				"emulator_quota":{
					"text":"String"
				},
				"emulatorpin":{
					"cpuset":"String"
				},
				"global_period":{
					"text":"String"
				},
				"global_quota":{
					"text":"String"
				},
				"iothread_period":{
					"text":"String"
				},
				"iothread_quota":{
					"text":"String"
				},
				"iothreadpin":[
					{
						"cpuset":"String",
						"iothread":"String"
					},
					{
						"cpuset":"String",
						"iothread":"String"
					}
				],
				"iothreadsched":[
					{
						"iothreads":"String",
						"priority":"String",
						"scheduler":"String"
					},
					{
						"iothreads":"String",
						"priority":"String",
						"scheduler":"String"
					}
				],
				"memorytune":[
					{
						"node":[
							{
								"bandwidth":"String",
								"id":"String"
							},
							{
								"bandwidth":"String",
								"id":"String"
							}
						],
						"vcpus":"String"
					},
					{
						"node":[
							{
								"bandwidth":"String",
								"id":"String"
							},
							{
								"bandwidth":"String",
								"id":"String"
							}
						],
						"vcpus":"String"
					}
				],
				"period":{
					"text":"String"
				},
				"quota":{
					"text":"String"
				},
				"shares":{
					"text":"String"
				},
				"vcpupin":[
					{
						"cpuset":"String",
						"vcpu":"String"
					},
					{
						"cpuset":"String",
						"vcpu":"String"
					}
				],
				"vcpusched":[
					{
						"priority":"String",
						"scheduler":"String",
						"vcpus":"String"
					},
					{
						"priority":"String",
						"scheduler":"String",
						"vcpus":"String"
					}
				]
			},
			"currentMemory":{
				"text":"String",
				"unit":"String"
			},
			"description":{
				"text":"String"
			},
			"devices":{
				"channel":[
					{
						"address":{
							"bus":"String",
							"controller":"String",
							"port":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"log":{
							"append":"String",
							"file":"String"
						},
						"protocol":{
							"type":"String"
						},
						"source":{
							"mode":"String",
							"path":"String"
						},
						"target":{
							"name":"String",
							"state":"String",
							"type":"String"
						},
						"type":"String"
					},
					{
						"address":{
							"bus":"String",
							"controller":"String",
							"port":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"log":{
							"append":"String",
							"file":"String"
						},
						"protocol":{
							"type":"String"
						},
						"source":{
							"mode":"String",
							"path":"String"
						},
						"target":{
							"name":"String",
							"state":"String",
							"type":"String"
						},
						"type":"String"
					}
				],
				"console":[
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"log":{
							"append":"String",
							"file":"String"
						},
						"protocol":{
							"type":"String"
						},
						"source":{
							"path":"String"
						},
						"target":{
							"port":"String",
							"type":"String"
						},
						"tty":"String",
						"type":"String"
					},
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"log":{
							"append":"String",
							"file":"String"
						},
						"protocol":{
							"type":"String"
						},
						"source":{
							"path":"String"
						},
						"target":{
							"port":"String",
							"type":"String"
						},
						"tty":"String",
						"type":"String"
					}
				],
				"controller":[
					{
						"address":{
							"bus":"String",
							"domain":"String",
							"function":"String",
							"multifunction":"String",
							"slot":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"driver":{
							"ats":"String",
							"cmd_per_lun":"String",
							"ioeventfd":"String",
							"iommu":"String",
							"iothread":"String",
							"max_sectors":"String",
							"queues":"String"
						},
						"index":"String",
						"master":{
							"startport":"String"
						},
						"model":"String",
						"type":"String"
					},
					{
						"address":{
							"bus":"String",
							"domain":"String",
							"function":"String",
							"multifunction":"String",
							"slot":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"driver":{
							"ats":"String",
							"cmd_per_lun":"String",
							"ioeventfd":"String",
							"iommu":"String",
							"iothread":"String",
							"max_sectors":"String",
							"queues":"String"
						},
						"index":"String",
						"master":{
							"startport":"String"
						},
						"model":"String",
						"type":"String"
					}
				],
				"disk":[
					{
						"address":{
							"bus":"String",
							"controller":"String",
							"domain":"String",
							"function":"String",
							"slot":"String",
							"target":"String",
							"type":"String",
							"unit":"String"
						},
						"alias":{
							"name":"String"
						},
						"auth":{
							"secret":{
								"type":"String",
								"usage":"String",
								"uuid":"String"
							},
							"username":"String"
						},
						"backingStore":{
							"format":{
								"type":"String"
							},
							"index":"String",
							"source":{
								"encryption":{
									"format":"String",
									"secret":{
										"type":"String",
										"usage":"String",
										"uuid":"String"
									}
								},
								"index":"String",
								"reservations":{
									"enabled":"String",
									"managed":"String",
									"source":{
										"dev":"String",
										"mode":"String",
										"path":"String",
										"type":"String"
									}
								},
								"startupPolicy":"String"
							}
						},
						"blockio":{
							"logical_block_size":"String",
							"physical_block_size":"String"
						},
						"boot":{
							"loadparm":"String",
							"order":"String"
						},
						"device":"String",
						"driver":{
							"ats":"String",
							"cache":"String",
							"copy_on_read":"String",
							"detect_zeroes":"String",
							"discard":"String",
							"error_policy":"String",
							"event_idx":"String",
							"io":"String",
							"ioeventfd":"String",
							"iommu":"String",
							"iothread":"String",
							"name":"String",
							"queues":"String",
							"rerror_policy":"String",
							"type":"String"
						},
						"encryption":{
							"format":"String",
							"secret":{
								"type":"String",
								"usage":"String",
								"uuid":"String"
							}
						},
						"geometry":{
							"cyls":"String",
							"heads":"String",
							"secs":"String",
							"trans":"String"
						},
						"iotune":{
							"group_name":{
								"text":"String"
							},
							"read_bytes_sec":{
								"text":"String"
							},
							"read_bytes_sec_max":{
								"text":"String"
							},
							"read_bytes_sec_max_length":{
								"text":"String"
							},
							"read_iops_sec":{
								"text":"String"
							},
							"read_iops_sec_max":{
								"text":"String"
							},
							"read_iops_sec_max_length":{
								"text":"String"
							},
							"size_iops_sec":{
								"text":"String"
							},
							"total_bytes_sec":{
								"text":"String"
							},
							"total_bytes_sec_max":{
								"text":"String"
							},
							"total_bytes_sec_max_length":{
								"text":"String"
							},
							"total_iops_sec":{
								"text":"String"
							},
							"total_iops_sec_max":{
								"text":"String"
							},
							"total_iops_sec_max_length":{
								"text":"String"
							},
							"write_bytes_sec":{
								"text":"String"
							},
							"write_bytes_sec_max":{
								"text":"String"
							},
							"write_bytes_sec_max_length":{
								"text":"String"
							},
							"write_iops_sec":{
								"text":"String"
							},
							"write_iops_sec_max":{
								"text":"String"
							},
							"write_iops_sec_max_length":{
								"text":"String"
							}
						},
						"mirror":{
							"format":{
								"type":"String"
							},
							"job":"String",
							"ready":"String",
							"source":{
								"encryption":{
									"format":"String",
									"secret":{
										"type":"String",
										"usage":"String",
										"uuid":"String"
									}
								},
								"index":"String",
								"reservations":{
									"enabled":"String",
									"managed":"String",
									"source":{
										"dev":"String",
										"mode":"String",
										"path":"String",
										"type":"String"
									}
								},
								"startupPolicy":"String"
							}
						},
						"model":"String",
						"product":{
							"text":"String"
						},
						"rawio":"String",
						"readonly":{},
						"serial":{
							"text":"String",
							"type":"String"
						},
						"sgio":"String",
						"shareable":{},
						"snapshot":"String",
						"source":{
							"controller":"String",
							"encryption":{
								"format":"String",
								"secret":{
									"type":"String",
									"usage":"String",
									"uuid":"String"
								}
							},
							"file":"String",
							"index":"String",
							"reservations":{
								"enabled":"String",
								"managed":"String",
								"source":{
									"dev":"String",
									"mode":"String",
									"path":"String",
									"type":"String"
								}
							},
							"startupPolicy":"String"
						},
						"target":{
							"bus":"String",
							"dev":"String",
							"removable":"String",
							"tray":"String"
						},
						"transient":{},
						"type":"String",
						"vendor":{
							"text":"String"
						},
						"wwn":{
							"text":"String"
						}
					},
					{
						"address":{
							"bus":"String",
							"controller":"String",
							"domain":"String",
							"function":"String",
							"slot":"String",
							"target":"String",
							"type":"String",
							"unit":"String"
						},
						"alias":{
							"name":"String"
						},
						"auth":{
							"secret":{
								"type":"String",
								"usage":"String",
								"uuid":"String"
							},
							"username":"String"
						},
						"backingStore":{
							"format":{
								"type":"String"
							},
							"index":"String",
							"source":{
								"encryption":{
									"format":"String",
									"secret":{
										"type":"String",
										"usage":"String",
										"uuid":"String"
									}
								},
								"index":"String",
								"reservations":{
									"enabled":"String",
									"managed":"String",
									"source":{
										"dev":"String",
										"mode":"String",
										"path":"String",
										"type":"String"
									}
								},
								"startupPolicy":"String"
							}
						},
						"blockio":{
							"logical_block_size":"String",
							"physical_block_size":"String"
						},
						"boot":{
							"loadparm":"String",
							"order":"String"
						},
						"device":"String",
						"driver":{
							"ats":"String",
							"cache":"String",
							"copy_on_read":"String",
							"detect_zeroes":"String",
							"discard":"String",
							"error_policy":"String",
							"event_idx":"String",
							"io":"String",
							"ioeventfd":"String",
							"iommu":"String",
							"iothread":"String",
							"name":"String",
							"queues":"String",
							"rerror_policy":"String",
							"type":"String"
						},
						"encryption":{
							"format":"String",
							"secret":{
								"type":"String",
								"usage":"String",
								"uuid":"String"
							}
						},
						"geometry":{
							"cyls":"String",
							"heads":"String",
							"secs":"String",
							"trans":"String"
						},
						"iotune":{
							"group_name":{
								"text":"String"
							},
							"read_bytes_sec":{
								"text":"String"
							},
							"read_bytes_sec_max":{
								"text":"String"
							},
							"read_bytes_sec_max_length":{
								"text":"String"
							},
							"read_iops_sec":{
								"text":"String"
							},
							"read_iops_sec_max":{
								"text":"String"
							},
							"read_iops_sec_max_length":{
								"text":"String"
							},
							"size_iops_sec":{
								"text":"String"
							},
							"total_bytes_sec":{
								"text":"String"
							},
							"total_bytes_sec_max":{
								"text":"String"
							},
							"total_bytes_sec_max_length":{
								"text":"String"
							},
							"total_iops_sec":{
								"text":"String"
							},
							"total_iops_sec_max":{
								"text":"String"
							},
							"total_iops_sec_max_length":{
								"text":"String"
							},
							"write_bytes_sec":{
								"text":"String"
							},
							"write_bytes_sec_max":{
								"text":"String"
							},
							"write_bytes_sec_max_length":{
								"text":"String"
							},
							"write_iops_sec":{
								"text":"String"
							},
							"write_iops_sec_max":{
								"text":"String"
							},
							"write_iops_sec_max_length":{
								"text":"String"
							}
						},
						"mirror":{
							"format":{
								"type":"String"
							},
							"job":"String",
							"ready":"String",
							"source":{
								"encryption":{
									"format":"String",
									"secret":{
										"type":"String",
										"usage":"String",
										"uuid":"String"
									}
								},
								"index":"String",
								"reservations":{
									"enabled":"String",
									"managed":"String",
									"source":{
										"dev":"String",
										"mode":"String",
										"path":"String",
										"type":"String"
									}
								},
								"startupPolicy":"String"
							}
						},
						"model":"String",
						"product":{
							"text":"String"
						},
						"rawio":"String",
						"readonly":{},
						"serial":{
							"text":"String",
							"type":"String"
						},
						"sgio":"String",
						"shareable":{},
						"snapshot":"String",
						"source":{
							"controller":"String",
							"encryption":{
								"format":"String",
								"secret":{
									"type":"String",
									"usage":"String",
									"uuid":"String"
								}
							},
							"file":"String",
							"index":"String",
							"reservations":{
								"enabled":"String",
								"managed":"String",
								"source":{
									"dev":"String",
									"mode":"String",
									"path":"String",
									"type":"String"
								}
							},
							"startupPolicy":"String"
						},
						"target":{
							"bus":"String",
							"dev":"String",
							"removable":"String",
							"tray":"String"
						},
						"transient":{},
						"type":"String",
						"vendor":{
							"text":"String"
						},
						"wwn":{
							"text":"String"
						}
					}
				],
				"emulator":{
					"text":"String"
				},
				"filesystem":[
					{
						"accessmode":"String",
						"address":{},
						"alias":{
							"name":"String"
						},
						"driver":{
							"ats":"String",
							"format":"String",
							"iommu":"String",
							"name":"String",
							"type":"String",
							"wrpolicy":"String"
						},
						"model":"String",
						"readonly":{},
						"source":{},
						"space_hard_limit":{
							"text":"String",
							"unit":"String"
						},
						"space_soft_limit":{
							"text":"String",
							"unit":"String"
						},
						"target":{
							"dir":"String"
						}
					},
					{
						"accessmode":"String",
						"address":{},
						"alias":{
							"name":"String"
						},
						"driver":{
							"ats":"String",
							"format":"String",
							"iommu":"String",
							"name":"String",
							"type":"String",
							"wrpolicy":"String"
						},
						"model":"String",
						"readonly":{},
						"source":{},
						"space_hard_limit":{
							"text":"String",
							"unit":"String"
						},
						"space_soft_limit":{
							"text":"String",
							"unit":"String"
						},
						"target":{
							"dir":"String"
						}
					}
				],
				"graphics":[
					{
						"autoport":"String",
						"listen":{
							"address":"String",
							"type":"String"
						},
						"port":"String",
						"type":"String"
					},
					{
						"autoport":"String",
						"listen":{
							"address":"String",
							"type":"String"
						},
						"port":"String",
						"type":"String"
					}
				],
				"hostdev":[
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"boot":{
							"loadparm":"String",
							"order":"String"
						},
						"managed":"String",
						"rom":{
							"bar":"String",
							"enabled":"String",
							"file":"String"
						}
					},
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"boot":{
							"loadparm":"String",
							"order":"String"
						},
						"managed":"String",
						"rom":{
							"bar":"String",
							"enabled":"String",
							"file":"String"
						}
					}
				],
				"hub":[
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"type":"String"
					},
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"type":"String"
					}
				],
				"input":[
					{
						"address":{
							"bus":"String",
							"port":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"bus":"String",
						"driver":{
							"ats":"String",
							"iommu":"String"
						},
						"model":"String",
						"source":{
							"evdev":"String"
						},
						"type":"String"
					},
					{
						"address":{
							"bus":"String",
							"port":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"bus":"String",
						"driver":{
							"ats":"String",
							"iommu":"String"
						},
						"model":"String",
						"source":{
							"evdev":"String"
						},
						"type":"String"
					}
				],
				"interface":[
					{
						"address":{
							"bus":"String",
							"domain":"String",
							"function":"String",
							"slot":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"backend":{
							"tap":"String",
							"vhost":"String"
						},
						"bandwidth":{
							"inbound":{
								"average":"String",
								"burst":"String",
								"floor":"String",
								"peak":"String"
							},
							"outbound":{
								"average":"String",
								"burst":"String",
								"floor":"String",
								"peak":"String"
							}
						},
						"boot":{
							"loadparm":"String",
							"order":"String"
						},
						"coalesce":{
							"rx":{
								"frames":{
									"max":"String"
								}
							}
						},
						"driver":{
							"ats":"String",
							"event_idx":"String",
							"guest":{
								"csum":"String",
								"ecn":"String",
								"tso4":"String",
								"tso6":"String",
								"ufo":"String"
							},
							"host":{
								"csum":"String",
								"ecn":"String",
								"gso":"String",
								"mrg_rxbuf":"String",
								"tso4":"String",
								"tso6":"String",
								"ufo":"String"
							},
							"ioeventfd":"String",
							"iommu":"String",
							"name":"String",
							"queues":"String",
							"rx_queue_size":"String",
							"tx_queue_size":"String",
							"txmode":"String"
						},
						"filterref":{
							"filter":"String",
							"parameter":[
								{
									"name":"String",
									"value":"String"
								},
								{
									"name":"String",
									"value":"String"
								}
							]
						},
						"guest":{
							"actual":"String",
							"dev":"String"
						},
						"ip":[
							{
								"address":"String",
								"family":"String",
								"peer":"String",
								"prefix":"String"
							},
							{
								"address":"String",
								"family":"String",
								"peer":"String",
								"prefix":"String"
							}
						],
						"link":{
							"state":"String"
						},
						"mac":{
							"address":"String"
						},
						"managed":"String",
						"model":{
							"type":"String"
						},
						"mtu":{
							"size":"String"
						},
						"rom":{
							"bar":"String",
							"enabled":"String",
							"file":"String"
						},
						"route":[
							{
								"address":"String",
								"family":"String",
								"gateway":"String",
								"metric":"String",
								"netmask":"String",
								"prefix":"String"
							},
							{
								"address":"String",
								"family":"String",
								"gateway":"String",
								"metric":"String",
								"netmask":"String",
								"prefix":"String"
							}
						],
						"script":{
							"path":"String"
						},
						"source":{
							"bridge":"String",
							"network":"String"
						},
						"target":{
							"dev":"String"
						},
						"trustGuestRxFilters":"String",
						"tune":{
							"sndbuf":{
								"text":"String"
							}
						},
						"type":"String",
						"virtualport":{
							"parameters":{
								"_interfaceid":"String"
							},
							"type":"String"
						},
						"vlan":{
							"tag":[
								{
									"id":"String",
									"nativeMode":"String"
								},
								{
									"id":"String",
									"nativeMode":"String"
								}
							],
							"trunk":"String"
						}
					},
					{
						"address":{
							"bus":"String",
							"domain":"String",
							"function":"String",
							"slot":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"backend":{
							"tap":"String",
							"vhost":"String"
						},
						"bandwidth":{
							"inbound":{
								"average":"String",
								"burst":"String",
								"floor":"String",
								"peak":"String"
							},
							"outbound":{
								"average":"String",
								"burst":"String",
								"floor":"String",
								"peak":"String"
							}
						},
						"boot":{
							"loadparm":"String",
							"order":"String"
						},
						"coalesce":{
							"rx":{
								"frames":{
									"max":"String"
								}
							}
						},
						"driver":{
							"ats":"String",
							"event_idx":"String",
							"guest":{
								"csum":"String",
								"ecn":"String",
								"tso4":"String",
								"tso6":"String",
								"ufo":"String"
							},
							"host":{
								"csum":"String",
								"ecn":"String",
								"gso":"String",
								"mrg_rxbuf":"String",
								"tso4":"String",
								"tso6":"String",
								"ufo":"String"
							},
							"ioeventfd":"String",
							"iommu":"String",
							"name":"String",
							"queues":"String",
							"rx_queue_size":"String",
							"tx_queue_size":"String",
							"txmode":"String"
						},
						"filterref":{
							"filter":"String",
							"parameter":[
								{
									"name":"String",
									"value":"String"
								},
								{
									"name":"String",
									"value":"String"
								}
							]
						},
						"guest":{
							"actual":"String",
							"dev":"String"
						},
						"ip":[
							{
								"address":"String",
								"family":"String",
								"peer":"String",
								"prefix":"String"
							},
							{
								"address":"String",
								"family":"String",
								"peer":"String",
								"prefix":"String"
							}
						],
						"link":{
							"state":"String"
						},
						"mac":{
							"address":"String"
						},
						"managed":"String",
						"model":{
							"type":"String"
						},
						"mtu":{
							"size":"String"
						},
						"rom":{
							"bar":"String",
							"enabled":"String",
							"file":"String"
						},
						"route":[
							{
								"address":"String",
								"family":"String",
								"gateway":"String",
								"metric":"String",
								"netmask":"String",
								"prefix":"String"
							},
							{
								"address":"String",
								"family":"String",
								"gateway":"String",
								"metric":"String",
								"netmask":"String",
								"prefix":"String"
							}
						],
						"script":{
							"path":"String"
						},
						"source":{
							"bridge":"String",
							"network":"String"
						},
						"target":{
							"dev":"String"
						},
						"trustGuestRxFilters":"String",
						"tune":{
							"sndbuf":{
								"text":"String"
							}
						},
						"type":"String",
						"virtualport":{
							"parameters":{
								"_interfaceid":"String"
							},
							"type":"String"
						},
						"vlan":{
							"tag":[
								{
									"id":"String",
									"nativeMode":"String"
								},
								{
									"id":"String",
									"nativeMode":"String"
								}
							],
							"trunk":"String"
						}
					}
				],
				"iommu":{
					"driver":{
						"caching_mode":"String",
						"eim":"String",
						"intremap":"String",
						"iotlb":"String"
					},
					"model":"String"
				},
				"lease":[
					{
						"key":{
							"text":"String"
						},
						"lockspace":{
							"text":"String"
						},
						"target":{
							"offset":"String",
							"path":"String"
						}
					},
					{
						"key":{
							"text":"String"
						},
						"lockspace":{
							"text":"String"
						},
						"target":{
							"offset":"String",
							"path":"String"
						}
					}
				],
				"memballoon":{
					"address":{
						"bus":"String",
						"domain":"String",
						"function":"String",
						"slot":"String",
						"type":"String"
					},
					"alias":{
						"name":"String"
					},
					"autodeflate":"String",
					"driver":{
						"ats":"String",
						"iommu":"String"
					},
					"model":"String",
					"stats":{
						"period":"String"
					}
				},
				"memory":[
					{
						"access":"String",
						"address":{},
						"alias":{
							"name":"String"
						},
						"discard":"String",
						"model":"String",
						"source":{
							"alignsize":{
								"text":"String",
								"unit":"String"
							},
							"nodemask":{
								"text":"String"
							},
							"pagesize":{
								"text":"String",
								"unit":"String"
							},
							"path":{
								"text":"String"
							},
							"pmem":{}
						},
						"target":{
							"label":{
								"size":{
									"text":"String",
									"unit":"String"
								}
							},
							"node":{
								"text":"String"
							},
							"readonly":{},
							"size":{
								"text":"String",
								"unit":"String"
							}
						}
					},
					{
						"access":"String",
						"address":{},
						"alias":{
							"name":"String"
						},
						"discard":"String",
						"model":"String",
						"source":{
							"alignsize":{
								"text":"String",
								"unit":"String"
							},
							"nodemask":{
								"text":"String"
							},
							"pagesize":{
								"text":"String",
								"unit":"String"
							},
							"path":{
								"text":"String"
							},
							"pmem":{}
						},
						"target":{
							"label":{
								"size":{
									"text":"String",
									"unit":"String"
								}
							},
							"node":{
								"text":"String"
							},
							"readonly":{},
							"size":{
								"text":"String",
								"unit":"String"
							}
						}
					}
				],
				"nvram":{
					"address":{},
					"alias":{
						"name":"String"
					}
				},
				"panic":[
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"model":"String"
					},
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"model":"String"
					}
				],
				"parallel":[
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"log":{
							"append":"String",
							"file":"String"
						},
						"protocol":{
							"type":"String"
						},
						"source":{},
						"target":{
							"port":"String",
							"type":"String"
						}
					},
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"log":{
							"append":"String",
							"file":"String"
						},
						"protocol":{
							"type":"String"
						},
						"source":{},
						"target":{
							"port":"String",
							"type":"String"
						}
					}
				],
				"redirdev":[
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"boot":{
							"loadparm":"String",
							"order":"String"
						},
						"bus":"String",
						"protocol":{
							"type":"String"
						},
						"source":{}
					},
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"boot":{
							"loadparm":"String",
							"order":"String"
						},
						"bus":"String",
						"protocol":{
							"type":"String"
						},
						"source":{}
					}
				],
				"redirfilter":[
					{
						"usbdev":[
							{
								"allow":"String",
								"class":"String",
								"product":"String",
								"vendor":"String",
								"version":"String"
							},
							{
								"allow":"String",
								"class":"String",
								"product":"String",
								"vendor":"String",
								"version":"String"
							}
						]
					},
					{
						"usbdev":[
							{
								"allow":"String",
								"class":"String",
								"product":"String",
								"vendor":"String",
								"version":"String"
							},
							{
								"allow":"String",
								"class":"String",
								"product":"String",
								"vendor":"String",
								"version":"String"
							}
						]
					}
				],
				"rng":[
					{
						"address":{
							"bus":"String",
							"domain":"String",
							"function":"String",
							"slot":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"backend":{
							"model":"String",
							"text":"String"
						},
						"driver":{
							"ats":"String",
							"iommu":"String"
						},
						"model":"String",
						"rate":{
							"bytes":"String",
							"period":"String"
						}
					},
					{
						"address":{
							"bus":"String",
							"domain":"String",
							"function":"String",
							"slot":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"backend":{
							"model":"String",
							"text":"String"
						},
						"driver":{
							"ats":"String",
							"iommu":"String"
						},
						"model":"String",
						"rate":{
							"bytes":"String",
							"period":"String"
						}
					}
				],
				"serial":[
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"log":{
							"append":"String",
							"file":"String"
						},
						"protocol":{
							"type":"String"
						},
						"source":{
							"path":"String"
						},
						"target":{
							"model":{
								"name":"String"
							},
							"port":"String",
							"type":"String"
						},
						"type":"String"
					},
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"log":{
							"append":"String",
							"file":"String"
						},
						"protocol":{
							"type":"String"
						},
						"source":{
							"path":"String"
						},
						"target":{
							"model":{
								"name":"String"
							},
							"port":"String",
							"type":"String"
						},
						"type":"String"
					}
				],
				"shmem":[
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"model":{
							"type":"String"
						},
						"msi":{
							"enabled":"String",
							"ioeventfd":"String",
							"vectors":"String"
						},
						"name":"String",
						"server":{
							"path":"String"
						},
						"size":{
							"text":"String",
							"unit":"String"
						}
					},
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"model":{
							"type":"String"
						},
						"msi":{
							"enabled":"String",
							"ioeventfd":"String",
							"vectors":"String"
						},
						"name":"String",
						"server":{
							"path":"String"
						},
						"size":{
							"text":"String",
							"unit":"String"
						}
					}
				],
				"smartcard":[
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"certificate":[
							{
								"text":"String"
							},
							{
								"text":"String"
							}
						],
						"database":{
							"text":"String"
						},
						"protocol":{
							"type":"String"
						},
						"source":{}
					},
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"certificate":[
							{
								"text":"String"
							},
							{
								"text":"String"
							}
						],
						"database":{
							"text":"String"
						},
						"protocol":{
							"type":"String"
						},
						"source":{}
					}
				],
				"sound":[
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"codec":[
							{
								"type":"String"
							},
							{
								"type":"String"
							}
						],
						"model":"String"
					},
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"codec":[
							{
								"type":"String"
							},
							{
								"type":"String"
							}
						],
						"model":"String"
					}
				],
				"tpm":[
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"backend":{},
						"model":"String"
					},
					{
						"address":{},
						"alias":{
							"name":"String"
						},
						"backend":{},
						"model":"String"
					}
				],
				"video":[
					{
						"address":{
							"bus":"String",
							"domain":"String",
							"function":"String",
							"slot":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"driver":{
							"ats":"String",
							"iommu":"String",
							"vgaconf":"String"
						},
						"model":{
							"acceleration":{
								"accel2d":"String",
								"accel3d":"String"
							},
							"heads":"String",
							"primary":"String",
							"ram":"String",
							"type":"String",
							"vgamem":"String",
							"vram":"String",
							"vram64":"String"
						}
					},
					{
						"address":{
							"bus":"String",
							"domain":"String",
							"function":"String",
							"slot":"String",
							"type":"String"
						},
						"alias":{
							"name":"String"
						},
						"driver":{
							"ats":"String",
							"iommu":"String",
							"vgaconf":"String"
						},
						"model":{
							"acceleration":{
								"accel2d":"String",
								"accel3d":"String"
							},
							"heads":"String",
							"primary":"String",
							"ram":"String",
							"type":"String",
							"vgamem":"String",
							"vram":"String",
							"vram64":"String"
						}
					}
				],
				"vsock":{
					"address":{},
					"alias":{
						"name":"String"
					},
					"cid":{
						"address":"String",
						"auto":"String"
					},
					"model":"String"
				},
				"watchdog":{
					"action":"String",
					"address":{},
					"alias":{
						"name":"String"
					},
					"model":"String"
				}
			},
			"features":{
				"acpi":{},
				"apic":{
					"eoi":"String"
				},
				"capabilities":{
					"audit_control":{
						"state":"String"
					},
					"audit_write":{
						"state":"String"
					},
					"block_suspend":{
						"state":"String"
					},
					"chown":{
						"state":"String"
					},
					"dac_override":{
						"state":"String"
					},
					"dac_read_Search":{
						"state":"String"
					},
					"fowner":{
						"state":"String"
					},
					"fsetid":{
						"state":"String"
					},
					"ipc_lock":{
						"state":"String"
					},
					"ipc_owner":{
						"state":"String"
					},
					"kill":{
						"state":"String"
					},
					"lease":{
						"state":"String"
					},
					"linux_immutable":{
						"state":"String"
					},
					"mac_admin":{
						"state":"String"
					},
					"mac_override":{
						"state":"String"
					},
					"mknod":{
						"state":"String"
					},
					"net_admin":{
						"state":"String"
					},
					"net_bind_service":{
						"state":"String"
					},
					"net_broadcast":{
						"state":"String"
					},
					"net_raw":{
						"state":"String"
					},
					"policy":"String",
					"setfcap":{
						"state":"String"
					},
					"setgid":{
						"state":"String"
					},
					"setpcap":{
						"state":"String"
					},
					"setuid":{
						"state":"String"
					},
					"sys_admin":{
						"state":"String"
					},
					"sys_boot":{
						"state":"String"
					},
					"sys_chroot":{
						"state":"String"
					},
					"sys_module":{
						"state":"String"
					},
					"sys_nice":{
						"state":"String"
					},
					"sys_pacct":{
						"state":"String"
					},
					"sys_ptrace":{
						"state":"String"
					},
					"sys_rawio":{
						"state":"String"
					},
					"sys_resource":{
						"state":"String"
					},
					"sys_time":{
						"state":"String"
					},
					"sys_tty_config":{
						"state":"String"
					},
					"syslog":{
						"state":"String"
					},
					"wake_alarm":{
						"state":"String"
					}
				},
				"gic":{
					"version":"String"
				},
				"hap":{
					"state":"String"
				},
				"hpt":{
					"maxpagesize":{
						"text":"String",
						"unit":"String"
					},
					"resizing":"String"
				},
				"htm":{
					"state":"String"
				},
				"hyperv":{
					"evmcs":{
						"state":"String"
					},
					"frequencies":{
						"state":"String"
					},
					"ipi":{
						"state":"String"
					},
					"reenlightenment":{
						"state":"String"
					},
					"relaxed":{
						"state":"String"
					},
					"reset":{
						"state":"String"
					},
					"runtime":{
						"state":"String"
					},
					"spinlocks":{
						"retries":"String",
						"state":"String"
					},
					"stimer":{
						"state":"String"
					},
					"synic":{
						"state":"String"
					},
					"tlbflush":{
						"state":"String"
					},
					"vapic":{
						"state":"String"
					},
					"vendor_id":{
						"value":"String"
					},
					"vpindex":{
						"state":"String"
					}
				},
				"ioapic":{
					"driver":"String"
				},
				"kvm":{
					"hidden":{
						"state":"String"
					}
				},
				"msrs":{
					"unknown":"String"
				},
				"nested_hv":{
					"state":"String"
				},
				"pae":{},
				"pmu":{
					"state":"String"
				},
				"privnet":{},
				"pvspinlock":{
					"state":"String"
				},
				"smm":{
					"state":"String",
					"tseg":{
						"text":"String",
						"unit":"String"
					}
				},
				"viridian":{},
				"vmcoreinfo":{
					"state":"String"
				},
				"vmport":{
					"state":"String"
				}
			},
			"genid":{
				"text":"String"
			},
			"id":"String",
			"idmap":{
				"gid":[
					{
						"count":"String",
						"start":"String",
						"target":"String"
					},
					{
						"count":"String",
						"start":"String",
						"target":"String"
					}
				],
				"uid":[
					{
						"count":"String",
						"start":"String",
						"target":"String"
					},
					{
						"count":"String",
						"start":"String",
						"target":"String"
					}
				]
			},
			"iothreadids":{
				"iothread":[
					{
						"id":"String"
					},
					{
						"id":"String"
					}
				]
			},
			"iothreads":{
				"text":"String"
			},
			"keywrap":{
				"cipher":[
					{
						"name":"String",
						"state":"String"
					},
					{
						"name":"String",
						"state":"String"
					}
				]
			},
			"launchSecurity":{},
			"maxMemory":{
				"slots":"String",
				"text":"String",
				"unit":"String"
			},
			"memory":{
				"dumpCore":"String",
				"text":"String",
				"unit":"String"
			},
			"memoryBacking":{
				"access":{
					"mode":"String"
				},
				"allocation":{
					"mode":"String"
				},
				"discard":{},
				"hugepages":{
					"page":[
						{
							"nodeset":"String",
							"size":"String",
							"unit":"String"
						},
						{
							"nodeset":"String",
							"size":"String",
							"unit":"String"
						}
					]
				},
				"locked":{},
				"nosharepages":{},
				"source":{
					"type":"String"
				}
			},
			"memtune":{
				"hard_limit":{
					"text":"String",
					"unit":"String"
				},
				"min_guarantee":{
					"text":"String",
					"unit":"String"
				},
				"soft_limit":{
					"text":"String",
					"unit":"String"
				},
				"swap_hard_limit":{
					"text":"String",
					"unit":"String"
				}
			},
			"metadata":{},
			"name":{
				"text":"String"
			},
			"numatune":{
				"memnode":[
					{
						"cellid":"String",
						"mode":"String",
						"nodeset":"String"
					},
					{
						"cellid":"String",
						"mode":"String",
						"nodeset":"String"
					}
				],
				"memory":{
					"mode":"String",
					"nodeset":"String",
					"placement":"String"
				}
			},
			"on_crash":{
				"text":"String"
			},
			"on_poweroff":{
				"text":"String"
			},
			"on_reboot":{
				"text":"String"
			},
			"os":{
				"acpi":{
					"table":[
						{
							"text":"String",
							"type":"String"
						},
						{
							"text":"String",
							"type":"String"
						}
					]
				},
				"bios":{
					"rebootTimeout":"String",
					"useserial":"String"
				},
				"boot":[
					{
						"dev":"String"
					},
					{
						"dev":"String"
					}
				],
				"bootmenu":{
					"enable":"String",
					"timeout":"String"
				},
				"cmdline":{
					"text":"String"
				},
				"dtb":{
					"text":"String"
				},
				"init":{
					"text":"String"
				},
				"initarg":{
					"text":"String"
				},
				"initdir":{
					"text":"String"
				},
				"initenv":[
					{
						"name":"String",
						"text":"String"
					},
					{
						"name":"String",
						"text":"String"
					}
				],
				"initgroup":{
					"text":"String"
				},
				"initrd":{
					"text":"String"
				},
				"inituser":{
					"text":"String"
				},
				"kernel":{
					"text":"String"
				},
				"loader":{
					"text":"String"
				},
				"nvram":{
					"text":"String"
				},
				"smbios":{
					"mode":"String"
				},
				"type":{
					"arch":"String",
					"machine":"String",
					"text":"String"
				}
			},
			"perf":{
				"event":[
					{
						"enabled":"String",
						"name":"String"
					},
					{
						"enabled":"String",
						"name":"String"
					}
				]
			},
			"pm":{
				"suspend_to_disk":{
					"enabled":"String"
				},
				"suspend_to_mem":{
					"enabled":"String"
				}
			},
			"resource":{
				"partition":{
					"text":"String"
				}
			},
			"seclabel":[
				{
					"baselabel":{
						"text":"String"
					},
					"imagelabel":{
						"text":"String"
					},
					"label":{
						"text":"String"
					},
					"model":"String",
					"relabel":"String",
					"type":"String"
				},
				{
					"baselabel":{
						"text":"String"
					},
					"imagelabel":{
						"text":"String"
					},
					"label":{
						"text":"String"
					},
					"model":"String",
					"relabel":"String",
					"type":"String"
				}
			],
			"sysinfo":{
				"baseBoard":[
					{
						"entry":[
							{
								"name":"String",
								"text":"String"
							},
							{
								"name":"String",
								"text":"String"
							}
						]
					},
					{
						"entry":[
							{
								"name":"String",
								"text":"String"
							},
							{
								"name":"String",
								"text":"String"
							}
						]
					}
				],
				"bios":{
					"entry":[
						{
							"name":"String",
							"text":"String"
						},
						{
							"name":"String",
							"text":"String"
						}
					]
				},
				"chassis":{
					"entry":[
						{
							"name":"String",
							"text":"String"
						},
						{
							"name":"String",
							"text":"String"
						}
					]
				},
				"memory":[
					{
						"entry":[
							{
								"name":"String",
								"text":"String"
							},
							{
								"name":"String",
								"text":"String"
							}
						]
					},
					{
						"entry":[
							{
								"name":"String",
								"text":"String"
							},
							{
								"name":"String",
								"text":"String"
							}
						]
					}
				],
				"oemStrings":{
					"entry":{
						"text":"String"
					}
				},
				"processor":[
					{
						"entry":[
							{
								"name":"String",
								"text":"String"
							},
							{
								"name":"String",
								"text":"String"
							}
						]
					},
					{
						"entry":[
							{
								"name":"String",
								"text":"String"
							},
							{
								"name":"String",
								"text":"String"
							}
						]
					}
				],
				"system":{
					"entry":[
						{
							"name":"String",
							"text":"String"
						},
						{
							"name":"String",
							"text":"String"
						}
					]
				},
				"type":"String"
			},
			"title":{
				"text":"String"
			},
			"type":"String",
			"uuid":{
				"text":"String"
			},
			"vcpu":{
				"cpuset":"String",
				"current":"String",
				"placement":"String",
				"text":"String"
			},
			"vcpus":{
				"vcpu":[
					{
						"enabled":"String",
						"hotpluggable":"String",
						"id":"String",
						"order":"String"
					},
					{
						"enabled":"String",
						"hotpluggable":"String",
						"id":"String",
						"order":"String"
					}
				]
			}
		},
		"lifecycle":{
			"convertImageToVM":{},
			"createImage":{
				"disk":"String"
			},
			"deleteImage":{}
		},
		"versions":[]
	}
}
```
# 6 VirtualMachineDisk

云盘是指未格式化的云盘.VirtualMachineDisk所有操作的返回值一样，见**[返回值]**

## 6.1 DeleteDisk(删除云盘)

**接口功能:**
	删除云盘，只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	云盘存在，即已调用过CreateDisk/CreateDiskFromDiskImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.DeleteDisk

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | deleteDisk.name.001|
| deleteDisk | DeleteDisk | true | 删除云盘 | 详细见下 |
| eventId | String | fasle | 事件ID | deleteDisk.event.001 |

对象deleteDisk参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| pool|String|true|云盘所在的存储池名|pool2|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看DeleteDiskspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 6.2 ResizeDisk(调整云盘大小)

**接口功能:**
	调整云盘大小，只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	云盘存在，即已调用过CreateDisk/CreateDiskFromDiskImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.ResizeDisk

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | resizeDisk.name.001|
| resizeDisk | ResizeDisk | true | 调整云盘大小 | 详细见下 |
| eventId | String | fasle | 事件ID | resizeDisk.event.001 |

对象resizeDisk参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| pool|String|true|云盘所在的存储池名|pool2|
| capacity|String|true|扩容后的云盘空间大小|10485760|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看ResizeDiskspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 6.3 CreateDisk(创建云盘)

**接口功能:**
	创建云盘，只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CreateDisk

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | createDisk.name.001|
| nodeName | String | false | 选择部署的物理机，可以通过kubernetes.nodes().list进行查询 | node22 |
| createDisk | CreateDisk | true | 创建云盘 | 详细见下 |
| eventId | String | fasle | 事件ID | createDisk.event.001 |

对象createDisk参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| format|String|true|云盘文件的类型|qcow2|
| pool|String|true|创建云盘使用的存储池名|pool2|
| capacity|String|true|云盘空间大小|10485760|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看CreateDiskspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 6.4 CreateDiskFromDiskImage(从镜像创建云盘)

**接口功能:**
	从镜像创建云盘，只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CreateDiskFromDiskImage

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | createDiskFromDiskImage.name.001|
| nodeName | String | false | 选择部署的物理机，可以通过kubernetes.nodes().list进行查询 | node22 |
| createDiskFromDiskImage | CreateDiskFromDiskImage | true | 从镜像创建云盘 | 详细见下 |
| eventId | String | fasle | 事件ID | createDiskFromDiskImage.event.001 |

对象createDiskFromDiskImage参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| pool|String|true|创建云盘所在的存储池名|pool2|
| image|String|true|云盘镜像名|pool2|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看CreateDiskFromDiskImagespec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 6.5 ConvertDiskToDiskImage(转化为云盘镜像)

**接口功能:**
	转化为云盘镜像，只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	云盘存在，即已调用过CreateDisk/CreateDiskFromDiskImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.ConvertDiskToDiskImage

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | convertDiskToDiskImage.name.001|
| convertDiskToDiskImage | ConvertDiskToDiskImage | true | 转化为云盘镜像 | 详细见下 |
| eventId | String | fasle | 事件ID | convertDiskToDiskImage.event.001 |

对象convertDiskToDiskImage参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| pool|String|true|云盘所在的存储池名|pool2|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看ConvertDiskToDiskImagespec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 6.6 CloneDisk(克隆云盘)

**接口功能:**
	克隆云盘，只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	云盘存在，即已调用过CreateDisk/CreateDiskFromDiskImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CloneDisk

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | cloneDisk.name.001|
| cloneDisk | CloneDisk | true | 克隆云盘 | 详细见下 |
| eventId | String | fasle | 事件ID | cloneDisk.event.001 |

对象cloneDisk参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| pool|String|true|云盘所在的存储池名|pool2|
| newname|String|true|新云盘的名字|newdisk|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看CloneDiskspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## **返回值:**

```
{
	"kind":"VirtualMachineDisk",
	"metadata":{
		"additionalProperties":{},
		"finalizers":[],
		"ownerReferences":[]
	},
	"spec":{
		"additionalPrinterColumns":[],
		"additionalProperties":{},
		"lifecycle":{
			"cloneDisk":{
				"newname":"String",
				"pool":"String",
				"prealloc_metadata":true,
				"reflink":true
			},
			"convertDiskToDiskImage":{
				"pool":"String"
			},
			"createDisk":{
				"allocation":"String",
				"backing_vol":"String",
				"backing_vol_format":"String",
				"capacity":"String",
				"format":"String",
				"pool":"String",
				"prealloc_metadata":true
			},
			"createDiskFromDiskImage":{
				"image":"String",
				"pool":"String"
			},
			"deleteDisk":{
				"delete_snapshots":true,
				"pool":"String"
			},
			"resizeDisk":{
				"allocate":true,
				"capacity":"String",
				"delta":true,
				"pool":"String",
				"shrink":true
			}
		},
		"versions":[],
		"volume":{
			"allocation":{
				"text":"String",
				"unit":"String"
			},
			"capacity":{
				"text":"String",
				"unit":"String"
			},
			"key":{
				"text":"String"
			},
			"name":{
				"text":"String"
			},
			"physical":{
				"text":"String",
				"unit":"String"
			},
			"source":{
				"auth":{
					"secret":{
						"usage":"String"
					},
					"type":"String",
					"username":"String"
				},
				"device":{
					"path":"String"
				},
				"host":{
					"name":"String"
				}
			},
			"target":{
				"compat":{
					"text":"String"
				},
				"features":{
					"lazy_refcounts":{}
				},
				"format":{
					"type":"String"
				},
				"path":{
					"text":"String"
				},
				"permissions":{
					"group":{
						"text":"String"
					},
					"mode":{
						"text":"String"
					},
					"owner":{
						"text":"String"
					}
				},
				"timestamps":{
					"atime":{
						"text":"String"
					},
					"ctime":{
						"text":"String"
					},
					"mtime":{
						"text":"String"
					}
				}
			},
			"type":"String"
		}
	}
}
```
# 7 VirtualMachineDiskImage

云盘模板，主要是指大小和文件格式等.VirtualMachineDiskImage所有操作的返回值一样，见**[返回值]**

## 7.1 ConvertDiskImageToDisk(将云盘镜像转化为云盘)

**接口功能:**
	将云盘镜像转化为云盘，只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	云盘镜像存在，即已调用过CreateDiskImage/ConvertDiskToDiskImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachinediskimage.Lifecycle.ConvertDiskImageToDisk

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | convertDiskImageToDisk.name.001|
| convertDiskImageToDisk | ConvertDiskImageToDisk | true | 将云盘镜像转化为云盘 | 详细见下 |
| eventId | String | fasle | 事件ID | convertDiskImageToDisk.event.001 |

对象convertDiskImageToDisk参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| pool|String|true|转化的云盘所属的存储池名|pool2|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看ConvertDiskImageToDiskspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 7.2 DeleteDiskImage(删除云盘镜像)

**接口功能:**
	删除云盘镜像，只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	云盘镜像存在，即已调用过CreateDiskImage/ConvertDiskToDiskImage

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachinediskimage.Lifecycle.DeleteDiskImage

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | deleteDiskImage.name.001|
| deleteDiskImage | DeleteDiskImage | true | 删除云盘镜像 | 详细见下 |
| eventId | String | fasle | 事件ID | deleteDiskImage.event.001 |

对象deleteDiskImage参数说明:

## 7.3 CreateDiskImage(创建云盘镜像)

**接口功能:**
	创建云盘镜像，只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachinediskimage.Lifecycle.CreateDiskImage

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | createDiskImage.name.001|
| nodeName | String | false | 选择部署的物理机，可以通过kubernetes.nodes().list进行查询 | node22 |
| createDiskImage | CreateDiskImage | true | 创建云盘镜像 | 详细见下 |
| eventId | String | fasle | 事件ID | createDiskImage.event.001 |

对象createDiskImage参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| source|String|true|要转化为云盘镜像的云盘所在的路径|/var/lib/libvirt/test.qcow2|

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看CreateDiskImagespec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## **返回值:**

```
{
	"kind":"VirtualMachineDiskImage",
	"metadata":{
		"additionalProperties":{},
		"finalizers":[],
		"ownerReferences":[]
	},
	"spec":{
		"additionalPrinterColumns":[],
		"additionalProperties":{},
		"lifecycle":{
			"convertDiskImageToDisk":{
				"pool":"String"
			},
			"createDiskImage":{
				"source":"String"
			},
			"deleteDiskImage":{}
		},
		"versions":[],
		"volume":{
			
		}
	}
}
```

