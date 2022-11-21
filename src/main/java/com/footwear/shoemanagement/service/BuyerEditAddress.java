package com.footwear.shoemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.footwear.shoemanagement.model.Buyer;
import com.footwear.shoemanagement.repository.BuyerRepository;

@Service
public class BuyerEditAddress {


	@Autowired
	private BuyerRepository buyerRepository;
	
	
	
	public ResponseEntity<String> editBuyerAddress(String userName, String password,long skey, Buyer buyer)
	{
		Buyer b1=buyerRepository.getByUsername(userName);
		if(b1.getsKey()==skey) 
		{
			if(b1.getPassword().equals(password))
			{
				if(buyer.getAddress().isBlank())
				{
					return ResponseEntity.status(400).body("Address cannot be blank");
				}
				else
				{
					b1.setAddress(buyer.getAddress());
					
					buyerRepository.save(b1);
					return ResponseEntity.status(200).body("Address updated");
				}
			}
			else
				return ResponseEntity.status(200).body("Wrong password");
		}
		else
			return ResponseEntity.status(400).body("Session expired");
		
	}
	
}
