package com.springamqp.amqp.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
@ComponentScan({"com.springamqp.amqp.*"})
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

    /**
     * amqp声明
     */
    @Bean
    public TopicExchange topic001(){
        return new TopicExchange("topic001",true,false);
    }

    @Bean
    public Queue queue001(){
        return new Queue("queue001",true);
    }

    @Bean
    public Binding binding001(){
       return BindingBuilder.bind(queue001()).to(topic001()).with("spring.*");
    }

    @Bean
    public TopicExchange topic002(){
        return new TopicExchange("topic002",true,false);
    }

    @Bean
    public Queue queue002(){
        return new Queue("queue002",true);
    }

    @Bean
    public Binding binding002(){
        return BindingBuilder.bind(queue002()).to(topic002()).with("rabbit.*");
    }


    @Bean
    public Queue queue003(){
        return new Queue("queue003",true);
    }

    @Bean
    public Binding binding003(){
        return BindingBuilder.bind(queue003()).to(topic001()).with("mq.*");
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        return  rabbitTemplate;
    }
}
