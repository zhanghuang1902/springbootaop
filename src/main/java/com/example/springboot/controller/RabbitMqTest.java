package com.example.springboot.controller;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:RabbitMqTest
 * Package:com.example.springboot.controller
 * Description:
 *
 * @date:2020/5/19 14:02
 * @author:zh
 */
public class RabbitMqTest {

    @Autowired
    private ConnectionFactory factory;

    @RequestMapping("/mq")
    public void mq() {

    }
}
