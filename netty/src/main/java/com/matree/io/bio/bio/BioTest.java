package com.matree.io.bio.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @author wy
 * @data 2020-06-19 1:02
 */
public class BioTest {

    private static BlockingQueue<Runnable> executeQueue = new ArrayBlockingQueue<>(20);

    public static void main(String[] args) throws IOException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4,
                0, TimeUnit.SECONDS, executeQueue, Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("server start :" + Thread.currentThread().getName());
        while (true) {
            System.out.println("wait connect");
            Socket accept = serverSocket.accept();
            System.out.println("connect client " + accept.getPort() + " " + accept.getLocalPort());
            threadPoolExecutor.execute(() -> {
                handler(accept);
            });
        }
    }

    public static void handler(Socket socket) {

        try {
            byte[] bytes = new byte[1024];
            // get inputStream
            InputStream inputStream = socket.getInputStream();
            while (true) {
                System.out.print("thread info id = " + Thread.currentThread().getId() +
                        " name = " + Thread.currentThread().getName() + "  :");
                System.out.println("wait data");
                int read = inputStream.read(bytes);
                if (read == -1) break;
                System.out.print(Thread.currentThread().getName() + "  :");
                System.out.println(new String(bytes, 0, bytes.length));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("close client connect");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
