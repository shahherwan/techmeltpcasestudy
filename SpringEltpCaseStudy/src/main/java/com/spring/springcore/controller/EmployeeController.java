package com.spring.springcore.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.springcore.entity.Employee;
import com.spring.springcore.service.EmployeeService;


@Controller
@RequestMapping("/")
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	@GetMapping
	public String getAllEmployees(Model model, Principal principal) {
		List<Employee> list = service.getEmployees();
		model.addAttribute("employees", list);
		model.addAttribute("loggedInAs", "You are logged in as " + principal.getName());
		return "list-employees";
	}
}
