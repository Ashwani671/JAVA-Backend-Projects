package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.AuthReqDTO;
import com.app.dto.AuthRespDTO;
import com.app.entities.Course;
import com.app.repository.CourseRepository;
@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		return courseRepo.findAll();
	}

	@Override
	public Course addCourseDeatils(Course transCourse) {
		// TODO Auto-generated method stub
		return courseRepo.save(transCourse);
	}

	@Override
	public String deleteCourseDetails(Long courseId) {
		// TODO Auto-generated method stub
		String msg="course not found!!";
		if(courseRepo.existsById(courseId)) {
			courseRepo.deleteById(courseId);
			msg="Course is deleted"+ courseId +"successfully";
		}
		return msg;
	}

	@Override
	public Course updateCourseDetails(Course detachCourse) {
		// TODO Auto-generated method stub
		return courseRepo.save(detachCourse);
	}

	@Override
	public Course getByCourseId(Long courseId) {
		// TODO Auto-generated method stub
		return courseRepo.findById(courseId).orElseThrow(()->new ResourceNotFoundException("Can't find Course. Invalid id!!"));
	}

	@Override
	public AuthRespDTO authenticatecourse(AuthReqDTO request) {
		// TODO Auto-generated method stub
		Course course = courseRepo.findByEmailAndPassword(request.getEmail(),request.getPassword()).orElseThrow(()->new ResourceNotFoundException("invalid Credentials"));
		AuthRespDTO authrespdto=mapper.map(course, AuthRespDTO.class);
		
		
		
		
		return authrespdto;
	}

}
