package com.classwebbeta.professor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
        professor.setEmail("email@uoi.gr");
        professor.setPassword("password");
        professor.setPhoneNumber("99999999");
        professor.setProfessorName("professorName");
        professor.setProfessorid(1);
        professor.setUsername("username");
        professorService.saveProfessor(professor);
        
        assertEquals(professor, professorService.authenticate(professor.getUsername(), professor.getPassword()));

    }

    @Test
    void testGetAllProfessors() {
        Professor professor = new Professor();
        professor.setEmail("email@uoi.gr");
        professor.setPassword("password");
        professor.setPhoneNumber("99999999");
        professor.setProfessorName("professorName");
        professor.setProfessorid(1);
        professor.setUsername("username");
        professorService.saveProfessor(professor);

        Professor professor2 = new Professor();
        professor2.setEmail("email2@uoi.gr");
        professor2.setPassword("password2");
        professor2.setPhoneNumber("99999999");
        professor2.setProfessorName("professorName2");
        professor2.setProfessorid(2);
        professor2.setUsername("username2");
        professorService.saveProfessor(professor2);

        List<Professor> all = new ArrayList<Professor>();
        all.add(professor);
        all.add(professor2); 

        assertTrue(!professorService.getAllProfessors().isEmpty());
    }

    @Test
    void testGetProfessor() {
        Professor professor = new Professor();
        professor.setEmail("email@uoi.gr");
        professor.setPassword("password");
        professor.setPhoneNumber("99999999");
        professor.setProfessorName("professorName");
        professor.setProfessorid(1);
        professor.setUsername("username");
        professorService.saveProfessor(professor);

        assertEquals(professor, professorService.getProfessor(professor.getEmail()));
    }
}
