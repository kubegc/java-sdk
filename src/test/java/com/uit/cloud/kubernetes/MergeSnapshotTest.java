/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Lifecycle.MergeSnapshot;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class MergeSnapshotTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachineSnapshots()
				.mergeSnapshot("snapshot3", get());
		System.out.println(successful);
	}
	
	public static MergeSnapshot get() {
		MergeSnapshot mergeSnapshotToTop = new MergeSnapshot();
		mergeSnapshotToTop.setDomain("950646e8c17a49d0b83c1c797811e001");
		return mergeSnapshotToTop;
	}
}
