package com.mit.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mit.emp.exception.EmployeeNotFoundException;
import com.mit.emp.model.Employee;
import com.mit.emp.repo.EmployeeRepository;
import com.mit.emp.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public Integer saveEmployee(Employee employee) {
		
		employee=repo.save(employee);
		
		return employee.getId();
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		List<Employee> list=repo.findAll();
		list.sort((e1,e2)->e1.getId()-e2.getId());
		return list;
	}

	@Override
	public void deleteEmployeeById(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		Employee e=	repo.findById(id).orElseThrow(
				()->
					new EmployeeNotFoundException("Employee '"+id+"' is not Exist")
				);
		
		return e;
	}

	@Override
	public Integer updateEmployee(Employee employee) {
		repo.save(employee);
		return employee.getId();
	}

}
