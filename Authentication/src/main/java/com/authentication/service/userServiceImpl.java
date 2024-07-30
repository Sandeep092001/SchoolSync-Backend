package com.authentication.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.authentication.model.User;
import com.authentication.repo.userRepo;
@Service
public class userServiceImpl implements userService {

	@Autowired
	private userRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private feesClient feesClient;

	@Autowired
	private studentClient studentClient;

	@Override
	public List<User> getUsers() {
		return userRepo.findAll();		
	}

	@Override
	public User createUser(User user) {
		user.setUserId(UUID.randomUUID().getLeastSignificantBits());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
	    return userRepo.save(user);
	}

	@Override
	public Optional<User> findUser(String username) {
		return userRepo.findByUsername(username);		
	}	

	@Override
	public User updateUserDetails(String username, User user) {
		  feesClient.updateUsername(username, user.getUsername());
		  studentClient.updateUsername(username, user.getUsername());
		  return userRepo.findByUsername(username)
	                .map(userDetails -> {
	                	userDetails.setUsername(user.getUsername());
	                	userDetails.setEmail(user.getEmail());
	                	userDetails.setSchoolName(user.getSchoolName());
	                    return userRepo.save(userDetails);
	                })
	                .orElseThrow(() -> new RuntimeException("Student not found with id " + username));		  
		  
	}
}
