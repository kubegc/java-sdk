package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.KubeStackClient;
import com.github.kubesys.kubernetes.api.specs.items.virtualmachine.Lifecycle;

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
