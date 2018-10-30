package com.udemy.in28min.rest.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.in28min.rest.entity.User;

public interface UserReposistory extends JpaRepository<User, Long>{

}
