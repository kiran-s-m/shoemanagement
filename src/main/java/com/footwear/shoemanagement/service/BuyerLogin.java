package com.footwear.shoemanagement.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.footwear.shoemanagement.model.Buyer;
import com.footwear.shoemanagement.model.Shoes;
import com.footwear.shoemanagement.repository.BuyerRepository;
import com.footwear.shoemanagement.repository.ShoeRepository;


@Service
public class BuyerLogin {

	@Autowired
	private BuyerRepository buyerRepository;
	
	@Autowired
	private BuyerSignup signup;
	
	@Autowired
	private ShoeRepository shoeRepository;
	
	public ResponseEntity<List<Object>> getBuyer(String username,String password)
	{	
		 Buyer b1 = buyerRepository.getByUsername(username);
		 List<Object>list=new ArrayList<>();
		 if(b1!=null)
		 {
			 if(b1.getPassword().equals(password))
				{
				long skey=(long) (Math.random()*100000000);
				b1.setsKey(skey);
				signup.saveBuyer(b1);
				System.out.println(skey);
	 
				
				System.out.println("Logged in successfully");
//				return "Logged in successfully";

				list.add("User logged in successfully");
				
				list.add(b1.getUserid());
				list.add(skey);
				list.add(username);
				list.add(shoeRepository.findAll());
				return ResponseEntity.status(200).body(list);
				}
			else
			{
				System.out.println("Password is incorrect");
//				return "Password is incorrect";
				list.add("Password is incorrect...");
				return ResponseEntity.status(401).body(list);
			}
		 }
		 else
		 {
			System.out.println("User does not exist");
//			return "User does not exist";
			list.add("User does not exist");
			return ResponseEntity.status(401).body(list);
		 }
		 
	}
}
