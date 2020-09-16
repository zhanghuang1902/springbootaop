package com.websocket.wrbsocket.controller;

import com.websocket.wrbsocket.config.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * ClassName:TestController
 * Package:com.websocket.wrbsocket.controller
 * Description:
 *
 * @date:2020/9/16 11:53
 * @author:zh
 */
@RestController
@RequestMapping("/testMethod")
public class TestController {

    @Autowired
    WebSocket webSocket;


    @ResponseBody
    @GetMapping("/sendTo")
    public String sendTo(@RequestParam("userId") String userId,@RequestParam("msg") String msg) throws IOException {

        webSocket.sendMessageTo(msg,userId);

        return "推送成功";
    }

    @GetMapping("/sendAll")
    public String sendAll(@RequestParam("msg") String msg) throws IOException {

        String fromUserId="system";//其实没用上
        webSocket.sendMessageAll(msg,fromUserId);

        return "推送成功";
    }
}
