package com.springboot.rabbitmqprovider;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitmqProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProviderApplication.class, args);
    }

    @Bean
    public ConnectionFactory connectionFactory(){
        return new ConnectionFactory();
    }

}
