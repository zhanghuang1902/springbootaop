package com.example.demo.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * ClassName:FaboutExchangeProducer
 * Package:com.example.demo.mq
 * Description:
 *
 * @date:2020/5/20 19:37
 * @author:zh
 */
public class FanoutExchangeProducer {
    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setPassword("guest");
        factory.setUsername("guest");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String exchangeName="test_fanout_exchange";
        for (int i=0;i<=10;i++){
            String msg="fanoutExchange";
            channel.basicPublish(exchangeName, "", null, msg.getBytes());
        }
        channel.close();
        connection.close();
    }
}
