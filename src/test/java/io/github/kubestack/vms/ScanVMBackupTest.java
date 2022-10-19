package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachinepool.Lifecycle;

public class ScanVMBackupTest {
    public static void main(String[] args) throws Exception {

        KubeStackClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachinePools()
                .scanVmBackup("migratepoolnodepool22", "vm.node22", getCleanVMBackup());
        System.out.println(successful);
    }

    public static Lifecycle.ScanVMBackup getCleanVMBackup() {
        Lifecycle.ScanVMBackup scanVMBackup = new Lifecycle.ScanVMBackup();
        scanVMBackup.setDomain("cloudinitbackup5555");
        scanVMBackup.setPool("migratepoolnodepool22");
        scanVMBackup.setVol("e8c9b41664584253afa43592d5efeafb");
        return scanVMBackup;
    }
}
