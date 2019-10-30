/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachineimage.Lifecycle.ConvertImageToVM;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class ConvertImageToVMTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineImages()
				.convertImageToVM("150646e8c17a49d0b83c1c797811e045", get(), "123");
		System.out.println(successful);
	}
	
	private static ConvertImageToVM get() {
		ConvertImageToVM image = new ConvertImageToVM();
		image.setTarget("/var/lib/libvirt/images");
		return image;
	}
}
	
