package matree.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket {

    private Integer number = 30;

    private Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() +
                        " sale ticket = " + number-- + " 还剩:" + number);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private int calc = 0;
    private Condition condition = lock.newCondition();

    /**
     * 使用 lock 上锁，condition 等待唤醒
     * 来进行 生产者-消费者
     */
    public void increment() {

        lock.lock();
        try {
            while (calc != 0) {
                condition.await();
            }
            calc++;
            System.out.println(Thread.currentThread().getName() + "\t" + calc);
            condition.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void reduce() {

        lock.lock();
        try {
            while (calc == 0) {
                condition.await();
            }
            calc--;
            System.out.println(Thread.currentThread().getName() + "\t" + calc);
            condition.notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

public class SaleDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(3, 3, 100, TimeUnit.SECONDS
                , new ArrayBlockingQueue<Runnable>(3), new ThreadPoolExecutor.DiscardOldestPolicy());

        Ticket ticket = new Ticket();
        for (int i = 0; i < 3; i++) {
            tpe.execute(() -> {
                for (int j = 0 ; j<30; j++) {
                    ticket.sale();
                }
            });
        }
    }
}
