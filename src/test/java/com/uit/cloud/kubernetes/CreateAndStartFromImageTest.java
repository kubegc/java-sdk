/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CreateAndStartVMFromISO;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CreateAndStartVMFromImage;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class CreateAndStartFromImageTest {
	
	public static void main(String[] args) throws Exception {
		ExtendedKubernetesClient client = AbstractTest.getClient();
		CreateAndStartVMFromImage createAndStartVMFromImage = get();
		// name
		boolean successful = client.virtualMachines()
				.createAndStartVMFromImage("350646e8c17a49d0b83c1c797811a022",
						"vm.leader", createAndStartVMFromImage);
		System.out.println(successful);
	}
	
	
	public static CreateAndStartVMFromImage get() throws Exception {
		
		CreateAndStartVMFromImage createAndStartVMFromImage = new CreateAndStartVMFromImage();
		// default value
		createAndStartVMFromImage.setMetadata("uuid=350646e8-c17a-49d0-b83c-1c797a11e020");
		createAndStartVMFromImage.setVirt_type("kvm");
		// @see https://github.com/uit-plus/api/blob/master/src/main/java/com/github/uitplus/utils/OSDistroUtils.java
		createAndStartVMFromImage.setOs_variant("centos7.0");
		createAndStartVMFromImage.setBoot("hd");
		createAndStartVMFromImage.setNoautoconsole(true); 
		
		// calculationSpecification
		calculationSpecification(createAndStartVMFromImage);  
		
		// image
		
		createAndStartVMFromImage.setCdrom("/root/Kylin-4.0.2-server-sp2-17111109.Z1-marco-316kernel-arm64.qcow2");
		// Disk and QoS for 1 disk and many disks
		createAndStartVMFromImage.setDisk("ROOTDISK=/var/lib/libvirt/images/diskroot11,read_bytes_sec=1024000000,write_bytes_sec=1024000000");
		
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
		
//		createAndStartVMFromImage.setNetwork("type=l2bridge,source=virbr0,inbound=102400,outbound=102400");
//		createAndStartVMFromISO.setNetwork("type=l2bridge,source=br-native,inbound=102400,outbound=102400");
//      if you want to use l3bridge, please first execute the command on your master node, 'kubeovn-adm create-switch --name switch8888 --subnet 192.168.5.0/24' 		
//		createAndStartVMFromImage.setNetwork("type=l3bridge,source=br-int,ip=192.168.5.8,switch=switch8888,inbound=102400,outbound=102400");
		
		
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
	
}
