package com.security.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.security.example.entities.User;
import com.security.example.repositories.UserRepository;

@SpringBootApplication
public class SpringBootSecurityExampleApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUsername("mehedi");
		user.setPassword(bcryptPasswordEncoder.encode("1234"));
		user.setEmail("mehedi@gmail.com");
		user.setRole("ROLE_ADMIN");
		
		userRepo.save(user);
		
		User user1 = new User();
		user1.setUsername("mahin");
		user1.setPassword(bcryptPasswordEncoder.encode("1234"));
		user1.setEmail("mahin@gmail.com");
		user1.setRole("ROLE_NORMAL");
		
		userRepo.save(user1);
	}

}
