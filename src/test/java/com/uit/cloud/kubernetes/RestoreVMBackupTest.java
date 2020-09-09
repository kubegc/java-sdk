package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinepool.Lifecycle;

public class RestoreVMBackupTest {
    public static void main(String[] args) throws Exception {

        ExtendedKubernetesClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachinePools()
                .restoreVMBackup("migratepoolnodepool22", "vm.node22", getRestoreVM());
        System.out.println(successful);
    }

    public static Lifecycle.RestoreVMBackup getRestoreVM() {
        Lifecycle.RestoreVMBackup restoreVMBackup = new Lifecycle.RestoreVMBackup();
        restoreVMBackup.setDomain("cloudinitbackup4");
        restoreVMBackup.setPool("migratepoolnodepool22");
        restoreVMBackup.setVersion("vmbackup2");
//        restoreVMBackup.setAll(true);
        restoreVMBackup.setTarget("migratepoolnodepool22");
        restoreVMBackup.setNewname("cloudinitbackup7777");
        return restoreVMBackup;
    }
}
