package com.footwear.shoemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.footwear.shoemanagement.model.Shoes;
import com.footwear.shoemanagement.service.GetByColor;
import com.footwear.shoemanagement.service.GetBySize;
import com.footwear.shoemanagement.service.GetByType;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/loginBuyer")
public class FilterControllerClass {

	@Autowired
	private GetByColor byColor;
	
	@Tag(description = "Method used to get filtered data based on color", name = "To get")
	@GetMapping("/filterByColor")
	public ResponseEntity<List<Shoes>> searchByColor(@RequestHeader String color)
	{
		return byColor.getByColor(color);	
	}
	
	@Autowired
	private GetBySize bySize;
	
	@Tag(description = "Method used to get filtered data based on size", name = "To get")
	@GetMapping("/filterBySize")
	public ResponseEntity<List<Shoes>> searchBySize(@RequestHeader double size)
	{
		return bySize.getBySize(size);	
	}
	
	@Autowired
	private GetByType byType;
	
	@Tag(description = "Method used to get filtered data based on shoe type", name = "To get")
	@GetMapping("/filterByType")
	public ResponseEntity<List<Shoes>> searchByType(@RequestHeader String type)
	{
		return byType.getByType(type);
	}
}
