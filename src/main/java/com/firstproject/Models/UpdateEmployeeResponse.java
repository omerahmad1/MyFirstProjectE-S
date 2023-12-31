package com.firstproject.Models;

import com.firstproject.Common.BaseResponse;
import com.firstproject.Entities.Employee;

public class UpdateEmployeeResponse extends BaseResponse {
	private Employee emp;

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "UpdateEmployeeResponse [emp=" + emp + "]";
	}
	

}
