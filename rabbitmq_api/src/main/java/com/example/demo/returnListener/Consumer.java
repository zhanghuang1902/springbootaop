package com.example.demo.returnListener;

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
        factory.setPort(5672);//端口号
        factory.setVirtualHost("/");
        factory.setUsername("guest");
        factory.setPassword("guest");
        //通过连接工厂创建连接
        Connection connection = factory.newConnection();
        //通过连接创建一个通道
        Channel channel = connection.createChannel();
        //创建交换极
        String exchange="test_return_exchange";
        //指定routing key
        String routingKey="return.#";
        String routingErrKey="abc.save";
        //声明一个交换机
        channel.exchangeDeclare(exchange, "topic", true);
        //申明创建一个队列
        String queueName="test_return_queue";
        channel.queueDeclare(queueName, true, false, false, null);
        //绑定两者关系
        channel.queueBind(queueName, exchange, routingKey);
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
