package com.firstproject.Models;

import java.util.List;

import com.firstproject.Common.BaseResponse;
import com.firstproject.Entities.Employee;

public class GetAllEmployeeResponse extends BaseResponse{

	private List<Employee> data;

	public List<Employee> getData() {
		return data;
	}

	public void setData(List<Employee> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "GetEmployeeResponse [data=" + data + "]";
	}
	
}
