package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle;

public class RestoreVMTest {
    public static void main(String[] args) throws Exception {

        ExtendedKubernetesClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachines()
                .restoreVM("vmbackuptest", "vm.node25", getRestoreVM());
        System.out.println(successful);
    }

    public static Lifecycle.RestoreVM getRestoreVM() {
        Lifecycle.RestoreVM restoreVM = new Lifecycle.RestoreVM();
        restoreVM.setPool("61024b305b5c463b80bceee066077079");
        restoreVM.setVersion("backup1");
        restoreVM.setAll(false);
        return restoreVM;
    }
}
