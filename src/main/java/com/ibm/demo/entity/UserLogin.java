package com.ibm.demo.entity;

import javax.annotation.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserInfo")
@ManagedBean
public class UserLogin {
	@Id
	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "passwd", nullable = false)
	private String password;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "fullName", nullable = false)
	private String name;

	public UserLogin() {
		// Auto-generated constructor stub
	}

	public UserLogin(String username, String password, String captcha, String email, String name) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
