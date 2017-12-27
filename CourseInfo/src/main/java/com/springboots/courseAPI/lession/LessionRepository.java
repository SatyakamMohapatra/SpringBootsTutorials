package com.springboots.courseAPI.lession;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LessionRepository extends CrudRepository<Lession, String>{

	public List<Lession> findByCourseId(String courseId);
}
