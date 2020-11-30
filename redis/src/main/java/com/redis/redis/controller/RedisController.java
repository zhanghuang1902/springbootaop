package com.redis.redis.controller;

import com.redis.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:RedisController
 * Package:com.redis.redis.controller
 * Description:
 *
 * @date:2020/11/30 11:12
 * @author:zh
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/redis")
    public String redis(){
        redisUtil.expire("zhanghuang", 10);
        return "ok";
    }
}
