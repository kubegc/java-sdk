package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachinepool.Lifecycle;

public class CleanVMBackupTest {
    public static void main(String[] args) throws Exception {

        KubeStackClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachinePools()
                .cleanVMBackup("migratepoolnodepool22", "vm.node22", getCleanVMBackup());
        System.out.println(successful);
    }

    public static Lifecycle.CleanVMBackup getCleanVMBackup() {
        Lifecycle.CleanVMBackup cleanVMBackup = new Lifecycle.CleanVMBackup();
        cleanVMBackup.setDomain("cloudinitbackup4");
        cleanVMBackup.setPool("migratepoolnodepool22");
//        cleanVMBackup.setVol("vmbackupdisk1");
        cleanVMBackup.setAll(true);
        return cleanVMBackup;
    }
}
