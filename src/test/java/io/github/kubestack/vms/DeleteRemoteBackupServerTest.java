package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachinepool.Lifecycle;

public class DeleteRemoteBackupServerTest {
    public static void main(String[] args) throws Exception {

        KubeStackClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachinePools()
                .deleteRemoteBackupServer("migratenodepool22", "vm.node22", getDeleteRemoteBackupServer());
        System.out.println(successful);
    }

    public static Lifecycle.DeleteRemoteBackupServer getDeleteRemoteBackupServer() {
        Lifecycle.DeleteRemoteBackupServer deleteRemoteBackupServer = new Lifecycle.DeleteRemoteBackupServer();
        deleteRemoteBackupServer.setRemote("133.133.135.30");
        deleteRemoteBackupServer.setPort("21");
        deleteRemoteBackupServer.setUsername("ftpuser");
        deleteRemoteBackupServer.setPassword("ftpuser");
        return deleteRemoteBackupServer;
    }
}
