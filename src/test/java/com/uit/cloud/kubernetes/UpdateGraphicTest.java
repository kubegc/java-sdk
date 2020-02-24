/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UpdateGraphic;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class UpdateGraphicTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.updateGraphic("wywtest", updateGraphic());
		System.out.println(successful);
	}
	
	public static UpdateGraphic updateGraphic() {
		UpdateGraphic updateGraphic = new UpdateGraphic();
		updateGraphic.setType("vnc");
		updateGraphic.setPassword("123456");
		updateGraphic.setLive(true);
		updateGraphic.setConfig(true);
		return updateGraphic;
	}
}
