package com.fees;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fees.model.Fees;
import com.fees.model.FeesSubmissionDetails;
import com.fees.service.feesService;

@RestController
public class FeesDepositController {

	@Autowired
	feesService feesService;

	@PostMapping("/saveFeesData/{id}/{username}")
	public Fees saveFeesData(@PathVariable Long id,@PathVariable String username) {
		return feesService.createFeesTableForStudent(id, username);
	}

	@PutMapping("/updateUsername/{oldusername}/{newusername}")
	public void updateUsername(@PathVariable String oldusername, @PathVariable String newusername) {
		System.out.println("hello"+ oldusername+newusername);
		feesService.updateUsername(oldusername, newusername);
	}
	
	@PutMapping("/submitFeesData")
	public String submitStudentFeesData(@RequestBody FeesSubmissionDetails feesSubmissionDetails) {
//		System.out.println(feesSubmissionDetails.toString());
//		return "";
		return feesService.submitStudentFees(feesSubmissionDetails.getMonth(), feesSubmissionDetails.getS_id(),
				feesSubmissionDetails.getPayment_status(), feesSubmissionDetails.getUsername());
	}
	
   @GetMapping("/checkFeesPaymentStatus/{id}/{month}/{username}")
   public boolean checkPaymentStatus(@PathVariable Long id, @PathVariable String month, @PathVariable String username) {
	   return feesService.checkFeesPaymentStatus(id, month, username);
   }
   
   @GetMapping("/getFeesDetails/{s_id}/{username}")
   public Optional<Fees> getFeesDetails(@PathVariable Long s_id, @PathVariable String username){
//	   System.out.println("Hello" +s_id);
	   
//	   return null;
	   return feesService.getFeeDetails(s_id, username);
   }

}