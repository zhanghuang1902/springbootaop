package com.springboot.aop.controller;

import com.springboot.aop.bean.InputBean;
import com.springboot.aop.bean.OutPutBean;
import com.springboot.aop.service.AopTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:AopController
 * Package:com.springboot.aop.controller
 * Description:
 *
 * @date:2020/8/26 16:46
 * @author:zh
 */
@RestController
@RequestMapping("/aop")
public class AopController {

    @Autowired
    private AopTestService aopService;

    @PostMapping("/test")
    public OutPutBean aopController(@RequestBody InputBean bean){
        OutPutBean out=aopService.result(bean);
        return out;
    }
}
