package com.footwear.shoemanagement.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.footwear.shoemanagement.model.Buyer;
import com.footwear.shoemanagement.model.Shoes;
import com.footwear.shoemanagement.service.AddShoes;
import com.footwear.shoemanagement.service.AddToCart;
import com.footwear.shoemanagement.service.BuyerDelete;
import com.footwear.shoemanagement.service.BuyerEditAddress;
import com.footwear.shoemanagement.service.BuyerEditName;
import com.footwear.shoemanagement.service.BuyerEditPassword;
import com.footwear.shoemanagement.service.BuyerLogin;
import com.footwear.shoemanagement.service.BuyerLogout;
import com.footwear.shoemanagement.service.BuyerService;
import com.footwear.shoemanagement.service.BuyerSignup;
import com.footwear.shoemanagement.service.EditPrice;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
public class FootwearController {

	@Tag(description = "Method used to test application", name = "To test")
	@GetMapping("/testing")
	public ResponseEntity<String> Testing() throws JsonMappingException, JsonProcessingException
	{
		String s1="Application is working";
		return ResponseEntity.ok(s1);	
	}
	
	@Tag(description = "Home page", name = "To get")
	@GetMapping("/")
	public ResponseEntity<String> display()
	{
		return ResponseEntity.status(303).body("Login with your account. \nIf you don't have the account yet, create one. \nIt takes only 2 minutes. ");
	}
	
	@Autowired
	private BuyerService buyerService;
	
	@Tag(description = "Method used to get data entered (hardcoded data) in service layer", name = "To get")
	@GetMapping("/getEnteredData")
	public ResponseEntity<Map<String, Object>> getEnteredData() throws JsonMappingException, JsonProcessingException
	{
		Map<String, Object> listBuyer= buyerService.getEnteredList();
		return ResponseEntity.ok(listBuyer);
	}	
	
	@Autowired
	private BuyerSignup buyerSignup;
	
	@Tag(description = "Method used to create user account and post details to database", name = "To post")
	@PostMapping("/saveBuyer") 
	public ResponseEntity<String> saveBuyerData(@RequestBody Buyer buyer) throws JsonMappingException, JsonProcessingException
	{
//		System.out.println(buyer.getUsername());
		ResponseEntity<String> s = buyerSignup.findBuyerExistsOrNot(buyer);
		return s;
	}
	
	
	@Autowired
	private BuyerLogin buyerLogin;
	
	@Tag(description = "Method used to verify password and login to user account", name = "To login")
	@GetMapping("/loginBuyer")
	public ResponseEntity<Map<String, Object>> loginUser(@RequestHeader("userName") String userName,@RequestHeader("password") String password) throws JsonMappingException, JsonProcessingException
	{
		return buyerLogin.getBuyer(userName,password);
	}
	
	@Autowired
	private BuyerLogout buyerLogout;
	
	@Tag(description = "Method used to logout of session", name = "To logout")
	@GetMapping("/loginBuyer/logout")
	public ResponseEntity<String> logoutUser(@RequestHeader long skey,@RequestHeader int userid)
	{
		return buyerLogout.logoutBuyer(userid,skey);
	}
	
	
	
	@Autowired
	private BuyerDelete buyerDelete;
	
	@Tag(description = "Method used to delete user account from database", name = "To delete")
	@DeleteMapping("/loginBuyer/deleteUser")
	public ResponseEntity<String> deleteBuyer(@RequestHeader("userName") String userName,@RequestHeader("password") String password,@RequestHeader long skey) throws JsonMappingException, JsonProcessingException
	{
		return buyerDelete.deleteUserAccount(userName, password,skey);
	}
	
	
	@Autowired
	private BuyerEditName buyerEditName;
	
	@Tag(description = "Method used to update user name", name = "To update")
	@PatchMapping("/loginBuyer/editBuyerName")
	public ResponseEntity<String> updateAccountName(@RequestHeader("userName") String userName,@RequestHeader("password") String password,@RequestHeader long skey,@RequestHeader String newFirstName, @RequestHeader String newLastName) throws JsonMappingException, JsonProcessingException
	{
		return buyerEditName.editBuyerName(userName, password,skey,newFirstName, newLastName);
	}
	
	
	@Autowired
	private BuyerEditPassword buyerEditPassword;
	
	@Tag(description = "Method used to update password", name = "To update")
	@PatchMapping("/loginBuyer/editPassword")
	public ResponseEntity<String> updateAccountPassword(@RequestHeader("userName") String userName,@RequestHeader("password") String password,@RequestHeader long skey,@RequestHeader String newPassword) throws JsonMappingException, JsonProcessingException
	{
		return buyerEditPassword.editBuyerPassword(userName, password,skey,newPassword);
	}
	
	
	@Autowired
	private BuyerEditAddress buyerEditAddress;
	
	@Tag(description = "Method used to update user address", name = "To update")
	@PatchMapping("/loginBuyer/editBuyerAddress")
	public ResponseEntity<String> updateAddress(@RequestHeader("userName") String userName,@RequestHeader("password") String password,@RequestHeader long skey,@RequestHeader String newAddress) throws JsonMappingException, JsonProcessingException
	{
		return buyerEditAddress.editBuyerAddress(userName, password,skey,newAddress);
	}
	
	
	
	
	@Autowired
	private AddToCart addToCart;
	
	@Tag(description = "Method used to add product to cart", name = "To add to cart")
	@GetMapping("/loginBuyer/addToCart/{shoeId}")
	public ResponseEntity<String> addToCart(@RequestHeader("userId") int userId, @RequestHeader long skey, @PathVariable int shoeId)
	{
		return addToCart.addCart(userId, skey, shoeId);
	}
	
	
	@Tag(description = "Method used to show cart details", name = "To get")
	@GetMapping("/loginBuyer/cart")
	public ResponseEntity<Map<String, Object>> showCart(@RequestHeader("userName") String userName, @RequestHeader long skey)
	{
		return addToCart.cart(userName, skey);
	}
	
	
	
	@Autowired
	private AddShoes addShoes;
	
	@Tag(description = "Method used to add shoes to the database", name = "To post")
	@PostMapping("/loginBuyer/addShoes")
	public Map<String, Object> addShoesToDB(@RequestBody Shoes shoe,@RequestHeader long skey,@RequestHeader int userid) throws JsonMappingException, JsonProcessingException
	{
		return addShoes.addShoeDetails(shoe,userid,skey);
	}
	
	
	@Autowired
	private EditPrice editPrice;
	
	@Tag(description = "Method used edit shoe price", name = "To update")
	@PatchMapping("/loginBuyer/editPrice")
	public ResponseEntity<String> updatePrice(@RequestHeader("userName") String userName,@RequestHeader("password") String password,@RequestHeader long skey,@RequestHeader int shoeId, @RequestHeader int sellerId, @RequestHeader double newPrice) throws JsonMappingException, JsonProcessingException
	{
		return editPrice.editPrice(shoeId, sellerId, skey, userName, password, newPrice);
	}
}
