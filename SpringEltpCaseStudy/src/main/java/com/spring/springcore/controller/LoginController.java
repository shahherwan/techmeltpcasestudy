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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.springcore.entity.User;
import com.spring.springcore.service.UserService;

/**
 * 
 * Controller for user logins.
 * <p>
 *  This controller is mapped to "/login",
 *  which can be accessed through localhost:<port>/login
 *  <p>
 * 
 * @author Nazreen Misrawi
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
    private UserService userService;
	
	/**
	 * 
	 * Default mapping for the login controller.
	 * <p>
	 * Accessed through localhost:<port>/login
	 * <p>
	 * This controller is also accessed whenever a user
	 * attempts to access a URI which requires authentication
	 * and/or specific privileges.
	 * 
	 * 
	 * Request mapping to handle requests to "/login" URI.
	 * <p>
	 * Method adds a message to the Model view if there is an error
	 * or a logout is made.
	 * <p>
	 * Default successful login URL is the root of the application,
	 * localhost<port>:/
	 * 
	 * @param model
	 * 		The model view, or the webpage
	 * @param error
	 * 		Error status
	 * @param logout
	 * 		Logout status
	 * 
	 * @return
	 * 		loginPage
	 * 
	 * 
	 * 
	 * 
	 * EmployeesController EMployee DAO Service list-employees 
	 */
	@RequestMapping
	public String loginProcess(Model model, String error, String logout) {
		if (error != null) {
			System.out.println(error);
			model.addAttribute("loginError", true);
		}
		if (logout != null) {
			model.addAttribute("logoutMsg", true);
		}
		return "loginPage";
	}
}


