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

    public Professor authenticate(String email, String password){
        return professorRepository.findByEmailAndPassword(email,password).orElse(null);
    }
    
    public List<Professor> getAllProfessors() {
    	return professorRepository.findAll();
    }
	
}
