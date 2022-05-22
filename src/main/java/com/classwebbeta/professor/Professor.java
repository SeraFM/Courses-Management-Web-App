package com.classwebbeta.professor;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table
public class Professor {

	// Table Fields
	@Id
    private Integer professorid;
    private String professorName;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;

	// Constructor
	public Professor(Integer professorid, String professorName, String username, String password, String email,
			String phoneNumber) {
		this.professorid = professorid;
		this.professorName = professorName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	// Default Constructor
	public Professor(){}
	
	// Getters and Setters
	public Integer getProfessorid() {
		return professorid;
	}
	public void setProfessorid(Integer professorid) {
		this.professorid = professorid;
	}
	public String getProfessorName() {
		return professorName;
	}
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    
}
