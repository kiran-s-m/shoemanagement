package com.footwear.shoemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.footwear.shoemanagement.model.Buyer;
import com.footwear.shoemanagement.model.Shoes;
import com.footwear.shoemanagement.service.AddShoes;
import com.footwear.shoemanagement.service.BuyerDelete;
import com.footwear.shoemanagement.service.BuyerEditAddress;
import com.footwear.shoemanagement.service.BuyerEditName;
import com.footwear.shoemanagement.service.BuyerEditPassword;
import com.footwear.shoemanagement.service.BuyerLogin;
import com.footwear.shoemanagement.service.BuyerLogout;
import com.footwear.shoemanagement.service.BuyerService;
import com.footwear.shoemanagement.service.BuyerSignup;

@RestController
public class FootwearController {

	@RequestMapping("/testing")
	public ResponseEntity<String> Testing() throws JsonMappingException, JsonProcessingException
	{
		String s1="Application is working";
		return ResponseEntity.ok(s1);	
	}
	
	@Autowired
	private BuyerService buyerService;
	
	@RequestMapping("/getEnteredData")
	public ResponseEntity<List<Buyer>> getEnteredData() throws JsonMappingException, JsonProcessingException
	{
		List<Buyer> listBuyer= buyerService.getEnteredList();
		return ResponseEntity.ok(listBuyer);
	}	
	
	@Autowired
	private BuyerSignup buyerSignup;
	
	@RequestMapping("/saveBuyer") 
	public ResponseEntity<String> saveBuyerData(@RequestBody Buyer buyer) throws JsonMappingException, JsonProcessingException
	{
//		System.out.println(buyer.getUsername());
		ResponseEntity<String> s = buyerSignup.findBuyerExistsOrNot(buyer);
		return s;
	}
	
	
	@Autowired
	private BuyerLogin buyerLogin;
	
	@RequestMapping("/loginBuyer")
	public ResponseEntity<List<Object>> loginUser(@RequestHeader("userName") String userName,@RequestHeader("password") String password) throws JsonMappingException, JsonProcessingException
	{
		ResponseEntity<List<Object>> s=buyerLogin.getBuyer(userName,password);
		return s;
	}
	
	@Autowired
	private BuyerLogout buyerLogout;
	
	@RequestMapping("/loginBuyer/logout")
	public ResponseEntity<String> logoutUser(@RequestHeader long skey,@RequestHeader int userid)
	{
		return buyerLogout.logoutBuyer(userid,skey);
	}
	
	
	
	@Autowired
	private BuyerDelete buyerDelete;
	
	@RequestMapping("/loginBuyer/deleteUser")
	public ResponseEntity<String> deleteBuyer(@RequestHeader("userName") String userName,@RequestHeader("password") String password,@RequestHeader long skey) throws JsonMappingException, JsonProcessingException
	{
		return buyerDelete.deleteUserAccount(userName, password,skey);
	}
	
	
	@Autowired
	private BuyerEditName buyerEditName;
	
	@RequestMapping("/loginBuyer/editBuyerName")
	public ResponseEntity<String> updateAccountName(@RequestHeader("userName") String userName,@RequestHeader("password") String password,@RequestHeader long skey,@RequestBody Buyer buyer) throws JsonMappingException, JsonProcessingException
	{
		return buyerEditName.editBuyerName(userName, password,skey,buyer);
	}
	
	
	@Autowired
	private BuyerEditPassword buyerEditPassword;
	
	@RequestMapping("/loginBuyer/editPassword")
	public ResponseEntity<String> updateAccountPassword(@RequestHeader("userName") String userName,@RequestHeader("password") String password,@RequestHeader long skey,@RequestBody Buyer buyer) throws JsonMappingException, JsonProcessingException
	{
		return buyerEditPassword.editBuyerPassword(userName, password,skey,buyer);
	}
	
	
	@Autowired
	private BuyerEditAddress buyerEditAddress;
	
	@RequestMapping("/loginBuyer/editBuyerAddress")
	public ResponseEntity<String> updateAddress(@RequestHeader("userName") String userName,@RequestHeader("password") String password,@RequestHeader long skey,@RequestBody Buyer buyer) throws JsonMappingException, JsonProcessingException
	{
		return buyerEditAddress.editBuyerAddress(userName, password,skey,buyer);
	}
	
	
	
	
	
	
	
	
	@Autowired
	private AddShoes addShoes;
	
	@RequestMapping("/loginBuyer/addShoes")
	public List<Object> addShoesToDB(@RequestBody Shoes shoe,@RequestHeader long skey,@RequestHeader int userid) throws JsonMappingException, JsonProcessingException
	{
		return addShoes.addShoeDetails(shoe,userid,skey);
	}
}
