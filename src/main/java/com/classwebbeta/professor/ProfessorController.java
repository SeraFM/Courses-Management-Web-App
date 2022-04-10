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
import com.classwebbeta.login.LoginService;
import com.classwebbeta.student.Student;
import com.classwebbeta.student.StudentService;


@Controller
public class ProfessorController {

	@Autowired
    private final ProfessorService professorService;
    @Autowired
	private final CoursesService coursesService;
    @Autowired
    private final LoginService loginService;

    public ProfessorController(ProfessorService professorService, CoursesService coursesService, LoginService loginService){
        this.professorService = professorService;
		this.coursesService = coursesService;
        this.loginService = loginService;
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

    @GetMapping("/registerCourse")
    public String registerCourse(Model model) {
        model.addAttribute("registerCourse");
        return "student_course_registration";
    }    
    
    // Get the login Email-Passowrd inputs from user and check if they are in the database so the user(instructor) can navigate to home page
    @PostMapping("/login")
    public String login(@ModelAttribute Professor professorModel, StudentService studentService, Model model, Model modelStudent) {

        // Calling a method to check if the inputs are in the database
        Boolean checkLogin = loginService.LoginAsProfessorOrStudentCheck(professorModel.getEmail(), professorModel.getPassword());

        if (checkLogin == false){
            return "error_page";
        }

        if(loginService.isProfessor()) {
            List<Professor> professor = professorService.getProfessor(loginService.getEmail());
            coursesService.setProfessorID(professor.get(0).getProfessorid());
            model.addAttribute("userLogin", professor.get(0).getProfessorName());
            return "home_page";	
        }else if(loginService.isStudent()){
            List<Student> student = studentService.getByEmail(loginService.getEmail());
            modelStudent.addAttribute("userLogin", student.get(0).getFullname());
            return "student_page";
        }else{
            return "redirect:/login";
        }
    }
    
}
