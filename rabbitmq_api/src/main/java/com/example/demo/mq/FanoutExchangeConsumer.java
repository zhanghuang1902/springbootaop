package com.example.demo.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * ClassName:FanoutExchangeConsumer
 * Package:com.example.demo.mq
 * Description:
 *
 * @date:2020/5/20 19:36
 * @author:zh
 */
public class FanoutExchangeConsumer {
    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setPassword("guest");
        factory.setUsername("guest");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String exchangeName="test_fanout_exchange";
        String exchangeType="fanout";
        String queueName="test_fanout_queue";
        //不设置路由键
        String routingKey="";
        //声明一个交换机
        channel.exchangeDeclare(exchangeName, exchangeType, true, false, null);
        channel.queueDeclare(queueName, false, false, false, null);
        channel.queueBind(queueName, exchangeName, routingKey);
        //创建一个消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(queueName, true, consumer);
        while (true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String s = new String(delivery.getBody());
            System.out.println("消息"+s);
        }
    }
}
