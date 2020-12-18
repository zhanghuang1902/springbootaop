package com.springboot.consumer.controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * ClassName:RabbitmqConsumerController
 * Package:com.springboot.consumer.controller
 * Description:
 *
 * @date:2020/12/9 15:58
 * @author:zh
 * 监听队列
 */
@Component
@RabbitListener(queues = "TestDirectQueue")
public class RabbitmqConsumerController {


    @RabbitHandler
    public void rabbitListener(Map testMessage){
        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
    }

}
