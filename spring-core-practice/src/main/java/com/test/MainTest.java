package com.test;

import com.test.service.PetStoreService;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author wy
 * @date 2021/07/06
 */
public class MainTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Service.xml");

        PetStoreService petStore = context.getBean("petStore", PetStoreService.class);

        petStore.printTest();
        petStore.printDao();
    }
}
