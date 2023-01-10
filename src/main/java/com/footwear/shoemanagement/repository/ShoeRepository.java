package com.footwear.shoemanagement.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.footwear.shoemanagement.model.Shoes;

@Repository
public interface ShoeRepository extends JpaRepository<Shoes, Integer> {
	
	public List<Shoes> getAllBySellerId(int sellerId);
	
//	public List<Shoes> deleteAllBySellerId(int sellerId);

	public List<Shoes> deleteBySellerId(int sellerId);
	// List is used as there could be many products added from same user

	public List<Shoes> findByColor(String color);
	
	public List<Shoes> findBySize(double size);
	
	public List<Shoes> findByType(String type);
	
//	For pagination and sorting
//	public List<Shoes> findAllByPrice(double price, Pageable pageable);
	
}
