package com.gospeller.rest.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("language")
public class Language {
	
	@Id
	private String id;
	
	private String details;
	private String name;
	private String header;

	private Long votes;
	
	private String adder;
	
	public Language() {
	}

	public Language(String id, String details, String name, String header, Long votes, String adder) {
		this.id = id;
		this.details = details;
		this.name = name;
		this.header = header;
		this.votes = votes;
		this.adder = adder;
	}
	
	public String getAdder() {
		return adder;
	}

	public void setAdder(String adder) {
		this.adder = adder;
	}

	public Long voteUp() {
		return this.votes++;
	}
	public Long voteDown() {
		return this.votes--;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public Long getVotes() {
		return votes;
	}

	public void setVotes(Long votes) {
		this.votes = votes;
	}

	@Override
	public String toString() {
		return "Language [id=" + id + ", details=" + details + ", name=" + name + ", header=" + header + ", votes="
				+ votes + "]";
	}
	
	
	
	
	
	

}
