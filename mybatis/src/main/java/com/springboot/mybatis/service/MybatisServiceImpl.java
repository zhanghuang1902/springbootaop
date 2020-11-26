package com.springboot.mybatis.service;

import com.springboot.mybatis.mapper.one.MybatisMapper;
import com.springboot.mybatis.mapper.one.TestUserOneMapper;
import com.springboot.mybatis.mapper.two.TestUserTwoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:MybatisServiceImpl
 * Package:com.springboot.mybatis.service
 * Description:
 *
 * @date:2020/11/26 16:05
 * @author:zh
 */
@Service
public class MybatisServiceImpl implements MybatisService {

    @Autowired
    private MybatisMapper mapper;
    @Autowired
    private TestUserOneMapper testUserOneMapper;
    @Autowired
    private TestUserTwoMapper testUserTwoMapper;
    @Override
    public String queryId() {
        String id1=testUserOneMapper.queryId();
        String id2=testUserTwoMapper.queryId();
        System.out.println(id1);
        System.out.println(id2);
        return mapper.queryId();
    }
}
