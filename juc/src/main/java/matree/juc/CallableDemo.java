package matree.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        System.out.println("call exec success");
        Thread.sleep(4000);
        return 1024;
    }
}

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());

        Thread thread = new Thread(futureTask);
        Thread thread1 = new Thread(futureTask);
        thread.start();
        thread1.start();

        System.out.println("main complete");
        System.out.println(futureTask.get());
    }
}
