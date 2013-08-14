package com.petstatistic.controller;

import com.petstatistic.common.PetComRequest;


public class PetStatisticRequest extends PetComRequest{
	private String method;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}


}
