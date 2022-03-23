package com.classwebbeta.professor;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.classwebbeta.course.CoursesModel;
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
    

	@GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new ProfessorModel());
        return "login";
    }
    
    
    @GetMapping("/home")
    public String getHomePage(Model model) {
        model.addAttribute("homeNav");
        return "home_page";
    }
    
    
    @GetMapping("/about")
    public String getAboutPage(Model model) {
        model.addAttribute("aboutNav");
        return "about_page";
    }  
    
    // SHOW ALL PROFESSOR COURSES
    @GetMapping("/courses")
    public String getCoursesPage(Model model) {
    	List<CoursesModel> coursesModel = coursesService.getAllCourses(coursesService.getProfessorID());
        model.addAttribute("courses", coursesModel);
        return "courses_page";
    }
    
    @PostMapping("/login")
    public String login(@ModelAttribute ProfessorModel professorModel, Model model) {
        System.out.println("Login Request: " + "Email: " + professorModel.getEmail() + "  Password: ********");
        ProfessorModel authenticated = professorService.authenticate(professorModel.getEmail(), professorModel.getPassword());
        if(authenticated!=null) {
        	List<ProfessorModel> all = professorService.getAllProfessors();
        	for(int i=0; i<all.size(); i++){
        		if((all.get(i).getEmail()).equals(authenticated.getEmail())) {
        			System.out.println("Loged in as: " + all.get(i).toString());
        			coursesService.setProfessorID(all.get(i).getProfessorid());
        			model.addAttribute("userLogin", authenticated.getEmail());
                    return "home_page";
        		}
        	}
        	System.out.println("Not Valid Username or Password. Please try again");
        	return "login";
        }else{
        	System.out.println("Not Valid Username or Password. Please try again");
            return "login";
        }
    }
    
}
