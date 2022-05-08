package com.classwebbeta.course;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
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
@ComponentScan(basePackages = "com.classwebbeta.course")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CoursesServiceTest {

    @Autowired
    CoursesService coursesService;

    @Test
    void testAddCourse() {
        Course courseTest = new Course();
        courseTest.setCourseid(1);
        courseTest.setExamPR(80);
        courseTest.setName("Course");
        courseTest.setProfessorid(1);
        courseTest.setProjectPR(80);
        courseTest.setSemester(1);
        courseTest.setSyllabus(1);
        courseTest.setYear(2020);

        coursesService.addCourse(courseTest);

        assertEquals(courseTest, coursesService.getOneCourse(courseTest.getCourseid()));
    }

    @Test
    void testDeleteCourse() {
        Course courseTest = new Course();
        courseTest.setCourseid(1);
        courseTest.setExamPR(80);
        courseTest.setName("Course");
        courseTest.setProfessorid(1);
        courseTest.setProjectPR(80);
        courseTest.setSemester(1);
        courseTest.setSyllabus(1);
        courseTest.setYear(2020);

        coursesService.addCourse(courseTest);
        coursesService.deleteCourse(courseTest);
        assertEquals(null, coursesService.getOneCourse(courseTest.getCourseid()));

    }

    @Test
    void testGetAllCourses() {
        Course courseTest = new Course();
        courseTest.setCourseid(1);
        courseTest.setExamPR(80);
        courseTest.setName("Course");
        courseTest.setProfessorid(1);
        courseTest.setProjectPR(80);
        courseTest.setSemester(1);
        courseTest.setSyllabus(1);
        courseTest.setYear(2020);
        coursesService.addCourse(courseTest);

        Course courseTest2 = new Course();
        courseTest2.setCourseid(2);
        courseTest2.setExamPR(80);
        courseTest2.setName("Course2");
        courseTest2.setProfessorid(1);
        courseTest2.setProjectPR(80);
        courseTest2.setSemester(1);
        courseTest2.setSyllabus(1);
        courseTest2.setYear(2020);
        coursesService.addCourse(courseTest2);

        List<Course> list = new ArrayList<Course>();
        list.add(courseTest);
        list.add(courseTest2);

        assertEquals(list, coursesService.getAllCourses(1));

    }

    @Test
    void testGetOneCourse() {
        Course courseTest = new Course();
        courseTest.setCourseid(1);
        courseTest.setExamPR(80);
        courseTest.setName("Course");
        courseTest.setProfessorid(1);
        courseTest.setProjectPR(80);
        courseTest.setSemester(1);
        courseTest.setSyllabus(1);
        courseTest.setYear(2020);

        coursesService.addCourse(courseTest);

        assertEquals(courseTest, coursesService.getOneCourse(courseTest.getCourseid()));
    }

    @Test
    void testUpdateCourse() {
        Course courseTest = new Course();
        courseTest.setCourseid(1);
        courseTest.setExamPR(80);
        courseTest.setName("Course");
        courseTest.setProfessorid(1);
        courseTest.setProjectPR(80);
        courseTest.setSemester(1);
        courseTest.setSyllabus(1);
        courseTest.setYear(2020);
        coursesService.addCourse(courseTest);

        Course courseUpdate = new Course();
        courseUpdate.setCourseid(1);
        courseUpdate.setExamPR(80);
        courseUpdate.setName("CourseUpdate");
        courseUpdate.setProfessorid(1);
        courseUpdate.setProjectPR(80);
        courseUpdate.setSemester(1);
        courseUpdate.setSyllabus(1);
        courseUpdate.setYear(2020);
        coursesService.updateCourse(courseUpdate);

        assertEquals(courseUpdate.getName(), coursesService.getOneCourse(1).getName());
    }
}
