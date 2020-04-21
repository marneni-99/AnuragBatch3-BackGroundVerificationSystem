package com.capgemini.backgroundverification.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Logindata")
public class Logindata {
	@Id
	private int userId;
	@NotBlank(message="username cannot be empty")
	private String userName;
	@NotBlank(message="usertype cannot be empty")
	private String userType;
	@Size(min=8, max=20, message="password must be minimum 8 characters")
	private String userPassword;
	@Min(value=10)
	private long userPhoneno;
	@Email(message="enter proper email id")
	private String userEmail;
	
	
	public Logindata() {
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public long getUserPhoneno() {
		return userPhoneno;
	}
	public void setUserPhoneno(long userPhoneno) {
		this.userPhoneno = userPhoneno;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	

	
}
