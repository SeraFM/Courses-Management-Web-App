package com.classwebbeta.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
       
      /*
      // Generate random student data
      random.ReadFile();
      try {
          random.randomStudent(studentService);
      } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }
      */
      /*
      if (!studentService.isValidStudentIdAndEmail(student)){
        String error = "Error. Invalid AM or Email!";
        err.addFlashAttribute("error", error);
        return "courses/students/?courseAttending=" + studentService.getCourseAttending();
      }*/
      studentService.isValidInputGrade(student);
    	studentService.addStudent(student);
    	return "redirect:/courses/students/?courseAttending=" + studentService.getCourseAttending();
    }
    
    // Update Student. Post Request to get the data from the Update Student form and put it in the Repository(database)
    @PostMapping(value="/updateStudent")
    public String updateStudent(Student student) {
      if (!studentService.isValidStudentIdAndEmail(student)){
        // return ""
      }
      studentService.isValidInputGrade(student);
		  studentService.updateStudent(student);
    	return "redirect:/courses/students/?courseAttending=" + studentService.getCourseAttending();
    }
      
    // Delete Student by ID 
    @RequestMapping(value="/deleteStudent", method = RequestMethod.POST)
    public String deleteStudent(Student student) {
    	studentService.deleteStudent(student);
    	return "redirect:/courses/students/?courseAttending=" + studentService.getCourseAttending();
    }

}
