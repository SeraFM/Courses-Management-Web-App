package com.classwebbeta.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
        studentService.isValidInputGrade(student);
        studentService.addStudent(student);
        return "redirect:/courses/students/?courseAttending=" + studentService.getCourseAttending();
        /*
        student.setCourseAttending(studentService.getCourseAttending());
        // Check if a student with same ID or email already exists Else add student
        if(studentService.studentAlreadyExists(student)){
            error.addAttribute("ErrorMessage", "Student with ID:"+ student.getStudentid() +" or with email:"+ student.getEmail() +" already exists");
            return "error_page";
        }else{
            studentService.addStudent(student);
            return "redirect:/courses/students/?courseAttending=" + studentService.getCourseAttending();
        }*/
    }
    
    // Update Student. Post Request to get the data from the Update Student form and put it in the Repository(database)
    @PostMapping(value="/updateStudent")
    public String updateStudent(Student student) {
        studentService.isValidInputGrade(student);
        studentService.updateStudent(student);
        return "redirect:/courses/students/?courseAttending=" + studentService.getCourseAttending();
        /*
        student.setCourseAttending(studentService.getCourseAttending());
        if (studentService.studentAlreadyExists(student)){
            error.addAttribute("ErrorMessage", "Student with ID:"+ student.getStudentid() +" or with email:"+ student.getEmail() +" already exists");
            return "error_page";
        }else{
            studentService.updateStudent(student);
            return "redirect:/courses/students/?courseAttending=" + studentService.getCourseAttending();
        }*/
    }
      
    // Delete Student by ID 
    @RequestMapping(value="/deleteStudent", method = RequestMethod.POST)
    public String deleteStudent(Student student) {
    	studentService.deleteStudent(student);
    	return "redirect:/courses/students/?courseAttending=" + studentService.getCourseAttending();
    }

}
