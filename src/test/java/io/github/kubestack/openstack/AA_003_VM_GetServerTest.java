package io.github.kubestack.openstack;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.openstack.SecretRef;
import io.github.kubestack.client.api.specs.openstack.openstackserver.Lifecycle;

/**
 * @Description 获取openstack中server的状态
 * @Date 2023/2/15 20:12
 * @Author guohao
 **/
public class AA_003_VM_GetServerTest {
    public static void main(String[] args) throws Exception {
        KubeStackClient client = AbstractTest.getClient();
        String id = client.openstackServers().get("test-create-sdk").getSpec().getId();
        boolean successful = client.openstackServers().getServer("test-create-sdk", get(id));
        System.out.println(successful);
    }

    public static Lifecycle.GetServer get(String id) {
        Lifecycle.GetServer getServer = new Lifecycle.GetServer();
        getServer.setId(id);
        return getServer;
    }

    public static SecretRef getSecretRef() {
        SecretRef secretRef = new SecretRef();
        secretRef.setNamespace("default");
        secretRef.setName("openstack-compute-secret");
        return secretRef;
    }
}
