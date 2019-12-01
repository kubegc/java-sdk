/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle;

import io.fabric8.kubernetes.api.model.Event;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watch;
import io.fabric8.kubernetes.client.Watcher;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class StartVMOnMachineTest {
	
	
	public static void main(String[] args) throws Exception {

		ExtendedKubernetesClient client = AbstractTest.getClient();
		boolean successful = client.virtualMachines()
				.migrateVM("vm006", get(), "abc123");
		System.out.println(successful);
		client.events().withName("abc123").watch(new Watcher<Event>() {

			  @Override
			  public void eventReceived(Action action, Event resource) {
			    System.out.println("event " + action.name() + " " + resource.toString());
			  }

			  @Override
			  public void onClose(KubernetesClientException cause) {
			    System.out.println("Watcher close due to " + cause);
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
