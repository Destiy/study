package com.matree.mybatis.framework.sqlsession;

import com.matree.mybatis.framework.config.Configuration;
import com.matree.mybatis.framework.config.XMLConfigParser;
import org.dom4j.Document;

import java.io.InputStream;
import java.io.Reader;

/**
 * @author
 * @create 2020-04-18 0:55
 */
public class SqlSessionFacoryBuilder {

    private Configuration configuration;

    public SqlSessionFactory build(InputStream inputStream) {
        // 解析全局配置文件，封装configuration 对象
        Document document = DocumentReader.createDecument(inputStream);
        XMLConfigParser xmlConfigParser = new XMLConfigParser();
        Configuration configuration = xmlConfigParser.parseConfiguration(document.getRootElement());
        return build();
    }

    public SqlSessionFactory build(Reader reader) {
        return build();
    }

    private SqlSessionFactory build() {
        return new DefaultSqlSessionFactory();
    }
}
