package com.example.springboot.service;

import com.example.springboot.bean.User;
import com.example.springboot.bean.UserMessage;

/**
 * ClassName:UserService
 * Package:com.example.springboot.service
 * Description:
 *
 * @date:2020/2/23 16:48
 * @author:zh
 */
public interface UserService {
    UserMessage queryUserMessage(int id);
}
