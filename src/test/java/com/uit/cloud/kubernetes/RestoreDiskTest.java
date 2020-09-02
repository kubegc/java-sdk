package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinepool.Lifecycle;

public class RestoreDiskTest {
    public static void main(String[] args) throws Exception {

        ExtendedKubernetesClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachinePools()
                .restoreDisk("migratepoolnodepool22", "vm.node22", getBackupVM());
        System.out.println(successful);
    }

    public static Lifecycle.RestoreDisk getBackupVM() {
        Lifecycle.RestoreDisk restoreDisk = new Lifecycle.RestoreDisk();
        restoreDisk.setDomain("cloudinitbackup4");
        restoreDisk.setPool("migratepoolnodepool22");
        restoreDisk.setVol("vmbackupdisk1");
        restoreDisk.setVersion("diskbackup1");
        restoreDisk.setNewname("vmbackupdisk1backup1");
        restoreDisk.setTarget("migratepoolnodepool22");
        restoreDisk.setTargetDomain("cloudinitbackup4");
        return restoreDisk;
    }
}
