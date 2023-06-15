package com.java.addToCart.Entity;

import java.util.UUID;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString

public class Product {
public UUID productId;
	
	public String name;
	public double price;
	public double rating;
	public String imageURL;
	public String type;

}
