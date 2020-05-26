package com.example.demo.returnListener;

import com.rabbitmq.client.*;

import java.io.IOException;

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
        String exchange="test_return_exchange";
        //指定routing key
        String routingKey="return.save";
        String routingErrKey="abc.save";
        //发生消息
        channel.basicPublish(exchange, routingErrKey, false, null, "hello ,world".getBytes());
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
        channel.addReturnListener(new ReturnListener() {
            @Override
            public void handleReturn(int replyCode, String replyText, String exchange, String routingKey, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.err.println("handleReturn....");
                System.err.println("replyCode...."+replyCode);
                System.err.println("replyText...."+replyText);
                System.err.println("exchange...."+exchange);
                System.err.println("properties...."+properties);
                System.err.println("body...."+new String(body));
            }
        });
//        //关闭连接
//        channel.close();
//        connection.close();

    }
}
