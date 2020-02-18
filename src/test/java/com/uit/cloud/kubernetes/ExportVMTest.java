package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle;

public class ExportVMTest {
    public static void main(String[] args) throws Exception {

        ExtendedKubernetesClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachines()
                .exportVM("vm006migratedisk4", getExportVM());
        System.out.println(successful);
    }

    public static Lifecycle.ExportVM getExportVM() {
        Lifecycle.ExportVM exportVM = new Lifecycle.ExportVM();
        exportVM.setDomain("migratepoolnode22");
        exportVM.setPath("nfs");
        return exportVM;
    }
}
