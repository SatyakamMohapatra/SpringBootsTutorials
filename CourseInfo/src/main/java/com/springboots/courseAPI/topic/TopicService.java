package com.springboots.courseAPI.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopic(){
		List<Topic> topics = new ArrayList<Topic>();	
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(String id){
		//return topics.stream().filter(Topic -> Topic.getId().equalsIgnoreCase(id)).findFirst().get();
		return topicRepository.findOne(id);
	}

	public Topic addTopic(Topic topic) {
		return topicRepository.save(topic);
		
	}

	public Topic updateTopic(Topic topic,String id) {
		return topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepository.delete(id);
	}
}
