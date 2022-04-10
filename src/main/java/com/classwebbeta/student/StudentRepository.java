package com.classwebbeta.student;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

// Is the 'API' to link database with java
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
	
	// Find students by the course they attend 
	List<Student> findByCourseAttending(Integer courseAttending);
	List<Student> findByEmail(String email);
	List<Student> findByStudentid(Integer studentid);
	Boolean existsByEmail(String email);
	List<Student> findByEmailAndPassword(String email, String password);	
}
