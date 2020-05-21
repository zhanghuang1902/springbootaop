package com.example.springboot.mapper;

import com.example.springboot.bean.User;
import com.example.springboot.bean.UserMessage;

/**
 * ClassName:UserMapper
 * Package:com.example.springboot.mapper
 * Description:
 *
 * @date:2020/2/23 16:45
 * @author:zh
 */
public interface UserMapper {
    UserMessage queryUserMessage(int id);
}
