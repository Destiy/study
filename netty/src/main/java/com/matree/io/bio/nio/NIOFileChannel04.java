package com.matree.io.bio.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

/**
 * @author wy
 * @date 2020-08-06 17:51
 */
public class NIOFileChannel04 {

    /**
     * 通过通道 传输file
     * @param args
     */
    public static void main(String[] args) throws Exception {

        FileInputStream fileInputStream = new FileInputStream("E:\\test\\课程内容\\uploads\\0.mp3");
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\test\\课程内容\\uploads\\out.mp3");

        FileChannel input = fileInputStream.getChannel();
        FileChannel output = fileOutputStream.getChannel();

        input.transferTo(0, input.size(), output);

        fileInputStream.close();
        fileOutputStream.close();
    }
}
