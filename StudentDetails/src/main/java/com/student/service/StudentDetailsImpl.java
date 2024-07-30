package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.model.Student;
import com.student.repo.StudentDetailsRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
public class StudentDetailsImpl implements StudentDetails {
	
	@Autowired
	StudentDetailsRepo studentRepo;
	
	@Autowired
	FeesClient feesClient;
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public Student addStudentDetails(Student student) {
		
		Student savedStudent = studentRepo.save(student);
		Long s_id = savedStudent.getS_id();
		String username = savedStudent.getSchoolUsername();
		System.out.println(s_id);
		feesClient.saveFeesData(s_id, username);
		return savedStudent;		
	}

	@Override
	public List<Student> ListAllStudents(String schoolUsername) {
		
		return studentRepo.findBySchoolUsername(schoolUsername);
	}
	
	@Override
	public Optional<Student> findStudentDetail(Long s_id, String username) {
		
		Optional<Student> student = studentRepo.findByIdAndUsername(s_id, username);
		System.out.println(student);
		return student;
	}

	@Override
	public Student updateStudentDetails(Long id, Student student) {
		  return studentRepo.findById(id)
	                .map(studentDetail -> {
	                	studentDetail.setStudent_fname(student.getStudent_fname());
	                	studentDetail.setAddress(student.getAddress());
	                	studentDetail.setEmail(student.getEmail());
	                	studentDetail.setGuradian_fname(student.getGuradian_fname());
	                	studentDetail.setGuradian_lname(student.getGuradian_lname());
	                	studentDetail.setStandard(student.getStandard());
	                	studentDetail.setStudent_lname(student.getStudent_lname());
	                    return studentRepo.save(studentDetail);
	                })
	                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));              
	}

	@Override
	public ResponseEntity<String> deleteStudentDetails(Long id) {
		 studentRepo.deleteById(id);
		 return ResponseEntity.ok("Data Successfully Deleted");
	}

	@Override
	public List<Student> searchByRollNo(String schoolUsername, Long searchVal) {
		return studentRepo.findByRollNo(schoolUsername, searchVal);		
	}

	@Override
	public List<Student> searchByStandard(String schoolUsername, Long searchVal) {
		return studentRepo.findByStandard(schoolUsername, searchVal);
	}

	@Override
	public List<Student> searchByName(String schoolUsername, String searchVal) {
		searchVal = "%"+searchVal+"%";
		return studentRepo.findByName(schoolUsername, searchVal);
	}

	@Transactional
	@Override
	public void updateUsername(String oldusername, String newusername) {
		 try {
				String sql = "UPDATE student SET school_username=:newusername WHERE school_username=:oldusername";
				Query query = entityManager.createNativeQuery(sql);
				query.setParameter("oldusername", oldusername);	
				query.setParameter("newusername", newusername);	
				int rowsUpdated = query.executeUpdate();
				System.out.println("Number of rows updated: " + rowsUpdated);
			} catch (Exception e) {
				System.out.println("error is :" + e.getMessage());
			}
	
	}
}