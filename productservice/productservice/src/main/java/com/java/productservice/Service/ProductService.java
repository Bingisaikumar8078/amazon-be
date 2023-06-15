package com.java.productservice.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.productservice.Entity.Product;
import com.java.productservice.Repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public Product addProduct(Product product) {
		product.setProductId(UUID.randomUUID());
		
		return productRepository.save(product);
	}

	public ArrayList<Product> getAllProducts() {
		
		return (ArrayList<Product>) productRepository.findAll();
	}

	public Optional<Product> getProductByUUID(UUID productId) {
		// TODO Auto-generated method stub
		return productRepository.getProductByProductId(productId);
	}

	public ArrayList<Product> getProductsByType(String type) {
		
		return (ArrayList<Product>) productRepository.getProductByType(type);
	}

	public ArrayList<Product> getProductsByBrand(String brand) {
	
		return (ArrayList<Product>) productRepository.getProductsByBrand(brand);
	}
	
	
	
}
