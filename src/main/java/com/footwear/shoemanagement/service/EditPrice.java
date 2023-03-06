package com.footwear.shoemanagement.service;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.footwear.shoemanagement.model.Buyer;
import com.footwear.shoemanagement.model.Shoes;
import com.footwear.shoemanagement.repository.BuyerRepository;
import com.footwear.shoemanagement.repository.ShoeRepository;

@Service
public class EditPrice {
	
@Autowired
private ShoeRepository shoeRepository;

@Autowired
private BuyerRepository buyerRepository;

public ResponseEntity<String> editPrice(int shoeId, int sellerId, long skey, String userName, String password, double newPrice)
{
	Buyer b1=buyerRepository.getByUsername(userName);
	Shoes s1=shoeRepository.getById(shoeId);
	
	if(s1.getSellerId()==sellerId)
	{
		if(b1.getsKey()==skey) 
		{
			if(b1.getPassword().equals(password))
			{
				LocalDateTime updateDate=LocalDateTime.now();
				s1.setUpdateDate(updateDate);
				
				s1.setPrice(newPrice);
				shoeRepository.save(s1);
				return ResponseEntity.status(200).body("Price updated to "+newPrice);
			}
			else
				return ResponseEntity.status(400).body("Password is incorrect... \nEnter the correct password. ");
		}
		else
			return ResponseEntity.status(400).body("Session expired");
	}
			return ResponseEntity.status(400).body("You cannot change the price of OTHER'S PRODUCTS...");

}
}
