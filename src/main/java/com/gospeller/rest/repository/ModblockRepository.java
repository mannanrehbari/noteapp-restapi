package com.gospeller.rest.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.gospeller.rest.models.Modblock;

public interface ModblockRepository extends MongoRepository<Modblock, String>{
	
	@Query("{ 'langId': ?0, 'modId': ?1}")
	public List<Modblock> findByModIdAndLangId(String langId, String modId);
	
	@Query("{ 'mbId':?0, 'modId': ?1, 'langId': ?2 }")
	public Modblock findByMbIdAndModIdAndLangId(String mbId, String modId, String langId);

}
