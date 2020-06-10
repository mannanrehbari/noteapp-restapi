package com.gospeller.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gospeller.rest.models.Language;
import com.gospeller.rest.repository.LanguageRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping( value = "/language")
public class LanguageController {
	
	@Autowired
	private LanguageRepository languageRepository;
	
	@PostMapping(value = "/add", produces = "application/json", consumes="application/json")
	public Language addLanguage(@RequestBody Language language) {
		languageRepository.save(language);
		return languageRepository.save(language);
	}
	
	@GetMapping(value="/all", produces="application/json")
	public List<Language> getLanguages(){
		return languageRepository.findAll();
	}
	
	@GetMapping(value = "/delete/{id}")
	public boolean deleteLanguage(@PathVariable("id") String id) {
		Optional<Language> langOpt = languageRepository.findById(id);
		if(langOpt.get() != null) {
			this.languageRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
	@GetMapping(value="/voteup/{id}")
	public Language voteUp(@PathVariable("id") String id) {
		Optional<Language> lang = languageRepository.findById(id);
		if(lang.get() != null) {
			Language langVote = lang.get();
			langVote.voteUp();
			return languageRepository.save(langVote);
		} else {
			return null;
		}
	}
	
	@GetMapping(value="/votedown/{id}")
	public Language voteDown(@PathVariable("id") String id) {
		Optional<Language> lang = languageRepository.findById(id);
		if(lang.get() != null) {
			Language langVote = lang.get();
			langVote.voteDown();
			return languageRepository.save(langVote);
		} else {
			return null;
		}
	}
	

	

}
