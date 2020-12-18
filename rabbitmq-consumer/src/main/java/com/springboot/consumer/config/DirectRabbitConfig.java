package com.springboot.consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:DirectRabbitConfig
 * Package:com.springboot.rabbitmqprovider.config
 * Description:
 *
 * @date:2020/12/9 15:18
 * @author:zh
 * 直连交换机配置类
 */
@Configuration
public class DirectRabbitConfig {

    /**
     * 声明一个队列
     * @return
     */
    @Bean
    public Queue testDirectQueue(){
        return new Queue("TestDirectQueue",true);
    }

    /**
     * 声明一个直连交换机
     */
    @Bean
    public DirectExchange testDirectExchange(){
        return new DirectExchange("TestDirectExchange",true,false);
    }

    /**
     * 绑定 将交换机和队列绑定
     */
    @Bean
    public Binding bindingDirect(){
        return BindingBuilder.bind(testDirectQueue()).to(testDirectExchange()).with("TestDirectRouting");
    }
}
