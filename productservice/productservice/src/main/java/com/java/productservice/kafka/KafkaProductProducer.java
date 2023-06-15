package com.java.productservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.java.productservice.Entity.Product;

@Service
public class KafkaProductProducer {
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProductConsumer.class);

	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private ChannelTopic channelTopic;
	
   private KafkaTemplate<Product, Product> kafkaTemplate;
   
   public KafkaProductProducer(KafkaTemplate<Product, Product> kafkaTemplate) {
       this.kafkaTemplate = kafkaTemplate;
   }
   
   public void sendProduct(Product product){
//LOGGER.info("Product received {}",product);
     kafkaTemplate.send("amazon-products", product);
 }
   public void sendPrice(Product product) {
	   LOGGER.info("Price is",product.getPrice());
	   kafkaTemplate.send("amazon-products" ,product);
	   
	   redisTemplate.convertAndSend(channelTopic.getTopic(), product.toString());
	  
	   
   }
}
