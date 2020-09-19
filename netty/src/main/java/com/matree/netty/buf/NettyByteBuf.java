package com.matree.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

public class NettyByteBuf {

    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.copiedBuffer("hello,world!", CharsetUtil.UTF_8);

        if (byteBuf.hasArray()) {
            byte[] content = byteBuf.array();
            System.out.println(new String(content, CharsetUtil.UTF_8));

            System.out.println("byteBuf = " + byteBuf);

            // 0
            System.out.println(byteBuf.arrayOffset());
            // 0
            System.out.println(byteBuf.readerIndex());
            System.out.println(byteBuf.capacity());

            // 0 TODO 会改变`readerIndex` 值
            System.out.println(byteBuf.readByte());
            // 104
            System.out.println(byteBuf.getByte(0));

            System.out.println("lens = " + byteBuf.readableBytes());

//            for (int i = 0 ; i < byteBuf.readableBytes(); i++) {
//                System.out.println((char)byteBuf.getByte(i));
//            }
            System.out.println(byteBuf.getCharSequence(0, 5, CharsetUtil.UTF_8));
        }
    }
}
