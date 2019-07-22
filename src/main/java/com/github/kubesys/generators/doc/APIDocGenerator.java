/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.generators.doc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import com.github.kubesys.kubernetes.impl.VirtualMachineDiskImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachineImageImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachineImpl;
import com.github.kubesys.kubernetes.impl.VirtualMachineSnapshotImpl;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since 2019/7/20
 *
 */
public class APIDocGenerator {
	
	protected final StringBuffer sb = new StringBuffer();
	
	protected final Map<String, String> cmds = new HashMap<String, String>();

	protected final Map<String, String> ignores = new HashMap<String, String>();
	
	protected final Map<String, Map<String, String>> params = new HashMap<String, Map<String, String>>();
	
	protected final String CMD_CFG = "cmd/alias.cfg";
	
	protected final String PARAM_CFG = "cmd/paramResults";
	
	public APIDocGenerator() throws Exception {
		super();
		BufferedReader br = new BufferedReader(
				new FileReader(new File(CMD_CFG)));
		String line = null;
		String ignore = "";
		while ((line = br.readLine()) != null) {
			if (line.trim().length() == 0) {
				continue;
			}
			
			if (line.startsWith("[")) {
				ignore = line.substring(1, line.length() - 1);
				continue;
			}
			String[] values = line.split("=");
			cmds.put(values[1].trim(), values[0].trim());
			ignores.put(values[1].trim(), ignore);
		}
		br.close();
	}

	public void genDoc() throws Exception {
		for (String cmd : cmds.keySet()) {
			sb.append("## **").append(cmds.get(cmd)).append("**\n\n");
			
			sb.append("Parameters:").append("\n\n");
			sb.append("| name | type | required | description | ").append("\n");
			sb.append("| ----- | ------ | ------ | ------ |").append("\n");
			Map<String, String> cmdParams = new HashMap<String, String>();
			genParams("[" + cmd + "]", cmdParams);
			params.put(cmds.get(cmd), cmdParams);
			
			sb.append("\n\nExeamples:").append("\n\n");
			
			sb.append("```").append("\n");
			sb.append("ExtendedKubernetesClient client = AbstractTest.getClient();").append("\n");
			sb.append(className(cmds.get(cmd)) + " cmd = new " + className(cmds.get(cmd)) + "();").append("\n");
			sb.append("{").append("\n");
			for(String name : params.get(cmds.get(cmd)).keySet()) {
				String type = params.get(cmds.get(cmd)).get(name).equals("String") ? "\"string\"" : "true";
				sb.append("\tcmd." + setMethod(name) + "(" + type + ");").append("\n");
			}
			sb.append("}").append("\n");
			sb.append(getImpl(cmds.get(cmd))).append("\n");
			sb.append("```").append("\n\n");
		}
	}
	
	protected void genParams(String key, Map<String,String> cmdParams) throws Exception {
		BufferedReader br = new BufferedReader(
				new FileReader(new File(PARAM_CFG)));
		String line = null;
		boolean ignore = true;
		while ((line = br.readLine()) != null) {
			if (line.trim().length() == 0) {
				continue;
			}
			
			if (line.startsWith("[vir")) {
				if (line.equals(key)) {
					ignore = false;
				} else {
					ignore = true;
				}
			} else {
				if (ignore) {
					continue;
				}
				
				sb.append("| ");
				
				String pname = line.split("\\s+")[0];
				String name = (pname.startsWith("[")) ?
						pname.substring(3, pname.length() - 1) :
							pname.substring(2, pname.length());
				
				sb.append(name).append(" | ");
				
				String type = (line.contains("<")) ? "String" : "Boolean";
				sb.append(type).append(" | ");
				
				cmdParams.put(name, type);
				
				String required = (line.startsWith("[")) ? "True" : "False";
				sb.append(required).append(" | ");
				
				int idx = line.indexOf(">");
				String desc = (idx == -1) ? 
						line.substring(name.length() + 3).trim() :
							line.substring(idx + 1).trim();
						
				sb.append(desc).append(" |").append("\n");
			}
			
		}
		br.close();
	}
	
	
	public StringBuffer getDoc() {
		return sb;
	}

	public static void main(String[] args) throws Exception {
		APIDocGenerator gen = new APIDocGenerator();
		gen.genDoc();
		System.out.println(gen.getDoc().toString());
	}
	
	protected static String setMethod(String name) {
		return "set" + name.substring(0, 1).toUpperCase()
							+ name.substring(1);
	}
	
	protected static String className(String name) {
		return name.substring(0, 1).toUpperCase()
							+ name.substring(1);
	}
	
	protected static String getImpl(String name) {
		String tmp = "client.TYPE().CMD(\"NAME\", CMD);)";
		if (VirtualMachineImpl.cmds.contains(name)) {
			return tmp.replaceAll("TYPE", "virtualmachines")
					.replaceAll("NAME", "vm").replaceAll("CMD", name);
		} else if (VirtualMachineDiskImpl.cmds.contains(name)) {
			return tmp.replaceAll("TYPE", "virtualmachinedisks")
					.replaceAll("NAME", "disk").replaceAll("CMD", name);
		} else if (VirtualMachineImageImpl.cmds.contains(name)) {
			return tmp.replaceAll("TYPE", "virtualmachineimages")
					.replaceAll("NAME", "image").replaceAll("CMD", name);
		} else if (VirtualMachineSnapshotImpl.cmds.contains(name)) {
			return tmp.replaceAll("TYPE", "virtualmachinesnapshots")
					.replaceAll("NAME", "snapshot").replaceAll("CMD", name);
		}
		return null;
	}
}
