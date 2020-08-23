package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle;

public class CleanVMRemoteBackupTest {
    public static void main(String[] args) throws Exception {

        ExtendedKubernetesClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachines()
                .cleanVMRemoteBackup("cloudinit", "vm.node22", getCleanVMBackup());
        System.out.println(successful);
    }

    public static Lifecycle.CleanVMRemoteBackup getCleanVMBackup() {
        Lifecycle.CleanVMRemoteBackup cleanVMBackup = new Lifecycle.CleanVMRemoteBackup();
        cleanVMBackup.setPool("migratepoolnodepool22");
        cleanVMBackup.setVol("cloudinit");
        cleanVMBackup.setVersion("backup2");
        cleanVMBackup.setRemote("133.133.135.30");
        cleanVMBackup.setPort("21");
        cleanVMBackup.setUsername("ftpuser");
        cleanVMBackup.setPassword("ftpuser");
        return cleanVMBackup;
    }
}
