package com.fees.service;

import java.util.Optional;

import com.fees.model.Fees;

public interface feesService {
   Fees depositFees(String month);
   Fees createFeesTableForStudent(Long i, String username);
   String submitStudentFees(String month, Long s_id, String payment_proof, String username);
   boolean checkFeesPaymentStatus(Long id, String month, String username);
   Optional<Fees> getFeeDetails(Long s_id, String username);
   void updateUsername(String oldusername, String newUsername);   
}
