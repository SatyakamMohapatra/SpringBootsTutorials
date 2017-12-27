package com.springboots.courseAPI.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboots.courseAPI.topic.Topic;

@RestController
@RequestMapping("/topic/{topicId}")
public class CourseControler {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/courses")
	public List<Course> getAllCourse(@PathVariable String topicId){
		return courseService.getAllCourse(topicId);
	}
	
	@RequestMapping("/courses/{id}")
	public Course getCourse(@PathVariable String id){
		return courseService.getCourse(id);
	}
	
	@RequestMapping(value = "/courses",method = RequestMethod.POST)
	public Course addCourse(@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		return courseService.addCourse(course);
	}
	
	@RequestMapping(value = "/courses/{id}",method = RequestMethod.PUT)
	public Course updateCourse(@RequestBody Course course,@PathVariable String topicId,@PathVariable String id){
		course.setTopic(new Topic(topicId,"",""));
		return courseService.updateCourse(course);
	}
	
	@RequestMapping(value = "/courses/{id}",method = RequestMethod.DELETE)
	public void deleteCourse(@PathVariable String id){
		courseService.deleteCourse(id);
	}
}
