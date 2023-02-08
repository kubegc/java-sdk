package io.github.kubestack.openstack;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.openstack.SecretRef;
import io.github.kubestack.client.api.specs.openstack.openstackserver.Lifecycle.CreateServer;

/**
 * @Description //Test Create Server
 * @Date 2023/2/8 16:40
 * @Author guohao
 **/
public class CC_002_VM_CreateServerTest {
    public static void main(String[] args) throws Exception {
        KubeStackClient client = AbstractTest.getClient();
        CreateServer createServer = get();
        boolean successful = client.openstackServers().createServer("test-create-sdk", get(), getSecretRef());
        System.out.println(successful);
    }

    public static CreateServer get() {
        CreateServer createServer = new CreateServer();
        createServer.setName("test-create-stack");
        createServer.setImageRef("952b386b-6f30-46f6-b019-f522b157aa3a");
        createServer.setFlavorRef("3");
        return createServer;
    }

    public static SecretRef getSecretRef() {
        SecretRef secretRef = new SecretRef();
        secretRef.setNamespace("default");
        secretRef.setName("openstack-compute-secret");
        return secretRef;
    }

}
