package com.authentication.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(value="FEES-SERVICE", url="http://localhost:8087")
public interface feesClient {
   @PutMapping("/updateUsername/{oldusername}/{newusername}")
   void updateUsername(@PathVariable String oldusername, @PathVariable String newusername);
}