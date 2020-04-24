package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle;

public class RestoreDiskTest {
    public static void main(String[] args) throws Exception {

        ExtendedKubernetesClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachineDisks()
                .restoreDisk("vmbackupdisktest1", "vm.node25", getBackupVM());
        System.out.println(successful);
    }

    public static Lifecycle.RestoreDisk getBackupVM() {
        Lifecycle.RestoreDisk restoreDisk = new Lifecycle.RestoreDisk();
        restoreDisk.setDomain("vmbackuptest");
        restoreDisk.setPool("3915282a12dd4c34a0ae565d3ba2da41");
        restoreDisk.setVersion("backup1");
//        restoreDisk.setRemote("172.16.1.214");
//        restoreDisk.setPort("21");
//        restoreDisk.setUsername("ftpuser");
//        restoreDisk.setPassword("ftpuser");
        return restoreDisk;
    }
}
