package com.sapient.entity;

public class UserProfile {
	
	private String userId;
	private String email;
	private String name;
	private String dob;
	
	public UserProfile()
	{
		
	}
	
	public UserProfile(String userId, String email,String name, String dob) {
		super();
		this.userId = userId;
		this.email = email;
		this.name = name;
		this.dob = dob;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}

}
