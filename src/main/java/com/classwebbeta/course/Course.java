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
   // private Integer attendance;
    private Integer professorid;
    private Integer examPR;
    private Integer projectPR;

    // Getters and Setters

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((courseid == null) ? 0 : courseid.hashCode());
        result = prime * result + ((examPR == null) ? 0 : examPR.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((professorid == null) ? 0 : professorid.hashCode());
        result = prime * result + ((projectPR == null) ? 0 : projectPR.hashCode());
        result = prime * result + ((semester == null) ? 0 : semester.hashCode());
        result = prime * result + ((syllabus == null) ? 0 : syllabus.hashCode());
        result = prime * result + ((year == null) ? 0 : year.hashCode());
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
        Course other = (Course) obj;
        if (courseid == null) {
            if (other.courseid != null)
                return false;
        } else if (!courseid.equals(other.courseid))
            return false;
        if (examPR == null) {
            if (other.examPR != null)
                return false;
        } else if (!examPR.equals(other.examPR))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (professorid == null) {
            if (other.professorid != null)
                return false;
        } else if (!professorid.equals(other.professorid))
            return false;
        if (projectPR == null) {
            if (other.projectPR != null)
                return false;
        } else if (!projectPR.equals(other.projectPR))
            return false;
        if (semester == null) {
            if (other.semester != null)
                return false;
        } else if (!semester.equals(other.semester))
            return false;
        if (syllabus == null) {
            if (other.syllabus != null)
                return false;
        } else if (!syllabus.equals(other.syllabus))
            return false;
        if (year == null) {
            if (other.year != null)
                return false;
        } else if (!year.equals(other.year))
            return false;
        return true;
    }

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

   /* public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }*/
    
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

	@Override
	public String toString() {
		return "CoursesModel [courseid=" + courseid + ", name=" + name + ", year=" + year + ", syllabus=" + syllabus
				+ ", semester=" + semester + /*", attendance=" + attendance +*/ ", professorid=" + professorid + ", examPR="
				+ examPR + ", projectPR=" + projectPR + "]";
	}
	
}