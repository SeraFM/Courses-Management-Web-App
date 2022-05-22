package com.classwebbeta.professor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Is the 'API' to link database with java
@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

	// Find professor by a specific username and password
	Professor findByUsernameAndPassword(String username, String password);
	// Find professor by username
	Professor findByUsername(String username);
}
