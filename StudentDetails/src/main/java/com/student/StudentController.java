package com.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.student.model.Student;
import com.student.service.StudentDetails;

import jakarta.ws.rs.Path;

@RestController
//@Controller
public class StudentController {
  
  @Autowired
  StudentDetails studentservice;
  
  @PostMapping("/addStudent")
  public ResponseEntity<String> addStudent(@RequestBody Student student) {
	  studentservice.addStudentDetails(student);
	  System.out.println(student.toString()); 
	  return ResponseEntity.ok("Student data received successfully");
  }

  @GetMapping("/listAll/{schoolUsername}")
  public List<Student> listAll(@PathVariable String schoolUsername){
//	System.out.println(studentservice.ListAllStudents());
	return studentservice.ListAllStudents(schoolUsername);
  }
  
  @GetMapping("/searchByRollNo/{schoolUsername}/{searchVal}")
  public List<Student> searchByRollNo(@PathVariable String schoolUsername,@PathVariable Long searchVal ){
	  return studentservice.searchByRollNo(schoolUsername, searchVal);
  }
  
  @GetMapping("/searchByClass/{schoolUsername}/{searchVal}")
  public List<Student> searchByStandard(@PathVariable String schoolUsername,@PathVariable Long searchVal ){
	  return studentservice.searchByStandard(schoolUsername, searchVal);
  }
  @GetMapping("/searchByName/{schoolUsername}/{searchVal}")
  public List<Student> searchByName(@PathVariable String schoolUsername,@PathVariable String searchVal ){
	  return studentservice.searchByName(schoolUsername, searchVal);
  }
  
  @GetMapping("/getStudentDetail/{s_id}/{username}")
  public Optional<Student> findStudent(@PathVariable Long s_id, @PathVariable String username) {
	  return studentservice.findStudentDetail(s_id, username);
  }
  
  @PutMapping("/updateStudentDetails/{id}")
  public ResponseEntity<String> updateStudent(@PathVariable Long id,@RequestBody Student student){
	  System.out.println(id);
	  System.out.println(student.toString());
	  studentservice.updateStudentDetails(id, student);
	  return ResponseEntity.ok("Student data received successfully");
  }

  @DeleteMapping("/deleteStudentDetails/{id}")
  public ResponseEntity<String> deleteStudentDetails(@PathVariable Long id){
	  System.out.println(id);
	studentservice.deleteStudentDetails(id);
	return ResponseEntity.ok("Student Deleted Successfully ");
  }
  
	@PutMapping("/updateUsername/{oldusername}/{newusername}")
	public void updateUsername(@PathVariable String oldusername, @PathVariable String newusername) {
		System.out.println("hello"+ oldusername+newusername);
		studentservice.updateUsername(oldusername, newusername);
	}
	
}