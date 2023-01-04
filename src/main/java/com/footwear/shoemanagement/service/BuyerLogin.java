package com.footwear.shoemanagement.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.footwear.shoemanagement.model.Buyer;
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
	
	public ResponseEntity<Map<String, Object>> getBuyer(String username,String password)
	{	
		 Buyer b1 = buyerRepository.getByUsername(username);
		 
		 Map<String, Object>list=new HashMap<>();

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

				list.put("msg", "User logged in successfully");
				
				list.put("userid", b1.getUserid());
				list.put("skey", skey);
				list.put("username", username);

				list.put("shoes", shoeRepository.findAll());
				
				return ResponseEntity.status(200).body(list);
				}
			else
			{
				System.out.println("Password is incorrect");
//				return "Password is incorrect";
				list.put("msg","Password is incorrect...");
				return ResponseEntity.status(401).body(list);
			}
		 }
		 else
		 {
			System.out.println("User does not exist");
//			return "User does not exist";
			list.put("msg","User does not exist");
			return ResponseEntity.status(401).body(list);
		 }
		 
	}
}
