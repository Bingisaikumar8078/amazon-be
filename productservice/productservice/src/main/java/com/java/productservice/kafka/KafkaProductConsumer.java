package com.java.productservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.java.productservice.Entity.Product;




@Service
public class KafkaProductConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProductConsumer.class);
	
	@KafkaListener(topics = "amazon-products",groupId = "sai-group")
	public void consumePrice(Product product) {
		LOGGER.info("Product recived from kafka {} ",product);
	}
}
