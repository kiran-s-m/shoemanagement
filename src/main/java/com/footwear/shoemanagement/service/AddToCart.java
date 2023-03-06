package com.footwear.shoemanagement.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.footwear.shoemanagement.model.Shoes;
import com.footwear.shoemanagement.repository.BuyerRepository;
import com.footwear.shoemanagement.repository.ShoeRepository;

@Service
public class AddToCart {

	@Autowired
	private ShoeRepository shoeRepository;
	
	@Autowired
	private BuyerRepository buyerRepository;
	
	Map<String, Object> map=new HashMap<>();
	List<Shoes>list=new ArrayList<>();
	double price=0;
	
	public ResponseEntity<String> addCart(int userId, long skey, int shoeId)
	{

		if(shoeRepository.findById(shoeId) != null)
		{	Shoes s=shoeRepository.getById(shoeId);
		
			if(userId==(shoeRepository.findById(shoeId)).get().getSellerId())
			{
				return ResponseEntity.status(400).body("The product is already yours. \nYou cannot purchase your own products.");
			}
			else
//				if(s.isInCart())
//				{
//					if(s.getInCartUserId()==userId)
//					{
//						return ResponseEntity.status(400).body("The product is already added in your cart.");
//					}
//					return ResponseEntity.status(400).body("The product is in the cart of user by UserID "+s.getInCartUserId()+" and name "+buyerRepository.getById(s.getInCartUserId()).getFirstName()+" "+buyerRepository.getById(s.getInCartUserId()).getLastName());
//				}
//				else
				if(list.contains(s) )
			{
					return ResponseEntity.status(400).body("The product is already added to the cart and total cart price is "+price+" Rs. ONLY");
			}
			else
			{
//				s.setInCart(true);
//				s.setInCartUserId(userId);
//				shoeRepository.save(s);
				price=price+s.getPrice();
				list.add(s);
				return ResponseEntity.status(201).body("Shoe added to cart and total cart price is "+price+" Rs. ONLY");
			}
			
		}
		else
			return ResponseEntity.status(404).body("Shoe does not exist");
	}
	
	
	
	
	public ResponseEntity<Map<String, Object>> cart(String userName, long skey)
	{
		map.put("price", price);
		map.put("cartItems", list);
		return ResponseEntity.status(200).body(map);
	}
}
