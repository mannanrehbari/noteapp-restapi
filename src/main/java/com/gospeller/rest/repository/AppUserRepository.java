package com.gospeller.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gospeller.rest.models.AppUser;

public interface AppUserRepository extends MongoRepository<AppUser, String>{
	

}
