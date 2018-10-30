package com.udemy.in28min.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.in28min.rest.entity.User;

@Repository
public interface UserReposistory extends JpaRepository<User, Integer>{

}
