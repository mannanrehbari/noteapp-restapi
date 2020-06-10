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

import com.gospeller.rest.models.Modblock;
import com.gospeller.rest.models.Module;
import com.gospeller.rest.repository.ModblockRepository;
import com.gospeller.rest.repository.NoteRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/modblock")
public class ModblockController {
	
	@Autowired
	private ModblockRepository modblockRepository;
	
	@Autowired
	private NoteRepository noteRepository;
	
	
	@PostMapping(value = "/add", produces="application/json", consumes="application/json")
	public Modblock addModblock(@RequestBody Modblock modblock) {
		return modblockRepository.save(modblock);
	}
	
	@GetMapping(value = "/delete/{mbId}")
	public boolean deleteNote(@PathVariable("mbId") String mbId){
		Optional<Modblock> mbOpt = this.modblockRepository.findById(mbId);
		if (mbOpt.get() != null) {
			this.modblockRepository.deleteById(mbId);
			return true;
		} else {
			return false;
		}
	}
	
	@GetMapping(value = "/{mbId}", produces="application/json")
	public Modblock getModblockById(@PathVariable("mbId") String mbId) {
		Optional<Modblock> mbOptional = modblockRepository.findById(mbId);
		if(mbOptional.get() != null) {
			Modblock retMb = mbOptional.get();
			retMb.setNotes(noteRepository.findByMbId(mbId));
			return retMb;
		} else {
			return null;
		}
	}
	
	@GetMapping(value="/all", produces="application/json")
	public List<Modblock> getModblocks(){
		return modblockRepository.findAll();
	}
	
	@GetMapping(value="/{langId}/{modId}", produces="application/json")
	public List<Modblock> getByModIdLangId(
			@PathVariable("langId")String langId, 
			@PathVariable("modId")String modId){
		return modblockRepository.findByModIdAndLangId(langId, modId);		
	}
	
	@PostMapping(value = "/status/flip", produces="application/json", consumes="application/json")
	public Modblock flipStatus(@RequestBody Modblock modblock) {
		return modblockRepository.save(modblock);
	}
	
	
}
