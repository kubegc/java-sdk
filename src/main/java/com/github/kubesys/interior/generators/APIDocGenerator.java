/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.interior.generators;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.github.kubesys.interior.annotations.Function;
import com.github.kubesys.interior.annotations.Parent;

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
			
			sb.append("参数:").append("\n\n");
			sb.append("| name | type | required | description | ").append("\n");
			sb.append("| ----- | ------ | ------ | ------ |").append("\n");
			Map<String, String> cmdParams = new HashMap<String, String>();
			genParams("[" + cmd + "]", cmdParams);
			params.put(cmds.get(cmd), cmdParams);
			
			sb.append("\n\nJava代码:").append("\n\n");
			
			sb.append("```").append("\n");
			sb.append("ExtendedKubernetesClient client = AbstractTest.getClient();").append("\n");
			sb.append(className(cmds.get(cmd)) + " cmd = new " + className(cmds.get(cmd)) + "();").append("\n");
			sb.append("{").append("\n");
			for(String name : params.get(cmds.get(cmd)).keySet()) {
				String type = params.get(cmds.get(cmd)).get(name).equals("String") ? "\"string\"" : "true";
				sb.append("\tcmd." + setMethod(name) + "(" + type + ");").append("\n");
			}
			sb.append("}").append("\n");
//			sb.append(getImpl(cmds.get(cmd))).append("\n");
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

	protected static String setMethod(String name) {
		return "set" + name.substring(0, 1).toUpperCase()
							+ name.substring(1);
	}
	
	protected static String className(String name) {
		return name.substring(0, 1).toUpperCase()
							+ name.substring(1);
	}
	
	public static void main(String[] args) throws Exception {
		StringBuffer sb = new StringBuffer();
		
		int i = 1; 
		for (String classname : JSONGenerator.list) {
			
			Class<?> forName = Class.forName(classname);
			Parent parent = forName.getAnnotation(Parent.class);
			if (parent == null) {
				continue;
			}
			
			sb.append("# ").append(i).append(" ")
				.append(parent.value()).append("\n\n");
			
			int j = 1;
			for (Field field : forName.getDeclaredFields()) {
				Function function = field.getAnnotation(Function.class);
				
				sb.append("## ").append(i).append(".").append(j++).append(" ")
						.append(field.getType().getSimpleName())
						.append("(").append(function.shortName()).append(")").append("\n\n");
				
				if (function != null) {
					sb.append("**接口功能:**").append("\n");
					sb.append("\t").append(function.description()).append("\n\n");
					
					sb.append("**接口依赖:**").append("\n");
					sb.append("\t").append(function.prerequisite()).append("\n\n");
					
					sb.append("**接口所属:**").append("\n");
					sb.append("\t").append(classname).append(".").append(field.getType().getSimpleName()).append("\n\n");
					
					sb.append("**参数描述:**").append("\n\n");
					
					sb.append("**接口异常:**").append("\n\n");
					sb.append("异常分为两类:(1)在调用本方法时因资源重名或不存在，或上一次操作未处理完导致;"
							+ "(2)调用本方法返回True，因本API是异步处理，开发者需要进一步监听是否正确执行。本文考虑第(2)种情况"
							+ "请查看" + field.getType().getSimpleName() + "spec下的status域，从message中获取详细异常信息").append("\n\n");
					sb.append("| name  | description | ").append("\n");
					sb.append("| ----- | ----- | ").append("\n");
					sb.append("| LibvirtError | 因传递错误参数，或者后台缺少软件包导致执行Libvirt命令出错   |").append("\n");
					sb.append("| VirtctlError | Libvirt不支持的生命周期    |").append("\n");
					sb.append("| VirtletError | Libvirt监听事件错误，比如绕开Kubernetes,后台执行操作  |").append("\n");
					sb.append("| Exception    | 后台代码异常退出    |").append("\n\n");
				}
			}
			i++;
		}
		
		System.out.println(sb.toString());
	}
}
