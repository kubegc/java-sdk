/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.vms;

import io.github.kubestack.AbstractTest;
import io.github.kubestack.client.KubeStackClient;
import io.github.kubestack.client.api.specs.vms.virtualmachine.Lifecycle.UpdateGraphic;

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

		KubeStackClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.updateGraphic("wyw123", updateGraphic());
		System.out.println(successful);
	}
	
	public static UpdateGraphic updateGraphic() {
		UpdateGraphic updateGraphic = new UpdateGraphic();
		updateGraphic.setType("vnc");
//		updateGraphic.setPassword("123456");
		updateGraphic.setNo_password(true);
		return updateGraphic;
	}
}
