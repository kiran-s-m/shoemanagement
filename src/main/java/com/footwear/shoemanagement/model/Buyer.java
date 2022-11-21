package com.footwear.shoemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Buyer {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
//	private String creationdate;
//	private String updatedate;
	
	
	
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
	
	
//	public String getCreationdate() {
//		return creationdate;
//	}
//	public String getUpdatedate() {
//		return updatedate;
//	}
	
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
