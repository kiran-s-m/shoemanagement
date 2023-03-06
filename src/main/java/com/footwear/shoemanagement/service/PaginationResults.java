package com.footwear.shoemanagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.footwear.shoemanagement.model.Shoes;
import com.footwear.shoemanagement.repository.ShoeRepository;

@Service
public class PaginationResults {

	@Autowired
	private ShoeRepository shoeRepository;
	
	public List<Shoes> getByPages(int itemsPerPage, int pageNo)
	{
		PageRequest sortedByPrice= PageRequest.of(pageNo,itemsPerPage, Sort.by("price","size").ascending());
		Page<Shoes> result=shoeRepository.findAll(sortedByPrice);
		
		if(result.getSize()>0)
		return result.toList();
		else
		return null;
	}
}