package com.udemy.in28min.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.udemy.in28min.rest.entity.User;
import com.udemy.in28min.rest.service.UserDAOService;

@Component
public class UserCommandLineRunner implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);
	
	@Autowired
	private UserDAOService userDAOService;

	@Override
	public void run(String... args) throws Exception {
		User user = new User("bibhu", "admin");
		long id = userDAOService.insert(user);
		log.info("Inserted ID: "+id);
	}
}
