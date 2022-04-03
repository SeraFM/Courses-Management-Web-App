package com.classwebbeta.course;

import org.springframework.beans.factory.annotation.Autowired;   
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.classwebbeta.student.Student;
import com.classwebbeta.student.StudentService;
import java.util.List;

@Controller
@RequestMapping("/courses")
public class CoursesController {
	
	@Autowired
	private final CoursesService coursesService;
	private final StudentService studentService;

    public CoursesController(CoursesService coursesService,  StudentService studentService){
    	this.studentService = studentService;
        this.coursesService = coursesService;
    }

    // Add Course using Thymeleaf. PostMapping is an HTTP Request to Add Course here. The value is the HTML url to follow
    @PostMapping("/addCourse")
    public String addCourse(Course course) {
        // Set course Professor automatically
    	course.setProfessorid(coursesService.getProfessorID());
        // set project percentage automatically 
        course.setProjectPR(course.getExamPR());
    	System.out.println("Added New Course: " + course.toString());
        // add the course to the repository
    	coursesService.addCourse(course);
    	return "redirect:/courses";
    }
    
    // Update existing Course using Thymeleaf. The value is the HTML url to follow
    @PostMapping(value="/updateCourse")
    public String updateCourse(Course course) {
        // Set course Professor automatically
        course.setProfessorid(coursesService.getProfessorID());
        // set project percentage automatically 
        course.setProjectPR(course.getExamPR());
        // update the course in the repository
		coursesService.updateCourse(course);
    	return "redirect:/courses";
    }
      
    // Delete course by courseid using Thymeleaf. DeleteMapping is an HTTP Request to Delete Course Here
    @PostMapping(value="/deleteCourse")
    public String deleteCourse(Course course) {
        // delete a course with courseid from the repository
    	coursesService.deleteCourse(course);
    	return "redirect:/courses";
    }
    
    // Get Course's Students by courseAttending(Field in Student Table) using Thymeleaf. GetMapping is an HTTP Request to Get the URL of Students Here
    @GetMapping("/students")
    public String getStudentsPage(Integer courseAttending, Model model) {
        // Set courseAttending automatically to use it for getting the students that attend a specific course
        studentService.setCourseAttending(courseAttending);
        Integer exam = coursesService.getOneCourse(courseAttending).get(0).getExamPR();
        Integer project = coursesService.getOneCourse(courseAttending).get(0).getProjectPR();
        studentService.setExamGradePR(exam);
        studentService.setProjectGradePR(project);
        // List of Students
    	List<Student> students = studentService.getByCourseAttending(courseAttending);
        // Model to use it in HTML with Thymeleaf
        model.addAttribute("students", students);
        // Navigate to this HTML page (.html file)
        return "navigate_course_page";
    }

}
