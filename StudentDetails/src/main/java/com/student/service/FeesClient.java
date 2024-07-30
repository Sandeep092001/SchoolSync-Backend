package com.student.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.student.model.Fees;

@FeignClient(value="Fees-Service", url="http://localhost:8087")
public interface FeesClient {
   @PostMapping("/saveFeesData/{id}/{username}")
   Fees saveFeesData(@PathVariable Long id, @PathVariable String username);
}