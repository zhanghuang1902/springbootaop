package com.example.demo.deadletterexchange;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * ClassName:Consumer
 * Package:com.example.demo.deadletterexchange
 * Description:
 *
 * @date:2020/5/26 16:54
 * @author:zh
 */
public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.7");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String exchangeName="test_dlx_exchange";
        String routingKey="dlx.#";
        String queue="test_dlx_queue";
        channel.exchangeDeclare(exchangeName, "topic", true, false, null);

        //设置死信队列参数
        Map<String, Object> map=new HashMap<>();
        map.put("x-dead-letter-exchange","dlx.exchange");
        channel.queueDeclare(queue, true, false, false, map);
        channel.queueBind(queue, exchangeName, routingKey);

        //设置死信声明  交换机必须和上面的参数一致
        channel.exchangeDeclare("dlx.exchange", "topic", true, false, null);
        channel.queueDeclare("dlx.queue", true, false, false, null);
        channel.queueBind("dlx.queue", "dlx.exchange", "#");
        channel.basicConsume(queue, true, new MyConsumer(channel));
    }
}
