package com.classwebbeta.login;

import com.classwebbeta.professor.ProfessorService;
import com.classwebbeta.student.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private boolean isStudent = false;
    private boolean isProfessor = false;
    private String Email;
    private String Password;
    

    public String getEmail() {
        return Email;
    }


    public void setEmail(String Email) {
        this.Email = Email;
    }


    public String getPassword() {
        return Password;
    }


    public void setPassword(String Password) {
        this.Password = Password;
    }


    public boolean isStudent() {
        return isStudent;
    }


    public void setStudent(boolean isStudent) {
        this.isStudent = isStudent;
    }


    public boolean isProfessor() {
        return isProfessor;
    }


    public void setProfessor(boolean isProfessor) {
        this.isProfessor = isProfessor;
    }


    @Autowired
	private final ProfessorService professorService;
    private final StudentService studentService;

  

    public LoginService(ProfessorService professorService, StudentService studentService) {
        this.professorService = professorService;
        this.studentService = studentService;
    }


    public Boolean LoginAsProfessorOrStudentCheck(String email, String password){
        if (professorService.authenticate(email, password).isEmpty() && studentService.getByEmailAndPassword(email, password).isEmpty()){
            System.out.println("Wrong Email. Please try again!");
            return false;
        }else if (!studentService.getByEmailAndPassword(email, password).isEmpty()){
            Email = email;
            Password = password;
            isStudent = true;
            return true;
        }else{
            Email = email;
            Password = password;
            isProfessor = true;
            return true;
        }
    }
    
}
