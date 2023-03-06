package com.footwear.shoemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.footwear.shoemanagement.model.Shoes;
import com.footwear.shoemanagement.service.PaginationResults;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
public class PagedResults {

	@Autowired
	private PaginationResults paginationResults;
	
	@Tag(description = "Method used to get paginated data based on price", name = "To get paginated data")
	@GetMapping("/pagedResult")
	public ResponseEntity<List<Shoes>> searchByPrice(@RequestParam int pageNo, @RequestParam int itemsPerPage)
	{
		return ResponseEntity.status(200).body(paginationResults.getByPages(itemsPerPage, pageNo));
	}
}
