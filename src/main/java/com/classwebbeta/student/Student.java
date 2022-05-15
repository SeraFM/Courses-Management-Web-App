package com.classwebbeta.student;

import java.time.LocalDate;
import java.time.Year;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Student {

	// Database Table Fields
	@Id
    private Integer studentid;
    private String fullname;
	private String email;
	private Integer yearOfRegistration;
    private Integer yearOfStudies;
    private Integer syllabus;
    private Integer semester;
    private Integer courseAttending;
	private String projectGrade;
    private String examGrade;
	private String finalGrade;

	public Student(){}

	// Getters and Setters

	public Student(Integer studentid, String fullname, String email, Integer yearOfRegistration,
			Integer yearOfStudies, Integer syllabus, Integer semester, Integer courseAttending, String projectGrade,
			String examGrade, String finalGrade) {
		this.studentid = studentid;
		this.fullname = fullname;
		this.email = email;
		this.yearOfRegistration = yearOfRegistration;
		this.yearOfStudies = yearOfStudies;
		this.syllabus = syllabus;
		this.semester = semester;
		this.courseAttending = courseAttending;
		this.projectGrade = projectGrade;
		this.examGrade = examGrade;
		this.finalGrade = finalGrade;
	}

	public String getFinalGrade() {
		return finalGrade;
	}
	public void setFinalGrade(String finalGrade) {
		this.finalGrade = finalGrade;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	} 
	public Integer getCourseAttending() {
		return courseAttending;
	}
	public void setCourseAttending(Integer courseAttending) {
		this.courseAttending = courseAttending;
	}
	public Integer getStudentid() {
		return studentid;
	}
	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Integer getYearOfRegistration() {
		return yearOfRegistration;
	}
	public void setYearOfRegistration(Integer yearOfRegistration) {
		this.yearOfRegistration = yearOfRegistration;
	}
	public Integer getYearOfStudies() {
		yearOfStudies = Year.now().getValue() - yearOfRegistration;
		return yearOfStudies;
	}
	public void setYearOfStudies(Integer yearOfStudies) {
		yearOfStudies = Year.now().getValue() - yearOfRegistration;
		this.yearOfStudies = yearOfStudies;
	}
	public Integer getSyllabus() {
		syllabus = Year.now().getValue() - yearOfRegistration;
		return syllabus;
	}
	public void setSyllabus(Integer syllabus) {
		syllabus = Year.now().getValue() - yearOfRegistration;
		this.syllabus = syllabus;
	}
	public Integer getSemester() {
		LocalDate date = LocalDate.now();
		int month = date.getMonthValue();
		if (month >= 9 || month <= 1) {
			semester = (syllabus*2) - 1;
		}else {
			semester = syllabus*2;
		}
		return semester;
	}
	public void setSemester(Integer semester) {
		LocalDate date = LocalDate.now();
		int month = date.getMonthValue();
		if (month >= 9 || month <= 1) {
			semester = (syllabus*2) - 1;
			this.semester = semester;
		}else {
			semester = syllabus*2;
			this.semester = semester;
		}
	}
	public String getProjectGrade() {
		return projectGrade;
	}
	public void setProjectGrade(String projectGrade) {
		this.projectGrade = projectGrade;
	}
	public String getExamGrade() {
		return examGrade;
	}
	public void setExamGrade(String examGrade) {
		this.examGrade = examGrade;
	}

	@Override
	public String toString() {
		return "Student [courseAttending=" + courseAttending + ", email=" + email + ", examGrade=" + examGrade
				+ ", finalGrade=" + finalGrade + ", fullname=" + fullname + ", projectGrade="
				+ projectGrade + ", semester=" + semester + ", studentid=" + studentid + ", syllabus=" + syllabus
				+ ", yearOfRegistration=" + yearOfRegistration + ", yearOfStudies=" + yearOfStudies + "]";
	}
}
