package com.springboot.mybatis.controller;

import com.springboot.mybatis.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Soundbank;

/**
 * ClassName:MybatisController
 * Package:com.springboot.mybatis.controller
 * Description:
 *
 * @date:2020/11/26 16:04
 * @author:zh
 */
@RestController
public class MybatisController {

    @Autowired
    private MybatisService mybatisService;

    @GetMapping("/test")
    public void test1(){
        String id=mybatisService.queryId();
        System.out.println(id);
    }

}
