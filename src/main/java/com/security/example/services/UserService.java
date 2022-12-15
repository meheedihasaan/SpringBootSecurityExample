package com.security.example.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.security.example.entities.User;

@Service
public class UserService {

	//Fake Service
	List<User> users = new ArrayList<>();
	
	public UserService() {
		users.add(new User("Mehedi", "mehedi@gmail.com", "1234", "ADMIN"));
		users.add(new User("Mahin", "mahin@gmail.com", "1234", "NORMAL"));
		users.add(new User("Fariya", "fariya@gmail.com", "1234", "NORMAL"));
	}
	
	//To get all the users
	public List<User> getUsers(){
		return this.users;
	}
	
	//To get a user by his username
	public User getUserByUsername(String username) {
		return this.users
				.stream()
				.filter((user)->user.getUsername().equals(username))
				.findAny()
				.orElse(null);
	}
	
	//To add a new user
	public User addUser(User user) {
		this.users.add(user);
		return user;
	}
}
