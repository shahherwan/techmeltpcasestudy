package com.spring.springcore.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 *  Controller for user registrations.
 *  <p>
 *  This controller is mapped to "/register",
 *  which can be accessed through localhost:<port>/register
 *  <p>
 * 
 * @author 
 * 		Nazreen Misrawi
 *  
 */

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	/**
	 * 
	 * Default mapping for the controller.
	 * <p>
	 * Accessed through localhost:<port>/register
	 * 
	 * @return
	 * 		Register page
	 */
	
    @GetMapping
    public String showRegister() {
        return "register";
    }
}