package com.example.springboot.controller;

import com.example.springboot.common.BusinessErrorException;
import com.example.springboot.common.BusinessMsgEnum;
import com.example.springboot.common.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName:ExceptionController
 * Package:com.example.springboot.controller
 * Description:
 *
 * @date:2020/2/23 13:35
 * @author:zh
 */
@RestController
@RequestMapping("/exception")
public class ExceptionController {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @PostMapping("/test")
    public JsonResult test(@RequestParam("name") String name,
                           @RequestParam("pass") String pass) {
        logger.info("name：{}", name);
        logger.info("pass：{}", pass);
        return new JsonResult();
    }

    @GetMapping("/business")
    public JsonResult testException() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new BusinessErrorException(BusinessMsgEnum.PARMETER_BIG_EXCEPTION);
        }
        return new JsonResult();
    }
}
