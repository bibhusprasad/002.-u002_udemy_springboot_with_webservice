package com.udemy.in28min.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.udemy.in28min.bean.Course;
import com.udemy.in28min.delegate.CourseDetails;
import com.udemy.in28min.delegate.DeleteCourseDetailsRequest;
import com.udemy.in28min.delegate.DeleteCourseDetailsResponse;
import com.udemy.in28min.delegate.GetAllCourseDetailsRequest;
import com.udemy.in28min.delegate.GetAllCourseDetailsResponse;
import com.udemy.in28min.delegate.GetCourseDetailsRequest;
import com.udemy.in28min.delegate.GetCourseDetailsResponse;
import com.udemy.in28min.service.CourseDetailsService;
import com.udemy.in28min.service.CourseDetailsService.Status;

@Endpoint
public class CourseDetailsEndpoint {

	@Autowired
	private CourseDetailsService courseDetailsService;
	
	public void setCourseDetailsService(CourseDetailsService courseDetailsService) {
		this.courseDetailsService = courseDetailsService;
	}


	/**
	 * method
	 * 
	 * input --> GetCourseDetailsRequest
	 * 
	 * output --> GetCourseDetailsResponse
	 */
	
	@PayloadRoot(namespace="http://in28min.udemy.com/delegate", localPart="GetCourseDetailsRequest")
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(
			@RequestPayload GetCourseDetailsRequest request) {
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		Course course = courseDetailsService.findCourseById(request.getId());
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(course.getId());
		courseDetails.setName(course.getName());
		courseDetails.setDescription(course.getDescription());
		response.setCourseDetails(courseDetails);
		return response;
	}
	
	@PayloadRoot(namespace="http://in28min.udemy.com/delegate", localPart="GetAllCourseDetailsRequest")
	@ResponsePayload
	public GetAllCourseDetailsResponse processAllCourseDetailsRequest(
			@RequestPayload GetAllCourseDetailsRequest request) {
		GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
		List<Course> courseList = courseDetailsService.findAllCourse();

		for (Course course : courseList) {
			CourseDetails courseDetails = new CourseDetails();
			courseDetails.setId(course.getId());
			courseDetails.setName(course.getName());
			courseDetails.setDescription(course.getDescription());
			response.getCourseDetails().add(courseDetails);
		}
		return response;
	}
	
	@PayloadRoot(namespace="http://in28min.udemy.com/delegate", localPart="DeleteCourseDetailsRequest")
	@ResponsePayload
	public DeleteCourseDetailsResponse processDeleteCourseDetailsRequest(
			@RequestPayload DeleteCourseDetailsRequest request) {
		DeleteCourseDetailsResponse response = new DeleteCourseDetailsResponse();
		Status status = courseDetailsService.deleteCourse(request.getId());

		response.setStatus(prepareStatusMessage(status));
		return response;
	}


	private com.udemy.in28min.delegate.Status prepareStatusMessage(Status status) {
		if(status == Status.FAILURE)
			return com.udemy.in28min.delegate.Status.FAILURE;
		return com.udemy.in28min.delegate.Status.SUCCESS;
	}
	
}
