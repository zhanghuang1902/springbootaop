package com.example.demo.consumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * ClassName:producer
 * Package:com.example.demo
 * Description:
 *
 * @date:2020/5/20 11:35
 * @author:zh
 */
public class Producer {

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
        String exchangeName="test_consumer_exchange";
        String routingKey="consumer.save";
        //发送带有附加属性的消息,链式编程
        for(int i=0;i<=5;i++){
            String msg="hello mq";
            channel.basicPublish(exchangeName,routingKey,null,msg.getBytes());
        }
        //关闭连接
        channel.close();
        connection.close();

    }
}
