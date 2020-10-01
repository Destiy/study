package com.matree.io.nio.zeroCopy;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;

/**
 * @author wy
 * @data 2020-08-11 0:01
 */
public class OldIoClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 7000);

        String fileName = "D:\\迅雷下载\\Java并发编程实战.pdf";
        FileInputStream fileInputStream = new FileInputStream(fileName);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] buffer = new byte[4096];
        long readCount, total =  0;
        long start = System.currentTimeMillis();

        while((readCount = fileInputStream.read(buffer)) >= 0) {
            total += readCount;
            dataOutputStream.write(buffer);
        }
        System.out.println("send Byte Count = " + total + ", time = " +
                (System.currentTimeMillis() - start));
        dataOutputStream.close();
        socket.close();
        fileInputStream.close();
    }
}
