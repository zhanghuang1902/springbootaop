package com.example.demo.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

/**
 * ClassName:DirectExchangeConsumer
 * Package:com.example.demo.mq
 * Description:
 *
 * @date:2020/5/20 16:19
 * @author:zh
 */
public class DirectExchangeConsumer {
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
        //声明参数
        String exchangeName="test_exchange_direct";
        String routingKey="test.direct";
        //指定类型 直连交换机类型
        String exchangeType="direct";
        String queueName="test_direct_queue";
        //声明一个交换机
        channel.exchangeDeclareNoWait(exchangeName,exchangeType,true,false,false,null);
        //声明一个队列
        channel.queueDeclare(queueName,false,false,false,null);
        //建立一个绑定关系
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
