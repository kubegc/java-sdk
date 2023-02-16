package io.github.kubestack.openstack;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.openstack.SecretRef;
import io.github.kubestack.client.api.specs.openstack.openstackserver.Lifecycle;

/**
 * @Description //同步调用没有通过
 * @Date 2023/2/10 17:02
 * @Author guohao
 **/
public class AA_003_VM_ResizeServerTest {
    public static void main(String[] args) throws Exception {
        KubeStackClient client = AbstractTest.getClient();
        String id = client.openstackServers().get("test-create-sdk").getSpec().getId();
        boolean successful = client.openstackServers().resizeServer("test-create-sdk", get(id));
        System.out.println(successful);
    }

    public static Lifecycle.ResizeServer get(String id) {
        Lifecycle.ResizeServer resizeServer = new Lifecycle.ResizeServer();
        resizeServer.setId(id);
        Lifecycle.ResizeServer.Opts opts = new Lifecycle.ResizeServer.Opts();
        opts.setFlavorRef("4");
        resizeServer.setOpts(opts);
        return resizeServer;
    }

    public static SecretRef getSecretRef() {
        SecretRef secretRef = new SecretRef();
        secretRef.setNamespace("default");
        secretRef.setName("openstack-compute-secret");
        return secretRef;
    }
}
