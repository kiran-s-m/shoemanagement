package com.footwear.shoemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shoes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shoeid;
	
	@Column(nullable = false)
	private String color;
	
	@Column(nullable = false)
	private double size;
	
	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private double rating;
	
	private int sellerId;

	public int getShoeid() {
		return shoeid;
	}

	public void setShoeid(int shoeid) {
		this.shoeid = shoeid;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}

	public Shoes(int shoeid, String color, double size, String type, double price, double rating, int sellerId) {
		super();
		this.shoeid = shoeid;
		this.color = color;
		this.size = size;
		this.type = type;
		this.price = price;
		this.rating = rating;
		this.sellerId = sellerId;
	}

	
	public Shoes() {
		super();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Shoe[Product ID= "+this.getShoeid()+" Type = "+this.getType()+" Color = "+this.getColor()+" Size = "+this.getSize()+" Price = "+this.getPrice()+" Rating = "+this.getRating()+" ]";
	}
	
	
	
}
