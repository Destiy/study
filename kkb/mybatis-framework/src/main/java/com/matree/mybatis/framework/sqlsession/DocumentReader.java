package com.matree.mybatis.framework.sqlsession;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

/**
 * @author
 * @create 2020-04-18 1:16
 */
public class DocumentReader {

    public static Document createDecument(InputStream inputStream) {
        Document document = null;
        try {
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(inputStream);
            return document;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }
}
