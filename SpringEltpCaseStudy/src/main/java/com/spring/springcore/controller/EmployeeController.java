package com.spring.springcore.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.springcore.entity.Employee;
import com.spring.springcore.exception.EmployeeNotFoundException;
import com.spring.springcore.service.EmployeeService;

/**
 *  Main Controller for the application.
 *  <p>
 *  This controller's default mapping is "/", 
 *  which accessed through localhost:<port>/
 *  
 *  @author
 *  	Nazreen Misrawi
 */

@Controller
@RequestMapping("/")
public class EmployeeController {
	
	/**
	 *  Autowire the EmployeeService.
	 *  <p>
	 *  This will be used to access the Employee DAO
	 *  
	 *  @author
	 *  	Nazreen Misrawi
	 */
	
	@Autowired
	EmployeeService service;
	
//	@Autowired
//	JdbcUserDetailsManager jdbcUserDetailsManager;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	/**
	 *  Controller for the root location of the API.
	 *  <p>
	 *  Since no path is specified in the GetMapping annotation,
	 *  the mapping of the controller class, "/", is used. Similarly,
	 *  This URI can be accessed by localhost:<port>/
	 *  <p>
	 *  @param model The view of the mapping, or web page.
	 *  @param principal Principal stores the information of the current authenticated user.
	 *  @return Returns the view list-employees
	 */
	@GetMapping
	public String getAllEmployees(Model model, Principal principal) {
		List<Employee> list = service.getEmployees();
//		UserDetails user = jdbcUserDetailsManager.loadUserByUsername("admin@email.com");
//		System.out.println(user);
		
		model.addAttribute("employees", list);
		model.addAttribute("loggedInAs", "You are logged in as " + principal.getName());
		return "list-employees";
	}

//	// Edit
//	@PostMapping("/edit")
//	public String editEmployee() {
//		return "redirect:/";
//	}

	// Edit
	@PostMapping("/edit/{id}")
	public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id) throws EmployeeNotFoundException {
		if (id.isPresent()) {
			Employee entity = service.getEmployeeById(id.get());
			model.addAttribute("employee", entity);
			service.updateEmployee(entity.getId(), entity);
		} else {
			model.addAttribute("employee", new Employee());
		}
		
		return "edit-employee";
	}
	
//	@RequestMapping("/register/process")
//	public String registerEmployee() {
//		jdbcUserDetailsManager.createUser(
//				User.withUsername("test@email.com")
//					.password(passwordEncoder.encode("testtest123"))
//					.roles("USER").build());
//		return "redirect:/";
//	}
	
	
	
}
