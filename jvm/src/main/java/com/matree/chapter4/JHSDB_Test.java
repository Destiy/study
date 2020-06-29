package com.matree.chapter4;

/**
 * @author wy
 * @data 2020-06-20 18:16
 */
public class JHSDB_Test {

    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder objectHolder = new ObjectHolder();

        void foo() {
            String localStr = "";
            System.out.println("done");
        }
    }
    private static class ObjectHolder {}

    public static void main(String[] args) {
        Test test = new JHSDB_Test.Test();
        test.foo();
    }
}
