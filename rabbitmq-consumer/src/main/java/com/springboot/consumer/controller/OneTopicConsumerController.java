package com.springboot.consumer.controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * ClassName:OneTopicConsumerController
 * Package:com.springboot.consumer.controller
 * Description:
 *
 * @date:2020/12/9 17:28
 * @author:zh
 */
@Component
@RabbitListener(queues = "TestTopicQueueOne")
public class OneTopicConsumerController {

    @RabbitHandler
    public void rabbitListenerOne(Map testMessage){
        System.out.println("正常  : " + testMessage.toString());
    }


}
