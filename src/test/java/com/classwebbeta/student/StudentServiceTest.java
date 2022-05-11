package com.classwebbeta.student;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.util.List;
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
public class StudentServiceTest {

    @Autowired
    StudentService studentService;

    @Test
    void testAddStudent() {
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
        studentService.addStudent(st);

        assertEquals(st, studentService.getStudent(1).get(0));
    }

    @Test
    void testDeleteStudent() {
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
        studentService.addStudent(st);

        studentService.deleteStudent(st);

        assertEquals(null, studentService.getStudent(1).get(0));
    }

    @Test
    void testGetAllStudents() {
        int len = studentService.getAllStudents().size()+1;

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
        studentService.addStudent(st);

        assertEquals(len, studentService.getAllStudents().size());
    }

    @Test
    void testGetByCourseAttending() {
        List<Student> all = studentService.getAllStudents();
        List<Student> allByCourse = studentService.getByCourseAttending(1);

        assertNotEquals(all, allByCourse);
    }

    @Test
    void testGetStudent() {
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
        studentService.addStudent(st);

        assertEquals(st, studentService.getStudent(1).get(0));
    }

    @Test
    void testIsValidInputGrade() {
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
        studentService.addStudent(st);

        studentService.isValidInputGrade(st);
    }

    @Test
    void testIsValidStudentIdAndEmail() {
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
        studentService.addStudent(st);

        assertEquals(true, studentService.isValidStudentIdAndEmail(st));
    }

    @Test
    void testUpdateStudent() {
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
        studentService.addStudent(st);

        Student updateSt = new Student();
        updateSt.setCourseAttending(1);
        updateSt.setEmail("emailUpdated");
        updateSt.setExamGrade("10");
        updateSt.setFinalGrade("10");
        updateSt.setFullname("fullname");
        updateSt.setPassword("password");
        updateSt.setProjectGrade("10");
        updateSt.setYearOfRegistration(2020);
        updateSt.setYearOfStudies(2);
        updateSt.setSyllabus(1);
        updateSt.setSemester(1);
        updateSt.setStudentid(1);
        studentService.updateStudent(updateSt);

        assertEquals(updateSt.getEmail(), studentService.getStudent(1).get(0).getEmail());
    }
}
