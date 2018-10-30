package com.udemy.in28min.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.udemy.in28min.bean.Course;
import com.udemy.in28min.exception.EnhancedException;

@Component
public class CourseDetailsService {
	
	private static List<Course> courseList = new ArrayList<>();
	
	static {
		Course course1 = new Course(1, "c", "all about c");
		Course course2 = new Course(2, "c++", "all about c++");
		Course course3 = new Course(3, "java", "all about java");
		Course course4 = new Course(4, "php", "all about php");
		
		courseList.add(course1);
		courseList.add(course2);
		courseList.add(course3);
		courseList.add(course4);
	}
	
	public Course findCourseById(int id) {
		for (Course course : courseList) {
			if(course.getId() == id) {
				return course;
			}
		}
		return null;
	}
	
	public List<Course> findAllCourse(){
		return courseList;
	}
	
	public Status deleteCourse(int id) {
		if(1 == id) {
			throw new EnhancedException("Can not delete this record.");
		}
		Iterator<Course> iterator = courseList.iterator();
		
		while(iterator.hasNext()) {
			Course course = iterator.next();
			if(course.getId() == id) {
				iterator.remove();
				return Status.SUCCESS;
			}
		}
		return Status.FAILURE;
	}
	
	public enum Status{
		SUCCESS, FAILURE;
	}
	

}
