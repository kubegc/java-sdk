/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.ConvertDiskToDiskImage;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class ConvertDiskToDiskImageTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineDisks()
				.convertDiskToDiskImage("20190919root13131245", get(), "abcd");
		System.out.println(successful);
	}

	protected static ConvertDiskToDiskImage get() {
		ConvertDiskToDiskImage convertDisk = new ConvertDiskToDiskImage();
        convertDisk.setType("dir");
		convertDisk.setTargetPool("pool1");
		return convertDisk;
	}
}
