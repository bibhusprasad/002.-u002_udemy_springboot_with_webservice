package com.udemy.in28min.rest.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.udemy.in28min.rest.controller.User;

@Repository
public class UserDAO {

	private static List<User> userList = new ArrayList<>();
	private static int userCount = 3;
	
	static {
		User user1 = new User(1, "bibhu", new Date());
		User user2 = new User(2, "alok", new Date());
		User user3 = new User(3, "asu", new Date());
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
	}
	
	public List<User> findAll(){
		return userList;
	}
	
	public User saveUser(User user) {
		if(user.getId() == 0) {
			user.setId(++userCount);
		}
		userList.add(user);
		return user;
	}
	
	public User findOneUser(int id) {
		for (User user : userList) {
			if(id == user.getId())
				return user;
		}
		return null;
	}
	
	public boolean deleteUser(int id) {
		Iterator<User> iterator = userList.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if(id == user.getId()) {
				userList.remove(user);
				return true;
			}
		}
		return false;
	}

}
