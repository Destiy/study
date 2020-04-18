package com.matree.mybatis.dao;

import com.matree.mybatis.framework.sqlsession.SqlSession;
import com.matree.mybatis.framework.sqlsession.SqlSessionFactory;
import com.matree.mybatis.po.User;

/**
 * @author
 * @create 2020-04-18 0:40
 */
public class UserDaoImpl  implements UserDao {

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User queryUserById(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String statementId = "test.findUserById";
        User user = sqlSession.selectOone(statementId, id);
        return user;
    }

    @Override
    public void insertUser() {

    }
}
