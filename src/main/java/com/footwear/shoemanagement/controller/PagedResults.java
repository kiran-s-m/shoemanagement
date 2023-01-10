package com.footwear.shoemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.footwear.shoemanagement.model.Shoes;
import com.footwear.shoemanagement.service.PaginationResults;

@RestController
public class PagedResults {

	@Autowired
	private PaginationResults paginationResults;
	
	@RequestMapping("/pagedResult")
	public ResponseEntity<List<Shoes>> searchByPrice(@RequestParam int pageNo, @RequestParam int itemsPerPage)
	{
		return ResponseEntity.status(200).body(paginationResults.getByPages(itemsPerPage, pageNo));
	}
}
