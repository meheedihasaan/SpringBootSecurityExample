package com.security.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.example.entities.User;
import com.security.example.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping("")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/{username}")
	public User getUserByUsername(@PathVariable("username") String username) {
		return this.userService.getUserByUsername(username);
	}
	
	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}
	
}
