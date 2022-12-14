package com.security.example.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{
	
	@Bean
	public SecurityFilterChain publicFilterChain(HttpSecurity http) throws Exception{
		http
			.csrf(csrf->csrf.disable())
			.authorizeHttpRequests(auth-> {
				//auth.requestMatchers("/home", "/login", "/register").permitAll();
				auth.requestMatchers("/signin").permitAll();
				auth.requestMatchers("/public/**").hasRole("NORMAL");
				auth.requestMatchers("/users/**").hasRole("ADMIN");
			})
			//.httpBasic();      //For Basic Authentication
			.formLogin()     //For Form based Authentication
			.loginPage("/signin")
			.loginProcessingUrl("/doLogin")
			.defaultSuccessUrl("/users");
		
		return http.build();
			
	}
	
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("mahin")
				.password("1234")
				.roles("NORMAL")
				.build();
		
		UserDetails user1 = User.withDefaultPasswordEncoder()
				.username("mehedi")
				.password("1234")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user, user1);
	}
	
	
}
