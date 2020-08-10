package com.matree.io.nio;

import com.sun.javafx.image.impl.BaseByteToIntConverter;

import java.nio.ByteBuffer;

/**
 * 只读buffer
 *
 * @author wy
 * @date 2020-08-07 12:00
 */
public class ReadOnlyBuffer {

    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocate(64);

        for (int i = 0; i < 5; i++) {
            buffer.put((byte) i);
        }

        ByteBuffer byteBuffer = buffer.asReadOnlyBuffer();
        System.out.println(byteBuffer.getClass());
    }
}
