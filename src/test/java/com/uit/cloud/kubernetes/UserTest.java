/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.uit.cloud.kubernetes;

import com.alibaba.fastjson.JSONObject;
import com.uit.cloud.kubernetes.model.User;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @since  2019/5/1
 *
 * This code is used to manage CustomResource's lifecycle,
 * such as VirtualMachine
 */
public class UserTest {
	
	public final static String JSON = "{\"age\":18,\"name\":\"Henry\"}";
	
	public static void main(String[] args) throws Exception {
		User user = JSONObject.parseObject(JSON, User.class);
		System.out.println(user.getName());
	}

}
