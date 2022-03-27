package com.classwebbeta.professor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer>{

	Optional<Professor> findByEmailAndPassword(String email, String password);
	
}
