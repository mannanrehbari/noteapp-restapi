package com.gospeller.rest.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("notes")
public class Note {
	
	
	@Id
	private String noteId;
	
	private String mbId;
	private String modId;
	private String langId;
	
	private String noteTag;
	private String noteDetail;
	
	private boolean done;
	
	private String adder;
	
	public Note() {
	}
	
	public Note(String noteId, String mbId, String modId, String langId, String noteTag, String noteDetail, boolean done, String adder) {
		this.noteId = noteId;
		this.mbId = mbId;
		this.modId = modId;
		this.langId = langId;
		this.noteTag = noteTag;
		this.noteDetail = noteDetail;
		this.done = done;
		this.adder = adder;
	}
	
	public String getAdder() {
		return adder;
	}

	public void setAdder(String adder) {
		this.adder = adder;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public String getNoteId() {
		return noteId;
	}
	public void setNoteId(String noteId) {
		this.noteId = noteId;
	}
	public String getMbId() {
		return mbId;
	}
	public void setMbId(String mbId) {
		this.mbId = mbId;
	}
	public String getModId() {
		return modId;
	}
	public void setModId(String modId) {
		this.modId = modId;
	}
	public String getLangId() {
		return langId;
	}
	public void setLangId(String langId) {
		this.langId = langId;
	}
	public String getNoteTag() {
		return noteTag;
	}
	public void setNoteTag(String noteTag) {
		this.noteTag = noteTag;
	}
	public String getNoteDetail() {
		return noteDetail;
	}
	public void setNoteDetail(String noteDetail) {
		this.noteDetail = noteDetail;
	}
	
	
	
	

}
