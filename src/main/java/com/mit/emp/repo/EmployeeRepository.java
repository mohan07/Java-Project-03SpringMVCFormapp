package com.mit.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mit.emp.model.Employee;


public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{
	

}
