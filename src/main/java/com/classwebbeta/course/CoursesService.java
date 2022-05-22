package com.classwebbeta.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CoursesService {

	// Create CoursesRepository object
	@Autowired
	private final CoursesRepository coursesRepository;

	// Constructor
    public CoursesService(CoursesRepository coursesRepository) {
		this.coursesRepository = coursesRepository;
	}

	private Integer professorID;

	public Integer getProfessorID() {
		return professorID;
	}

	// To set the professor ID from ProfessorController and use it to get all courses
	public void setProfessorID(Integer professorID) {
		this.professorID = professorID;
	}

	// Get all courses from the Course Repository by professor ID
	public List<Course> getAllCourses(Integer professorid) {
        return coursesRepository.findByProfessorid(professorid);
    }

	// Sort all courses by ID
	public static void sortCoursesByID(List<Course> list) {
		list.sort((o1, o2)
				-> o1.getCourseid().compareTo(
				o2.getCourseid()));
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
	public void deleteCourse(Course course) {
		coursesRepository.delete(course);
	}

	// Get one Course
	public Course getOneCourse(Integer courseid){
		return coursesRepository.findByCourseid(courseid);
	}
}
