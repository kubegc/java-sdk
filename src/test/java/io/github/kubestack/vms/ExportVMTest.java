package io.github.kubestack.vms;

import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.virtualmachine.Lifecycle;

public class ExportVMTest {
    public static void main(String[] args) throws Exception {

        KubeStackClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachines()
                .exportVM("vmbackuptest", "vm.node51", getExportVM());
        System.out.println(successful);
    }

    public static Lifecycle.ExportVM getExportVM() {
        Lifecycle.ExportVM exportVM = new Lifecycle.ExportVM();
        exportVM.setPath("/root/export");
        return exportVM;
    }
}
