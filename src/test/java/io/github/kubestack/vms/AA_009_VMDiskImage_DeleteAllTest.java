/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.models.vms.VirtualMachineDiskImage;
import io.github.kubestack.client.api.specs.vms.virtualmachinediskimage.Lifecycle.DeleteDiskImage;


/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/7/15
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class AA_009_VMDiskImage_DeleteAllTest {
	
	public static void main(String[] args) throws Exception {

		KubeStackClient client = io.github.kubestack.AbstractTest.getClient();
		for (VirtualMachineDiskImage vmdi : client.virtualMachineDiskImages().list()) {
			boolean successful = client.virtualMachineDiskImages()
					.deleteDiskImage(vmdi.getMetadata().getName(), get());
			System.out.println(successful);
		}
		
	}

	protected static DeleteDiskImage get() {
		DeleteDiskImage deleteDiskImage = new DeleteDiskImage();
		deleteDiskImage.setSourcePool("ceph1");
		return deleteDiskImage;
	}
	
}
