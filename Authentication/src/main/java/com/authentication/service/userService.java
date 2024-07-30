package com.authentication.service;

import java.util.List;
import java.util.Optional;

import com.authentication.model.User;

public interface userService {
  
	public List<User> getUsers();
	public User createUser(User user);
	public Optional<User> findUser(String username);
	public User updateUserDetails(String username, User user);
	
//	public User getUserDetails(String username);
	
}
