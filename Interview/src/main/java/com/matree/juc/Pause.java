package com.matree.juc;

/**
 * 在地点检测flag。然后就是wait/notify配合使用。
 *
 * TODO 要点：把停止的信号传达给别人，别人处理完手头的事情就自己主动停止了。
 * @author wy
 * @data 2020-05-10 2:46 PM
 */
public class Pause {

    static void pauseByFlag() throws InterruptedException {
        bRunnable br = new bRunnable();
        new Thread(br).start();
        br.tellToPause();
        Thread.sleep(8000);
        br.tellToResume();
    }

    static class bRunnable implements Runnable {

        volatile boolean pause;

        void tellToPause() {
            pause = true;
        }

        void tellToResume() {
            synchronized (this) {
                this.notify();
            }
        }
        @Override
        public void run() {
            try {
                System.out.println("进入不可暂停区域 1。。。");
                Thread.sleep(5000);
                System.out.println("退出不可暂停区域 1。。。");
                System.out.println("检测标志pause = %s"+ String.valueOf(pause));
                if (pause) {
                    System.out.println("暂停执行");
                    try {
                        synchronized (this) {
                            this.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("恢复执行");
                }
                System.out.println("进入不可暂停区域 2。。。");
//            doingLongTime(5);
                Thread.sleep(5000);
                System.out.println("退出不可暂停区域 2。。。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        pauseByFlag();
    }
}
