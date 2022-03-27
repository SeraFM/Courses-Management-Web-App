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

	Integer courseAttending;

    public Integer getCourseAttending(){
        return courseAttending;
    }

    public void setCourseAttending(Integer courseAttending){
        this.courseAttending = courseAttending;
    }
	
	public List<Student> getByCourseAttending(Integer courseAttending){
		return studentRepository.findByCourseAttending(courseAttending);
	}

	public void updateStudent(Student student) {
		studentRepository.save(student);
	}
	
	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	public void deleteStudent(Integer studentid){
		studentRepository.deleteById(studentid);
	}
	
	
}
