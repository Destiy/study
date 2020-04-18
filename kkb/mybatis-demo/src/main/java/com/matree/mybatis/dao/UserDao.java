package com.matree.mybatis.dao;

import com.matree.mybatis.po.User;

/**
 * @author
 * @create 2020-04-18 0:40
 */
public interface UserDao {

    public void insertUser();

    public User queryUserById(Integer id);
}
