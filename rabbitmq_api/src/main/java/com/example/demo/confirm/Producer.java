package com.example.demo.confirm;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
        //指定消息的确认模式
        channel.confirmSelect();
        //创建交换极
        String exchange="test_confirm_exchange";
        //指定routing key
        String routingKey="confirm.save";
        //发生消息
        channel.basicPublish(exchange, routingKey, null, "hello,world".getBytes());
        //监听消息
        channel.addConfirmListener(new ConfirmListener() {
            //返回成功进入此方法
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                System.err.println(" ack");
            }
            //返回失败进入此方法
            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                System.err.println("no ack");
            }
        });
//        //关闭连接
//        channel.close();
//        connection.close();

    }
}
