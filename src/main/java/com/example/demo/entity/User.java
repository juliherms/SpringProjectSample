package com.example.demo.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.dto.UserDTO;

/**
 * this class represent user
 * @author j.a.vasconcelos
 *
 */
@Document("users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	
	private String email;
	private boolean active;
	
	public User() {}
	
	public User(UserDTO userDTO) {
		this.id = userDTO.getId();
		this.firstName = userDTO.getFirstName();
		this.lastName = userDTO.getLastName();
		this.email = userDTO.getEmail();
	}
	
	public User(String firsName, String lastName, String email, boolean active) {
		this.firstName = firsName;
		this.lastName = lastName;
		this.email = email;
		this.active = active;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
