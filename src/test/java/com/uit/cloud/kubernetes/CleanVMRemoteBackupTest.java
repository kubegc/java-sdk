package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle;

public class CleanVMRemoteBackupTest {
    public static void main(String[] args) throws Exception {

        ExtendedKubernetesClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachines()
                .cleanVMRemoteBackup("vmbackupdisktest1", "vm.node25", getCleanVMBackup());
        System.out.println(successful);
    }

    public static Lifecycle.CleanVMRemoteBackup getCleanVMBackup() {
        Lifecycle.CleanVMRemoteBackup cleanVMBackup = new Lifecycle.CleanVMRemoteBackup();
        cleanVMBackup.setPool("3915282a12dd4c34a0ae565d3ba2da41");
        cleanVMBackup.setVersion("backup2");
//        backupDisk.setRemote("172.16.1.214");
//        backupDisk.setPort("21");
//        backupDisk.setUsername("ftpuser");
//        backupDisk.setPassword("ftpuser");
        return cleanVMBackup;
    }
}
