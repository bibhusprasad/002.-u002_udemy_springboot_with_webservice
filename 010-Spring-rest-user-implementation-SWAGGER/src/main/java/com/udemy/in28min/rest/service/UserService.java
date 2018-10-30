package com.udemy.in28min.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.in28min.rest.controller.User;
import com.udemy.in28min.rest.dao.UserDAO;
import com.udemy.in28min.rest.exception.UserNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public List<User> findAllService(){
		return userDAO.findAll();
	}
	
	public User saveUserService(User user) {
		return userDAO.saveUser(user);
	}
	
	public User findOneUserService(int id) {
		User user = userDAO.findOneUser(id);
		if(null == user) {
			throw new UserNotFoundException("User record is not present.");
		}
		return user;
	}
	
	public String deleteUserService(int id) {
		if(userDAO.deleteUser(id)) {
			return "User Deleted.";
		}else {
			return "User not found.";
		}
	}

}
