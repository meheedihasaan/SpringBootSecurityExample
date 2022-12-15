package com.security.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	private String username;
	private String password;
	private String email;
	private String role;
	
	public User() {
		
	}
	
	public User(String username, String password, String email, String role) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + "]";
	}
	
}
