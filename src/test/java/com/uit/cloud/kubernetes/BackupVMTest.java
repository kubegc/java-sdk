package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle;

public class BackupVMTest {
    public static void main(String[] args) throws Exception {

        ExtendedKubernetesClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachines()
                .backupVM("cloudinitbackup4", "vm.node22", getBackupVM());
        System.out.println(successful);
    }

    public static Lifecycle.BackupVM getBackupVM() {
        Lifecycle.BackupVM backupVM = new Lifecycle.BackupVM();
        backupVM.setPool("migratepoolnodepool22");
        backupVM.setVersion("vmbackup2");
        backupVM.setAll(true);
        backupVM.setFull(true);
        backupVM.setRemote("133.133.135.30");
        backupVM.setPort("21");
        backupVM.setUsername("ftpuser");
        backupVM.setPassword("ftpuser");
        return backupVM;
    }
}
