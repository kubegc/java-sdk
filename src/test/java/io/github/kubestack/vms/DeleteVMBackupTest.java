package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachinepool.Lifecycle;

public class DeleteVMBackupTest {
    public static void main(String[] args) throws Exception {

        KubeStackClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachinePools()
                .deleteVMBackup("migratepoolnodepool22", "vm.node22", getDeleteVMBackup());
        System.out.println(successful);
    }

    public static Lifecycle.DeleteVMBackup getDeleteVMBackup() {
        Lifecycle.DeleteVMBackup deleteVMBackup = new Lifecycle.DeleteVMBackup();
        deleteVMBackup.setDomain("cloudinitbackup4");
        deleteVMBackup.setPool("migratepoolnodepool22");
        deleteVMBackup.setVersion("vmbackup2");
        return deleteVMBackup;
    }
}
