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

	// Getters and Setters
	
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseAttending == null) ? 0 : courseAttending.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((examGrade == null) ? 0 : examGrade.hashCode());
		result = prime * result + ((finalGrade == null) ? 0 : finalGrade.hashCode());
		result = prime * result + ((fullname == null) ? 0 : fullname.hashCode());
		result = prime * result + ((projectGrade == null) ? 0 : projectGrade.hashCode());
		result = prime * result + ((semester == null) ? 0 : semester.hashCode());
		result = prime * result + ((studentid == null) ? 0 : studentid.hashCode());
		result = prime * result + ((syllabus == null) ? 0 : syllabus.hashCode());
		result = prime * result + ((yearOfRegistration == null) ? 0 : yearOfRegistration.hashCode());
		result = prime * result + ((yearOfStudies == null) ? 0 : yearOfStudies.hashCode());
		return result;
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
		if (courseAttending == null) {
			if (other.courseAttending != null)
				return false;
		} else if (!courseAttending.equals(other.courseAttending))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (examGrade == null) {
			if (other.examGrade != null)
				return false;
		} else if (!examGrade.equals(other.examGrade))
			return false;
		if (finalGrade == null) {
			if (other.finalGrade != null)
				return false;
		} else if (!finalGrade.equals(other.finalGrade))
			return false;
		if (fullname == null) {
			if (other.fullname != null)
				return false;
		} else if (!fullname.equals(other.fullname))
			return false;
		if (projectGrade == null) {
			if (other.projectGrade != null)
				return false;
		} else if (!projectGrade.equals(other.projectGrade))
			return false;
		if (semester == null) {
			if (other.semester != null)
				return false;
		} else if (!semester.equals(other.semester))
			return false;
		if (studentid == null) {
			if (other.studentid != null)
				return false;
		} else if (!studentid.equals(other.studentid))
			return false;
		if (syllabus == null) {
			if (other.syllabus != null)
				return false;
		} else if (!syllabus.equals(other.syllabus))
			return false;
		if (yearOfRegistration == null) {
			if (other.yearOfRegistration != null)
				return false;
		} else if (!yearOfRegistration.equals(other.yearOfRegistration))
			return false;
		if (yearOfStudies == null) {
			if (other.yearOfStudies != null)
				return false;
		} else if (!yearOfStudies.equals(other.yearOfStudies))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [courseAttending=" + courseAttending + ", email=" + email + ", examGrade=" + examGrade
				+ ", finalGrade=" + finalGrade + ", fullname=" + fullname + ", projectGrade=" + projectGrade
				+ ", semester=" + semester + ", studentid=" + studentid + ", syllabus=" + syllabus
				+ ", yearOfRegistration=" + yearOfRegistration + ", yearOfStudies=" + yearOfStudies + "]";
	}
	
}
