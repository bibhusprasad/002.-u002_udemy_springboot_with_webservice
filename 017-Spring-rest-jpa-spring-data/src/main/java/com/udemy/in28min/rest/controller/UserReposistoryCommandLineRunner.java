package com.udemy.in28min.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.udemy.in28min.rest.entity.User;
import com.udemy.in28min.rest.service.UserReposistory;

@Component
public class UserReposistoryCommandLineRunner implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(UserReposistoryCommandLineRunner.class);
	
	@Autowired
	private UserReposistory userReposistory;

	@Override
	public void run(String... args) throws Exception {
		User user = new User("samal", "admin");
		userReposistory.save(user);
		log.info("User inserted : "+ user);
	}
}
