package io.github.kubestack.openstack;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.openstack.SecretRef;
import io.github.kubestack.client.api.specs.openstack.openstackserver.Lifecycle;

/**
 * @Description
 * @Date 2023/2/10 17:00
 * @Author guohao
 **/
public class AA_003_VM_RebootServerTest {
    public static void main(String[] args) throws Exception {
        KubeStackClient client = AbstractTest.getClient();
        String id = client.openstackServers().get("test-create-sdk").getSpec().getId();
        boolean successful = client.openstackServers().rebootServer("test-create-sdk", get(id));
        System.out.println(successful);
    }

    public static Lifecycle.RebootServer get(String id) {
        Lifecycle.RebootServer rebootServer = new Lifecycle.RebootServer();
        rebootServer.setId(id);
        Lifecycle.RebootServer.Opts opts = new Lifecycle.RebootServer.Opts();
        opts.setType("SOFT");
        rebootServer.setOpts(opts);
        return rebootServer;
    }

    public static SecretRef getSecretRef() {
        SecretRef secretRef = new SecretRef();
        secretRef.setNamespace("default");
        secretRef.setName("openstack-compute-secret");
        return secretRef;
    }
}
