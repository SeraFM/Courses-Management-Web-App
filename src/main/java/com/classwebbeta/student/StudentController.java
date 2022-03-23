package com.classwebbeta.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/addStudent")
    public String addStudent(Student student) {
    	student.setCourseAttending(studentService.getCourseAttending());
    	System.out.println("Added New Course: " + student.toString());
    	studentService.addStudent(student);
    	return "redirect:/students";
    }

    @GetMapping("/getOneStudent")
    @ResponseBody
    public List<Student> getOneStudent(Integer studentid) {
    	return studentService.getOneStudent(studentid);
    }
    
    @RequestMapping(value="/editStudent", method = {RequestMethod.PUT, RequestMethod.GET})
    public String editStudent(Student student) {
		studentService.updateStudent(student);
    	return "redirect:/students";
    }
      
    @DeleteMapping(value="/delete")
    public String deleteStudent(Integer studentid) {
    	studentService.deleteStudent(studentid);
    	return "redirect:/students";
    }

}
