package com.classwebbeta.statistics;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.ArrayList;
import java.util.List;
import com.classwebbeta.student.Student;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.classwebbeta.statistics")
public class CalculateStatisticsTest {

    CalculateStatistics statistics = new CalculateStatistics();

    @Test
    void testCalculateStatistics(){
        List<Student> allStudents = new ArrayList<Student>();
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
        allStudents.add(st);

        Student st2 = new Student();
        st2.setCourseAttending(1);
        st2.setEmail("email2");
        st2.setExamGrade("10");
        st2.setFinalGrade("10");
        st2.setFullname("fullname");
        st2.setPassword("password");
        st2.setProjectGrade("10");
        st2.setYearOfRegistration(2020);
        st2.setYearOfStudies(2);
        st2.setSyllabus(1);
        st2.setSemester(1);
        st2.setStudentid(2);
        allStudents.add(st2);

        assertNotNull(statistics.calculateStatistics(allStudents));
    }
}
