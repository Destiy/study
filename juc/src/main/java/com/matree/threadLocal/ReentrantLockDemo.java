package com.matree.threadLocal;

import javafx.concurrent.Worker;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wy
 * @date 2020-07-22 10:10
 */
public class ReentrantLockDemo {
    private static ThreadPoolExecutor tpe = new ThreadPoolExecutor(2, 5,
            1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(20), new ThreadPoolExecutor.AbortPolicy());
    static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        Condition condition = lock.newCondition();
        try {
            tpe.execute(() -> {
                lock.lock();
                try {
                    System.out.println("线程一加锁成功");
                    System.out.println("线程一执行await被挂起");
                    condition.await();
                    System.out.println("线程一被唤醒成功");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    System.out.println("线程一释放锁成功");
                }
            });


            tpe.execute(() -> {
                lock.lock();
                try {
                    System.out.println("线程二加锁成功");
                    condition.signal();
                    System.out.println("线程二唤醒线程一");
                } finally {
                    lock.unlock();
                    System.out.println("线程二释放锁成功");
                }
            });
        } finally {
            tpe.shutdown();
        }
//        new Thread(() -> {
//            lock.lock();
//            try {
//                System.out.println("线程一加锁成功");
//                System.out.println("线程一执行await被挂起");
//                condition.await();
//                System.out.println("线程一被唤醒成功");
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock();
//                System.out.println("线程一释放锁成功");
//            }
//        }).start();
//        new Thread(() -> {
//            lock.lock();
//            try {
//                System.out.println("线程二加锁成功");
//                condition.signal();
//                System.out.println("线程二唤醒线程一");
//            } finally {
//                lock.unlock();
//                System.out.println("线程二释放锁成功");
//            }
//        }).start();
    }
}
