package com.example.springboot.service;

import com.example.springboot.bean.User;
import com.example.springboot.bean.UserMessage;
import com.example.springboot.common.MyEvent;
import com.example.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * ClassName:UserServiceImpl
 * Package:com.example.springboot.service
 * Description:
 *
 * @date:2020/2/23 16:49
 * @author:zh
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public UserMessage queryUserMessage(int id) {
        return userMapper.queryUserMessage(id);
    }

    public User getUser() {
        // 实际中会根据具体的业务场景，从数据库中查询对应的信息
        return new User(1L, "倪升武", "123456");
    }

    /**
     * 发布事件
     * @return
     */
    public User getUser2() {
        User user = new User(1L, "倪升武", "123456");
        // 发布事件
        MyEvent event = new MyEvent(this, user);
        applicationContext.publishEvent(event);
        return user;
    }
}
