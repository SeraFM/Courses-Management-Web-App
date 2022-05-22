package com.classwebbeta.student;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
	
	// Find students by the course they attend 
	List<Student> findByCourseAttending(Integer courseAttending);

	// Find student by ID
	Student findByStudentid(Integer studentid);

	// Check if student exists by ID
	Boolean existsByEmail(String email);
}
