package com.classwebbeta.professor;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table
public class Professor {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer professorid;
    private String professorName;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    
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
	@Override
	public int hashCode() {
		return Objects.hash(email, password, phoneNumber, professorid, professorName, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(professorid, other.professorid)
				&& Objects.equals(professorName, other.professorName) && Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "ProfessorModel [professorID=" + professorid + ", professorName=" + professorName + ", username="
				+ username + ", password=********" + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
    
}
