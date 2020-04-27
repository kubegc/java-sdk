package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle;

public class BackupVMTest {
    public static void main(String[] args) throws Exception {

        ExtendedKubernetesClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachines()
                .backupVM("vmbackuptest", "vm.node25", getBackupVM());
        System.out.println(successful);
    }

    public static Lifecycle.BackupVM getBackupVM() {
        Lifecycle.BackupVM backupVM = new Lifecycle.BackupVM();
        backupVM.setPool("3915282a12dd4c34a0ae565d3ba2da41");
        backupVM.setVersion("backup2");
//        backupVM.setAll(true);
//        backupVM.setRemote("172.16.1.214");
//        backupVM.setPort("21");
//        backupVM.setUsername("ftpuser");
//        backupVM.setPassword("ftpuser");
        return backupVM;
    }
}
