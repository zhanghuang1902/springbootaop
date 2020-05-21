package com.example.demo.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * ClassName:DirectExchangeProducer
 * Package:com.example.demo.mq
 * Description:
 *
 * @date:2020/5/20 16:11
 * @author:zh
 */
public class DirectExchangeProducer {
    public static void main(String[] args) throws Exception {
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
        String exchangeName="test_exchange_direct";
        String routingKey="test.direct";
        //发送
        String msg="directExchange";
        channel.basicPublish(exchangeName, routingKey, null,msg.getBytes());
        channel.close();
        connection.close();
    }
}
