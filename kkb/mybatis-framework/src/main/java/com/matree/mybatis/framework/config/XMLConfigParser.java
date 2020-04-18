package com.matree.mybatis.framework.config;

import com.matree.mybatis.framework.config.Configuration;
import org.dom4j.Element;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author
 * @create 2020-04-18 1:21
 */
public class XMLConfigParser {

    /**
     *
     * @param element configuration
     * @return
     */
    public Configuration parseConfiguration(Element element) {
        // environments
        Element environments = element.element("environments");
        // mappers
        Element mappers = element.element("mappers");
        return null;
    }

    // environments 主要解析数据源
    public void paseEnvironments(Element element){
        //<environments default="dev">
        String defaultId = element.attributeValue("default");

        List elements = element.elements("environment");

        for (Object o : elements) {
            Element element1 = (Element) o;
            String id = element.attributeValue("id");
            // 如果和默认的环境匹配，才进行解析
            if (id != null && id.equals(defaultId)) {
                parseDataSource(element.element("dataSource"));
            }
        }

    }

    private void parseDataSource(Element element) {
        String type = element.attributeValue("type");
        if (type != null && type.equals("")) {
            type = "DBCP";
        }

        List property = element.elements("property");
        for (Object o : property) {
            Element propertyEle = (Element) o;
            String name = propertyEle.attributeValue("name");
            String value = propertyEle.attributeValue("value");
        }

        DataSource dataSource = null;
        if (type.equals("DBCP")) {
            new BasicDataSource();
        }
    }
}
