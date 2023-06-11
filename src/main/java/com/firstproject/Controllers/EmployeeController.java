package com.firstproject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstproject.Models.DeleteEmployeeResponse;
import com.firstproject.Models.GetAllEmployeeRequest;
import com.firstproject.Models.GetAllEmployeeResponse;
import com.firstproject.Models.GetEmployeeRequest;
import com.firstproject.Models.GetEmployeeResponse;
import com.firstproject.Models.SaveEmployeeRequest;
import com.firstproject.Models.SaveEmployeeResponse;
import com.firstproject.Models.UpdateEmployeeRequest;
import com.firstproject.Models.UpdateEmployeeResponse;
import com.firstproject.Services.EmployeeService;

@RestController
@RequestMapping(path = "employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/save")
	public SaveEmployeeResponse save(@RequestBody SaveEmployeeRequest request) {
		System.out.println("Request: " + request);
		SaveEmployeeResponse response = new SaveEmployeeResponse();
		response = employeeService.save(request,response);
		System.out.println("Response : "+ response);
		return response;
	}
	
	@GetMapping("/get")
	public GetAllEmployeeResponse getAllEmployee(@RequestBody GetAllEmployeeRequest request) {
		System.out.println("Response : "+ request);
		GetAllEmployeeResponse response =  new GetAllEmployeeResponse();
		response =employeeService.getAllEmployee(request,response);
		System.out.println("Response : "+ response);
		return response;
	}
	@PostMapping("/id")
	public GetEmployeeResponse getEmployee(@RequestBody GetEmployeeRequest request ) {
		System.out.println("Request : "+ request);
		GetEmployeeResponse response = new GetEmployeeResponse();
		response = employeeService.getAllEmployee(request,response);
		System.out.println("Response : "+ response);
		return response;
	}
	@DeleteMapping("/{id}")
	public DeleteEmployeeResponse deleteEmployee(@PathVariable int id) {
		DeleteEmployeeResponse response = new DeleteEmployeeResponse();
		response = employeeService.deleteEmployee(id,response);
		System.out.println("Response : "+ response);
		return response;
		
	}
	@PutMapping("/{id}")
	public UpdateEmployeeResponse updateEmployee(@RequestBody UpdateEmployeeRequest request , @PathVariable int id) {
		System.out.println("Request: " + request );
		UpdateEmployeeResponse response = new UpdateEmployeeResponse();
		response = employeeService.updateEmployee(request,id, response);
		System.out.println("Response : "+ response);
		return response;
	}

}
