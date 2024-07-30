package com.authentication.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(value="STUDENTDETAILS", url="http://localhost:8086")
public interface studentClient {
	  @PutMapping("/updateUsername/{oldusername}/{newusername}")
	   void updateUsername(@PathVariable String oldusername, @PathVariable String newusername);
}