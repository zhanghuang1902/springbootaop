package com.springboot.consumer.controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * ClassName:RabbitmqConsumerControllerNew
 * Package:com.springboot.consumer.controller
 * Description:
 *
 * @date:2020/12/9 16:26
 * @author:zh
 */
@Component
@RabbitListener(queues = "TestDirectQueue")
public class RabbitmqConsumerControllerNew {

    @RabbitHandler
    public void rabbitListener(Map testMessage){
        System.out.println("DirectReceiverTwo消费者收到消息  : " + testMessage.toString());
    }
}
