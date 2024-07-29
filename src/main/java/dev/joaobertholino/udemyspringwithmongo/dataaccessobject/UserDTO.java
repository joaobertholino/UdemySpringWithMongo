package dev.joaobertholino.udemyspringwithmongo.dataaccessobject;

import dev.joaobertholino.udemyspringwithmongo.domain.User;

import java.io.Serializable;

public class UserDTO implements Serializable {
	private String name;
	private String email;

	public UserDTO() {
	}

	public UserDTO(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
