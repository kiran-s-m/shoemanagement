package com.footwear.shoemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.footwear.shoemanagement.model.Buyer;
import com.footwear.shoemanagement.repository.BuyerRepository;

@Service
public class BuyerSignup {


	
	@Autowired
	private BuyerRepository buyerRepository;
	
	public Buyer saveBuyer(Buyer buyer) {
		Buyer b1=buyerRepository.save(buyer);
		return b1;
	}
		
	public ResponseEntity<String> findBuyerExistsOrNot(Buyer buyer)
	{
		Buyer buyerusername = buyerRepository.getByUsername(buyer.getUsername());
		Buyer buyermob = buyerRepository.getByMobileno(buyer.getMobileno());
		Buyer buyeremail = buyerRepository.getByEmail(buyer.getEmail());
		
		if(buyerusername!=null)
			{
				System.out.println("\n\n Username already exists \n\n");
				return ResponseEntity.status(400).body("Username already exists");
//				return "Username already exists";
			}
		else if(buyermob!=null)
			{
				System.out.println("\n\n Mobile number already exists \n\n");
				return ResponseEntity.status(400).body("Mobile number already exists");
//				return "Mobile number already exists";

			}
			else 
			if(buyeremail!=null)
			{
				System.out.println("\n\n Email already exists \n\n");
				return ResponseEntity.status(400).body("Email already exists");
//				return "Email already exists";		
			}
			
		else
		{
			saveBuyer(buyer);
			System.out.println("User registered succesfully...");
			return ResponseEntity.status(200).body("User registered succesfully...");
//			return "User registered succesfully...";
		}
		
	}
	}