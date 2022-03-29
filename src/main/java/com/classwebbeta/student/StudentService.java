package com.classwebbeta.student;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// StudentService is linked with the Repository to Add, Update, Delete etc. students from the database
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
    
	
	// Get all students by the course they attend
	public List<Student> getByCourseAttending(Integer courseAttending){
		return studentRepository.findByCourseAttending(courseAttending);
	}

	// Update Student
	public void updateStudent(Student student) {
		studentRepository.save(student);
	}
	
	// Add new Student
	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	// Delete Student
	public void deleteStudent(Integer studentid){
		studentRepository.deleteById(studentid);
	}
	
	// Calculate the Grade Statistics of the Course
	public List<Double> getStatistics(Integer courseAttending){
		DescriptiveStatistics stats = new DescriptiveStatistics();
        int count = 0;
		int passed = 0;
        List<Student> allStudents = studentRepository.findByCourseAttending(courseAttending);
		List<Double> statistics = new ArrayList<Double>();
        for(int i=0; i<allStudents.size(); i++){
			if (!allStudents.get(i).getFinalGrade().equals("-") || !allStudents.get(i).getFinalGrade().equals("")){
				Double grade = Double.parseDouble(allStudents.get(i).getFinalGrade());
				stats.addValue(grade);
				count++;
				if( grade >=5 ){
					passed++;
				}
            }
        }
		double sum = stats.getSum();
		double mean = stats.getMean();
		double min = stats.getMin();
		double max = stats.getMax();
		double standardDeviation = stats.getStandardDeviation();
		double variance = stats.getVariance(); 
		double skewness = stats.getSkewness();
		double kurtosis = stats.getKurtosis();
		double median = stats.getPercentile(50);
        double average = sum/count;
		double successRate = (passed/count)*100;
		statistics.add(0, average);
		statistics.add(1, mean);
		statistics.add(2, min);
		statistics.add(3, max);
		statistics.add(4, standardDeviation);
		statistics.add(5, variance);
		statistics.add(6, skewness);
		statistics.add(7, kurtosis);
		statistics.add(8, median);
		statistics.add(9, successRate);
		return statistics;
	}
 	
}
