package com.matree.netty.inandoutstack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 对数据进行编码操作
 *
 * @author wy
 * @data 2020-09-26 16:20
 */
public class MyLongToByteEncoder extends MessageToByteEncoder<Long> {
    /**
     * 编码方法
     *
     * @param ctx
     * @param msg
     * @param out
     * @throws Exception
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
        System.out.println("---Encoder MyLongToByteEncoder");
        System.out.println("msg = " + msg);
        out.writeLong(msg);
    }
}
