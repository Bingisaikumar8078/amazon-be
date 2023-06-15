package com.java.productservice.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.productservice.Entity.Cart;
import com.java.productservice.Service.CartService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/amazon/cart")
public class CartController {
	
	
	@Autowired 
	CartService cartService;
	
	
	@PostMapping("/addToCart")
	public ResponseEntity<String> addToCart(@RequestBody Cart product){
		
		cartService.addToCart(product);
		
		return ResponseEntity.ok("Added to cart successfully");
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProductFromCart(@PathVariable("id") Long  id){
		
		cartService.deleteProductFromCart(id);
		
		return ResponseEntity.ok("Product is removed from cart");
		
	}
	

}
