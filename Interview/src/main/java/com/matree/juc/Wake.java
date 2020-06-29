package com.matree.juc;

/**
 * 要把别人从睡梦中叫醒，一定要采取稍微暴力一点的手段。
 * TODO 线程在sleep或wait时，是处于无法交互的状态的，此时只能使用interrupt方法中断它，线程会被激活并收到中断异常
 *
 * @author wy
 * @data 2020-05-10 3:21 PM
 */
public class Wake {


    static void stopByInterrupt() {
        try {
            DRunnable dr = new DRunnable();
            Thread t = new Thread(dr);
            t.start();
            Thread.sleep(2000);
            t.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class DRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("进入暂停。。。");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("收到中断异常。。。");
                System.out.println("做一些相关处理。。。");
            }
            System.out.println("继续执行或选择退出。。。");
        }
    }

    public static void main(String[] args) {
        stopByInterrupt();
    }
}
