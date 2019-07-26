/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CreateAndStartVMFromISO;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CreateAndStartVMFromImage;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/24
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class CreateAndStartFromImageTest {
	
	public static void main(String[] args) throws Exception {
		ExtendedKubernetesClient client = AbstractTest.getClient();
		CreateAndStartVMFromImage createAndStartVMFromImage = get();
		// name
		boolean successful = client.virtualMachines()
				.createAndStartVMFromImage("650646e8c17a49d0b83c1c797811e069",
						"node30", createAndStartVMFromImage);
		System.out.println(successful);
	}
	
	
	public static CreateAndStartVMFromImage get() throws Exception {
		
		CreateAndStartVMFromImage createAndStartVMFromImage = new CreateAndStartVMFromImage();
		// default value
		createAndStartVMFromImage.setMetadata("uuid=650646e8-c17a-49d0-b83c-1c797811e069");
		createAndStartVMFromImage.setVirt_type("kvm"); 
		createAndStartVMFromImage.setOs_variant("RHEL");
		createAndStartVMFromImage.setBoot("hd");
		createAndStartVMFromImage.setNoautoconsole(true); 
		
		// calculationSpecification
		calculationSpecification(createAndStartVMFromImage);  
		
		// cdrom
		// Disk and QoS for 1 disk and many disks
		createAndStartVMFromImage.setDisk("ROOTDISK,read_bytes_sec=1024,write_bytes_sec=1024 --disk size=10,read_bytes_sec=1024,write_bytes_sec=1024");
		
		//network and QoS
		createAndStartVMFromImage.setNetwork("bridge=virbr0");  
		
		// consoleMode amd passowrd
		createAndStartVMFromImage.setGraphics("vnc,listen=0.0.0.0" + getconsolePassword("123456"));
		
		createAndStartVMFromImage.setOs_variant("rhel7");
		return createAndStartVMFromImage;
	}


	protected static void calculationSpecification(CreateAndStartVMFromISO createAndStartVMFromISO) {
		createAndStartVMFromISO.setMemory("1024");    
		createAndStartVMFromISO.setVcpus("1");
	}
	
	protected static String getCPUSet(String cpuset) {
		return (cpuset == null || cpuset.length() == 0) 
				? "" :",cpuset=" + cpuset;
	}
	
	protected static String getconsolePassword(String pwd) {
		return (pwd == null || pwd.length() == 0) ? "" : ",password=abcdefg";
	}
	
	protected static String getOtherCDROMs() {
		return "--disk /opt/ISO/CentOS-7-x86_64-Minimal-1511.iso,device=cdrom,perms=ro --disk /opt/ISO/CentOS-7-x86_64-Minimal-1511.iso,device=cdrom,perms=ro";
	}
	
}
