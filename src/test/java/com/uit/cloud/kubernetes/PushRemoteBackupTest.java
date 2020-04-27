package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle;

public class PushRemoteBackupTest {
    public static void main(String[] args) throws Exception {

        ExtendedKubernetesClient client = AbstractTest.getClient();
        boolean successful = client.virtualMachines()
                .pushRemoteBackup("vmbackuptest", "vm.node25", getPushRemoteBackup());
        System.out.println(successful);
    }

    public static Lifecycle.PushRemoteBackup getPushRemoteBackup() {
        Lifecycle.PushRemoteBackup pushRemoteBackup = new Lifecycle.PushRemoteBackup();
        pushRemoteBackup.setVol("vmbackupdisktest1");
        pushRemoteBackup.setPool("3915282a12dd4c34a0ae565d3ba2da41");
        pushRemoteBackup.setVersion("backup2");
        pushRemoteBackup.setRemote("172.16.1.214");
        pushRemoteBackup.setPort("21");
        pushRemoteBackup.setUsername("ftpuser");
        pushRemoteBackup.setPassword("ftpuser");
        return pushRemoteBackup;
    }
}
