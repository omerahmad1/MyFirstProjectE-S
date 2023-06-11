package com.firstproject.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firstproject.Entities.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Employee findById(int id);
	
}
