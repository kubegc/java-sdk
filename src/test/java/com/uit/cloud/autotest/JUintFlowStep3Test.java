/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.autotest;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.VirtualMachine;
import com.github.kubesys.kubernetes.api.model.VirtualMachineDisk;
import com.github.kubesys.kubernetes.api.model.VirtualMachineSnapshot;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ChangeNumberOfCPU;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CloneVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CreateAndStartVMFromISO;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.CreateAndStartVMFromImage;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.DeleteVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.PlugDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.ResizeRAM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StartVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StopVM;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.StopVMForce;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UnplugDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachine.Lifecycle.UpdateOS;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CloneDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CreateDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.CreateDiskSnapshot;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.DeleteDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.DeleteDiskSnapshot;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Lifecycle.ResizeDisk;
import com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Lifecycle.CreateSnapshot;
import com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Lifecycle.DeleteSnapshot;
import com.uit.cloud.kubernetes.AbstractTest;

/**
 * @author  wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.3.0
 * @since   2019/9/4
 * 
 **/
public class JUintFlowStep3Test {
	
	/**********************************************************************
	 * 
	 *         Please ensure the following values are correct 
	 * 
	 **********************************************************************/
	
	// RegisterISO
	public final static String ISO = "/var/lib/libvirt/iso/centos7-minimal-1511.iso";
	
	// CreateVMImage
	public final static String IMAGE = "/var/lib/libvirt/templates/950646e8c17a49d0b83c1c797811e002";
	
	// CreateVPC
	public final static String SWITCH = "switchtest";
	
	// CreateVMDisk
	public final static String ROOTDISK = "/var/lib/libvirt/images/rootdisk";
	
	
	/**********************************************************************
	 * 
	 *                    Default Test value
	 * 
	 **********************************************************************/
	
	public final static String NAME_CorrectValue             = "auto.test";
	
	public final static String NAME_UnsupportSymbol          = "auto_test";
	
	public final static String NAME_TooShort                 = "";
	
	public final static String NAME_TooLong                  = "auto.test-auto.test-auto.test-";

	public final static String UUID_CorrectValue             = "uuid=auto.test";
	
	public final static String UUID_WrongFormat              = "auto.test";
	
	public final static String UUID_UnsupportSymbol          = "uuid=auto_test";
	
	public final static String UUID_TooShort                 = "uuid=";
	
	public final static String UUID_TooLong                  = "uuid=auto.test-auto.test-auto.test-";
	
	public final static String PATH_CorrectValue             = "/var/lib/libvirt/";
	
	public final static String PATH_WrongFormat              = "/var/lib/libvirt2/";
	
	public final static String PATH_UnsupportSymbol          = "/var/lib/lib_virt/";
	
	public final static String OS_CorrectValue               =  "centos7.0";
	
	public final static String OS_WrongValue                 =  "cent777";
	
	public final static String MAC_CorrectValue              = "52:54:29:16:e0:cc";
	
	public final static String MAC_WrongFormat               = "52:54:EF:16:e0:cc";
	
	public final static String MAC_UnsupportSymbol           = "fe:54:29:16:e0:cc";
	
	public final static String MAC_TooShort                  = "52:54:EF:16:e0";
	
	public final static String MAC_TooLong                   = "52:54:EF:16:e0:cc:cc";
	
	public final static String VCPU_CorrectValue             = "2";
	
	public final static String VCPU_TooSmall                 = "0";
	
	public final static String VCPU_TooLarger                = "100";
	
	public final static String RAM_CorrectValue              = "100";
	
	public final static String RAM_TooSmall                  = "99";
	
	public final static String RAM_TooLarger                 = "100000";
	
	public final static String DISK_TYPE_CorrectValue        = "qcow2";
	
	public final static String DISK_TYPE_WrongFormat         = "abc2";
	
	public final static String FDISK_TYPE_CorrectValue       = "vdb";
	
	public final static String FDISK_TYPE_WrongValue         =  "abd2";
	
	public final static String DISK_MODE_CorrectValue        = "shareable";
	
	public final static String DISK_MODE_WrongValue          = "read";
	
	public final static String DISK_DRIVER_CorrectValue      = "qemu";
	
	public final static String DISK_DRIVER_WrongValue        = "read";
	
	public final static String VIRT_TYPE_CorrectValue        = "kvm";
	
	public final static String SWITCH_TYPE_CorrectValue1     = "bridge";
	
	public final static String SWITCH_TYPE_CorrectValue2     = "l2bridge";
	
	public final static String SWITCH_TYPE_CorrectValue3     = "l3bridge";
	
	public final static String SWITCH_TYPE_WrongValue        = "l3b";
	
	public final static String GRAPHICS_CorrectValue         = "vnc,listen=0.0.0.0";
	
	public final static String DISK_SIZE_CorrectValue        = "20000000000";
	
	public final static String DISK_SIZE_TooSmall            = "1000000000";
	
