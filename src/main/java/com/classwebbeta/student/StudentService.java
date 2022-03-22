package com.classwebbeta.student;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private final StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getAll(Student student){
		return studentRepository.findAll();
	}
	
	public List<Student> getByCourseAttending(Integer courseAttending){
		return studentRepository.findByCourseAttending(courseAttending);
	}
	
	
}
