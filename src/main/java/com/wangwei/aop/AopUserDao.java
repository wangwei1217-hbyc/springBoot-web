package com.wangwei.aop;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by wangwei on 2018/1/27.
 */
@Repository
public class AopUserDao implements IAopUserDao{
    @Resource
    private JdbcTemplate jdbcTemplate;

    public void addUser(String name){
        String sql = "insert into t_user(name) values(?)";
        jdbcTemplate.update(sql,name);
    }
}
