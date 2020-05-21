package com.example.demo.message;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

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
        //发送带有附加属性的消息,链式编程
        Map<String, Object> map = new HashMap<>();
        map.put("my1", "111");
        map.put("my2", "222");
        AMQP.BasicProperties build = new AMQP.BasicProperties().builder()
                .deliveryMode(2)//是否持久化
                .contentEncoding("UTF-8")//字符集格式
                .expiration("10000")//过期时间10s
                .headers(map)//自定义消息
                .build();
        //通过channel 发送数据
        for(int i=0;i<=5;i++){
            String msg="hello mq";
            channel.basicPublish("", "test001", build,msg.getBytes());
        }
        //关闭连接
        channel.close();
        connection.close();

    }
}
