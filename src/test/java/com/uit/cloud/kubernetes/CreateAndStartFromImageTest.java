/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CreateAndStartVMFromISO;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CreateAndStartVMFromImage;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/15
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class CreateAndStartFromImageTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		CreateAndStartVMFromImage createAndStartVMFromImage = get();
		boolean successful = client.virtualMachines()
				.createAndStartVMFromImage("skywind11-clone", createAndStartVMFromImage);
		System.out.println(successful);
	}
	
	
	public static CreateAndStartVMFromImage get() throws Exception {
		CreateAndStartVMFromImage createAndStartVMFromImage = new CreateAndStartVMFromImage();
		createAndStartVMFromImage.setMemory("4096");
		createAndStartVMFromImage.setOriginal("skywind11");
		createAndStartVMFromImage.setFile("/var/lib/libvirt/images/skywin11_clone.qcow2");
		createAndStartVMFromImage.setVcpus("4");  
		return createAndStartVMFromImage;
	}
	
}
