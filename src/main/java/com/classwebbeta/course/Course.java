package com.classwebbeta.course;

import javax.persistence.*; 

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
    private Integer professorid;
    private Integer examPR;
    private Integer projectPR;

    // Getters and Setters
    public Integer getProfessorid() {
		return professorid;
	}

	public void setProfessorid(Integer professorid) {
		this.professorid = professorid;
	}

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
    
    public Integer getExamPR() {
		return examPR;
	}

	public void setExamPR(Integer examPR) {
		this.examPR = examPR;
	}

	public Integer getProjectPR() {
		return projectPR;
	}

	public void setProjectPR(Integer examPR) {
		this.projectPR = 100 - examPR;;
	}
	
}