package com.footwear.shoemanagement.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Buyer {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;

	
	@Column(nullable = false, unique = true, length = 45)
	private String username;
	
	@Column(nullable = false, length = 45)
	private String firstName;
	
	@Column(nullable = false, length = 45)
	private String lastName;	
	
	@Column(nullable = false, length = 45)
	private String password;
	
	@Column(nullable = false, unique = true)
	private long mobileno;
	
	@Column (nullable=false)
	private String address;
	
	@Column(nullable = false, unique = true, length = 60)
	private String email;
	
	private long sKey;
	
	
	
	
	
	
	
//	List<Integer>cart=new ArrayList<>();
	private int[] cart;
	
	public int[] getCart() {
		return cart;
	}
	public void setCart(int[] cart) {
		this.cart = cart;
	}
	
	private LocalDateTime createdDate;
	
	private LocalDateTime currentLoginDate;
	
	private LocalDateTime lastLoginDate=null;
	
	public LocalDateTime getCurrentLoginDate() {
		return currentLoginDate;
	}
	public void setCurrentLoginDate(LocalDateTime currentLoginDate) {
		this.currentLoginDate = currentLoginDate;
	}
	public LocalDateTime getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(LocalDateTime lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime localDateTime) {
		this.createdDate = localDateTime;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public long getsKey() {
		return sKey;
	}
	public void setsKey(long sKey) {
		this.sKey = sKey;
	}
	public int getUserid() {
		return userid;
	}
	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return username;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public long getMobileno() {
		return mobileno;
	}
	public String getAddress() {
		return address;
	}
	public String getEmail() {
		return email;
	}
	
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setMobileno(long mobileno) {
		this.mobileno = mobileno;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Buyer(int userid, String username, String firstName, String lastName, String password, long mobileno,
			String address, String email) {
		super();
		this.userid = userid;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.mobileno = mobileno;
		this.address = address;
		this.email = email;
	}
	
	
	public Buyer() {
		super();
	}
	

}
