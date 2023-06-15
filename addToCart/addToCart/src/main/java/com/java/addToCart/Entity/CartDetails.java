package com.java.addToCart.Entity;

import java.util.ArrayList;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDetails {
	
	private UUID userId;
	private ArrayList<Product> list;

}
