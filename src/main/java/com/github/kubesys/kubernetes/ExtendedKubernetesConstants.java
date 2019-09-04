/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package com.github.kubesys.kubernetes;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * 
 * @version 1.0.0
 * @since   2019/9/3
 *
 */
public class ExtendedKubernetesConstants {

	public final static String LABEL_EVENTID     = "eventId";
	
	public final static String LABEL_HOST        = "host";
	
	public final static String LABEL_VM_HA       = "vm.ha";
	
	
	public final static String OPERATOR_ADD_TAG  = "AddTag";
	
	public final static String OPERATOR_DEL_TAG  = "DeleteTag";
	
	/*****************************************************************
	 * 
	 *                   These variables are used for generating API
	 * 
	 *****************************************************************/
	
	public final static String DESC_BOOLEAN       = "True或者False";
	
	public final static String DESC_FUNCTION_DESC = "只会返回True或者异常"
			+ "返回True意味着提交到Kubernetes成功，并不代表执行成功(异步设计)。开发人员需要通过监听Event和Watcher方法获取更详细信息；"
			+ "如果提交到Kubernetes后执行错误，需要根据资源的Status状态(https://tower.im/teams/616100/repository_documents/3395/)获取";
	
	public final static String DESC_FUNCTION_EXEC = "RuntimeException: 出现重名或不存在，或者该资源（如VirtualMachine, VirtualMachinePool等）还在处理中，需等待上一步操作完成才能进行下一步";
	
	public final static String DESC_FUNCTION_VM   = "虚拟机存在，即已调用过CreateAndStartVMFromISO,或CreateAndStartVMFromImage";
	
	public final static String DESC_FUNCTION_VMD  = "云盘存在，即已调用过CreateDisk，或CreateDiskFromDiskImage";
	
	public final static String DESC_FUNCTION_VMDI = "云盘镜像存在，即已调用过CreateDiskImage，或ConvertDiskToDiskImage";
	
	public final static String DESC_FUNCTION_VMI  = "虚拟机镜像存在，即已调用过CreateImage，或ConvertVMToImage";

}
