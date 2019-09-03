/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.json;

import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import com.alibaba.fastjson.JSON;
import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.VirtualMachine;
import com.github.kubesys.kubernetes.api.model.VirtualMachineDisk;
import com.github.kubesys.kubernetes.api.model.VirtualMachineImage;
import com.github.kubesys.kubernetes.api.model.VirtualMachineNetwork;
import com.github.kubesys.kubernetes.api.model.VirtualMachinePool;
import com.github.kubesys.kubernetes.api.model.VirtualMachineSnapshot;

import io.fabric8.kubernetes.api.builder.Visitor;
import io.fabric8.kubernetes.client.dsl.ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author xuyuanjia2017@otcaix.iscas.ac.cn
 * @author xianghao16@otcaix.iscas.ac.cn
 * @author yangchen18@otcaix.iscas.ac.cn
 * @since Thu Aug 29 21:39:55 CST 2019
 **/
@SuppressWarnings("rawtypes")
public class JSONImpl implements ParameterNamespaceListVisitFromServerGetDeleteRecreateWaitApplicable {

	protected final ExtendedKubernetesClient client;
	
	protected final String kind;
	
	protected final Object obj;
	
	public JSONImpl(ExtendedKubernetesClient client, String kind, InputStream is) throws Exception {
		super();
		this.client = client;
		this.kind = kind;
		Class type = Class.forName("com.github.kubesys.kubernetes.api.model." + kind);
		this.obj = JSON.parseObject(is, type);
	}

	@Override
	public Object createOrReplace() {
		try {
			if (VirtualMachine.class.getSimpleName().equals("kind")) {
				client.virtualMachines().create((VirtualMachine) obj);
			} else if (VirtualMachineDisk.class.getSimpleName().equals("kind")) {
				client.virtualMachineDisks().create((VirtualMachineDisk) obj);
			} else if (VirtualMachineSnapshot.class.getSimpleName().equals("kind")) {
				client.virtualMachineSnapshots().create((VirtualMachineSnapshot) obj);
			} else if (VirtualMachinePool.class.getSimpleName().equals("kind")) {
				client.virtualMachinePools().create((VirtualMachinePool) obj);
			} else if (VirtualMachineImage.class.getSimpleName().equals("kind")) {
				client.virtualMachineImages().create((VirtualMachineImage) obj);
			} else if (VirtualMachineNetwork.class.getSimpleName().equals("kind")) {
				client.virtualMachineNetworks().create((VirtualMachineNetwork) obj);
			} 
		} catch (Exception ex) {
			try {
				if (VirtualMachine.class.getSimpleName().equals("kind")) {
					client.virtualMachines().update((VirtualMachine) obj);
				} else if (VirtualMachineDisk.class.getSimpleName().equals("kind")) {
					client.virtualMachineDisks().update((VirtualMachineDisk) obj);
				} else if (VirtualMachineSnapshot.class.getSimpleName().equals("kind")) {
					client.virtualMachineSnapshots().update((VirtualMachineSnapshot) obj);
				} else if (VirtualMachinePool.class.getSimpleName().equals("kind")) {
					client.virtualMachinePools().update((VirtualMachinePool) obj);
				} else if (VirtualMachineImage.class.getSimpleName().equals("kind")) {
					client.virtualMachineImages().update((VirtualMachineImage) obj);
				} else if (VirtualMachineNetwork.class.getSimpleName().equals("kind")) {
					client.virtualMachineNetworks().update((VirtualMachineNetwork) obj);
				} 
			} catch (Exception e) {
				throw new RuntimeException();
			}
		}
		return null;
	}

	@Override
	public Object delete() {
		try {
			if (VirtualMachine.class.getSimpleName().equals("kind")) {
				client.virtualMachines().delete((VirtualMachine) obj);
			} else if (VirtualMachineDisk.class.getSimpleName().equals("kind")) {
				client.virtualMachineDisks().delete((VirtualMachineDisk) obj);
			} else if (VirtualMachineSnapshot.class.getSimpleName().equals("kind")) {
				client.virtualMachineSnapshots().delete((VirtualMachineSnapshot) obj);
			} else if (VirtualMachinePool.class.getSimpleName().equals("kind")) {
				client.virtualMachinePools().delete((VirtualMachinePool) obj);
			} else if (VirtualMachineImage.class.getSimpleName().equals("kind")) {
				client.virtualMachineImages().delete((VirtualMachineImage) obj);
			} else if (VirtualMachineNetwork.class.getSimpleName().equals("kind")) {
				client.virtualMachineNetworks().delete((VirtualMachineNetwork) obj);
			} 
		} catch (Exception ex) {
			throw new RuntimeException();
		}
		return null;
	}
	
	// ============================
	@Override
	public Object inNamespace(String name) {
		return null;
	}

	@Override
	public Object waitUntilReady(long amount, TimeUnit timeUnit) throws InterruptedException {
		return null;
	}

	@Override
	public Object waitUntilCondition(Predicate condition, long amount, TimeUnit timeUnit) throws InterruptedException {
		return null;
	}

	@Override
	public Object withGracePeriod(long gracePeriodSeconds) {
		return null;
	}

	@Override
	public Object get() {
		return null;
	}

	@Override
	public Object deletingExisting() {
		return null;
	}

	@Override
	public Object accept(Visitor visitor) {
		return null;
	}

	@Override
	public Object withParameters(Map parameters) {
		return null;
	}

	@Override
	public Object cascading(boolean enabled) {
		return null;
	}

	@Override
	public Object createOrReplaceAnd() {
		return null;
	}

	@Override
	public Object apply() {
		return null;
	}

	@Override
	public Object fromServer() {
		return null;
	}

}