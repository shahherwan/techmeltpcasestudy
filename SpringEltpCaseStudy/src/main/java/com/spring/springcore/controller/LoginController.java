package com.spring.springcore.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping
	public String login() {
		return "loginPage";
	}
	
	@PostMapping("/login")
	public String loginProcess(Model model, String error, String logout) {
		if (error != null) {
			model.addAttribute("errorMsg", "Your username and password are invalid.");
//			return "loginPage";
		}
		if (logout != null) {
			model.addAttribute("msg", "You have been logged out successfully.");
//			return "loginPage";
		}
		return "loginPage";
	}
}
