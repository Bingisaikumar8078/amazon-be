package com.java.productservice.redisconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

import com.java.productservice.redissubscriber.RedisSubscriber;


@Configuration

public class RedisConfig {
	@Bean
    public JedisConnectionFactory connectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName("localhost");
        configuration.setPort(6379);
        return new JedisConnectionFactory(configuration);
    }

    @Bean
    public RedisTemplate<String, Object> template() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory());
        template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
      
        return template;
    }
    
    @Bean
    public ChannelTopic topic() {
    	return new ChannelTopic("pubsub-product-topic");
    }
    @Bean
    public MessageListenerAdapter messageListenerAdapter() {
    	return new MessageListenerAdapter( new RedisSubscriber());
    }
    
    
    
    @Bean
    public RedisMessageListenerContainer messageListenerContainer() {
    	RedisMessageListenerContainer container = new RedisMessageListenerContainer();
    	container.setConnectionFactory(connectionFactory());
    	
    	container.addMessageListener(messageListenerAdapter(), topic());
return container;
    	
    	
    }


}
