package com.example.springboot;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * ClassName:HelloConsumer
 * Package:com.example.springboot
 * Description:
 *
 * @date:2020/5/19 14:45
 * @author:zh
 */
@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello",durable = "true",autoDelete = "true"))
public class HelloConsumer {

    @RabbitHandler
    public void receive(String message){
        System.out.println("message"+message);
    }
}
