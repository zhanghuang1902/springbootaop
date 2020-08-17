package com.example.recovery.controller;

import com.example.recovery.service.RecoveryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:RecoveryController
 * Package:com.example.recovery.controller
 * Description:
 *
 * @date:2020/8/13 10:51
 * @author:zh
 */
@RestController
@RequestMapping("/recover")
@Slf4j
public class RecoveryController {

    @Autowired
    private RecoveryService recoveryService;
    @PostMapping("/recover")
    public String recovery(){
        recoveryService.recovery();
        return "success";
    }
}
