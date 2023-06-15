z//package com.java.addToCart.Service;
//
//import java.util.UUID;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
////import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.client.RestTemplate;
//
//import com.java.addToCart.Entity.Product;
//
//
//
//
////@FeignClient(name="product-details",url="localhost:8082")
//@Service
//public class ProductDetails {
//
//	
//	public static final RestTemplate restTemplate = new RestTemplate();
//	
//	
////	String productId = "123"; // Replace with the actual productId
//////	String url = "http://localhost:8082/amazon/products/search/" + productId;
////
////	
////	url.replace("{productId}")
////
////	HttpHeaders headers = new HttpHeaders();
////	headers.setContentType(MediaType.APPLICATION_JSON);
////
////	HttpEntity<String> entity = new HttpEntity<>(null, headers);
////
////	ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
////	String responseBody = response.getBody();
////	
//////	
//////	@GetMapping("/search/{productId}")
//	public Product getProductByUUID(UUID productId) {
//		return null;
//		String url = "http://localhost:8082/amazon/products/search/{productid}";
//		
//		url.replaceFirst({productid, productId);
//		
//
//		
//		
//	}
//
//}
