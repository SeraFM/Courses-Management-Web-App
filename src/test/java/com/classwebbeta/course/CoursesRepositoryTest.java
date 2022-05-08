package com.classwebbeta.course;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import com.classwebbeta.ClassWebBetaApplication;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClassWebBetaApplication.class)
@ComponentScan(basePackages = "com.classwebbeta.course")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CoursesRepositoryTest {

    @Autowired
    CoursesRepository coursesRepository;

    @Test
    void testFindByCourseid() {
        Course courseTest = new Course();
        courseTest.setCourseid(1);
        courseTest.setExamPR(80);
        courseTest.setName("Course");
        courseTest.setProfessorid(1);
        courseTest.setProjectPR(80);
        courseTest.setSemester(1);
        courseTest.setSyllabus(1);
        courseTest.setYear(2020);
        coursesRepository.save(courseTest);

        assertEquals(courseTest, coursesRepository.findByCourseid(courseTest.getCourseid()));
    }

    @Test
    void testFindByProfessorid() {
        Course courseTest = new Course();
        courseTest.setCourseid(1);
        courseTest.setExamPR(80);
        courseTest.setName("Course");
        courseTest.setProfessorid(1);
        courseTest.setProjectPR(80);
        courseTest.setSemester(1);
        courseTest.setSyllabus(1);
        courseTest.setYear(2020);
        coursesRepository.save(courseTest);

        assertEquals(courseTest, coursesRepository.findByCourseid(courseTest.getProfessorid()));
    }
}
