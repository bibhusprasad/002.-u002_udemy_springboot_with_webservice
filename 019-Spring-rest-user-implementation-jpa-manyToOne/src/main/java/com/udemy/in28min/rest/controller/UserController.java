package com.udemy.in28min.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.in28min.rest.dao.PostReposistory;
import com.udemy.in28min.rest.dao.UserReposistory;
import com.udemy.in28min.rest.entity.Post;
import com.udemy.in28min.rest.entity.User;

@RestController
public class UserController {
	
	@Autowired
	private UserReposistory userReposistory;
	
	@Autowired
	private PostReposistory postReposistory;
	
	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		return userReposistory.save(user);
	}
	
	@GetMapping("/users")
	public List<User> getAllUserDetails() {
		return userReposistory.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> findAUser(@PathVariable int id) {
		return userReposistory.findById(id);
	}
	
	@DeleteMapping("/users/{id}")
	public int deleteUser(@PathVariable int id) {
		userReposistory.deleteById(id);
		return id;
	}
	
	@GetMapping("/users/{id}/posts")
	public List<Post> getAllUserPosts(@PathVariable int id) {
		Optional<User> user = userReposistory.findById(id);
		return user.get().getPosts();
	}
	
	@PostMapping("/users/{id}/posts")
	public Post saveUserPost(@PathVariable int id, @RequestBody Post post) {
		Optional<User> userOptional = userReposistory.findById(id);
		User user = userOptional.get();
		post.setUser(user);
		return postReposistory.save(post);
	}
}
