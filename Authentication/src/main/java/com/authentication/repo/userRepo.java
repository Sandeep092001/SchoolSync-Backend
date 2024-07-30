package com.authentication.repo;
import com.authentication.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends JpaRepository<User, Long> {
  public Optional<User> findByUsername(String username);
}