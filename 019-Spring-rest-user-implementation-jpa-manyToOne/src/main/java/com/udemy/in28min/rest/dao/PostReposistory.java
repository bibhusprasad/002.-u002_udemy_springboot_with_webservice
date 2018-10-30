package com.udemy.in28min.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.in28min.rest.entity.Post;

@Repository
public interface PostReposistory extends JpaRepository<Post, Integer>{

}
