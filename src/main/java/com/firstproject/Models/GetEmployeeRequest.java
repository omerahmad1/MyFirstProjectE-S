package com.firstproject.Models;

import com.firstproject.Common.BaseRequest;

public class GetEmployeeRequest extends BaseRequest {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "GetEmployeeRequest [id=" + id + "]";
	}
	
	

}
