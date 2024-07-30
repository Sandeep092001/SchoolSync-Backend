package com.fees.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fees.model.Fees;
import com.fees.repo.feesRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
public class feesServiceImpl implements feesService {

	Fees feesObj = new Fees();

	@Autowired
	feesRepo feesRepo;

	@Autowired
	private EntityManager entityManager;

	@Override
	public Fees depositFees(String month) {
		return null;
	}

	@Override
	public Fees createFeesTableForStudent(Long s_id, String username) {
		feesObj.setS_id(s_id);
		feesObj.setUsername(username);
		feesObj.setJanuary("Unpaid");
		feesObj.setFebruary("Unpaid");
		feesObj.setMarch("Unpaid");
		feesObj.setApril("Unpaid");
		feesObj.setMay("Unpaid");
		feesObj.setJune("Unpaid");
		feesObj.setJuly("Unpaid");
		feesObj.setAugust("Unpaid");
		feesObj.setSeptember("Unpaid");
		feesObj.setOctober("Unpaid");
		feesObj.setNovember("Unpaid");
		feesObj.setDecember("Unpaid");

		Fees SavedData = feesRepo.save(feesObj);
		return SavedData;
	}

	@Transactional
	@Override
	public String submitStudentFees(String month, Long s_id, String payment_proof, String username) {

		try {
			String sql = "UPDATE fees SET " + month.toLowerCase()
					+ " = :payment_proof WHERE s_id = :s_id AND username = :username";
			Query query = entityManager.createNativeQuery(sql);
			query.setParameter("payment_proof", payment_proof);
			query.setParameter("s_id", s_id);
			query.setParameter("username", username);

			int rowsUpdated = query.executeUpdate();

			if (rowsUpdated > 0) {
				return "Update successful";
			} else {
				return "No records updated";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Error updating fees: " + e.getMessage();
		}
	}

	@Transactional
	@Override
	public boolean checkFeesPaymentStatus(Long id, String month, String username) {
		try {
			String sql = "SELECT " + month.toLowerCase() + " FROM fees WHERE s_id=:s_id AND username = :username";
			Query query = entityManager.createNativeQuery(sql);
			query.setParameter("s_id", id);
			query.setParameter("username", username);
			String result = query.getSingleResult().toString();

			if (!result.equalsIgnoreCase("Unpaid")) {
				System.out.println(result);
				return true;
			}
		} catch (Exception e) {
			System.out.println("error is :" + e.getMessage());
		}
		return false;
	}

	@Override
	public Optional<Fees> getFeeDetails(Long s_id, String username) {
		return feesRepo.findByIdAndUsername(s_id, username);
	}

	@Transactional
	@Override
	public void updateUsername(String oldusername, String newusername) {
		 try {
				String sql = "UPDATE fees SET username=:newusername WHERE username=:oldusername";
				Query query = entityManager.createNativeQuery(sql);
				query.setParameter("oldusername", oldusername);	
				query.setParameter("newusername", newusername);	
				int rowsUpdated = query.executeUpdate();
				System.out.println("Number of rows updated: " + rowsUpdated);
			} catch (Exception e) {
				System.out.println("error is :" + e.getMessage());
			}
	
	}
	
	
}
