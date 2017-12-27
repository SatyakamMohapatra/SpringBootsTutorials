package com.springboots.courseAPI.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourse(String topicId){
		List<Course> topics = new ArrayList<Course>();	
		courseRepository.findByTopicId(topicId).forEach(topics::add);
		return topics;
	}
	
	public Course getCourse(String id){
		//return topics.stream().filter(Topic -> Topic.getId().equalsIgnoreCase(id)).findFirst().get();
		return courseRepository.findOne(id);
	}

	public Course addCourse(Course topic) {
		return courseRepository.save(topic);
		
	}

	public Course updateCourse(Course topic) {
		return courseRepository.save(topic);
	}

	public void deleteCourse(String id) {
		courseRepository.delete(id);
	}
}
