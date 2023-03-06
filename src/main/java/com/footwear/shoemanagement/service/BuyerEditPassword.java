package com.footwear.shoemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.footwear.shoemanagement.model.Buyer;
import com.footwear.shoemanagement.repository.BuyerRepository;

@Service
public class BuyerEditPassword {


	@Autowired
	private BuyerRepository buyerRepository;
		

	public ResponseEntity<String> editBuyerPassword(String userName, String password,long skey, String newPassword)
	{
		Buyer b1=buyerRepository.getByUsername(userName);
		
		if(b1.getsKey()==skey) 
		{
			if(b1.getPassword().equals(password))
			{
				if(newPassword.isBlank())
				{
					return ResponseEntity.status(400).body("Password cannot be blank");
				}
				else
				if(newPassword.contains(" "))
				{
					return ResponseEntity.status(400).body("Password cannot contain spaces");
				}
				else
				{
					b1.setPassword(newPassword);
					buyerRepository.save(b1);
					return ResponseEntity.status(200).body("Password updated");
				}
			}
			else 
				return ResponseEntity.status(400).body("Wrong password entered...");
		}
		else 
			return ResponseEntity.status(400).body("Session expired");
	}
	
	
}
