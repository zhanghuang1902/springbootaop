package com.example.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:RabbitMqConfig
 * Package:com.example.springboot.config
 * Description:
 *
 * @date:2020/5/18 16:40
 * @author:zh
 */
@Configuration
public class RabbitMqConfig {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;


    @Bean
    public ConnectionFactory connectionFactory() {
        //建立一个工程
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setPort(port);
        factory.setHost(host);
        factory.setVirtualHost("/");
        factory.setUsername(username);
        factory.setPassword(password);
        return factory;
    }
    
}
