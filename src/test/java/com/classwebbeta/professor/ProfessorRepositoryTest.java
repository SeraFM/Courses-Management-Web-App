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
    void testFindByEmail() {
        Professor professor = new Professor();
        professor.setEmail("email@gmail.com");
        professor.setPassword("password");
        professor.setPhoneNumber("999999999");
        professor.setProfessorName("professorName");
        professor.setProfessorid(1);
        professor.setUsername("username");
        professorRepository.save(professor);

        Assert.assertEquals(professor, professorRepository.findByEmail(professor.getEmail()));
    }

    @Test
    void testFindByEmailAndPassword() {
        Professor professor = new Professor();
        professor.setEmail("email@gmail.com");
        professor.setPassword("password");
        professor.setPhoneNumber("999999999");
        professor.setProfessorName("professorName");
        professor.setProfessorid(1);
        professor.setUsername("username");
        professorRepository.save(professor);

        Assert.assertEquals(professor, professorRepository.findByEmailAndPassword(professor.getEmail(), professor.getPassword()));
    }
}
