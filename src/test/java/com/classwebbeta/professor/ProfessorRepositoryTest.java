package com.classwebbeta.professor;

import com.classwebbeta.ClassWebBetaApplication;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClassWebBetaApplication.class)
@ComponentScan(basePackages = "com.classwebbeta.professor")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProfessorRepositoryTest {

    @Autowired
    ProfessorRepository professorRepository;

    @Test
    void testFindByUsername() {
        Professor professor = new Professor();
        professor.setEmail("instructor1@uoi.com");
        professor.setPassword("123456789");
        professor.setPhoneNumber("6987056473");
        professor.setProfessorName("Instructor 1");
        professor.setProfessorid(1);
        professor.setUsername("instructor1");
        professorRepository.save(professor);

        Assert.assertEquals(professor.getPassword(), professorRepository.findByUsername(professor.getUsername()).getPassword());
    }

    @Test
    void testFindByUsernameAndPassword() {
        Professor professor = new Professor();
        professor.setEmail("instructor1@uoi.com");
        professor.setPassword("123456789");
        professor.setPhoneNumber("6987056473");
        professor.setProfessorName("Instructor 1");
        professor.setProfessorid(1);
        professor.setUsername("instructor1");
        professorRepository.save(professor);

        String username = professorRepository.findByUsernameAndPassword(professor.getUsername(), professor.getPassword()).getUsername();

        Assert.assertEquals(professor.getUsername(),username);
    }
}