package com.matree.io.nio.zeroCopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @author wy
 * @data 2020-08-11 0:35
 */
public class NewIoClient {

    private static final int WIN_FILE_TRANS = 8 * 1024 * 1024;

    public static void main(String[] args) throws Exception {
        SocketChannel open = SocketChannel.open();
        open.connect(new InetSocketAddress("localhost", 7001));
        String fileName = "D:\\迅雷下载\\Java并发编程实战.pdf";

        FileChannel fileChannel = new FileInputStream(fileName).getChannel();

        long start = System.currentTimeMillis();

        // linux 下一个transferTo 方法可以完成传输
        // windows 下一个transferTo 只能发送8M，需要分段传输
        System.out.println(fileChannel.size());
        long size = fileChannel.size();
        long i = size / WIN_FILE_TRANS;
        long pos = 0;
        while (i >= 0) {
            i --;
            // transferTo 零拷贝
            long transferCount = fileChannel.transferTo(pos, pos + WIN_FILE_TRANS, open);
            pos += transferCount;
            System.out.println("send byte count = " + pos + ", time = " +
                    (System.currentTimeMillis() - start));
        }
    }
}
