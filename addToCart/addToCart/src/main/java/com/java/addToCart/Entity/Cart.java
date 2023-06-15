package com.java.addToCart.Entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table
@Entity(name="Cart")
public class Cart {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	
	 @Column(name = "userId", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
	 @Type(type = "uuid-char")
	public UUID userId;
	
	 @Column(name = "productId", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
	 @Type(type = "uuid-char")
	public UUID productId;
	
}
