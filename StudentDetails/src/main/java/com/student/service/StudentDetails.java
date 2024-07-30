package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.student.model.Student;

public interface StudentDetails {
    
	Student addStudentDetails(Student student);
	ResponseEntity<String> deleteStudentDetails(Long id);
	Student updateStudentDetails(Long id,Student student);
	
	List<Student> ListAllStudents(String schoolUsername);
	
	Optional<Student> findStudentDetail(Long id, String username);
	List<Student> searchByRollNo(String schoolUsername, Long searchVal);
	List<Student> searchByStandard(String schoolUsername, Long searchVal);
	List<Student> searchByName(String schoolUsername, String searchVal);
	void updateUsername(String oldusername, String newusername);	
}