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

import com.gospeller.rest.models.Module;
import com.gospeller.rest.models.Note;
import com.gospeller.rest.repository.ModblockRepository;
import com.gospeller.rest.repository.ModuleRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/module", produces="application/json")
public class ModuleController {
	
	@Autowired
	private ModuleRepository moduleRepository;
	
	@Autowired
	private ModblockRepository modblockRepository;
	
	
	@PostMapping(value="/add" , produces="application/json", consumes="application/json")
	public Module addModule(@RequestBody Module module) {
		return moduleRepository.save(module);
	}
	
	@GetMapping(value = "/delete/{modId}")
	public boolean deleteNote(@PathVariable("modId") String modId){
		Optional<Module> mod = this.moduleRepository.findById(modId);
		if (mod.get() != null) {
			this.moduleRepository.deleteById(modId);
			return true;
		} else {
			return false;
		}
	}
	
	@GetMapping(value = "/lang/{langId}", produces="application/json")
	public List<Module> getModuleByLangId(@PathVariable("langId") String langId){
		List<Module> modules = moduleRepository.findByLangId(langId);
		for(Module module: modules) {
			module.setModBlocks(modblockRepository.findByModIdAndLangId(langId, module.getModId()));
		}
		return modules;
	}
	
	@GetMapping(value = "/voteUp/{modId}", produces="application/json")
	public Module voteUp(@PathVariable("modId") String modId) {
		Optional<Module> optModule = moduleRepository.findById(modId);
		if(optModule.get() != null) {
			Module modToVote = optModule.get();
			modToVote.voteUp();
			return moduleRepository.save(modToVote);
		} else {
			return null;
		}	
	}
	
	@GetMapping(value = "/voteDown/{modId}", produces="application/json")
	public Module voteDown(@PathVariable("modId") String modId) {
		Optional<Module> optModule = moduleRepository.findById(modId);
		if(optModule.get() != null) {
			Module modToVote = optModule.get();
			modToVote.voteDown();
			return moduleRepository.save(modToVote);
		} else {
			return null;
		}	
	}
	
	
	
	

}
