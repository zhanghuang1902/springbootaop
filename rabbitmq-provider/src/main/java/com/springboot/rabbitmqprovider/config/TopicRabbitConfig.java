package com.springboot.rabbitmqprovider.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:TopicRabbitConfig
 * Package:com.springboot.rabbitmqprovider.config
 * Description:
 *
 * @date:2020/12/9 16:56
 * @author:zh
 * 主题交换机配置
 */
@Configuration
public class TopicRabbitConfig {

    private static final String man = "topic.man";

    public static final  String woman = "topic.woman";

    /**
     * 声明一个队列TestTopicQueueOne
     * @return
     */
    @Bean
    public Queue testDirectQueueOne(){
        return new Queue("TestTopicQueueOne",true);
    }

    /**
     * 声明一个队列TestTopicQueueTwo
     * @return
     */
    @Bean
    public Queue testDirectQueueTwo(){
        return new Queue("TestTopicQueueTwo",true);
    }

    /**
     * 声明一个队列TestTopicQueueTwo
     * @return
     */
    @Bean
    public Queue testDirectQueueThree(){
        return new Queue("TestTopicQueueThree",true);
    }

    /**
     * 声明一个直连交换机
     */
    @Bean
    public TopicExchange testTopicExchange(){
        return new TopicExchange("TestTopicExchange",true,false);
    }

    /**
     * 绑定 将交换机和队列绑定
     */
    @Bean
    public Binding bindingDirectOne(){
        return BindingBuilder.bind(testDirectQueueOne()).to(testTopicExchange()).with("TopicRouting.man");
    }

    /**
     * 绑定 将交换机和队列绑定
     */
    @Bean
    public Binding bindingDirectTwo(){
        return BindingBuilder.bind(testDirectQueueTwo()).to(testTopicExchange()).with("TopicRouting.#");
    }

    /**
     * 绑定 将交换机和队列绑定
     */
    @Bean
    public Binding bindingDirectThree(){
        return BindingBuilder.bind(testDirectQueueThree()).to(testTopicExchange()).with("TopicRouting.*");
    }


}
