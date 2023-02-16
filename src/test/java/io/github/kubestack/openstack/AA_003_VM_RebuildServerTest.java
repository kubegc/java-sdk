package io.github.kubestack.openstack;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.openstack.SecretRef;
import io.github.kubestack.client.api.specs.openstack.openstackserver.Lifecycle;

/**
 * @Description
 * @Date 2023/2/10 17:01
 * @Author guohao
 **/
public class AA_003_VM_RebuildServerTest {
    public static void main(String[] args) throws Exception {
        KubeStackClient client = AbstractTest.getClient();
        String id = client.openstackServers().get("test-create-sdk").getSpec().getId();
        boolean successful = client.openstackServers().rebuildServer("test-create-sdk", get(id));
        System.out.println(successful);
    }

    public static Lifecycle.RebuildServer get(String id) {
        Lifecycle.RebuildServer rebuildServer = new Lifecycle.RebuildServer();
        rebuildServer.setId(id);
        Lifecycle.RebuildServer.Opts opts = new Lifecycle.RebuildServer.Opts();
        opts.setImageRef("952b386b-6f30-46f6-b019-f522b157aa3a");
        opts.setAdminPass("111111");
        rebuildServer.setOpts(opts);
        return rebuildServer;
    }

    public static SecretRef getSecretRef() {
        SecretRef secretRef = new SecretRef();
        secretRef.setNamespace("default");
        secretRef.setName("openstack-compute-secret");
        return secretRef;
    }

}
