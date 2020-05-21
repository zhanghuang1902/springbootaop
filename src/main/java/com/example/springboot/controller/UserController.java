package com.example.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.example.springboot.bean.UserMessage;
import com.example.springboot.service.UserService;
import com.example.springboot.service.UserServiceImpl;
import com.example.springboot.until.JedisUtil;
import com.example.springboot.until.RedisUntil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * ClassName:UserController
 * Package:com.example.springboot.controller
 * Description:
 *
 * @date:2020/2/23 16:48
 * @author:zh
 */
@RestController
@RequestMapping("/User")
public class UserController {

    private final Logger logger=LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private RedisUntil redisUntil;

    @Autowired
    private JedisUtil jedisUtil;

    @RequestMapping("/UserMessage")
    public UserMessage UserMessage(@RequestParam int id){
        UserMessage message = userService.queryUserMessage(id);
        redisUntil.setString("redis", "测试成功");
        logger.info("我的redis测试结果为：{}", redisUntil.getString("redis"));
        redisUntil.setString("user", JSON.toJSONString(message));
        logger.info("我的redis用户信息:{}",redisUntil.getString("user"));
        jedisUtil.setex("时间测试", 10, "是否消失");
       jedisUtil.setHashKey("user", "张煌",  5);
       String hash = jedisUtil.getHashKey("user", 5);
        logger.info(hash);
        return message;
    }

    @GetMapping("/user")
    public UserMessage getUser(HttpServletRequest request) {
        ServletContext application = request.getServletContext();
        return (UserMessage) application.getAttribute("user");
    }

    /**
     * 获取当前在线人数，该方法有bug
     * @param request
     * @return
     */
    @GetMapping("/total")
    public String getTotalUser(HttpServletRequest request) {
        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return "当前在线人数：" + count;
    }

    @GetMapping("/total2")
    public String getTotalUser(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie;
        try {
            // 把sessionId记录在浏览器中
            cookie = new Cookie("JSESSIONID", URLEncoder.encode(request.getSession().getId(), "utf-8"));
            cookie.setPath("/");
            //设置cookie有效期为2天，设置长一点
            cookie.setMaxAge( 48*60 * 60);
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return "当前在线人数：" + count;
    }

    @GetMapping("/request")
    public String getRequestInfo(HttpServletRequest request) {
        System.out.println("requestListener中的初始化的name数据：" + request.getAttribute("name"));
        return "success";
    }


    @GetMapping("/publish")
    public String getPublish() {
        userServiceImpl.getUser2();
        return "SUCCESS";
    }

}
