package com.springboot.rabbitmqprovider.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * ClassName:RabbitMqProviderController
 * Package:com.springboot.rabbitmqprovider.controller
 * Description:
 *
 * @date:2020/12/9 15:30
 * @author:zh
 */
@RestController
public class RabbitMqProviderController {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @GetMapping("/sendDirectMessage")
    public String sendDirectMessage() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "我爱mq 我要学好mq";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);
        return "ok";
    }

    @GetMapping("/sendTopicMessageOne")
    public String sendTopicMessageOne() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "我爱mq 我要学好mq 直连交换机one";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestTopicExchange", "TopicRouting.man", map);
        return "ok";
    }

    @GetMapping("/sendTopicMessageTwo")
    public String sendTopicMessageTwo() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "我爱mq 我要学好mq 直连交换机Two";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestTopicExchange", "TopicRouting.man.women", map);
        return "ok";
    }

    @GetMapping("/sendTopicMessageThree")
    public String sendTopicMessageThree() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "我爱mq 我要学好mq 直连交换机Three";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> map=new HashMap<>();
        map.put("messageId",messageId);
        map.put("messageData",messageData);
        map.put("createTime",createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestTopicExchange", "TopicRouting.women", map);
        return "ok";
    }

}
