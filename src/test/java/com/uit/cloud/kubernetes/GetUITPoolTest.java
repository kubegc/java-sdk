/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.alibaba.fastjson.JSON;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/5/1
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class GetUITPoolTest {
	
	public static void main(String[] args) throws Exception {
		System.out.println(JSON.toJSONString(
				AbstractTest.getUITPoolByName("test3"), true));
	}
	
}
