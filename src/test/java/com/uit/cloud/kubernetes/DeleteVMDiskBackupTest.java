package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle;

public class DeleteVMDiskBackupTest {
    public static void main(String[] args) throws Exception {

        ExtendedKubernetesClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachineDisks()
                .deleteVMDiskBackup("vmbackupdisktest1", "vm.node25", getDeleteVMDiskBackup());
        System.out.println(successful);
    }

    public static Lifecycle.DeleteVMDiskBackup getDeleteVMDiskBackup() {
        Lifecycle.DeleteVMDiskBackup deleteVMBackup = new Lifecycle.DeleteVMDiskBackup();
        deleteVMBackup.setDomain("vmbackuptest");
        deleteVMBackup.setPool("3915282a12dd4c34a0ae565d3ba2da41");
        deleteVMBackup.setVersion("backup1");
        return deleteVMBackup;
    }
}
