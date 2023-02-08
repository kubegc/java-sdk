package io.github.kubestack.client.impl.openstack;

import java.util.regex.Pattern;

import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.models.openstack.OpenstackServer;
import io.github.kubestack.client.api.specs.openstack.OpenstackServerSpec;
import io.github.kubestack.client.api.specs.openstack.SecretRef;
import io.github.kubestack.client.api.specs.openstack.openstackserver.Lifecycle;
import io.github.kubestack.client.api.specs.openstack.openstackserver.Lifecycle.CreateServer;
import io.github.kubestack.client.impl.AbstractImpl;
import io.github.kubestack.core.utils.RegExpUtils;

/**
 * @Description // openstack server operation impl
 * @Date 2023/2/8 16:45
 * @Author guohao
 **/
@SuppressWarnings("deprecation")
public class OpenstackServerImpl extends AbstractImpl<OpenstackServer, OpenstackServerSpec> {

    public OpenstackServerImpl(KubeStackClient client, String kind) {
        super(client, kind);
    }

    public boolean createServer(String name, CreateServer createServer, SecretRef secretRef) throws Exception {
        Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
        if (!pattern.matcher(name).matches()) {
            throw new IllegalArgumentException(
                "the length must be between 4 and 100, and it can only includes a-z, 0-9 and -.");
        }
        // todo test createLifecycle
        return create(getModel(), createMetadata(name, null, null),
            createSpec(createLifecycle(createServer), secretRef));
    }

    @Override
    protected Class<?> getModelClass() {
        return OpenstackServer.class;
    }

    @Override
    protected OpenstackServer getModel() {
        return new OpenstackServer();
    }

    @Override
    protected OpenstackServerSpec getSpec() {
        return new OpenstackServerSpec();
    }

    @Override
    protected Object getLifecycle() {
        return new Lifecycle();
    }
}
