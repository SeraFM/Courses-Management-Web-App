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
    public Professor authenticate(String email, String password){
        return professorRepository.findByEmailAndPassword(email,password);
    }
    
    // Get all professors from the repository
    public List<Professor> getAllProfessors() {
    	return professorRepository.findAll();
    }

    public Professor getProfessor(String email) {
    	return professorRepository.findByEmail(email);
    }

	
}
