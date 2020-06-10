package com.gospeller.rest.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("modblocks")
public class Modblock {

	@Id
	private String mbId;
	
	private String modId;
	private String langId;


	private boolean status;
	
	private String mbName;
	
	private String adder;
	
	@Transient
	private List<Note> notes;

	public Modblock() {
	}

	public Modblock(String mbId, String modId, String langId, boolean status, String mbName, String adder) {
		super();
		this.mbId = mbId;
		this.modId = modId;
		this.langId = langId;
		this.status = status;
		this.mbName = mbName;
		this.adder = adder;
	}

	public String getAdder() {
		return adder;
	}

	public void setAdder(String adder) {
		this.adder = adder;
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
	

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMbName() {
		return mbName;
	}

	public void setMbName(String mbName) {
		this.mbName = mbName;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

}
