package com.quinto.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.quinto.demo.entities.User;
import com.quinto.demo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Maria maria", "maria@gmail.com", "988888888", "123456"); 
		User user2 = new User(null, "Alex alex", "alex@gmail.com", "977777777", "123456"); 
		
		userRepository.saveAll(Arrays.asList(user1, user2));
	}

}
