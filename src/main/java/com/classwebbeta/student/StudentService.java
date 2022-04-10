package com.classwebbeta.student;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// StudentService is 'linked' with the Repository to Add, Update, Delete etc. students from the database
@Service
public class StudentService {

	@Autowired
	private final StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	Integer courseAttending;
	private Integer examGradePR;
    private Integer projectGradePR;

    public Integer getCourseAttending(){
        return courseAttending;
    }

    public void setCourseAttending(Integer courseAttending){
        this.courseAttending = courseAttending;
    }

    public void setExamGradePR(Integer examGradePR){
        this.examGradePR = examGradePR;
    }

    public Integer getExamGradePR(){
        return examGradePR;
    }

    public void setProjectGradePR(Integer projectGradePR){
      this.projectGradePR = projectGradePR;
    }

    public Integer getProjectGradePR(){
        return projectGradePR;
    }
    
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}

	public List<Student> getStudent(Integer studentid){
		return studentRepository.findByStudentid(studentid);
	}

	public List<Student> getByEmail(String email){
		return studentRepository.findByEmail(email);
	}

	public List<Student> getByEmailAndPassword(String email, String password){
		return studentRepository.findByEmailAndPassword(email, password);

	}

	// Get all students by the course they attend
	public List<Student> getByCourseAttending(Integer courseAttending){
		return studentRepository.findByCourseAttending(courseAttending);
	}

	// Update Student
	public void updateStudent(Student student) {
		student.setCourseAttending(getCourseAttending());
      	student.setYearOfStudies(student.getYearOfStudies());
      	student.setSyllabus(student.getSyllabus());
      	student.setSemester(student.getSemester());
		studentRepository.save(student);
	}
	
	// Add new Student
	public void addStudent(Student student) {
		student.setCourseAttending(getCourseAttending());
      	student.setYearOfStudies(student.getYearOfStudies());
      	student.setSyllabus(student.getSyllabus());
      	student.setSemester(student.getSemester());
		studentRepository.save(student);
	}

	public void addRandomStudent(Student student){
		studentRepository.save(student);
	}

	// Delete Student
	public void deleteStudent(Student student){
		studentRepository.delete(student);
	}

	public Boolean isValidStudentIdAndEmail(Student student){
		Integer studentid = student.getStudentid();
		String email = student.getEmail();

		if (studentRepository.existsById(studentid)){
			System.out.println("Error. StudentID already exists!");
			return false;
		}else{
			if (studentRepository.existsByEmail(email)){
				System.out.println("Error. Email already exists!");
				return false;
			}else{
				//nothing
				return true;
			}
		}
		
	}

	public void isValidInputGrade(Student student){
		if ((student.getExamGrade().equals("") && student.getProjectGrade().equals("")) || (student.getExamGrade().equals("-") && student.getProjectGrade().equals("-")) ){
			student.setExamGrade("-");
			student.setProjectGrade("-");
			student.setFinalGrade("-");
		}else{
		  // If project percentage is > 0 then calculate it
		  if (getProjectGradePR() > 0){
			  Double projectGradeWithPercentage = Double.parseDouble(student.getProjectGrade())*(getProjectGradePR().floatValue()/100);
			  Double examGradeWithPercentage = Double.parseDouble(student.getExamGrade())*(getExamGradePR().floatValue()/100);
			  // If exam grade is < 5 the final grade = exam grade
			  if (Double.parseDouble(student.getExamGrade()) < 5){
				  student.setFinalGrade(student.getExamGrade());
			  }else{
				Double finalGrade = examGradeWithPercentage + projectGradeWithPercentage;
				String decimalPart[] = new String[15];
				decimalPart = String.valueOf(finalGrade).split("");
				if (Integer.parseInt(decimalPart[2]) > 5){
					finalGrade = Double.parseDouble(decimalPart[0]) + 1;
				}else if (Integer.parseInt(decimalPart[2]) < 5){
					finalGrade = Double.parseDouble(decimalPart[0]);
				}else{
					finalGrade = Double.parseDouble(decimalPart[0]) + 0.5;
				}

				DecimalFormat df = new DecimalFormat("#.##");
				student.setFinalGrade(String.valueOf(df.format(finalGrade)).replace(",", "."));
			  }
		  }else{
			  student.setFinalGrade(student.getExamGrade());
		  }
		  student.setExamGrade(student.getExamGrade());
		  student.setProjectGrade(student.getProjectGrade());
		}
		studentRepository.save(student);
	}
 	
}
