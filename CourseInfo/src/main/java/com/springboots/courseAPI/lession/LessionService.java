package com.springboots.courseAPI.lession;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class LessionService {
	
	@Autowired
	private LessionRepository lessionRepository;
	
	public List<Lession> getAllLession(String topicId, String coursesid){
		List<Lession> lession = new ArrayList<Lession>();	
		lessionRepository.findByCourseId(coursesid).forEach(lession::add);
		return lession;
	}
	
	public Lession getLession(String id){
		//return topics.stream().filter(Topic -> Topic.getId().equalsIgnoreCase(id)).findFirst().get();
		return lessionRepository.findOne(id);
	}

	public Lession addLession(Lession topic) {
		return lessionRepository.save(topic);
		
	}

	public Lession updateLession(Lession topic,String id) {
		return lessionRepository.save(topic);
	}

	public void deleteLession(String id) {
		lessionRepository.delete(id);
	}
}
