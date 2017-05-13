package com.me.spring.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Customer")
public class Customer {

	Customer(){
		
	}
	
	public Customer(String role, String userName, String password, String email, long phoneno){
		
		this.userName=userName;
		this.password=password;
		this.email=email;
		this.phoneno=phoneno;
		this.role=role;
		
	}
	
	
	@Id @GeneratedValue
	@Column(name="userid", unique = true, nullable = false)
    private long userid;
	
	@Column(name="Role")
	private String role;
	
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="email")
	private String email;
	
	@Column(name="Phoneno")
	private long phoneno;
	

	public long getUserid() {
	return userid;
	}
  
	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
