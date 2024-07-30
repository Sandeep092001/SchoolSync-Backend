package com.student.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long S_id;
	private String schoolUsername;
	private String Student_fname;
	private String Student_lname;
	private String Guradian_fname;
	private String Guradian_lname;
	private String email;
	private String standard;
	private String address;

	public Long getS_id() {
		return S_id;
	}

	public void setS_id(Long s_id) {
		S_id = s_id;
	}

	public String getSchoolUsername() {
		return schoolUsername;
	}

	public void setSchoolUsername(String schoolUsername) {
		this.schoolUsername = schoolUsername;
	}

	public String getStudent_fname() {
		return Student_fname;
	}

	public void setStudent_fname(String student_fname) {
		Student_fname = student_fname;
	}

	public String getStudent_lname() {
		return Student_lname;
	}

	public void setStudent_lname(String student_lname) {
		Student_lname = student_lname;
	}

	public String getGuradian_fname() {
		return Guradian_fname;
	}

	public void setGuradian_fname(String guradian_fname) {
		Guradian_fname = guradian_fname;
	}

	public String getGuradian_lname() {
		return Guradian_lname;
	}

	public void setGuradian_lname(String guradian_lname) {
		Guradian_lname = guradian_lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [S_id=" + S_id + ", Student_fname=" + Student_fname + ", Student_lname=" + Student_lname
				+ ", Guradian_fname=" + Guradian_fname + ", Guradian_lname=" + Guradian_lname + ", email=" + email
				+ ", standard=" + standard + ", address=" + address + "]";
	}

	
}