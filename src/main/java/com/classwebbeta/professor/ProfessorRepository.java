package com.classwebbeta.professor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Is the 'API' to link database with java
@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

	// Find all professors by a specific email and password (there is only one of course)
	List<Professor> findByEmailAndPassword(String email, String password);
	List<Professor> findByEmail(String email);
	
}
