package com.microservice.User.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.User.models.User;
import com.microservice.User.producers.UserProducer;
import com.microservice.User.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserProducer userProducer;
	
	@Transactional
	public User save (User user) {
		user = userRepository.save(user);
		userProducer.publishEmailMessage(user);
		return user; 
	}
}
