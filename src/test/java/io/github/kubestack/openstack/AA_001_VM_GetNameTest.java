package io.github.kubestack.openstack;

import io.github.kubestack.client.KubeStackClient;

/**
 * @Description
 * @Date 2023/2/15 20:27
 * @Author guohao
 **/
public class AA_001_VM_GetNameTest {

    public static void main(String[] args) throws Exception {

        KubeStackClient client = io.github.kubestack.AbstractTest.getClient();
        System.out.println(client.openstackServers().get("test-create-sdk").getMetadata().getName());
    }

}
