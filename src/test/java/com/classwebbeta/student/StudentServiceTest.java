package com.classwebbeta.student;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
        st.setCourseAttending(121);
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

        assertNotNull(st);

        Student test = studentService.getStudent(1);
        assertEquals("fullname", test.getFullname());
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

        assertEquals(null, studentService.getStudent(1));
    }

    @Test
    void testGetAllStudents() {
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

        assertEquals(1, studentService.getAllStudents().size());
    }

    @Test
    void testGetByCourseAttending() {
        Student st = new Student();
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
        st.setCourseAttending(1231);
        studentService.addStudent(st);

        List<Student> allByCourse = studentService.getByCourseAttending(null);
        assertNotNull(allByCourse);

        assertEquals("password",allByCourse.get(0).getPassword());
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

        assertEquals("email", studentService.getStudent(1).getEmail());
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

        assertEquals(true, studentService.studentAlreadyExists(st));
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

        assertEquals(updateSt.getEmail(), studentService.getStudent(1).getEmail());
    }
}
