package com.classwebbeta.course;


import java.util.List; 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<CoursesModel,Integer> {
 	
	List<CoursesModel> findByProfessorid(Integer professorid);
	
}
