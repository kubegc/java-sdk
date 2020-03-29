package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle;

public class BackupDiskTest {
    public static void main(String[] args) throws Exception {

        ExtendedKubernetesClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachineDisks()
                .backupDisk("vmbackuptestdisk1", "vm.node25", getBackupVM());
        System.out.println(successful);
    }

    public static Lifecycle.BackupDisk getBackupVM() {
        Lifecycle.BackupDisk backupDisk = new Lifecycle.BackupDisk();
        backupDisk.setDomain("vmbackuptest");
        backupDisk.setPool("61024b305b5c463b80bceee066077079");
        backupDisk.setVersion("backup2");
//        backupDisk.setRemote("172.16.1.214");
//        backupDisk.setPort("21");
//        backupDisk.setUsername("ftpuser");
//        backupDisk.setPassword("ftpuser");
        return backupDisk;
    }
}
