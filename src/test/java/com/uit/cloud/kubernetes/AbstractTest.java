package com.uit.cloud.kubernetes;

/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */

import com.github.kubesys.kubernetes.KubeStackClient;
import com.github.kubesys.kubernetes.api.model.*;


import java.util.*;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 *
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class AbstractTest {

    public static KubeStackClient getClient() throws Exception {
        return new KubeStackClient("", "");
    }

    public static VirtualMachine getVMByName(String name) throws Exception {
        return getClient().virtualMachines().get(name);
    }

    public static VirtualMachineBackup getVMBByName(String name) throws Exception {
        return getClient().virtualMachineBackups().get(name);
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
