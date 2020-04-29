package com.matree.chapter2;

/**
 * @author
 * @create 2020-04-26 11:47 PM
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Exception e) {
            System.out.println("stack length: " + oom.stackLength);
            throw e;
        }
    }
}