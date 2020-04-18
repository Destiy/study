package com.matree.mybatis.framework.sqlsession;

import java.util.List;

/**
 * @author
 * @create 2020-04-18 0:30
 */
public interface SqlSession {

    <T> T selectOone(String statementId, Object param);

    <T> List<T> selectList(String statementId, Object param);
}
