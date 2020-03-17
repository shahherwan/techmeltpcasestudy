//package com.spring.springcore.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/login?logout")
//public class LogoutController {
//	
//	/**
//	 * 
//	 * Default mapping for the login controller.
//	 * <p>
//	 * Accessed through localhost:<port>/login
//	 * <p>
//	 * This controller is also accessed whenever a user
//	 * attempts to access a URI which requires authentication
//	 * and/or specific privileges.
//	 * 
//	 * 
//	 * Request mapping to handle requests to "/login" URI.
//	 * <p>
//	 * Method adds a message to the Model view if there is an error
//	 * or a logout is made.
//	 * <p>
//	 * Default successful login URL is the root of the application,
//	 * localhost<port>:/
//	 * 
//	 * @param model
//	 * 		The model view, or the webpage
//	 * @param error
//	 * 		Error status
//	 * @param logout
//	 * 		Logout status
//	 * 
//	 * @return
//	 * 		loginPage
//	 */
//	@RequestMapping
//	public String logoutProcess(Model model, String error, String logout) {
//		if (error != null) {
//			model.addAttribute("errorMsg", "Invalid credentials");
//		}
//		if (logout != null) {
//			model.addAttribute("logoutMsg", "You have been logged out successfully.");
//		}
//		return "loginPage";
//	}
//
//}
