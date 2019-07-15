/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.VirtualMachine;
import com.github.kubesys.kubernetes.api.model.VirtualMachineSpec;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CreateAndStartVMFromISO;

import io.fabric8.kubernetes.api.model.ObjectMeta;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/15
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class CreateAndStartFromISOTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		CreateAndStartVMFromISO createAndStartVMFromISO = get();
		boolean successful = client.virtualMachines()
				.createAndStartVMFromISO("skywind5", createAndStartVMFromISO);
		System.out.println(successful);
	}
	
	
	public static CreateAndStartVMFromISO get() throws Exception {
		CreateAndStartVMFromISO createAndStartVMFromISO = new CreateAndStartVMFromISO();
		createAndStartVMFromISO.setVirt_type("kvm");  
		createAndStartVMFromISO.setMemory("1024");    
		createAndStartVMFromISO.setVcpus("1");  
		createAndStartVMFromISO.setCdrom("/opt/ISO/CentOS-7-x86_64-Minimal-1511.iso"); 
		createAndStartVMFromISO.setDisk("size=10,format=qcow2");      
		createAndStartVMFromISO.setNetwork("bridge=virbr0");  
		createAndStartVMFromISO.setGraphics("vnc,listen=0.0.0.0");   
		createAndStartVMFromISO.setNoautoconsole(true);   
		return createAndStartVMFromISO;
	}
	
}
