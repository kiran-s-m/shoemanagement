package com.footwear.shoemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.footwear.shoemanagement.model.Shoes;
import com.footwear.shoemanagement.service.GetByColor;
import com.footwear.shoemanagement.service.GetBySize;
import com.footwear.shoemanagement.service.GetByType;

@RestController
@RequestMapping("/loginBuyer")
public class FilterControllerClass {

	@Autowired
	private GetByColor byColor;
	
	@RequestMapping("/filterByColor")
	public ResponseEntity<List<Shoes>> searchByColor(@RequestHeader String color)
	{
		return byColor.getByColor(color);	
	}
	
	@Autowired
	private GetBySize bySize;
	
	@RequestMapping("/filterBySize")
	public ResponseEntity<List<Shoes>> searchBySize(@RequestHeader double size)
	{
		return bySize.getBySize(size);	
	}
	
	@Autowired
	private GetByType byType;
	
	@RequestMapping("/filterByType")
	public ResponseEntity<List<Shoes>> searchByType(@RequestHeader String type)
	{
		return byType.getByType(type);
	}
}
