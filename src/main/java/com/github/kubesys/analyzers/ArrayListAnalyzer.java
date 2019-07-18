/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.analyzers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.github.kubesys.kubernetes.api.model.virtualmachine.Domain;
import com.github.kubesys.kubernetes.api.model.virtualmachinedisk.Volume;
import com.github.kubesys.kubernetes.api.model.virtualmachinesnapshot.Domainsnapshot;

/**
 * @author xuyuanjia2017@otcaix.iscas.ac.cn
 * @since 2019/6/14
 */
public class ArrayListAnalyzer {

	public static Set<String>  primitives = new HashSet<String>();
	
	public static List<String> results    = new ArrayList<String>();
	
	static {
		primitives.add(String.class.getName());
		primitives.add(Integer.class.getName());
		primitives.add(Boolean.class.getName());
		primitives.add(Long.class.getName());
		primitives.add("int");
		primitives.add("boolean");
		primitives.add("long");
	}
	
	public static void main(String[] args) throws Exception {
//		analyser(Class.forName(Domain.class.getName()));
		analyser(Class.forName(Volume.class.getName()));
//		analyser(Class.forName(Domainsnapshot.class.getName()));
		for (String res : results) {
			System.out.println(res);
		}
		
	}

	protected static void analyser(Class clazz) throws Exception {
		analyser(clazz.getSimpleName().toLowerCase(), clazz);
	}
	
	protected static void analyser(String parent, Class clazz) throws Exception {
		for (Field field : clazz.getDeclaredFields()) {
			String typename = field.getType().getName();
			if (primitives.contains(typename)) {
				continue;
			} else if (typename.equals(ArrayList.class.getName())) {
				results.add(parent + "-" + field.getName());
			} else {
				analyser(parent + "-" + field.getName(), Class.forName(typename));
			}
		}
	}
	
}
