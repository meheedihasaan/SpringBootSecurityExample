package com.security.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/signin")
	public String login() {
		System.out.println("Login page");
		return "login";
	}
	
}
