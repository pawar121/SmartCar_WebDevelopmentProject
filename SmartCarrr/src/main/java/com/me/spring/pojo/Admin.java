package com.me.spring.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin")


public class Admin {


	@Id
	@GeneratedValue
	@Column(name = "adminID", unique=true, nullable = false)
	private long adminID;
	
	
	@Column(name="Role")
	private String role;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;

	public Admin(){
		
	}
	
	
public Admin(long admin_ID,String role,String username, String passord)
	
	{
		this.adminID = admin_ID;
		this.username = username;
		this.password = password;
		this.role=role;
	}


   
	public String getRole() {
	return role;
    }


	public void setRole(String role) {
		this.role = role;
	}


	public long getAdminID() {
		return adminID;
	}

	public void setAdminID(long adminID) {
		this.adminID = adminID;
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
