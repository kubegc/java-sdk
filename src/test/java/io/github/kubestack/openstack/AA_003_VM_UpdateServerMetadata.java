package io.github.kubestack.openstack;

import java.util.HashMap;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.openstack.SecretRef;
import io.github.kubestack.client.api.specs.openstack.openstackserver.Lifecycle;

/**
 * @Description
 * @Date 2023/2/16 11:19
 * @Author guohao
 **/
public class AA_003_VM_UpdateServerMetadata {
    public static void main(String[] args) throws Exception {
        KubeStackClient client = AbstractTest.getClient();
        String id = client.openstackServers().get("test-create-sdk").getSpec().getId();
        boolean successful = client.openstackServers().updateMetadataServer("test-create-sdk", get(id));
        System.out.println(successful);
    }

    public static Lifecycle.UpdateMetadataServer get(String id) {
        Lifecycle.UpdateMetadataServer updateMetadataServer = new Lifecycle.UpdateMetadataServer();
        updateMetadataServer.setId(id);
        HashMap<String, String> opts = new HashMap<>();
        opts.put("updated", "1");
        updateMetadataServer.setOpts(opts);
        return updateMetadataServer;
    }

    public static SecretRef getSecretRef() {
        SecretRef secretRef = new SecretRef();
        secretRef.setNamespace("default");
        secretRef.setName("openstack-compute-secret");
        return secretRef;
    }
}
