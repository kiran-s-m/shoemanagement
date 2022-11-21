package com.footwear.shoemanagement.service;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Object> addShoeDetails(Shoes shoe,int userid,long skey)
	{
		List<Object>list=new ArrayList<>();
		Buyer b1=buyerRepository.getById(userid);
		System.out.println(b1.getMobileno());
		if(b1.getsKey()==skey)
		{
			shoe.setSellerId(userid);
			Shoes s1=shoeRepository.save(shoe);
			list.add(s1);
		}
		else
		{
			list.add("User session expired");
		}
		return list;
		
	}
}
