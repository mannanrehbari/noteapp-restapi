package com.gospeller.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gospeller.rest.models.Language;

public interface LanguageRepository extends MongoRepository<Language, String>{

}
