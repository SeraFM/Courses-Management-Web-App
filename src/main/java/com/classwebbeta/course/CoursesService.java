package com.classwebbeta.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {

	@Autowired
	private final CoursesRepository coursesRepository;
	
    public CoursesService(CoursesRepository coursesRepository) {
		this.coursesRepository = coursesRepository;
	}

	public List<CoursesModel> getAllCourses(Integer professorid) {
        return coursesRepository.findByProfessorid(professorid);
    }
	
	public void updateCourse(CoursesModel coursesModel) {
		coursesRepository.save(coursesModel);
	}
	
	public void addCourse(CoursesModel coursesModel) {
		coursesRepository.save(coursesModel);
	}
	
	public Optional<CoursesModel> getOne(Integer courseid) {
		return coursesRepository.findById(courseid);
	}
	
	private Integer professorID;

	public Integer getProfessorID() {
		return professorID;
	}

	public void deleteCourse(Integer courseid) {
		coursesRepository.deleteById(courseid);
	}

	public void setProfessorID(Integer professorID) {
		this.professorID = professorID;
	}

	
}
