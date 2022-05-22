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

    // Constructor
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    // Add new Student. Post Request to get the data from the Add Student form and put it in the Repository(database)
    @PostMapping("/addStudent")
    public String addStudent(Student student, Model error) {
        // Check if student with this ID or email already exists in the Database
        if (ObjectUtils.isEmpty(studentService.getStudent(student.getStudentid()))){
            // Check for valid email and year of register
            if(studentService.isValidEmail(student) && studentService.isValidYearOfRegistration(student)){
                studentService.isValidInputGrade(student);
                studentService.addStudent(student);
                return "redirect:/courses/students/?courseAttending=" + studentService.getCourseAttending();
            }else if(!studentService.isValidEmail(student)){ // if email is not valid show error
                error.addAttribute("ErrorMessage",  "Incorrect input: Email. Must be type of: something@mail.com or .gr");
                return "error_page";
            }else { // if year of registration is not valid show error
                error.addAttribute("ErrorMessage", "Incorrect input: Year of Registration. Must be between 2000-2021");
                return "error_page";
            }
        }else{
            error.addAttribute("ErrorMessage", "Student with ID:"+ student.getStudentid() +" or with email:"+ student.getEmail() +" already exists");
            return "error_page";
        }
    }
    
    // Update Student. Post Request to get the data from the Update Student form and put it in the Repository(database)
    @PostMapping(value="/updateStudent")
    public String updateStudent(Student student, Model error) {
        // Check for valid email and year of registration
        if(studentService.isValidEmail(student) && studentService.isValidYearOfRegistration(student)){
            studentService.isValidInputGrade(student);
            studentService.updateStudent(student);
            return "redirect:/courses/students/?courseAttending=" + studentService.getCourseAttending();
        }else if(!studentService.isValidEmail(student)){ // if email is not valid show error
            error.addAttribute("ErrorMessage",  "Incorrect input: Email. Must be type of: something@mail.com or .gr");
            return "error_page";
        }else { // if year of registration is not valid show error
            error.addAttribute("ErrorMessage", "Incorrect input: Year of Registration. Must be between 2000-2021");
            return "error_page";
        }
    }
      
    // Delete Student by ID 
    @RequestMapping(value="/deleteStudent", method = RequestMethod.POST)
    public String deleteStudent(Student student) {
    	studentService.deleteStudent(student);
    	return "redirect:/courses/students/?courseAttending=" + studentService.getCourseAttending();
    }

}
