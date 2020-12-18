package com.example.demo.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

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
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("guest");
        factory.setPassword("guest");
        //通过连接工厂创建连接
        Connection connection = factory.newConnection();

        //通过连接创建一个通道
        Channel channel = connection.createChannel();
        //申明创建一个队列
        String queueName="test001";
        channel.queueDeclare(queueName, true, false, false, null);

        //创建一个消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        //设置channel
        channel.basicConsume(queueName, true,consumer);
        while (true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String msg=new String(delivery.getBody());
            System.out.println(msg);
        }
    }
}
