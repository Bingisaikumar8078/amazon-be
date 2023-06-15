package com.java.addToCart.Repository;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.addToCart.Entity.Cart;



public interface AddToCartRepository extends JpaRepository<Cart ,Long> {

	
	ArrayList<Cart> findByuserId(UUID userId);
}
