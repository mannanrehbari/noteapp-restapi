package com.gospeller.rest.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.gospeller.rest.models.Note;

public interface NoteRepository extends MongoRepository<Note, String>{
	
	@Query("{'mbId': ?0}")
	public List<Note> findByMbId(String mbId);

}
