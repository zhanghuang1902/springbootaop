package com.springboot.consumer.controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * ClassName:TwoTopicConsumerController
 * Package:com.springboot.consumer.controller
 * Description:
 *
 * @date:2020/12/9 17:28
 * @author:zh
 */
@Component
@RabbitListener(queues = "TestTopicQueueTwo")
public class TwoTopicConsumerController {

    @RabbitHandler
    public void rabbitListenerTwo(Map testMessage){
        System.out.println("Two #  : " + testMessage.toString());
    }

}
