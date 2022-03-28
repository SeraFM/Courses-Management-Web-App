package com.classwebbeta.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // Add new Student. Post Request to get the data from the Add Student form and put it in the Repository(database)
    @PostMapping("/addStudent")
    public String addStudent(Student student) {
    	student.setCourseAttending(studentService.getCourseAttending());
      student.setYearOfStudies(student.getYearOfStudies());
      student.setSyllabus(student.getSyllabus());
      student.setSemester(student.getSemester());
    	System.out.println("Added New Student: " + student.toString());
    	studentService.addStudent(student);
    	return "redirect:/courses/students/?courseAttending=" + studentService.getCourseAttending();
    }
    
    // Update Student. Post Request to get the data from the Update Student form and put it in the Repository(database)
    @PostMapping(value="/updateStudent")
    public String updateStudent(Student student) {
      student.setCourseAttending(studentService.getCourseAttending());
      student.setYearOfStudies(student.getYearOfStudies());
      student.setSyllabus(student.getSyllabus());
      student.setSemester(student.getSemester());
		  studentService.updateStudent(student);
    	return "redirect:/courses/students/?courseAttending=" + studentService.getCourseAttending();
    }
      
    // Delete Student by ID 
    @DeleteMapping(value="/delete")
    public String deleteStudent(Integer studentid) {
    	studentService.deleteStudent(studentid);
    	return "redirect:/courses/students/?courseAttending=" + studentService.getCourseAttending();
    }

}
