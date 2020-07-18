package com.jpa.example.corseapidata.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{

//public List<Course> findByName(String name);
//public List<Course> findByDescription(String description);

public List<Course> findByTopicId(String topicId);// define method as courseSErvice. It is an interface so you can create method here.


	
}
