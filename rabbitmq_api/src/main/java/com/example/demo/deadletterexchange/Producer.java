package com.example.demo.deadletterexchange;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

/**
 * ClassName:Producer
 * Package:com.example.demo.deadletterexchange
 * Description:
 *
 * @date:2020/5/26 16:45
 * @author:zh
 */
public class Producer {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.7");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String exchangeName="test_dlx_exchange";
        String routingKey="dlx.save";
        String msg="hello mq";
        AMQP.BasicProperties properties= new AMQP.BasicProperties.Builder().deliveryMode(2).contentEncoding("UTF-8").expiration("10000").build();
        channel.basicPublish(exchangeName,routingKey, true,properties,msg.getBytes());
        channel.close();
        connection.close();
    }
}
