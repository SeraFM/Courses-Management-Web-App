package com.classwebbeta.student;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// StudentService is linked with the Repository to Add, Update, Delete etc. students from the database
@Service
public class StudentService {

	@Autowired
	private final StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	Integer courseAttending;

    public Integer getCourseAttending(){
        return courseAttending;
    }

    public void setCourseAttending(Integer courseAttending){
        this.courseAttending = courseAttending;
    }
	
	// Get all students by the course they attend
	public List<Student> getByCourseAttending(Integer courseAttending){
		return studentRepository.findByCourseAttending(courseAttending);
	}

	// Update Student
	public void updateStudent(Student student) {
		studentRepository.save(student);
	}
	
	// Add new Student
	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	// Delete Student
	public void deleteStudent(Integer studentid){
		studentRepository.deleteById(studentid);
	}
	
	
}
