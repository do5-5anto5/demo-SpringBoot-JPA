package com.quinto.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.quinto.demo.entities.Order;
import com.quinto.demo.entities.User;
import com.quinto.demo.entities.enums.OrderStatus;
import com.quinto.demo.repositories.OrderRepository;
import com.quinto.demo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Maria maria", "maria@gmail.com", "988888888", "123456"); 
		User user2 = new User(null, "Alex alex", "alex@gmail.com", "977777777", "123456");
		
		Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1); 
		Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2); 
		Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user1); 
		
		userRepository.saveAll(Arrays.asList(user1, user2)); 
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
	}

}
