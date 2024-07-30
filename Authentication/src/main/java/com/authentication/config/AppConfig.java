package com.authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

//    @Bean
//    public UserDetailsService userDetailsService() {	
//		UserDetails user = User.builder().username("user").password(passwordEncoder().encode("user")).roles("ADMIN").build();
//		UserDetails user1 = User.builder().username("user1").password(passwordEncoder().encode("user1")).roles("ADMIN").build();
//		UserDetails user2 = User.builder().username("deepak").password(passwordEncoder().encode("aklecha")).roles("ADMIN").build();
//		return new InMemoryUserDetailsManager(user, user1, user2);
//	}

    @Bean
    public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}