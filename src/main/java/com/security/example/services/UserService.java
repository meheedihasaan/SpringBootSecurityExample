package com.security.example.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.security.example.entities.User;

@Service
public class UserService {

	List<User> users = new ArrayList<>();
	
	public UserService() {
		this.users.add(new User("mehedi", "1234", "mehedihasan111941@gmail.com"));
		this.users.add(new User("fariya", "1234", "fariya@gmail.com"));
		this.users.add(new User("mahin", "1234", "mahin@gmail.com"));
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
