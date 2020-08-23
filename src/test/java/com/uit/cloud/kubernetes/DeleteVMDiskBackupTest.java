package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle;

public class DeleteVMDiskBackupTest {
    public static void main(String[] args) throws Exception {

        ExtendedKubernetesClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachineDisks()
                .deleteVMDiskBackup("cloudinit", "vm.node22", getDeleteVMDiskBackup());
        System.out.println(successful);
    }

    public static Lifecycle.DeleteVMDiskBackup getDeleteVMDiskBackup() {
        Lifecycle.DeleteVMDiskBackup deleteVMBackup = new Lifecycle.DeleteVMDiskBackup();
        deleteVMBackup.setDomain("cloudinit");
        deleteVMBackup.setPool("migratepoolnodepool22");
        deleteVMBackup.setVersion("backup1");
        return deleteVMBackup;
    }
}
