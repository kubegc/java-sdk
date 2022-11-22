package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachinepool.Lifecycle;

public class AA_VM_RestoreTest {
    public static void main(String[] args) throws Exception {

        KubeStackClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachinePools()
                .restoreDisk("migratepoolnodepool22", "vm.node22", getBackupVM());
        System.out.println(successful);
    }

    public static Lifecycle.RestoreDisk getBackupVM() {
        Lifecycle.RestoreDisk restoreDisk = new Lifecycle.RestoreDisk();
        restoreDisk.setDomain("crail");
        restoreDisk.setPool("migratepoolnodepool22");
        restoreDisk.setVol("crail");
        restoreDisk.setVersion("diskbackup1");
        restoreDisk.setNewname("vmbackupdisk1restore1");
        restoreDisk.setTarget("migratepoolnodepool22");
        restoreDisk.setTargetDomain("crail");
        return restoreDisk;
    }
}
