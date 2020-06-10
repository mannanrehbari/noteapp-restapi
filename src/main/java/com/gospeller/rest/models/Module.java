package com.gospeller.rest.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("modules")
public class Module {
	
	@Id
	private String modId;
	private String langId;

	private String modName;
	private String modHeader;
	private String modDescription;
	
	private Long modVotes;
	
	private String adder;
	
	@Transient
	private List<Modblock> modBlocks;

	public Module() {	
	}

	public Module(String modId, String langId, String modName, String modHeader, String modDescription, Long modVotes, String adder) {
		this.modId = modId;
		this.langId = langId;
		this.modName = modName;
		this.modHeader = modHeader;
		this.modDescription = modDescription;
		this.modVotes = modVotes;
		this.adder = adder;
	}
	
	public String getAdder() {
		return adder;
	}

	public void setAdder(String adder) {
		this.adder = adder;
	}

	public Long voteUp() {
		return this.modVotes++;		
	}
	public Long voteDown() {
		return this.modVotes--;
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

	public String getModName() {
		return modName;
	}

	public void setModName(String modName) {
		this.modName = modName;
	}

	public String getModHeader() {
		return modHeader;
	}

	public void setModHeader(String modHeader) {
		this.modHeader = modHeader;
	}

	public String getModDescription() {
		return modDescription;
	}

	public void setModDescription(String modDescription) {
		this.modDescription = modDescription;
	}

	public Long getModVotes() {
		return modVotes;
	}

	public void setModVotes(Long modVotes) {
		this.modVotes = modVotes;
	}
	
	public List<Modblock> getModBlocks() {
		return modBlocks;
	}

	public void setModBlocks(List<Modblock> modBlocks) {
		this.modBlocks = modBlocks;
	}
	

}
