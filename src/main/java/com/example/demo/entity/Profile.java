package com.example.demo.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This class represent profile in the system
 * 
 * @author j.a.vasconcelos
 *
 */
@Document
public class Profile implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String name;

	public Profile() {
	}

	public Profile(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Profile(String name) {
		super();
		this.name = name;
	}

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
}