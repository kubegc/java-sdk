package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle;

public class CleanVMBackupTest {
    public static void main(String[] args) throws Exception {

        ExtendedKubernetesClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachines()
                .cleanVMBackup("cloudinit", "vm.node22", getCleanVMBackup());
        System.out.println(successful);
    }

    public static Lifecycle.CleanVMBackup getCleanVMBackup() {
        Lifecycle.CleanVMBackup cleanVMBackup = new Lifecycle.CleanVMBackup();
        cleanVMBackup.setPool("migratepoolnodepool22");
        cleanVMBackup.setVol("cloudinit");
        cleanVMBackup.setVersion("backup2");
        return cleanVMBackup;
    }
}
