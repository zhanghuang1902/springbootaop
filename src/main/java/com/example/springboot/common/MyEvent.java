package com.example.springboot.common;

import com.example.springboot.bean.User;
import org.springframework.context.ApplicationEvent;

/**
 * ClassName:MyEvent
 * Package:com.example.springboot.common
 * Description:
 *
 * @date:2020/2/23 21:52
 * @author:zh
 */
public class MyEvent extends ApplicationEvent {
    private User user;

    public MyEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
