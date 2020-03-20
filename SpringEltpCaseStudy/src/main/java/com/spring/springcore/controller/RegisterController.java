package com.spring.springcore.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.springcore.entity.Employee;
import com.spring.springcore.entity.User;
import com.spring.springcore.service.EmployeeService;
import com.spring.springcore.service.UserService;

/**
 * 
 * Controller for user registrations.
 * <p>
 * This controller is mapped to "/register", which can be accessed through
 * localhost:<port>/register
 * <p>
 * 
 * @author Nazreen Misrawi
 * 
 */

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private UserService userService;

//	@Autowired
//	private EmployeeService employeeService;

	/**
	 * 
	 * Default mapping for the controller.
	 * <p>
	 * Accessed through localhost:<port>/register
	 * 
	 * @return Register page
	 */

	@GetMapping
	public String showRegister() {
		return "register";
	}

//	@GetMapping("/register")
//	public ModelAndView registration() {
//		ModelAndView modelAndView = new ModelAndView();
//		User user = new User();
//		modelAndView.addObject("user", user);
//		modelAndView.setViewName("register");
//		return modelAndView;
//	}

	@PostMapping
	public String createNewUser(Model model, @Valid User user) {
		User userExists = userService.findByUsername(user.getUsername());
		if (userExists != null) {
			model.addAttribute("usernameError", true);

		} else if(!user.getPassword().contentEquals(user.getPasswordConfirm())) {
			model.addAttribute("passwordMatchError", true);
		} else {
			userService.save(user);
			model.addAttribute("registrationSuccess", true);
		}
		return "register";
	}
}