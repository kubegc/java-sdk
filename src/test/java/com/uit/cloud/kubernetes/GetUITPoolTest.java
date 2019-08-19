/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/5/1
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class GetUITPoolTest {
	
	public static void main(String[] args) throws Exception {
		System.out.println(AbstractTest.getUITPoolByName("p1"));
	}
	
}
