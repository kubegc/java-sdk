/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import java.util.UUID;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StartVM;

import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since 2019/9/3
 *
 */
public class StartVMOnMachineTest {

	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		String eventId = UUID.randomUUID().toString().replaceAll("-", "");
		boolean successful = client.virtualMachines().migrateVM("vm006", get(), eventId);
		System.out.println(successful);
		client.events().withField("reason", "migrateVM").watch(new Watcher<Event>() {

			@Override
			public void eventReceived(Action action, Event resource) {
				if (resource.getMessage().indexOf("eventId:" + eventId) != -1) {
					System.out.println("event " + action.name() + " " + resource.toString());
					if (resource.getMessage().indexOf("status:Done") != -1 && resource.getType().equals("Normal")) {
						System.out.println("migrate VM done success, now start the VM.");
						try {
							Thread.sleep(2000);
							client.virtualMachines().startVM("vm006", new StartVM());
						} catch (Exception e) {
							e.printStackTrace();
						}
						onClose(null);
					} 
					else if (resource.getMessage().indexOf("status:Done") != -1 && resource.getType().equals("Warning")) {
						System.out.println("migrate VM failed!");
						onClose(null);
					}
				}
			}

			@Override
			public void onClose(KubernetesClientException cause) {
				System.out.println("Watcher close due to " + cause);
				client.close();
			}

		});
	}
	
	public static Lifecycle.MigrateVM get() throws Exception {
		Lifecycle.MigrateVM migrateVM = new Lifecycle.MigrateVM();
		migrateVM.setIp("133.133.135.22");
		migrateVM.setOffline(true);
		return migrateVM;
	}

}
