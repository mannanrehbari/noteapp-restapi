package com.gospeller.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gospeller.rest.models.Note;
import com.gospeller.rest.repository.NoteRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/note")
public class NoteController {
	
	@Autowired
	private NoteRepository noteRepository;
	
	@GetMapping(value = "/{mbId}", produces = "application/json")
	public List<Note> findByMbId(@PathVariable("mbId") String mbId){
		return noteRepository.findByMbId(mbId);
	}
	
	@PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
	public Note addNote(@RequestBody Note note) {
		return noteRepository.save(note);
	}
	
	@GetMapping(value = "/flipdone/{noteId}")
	public Note flipDone(@PathVariable("noteId") String noteId) {
		Optional<Note> noteOpt = noteRepository.findById(noteId);
		if(noteOpt.get() != null) {
			Note note = noteOpt.get();
			note.setDone(!note.isDone());
			return noteRepository.save(note);
		} else {
			return null;
		}
	}
	
	@GetMapping(value = "/delete/{noteId}")
	public boolean deleteNote(@PathVariable("noteId") String noteId){
		Optional<Note> note = this.noteRepository.findById(noteId);
		if (note.get() != null) {
			this.noteRepository.deleteById(noteId);
			return true;
		} else {
			return false;
		}
	} 

	
}
