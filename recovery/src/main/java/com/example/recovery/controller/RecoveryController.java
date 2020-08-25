package com.example.recovery.controller;

import com.example.recovery.bean.TestBean;
import com.example.recovery.service.RecoveryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.PostVMInitHook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    public String recovery() {
        recoveryService.recovery();
        return "success";
    }

    public static void main(String[] args) {
        List<TestBean> list = new ArrayList<>();
        TestBean testBean1 = new TestBean();
        testBean1.setId("1");
        TestBean testBean2 = new TestBean();
        testBean2.setId("2");
        TestBean testBean3 = new TestBean();
        testBean3.setId("3");
        list.add(testBean2);
        list.add(testBean1);
        list.add(testBean3);
        List<TestBean> collect = list.stream().sorted(Comparator.comparing(TestBean::getId)).collect(Collectors.toList());
        collect.get(0).setId("5");
        System.out.println(collect);
        System.out.println(list);
    }
}
