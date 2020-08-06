package com.matree.io.bio.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 1. 每个Channel 对应一个Buffer
 * 2. 一个Selector 对应一个线程，一个线程对应多个Channel(链接)
 * 3. 程序切换到哪个Channel 是由事件（Event）决定的，Event 就是一个重要的概念
 * 4. Selector 会根据不同的时间，在各个通道（Channel）之间切换
 * 5. Buffer 就是一个内存卡,底层是有一个数组
 * 6. 数据的读取/写入是通过Buffer，这个和BIO 有本质不同，BIO 中要么是输入流或者是输出流,不能双向，
 *    但是NIO 的Buffer 是可以读写，需要flip 方法切换
 * 7. Channel 是双向的，可以返回底层操作系统的情况，比如Linux，底层的操作系统通道就是双向的
 * @author wy
 * @date 2020-08-05 17:22
 */
public class NioTest {

    /** 使用一个buffer 实现文件读写*/
    public static void main(String[] args) throws Exception {

        // 创建相关文件流
        FileInputStream fileInputStream = new FileInputStream("E:\\test\\0708.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\test\\out.txt");

        // 获取通道
        FileChannel input = fileInputStream.getChannel();
        FileChannel output = fileOutputStream.getChannel();

        // 创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while(true) {
            int read = input.read(byteBuffer);
            if (read == -1) {
                break;
            }
            byteBuffer.flip();
            output.write(byteBuffer);
            byteBuffer.clear();
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
