package com.classwebbeta.student;

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
@ComponentScan(basePackages = "com.classwebbeta.student")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentRepositoryTest {
   
    @Autowired
    StudentRepository studentRepository;

    @Test
    void testExistsByEmail() {
        Student st = new Student();
        st.setCourseAttending(1);
        st.setEmail("email");
        st.setExamGrade("10");
        st.setFinalGrade("10");
        st.setFullname("fullname");
        st.setPassword("password");
        st.setProjectGrade("10");
        st.setYearOfRegistration(2020);
        st.setYearOfStudies(2);
        st.setSyllabus(1);
        st.setSemester(1);
        st.setStudentid(1);
        studentRepository.save(st);

        assertEquals(true, studentRepository.existsByEmail(st.getEmail()));
    }

    @Test
    void testFindByCourseAttending() {
        Student st = new Student();
        st.setCourseAttending(1);
        st.setEmail("email");
        st.setExamGrade("10");
        st.setFinalGrade("10");
        st.setFullname("fullname");
        st.setPassword("password");
        st.setProjectGrade("10");
        st.setYearOfRegistration(2020);
        st.setYearOfStudies(2);
        st.setSyllabus(1);
        st.setSemester(1);
        st.setStudentid(1);
        studentRepository.save(st);

        assertEquals(st, studentRepository.findByCourseAttending(st.getCourseAttending()).get(0));
    }

    @Test
    void testFindByStudentid() {
        Student st = new Student();
        st.setCourseAttending(1);
        st.setEmail("email");
        st.setExamGrade("10");
        st.setFinalGrade("10");
        st.setFullname("fullname");
        st.setPassword("password");
        st.setProjectGrade("10");
        st.setYearOfRegistration(2020);
        st.setYearOfStudies(2);
        st.setSyllabus(1);
        st.setSemester(1);
        st.setStudentid(1);
        studentRepository.save(st);

        assertEquals(st, studentRepository.findByStudentid(st.getStudentid()).get(0));
    }
}
