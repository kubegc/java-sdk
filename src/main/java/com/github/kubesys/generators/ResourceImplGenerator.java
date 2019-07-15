/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.generators;

import java.util.List;

import com.github.kubesys.kubernetes.api.model.VirtualMachine;
import com.github.kubesys.kubernetes.impl.VirtualMachineImpl;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since 2019/6/14
 *
 */
public class ResourceImplGenerator {

	public static void generate(String kind, String apiversion, List<String> cmds) {
		for (String cmd : cmds) {
			System.out.println("\tpublic boolean " + cmd + "(String name, " + getClassName(cmd) + " " + cmd +") throws Exception {");
			if (cmd.startsWith("create")) {
				System.out.println("\t\t" + kind + " kind = new " + kind + "();");
				System.out.println("\t\tkind.setApiVersion(\"" + apiversion + "\");");
				System.out.println("\t\tkind.setKind(\""+ kind +"\");");
				System.out.println("\t\t" + kind +  "Spec spec = new " + kind + "Spec();");
				System.out.println("\t\tObjectMeta om = new ObjectMeta();");
				System.out.println("\t\tom.setName(name);");
				System.out.println("\t\tkind.setMetadata(om);");
				System.out.println("\t\tLifecycle lifecycle = new Lifecycle();");
				System.out.println("\t\tlifecycle.set" + getClassName(cmd) + "(" + cmd + ");");
				System.out.println("\t\tspec.setLifecycle(lifecycle );");
				System.out.println("\t\tkind.setSpec(spec );");
				System.out.println("\t\tcreate(kind );");
			} else if (cmd.startsWith("delete")) {
				System.out.println("\t\t" + kind +" kind = get(name);");
				System.out.println("\t\tif(kind == null || kind.getSpec().getLifecycle() != null) {");
				System.out.println("\t\t\tdelete(kind);");
				System.out.println("\t\t}");
				System.out.println("\t\t" + kind + "Spec spec = kind.getSpec();");
				System.out.println("\t\tLifecycle lifecycle = new Lifecycle();");
				System.out.println("\t\tlifecycle.set" + getClassName(cmd) + "(" + cmd + ");");
				System.out.println("\t\tspec.setLifecycle(lifecycle );");
				System.out.println("\t\tkind.setSpec(spec );");
				System.out.println("\t\tdelete(kind );");
			} else {
				System.out.println("\t\t" + kind + " kind = get(name);");
				System.out.println("\t\tif(kind == null || kind.getSpec().getLifecycle() != null) {");
				System.out.println("\t\t\tthrow new RuntimeException(\"" + kind 
						+ "\" + name + "+ "\" is not exist or it is in a wrong status\");");
				System.out.println("\t\t}");
				System.out.println("\t\t" + kind + "Spec spec = kind.getSpec();");
				System.out.println("\t\tLifecycle lifecycle = new Lifecycle();");
				System.out.println("\t\tlifecycle.set" + getClassName(cmd) + "(" + cmd + ");");
				System.out.println("\t\tspec.setLifecycle(lifecycle );");
				System.out.println("\t\tkind.setSpec(spec );");
				System.out.println("\t\tupdate(\"" + cmd +"\" , kind );");
			}
			System.out.println("\t\treturn true;");
			System.out.println("\t}\n\n");
		}
	}
	
	public static void main(String[] args) {
		generate(VirtualMachine.class.getSimpleName(),
				"cloudplus.io/v1alpha3", VirtualMachineImpl.cmds);
	}
	
	public static String getClassName(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}
}
