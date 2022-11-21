package com.footwear.shoemanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.footwear.shoemanagement.model.Buyer;
@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Integer>{

	public Buyer getByUsername(String username);
	public Buyer getByMobileno(long mobileno);
	public Buyer getByEmail(String email);
}
