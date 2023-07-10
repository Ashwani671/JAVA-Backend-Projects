package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.AuthReqDTO;
import com.app.entities.Course;
import com.app.service.CourseService;



@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	public CourseController() {
		// TODO Auto-generated constructor stub
		System.out.println("in ctor of course"+getClass());
	}
	
	@GetMapping
	public List<Course> listCourses(){
		System.out.println("in course list");
		return courseService.getAllCourse();
	}
	
	@GetMapping("/{courseId}")
	
	public ResponseEntity<?> getCourse(@PathVariable Long courseId){
		return new ResponseEntity<>(courseService.getByCourseId(courseId), HttpStatus.OK);
	}
	
//	@PostMapping
//	public ResponseEntity<?> addCourse(@RequestBody Course transcourse){
//		return new ResponseEntity<>(courseService.addCourseDeatils(transcourse), HttpStatus.CREATED);
//	
	
	@PostMapping
	public Course getCourse(@RequestBody Course transCourse) {
		return courseService.addCourseDeatils(transCourse);
	}
	
	@PutMapping
	public Course updateCourse(@RequestBody Course detachCourse) {
		return courseService.updateCourseDetails(detachCourse);
	}
	@DeleteMapping("/{courseId}")
	public ApiResponse deleteCourse(@PathVariable Long courseId) {
		return new ApiResponse(courseService.deleteCourseDetails(courseId));
	}
	
	@PostMapping("/signin")
	
	public ResponseEntity<?> authenticateCourse(@RequestBody @Valid AuthReqDTO request){
		return new ResponseEntity<>(courseService.authenticatecourse(request), HttpStatus.ACCEPTED);
	}

}
