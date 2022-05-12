package com.classwebbeta.professor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

	@Autowired
	private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository){
        this.professorRepository = professorRepository;
    }

    public void saveProfessor(Professor professor){
        professorRepository.save(professor);
    }

    // Check if user login is valid (is in the database)  
    public Professor authenticate(String username, String password){
        return professorRepository.findByUsernameAndPassword(username,password);
    }
    
    // Get all professors from the repository
    public List<Professor> getAllProfessors() {
    	return professorRepository.findAll();
    }

    public Professor getProfessor(String username) {
    	return professorRepository.findByUsername(username);
    }

	
}
