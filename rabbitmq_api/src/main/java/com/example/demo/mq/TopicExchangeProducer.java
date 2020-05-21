package com.example.demo.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * ClassName:TopicExchangeProducer
 * Package:com.example.demo.mq
 * Description:
 *
 * @date:2020/5/20 17:28
 * @author:zh
 */
public class TopicExchangeProducer {
    public static void main(String[] args) throws Exception{
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        //通过连接工厂创建连接
        Connection connection = factory.newConnection();
        //通过连接创建一个通道
        Channel channel = connection.createChannel();
        //声明交换机和routingKey
        String exchangeName="test_exchange_topic";
        String routingKey1="user.direct";
        String routingKey2="user.update";
        String routingKey3="user.delete.abc";
        //发送
        String msg="topicExchange";
        channel.basicPublish(exchangeName, routingKey1, null,msg.getBytes());
        channel.basicPublish(exchangeName, routingKey2, null,msg.getBytes());
        channel.basicPublish(exchangeName, routingKey3, null,msg.getBytes());
        channel.close();
        connection.close();
    }
}
