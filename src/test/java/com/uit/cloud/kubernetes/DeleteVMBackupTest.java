package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle;

public class DeleteVMBackupTest {
    public static void main(String[] args) throws Exception {

        ExtendedKubernetesClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachines()
                .deleteVMBackup("vmbackuptest", "vm.node25", getDeleteVMBackup());
        System.out.println(successful);
    }

    public static Lifecycle.DeleteVMBackup getDeleteVMBackup() {
        Lifecycle.DeleteVMBackup deleteVMBackup = new Lifecycle.DeleteVMBackup();
        deleteVMBackup.setPool("3915282a12dd4c34a0ae565d3ba2da41");
        deleteVMBackup.setVersion("backup1");
        return deleteVMBackup;
    }
}
