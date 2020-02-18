package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle;

public class BackupVMTest {
    public static void main(String[] args) throws Exception {

        ExtendedKubernetesClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachines()
                .backupVM("vmbackuptest", getBackupVM());
        System.out.println(successful);
    }

    public static Lifecycle.BackupVM getBackupVM() {
        Lifecycle.BackupVM backupVM = new Lifecycle.BackupVM();
        backupVM.setRemote("nfs");
        backupVM.setPort("vm006migratedisk2");
        backupVM.setUsername("qcow2");
        backupVM.setPassword("qcow2");
        return backupVM;
    }
}
