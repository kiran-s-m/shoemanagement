package com.footwear.shoemanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.footwear.shoemanagement.model.Buyer;

@Service
public class BuyerService {

	
	public List<Buyer> getEnteredList()
	{
		List<Buyer> list=new ArrayList<>();
		
		Buyer b1=new Buyer(1001, "kiransm007", "Kiran", "S M", "Kiransm007", 9738461936l, "Bengaluru", "kiransm007@gmail.com");
		Buyer b2=new Buyer(1002, "kiransm", "S M", "Kiran", "Kiransm", 9945097274l, "Mysuru", "kiransm@live.com");
		
		list.add(b1);
		list.add(b2);
		
		return list;
		
	}

}
