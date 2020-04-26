package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle;

public class PullRemoteBackupTest {
    public static void main(String[] args) throws Exception {

        ExtendedKubernetesClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachines()
                .pullRemoteBackup("vmbackuptest", "vm.node25", getPullRemoteBackup());
        System.out.println(successful);
    }

    public static Lifecycle.PullRemoteBackup getPullRemoteBackup() {
        Lifecycle.PullRemoteBackup pullRemoteBackup = new Lifecycle.PullRemoteBackup();
        pullRemoteBackup.setVol("vmbackupdisktest1");
        pullRemoteBackup.setPool("3915282a12dd4c34a0ae565d3ba2da41");
        pullRemoteBackup.setVersion("backup1");
        pullRemoteBackup.setRemote("172.16.1.214");
        pullRemoteBackup.setPort("21");
        pullRemoteBackup.setUsername("ftpuser");
        pullRemoteBackup.setPassword("ftpuser");
        return pullRemoteBackup;
    }
}
