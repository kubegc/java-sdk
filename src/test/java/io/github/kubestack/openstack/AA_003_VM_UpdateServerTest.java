package io.github.kubestack.openstack;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.openstack.SecretRef;
import io.github.kubestack.client.api.specs.openstack.openstackserver.Lifecycle;

/**
 * @Description
 * @Date 2023/2/10 16:58
 * @Author guohao
 **/
public class AA_003_VM_UpdateServerTest {
    public static void main(String[] args) throws Exception {
        KubeStackClient client = AbstractTest.getClient();
        String id = client.openstackServers().get("test-create-sdk").getSpec().getId();
        boolean successful = client.openstackServers().updateServer("test-create-sdk", get(id));
        System.out.println(successful);
    }

    public static Lifecycle.UpdateServer get(String id) {
        Lifecycle.UpdateServer updateServer = new Lifecycle.UpdateServer();
        updateServer.setId(id);
        Lifecycle.UpdateServer.Opts opts = new Lifecycle.UpdateServer.Opts();
        opts.setAccessIPv4("192.0.0.1");
        updateServer.setOpts(opts);
        return updateServer;
    }

    public static SecretRef getSecretRef() {
        SecretRef secretRef = new SecretRef();
        secretRef.setNamespace("default");
        secretRef.setName("openstack-compute-secret");
        return secretRef;
    }
}
