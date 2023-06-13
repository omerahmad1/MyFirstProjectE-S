package com.firstproject.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firstproject.Entities.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

//	Optional<Employee> findById(Integer id);

	
	Employee findByEmail(String email);


	Integer deleteById(int id);


	Employee findOneById(Integer id);


	Employee getOneById(Integer id);




	
}
