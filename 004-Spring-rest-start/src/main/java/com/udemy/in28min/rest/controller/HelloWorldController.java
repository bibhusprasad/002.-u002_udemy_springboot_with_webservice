package com.udemy.in28min.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping(path = "/hello-world")
	public String getHelloWorld() {
		return "Hello User !!";
	}
	
	@GetMapping(path = "/hello-world-bean/{name}")
	public HelloWorld getHelloWorldBean(@PathVariable String name) {
		return new HelloWorld("Hello Bean user !! "+ name);
	}
}
