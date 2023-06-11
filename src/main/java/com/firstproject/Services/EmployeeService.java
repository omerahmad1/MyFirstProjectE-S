package com.firstproject.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstproject.Entities.Employee;
import com.firstproject.Models.DeleteEmployeeResponse;
import com.firstproject.Models.GetAllEmployeeRequest;
import com.firstproject.Models.GetAllEmployeeResponse;
import com.firstproject.Models.GetEmployeeRequest;
import com.firstproject.Models.GetEmployeeResponse;
import com.firstproject.Models.SaveEmployeeRequest;
import com.firstproject.Models.SaveEmployeeResponse;
import com.firstproject.Models.UpdateEmployeeRequest;
import com.firstproject.Models.UpdateEmployeeResponse;
import com.firstproject.Repositories.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	

	public SaveEmployeeResponse save(SaveEmployeeRequest request, SaveEmployeeResponse response) {
		Employee emp = new Employee();
		emp.setId(request.getId());
		emp.setName(request.getName());
		emp.setEmail(request.getEmail());
		emp.setSalary(request.getSalary());
		employeeRepository.save(emp);
		response.setCode("200");
		response.setMessage("Success");
		return response;
	}


	public GetAllEmployeeResponse getAllEmployee(GetAllEmployeeRequest request, GetAllEmployeeResponse response) {
		
		List<Employee> employee = employeeRepository.findAll();
		List<Employee> s= employee.stream().filter(e-> e.getSalary()>15000).collect(Collectors.toList());
		System.out.println("Response :" + s);
		response.setData(s);
		response.setCode("200");
		response.setMessage("success");
		return response;
	}


	public GetEmployeeResponse getAllEmployee(GetEmployeeRequest request, GetEmployeeResponse response) {
		Employee employee = employeeRepository.findById(request.getId());
		response.setEmp(employee);
		response.setCode("200");
		response.setMessage("Success");
		return response;
	}


	public DeleteEmployeeResponse deleteEmployee(int id, DeleteEmployeeResponse response) {
		Employee employee = employeeRepository.findById(id);
		response.setEmp(employee);
		response.setCode("200");
		response.setMessage("Successfully Deleted");
		return response;
	}


	public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest request, int id,
			UpdateEmployeeResponse response) {
		
		Employee employee = employeeRepository.findById(id);
		employee.setId(request.getId());
		employee.setName(request.getName());
		employee.setSalary(request.getSalary());
		employeeRepository.save(employee);
		
		response.setEmp(employee);
		response.setCode("200");
		response.setMessage("Success");
		System.out.println("Response : "+ employee);
		return response;
	}

}
