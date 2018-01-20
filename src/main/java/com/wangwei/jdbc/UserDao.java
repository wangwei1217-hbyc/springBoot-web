package com.wangwei.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.FileNotFoundException;

/**
 * Created by wangwei on 2018/1/18.
 */
@Repository
public class UserDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public void add(String name){
        String sql = "insert into t_user(name) values(?)";
        jdbcTemplate.update(sql,name);
    }

    /**
     *rollbackFor--指定哪些异常会回滚
     */
    @Transactional(rollbackFor = {Exception.class})
    public void add2(String name) throws Exception{
        String sql = "insert into t_user(name) values(?)";
        jdbcTemplate.update(sql,name);
        throw new FileNotFoundException();
    }

    @Transactional
    public void add3(String name) throws Exception{
        String sql = "insert into t_user(name) values(?)";
        jdbcTemplate.update(sql,name);
        throw new RuntimeException();
    }
    /**
     * noRollbackFor--指定针对哪些异常不进行回滚
     */
    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    public void add4(String name) throws Exception{
        String sql = "insert into t_user(name) values(?)";
        jdbcTemplate.update(sql,name);
        throw new IllegalArgumentException();
    }

    public void addUser(String name) throws Exception{
        add3(name);
    }
}
