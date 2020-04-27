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
        restoreVM.setVersion("backup2");
        restoreVM.setAll(true);
        restoreVM.setTarget("233041549cb44e5a83eba623716f122f");
        restoreVM.setNewname("vmbackuptest2");
        return restoreVM;
    }
}
