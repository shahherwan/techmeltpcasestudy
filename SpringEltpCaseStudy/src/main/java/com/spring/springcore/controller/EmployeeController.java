package com.spring.springcore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.springcore.entity.Employee;
import com.spring.springcore.service.EmployeeService;


@Controller
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/employees")
	public String getAllEmployees(Model model) {
		List<Employee> list = service.getEmployees();
		model.addAttribute("employees", list);
		return "list-employees";
	}
}
