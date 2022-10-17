package io.github.kubestack;

import java.io.File;

import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.models.VirtualMachine;
import io.github.kubestack.client.api.models.VirtualMachineDisk;
import io.github.kubestack.client.api.models.VirtualMachineDiskImage;
import io.github.kubestack.client.api.models.VirtualMachineImage;
import io.github.kubestack.client.api.models.VirtualMachineNetwork;
import io.github.kubestack.client.api.models.VirtualMachinePool;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 *
 * @version 2.0.0
 * @since   2022/10/22
 *
 */
public class AbstractTest {

	// 1. ssh master 
	// 2. download /etc/kubernetes/admin.conf
	// 3. rename to .token
    public static KubeStackClient getClient() throws Exception {
        return new KubeStackClient(new File(".token"));
    }

    public static VirtualMachine getVMByName(String name) throws Exception {
        return getClient().virtualMachines().get(name);
    }


    public static VirtualMachineImage getVMImageByName(String name) throws Exception {
        return getClient().virtualMachineImages().get(name);
    }

    public static VirtualMachineDisk getVMDiskByName(String name) throws Exception {
        return getClient().virtualMachineDisks().get(name);
    }

    public static VirtualMachinePool getVMPoolByName(String name) throws Exception {
        return getClient().virtualMachinePools().get(name);
    }

    public static VirtualMachineDiskImage getVMDiskImageByName(String name) throws Exception {
        return getClient().virtualMachineDiskImages().get(name);
    }

    public static VirtualMachineNetwork getVMNetworkByName(String name) throws Exception {
        return getClient().virtualMachineNetworks().get(name);
    }
}
