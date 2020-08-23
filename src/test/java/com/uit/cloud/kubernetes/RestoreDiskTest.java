package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle;

public class RestoreDiskTest {
    public static void main(String[] args) throws Exception {

        ExtendedKubernetesClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachineDisks()
                .restoreDisk("cloudinit", "vm.node22", getBackupVM());
        System.out.println(successful);
    }

    public static Lifecycle.RestoreDisk getBackupVM() {
        Lifecycle.RestoreDisk restoreDisk = new Lifecycle.RestoreDisk();
        restoreDisk.setDomain("cloudinit");
        restoreDisk.setPool("migratepoolnodepool22");
        restoreDisk.setVersion("backup1");
//        restoreDisk.setNewname("cloudinitnew");
//        restoreDisk.setTarget("migratepoolnodepool22");
//        restoreDisk.setTargetDomain("cloudinit");
//        restoreDisk.setRemote("172.16.1.214");
//        restoreDisk.setPort("21");
//        restoreDisk.setUsername("ftpuser");
//        restoreDisk.setPassword("ftpuser");
        return restoreDisk;
    }
}
