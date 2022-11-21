package com.footwear.shoemanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.footwear.shoemanagement.model.Buyer;
import com.footwear.shoemanagement.model.Shoes;
import com.footwear.shoemanagement.repository.BuyerRepository;
import com.footwear.shoemanagement.repository.ShoeRepository;

@Service
@Transactional
public class BuyerDelete {

	@Autowired
	private BuyerRepository buyerRepository;
	
	@Autowired
	private ShoeRepository shoeRepository;
	
	public ResponseEntity<String> deleteUserAccount(String username,String password,long skey)
	{
		Buyer b1=buyerRepository.getByUsername(username);
		if(b1!=null)
		{
			
			if(b1.getsKey()!=0 && b1.getsKey()==skey)
			{
				if(b1.getPassword().equals(password))
			{
				int userid=b1.getUserid();
				System.out.println(userid);

//				List<Shoes> shoes=shoeRepository.getAllBySellerId(userid);
				shoeRepository.deleteBySellerId(userid);
//				System.out.println(shoes);
				
				buyerRepository.delete(b1);
				return ResponseEntity.status(200).body("User account and all his products are deleted succesfully");
			}
				else 
					return ResponseEntity.status(401).body("Wrong password");
			}
				else 
					return ResponseEntity.status(401).body("Session expired");
			}
			
		else
			return ResponseEntity.status(401).body("User does not exist");
		
	}
}
