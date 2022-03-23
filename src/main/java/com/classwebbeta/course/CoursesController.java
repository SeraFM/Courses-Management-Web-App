package com.classwebbeta.course;

import org.springframework.beans.factory.annotation.Autowired;   
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.classwebbeta.student.Student;
import com.classwebbeta.student.StudentService;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/addCourse")
    public String addCourse(CoursesModel coursesModel) {
    	coursesModel.setProfessorid(coursesService.getProfessorID());
    	System.out.println("Added New Course: " + coursesModel.toString());
    	coursesService.addCourse(coursesModel);
    	return "redirect:/courses";
    }
    
    @GetMapping("/getOne")
    @ResponseBody
    public Optional<CoursesModel> getOne(Integer courseid) {
    	return coursesService.getOne(courseid);
    }
    
    @RequestMapping(value="/editCourse", method = {RequestMethod.PUT, RequestMethod.GET})
    public String editCourse(CoursesModel coursesModel) {
		coursesService.updateCourse(coursesModel);
    	return "redirect:/courses";
    }
      
    @DeleteMapping(value="/delete")
    public String deleteCourse(Integer courseid) {
    	coursesService.deleteCourse(courseid);
    	return "redirect:/courses";
    }
    
    @GetMapping("/students")
    public String getStudentsPage(Integer courseAttending, Model model) {
        studentService.setCourseAttending(courseAttending);
    	List<Student> students = studentService.getByCourseAttending(courseAttending);
    	//System.out.println(students);
        model.addAttribute("students", students);
        return "navigate_course_page";
    }

}
