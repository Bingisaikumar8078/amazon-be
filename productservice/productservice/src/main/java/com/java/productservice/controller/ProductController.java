package com.java.productservice.controller;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.productservice.Entity.Product;
import com.java.productservice.Repository.ProductRepository;
import com.java.productservice.Service.ProductService;
import com.java.productservice.kafka.KafkaProductConsumer;
import com.java.productservice.kafka.KafkaProductProducer;
import com.java.productservice.redissubscriber.RedisSubscriber;

import reactor.core.publisher.Flux;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/amazon/products")
public class ProductController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;
	
	@Autowired
	KafkaProductProducer kafkaProductProducer;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	KafkaProductConsumer kafkaProductConsumer;
	
	@Autowired
	RedisSubscriber redisSubscriber;
	
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {
	return productService.addProduct(product);
		
		
	}
	
	 
//	@PostMapping("/save/product")
//    public ResponseEntity<String> publish(@RequestBody Product product){
//    	kafkaProductProducer.sendProduct(product);
//        return ResponseEntity.ok("product  sent to the topic");
//    }
	
	@PutMapping("update/{id}")
	public ResponseEntity<String> updatePrice(@PathVariable("id") Integer id ,@RequestBody Product updatedproduct){
		try {
			
	Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeErrorException(null));
	

			LOGGER.info("product is {}",product);
			product.setPrice(updatedproduct.getPrice());
			LOGGER.info("updated product price for product id {}:",id);
			product.setPrice(updatedproduct.getPrice());
			kafkaProductProducer.sendPrice(product);
			productRepository.save(product);
		    
		}
		catch(Exception ex) {
			LOGGER.error(ex.getMessage());
			
		}
		return ResponseEntity.ok("price is updated");
	
		
	}
	@GetMapping("/prices")
	public Flux<ServerSentEvent<String>> streamPrices() {
	    return Flux.interval(Duration.ofSeconds(1))
	      .map(sequence -> ServerSentEvent.<String> builder()
	        .id(String.valueOf(sequence))
	          .event("price-event")
	          .data(generatePrice() )
	          .build());
	}
	
	@GetMapping("phone/{brand}")
	public ArrayList<Product> getProductbyBrand(@PathVariable("brand") String brand) {
		return productService.getProductsByBrand(brand);
	}
	
	
	
	private String generatePrice() {
		return String.valueOf(Math.random()*10000);
	}


	@GetMapping("/allProducts")
	public ArrayList<Product> getAllProducts(){
		return productService.getAllProducts();
		
	}
	
	@GetMapping("/search/{productId}")
	public Optional<Product> getProductByUUID(@PathVariable("productId") UUID productId) {
		return productService.getProductByUUID(productId);
	}
	
	@GetMapping("/product/{type}")
	public ArrayList<Product> getProductByType(@PathVariable String type) {
		return productService.getProductsByType(type);
	}

}
