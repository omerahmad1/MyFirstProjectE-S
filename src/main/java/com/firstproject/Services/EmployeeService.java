package com.firstproject.Services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.firstproject.Entities.Employee;
import com.firstproject.Models.DeleteEmployeeResponse;
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

		if (Objects.nonNull(employeeRepository.findByEmail(request.getEmail()))) {
			response.setCode("409");
			response.setMessage("User Already exist");
			return response;
		}
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

	@SuppressWarnings("unused")
	public GetAllEmployeeResponse getAllEmployee(GetAllEmployeeResponse response) {

		List<Employee> employee = employeeRepository.findAll();
		

		List<Employee> s = employee.stream().filter(e-> e.getSalary()>15000).collect(Collectors.toList());

		if( s.isEmpty()) {
			response.setData(s);
			response.setCode("100");
			response.setMessage("No data found");
			return response;
		}
		response.setData(s);
		response.setCode("200");
		response.setMessage("success");
		return response;
	}

	public GetEmployeeResponse getEmployee(Integer id, GetEmployeeResponse response) {
		Employee employee = employeeRepository.findOneById(id);
		if (employee == null) {
			response.setCode("100");
			response.setMessage("Employee not exists");
			return response;
		}
		response.setEmp(employee);
		response.setCode("200");
		response.setMessage("Success");
		return response;
	}

	public DeleteEmployeeResponse deleteEmployee(Integer id, DeleteEmployeeResponse response) {
		if (employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
			response.setCode("200");
			response.setMessage("Successfully Deleted");
			return response;
		}
		response.setCode("100");
		response.setMessage("Employee not Exists");

		return response;
	}

	public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest request, int id,
			UpdateEmployeeResponse response) {

		Employee employee = employeeRepository.findById(id);
		if (employee != null) {
			employee.setId(request.getId());
			employee.setName(request.getName());
			employee.setSalary(request.getSalary());
			employeeRepository.save(employee);

			response.setEmp(employee);
			response.setCode("200");
			response.setMessage("Success");
			System.out.println("Response : " + employee);
			return response;
		} else {

			response.setCode("100");
			response.setMessage("Employee not exists");
			return response;

		}

	}

}
