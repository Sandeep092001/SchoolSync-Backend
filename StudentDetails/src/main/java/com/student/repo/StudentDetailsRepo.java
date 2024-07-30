package com.student.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.model.Student;

@Repository
public interface StudentDetailsRepo extends JpaRepository<Student, Long> {

	List<Student> findBySchoolUsername(String schoolUsername);

	@Query(nativeQuery = true, value = "SELECT * FROM student WHERE s_id = :s_id AND school_username = :username")
	Optional<Student> findByIdAndUsername(Long s_id, String username);

	@Query(nativeQuery = true, value = "SELECT * FROM student WHERE school_username = :schoolUsername AND s_id = :searchVal")
	List<Student> findByRollNo(String schoolUsername, Long searchVal);

	@Query(nativeQuery = true, value = "SELECT * FROM student WHERE school_username = :schoolUsername AND standard = :searchVal")
	List<Student> findByStandard(String schoolUsername, Long searchVal);

	@Query(nativeQuery = true, value = "SELECT * FROM student WHERE school_username = :schoolUsername AND student_fname LIKE :searchVal")
	List<Student> findByName(String schoolUsername, String searchVal);
}