	public final static String DISK_SIZE_TooLarger           = "1999999999999";
	
	public final static String IP_CorrectValue               = "192.168.5.12";
	
	public final static String IP_WrongRange1                = "256.168.5.12";
	
	public final static String IP_WrongRange2                = "192.168.5.256";
	
	public final static String IP_WrongFormat1               = "192.168";
	
	public final static String IP_WrongFormat2               = "192.168.5.12.1";
	
	public final static String VCPUSET_CorrectValue          = "192.168.5.12,cpuset=1";
	
	public final static String VCPUSET_WrongValue            = "192.168.5.12,cpuset=1000";
	
	public final static String IP_SWITCH_CorrectValue1       = "source=virbr0";
	
	public final static String IP_SWITCH_CorrectValue2       = "source=br-native";
	
	public final static String IP_SWITCH_CorrectValue3       = "source=br-int,ip=192.168.5.2,switch=switch";
	
	public final static String IP_SWITCH_WrongValue1         = "source=cni0";
	
	public final static String IP_SWITCH_WrongValue2         = "cni0";
	
	public final static String IP_SWITCH_WrongValue3         = "source=br-int,ip=192";
	
	public final static String NETWORK_TYPE_CorrectValue1    = "type=bridge,source=virbr0";

	public final static String NETWORK_TYPE_CorrectValue2    = "type=l2bridge,source=br-native";
	
	public final static String NETWORK_TYPE_CorrectValue3    = "type=l3bridge,source=br-int,ip=192.168.5.12,switch=" + SWITCH + ",inbound=102400,outbound=102400,mac=52:54:29:16:e0:cc";
	
	public final static String NETWORK_TYPE_WrongValue1      = "type=bri";

	public final static String NETWORK_TYPE_WrongValue2      = "l2bridge";
	
	public final static String NETWORK_TYPE_WrongValue3      = "type=l3bridge,source=bri";
	
	public final static String ISO_Cdrom_CorrectValue        = ISO;
	
	public final static String ISO_Cdrom_WrongValue          = ISO.toUpperCase();
	
	public final static String ISO_Disk_CorrectValue         = ROOTDISK;
	
	public final static String ISO_Disk_WrongValue           = ROOTDISK.toUpperCase();
	
	public final static String IMAGE_Cdrom_CorrectValue      = IMAGE;
	
	public final static String IMAGE_Cdrom_WrongValue        = IMAGE.toUpperCase();
	
	public final static String IMAGE_Disk_CorrectValue       = ROOTDISK;
	
	public final static String IMAGE_Disk_WrongValue         = ROOTDISK.toUpperCase();
	
	/**********************************************************************
	 * 
	 *                    Default Test value
	 * 
	 **********************************************************************/
	public final static String VM_POSTFIX                    = ".vm";
	
	public final static String VMI_POSTFIX                   = ".vmi";
	
	public final static String VMD_POSTFIX                   = ".vmd";
	
	public final static String VMDI_POSTFIX                  = ".vmdi";
	
	public final static String VMSN_POSTFIX                  = ".vmsn";

	/**********************************************************************
	 * 
	 *                    Parameters and steps
	 * 
	 **********************************************************************/
	
	public final static List<Map<String, String>> paramValues = new ArrayList<Map<String, String>>();
	
	public final static List<List<String>> testRounds = new ArrayList<List<String>>();
	
	
	/**********************************************************************
	 * 
	 *                    init parameters and steps
	 * 
	 **********************************************************************/
	
