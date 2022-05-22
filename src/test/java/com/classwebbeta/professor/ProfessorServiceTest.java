package com.classwebbeta.professor;

import java.util.ArrayList;
import java.util.List;
import com.classwebbeta.ClassWebBetaApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ClassWebBetaApplication.class)
@ComponentScan(basePackages = "com.classwebbeta.professor")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProfessorServiceTest {

    @Autowired
    ProfessorService professorService;

    @Test
    void testAuthenticate() {
        Professor professor = new Professor();
        professor.setEmail("instructor1@uoi.com");
        professor.setPassword("123456789");
        professor.setPhoneNumber("6987056473");
        professor.setProfessorName("Instructor 1");
        professor.setProfessorid(1);
        professor.setUsername("instructor1");
        professorService.saveProfessor(professor);
        
        assertEquals(professor.getEmail(), professorService.authenticate(professor.getUsername(), professor.getPassword()).getEmail());

    }

    @Test
    void testGetAllProfessors() {
        assertFalse(professorService.getAllProfessors().isEmpty());
    }

    @Test
    void testGetProfessor() {
        Professor professor = new Professor();
        professor.setEmail("instructor1@uoi.com");
        professor.setPassword("123456789");
        professor.setPhoneNumber("6987056473");
        professor.setProfessorName("Instructor 1");
        professor.setProfessorid(1);
        professor.setUsername("instructor1");
        professorService.saveProfessor(professor);

        assertEquals(professor.getUsername(), professorService.getProfessor(professor.getUsername()).getUsername());
    }
}
