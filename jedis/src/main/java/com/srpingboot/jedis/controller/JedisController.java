package com.srpingboot.jedis.controller;

import com.srpingboot.jedis.util.JedisUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/jedis")
    public String redis(){
//        JedisUtil.lpush(3, "lsit", "山西","北京","上海");
        String list = JedisUtil.get("lsit", 3);
        List<String> list1 = JedisUtil.lrange("lsit", 0, -1, 3);
        String lsit = JedisUtil.rpop("lsit", 3);
        System.out.println(list1.toString());
        System.out.println(lsit);
        List<String> list2 = JedisUtil.lrange("lsit", 0, -1, 3);
        if(list2.isEmpty()){
            return "队列为空";
        }
        System.out.println(list2.toString());
        System.out.println(list);
        return "ok";
    }

}
