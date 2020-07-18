package com.jpa.example.corseapidata.course;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // it will register it when the class will be loaded. Its a stereotype
			// annotation.
public class CourseService {

	@Autowired
	private CourseRepository courseRepository; // creation of JPA .. so created
												// one interface and autowired
												// it.

	public List<Course> getAllCourses(String topicId) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}

	public Optional<Course> getCourseById(String id) {
		return courseRepository.findById(id);
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);

	}

}