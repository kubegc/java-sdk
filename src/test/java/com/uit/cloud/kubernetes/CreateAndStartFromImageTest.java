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
				.createAndStartVMFromImage("650646e8c17a49d0b83c1c797811e084",
						"node30", createAndStartVMFromImage);
		System.out.println(successful);
	}
	
	
	public static CreateAndStartVMFromImage get() throws Exception {
		
		CreateAndStartVMFromImage createAndStartVMFromImage = new CreateAndStartVMFromImage();
		// default value
		createAndStartVMFromImage.setMetadata("uuid=650646e8-c17a-49d0-b83c-1c797811e084");
		createAndStartVMFromImage.setVirt_type("kvm");
		// @see https://github.com/uit-plus/api/blob/master/src/main/java/com/github/uitplus/utils/OSDistroUtils.java
		createAndStartVMFromImage.setOs_variant("centos7.0");
		createAndStartVMFromImage.setBoot("hd");
		createAndStartVMFromImage.setNoautoconsole(true); 
		
		// calculationSpecification
		calculationSpecification(createAndStartVMFromImage);  
		
		// cdrom
		createAndStartVMFromImage.setCdrom("/var/lib/libvirt/templates/centos7.qcow2");
		// Disk and QoS for 1 disk and many disks
		createAndStartVMFromImage.setDisk("ROOTDISK,read_bytes_sec=1024000000,write_bytes_sec=1024000000 --disk size=10,read_bytes_sec=1024000000,write_bytes_sec=1024000000");
		
		/*
		 * libivrt default bridge
		 * Parameters:
		 * 	type
		 * 		type of network support values: "bridge", "l2bridge" and "l3bridge"
		 * 	source
		 * 		network source name
		 * 	inbound (optional)
		 * 		inbound bandwidth in KB
		 * 	outbound (optional)
		 * 		outbound bandwidth in KB
		 * 	mac (optional)
		 * 		if no mac, create a random mac
		 * 		Note! Mac address is unique and does not support a value that start with "fe:" (e.g. fe:54:00:05:37:b3)
		 */
//		createAndStartVMFromImage.setNetwork("type=bridge,source=virbr0,inbound=102400,outbound=102400");
		
		/*
		 * l2 network example
		 * Parameters:
		 * 	type
		 * 		type of network support values: "bridge", "l2bridge" and "l3bridge"
		 * 	source
		 * 		network source name
		 * 	inbound (optional)
		 * 		inbound bandwidth in KB
		 * 	outbound (optional)
		 * 		outbound bandwidth in KB
		 * 	mac (optional)
		 * 		if no mac, create a random mac
		 * 		Note! Mac address is unique and does not support a value that start with "fe:" (e.g. fe:54:00:05:37:b3)
		 */
//		createAndStartVMFromImage.setNetwork("type=l2bridge,source=br-native,inbound=102400,outbound=102400");
		
		/*
		 * l3 network example
		 * Parameters:
		 * 	type
		 * 		type of network support values: "bridge", "l2bridge" and "l3bridge"
		 * 	source
		 * 		network source name
		 * 	inbound (optional)
		 * 		inbound bandwidth limitation in KB, default is no limitation
		 * 	outbound (optional)
		 * 		outbound bandwidth limitation in KB, default is no limitation
		 * 	mac (optional)
		 * 		if no mac, create a random mac
		 * 		Note! Mac address is unique and does not support a value that start with "fe:" (e.g. fe:54:00:05:37:b3)
		 * 	ip (optional)
		 * 		ip address for l3 network, default is "dynamic" from DHCP
		 * 	switch
		 * 		switch name
		 */
		
		createAndStartVMFromImage.setNetwork("type=l3bridge,source=br-int,inbound=102400,outbound=102400,ip=192.168.4.8,switch=ls1"); 
		
		// consoleMode amd passowrd
		createAndStartVMFromImage.setGraphics("vnc,listen=0.0.0.0" + getconsolePassword("123456"));
		
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
