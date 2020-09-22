package com.example.recovery;

import com.example.recovery.controller.RecoveryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * ClassName:StartUp
 * Package:com.example.recovery
 * Description:
 *
 * @date:2020/8/13 10:57
 * @author:zh
 */
@Order(1)
@Component
public class StartUp implements CommandLineRunner {
    @Autowired
    private RecoveryController recoveryController;
    @Override
    public void run(String... args) throws Exception {
            recoveryController.recoverTest();
    }
}
