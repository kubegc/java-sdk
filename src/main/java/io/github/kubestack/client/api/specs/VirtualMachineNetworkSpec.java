/**
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */
package io.github.kubestack.client.api.specs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.github.kubestack.client.api.specs.virtualmachinenetwork.Data;
import io.github.kubestack.client.api.specs.virtualmachinenetwork.Lifecycle;

/**
 * @author wuheng@iscas.ac.cn
 * 
 * @version 2.0.0
 * @since   2022.9.28
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VirtualMachineNetworkSpec extends KubeStackSpec {


	protected String type;
	
	protected Data data;
	
	protected Lifecycle lifecycle;
	
	public VirtualMachineNetworkSpec() {

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Lifecycle getLifecycle() {
		return lifecycle;
	}

	public void setLifecycle(Lifecycle lifecycle) {
		this.lifecycle = lifecycle;
	}

}
