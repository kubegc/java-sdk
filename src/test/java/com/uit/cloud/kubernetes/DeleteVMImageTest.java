/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachineimage.Lifecycle.DeleteImage;


/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class DeleteVMImageTest {
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineImages()
				.deleteImage("950646e8c17a49d0b83c1c797811e001", get(), "123");
		System.out.println(successful);
	}
	
	private static DeleteImage get() {
		DeleteImage image = new DeleteImage();
		image.setTarget("/var/lib/libvirt/vmi1");
		return image;
	}
	
}
