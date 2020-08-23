package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle;

public class ScanVMBackupTest {
    public static void main(String[] args) throws Exception {

        ExtendedKubernetesClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachines()
                .scanVmBackup("cloudinit", "vm.node22", getCleanVMBackup());
        System.out.println(successful);
    }

    public static Lifecycle.ScanVMBackup getCleanVMBackup() {
        Lifecycle.ScanVMBackup scanVMBackup = new Lifecycle.ScanVMBackup();
        scanVMBackup.setPool("migratepoolnodepool22");
//        scanVMBackup.setVol("cloudinit");
        return scanVMBackup;
    }
}
