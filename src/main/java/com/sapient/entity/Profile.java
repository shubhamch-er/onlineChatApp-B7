package com.sapient.entity;

import java.time.LocalDate;

public class Profile {
	private String email;
	private String password;
	private String name;
	private LocalDate dob;

	public Profile() {

	}

	public Profile(String email, String password, String name, LocalDate dob) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "UpdateProfile [email=" + email + ", password=" + password + ", name=" + name + ", dob=" + dob + "]";
	}

}
