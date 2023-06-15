package com.java.productservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.productservice.Entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
