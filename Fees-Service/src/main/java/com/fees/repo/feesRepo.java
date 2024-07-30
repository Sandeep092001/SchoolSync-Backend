package com.fees.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.fees.model.Fees;

@Repository
public interface feesRepo extends JpaRepository<Fees, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM fees WHERE s_id=:s_id AND username=:username")
	Optional<Fees> findByIdAndUsername(Long s_id, String username);
  
//	@Modifying
//	@Transactional
//	@Query(nativeQuery = true, value = "UPDATE fees SET january = :payment_proof WHERE s_id = :s_id")
//	int updateFeesStatus(Long s_id, String payment_proof);
	
	Fees findByUsername(String username);
	
}