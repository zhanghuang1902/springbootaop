package com.example.demo.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * ClassName:Consumer
 * Package:com.example.demo
 * Description:
 *
 * @date:2020/5/20 11:35
 * @author:zh
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);//端口号
        factory.setVirtualHost("/");
        factory.setUsername("guest");
        factory.setPassword("guest");
        //通过连接工厂创建连接
        Connection connection = factory.newConnection();
        //通过连接创建一个通道
        Channel channel = connection.createChannel();
        String exchangeName="test_consumer_exchange";
        String routingKey="consumer.save";
        channel.exchangeDeclare(exchangeName,"topic",true);
        //申明创建一个队列
        String queueName="test001";
        channel.queueDeclare(queueName, true, false, false, null);
        //绑定交换机和队列
        channel.queueBind(queueName,exchangeName,routingKey);
        //设置channel
        channel.basicConsume(queueName, true,new MyConsumer(channel));

    }
}
