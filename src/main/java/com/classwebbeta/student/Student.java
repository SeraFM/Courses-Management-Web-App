package com.classwebbeta.student;

import java.time.LocalDate;
import java.time.Year;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentid;
    private String fullname;
    private String email;
	private Integer yearOfRegistration;
    private Integer yearOfStudies;
    private Integer syllabus;
    private Integer semester;
    private Double projectGrade;
    private Double examGrade;
    private Integer courseAttending;
    
    public Student() {}
  
	public Student(Integer studentid, String fullname, String email, Integer yearOfRegistration, Integer yearOfStudies, Integer syllabus, Integer semester, Double projectGrade, Double examGrade, Integer courseAttending) {
		this.studentid = studentid;
		this.fullname = fullname;
		this.email = email;
		this.yearOfRegistration = yearOfRegistration;
		this.yearOfStudies = yearOfStudies;
		this.syllabus = syllabus;
		this.semester = semester;
		this.projectGrade = projectGrade;
		this.examGrade = examGrade;
		this.courseAttending = courseAttending;
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
		setYearOfStudies(0);
		return yearOfStudies;
	}
	public void setYearOfStudies(Integer yearOfStudies) {
		yearOfStudies = Year.now().getValue() - yearOfRegistration;
		this.yearOfStudies = yearOfStudies;
	}
	public Integer getSyllabus() {
		setSyllabus(0);
		return syllabus;
	}
	public void setSyllabus(Integer syllabus) {
		syllabus = Year.now().getValue() - yearOfRegistration;
		this.syllabus = syllabus;
	}
	public Integer getSemester() {
		setSemester(0);
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
	public Double getProjectGrade() {
		return projectGrade;
	}
	public void setProjectGrade(Double projectGrade) {
		this.projectGrade = projectGrade;
	}
	public Double getExamGrade() {
		return examGrade;
	}
	public void setExamGrade(Double examGrade) {
		this.examGrade = examGrade;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(courseAttending, email, examGrade, fullname, projectGrade, semester, studentid, syllabus,
				yearOfRegistration, yearOfStudies);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(courseAttending, other.courseAttending) && Objects.equals(email, other.email)
				&& Objects.equals(examGrade, other.examGrade) && Objects.equals(fullname, other.fullname)
				&& Objects.equals(projectGrade, other.projectGrade) && Objects.equals(semester, other.semester)
				&& Objects.equals(studentid, other.studentid) && Objects.equals(syllabus, other.syllabus)
				&& Objects.equals(yearOfRegistration, other.yearOfRegistration)
				&& Objects.equals(yearOfStudies, other.yearOfStudies);
	}
	
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", fullname=" + fullname + ", email=" + email
				+ ", yearOfRegistration=" + yearOfRegistration + ", yearOfStudies=" + yearOfStudies + ", syllabus="
				+ syllabus + ", semester=" + semester + ", projectGrade=" + projectGrade + ", examGrade=" + examGrade
				+ ", courseAttending=" + courseAttending + "]";
	}
}
