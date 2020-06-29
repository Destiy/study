package com.matree.chapter2;


import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @create 2020-04-26 11:18 PM
 */
public class HeopOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
