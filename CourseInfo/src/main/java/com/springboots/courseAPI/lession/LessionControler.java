package com.springboots.courseAPI.lession;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboots.courseAPI.course.Course;
import com.springboots.courseAPI.topic.Topic;

@RestController
@RequestMapping("/topic/{topicId}/courses/{coursesid}")
public class LessionControler {
	
	@Autowired
	private LessionService lessionService;
	
	@RequestMapping("/lession")
	public List<Lession> getAllLession(@PathVariable String topicId,@PathVariable String coursesid){
		return lessionService.getAllLession(topicId,coursesid);
	}
	
	@RequestMapping("/lession/{id}")
	public Lession getLession(@PathVariable String id){
		return lessionService.getLession(id);
	}
	
	@RequestMapping(value = "/lession",method = RequestMethod.POST)
	public Lession addLession(@RequestBody Lession lession,@PathVariable String topicId,@PathVariable String coursesid) {
		Course course = new Course(coursesid,"","","");
		course.setTopic(new Topic(topicId,"",""));
		lession.setCourse(course);
		return lessionService.addLession(lession);
	}
	
	@RequestMapping(value = "/lession/{id}",method = RequestMethod.PUT)
	public Lession updateLession(@RequestBody Lession lession,@PathVariable String topicId,@PathVariable String coursesid,@PathVariable String id){
		Course course = new Course(coursesid,"","","");
		course.setTopic(new Topic(topicId,"",""));
		lession.setCourse(course);
		return lessionService.updateLession(lession,id);
	}
	
	@RequestMapping(value = "/lession/{id}",method = RequestMethod.DELETE)
	public void deleteLession(@PathVariable String id){
		lessionService.deleteLession(id);
	}
}
