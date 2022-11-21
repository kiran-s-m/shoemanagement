package com.footwear.shoemanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.footwear.shoemanagement.model.Buyer;
import com.footwear.shoemanagement.repository.BuyerRepository;

@Service
public class BuyerEditName {


	@Autowired
	private BuyerRepository buyerRepository;
	
	
//	public ResponseEntity<List> editBuyer(String userName, String password,long skey, Buyer buyer)
//	{
//		Buyer buyermob = buyerRepository.getByMobileno(buyer.getMobileno());
//		Buyer buyeremail = buyerRepository.getByEmail(buyer.getEmail());
//		
//		List list=new ArrayList<>();
//		Buyer b1= buyerRepository.getByUsername(userName);
//		if((b1.getsKey()==skey) && b1.getUsername().equals(userName))
//		{
//			if(b1.getPassword().equals(password))
//			{
//				b1.setAddress(buyer.getAddress());
//				b1.setEmail(buyer.getEmail());
//				b1.setFirstName(buyer.getFirstName());
//				b1.setLastName(buyer.getLastName());
//				b1.setMobileno(buyer.getMobileno());
//				b1.setPassword(buyer.getPassword());
//				
//				
//				if(buyermob!=null)
//				{
//					System.out.println("\n\n Mobile number already exists \n\n");
//					list.add("Mobile number already exists");
//					return ResponseEntity.status(400).body(list);
//				}
//				else 
//				if(buyeremail!=null)
//				{
//					System.out.println("\n\n Email already exists \n\n");
//					list.add("Email already exists");
//					return ResponseEntity.status(400).body(list);	
//				}
//				
//			else
//			{
//				signup.saveBuyer(b1);
//				System.out.println("User data updated succesfully...");
//				list.add("User data updated succesfully...");
//				list.add(b1);
//				return ResponseEntity.status(200).body(list);
//			}
//
//			}
//			else
//			{
//				list.add("Incorrect password");
//				return ResponseEntity.status(400).body(list);
//			}			
//		}
//		else
//		{
//			list.add("Session expired");
//			return ResponseEntity.status(400).body(list);
//		}
//		
//	}
	
	public ResponseEntity<String> editBuyerName(String userName, String password,long skey, Buyer buyer)
	{
		Buyer b1=buyerRepository.getByUsername(userName);
		if(b1.getsKey()==skey) 
		{
			if(b1.getPassword().equals(password))
			{
				if(buyer.getFirstName().isBlank() || buyer.getLastName().isBlank())
				{
					return ResponseEntity.status(400).body("Name cannot be blank");
				}
				else
				{
					b1.setFirstName(buyer.getFirstName());
					b1.setLastName(buyer.getLastName());
					
					buyerRepository.save(b1);
					return ResponseEntity.status(200).body("Name updated");
				}
			}
			else
				return ResponseEntity.status(200).body("Wrong password");
		}
		else
			return ResponseEntity.status(400).body("Session expired");
		
	}
	
}
