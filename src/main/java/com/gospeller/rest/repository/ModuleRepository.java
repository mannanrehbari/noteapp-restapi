package com.gospeller.rest.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gospeller.rest.models.Module;

public interface ModuleRepository extends MongoRepository<Module, String> {
	
	public List<Module> findByLangId(String langId);

}
