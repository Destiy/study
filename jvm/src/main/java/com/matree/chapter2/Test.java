package com.matree.chapter2;

/**
 * 不同线程之间也不能直接访问对方工作内存中的变量，线程间变量的值的传递需要通过主内存中转来完成。
 *
 * 解决办法：
 * 1. synchronized
 *          因为某一个线程进入synchronized代码块前后，线程会获得锁，清空工作内存，从主内存拷贝共享变量最新的值到工作内存成为副本，执行代码，将修改后的副本的值刷新回主内存中，线程释放锁。
 *          而获取不到锁的线程会阻塞等待，所以变量的值肯定一直都是最新的。
 * 2. volatile
 *
 * @author wy
 * @date 2020-04-28 8:14 PM
 */
public class Test {

    public static void main(String[] args) {
        Carie a = new Carie();
        a.start();
        while (true) {
            synchronized (a) {
                if (a.isFlag()) {
                    System.out.println("......");
                }
            }
        }
    }

}

class Carie extends Thread {
    private volatile boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag = " + flag);
    }
}
