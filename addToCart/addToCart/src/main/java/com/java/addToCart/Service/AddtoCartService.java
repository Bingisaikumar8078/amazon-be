package com.java.addToCart.Service;

//import java.util.ArrayList;
//import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.addToCart.Entity.Cart;
//import com.java.addToCart.Entity.CartDetails;
//import com.java.addToCart.Entity.Product;
import com.java.addToCart.Repository.AddToCartRepository;

@Service 
public class AddtoCartService {
	
	@Autowired
	AddToCartRepository addToCartRepository;
	
//	@Autowired
//	ProductDetails productDetails;

	public void addToCart(Cart cart) {
		// TODO Auto-generated method stub
		addToCartRepository.save(cart);
	
	}

	public void removeItemFromCartService(Cart cart) {
		// TODO Auto-generated method stub
		addToCartRepository.delete(cart);
		
	}
	
//	public CartDetails displayAllProductsInCart(UUID userId) {
//		CartDetails cartDetails=new CartDetails();
//		cartDetails.setUserId(userId);
//		
//		ArrayList<Cart> cartList = addToCartRepository.findByuserId(userId);
//		ArrayList<Product> productList=new ArrayList<Product>();
//		
//		for(int i =0; i<cartList.size();i++) {
//		Product product = 	productDetails.getProductByUUID(cartList.get(i).getProductId());
//		productList.add(product);
//		}
//		
//		cartDetails.setList(productList);
//		
//		return cartDetails;
//		
//	}
 

}
