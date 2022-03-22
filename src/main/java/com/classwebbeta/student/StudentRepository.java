package com.classwebbeta.student;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

	List<Student> findByCourseAttending(Integer courseAttending);
	
}
