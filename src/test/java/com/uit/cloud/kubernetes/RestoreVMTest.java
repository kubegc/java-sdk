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
        restoreVM.setPool("3915282a12dd4c34a0ae565d3ba2da41");
        restoreVM.setVersion("backup1");
        restoreVM.setAll(true);
        return restoreVM;
    }
}
