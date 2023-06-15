package com.java.productservice.Repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.productservice.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> getProductByType(String type);

	Optional<Product> getProductByProductId(UUID productId);

	List<Product> getProductsByBrand(String brand);

}
