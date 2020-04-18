package com.matree.mybatis.test;

import com.matree.mybatis.dao.UserDao;
import com.matree.mybatis.dao.UserDaoImpl;
import com.matree.mybatis.framework.sqlsession.SqlSessionFacoryBuilder;
import com.matree.mybatis.framework.sqlsession.SqlSessionFactory;
import com.matree.mybatis.po.User;
import org.junit.Before;

import java.io.InputStream;

/**
 * @author
 * @create 2020-04-18 0:40
 */
public class UserDaoTest {

    // sqlSessionFactory 加载依赖于全局配置文件的加载方式
    // 所以说我们需要定制需要哪一种加载方式去常见sqlSessionFactory
    private SqlSessionFactory sqlSessionFactory;

    // 创建sqlSessionFactory
    @Before
    public void init() {
        // 指定类路径下的全局配置文件，通过类加载器去加载
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFacoryBuilder().build(inputStream);
    }
    public void testQueryUserById() {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.queryUserById(1);
        System.out.println(user);
    }
}
