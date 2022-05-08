package com.classwebbeta.professor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.classwebbeta.course.Course;
import com.classwebbeta.course.CoursesService;

@Controller
public class ProfessorController {

	@Autowired
    private final ProfessorService professorService;
    @Autowired
	private final CoursesService coursesService;
    
    public ProfessorController(ProfessorService professorService, CoursesService coursesService){
        this.professorService = professorService;
		this.coursesService = coursesService;
    }

    // Log out
    @GetMapping("/logout")
    public String logedOut(){
        return "login";
    }
    
    // Go to the Login URL with HTTP Request GetMapping
	@GetMapping("/login")
    public String getLoginPage(Model model){
        // Add to the Model the Email and Password from the user trying to login
        model.addAttribute("loginRequest", new Professor());
        return "login";
    }
    
    // Go to Home page URL 
    @GetMapping("/home")
    public String getHomePage(Model model){
        model.addAttribute("homeNav");
        return "home_page";
    }
    
    // Go to About page URL
    @GetMapping("/about")
    public String getAboutPage(Model model){
        model.addAttribute("aboutNav");
        return "about_page";
    } 
    
    // Go to courses URL and diplsay all courses of the Instructor that loged in succesfully
    @GetMapping("/courses")
    public String getCoursesPage(Model model){
    	List<Course> course = coursesService.getAllCourses(coursesService.getProfessorID());
        model.addAttribute("courses", course);
        return "courses_page";
    }
    
    // Get the login Email-Passowrd inputs from user and check if they are in the database so the user(instructor) can navigate to home page
    @PostMapping("/login")
    public String login(@ModelAttribute Professor professorModel, Model model){

        // Calling a method from Professor Service to check if the inputs are in the database
        Professor loginProfessor = professorService.authenticate(professorModel.getEmail(), professorModel.getPassword());

        if (ObjectUtils.isEmpty(loginProfessor)){
            model.addAttribute("errorMessage","Wrong Username or Password. Please try again");
            return "login";
        }else{
            Professor professor = professorService.getProfessor(loginProfessor.getEmail());
            coursesService.setProfessorID(professor.getProfessorid());
            model.addAttribute("userLogin", professor.getProfessorName());
            return "home_page";
        }
    }
}
