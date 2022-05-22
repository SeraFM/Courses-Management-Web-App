package com.classwebbeta.professor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

	@Autowired
	private final ProfessorRepository professorRepository;

    // Constructor
    public ProfessorService(ProfessorRepository professorRepository){
        this.professorRepository = professorRepository;
    }

    // Check if user login is valid (is in the database)  
    public Professor authenticate(String username, String password){
        return professorRepository.findByUsernameAndPassword(username,password);
    }
    
    // Get all professors from the repository
    public List<Professor> getAllProfessors() {
    	return professorRepository.findAll();
    }

    // Get professor by username
    public Professor getProfessor(String username) {
    	return professorRepository.findByUsername(username);
    }

    // Save professor
    public void saveProfessor(Professor professor){
        professorRepository.save(professor);
    }
	
}
