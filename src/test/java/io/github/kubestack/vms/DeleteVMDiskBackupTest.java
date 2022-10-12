package io.github.kubestack.vms;

import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.virtualmachinepool.Lifecycle;

public class DeleteVMDiskBackupTest {
    public static void main(String[] args) throws Exception {

        KubeStackClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachinePools()
                .deleteVMDiskBackup("migratepoolnodepool22", "vm.node22", getDeleteVMDiskBackup());
        System.out.println(successful);
    }

    public static Lifecycle.DeleteVMDiskBackup getDeleteVMDiskBackup() {
        Lifecycle.DeleteVMDiskBackup deleteVMBackup = new Lifecycle.DeleteVMDiskBackup();
        deleteVMBackup.setDomain("cloudinitbackup4");
        deleteVMBackup.setPool("migratepoolnodepool22");
        deleteVMBackup.setVersion("diskbackup1");
        return deleteVMBackup;
    }
}
