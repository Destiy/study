package com.matree.io.bio.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * MappedByteBuffer 可以让文件直接在内存（堆外内存）修改，操作系统不需要拷贝一次
 *
 * @author wy
 * @date 2020-08-07 15:45
 */
public class MappedByteBufferTest {

    public static void main(String[] args) throws Exception {

        RandomAccessFile randomAccessFile = new RandomAccessFile("E:\\test\\0708.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();


        /**
         * 参数1：FileChannel.MapMode.READ_WRITE： 读写模式
         * 参数2： 0：  起始位置
         * 参数3： 5：  映射到内存的大小，可以修改的范围就是0-5
         *
         * 实际类型 DirectByteBuffer
         */
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        map.put(0, (byte) 'w');
        map.put(1, (byte) 'y');

        randomAccessFile.close();
        System.out.println("modify final");
    }
}
