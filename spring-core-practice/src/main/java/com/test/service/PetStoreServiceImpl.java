package com.test.service;

import com.test.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sound.midi.Soundbank;

/**
 * @author wy
 * @date 2021/07/06
 */
//@Component
public class PetStoreServiceImpl implements PetStoreService {

//    @Autowired
    AccountDao accountDao;

//    public PetStoreServiceImpl(AccountDao accountDao) {
//        this.accountDao = accountDao;
//    }


    @Override
    public void printTest() {
        System.out.println("xmlApplication test...");
    }

    @Override
    public void printDao() {
        System.out.println(accountDao.testXml());
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
