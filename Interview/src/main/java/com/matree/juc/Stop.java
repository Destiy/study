package com.matree.juc;

/**
 * 把停止的信号传达给别人，别人处理完手头的事情就自己主动停止了
 * TODO 线程在预设的地点检测flag，来决定是否停止。
 *
 * @author wy
 * @dataa 2020-05-10 3:11 PM
 */
public class Stop {
    static void stopByFlag() {
        ARunnable ar = new ARunnable();
        new Thread(ar).start();
        ar.tellToStop();
    }

    static class ARunnable implements Runnable {

        volatile boolean stop;

        void tellToStop() {
            stop = true;
        }

        @Override
        public void run() {
            try {
                System.out.println("进入不可停止区域 1。。。");
//            doingLongTime(5);
                Thread.sleep(5000);
                System.out.println("退出不可停止区域 1。。。");
                System.out.println("检测标志stop = %s" + String.valueOf(stop));
                if (stop) {
                    System.out.println("停止执行");
                    return;
                }
                System.out.println("进入不可停止区域 2。。。");
//            doingLongTime(5);
                Thread.sleep(5000);
                System.out.println("退出不可停止区域 2。。。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        stopByFlag();
    }
}
