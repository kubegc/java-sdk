/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.generators;

import com.github.kubesys.kubernetes.impl.AbstractImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachineDiskImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachineImageImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachineImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachineNetworkImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachinePoolImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachineSnapshotImpl;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.0.0
 * @since   2019/9/3
 *
 */
public class MethodGenerator {

	public static String generate(Object obj) throws Exception {
		StringBuffer sb = new StringBuffer();
		AbstractImpl<?, ?, ?> impl = (AbstractImpl<?, ?, ?>) obj;
		for (String cmd : impl.getSupportCmds()) {
			if (cmd.startsWith("create")) {
				sb.append("\tpublic boolean " + cmd +"(String name, " 
									+ getClassName(cmd) + " " + cmd + ") throws Exception {\n");
				sb.append("\t\treturn "+ cmd + "(name, null, " + cmd + ", null);\n");
				sb.append("\t}\n\n");
				
				sb.append("\tpublic boolean " + cmd +"(String name, String nodeName, " 
						+ getClassName(cmd) + " " + cmd + ") throws Exception {\n");
				sb.append("\t\treturn "+ cmd + "(name, nodeName, " + cmd + ", null);\n");
				sb.append("\t}\n\n");
				
				sb.append("\tpublic boolean " + cmd +"(String name, " 
						+ getClassName(cmd) + " " + cmd + ", String eventId) throws Exception {\n");
				sb.append("\t\treturn "+ cmd + "(name, null, " + cmd + ", eventId);\n");
				sb.append("\t}\n\n");
				
				sb.append("\tpublic boolean " + cmd +"(String name, String nodeName," 
						+ getClassName(cmd) + " " + cmd + ", String eventId) throws Exception {\n");
				sb.append("\t\treturn create(getModel(), createMetadata(name, nodeName, eventId), \r\n" + 
						"				createSpec(nodeName, createLifecycle(" + cmd + ")));\n");
				sb.append("\t}\n\n");
				
			} else if (cmd.startsWith("delete")) {
				sb.append("\tpublic boolean " + cmd +"(String name, " 
						+ getClassName(cmd) + " " + cmd + ") throws Exception {\n");
				sb.append("\t\treturn "+ cmd + "(name, " + cmd + ", null);\n");
				sb.append("\t}\n\n");
	
				sb.append("\tpublic boolean " + cmd +"(String name," 
						+ getClassName(cmd) + " " + cmd + ", String eventId) throws Exception {\n");
				sb.append("\t\treturn delete(name, updateMetadata(name, eventId), " + cmd + ");\n");
				sb.append("\t}\n\n");
			} else {
				sb.append("\tpublic boolean " + cmd +"(String name, " 
						+ getClassName(cmd) + " " + cmd + ") throws Exception {\n");
				sb.append("\t\treturn "+ cmd + "(name, " + cmd + ", null);\n");
				sb.append("\t}\n\n");
	
				sb.append("\tpublic boolean " + cmd +"(String name," 
						+ getClassName(cmd) + " " + cmd + ", String eventId) throws Exception {\n");
				sb.append("\t\treturn update(name, updateMetadata(name, eventId), " + cmd + ");\n");
				sb.append("\t}\n\n");
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws Exception {
//		System.out.println(generate(new VirtualMachineDiskImpl()));
//		System.out.println(generate(new VirtualMachineImpl()));
//		System.out.println(generate(new VirtualMachinePoolImpl()));
//		System.out.println(generate(new VirtualMachineImageImpl()));
//		System.out.println(generate(new VirtualMachineSnapshotImpl()));
		System.out.println(generate(new VirtualMachineNetworkImpl()));
	}
	
	public static String getClassName(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}
}
