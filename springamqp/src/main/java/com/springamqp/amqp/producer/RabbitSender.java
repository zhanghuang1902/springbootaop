package com.springamqp.amqp.producer;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * ClassName:RabbitSender
 * Package:com.springamqp.amqp.producer
 * Description:
 *
 * @date:2020/6/18 16:17
 * @author:zh
 */
@Component
public class RabbitSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    final RabbitTemplate.ConfirmCallback confirmCallback = (correlationData, b, s) -> {
        System.out.println("correlationData"+correlationData);
        System.out.println(b);
        if(!b){
            System.out.println("异常处理....");
        }

    };

    final RabbitTemplate.ReturnCallback returnCallback= (message, i, s, s1, s2) -> System.err.println("exchange "+s1+"key "+s2);

    public void sendMsg(Object message, Map<String, Object> properties) throws Exception{
        MessageHeaders mhs = new MessageHeaders(properties);
        Message  msg = MessageBuilder.createMessage(message, mhs);
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
        CorrelationData data = new CorrelationData("1234567890");
        rabbitTemplate.convertAndSend("exchange-1", "spring.hello",msg,data);
    }
}
