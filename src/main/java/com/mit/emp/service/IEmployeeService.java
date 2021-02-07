package com.mit.emp.service;

import java.util.List;

import com.mit.emp.model.Employee;

public interface IEmployeeService{
	
	public Integer saveEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public void deleteEmployeeById(Integer id);
	
	public Employee getEmployeeById(Integer id);

	public Integer updateEmployee(Employee employee);

}
