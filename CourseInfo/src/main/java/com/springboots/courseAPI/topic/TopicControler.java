package com.springboots.courseAPI.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicControler {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topic")
	public List<Topic> getAllTopic(){
		return topicService.getAllTopic();
	}
	
	@RequestMapping("/topic/{id}")
	public Topic getTopic(@PathVariable String id){
		return topicService.getTopic(id);
	}
	
	@RequestMapping(value = "/topic",method = RequestMethod.POST)
	public Topic addTopic(@RequestBody Topic topic) {
		return topicService.addTopic(topic);
	}
	
	@RequestMapping(value = "/topic/{id}",method = RequestMethod.PUT)
	public Topic updateTopic(@RequestBody Topic topic,@PathVariable String id){
		return topicService.updateTopic(topic,id);
	}
	
	@RequestMapping(value = "/topic/{id}",method = RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id){
		topicService.deleteTopic(id);
	}
}
