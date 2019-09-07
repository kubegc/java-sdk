/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinediskimage.Lifecycle.ConvertDiskImageToDisk;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class ConvertDiskImageToDiskTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDiskImages()
				.convertDiskImageToDisk("test6.qcow2", get(), "abc");
		System.out.println(successful);
	}

	protected static ConvertDiskImageToDisk get() {
		ConvertDiskImageToDisk convertDiskImage = new ConvertDiskImageToDisk();
		// need pool to store disk
		convertDiskImage.setPool("default");
		return convertDiskImage;
	}
}
