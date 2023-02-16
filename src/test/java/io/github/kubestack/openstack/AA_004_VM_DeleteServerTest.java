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
public class AA_004_VM_DeleteServerTest {
    public static void main(String[] args) throws Exception {
        KubeStackClient client = AbstractTest.getClient();
        String id = client.openstackServers().get("test-create-sdk").getSpec().getId();
        boolean deleteRemote = client.openstackServers().deleteServer("test-create-sdk", get(id));
        boolean deleteK8s = client.openstackServers().delete(client.openstackServers().get("test-create-sdk"));
        System.out.println(deleteRemote);
        System.out.println(deleteK8s);
    }

    public static Lifecycle.DeleteServer get(String id) {
        Lifecycle.DeleteServer deleteServer = new Lifecycle.DeleteServer();
        deleteServer.setId(id);
        return deleteServer;
    }

    public static SecretRef getSecretRef() {
        SecretRef secretRef = new SecretRef();
        secretRef.setNamespace("default");
        secretRef.setName("openstack-compute-secret");
        return secretRef;
    }
}
