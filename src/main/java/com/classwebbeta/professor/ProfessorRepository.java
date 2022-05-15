package com.classwebbeta.professor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Is the 'API' to link database with java
@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

	// Find all professors by a specific username and password (there is only one of course)
	Professor findByUsernameAndPassword(String username, String password);
	Professor findByUsername(String username);
}
