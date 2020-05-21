package com.example.demo.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

/**
 * ClassName:TopicExchangeConsumer
 * Package:com.example.demo.mq
 * Description:
 *
 * @date:2020/5/20 17:11
 * @author:zh
 */
public class TopicExchangeConsumer {
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        //通过连接工厂创建连接
        Connection connection = factory.newConnection();
        //通过连接创建一个通道
        Channel channel = connection.createChannel();
        //声明参数
        String exchangeName="test_exchange_topic";
        String exchangeType="topic";
        String queueName="test_topic_queue";
        String routingKey="user.#";
        //声明交换机
        channel.exchangeDeclare(exchangeName, exchangeType, true, false, false, null);
        //声明对列
        channel.queueDeclare(queueName, false, false, false, null);
        //建立绑定关系
        channel.queueBind(queueName, exchangeName, routingKey);
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
