package com.springamqp.amqp.config;


import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:RabbitMQConfig
 * Package:com.springamqp.amqp.config
 * Description:
 *
 * @date:2020/5/27 11:36
 * @author:zh
 */
@Configuration
@ComponentScan("com.springamqp.amqp.config.*")
public class RabbitMqConfig {

    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory factory = new CachingConnectionFactory();
        factory.setAddresses("127.0.0.1:5672");
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("/");
        return factory;
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory){//connectionFactory 必须和最上面的方法名称一致,否者无法注入
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        //此参数必须设置为True ,目的是让spring 自动加载
        rabbitAdmin.setAutoStartup(true);
        return rabbitAdmin;
    }
}
