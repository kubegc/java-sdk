/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes.utils;

import java.util.regex.Pattern;

import com.github.kubesys.kubernetes.annotations.Variable;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.2.0
 * @since   2019/9/3
 *
 */
public class RegExpUtils {

	@Variable("名称是字符串类型，长度是8到32位，只允许数字、小写字母、中划线、以及圆点")
	public static String NAME_PATTERN = "[a-z0-9-/.]{8,32}";

	public static void main(String[] args) {
		String name = "abcdef.d";
		Pattern pattern = Pattern.compile(RegExpUtils.NAME_PATTERN);
		if (!pattern.matcher(name).matches()) {
			throw new IllegalArgumentException("");
		}
	}
}
