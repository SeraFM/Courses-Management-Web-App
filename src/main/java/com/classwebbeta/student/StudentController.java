package com.classwebbeta.student;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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
    	student.setCourseAttending(studentService.getCourseAttending());
      student.setYearOfStudies(student.getYearOfStudies());
      student.setSyllabus(student.getSyllabus());
      student.setSemester(student.getSemester());
      if ((student.getExamGrade().equals("") && student.getProjectGrade().equals("")) || (student.getExamGrade().equals("-") && student.getProjectGrade().equals("-")) ){
          student.setExamGrade("-");
          student.setProjectGrade("-");
          student.setFinalGrade("-");
      }else{
        // If project percentage is > 0 then calculate it
        if (studentService.getProjectGradePR() > 0){
            Double projectGradeWithPercentage = Double.parseDouble(student.getProjectGrade())*(studentService.getProjectGradePR().floatValue()/100);
            Double examGradeWithPercentage = Double.parseDouble(student.getExamGrade())*(studentService.getExamGradePR().floatValue()/100);
            // If exam grade is < 5 the final grade = exam grade
            if (Double.parseDouble(student.getExamGrade()) < 5){
                student.setFinalGrade(student.getExamGrade());
            }else{
              Double finalGrade = examGradeWithPercentage + projectGradeWithPercentage;
              DecimalFormat df = new DecimalFormat("#.##");
              student.setFinalGrade(String.valueOf(df.format(finalGrade)).replace(",", "."));
            }
        }else{
            student.setFinalGrade(student.getExamGrade());
        }
        student.setExamGrade(student.getExamGrade());
        student.setProjectGrade(student.getProjectGrade());
      }
    	System.out.println("Added New Student: " + student.toString());
    	studentService.addStudent(student);
    	return "redirect:/courses/students/?courseAttending=" + studentService.getCourseAttending();
    }
    
    // Update Student. Post Request to get the data from the Update Student form and put it in the Repository(database)
    @PostMapping(value="/updateStudent")
    public String updateStudent(Student student) {
      student.setCourseAttending(studentService.getCourseAttending());
      student.setYearOfStudies(student.getYearOfStudies());
      student.setSyllabus(student.getSyllabus());
      student.setSemester(student.getSemester());
      if ((student.getExamGrade().equals("") && student.getProjectGrade().equals("")) || (student.getExamGrade().equals("-") && student.getProjectGrade().equals("-")) ){
        student.setExamGrade("-");
        student.setProjectGrade("-");
        student.setFinalGrade("-");
      }else{
        // If project percentage is > 0 then calculate it
        if (studentService.getProjectGradePR() > 0){
            Double projectGradeWithPercentage = Double.parseDouble(student.getProjectGrade())*(studentService.getProjectGradePR().floatValue()/100);
            Double examGradeWithPercentage = Double.parseDouble(student.getExamGrade())*(studentService.getExamGradePR().floatValue()/100);
            // If exam grade is < 5 the final grade = exam grade
            if (Float.parseFloat(student.getExamGrade()) < 5){
                student.setFinalGrade(student.getExamGrade());
            }else{
              Double finalGrade = examGradeWithPercentage + projectGradeWithPercentage;
              DecimalFormat df = new DecimalFormat("#.##");
              student.setFinalGrade(String.valueOf(df.format(finalGrade)).replace(",", "."));
            }
        }else{
          student.setFinalGrade(student.getExamGrade());
        }
        student.setExamGrade(student.getExamGrade());
        student.setProjectGrade(student.getProjectGrade());
      }
		  studentService.updateStudent(student);
    	return "redirect:/courses/students/?courseAttending=" + studentService.getCourseAttending();
    }
      
    // Delete Student by ID 
    @DeleteMapping(value="/delete")
    public String deleteStudent(Integer studentid) {
    	studentService.deleteStudent(studentid);
    	return "redirect:/courses/students/?courseAttending=" + studentService.getCourseAttending();
    }

    @PostMapping(value="stats")
    public String stats(){
      List<Double> statistics = studentService.getStatistics(studentService.getCourseAttending());
      System.out.println("AVERAGE: " + statistics.get(0));
      System.out.println("MEAN: " + statistics.get(1));
      System.out.println("MIN: " + statistics.get(2));
      System.out.println("MAX: " + statistics.get(3));
      System.out.println("STANDARD DEVIATION: " + statistics.get(4));
      System.out.println("VARIANCE: " + statistics.get(5));
      System.out.println("SKEWNESS: " + statistics.get(6));
      System.out.println("KURTOSIS: " + statistics.get(7));
      System.out.println("MEDIAN: " + statistics.get(8));
      System.out.println("SUCCESS RATE: " + statistics.get(9));
      return "redirect:/courses/students/?courseAttending=" + studentService.getCourseAttending();
    }

}
