package com.java.productservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.productservice.Entity.Cart;
import com.java.productservice.Repository.CartRepository;

@Service
public class CartService {
	@Autowired
	CartRepository cartRepository;

	public void addToCart(Cart product) {
		cartRepository.save(product);
		
	}

	public void deleteProductFromCart(Long id) {
		// TODO Auto-generated method stub
		
		cartRepository.deleteById(id);
		
	}

}
