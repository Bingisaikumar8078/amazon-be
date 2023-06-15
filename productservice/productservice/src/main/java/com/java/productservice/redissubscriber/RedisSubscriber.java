package com.java.productservice.redissubscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class RedisSubscriber implements MessageListener {
	
	Logger logger = LoggerFactory.getLogger(RedisSubscriber.class);

	@Override
	public void onMessage(Message message, byte[] pattern) {
		// TODO Auto-generated method stub
logger.info("Product recived from redis is {}" , message);		
	}

}
