package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle;

public class DeleteVMBackupTest {
    public static void main(String[] args) throws Exception {

        ExtendedKubernetesClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachines()
                .deleteVMBackup("cloudinit", "vm.node22", getDeleteVMBackup());
        System.out.println(successful);
    }

    public static Lifecycle.DeleteVMBackup getDeleteVMBackup() {
        Lifecycle.DeleteVMBackup deleteVMBackup = new Lifecycle.DeleteVMBackup();
        deleteVMBackup.setPool("migratepoolnodepool22");
        deleteVMBackup.setVersion("vmbackup2");
        return deleteVMBackup;
    }
}
