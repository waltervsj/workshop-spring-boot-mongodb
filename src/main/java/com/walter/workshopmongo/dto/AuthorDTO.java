package com.walter.workshopmongo.dto;

import java.io.Serializable;

import com.walter.workshopmongo.domain.User;

public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
 
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AuthorDTO(User author) {
		this.id = author.getId();
		this.name = author.getName();
	}

}
