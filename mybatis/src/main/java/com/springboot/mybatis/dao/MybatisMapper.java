package com.springboot.mybatis.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName:MybatisMapper
 * Package:com.springboot.mybatis.dao
 * Description:
 *
 * @date:2020/11/26 16:04
 * @author:zh
 */
@Mapper
public interface MybatisMapper {

    String queryId();
}
