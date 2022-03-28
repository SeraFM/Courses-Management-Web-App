package com.classwebbeta.professor;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    public ProfessorController(ProfessorService professorService, CoursesService coursesService ){
        this.professorService = professorService;
		this.coursesService = coursesService;
    }
    
    // Go to the Login URL with HTTP Request GetMapping
	@GetMapping("/login")
    public String getLoginPage(Model model) {
        // Add to the Model the Email and Password from the user trying to login
        model.addAttribute("loginRequest", new Professor());
        return "login";
    }
    
    // Go to Home page URL 
    @GetMapping("/home")
    public String getHomePage(Model model) {
        model.addAttribute("homeNav");
        return "home_page";
    }
    
    // Go to About page URL
    @GetMapping("/about")
    public String getAboutPage(Model model) {
        model.addAttribute("aboutNav");
        return "about_page";
    }  
    
    // Go to courses URL and diplsay all courses of the Instructor that loged in succesfully
    @GetMapping("/courses")
    public String getCoursesPage(Model model) {
    	List<Course> course = coursesService.getAllCourses(coursesService.getProfessorID());
        model.addAttribute("courses", course);
        return "courses_page";
    }
    
    // Get the login Email-Passowrd inputs from user and check if they are in the database so the user(instructor) can navigate to home page
    @PostMapping("/login")
    public String login(@ModelAttribute Professor professorModel, Model model) {
        // Print the login request from user
        System.out.println("Login Request: " + "Email: " + professorModel.getEmail() + "  Password: ********");
        // Calling a method to check if the inputs are in the database
        Professor authenticated = professorService.authenticate(professorModel.getEmail(), professorModel.getPassword());
        if(authenticated!=null) {
        	List<Professor> all = professorService.getAllProfessors();
        	for(int i=0; i<all.size(); i++){
                // if is true then navigate to home page
        		if((all.get(i).getEmail()).equals(authenticated.getEmail())) {
        			System.out.println("Loged in as: " + all.get(i).toString());
        			coursesService.setProfessorID(all.get(i).getProfessorid());
        			model.addAttribute("userLogin", authenticated.getEmail());
                    return "home_page";
        		}
        	}
        	System.out.println("Not Valid Username or Password. Please try again");
        	return "redirect:/login";
        }else{
        	System.out.println("Not Valid Username or Password. Please try again");
            return "redirect:/login";
        }
    }
    
}
