package com.footwear.shoemanagement.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footwear.shoemanagement.model.Buyer;
import com.footwear.shoemanagement.model.Shoes;
import com.footwear.shoemanagement.repository.BuyerRepository;
import com.footwear.shoemanagement.repository.ShoeRepository;

@Service
public class AddShoes {

	@Autowired
	private ShoeRepository shoeRepository;
	
	@Autowired
	private BuyerRepository buyerRepository;
	
	public Map<String, Object> addShoeDetails(Shoes shoe,int userid,long skey)
	{
		Map<String, Object> shoeMap=new HashMap<>();
		Buyer b1=buyerRepository.getById(userid);
		System.out.println(b1.getMobileno());
		if(b1.getsKey()==skey)
		{
			shoe.setSellerId(userid);
			Shoes s1=shoeRepository.save(shoe);
			shoeMap.put("objects", s1);
			
		}
		else
		{
			shoeMap.put("msg", "User session expired");
		}
		return shoeMap;
		
	}
}
