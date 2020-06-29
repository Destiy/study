package com.matree.juc;

/**
 * 别人插队到你前面，必须等他完事后才轮到你。
 * TODO join方法可以让某个线程插到自己前面，等它执行完，自己才会继续执行
 *
 * @author wy
 * @data 2020-05-10 3:18 PM
 */
public class QueueJump {
    static void jqByJoin() {
        try {
            CRunnable cr = new CRunnable();
            Thread t = new Thread(cr);
            t.start();
            Thread.sleep(1000);
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("终于轮到我了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class CRunnable implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("进入不可暂停区域 1。。。");
                Thread.sleep(5000);
                System.out.println("退出不可暂停区域 1。。。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        jqByJoin();
    }
}
