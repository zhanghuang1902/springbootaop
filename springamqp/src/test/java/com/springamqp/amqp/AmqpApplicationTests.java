package com.springamqp.amqp;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AmqpApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private RabbitAdmin rabbitAdmin;

    @Test
    public  void  rabbitAdmin() throws Exception{
        //声明三种模式交换机
        rabbitAdmin.declareExchange(new DirectExchange("test.direct", false, false));
        rabbitAdmin.declareExchange(new TopicExchange("test.topic", false, false));
        rabbitAdmin.declareExchange(new FanoutExchange("test.fanout", false, false));
        //声明三种模式的队列
        rabbitAdmin.declareQueue(new Queue("test.direct.queue", false));
        rabbitAdmin.declareQueue(new Queue("test.topic.queue", false));
        rabbitAdmin.declareQueue(new Queue("test.fanout.queue", false));
        //绑定交换机和队列的方法
        //第一种:
        // 参数说明:
        // destination:队列
        // Binding.DestinationType.QUEUE 队列绑定说明
        // exchange: 交换机
        // routingKey : 路由Key
        // arguments: 指定一个空的new HashMap
        rabbitAdmin.declareBinding(new Binding("test.direct.queue",Binding.DestinationType.QUEUE,"test.direct","direct",new HashMap<>()));
        //第二种(可以直接声明交换机和队列,可舍去声明三种模式交换机和三种模式队列
        rabbitAdmin.declareBinding(
                BindingBuilder.bind(new Queue("test.topic.queue", false)) //直接创建队列
                .to(new TopicExchange("test.topic", false, false)) //直接创建交换机 建立关联关系
                .with("user.#")); //指定路由key
        //由于广播交换机无需指定路由key 所以with 可以省略掉
        rabbitAdmin.declareBinding(
                BindingBuilder.bind(new Queue("test.fanout.queue", false)) //直接创建队列
                        .to(new FanoutExchange("test.topic", false, false)));//直接创建交换机 建立关联关系

        //清空队列数据
        rabbitAdmin.purgeQueue("test.topic.queue", false);

    }

}
