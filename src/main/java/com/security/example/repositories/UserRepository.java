package com.security.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.example.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	//To find product by it's name
	User findByUsername(String username);
	
}