	static {
		{
			List<String> testRound1 = new ArrayList<String>();
			testRound1.add(VirtualMachine.class.getSimpleName() + "=" + CreateAndStartVMFromISO.class.getName());
			testRound1.add(VirtualMachine.class.getSimpleName() + "=" + StopVMForce.class.getName());
			testRound1.add(VirtualMachine.class.getSimpleName() + "=" + UpdateOS.class.getName());
			testRound1.add(VirtualMachine.class.getSimpleName() + "=" + StartVM.class.getName());
			testRound1.add(VirtualMachine.class.getSimpleName() + "=" + ChangeNumberOfCPU.class.getName());
			testRound1.add(VirtualMachine.class.getSimpleName() + "=" + ResizeRAM.class.getName());
	
			testRound1.add(VirtualMachineSnapshot.class.getSimpleName() + "=" + CreateSnapshot.class.getName());
			testRound1.add(VirtualMachineSnapshot.class.getSimpleName() + "=" + DeleteSnapshot.class.getName());
			
			testRound1.add(VirtualMachineDisk.class.getSimpleName() + "=" + CreateDisk.class.getName());
			testRound1.add(VirtualMachineDisk.class.getSimpleName() + "=" + ResizeDisk.class.getName());
			
			testRound1.add(VirtualMachine.class.getSimpleName() + "=" + PlugDisk.class.getName());
			
			testRound1.add(VirtualMachineDisk.class.getSimpleName() + "=" + CreateDiskSnapshot.class.getName());
			testRound1.add(VirtualMachineDisk.class.getSimpleName() + "=" + DeleteDiskSnapshot.class.getName());
			
			testRound1.add(VirtualMachine.class.getSimpleName() + "=" + UnplugDisk.class.getName());
			
			testRound1.add(VirtualMachineDisk.class.getSimpleName() + "=" + CloneDisk.class.getName());
			testRound1.add(VirtualMachineDisk.class.getSimpleName() + "=" + DeleteDisk.class.getName());
			
			testRound1.add(VirtualMachine.class.getSimpleName() + "=" + StopVM.class.getName());
			testRound1.add(VirtualMachine.class.getSimpleName() + "=" + CloneVM.class.getName());
			testRound1.add(VirtualMachine.class.getSimpleName() + "=" + DeleteVM.class.getName());
			testRounds.add(testRound1);
		}
		
		{
			List<String> testRound2 = new ArrayList<String>();
			testRound2.add(VirtualMachine.class.getSimpleName() + "=" + CreateAndStartVMFromImage.class.getName());
			testRound2.add(VirtualMachine.class.getSimpleName() + "=" + StopVM.class.getName());
			testRound2.add(VirtualMachine.class.getSimpleName() + "=" + StartVM.class.getName());
			testRound2.add(VirtualMachine.class.getSimpleName() + "=" + ChangeNumberOfCPU.class.getName());
			testRound2.add(VirtualMachine.class.getSimpleName() + "=" + ResizeRAM.class.getName());
	
			testRound2.add(VirtualMachineSnapshot.class.getSimpleName() + "=" + CreateSnapshot.class.getName());
			testRound2.add(VirtualMachineSnapshot.class.getSimpleName() + "=" + DeleteSnapshot.class.getName());
			
			testRound2.add(VirtualMachineDisk.class.getSimpleName() + "=" + CreateDisk.class.getName());
			testRound2.add(VirtualMachineDisk.class.getSimpleName() + "=" + ResizeDisk.class.getName());
			
			testRound2.add(VirtualMachine.class.getSimpleName() + "=" + PlugDisk.class.getName());
			
			testRound2.add(VirtualMachineDisk.class.getSimpleName() + "=" + CreateDiskSnapshot.class.getName());
			testRound2.add(VirtualMachineDisk.class.getSimpleName() + "=" + DeleteDiskSnapshot.class.getName());
			
			testRound2.add(VirtualMachine.class.getSimpleName() + "=" + UnplugDisk.class.getName());
			
			testRound2.add(VirtualMachineDisk.class.getSimpleName() + "=" + CloneDisk.class.getName());
			testRound2.add(VirtualMachineDisk.class.getSimpleName() + "=" + DeleteDisk.class.getName());
			
			testRound2.add(VirtualMachine.class.getSimpleName() + "=" + StopVM.class.getName());
			testRound2.add(VirtualMachine.class.getSimpleName() + "=" + CloneVM.class.getName());
			testRound2.add(VirtualMachine.class.getSimpleName() + "=" + DeleteVM.class.getName());
			testRounds.add(testRound2);
		}
	}
	
	
	protected static void initParamValues(JUintFlowStep3Test jfs3) throws IllegalAccessException {
		Map<String, String> map1 = new HashMap<String, String>();
		Map<String, String> map2 = new HashMap<String, String>();
		Map<String, String> map3 = new HashMap<String, String>();
		for (Field f: JUintFlowStep3Test.class.getDeclaredFields()) {
			String name  = f.getName();
			Object value = f.get(jfs3);
			if (!(value instanceof String) || 
					name.endsWith("POSTFIX")) {
				continue;
			}
			
			if (name.endsWith("CorrectValue1")) {
				map1.put(name, (String) value);
			} else if (name.endsWith("CorrectValue2")) {
				map2.put(name, (String) value);
			} else if (name.endsWith("CorrectValue3")) {
				map3.put(name, (String) value);
			} else {
				map1.put(name, (String) value);
				map2.put(name, (String) value);
				map3.put(name, (String) value);
			}
		}
		
		paramValues.add(map1);
		paramValues.add(map2);
		paramValues.add(map3);
	}
	
	/**********************************************************************
	 * 
	 *                    Kubernetes connect
	 * 
	 **********************************************************************/
	protected ExtendedKubernetesClient client;
	
	public JUintFlowStep3Test() throws Exception {
		this.client = AbstractTest.getClient();
	}

	
	public void startTesting() {
		int total   = 0;
		int sucess  = 0;
		int failure = 0;
		for(List<String> round : testRounds) {
			for (String step : round) {
				
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		JUintFlowStep3Test jfs3 = new JUintFlowStep3Test();
		initParamValues(jfs3);
		System.out.println(paramValues.get(0).size());
		System.out.println(testRounds.get(0).size());
	}


	
}
