package com.authentication;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.authentication.model.User;
import com.authentication.service.userService;

@RestController
public class AuthController {
	
	@Autowired
	userService userService;
	
	@GetMapping
	public String Home() {
		return "hello bro";
	}
	
	@GetMapping("/current-user")
	public String getLoggedInUser(Principal principal) {		
		return principal.getName();
	}
	
	@GetMapping("/getUserDetails/{username}")
	public Optional<User> getUserDetails(@PathVariable String username) {
//		return "hello working";
		return userService.findUser(username);		
	}
	
	@PutMapping("updateUserDetails/{username}")
	public User updateUserDetails(@PathVariable String username, @RequestBody User user) {
		return userService.updateUserDetails(username, user);
	}
	
}