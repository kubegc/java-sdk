# 1. kubestack-client
Java Client for [kubestack](https://github.com/kube-stack/java-sdk), which is a private project.

Note: kubeext-jdk is a heavy work in progress.

**Authors**
- wuheng@iscas.ac.cn
- wuyuewen@iscas.ac.cn
- zhujianxing21@otcaix.iscas.ac.cn


![avatar](docs/images/arch.png)

# 2. Introduce KubeStack 

## 2.1 KubeStack brief

**KubeStack** is a Kubernetes-based virtual machine management platform, which extends [Kubernetes](https://kubernetes.io/) by adding
additional virtualization resource types through
[Kubernetes's Custom Resource Definitions API](https://kubernetes.io/docs/tasks/access-kubernetes-api/custom-resources/custom-resource-definitions/). By using this mechanism, the Kubernetes API can be used to manage these `VM`
resources alongside all other resources Kubernetes provides: 

- VirtualMachine:          kubectl get vm
- VirtualMachinePool:      kubectl get vmp
- VirtualMachineDisk:      kubectl get vmd
- VirtualMachineImage:     kubectl get vmi
- VirtualMachineDiskImage: kubectl get vmdi
- VirtualMachineSnapshot:  kubectl get vmsn
- VirtualMachineNetwork:   kubectl get vmn

**Note:** KubeStack is a heavy work in progress.

# 3 roadmap

- 2.0.0: production-ready

