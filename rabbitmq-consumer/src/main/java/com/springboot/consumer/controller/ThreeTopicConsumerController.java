package com.springboot.consumer.controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * ClassName:ThreeTopicConsumerController
 * Package:com.springboot.consumer.controller
 * Description:
 *
 * @date:2020/12/9 17:28
 * @author:zh
 */
@Component
@RabbitListener(queues = "TestTopicQueueThree")
public class ThreeTopicConsumerController {

    @RabbitHandler
    public void rabbitListenerThree(Map testMessage){
        System.out.println("Three *  : " + testMessage.toString());
    }
}
