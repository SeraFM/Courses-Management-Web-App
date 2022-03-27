package com.classwebbeta.course;

import javax.persistence.*; 
import java.util.Objects;

@Entity
@Table
public class Course {

    // Creating table fields

	@Id
    private Integer courseid;

    private String name;
    private Integer year;
    private Integer syllabus;
    private Integer semester;
    private Integer attendance;
    private Integer professorid;
    private Double examPR;
    private Double projectPR;

    public Integer getProfessorid() {
		return professorid;
	}

	public void setProfessorid(Integer professorid) {
		this.professorid = professorid;
	}

    @Override
	public int hashCode() {
		return Objects.hash(attendance, courseid, examPR, name, professorid, projectPR, semester, syllabus, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(attendance, other.attendance) && Objects.equals(courseid, other.courseid)
				&& Objects.equals(examPR, other.examPR) && Objects.equals(name, other.name)
				&& Objects.equals(professorid, other.professorid) && Objects.equals(projectPR, other.projectPR)
				&& Objects.equals(semester, other.semester) && Objects.equals(syllabus, other.syllabus)
				&& Objects.equals(year, other.year);
	}

    // Getters and Setters

	public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(Integer syllabus) {
        this.syllabus = syllabus;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }
    
    public Double getExamPR() {
		return examPR;
	}

	public void setExamPR(Double examPR) {
		this.examPR = examPR;
	}

	public Double getProjectPR() {
        projectPR = 1 - examPR;
		return projectPR;
	}

	public void setProjectPR(Double examPR) {
		this.projectPR = 1 - examPR;
	}

	@Override
	public String toString() {
		return "CoursesModel [courseid=" + courseid + ", name=" + name + ", year=" + year + ", syllabus=" + syllabus
				+ ", semester=" + semester + ", attendance=" + attendance + ", professorid=" + professorid + ", examPR="
				+ examPR + ", projectPR=" + projectPR + "]";
	}
	
}