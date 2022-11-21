package com.footwear.shoemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.footwear.shoemanagement.model.Buyer;
import com.footwear.shoemanagement.model.Shoes;

@Repository
public interface ShoeRepository extends JpaRepository<Shoes, Integer>{
	
	public List<Shoes> getAllBySellerId(int sellerId);
	
//	public List<Shoes> deleteAllBySellerId(int sellerId);

	public List<Shoes> deleteBySellerId(int sellerId);

}
