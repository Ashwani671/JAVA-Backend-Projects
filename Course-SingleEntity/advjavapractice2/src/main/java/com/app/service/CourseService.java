package com.app.service;

import java.util.List;

import com.app.dto.AuthReqDTO;
import com.app.dto.AuthRespDTO;
import com.app.entities.Course;

public interface CourseService {
	
	List<Course> getAllCourse();
	Course addCourseDeatils(Course transCourse);
	String deleteCourseDetails(Long courseId);
	Course updateCourseDetails(Course detachCourse);
	Course getByCourseId(Long courseId);
	
	AuthRespDTO authenticatecourse(AuthReqDTO request);
	
	
	

}
