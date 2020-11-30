package com.srpingboot.jedis.controller;

import com.srpingboot.jedis.util.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:JedisController
 * Package:com.srpingboot.jedis.controller
 * Description:
 *
 * @date:2020/11/30 15:27
 * @author:zh
 */
@RestController
public class JedisController {


    @Autowired
    private JedisUtil jedisUtil;

    @GetMapping("/jedis")
    public String redis(){
        Long incr = JedisUtil.incr("userCount", 1);
        String count = JedisUtil.get("userCount", 1);
        System.out.println(count);
        System.out.println(incr);
        return "ok";
    }

}
