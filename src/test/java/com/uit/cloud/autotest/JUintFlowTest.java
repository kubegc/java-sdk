/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.autotest;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.VirtualMachine;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.DeleteVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ManageISO;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ResumeVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StartVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StopVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StopVMForce;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.SuspendVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UpdateOS;
import com.uit.cloud.kubernetes.AbstractTest;
import com.uit.cloud.kubernetes.CreateAndStartFromISOTest;
import com.uit.cloud.kubernetes.PlugNICTest;
import com.uit.cloud.kubernetes.UnplugNICTest;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/8/3
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class JUintFlowTest {
	
	public final static String TEMPLATE = "/var/lib/libvirt/template/bbb.qcow2";
	
	public final static String ISO      = "/opt/ISO/CentOS-7-x86_64-Minimal-1511.iso"; 
	
	public final static String NAME     = "950646e8c17a49d0b83c1c797811e081";
	
	public final static String MAC      = "52:54:00:20:d0:90";
	
	@SuppressWarnings("deprecation")
	@Test
	public void test() throws Exception {
		ExtendedKubernetesClient client = AbstractTest.getClient();
		Assert.assertNotNull(client);
		
		clearEnv(client);
		
		client.virtualMachines().createAndStartVMFromISO(NAME, CreateAndStartFromISOTest.get());
		Assert.assertEquals(successful(client), true);
		Assert.assertEquals(getVMDiskNum(), 3);
		Assert.assertEquals(getVMNICNum(), 1);
		
		client.virtualMachines().stopVM(NAME, new StopVM());
		Assert.assertEquals(successful(client), false);
		
		client.virtualMachines().stopVMForce(NAME, new StopVMForce());
		Assert.assertEquals(successful(client), true);
		
		client.virtualMachines().updateOS(NAME, getUpdateSO());
		Assert.assertEquals(successful(client), true);

		client.virtualMachines().manageISO(NAME, getEjectISO());
		Assert.assertEquals(successful(client), true);
		Assert.assertEquals(getVMDiskNum(), 2);
		
		client.virtualMachines().startVM(NAME, new StartVM());
		Assert.assertEquals(successful(client), true);
		
		client.virtualMachines().suspendVM(NAME, new SuspendVM());
		Assert.assertEquals(successful(client), true);
		
		client.virtualMachines().resumeVM(NAME, new ResumeVM());
		Assert.assertEquals(successful(client), true);
		
		client.virtualMachines().plugNIC(NAME, PlugNICTest.get(MAC));
		Assert.assertEquals(successful(client), true);
		Assert.assertEquals(getVMNICNum(), 2);
		
		client.virtualMachines().unplugNIC(NAME, UnplugNICTest.get(MAC));
		Assert.assertEquals(successful(client), true);
		Assert.assertEquals(getVMNICNum(), 1);
		
		
	}

	public static UpdateOS getUpdateSO() {
		UpdateOS os = new UpdateOS();
		// current VM disk
		os.setSource("/var/lib/libvirt/images/" + NAME + ".qcow2");
		// target VM disk
		os.setTarget(TEMPLATE);
		return os;
	}
	
	protected void clearEnv(ExtendedKubernetesClient client) throws Exception {
		VirtualMachine vm = AbstractTest.getVMByName(NAME);
		if (vm != null) {
			client.virtualMachines().stopVMForce(NAME, new StopVMForce());
			Thread.sleep(5000);
			client.virtualMachines().deleteVM(NAME, new DeleteVM());
		} 
	}
	
	public static ManageISO getEjectISO() {
		ManageISO iso = new ManageISO();
		iso.setPath(ISO);
		iso.setEject(true);
		iso.setForce(true);
//		iso.setLive(true);
		iso.setConfig(true);
		return iso;
	}
	
	protected boolean successful(ExtendedKubernetesClient client) throws Exception {
		int num = 10;
		while (num-- > 0) {
			if (checkStatus(client)) {
				return true; 
			} else {
				Thread.sleep(3000);
			}
		}
		return false;
	}
	
	protected boolean checkStatus(ExtendedKubernetesClient client) throws Exception {
		VirtualMachine vm = AbstractTest.getVMByName(NAME);
		if (vm.getSpec().getLifecycle() != null) {
			System.out.println("虚拟机正在处理中[根据Action的状态]");
			return false;
		}
		
		if (vm.getSpec().getStatus() == null 
				|| vm.getSpec().getStatus().getAdditionalProperties() == null) {
			System.out.println("虚拟机处理异常，virtctl或virtctl服务异常");
			return false;
		}
		
		Map<String, Object> statusProps = vm.getSpec().getStatus().getAdditionalProperties();	
		Map<String, Object> statusCond = (Map<String, Object>) (statusProps.get("conditions"));
		Map<String, Object> statusStat = (Map<String, Object>) (statusCond.get("state"));
		Map<String, Object> statusWait = (Map<String, Object>) (statusStat.get("waiting"));
		if (statusWait.get("reason").equals("Exception")
				|| statusWait.get("reason").equals("VirtctlError")) {
			System.out.println("错误原因[根据Action的状态]：" + statusWait.get("message"));
			return false;
		}
		return true;
	}
	
	public int getVMDiskNum() throws Exception {
		VirtualMachine vm = AbstractTest.getVMByName(NAME);
		int size = vm.getSpec().getDomain().getDevices().getDisk().size();
		return size;
	}
	
	public int getVMNICNum() throws Exception {
		VirtualMachine vm = AbstractTest.getVMByName(NAME);
		int size = vm.getSpec().getDomain().getDevices().get_interface().size();
		return size;
	}
}
