package com.footwear.shoemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.footwear.shoemanagement.model.Shoes;
import com.footwear.shoemanagement.repository.ShoeRepository;

@Service
public class GetByType {

	@Autowired
	private ShoeRepository shoeRepository;
	
	public ResponseEntity<List<Shoes>> getByType(String type)
	{
		List<Shoes> list=shoeRepository.findByType(type);
		if(list.size()>0)
		return ResponseEntity.status(200).body(list);
		else
		return ResponseEntity.status(404).build();
	}
}
