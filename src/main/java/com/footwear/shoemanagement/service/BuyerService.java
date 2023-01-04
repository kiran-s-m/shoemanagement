package com.footwear.shoemanagement.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.footwear.shoemanagement.model.Buyer;

@Service
public class BuyerService {

	
	public Map<String, Object> getEnteredList()
	{
		Map<String, Object> enteredData=new HashMap<>();
		
		Buyer b1=new Buyer(1001, "kiransm007", "Kiran", "S M", "Kiransm007", 9738461936l, "Bengaluru", "kiransm007@gmail.com");
		Buyer b2=new Buyer(1002, "kiransm", "S M", "Kiran", "Kiransm", 9945097274l, "Mysuru", "kiransm@live.com");
		
		enteredData.put("obj1", b1);
		enteredData.put("obj2", b2);
		
		return enteredData;
		
	}

}
