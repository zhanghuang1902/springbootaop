package com.springboot.rabbitmqprovider.config;


import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:RabbitConfig
 * Package:com.springboot.rabbitmqprovider.config
 * Description:
 *
 * @date:2020/12/9 20:54
 * @author:zh
 */
@Configuration
public class RabbitConfig {

    @Bean
    public RabbitTemplate createRabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        //设置开启Mandatory,才能触发回调函数,无论消息推送结果怎么样都强制调用回调函数
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            System.out.println("ConfirmCallback:     "+"相关数据："+correlationData);
            System.out.println("ConfirmCallback:     "+"确认情况："+ack);
            System.out.println("ConfirmCallback:     "+"原因："+cause);

        });

        rabbitTemplate.setReturnsCallback(returnedMessage -> {
            System.out.println("ReturnCallback:     "+"消息："+returnedMessage.getMessage());
            System.out.println("ReturnCallback:     "+"回应码："+returnedMessage.getReplyCode());
            System.out.println("ReturnCallback:     "+"回应信息："+returnedMessage.getReplyText());
            System.out.println("ReturnCallback:     "+"交换机："+returnedMessage.getExchange());
            System.out.println("ReturnCallback:     "+"路由键："+returnedMessage.getRoutingKey());

        });
        return rabbitTemplate;
    }
}
