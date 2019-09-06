# 文档简介

	本文档用于说明基于Kubernetes的虚拟机生命周期如何管理, 项目地址：https://github.com/kubesys/kubeext-jdk.
	本文有两种通用的约束:
		(1)名称：只允许小写字母和、数字、中划线和圆点组合，8-32位
		(2)路径：必须是/xx/xx形式，且在/var/lib/libvirt目录下，xx允许小写字母、数字、中划线和点，18-1024位


# 1 VirtualMachineNetwork

扩展支持OVN插件.VirtualMachineNetwork所有操作的返回值一样，见**[返回值]**

## 1.1 CreateSwitch(创建网络交换机)

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
| subnet|String|true|网段，这里后台只会做形式，不会做逻辑判断，只要符合xx.xx.xx.xx/y形式即可，请确保传入正确的数值, y的取值必须是8,16,24之一|192.168.5.1/24|
|  |  |  |  |  |

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

## 1.2 DeleteSwitch(删除网络交换机)

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

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
|  |  |  |  |  |

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看DeleteSwitchspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 1.3 BindFip(绑定外网IP)

**接口功能:**
	适用于虚拟IP和浮动IP场景，只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机网络存在，即已调用过CreateSwitch

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachinenetwork.Lifecycle.BindFip

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | bindFip.name.001|
| bindFip | BindFip | true | 绑定外网IP | 详细见下 |
| eventId | String | fasle | 事件ID | bindFip.event.001 |

对象bindFip参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| vmmac|String|true|虚拟机mac地址|7e:0c:b0:ef:6a:04|
| fip|String|true|外网IP|192.168.5.2|
|  |  |  |  |  |

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看BindFipspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

## 1.4 UnbindFip(解绑定外网IP)

**接口功能:**
	适用于虚拟IP和浮动IP场景，只会返回True或者异常返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；如果提交到Kubernetes后执行错误，请查看[接口异常]

**接口依赖:**
	虚拟机网络存在，即已调用过CreateSwitch

**接口所属:**
	com.github.kubesys.kubernetes.api.model.virtualmachinenetwork.Lifecycle.UnbindFip

**参数描述:**

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| name | String | true | 资源名称 | unbindFip.name.001|
| unbindFip | UnbindFip | true | 解绑定外网IP | 详细见下 |
| eventId | String | fasle | 事件ID | unbindFip.event.001 |

对象unbindFip参数说明:

| name | type | required | description | exampe |
| ----- | ------ | ------ | ------ | ------ |
| vmmac|String|true|虚拟机mac地址|7e:0c:b0:ef:6a:04|
|  |  |  |  |  |

**接口异常:**

(1)在调用本方法抛出;

| name  | description | 
| ----- | ----- | 
| RuntimeException |  重名，或则资源(VirtualMachine, VirtualMachinePool等)不存在   |
| IllegalFormatException | 传递的参数不符合约束条件    |
| Exception    | 后台代码异常，比如未安装VM的Kubernets插件    |

(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况请查看UnbindFipspec下的status域，从message中获取详细异常信息

| name  | description | 
| ----- | ----- | 
| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |
| VirtctlError | Libvirt不支持的生命周期    |
| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |
| Exception    | 后台代码异常退出,比如主机的hostname变化    |

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
			"bindFip":{
				"fip":"String",
				"vmmac":"String"
			},
			"createSwitch":{
				"subnet":"String"
			},
			"deleteSwitch":{},
			"unbindFip":{
				"vmmac":"String"
			}
		},
		"type":"String",
		"versions":[]
	}
}
```

