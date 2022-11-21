package com.footwear.shoemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.footwear.shoemanagement.model.Buyer;
import com.footwear.shoemanagement.repository.BuyerRepository;

@Service
public class BuyerLogout {

	@Autowired
	private BuyerRepository buyerRepository;
	
	
	public ResponseEntity<String> logoutBuyer(int userid, long skey)
	{
		Buyer u=buyerRepository.getById(userid);
		u.setsKey(0);
		buyerRepository.save(u);
		return ResponseEntity.status(200).body("Logged out succesfully");
	}
}
