package com.classwebbeta.student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomData {


    Random rand = new Random();
    
    private Integer studentid;
    private String fullname;
	private String email;
    private String password;
	private Integer yearOfRegistration;
    private Integer yearOfStudies;
    private Integer syllabus;
    private Integer semester;
    private Integer courseAttending;
	private String projectGrade;
    private String examGrade;
	private String finalGrade;
    private List<String> nameList = new ArrayList<String>();
    private List<String> surnameList = new ArrayList<String>();
    private List<Integer> year = new ArrayList<Integer>();


    public void ReadFile() {

        File namesFile = new File("C:\\Users\\seraf\\workspace\\classwebbeta\\src\\main\\java\\com\\classwebbeta\\NamesDatabases\\firstnames\\all.txt");
        try (Scanner myReader = new Scanner(namesFile)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                nameList.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        File surnamesFile = new File("C:\\Users\\seraf\\workspace\\classwebbeta\\src\\main\\java\\com\\classwebbeta\\NamesDatabases\\surnames\\all.txt");
        try (Scanner myReader = new Scanner(surnamesFile)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                surnameList.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
          
    }

    // Method to generate a random alphanumeric password of a specific length
    public static String generateRandomPassword(int len)
    {
        // ASCII range – alphanumeric (0-9, a-z, A-Z)
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
 
        // each iteration of the loop randomly chooses a character from the given
        // ASCII range and appends it to the `StringBuilder` instance
 
        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
 
        return sb.toString();
    }

    public void randomStudent(StudentService studentService) throws IOException{
    
        FileWriter file = new FileWriter("StudentRandomData.txt");
        file.write("StudentID,Full Name,Email,Year of Registration,Year of Studies,Syllabus,Semester,Course Attending,Project Grade,Exam Grade,Final Grade \n");
        courseAttending = 1;
        int j = 0;

        String[] randomgrades = new String[21];
        for (double i=0; i<10.5; i=i+0.5){
            randomgrades[j] = String.valueOf(i);
            j++;
        }

        for (int i=0; i<1000; i++){

            Student student = new Student(studentid, fullname, email, password, yearOfRegistration, yearOfStudies, syllabus, semester, courseAttending, projectGrade, examGrade, finalGrade);

            studentid = i+100;

            student.setStudentid(studentid);

            int p1 = rand.nextInt(nameList.size());
            int p2 = rand.nextInt(surnameList.size());
            fullname = nameList.get(p1) + " " + surnameList.get(p2);
            email = nameList.get(p1).toLowerCase() + "@uoi.gr";
            password = generateRandomPassword(7);

            student.setFullname(fullname);
            student.setEmail(email);

  
            year.add(2017);
            year.add(2018);
            year.add(2019);  
            year.add(2020);
            year.add(2021);

            int y = rand.nextInt(year.size());
            yearOfRegistration = year.get(y);

            student.setYearOfRegistration(yearOfRegistration);

            yearOfStudies = student.getYearOfStudies();
            student.setYearOfStudies(yearOfStudies);

            syllabus = student.getSyllabus();
            student.setSyllabus(syllabus);

            semester = student.getSemester();
            student.setSemester(semester);

            if (i==101 || i==201 || i==301 || i==401 || i==501 || i==601 || i==701 || i==801 || i==901){
                courseAttending++;
            }

            student.setCourseAttending(courseAttending);

            int pos1 = rand.nextInt(randomgrades.length);
            examGrade = randomgrades[pos1];

            int pos2 = rand.nextInt(randomgrades.length);
            projectGrade = randomgrades[pos2];
            
            student.setExamGrade(examGrade);
            student.setProjectGrade(projectGrade);

            finalGrade = "null";

            student.setFinalGrade(finalGrade);

            String allInOneString = studentid.toString() + "," +  fullname + "," + email + "," + password + "," + yearOfRegistration.toString() + "," + yearOfStudies.toString() + "," + syllabus.toString() + "," + semester.toString() + "," + courseAttending.toString() + "," + examGrade + "," + projectGrade + "," + finalGrade + "\n";
            file.write(allInOneString);

            studentService.addRandomStudent(student);
        }
    
        file.close();
    }
    
}
