package com.classwebbeta.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CoursesService {

	@Autowired
	private final CoursesRepository coursesRepository;
	
    public CoursesService(CoursesRepository coursesRepository) {
		this.coursesRepository = coursesRepository;
	}

	private Integer professorID;

	public Integer getProfessorID() {
		return professorID;
	}

	public void setProfessorID(Integer professorID) {
		this.professorID = professorID;
	}

	// Get all courses from the Course Repository by professor ID
	public List<Course> getAllCourses(Integer professorid) {
        return coursesRepository.findByProfessorid(professorid);
    }
	
	// Update Course
	public void updateCourse(Course course) {
		coursesRepository.save(course);
	}
	
	// Add Course
	public void addCourse(Course course) {
		coursesRepository.save(course);
	}

	// Delete Course
	public void deleteCourse(Integer courseid) {
		coursesRepository.deleteById(courseid);
	}

	// Get one Course
	public List<Course> getOneCourse(Integer courseid){
		return coursesRepository.findByCourseid(courseid);
	}

}
