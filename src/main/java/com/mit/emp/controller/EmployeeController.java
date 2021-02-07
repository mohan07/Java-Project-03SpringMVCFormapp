package com.mit.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mit.emp.model.Employee;
import com.mit.emp.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	IEmployeeService service;

	@GetMapping("/register")
	public String showRegister() {

		return "EmployeeRegister";

	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute Employee employee, Model model) {

		Integer id = service.saveEmployee(employee);
		String message = id + " Employee saved successfully";
		model.addAttribute("message", message);
		return "EmployeeRegister";

	}

	@GetMapping("/all")
	public String getAllEmployees(Model model) {

		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);

		return "EmployeeData";

	}

	@GetMapping("/delete")
	public String deleteEmployeeById(@RequestParam Integer id, Model model) {

		service.deleteEmployeeById(id);
		List<Employee> list = service.getAllEmployees();

		String message = "Employee '" + id + "' deleted successfully";
		model.addAttribute("message", message);
		model.addAttribute("list", list);

		return "EmployeeData";

	}

	@GetMapping("/edit")
	public String showEdit(@RequestParam Integer id, Model model) {

		Employee e = service.getEmployeeById(id);
		model.addAttribute("employee", e);

		return "EmployeeEdit";

	}

	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee employee, Model model) {

		service.updateEmployee(employee);
		/*
		 * String message = id + " Employee updated successfully";
		 * model.addAttribute("message", message);
		 */
		return "redirect:all";

	}
}
