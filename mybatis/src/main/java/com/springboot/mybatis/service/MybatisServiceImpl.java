package com.springboot.mybatis.service;

import com.springboot.mybatis.dao.MybatisMapper;
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
    @Override
    public String queryId() {
        return mapper.queryId();
    }
}
