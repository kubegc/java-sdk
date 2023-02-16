package io.github.kubestack.openstack;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.models.openstack.OpenstackServer;
import io.github.kubestack.client.api.specs.openstack.SecretRef;
import io.github.kubestack.client.api.specs.openstack.openstackserver.Lifecycle;

/**
 * @Description
 * @Date 2023/2/10 16:59
 * @Author guohao
 **/
public class AA_004_VM_ForceDeleteServerTest {
    public static void main(String[] args) throws Exception {
        KubeStackClient client = AbstractTest.getClient();
        for (OpenstackServer server : client.openstackServers().list()) {
            String id = server.getSpec().getId();
            boolean deleteRemote = client.openstackServers().forceDeleteServer(server.getMetadata().getName(), get(id));
            boolean deleteK8s = client.openstackServers().delete(server);
            System.out.printf("delete server: %s\n", server.getMetadata().getName());
            System.out.println(deleteRemote);
            System.out.println(deleteK8s);
        }
    }

    public static Lifecycle.ForceDeleteServer get(String id) {
        Lifecycle.ForceDeleteServer forceDeleteServer = new Lifecycle.ForceDeleteServer();
        forceDeleteServer.setId(id);
        return forceDeleteServer;
    }

    public static SecretRef getSecretRef() {
        SecretRef secretRef = new SecretRef();
        secretRef.setNamespace("default");
        secretRef.setName("openstack-compute-secret");
        return secretRef;
    }
}
