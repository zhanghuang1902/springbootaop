package com.example.springboot.common;

import com.example.springboot.bean.User;
import com.example.springboot.bean.UserMessage;
import com.example.springboot.service.UserService;
import com.example.springboot.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

/**
 * ClassName:MyServletContextListener
 * Package:com.example.springboot.common
 * Description:
 *监听Servlet上下文对象
 * @date:2020/2/23 18:34
 * @author:zh
 */
@Component
public class MyServletContextListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // 先获取到application上下文
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        // 获取对应的service
        UserServiceImpl userService = applicationContext.getBean(UserServiceImpl.class);
        UserMessage message = userService.queryUserMessage(1);
        // 获取application域对象，将查到的信息放到application域中
        ServletContext application = applicationContext.getBean(ServletContext.class);
        application.setAttribute("user", message);
    }
}
